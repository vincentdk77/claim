package com.sinosoft.claimzy.facade;
/**
 * 这是农险（中央政策性）的分户赔付信息的数据访问类
 */
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpClaimFarmerInfoZY {
	/**
	 * 资源管理类的实例，处理数据库操作
	 */
    private static Log logger = LogFactory.getLog(DBPrpClaimFarmerInfoZY.class);
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpClaimFarmerInfoZY(){
    	
    }
    /**
     * 按主键查找数据
     * @throws Exception 
     */
    public ClaimFarmerInfo[] findByPrimaryKey(String caseNo) throws Exception{
    	DBManager dbManager = new DBManager();
    	DBManager dbManager1 = new DBManager();
    	ClaimFarmerInfo[] claimFarmerInfoList = null;
    	ArrayList list = new ArrayList();
    	ResultSet resultSet = null;
    	ResultSet resultSet1 = null;
    	String cNumber = null;
    	String flag = null;
    	String idType = null;
    	double sumPrePaid = 0.0;//预赔金额
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));//打开数据源
        	StringBuffer buffer = new StringBuffer(200);
        	//拼接SQL
        	buffer.append(" select Distinct ");
        	buffer.append(" p.compensateno, ");//赔案号
        	buffer.append(" pc.insuredflag, ");//客户标识（1-被保险人，2-投保人）
        	buffer.append(" pc.identifytype, ");//证件类型
        	buffer.append(" p.SUMPREPAID ");//预赔金额
        	buffer.append(" from prplcompensate p,prpcinsured pc  ");
        	if(logger.isDebugEnabled()){
                StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
                debugBuffer.append(buffer.toString());
                debugBuffer.append(" where p.policyno = pc.policyno ");
                debugBuffer.append(" And p.compensateNo=").append("'").append(caseNo).append("'");
                logger.debug(debugBuffer.toString());
            }
        	buffer.append(" where p.policyno = pc.policyno ");
        	buffer.append(" And p.compensateNo=? ");
        	dbManager.prepareStatement(buffer.toString());
            //设置条件字段;
            dbManager.setString(1,caseNo);
            resultSet = dbManager.executePreparedQuery();
            while (resultSet.next()) {
            	flag = dbManager.getString(resultSet, 2);//
				if ("1".equals(flag)) {// 被保险人
					cNumber = dbManager.getString(resultSet, 1);// 赔案号
					// 设置证件类型
					idType = dbManager.getString(resultSet, 3);
					if (idType.equals("01")) {
						idType = "01";// 身份证
					} else if (idType.equals("61")) {
						idType = "71";// 组织机构代码证
					} else if (idType.equals("62")) {
						idType = "72";// 税务登记证
					} else {
						idType = "99";// 其它
					}
					sumPrePaid = dbManager.getDouble(resultSet, 4);// 预付金额
				}
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
        resultSet.close();
        dbManager.close();
    	}
    	try{
        	dbManager1.open("NXDADataSource");//打开数据源
        	StringBuffer buffer1 = new StringBuffer(200);
            //拼接SQL
            buffer1.append(" select distinct  ");
            buffer1.append(" n.FNAME, ");//农户姓名
            buffer1.append(" n.FIDCARD, ");//证件号码
            buffer1.append(" n.phone, ");//联系电话
            buffer1.append(" n.insurearea, ");//承保数量
            buffer1.append(" n.LOSSRATE, ");//损失程度
            buffer1.append(" n.settlesum, ");//已决赔案金额
            buffer1.append(" n.settlesum, ");//赔付金额
            buffer1.append(" n.indexofsettle, ");//分户序号
            buffer1.append(" n.settlearea ");//理赔面积（受灾面积）
            buffer1.append(" from plantingsettlelist n,settlemainlist s ");
            if(logger.isDebugEnabled()){
                 StringBuffer debugBuffer1 =  new StringBuffer(buffer1.length()*4);
                 debugBuffer1.append(buffer1.toString());
                 debugBuffer1.append(" where s.settlelistcode = n.settlelistcode ");
                 debugBuffer1.append(" And n.nodeType='compe' ");
                 debugBuffer1.append(" And s.compensateNo=").append("'").append(caseNo).append("'");
                 logger.debug(debugBuffer1.toString());
               }
            buffer1.append(" Where s.settlelistcode = n.settlelistcode ");
            buffer1.append(" And n.nodeType='compe' ");
            buffer1.append(" And s.compensateNo=? ");
            dbManager1.prepareStatement(buffer1.toString());
             //设置条件字段;
            dbManager1.setString(1,caseNo);
            resultSet1 = dbManager1.executePreparedQuery();
            while(resultSet1.next()){
            	ClaimFarmerInfo claimFarmerInfo =  new ClaimFarmerInfo();//每次循环都要new一个新的对象
            	//农户姓名处理	
            	String farmerName = dbManager1.getString(resultSet1,1);
            	if("".equals(farmerName)){
            		claimFarmerInfo.setFarmerName("aaa");
            	}else{
            		claimFarmerInfo.setFarmerName(dbManager1.getString(resultSet1,1));
            	}
            	//证件号码处理
                String number = dbManager1.getString(resultSet1,2);
                if("".equals(number)){
                	claimFarmerInfo.setFarmerIDNumber("**");
                }else{
                	claimFarmerInfo.setFarmerIDNumber(dbManager1.getString(resultSet1,2));
                }
                claimFarmerInfo.setFarmerTelephone(dbManager1.getString(resultSet1, 3));//联系电话
                claimFarmerInfo.setInsuredObjectNumber(dbManager1.getDouble(resultSet1, 4));//承保数量
                //损失程度的操作
                double lossagree = dbManager1.getDouble(resultSet1, 5);
                double lossrate = lossagree / 100.00;
                DecimalFormat d = new DecimalFormat("0.00");
                double lossRate = Double.parseDouble(d.format(lossrate));
                claimFarmerInfo.setLossDegree(lossRate);//损失程度	
                claimFarmerInfo.setSettledAmount(dbManager1.getDouble(resultSet1, 6));//已决赔案金额
                claimFarmerInfo.setSettledSumAmount(dbManager1.getDouble(resultSet1, 7));//赔付金额
                claimFarmerInfo.setSerialNo(dbManager1.getLong(resultSet1, 8));//序号
                claimFarmerInfo.setAffectedArea(dbManager1.getDouble(resultSet1, 9));//受灾面积
                claimFarmerInfo.setDamagedArea(dbManager1.getDouble(resultSet1, 9));//成灾面积
                if(lossagree>=80){
                	claimFarmerInfo.setLossArea(dbManager1.getDouble(resultSet1, 9));//绝产面积
                }else{
                	claimFarmerInfo.setLossArea(0.00);//绝产面积
                }
                claimFarmerInfo.setMeasuremantUnit("1");//计量单位
                claimFarmerInfo.setCaseNumber(cNumber);//赔案号码
                claimFarmerInfo.setFarmerIDType(idType);//证件类型
                claimFarmerInfo.setSettledObjectNumber(dbManager1.getDouble(resultSet1, 9));//已决赔付数量
                claimFarmerInfo.setPrepaidAmount(sumPrePaid);//预赔金额
                list.add(claimFarmerInfo);
            }
    	}catch(Exception e1){
    		e1.printStackTrace();
    	}finally{
    		resultSet1.close();
            dbManager1.close();
    	}
    	if(list.size()<=0){
    		return null;
    	}
    	claimFarmerInfoList = new ClaimFarmerInfo[list.size()];
        for(int i=0;i<list.size();i++){
        	claimFarmerInfoList[i] = (ClaimFarmerInfo)list.get(i);
        }
		return claimFarmerInfoList;
    	
    }
}
