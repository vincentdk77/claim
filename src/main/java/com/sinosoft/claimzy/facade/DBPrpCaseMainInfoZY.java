package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.NXCaseUp.bl.facade.BLCasemaininfoFacade;
import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是农险（中央政策性）的赔案主信息的数据访问类
 * @author CDB
 *
 */
public class DBPrpCaseMainInfoZY {
	/**
	 * 资源管理类的实例，处理数据库操作
	 */
	protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpCaseMainInfoZY.class);
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCaseMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * 按主键查找数据
     * @throws Exception 
     *  
     */
    public CaseMainInfo findByPrimaryKey(String caseNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//用于机构代码的转换
		StringBuffer buffer = new StringBuffer(200);
		//拼接SQL语句
		buffer.append("select distinct ");
		buffer.append(" prpLcompensate.comcode, ");//保险公司机构代码
		buffer.append(" prpLcompensate.policyno, ");
		buffer.append(" prpLcompensate.compensateno, ");//赔案号
		buffer.append(" prpLcompensate.claimno, ");
		buffer.append(" prpLcompensate.underwriteenddate, ");//核赔日期
		buffer.append(" prplclaim.endcasedate, ");
		buffer.append(" prpLcompensate.SUMPAID, ");//已决赔款
		buffer.append(" prpLcompensate.sumnodutyfee, ");//已决直接理赔费用setteledDirectExpense()
		buffer.append(" prpLcompensate.sumthispaid, ");//理赔金额(sumpaid-sumnodutyfee)
		buffer.append(" prpLcompensate.sumnodutyfee, ");//其中：直接理赔费用
		buffer.append(" prplcompensate.sumprepaid, ");//预付赔款
		buffer.append(" prpLcompensate.DAMAGEINSURED, ");//受益农户户次（出险农户数量）
		buffer.append(" prpLcompensate.LOSSESNUMBER, ");//已决赔付数量
		buffer.append(" prpLcompensate.LOSSESUNITCODE, ");//计量单位
		buffer.append(" prpLcompensate.times, ");//次数(用于判断第几次理算)
		buffer.append(" prpLcompensate.reopenedType, ");//案件恢复、重开类型reopenedType(自己在表中增加了该字段)
		buffer.append(" prpLcompensate.noproductionarea, ");//绝产面积
		buffer.append(" prpLcompensate.affectedarea, ");//成灾面积
		buffer.append(" prpLcompensate.disasterarea, ");//受灾面积
		buffer.append(" prplcompensate.damageinsured, ");//分户赔付清单记录数
		buffer.append(" prpLcompensate.lawsuitFlag ");//是否涉诉lawsuitFlag(在表中加了字段)
		//理赔编码claimSequenceNo(未找到)
		buffer.append(" from prplcompensate,prplclaim ");
		if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" WHERE prplclaim.claimNo = prplcompensate.claimNo ");
            debugBuffer.append(" And prplcompensate.compensateNo=").append("'").append(caseNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append(" WHERE prplclaim.claimNo = prplcompensate.claimNo "); 
    	buffer.append(" And prplcompensate.compensateNo=? ");
    	dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,caseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CaseMainInfo caseMainInfo = null;
        if(resultSet.next()){
        	caseMainInfo = new CaseMainInfo();
        	String comCode = dbManager.getString(resultSet, 1);
        	caseMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//保险公司机构代码
        	caseMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//保单号
        	caseMainInfo.setCaseNumber(dbManager.getString(resultSet, 3));//赔案号
        	caseMainInfo.setClaimNumber(dbManager.getString(resultSet, 4));//立案号
        	int times = dbManager.getInt(resultSet, 15);
        	caseMainInfo.setAssessmentDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,5));//核赔日期
        	if (times>1){//重开赔案的结案日期取其核赔通过日期
        	  caseMainInfo.setSettlementDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,5));//结案日期
        	}else{
        	  caseMainInfo.setSettlementDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,6));//结案日期
        	}
        	caseMainInfo.setSetteledAmount(dbManager.getDouble(resultSet, 7));//已决赔款
        	caseMainInfo.setSetteledDirectExpense(dbManager.getDouble(resultSet, 8));//已决直接理赔费用
        	caseMainInfo.setClaimAmout(dbManager.getDouble(resultSet, 9));//理赔金额
        	caseMainInfo.setDirectExpense(dbManager.getDouble(resultSet,10));//其中：直接理赔费用
        	caseMainInfo.setPrepaidAmount(dbManager.getDouble(resultSet, 11));//预付赔款
        	caseMainInfo.setPrepaidDirectExpense(0.00);//预付赔款中的直接理赔费用
        	caseMainInfo.setSettledFamilyNumber(dbManager.getLong(resultSet, 12));//受益农户户次
        	caseMainInfo.setSettledObjectNumber(dbManager.getDouble(resultSet, 13));//已决赔付数量
        	caseMainInfo.setMeasuremantUnit("1");//计量单位
            double sumPaid = dbManager.getDouble(resultSet, 7);
            if(times==1){
            	caseMainInfo.setReopenedType("1");//不涉及恢复或重开
            }else if(times>1){
            	if(sumPaid==0){
            		caseMainInfo.setReopenedType("4");//零结重开
            	}else{
            		caseMainInfo.setReopenedType("5");//已赔付案件重开
            	}
            }else{
            	caseMainInfo.setReopenedType(dbManager.getString(resultSet, 16));
            }
            int time = times -1;
            caseMainInfo.setReopenedTimes(time);//案件恢复、重开次数
        	caseMainInfo.setDamagedArea(dbManager.getDouble(resultSet,18));//成灾
        	caseMainInfo.setAffectedArea(dbManager.getDouble(resultSet,19));//受灾
        	caseMainInfo.setLossArea(dbManager.getDouble(resultSet,17));//绝产
        	caseMainInfo.setFarmerCount(dbManager.getLong(resultSet, 20));//分户赔付清单记录数
        	caseMainInfo.setLawsuitFlag(dbManager.getString(resultSet, 21));//是否涉诉
        	caseMainInfo.setClaimSequenceNo("");//理赔编码置空
        }
        resultSet.close();
    	return caseMainInfo;
    }
}
