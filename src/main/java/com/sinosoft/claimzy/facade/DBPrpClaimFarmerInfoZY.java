package com.sinosoft.claimzy.facade;
/**
 * ����ũ�գ����������ԣ��ķֻ��⸶��Ϣ�����ݷ�����
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
	 * ��Դ�������ʵ�����������ݿ����
	 */
    private static Log logger = LogFactory.getLog(DBPrpClaimFarmerInfoZY.class);
    
    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpClaimFarmerInfoZY(){
    	
    }
    /**
     * ��������������
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
    	double sumPrePaid = 0.0;//Ԥ����
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
        	StringBuffer buffer = new StringBuffer(200);
        	//ƴ��SQL
        	buffer.append(" select Distinct ");
        	buffer.append(" p.compensateno, ");//�ⰸ��
        	buffer.append(" pc.insuredflag, ");//�ͻ���ʶ��1-�������ˣ�2-Ͷ���ˣ�
        	buffer.append(" pc.identifytype, ");//֤������
        	buffer.append(" p.SUMPREPAID ");//Ԥ����
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
            //���������ֶ�;
            dbManager.setString(1,caseNo);
            resultSet = dbManager.executePreparedQuery();
            while (resultSet.next()) {
            	flag = dbManager.getString(resultSet, 2);//
				if ("1".equals(flag)) {// ��������
					cNumber = dbManager.getString(resultSet, 1);// �ⰸ��
					// ����֤������
					idType = dbManager.getString(resultSet, 3);
					if (idType.equals("01")) {
						idType = "01";// ���֤
					} else if (idType.equals("61")) {
						idType = "71";// ��֯��������֤
					} else if (idType.equals("62")) {
						idType = "72";// ˰��Ǽ�֤
					} else {
						idType = "99";// ����
					}
					sumPrePaid = dbManager.getDouble(resultSet, 4);// Ԥ�����
				}
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
        resultSet.close();
        dbManager.close();
    	}
    	try{
        	dbManager1.open("NXDADataSource");//������Դ
        	StringBuffer buffer1 = new StringBuffer(200);
            //ƴ��SQL
            buffer1.append(" select distinct  ");
            buffer1.append(" n.FNAME, ");//ũ������
            buffer1.append(" n.FIDCARD, ");//֤������
            buffer1.append(" n.phone, ");//��ϵ�绰
            buffer1.append(" n.insurearea, ");//�б�����
            buffer1.append(" n.LOSSRATE, ");//��ʧ�̶�
            buffer1.append(" n.settlesum, ");//�Ѿ��ⰸ���
            buffer1.append(" n.settlesum, ");//�⸶���
            buffer1.append(" n.indexofsettle, ");//�ֻ����
            buffer1.append(" n.settlearea ");//������������������
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
             //���������ֶ�;
            dbManager1.setString(1,caseNo);
            resultSet1 = dbManager1.executePreparedQuery();
            while(resultSet1.next()){
            	ClaimFarmerInfo claimFarmerInfo =  new ClaimFarmerInfo();//ÿ��ѭ����Ҫnewһ���µĶ���
            	//ũ����������	
            	String farmerName = dbManager1.getString(resultSet1,1);
            	if("".equals(farmerName)){
            		claimFarmerInfo.setFarmerName("aaa");
            	}else{
            		claimFarmerInfo.setFarmerName(dbManager1.getString(resultSet1,1));
            	}
            	//֤�����봦��
                String number = dbManager1.getString(resultSet1,2);
                if("".equals(number)){
                	claimFarmerInfo.setFarmerIDNumber("**");
                }else{
                	claimFarmerInfo.setFarmerIDNumber(dbManager1.getString(resultSet1,2));
                }
                claimFarmerInfo.setFarmerTelephone(dbManager1.getString(resultSet1, 3));//��ϵ�绰
                claimFarmerInfo.setInsuredObjectNumber(dbManager1.getDouble(resultSet1, 4));//�б�����
                //��ʧ�̶ȵĲ���
                double lossagree = dbManager1.getDouble(resultSet1, 5);
                double lossrate = lossagree / 100.00;
                DecimalFormat d = new DecimalFormat("0.00");
                double lossRate = Double.parseDouble(d.format(lossrate));
                claimFarmerInfo.setLossDegree(lossRate);//��ʧ�̶�	
                claimFarmerInfo.setSettledAmount(dbManager1.getDouble(resultSet1, 6));//�Ѿ��ⰸ���
                claimFarmerInfo.setSettledSumAmount(dbManager1.getDouble(resultSet1, 7));//�⸶���
                claimFarmerInfo.setSerialNo(dbManager1.getLong(resultSet1, 8));//���
                claimFarmerInfo.setAffectedArea(dbManager1.getDouble(resultSet1, 9));//�������
                claimFarmerInfo.setDamagedArea(dbManager1.getDouble(resultSet1, 9));//�������
                if(lossagree>=80){
                	claimFarmerInfo.setLossArea(dbManager1.getDouble(resultSet1, 9));//�������
                }else{
                	claimFarmerInfo.setLossArea(0.00);//�������
                }
                claimFarmerInfo.setMeasuremantUnit("1");//������λ
                claimFarmerInfo.setCaseNumber(cNumber);//�ⰸ����
                claimFarmerInfo.setFarmerIDType(idType);//֤������
                claimFarmerInfo.setSettledObjectNumber(dbManager1.getDouble(resultSet1, 9));//�Ѿ��⸶����
                claimFarmerInfo.setPrepaidAmount(sumPrePaid);//Ԥ����
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
