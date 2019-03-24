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
 * ����ũ�գ����������ԣ����ⰸ����Ϣ�����ݷ�����
 * @author CDB
 *
 */
public class DBPrpCaseMainInfoZY {
	/**
	 * ��Դ�������ʵ�����������ݿ����
	 */
	protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpCaseMainInfoZY.class);
    
    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCaseMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * ��������������
     * @throws Exception 
     *  
     */
    public CaseMainInfo findByPrimaryKey(String caseNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//���ڻ��������ת��
		StringBuffer buffer = new StringBuffer(200);
		//ƴ��SQL���
		buffer.append("select distinct ");
		buffer.append(" prpLcompensate.comcode, ");//���չ�˾��������
		buffer.append(" prpLcompensate.policyno, ");
		buffer.append(" prpLcompensate.compensateno, ");//�ⰸ��
		buffer.append(" prpLcompensate.claimno, ");
		buffer.append(" prpLcompensate.underwriteenddate, ");//��������
		buffer.append(" prplclaim.endcasedate, ");
		buffer.append(" prpLcompensate.SUMPAID, ");//�Ѿ����
		buffer.append(" prpLcompensate.sumnodutyfee, ");//�Ѿ�ֱ���������setteledDirectExpense()
		buffer.append(" prpLcompensate.sumthispaid, ");//������(sumpaid-sumnodutyfee)
		buffer.append(" prpLcompensate.sumnodutyfee, ");//���У�ֱ���������
		buffer.append(" prplcompensate.sumprepaid, ");//Ԥ�����
		buffer.append(" prpLcompensate.DAMAGEINSURED, ");//����ũ�����Σ�����ũ��������
		buffer.append(" prpLcompensate.LOSSESNUMBER, ");//�Ѿ��⸶����
		buffer.append(" prpLcompensate.LOSSESUNITCODE, ");//������λ
		buffer.append(" prpLcompensate.times, ");//����(�����жϵڼ�������)
		buffer.append(" prpLcompensate.reopenedType, ");//�����ָ����ؿ�����reopenedType(�Լ��ڱ��������˸��ֶ�)
		buffer.append(" prpLcompensate.noproductionarea, ");//�������
		buffer.append(" prpLcompensate.affectedarea, ");//�������
		buffer.append(" prpLcompensate.disasterarea, ");//�������
		buffer.append(" prplcompensate.damageinsured, ");//�ֻ��⸶�嵥��¼��
		buffer.append(" prpLcompensate.lawsuitFlag ");//�Ƿ�����lawsuitFlag(�ڱ��м����ֶ�)
		//�������claimSequenceNo(δ�ҵ�)
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
        //���������ֶ�;
        dbManager.setString(1,caseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CaseMainInfo caseMainInfo = null;
        if(resultSet.next()){
        	caseMainInfo = new CaseMainInfo();
        	String comCode = dbManager.getString(resultSet, 1);
        	caseMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//���չ�˾��������
        	caseMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//������
        	caseMainInfo.setCaseNumber(dbManager.getString(resultSet, 3));//�ⰸ��
        	caseMainInfo.setClaimNumber(dbManager.getString(resultSet, 4));//������
        	int times = dbManager.getInt(resultSet, 15);
        	caseMainInfo.setAssessmentDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,5));//��������
        	if (times>1){//�ؿ��ⰸ�Ľ᰸����ȡ�����ͨ������
        	  caseMainInfo.setSettlementDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,5));//�᰸����
        	}else{
        	  caseMainInfo.setSettlementDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,6));//�᰸����
        	}
        	caseMainInfo.setSetteledAmount(dbManager.getDouble(resultSet, 7));//�Ѿ����
        	caseMainInfo.setSetteledDirectExpense(dbManager.getDouble(resultSet, 8));//�Ѿ�ֱ���������
        	caseMainInfo.setClaimAmout(dbManager.getDouble(resultSet, 9));//������
        	caseMainInfo.setDirectExpense(dbManager.getDouble(resultSet,10));//���У�ֱ���������
        	caseMainInfo.setPrepaidAmount(dbManager.getDouble(resultSet, 11));//Ԥ�����
        	caseMainInfo.setPrepaidDirectExpense(0.00);//Ԥ������е�ֱ���������
        	caseMainInfo.setSettledFamilyNumber(dbManager.getLong(resultSet, 12));//����ũ������
        	caseMainInfo.setSettledObjectNumber(dbManager.getDouble(resultSet, 13));//�Ѿ��⸶����
        	caseMainInfo.setMeasuremantUnit("1");//������λ
            double sumPaid = dbManager.getDouble(resultSet, 7);
            if(times==1){
            	caseMainInfo.setReopenedType("1");//���漰�ָ����ؿ�
            }else if(times>1){
            	if(sumPaid==0){
            		caseMainInfo.setReopenedType("4");//����ؿ�
            	}else{
            		caseMainInfo.setReopenedType("5");//���⸶�����ؿ�
            	}
            }else{
            	caseMainInfo.setReopenedType(dbManager.getString(resultSet, 16));
            }
            int time = times -1;
            caseMainInfo.setReopenedTimes(time);//�����ָ����ؿ�����
        	caseMainInfo.setDamagedArea(dbManager.getDouble(resultSet,18));//����
        	caseMainInfo.setAffectedArea(dbManager.getDouble(resultSet,19));//����
        	caseMainInfo.setLossArea(dbManager.getDouble(resultSet,17));//����
        	caseMainInfo.setFarmerCount(dbManager.getLong(resultSet, 20));//�ֻ��⸶�嵥��¼��
        	caseMainInfo.setLawsuitFlag(dbManager.getString(resultSet, 21));//�Ƿ�����
        	caseMainInfo.setClaimSequenceNo("");//��������ÿ�
        }
        resultSet.close();
    	return caseMainInfo;
    }
}
