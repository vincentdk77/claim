package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ũ�գ����������ԣ���Ԥ�ⰸ����Ϣ�����ݷ�����
 * @author CDB
 *
 */
public class DBPrpPrepaidMainInfoZY {
	/**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpPrepaidMainInfoZY.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPrepaidMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * ��������������
     * @throws Exception 
     */
    public PrepaidMainInfo findByPrimaryKey(String preCompensateNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//���ڻ��������ת��
		StringBuffer buffer = new StringBuffer(200);
		//ƴ��SQL
		buffer.append("select ");
		buffer.append(" prplprepay.comcode, ");
		buffer.append(" prplprepay.policyno, ");
		buffer.append(" prplprepay.claimno, ");
		buffer.append(" prplprepay.precompensateno, ");
		buffer.append(" prplprepay.underwriteenddate, ");
		buffer.append(" prplprepay.sumprepaid, ");
		buffer.append(" prplprepay.sumPreChargePaid, ");
		buffer.append(" prpcmain.suminsured ");
		buffer.append(" from prplprepay,prpcmain ");
		if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" where prplprepay.policyno = prpcmain.policyno ");
            debugBuffer.append(" And preCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append(" where prplprepay.policyno = prpcmain.policyno "); 
    	buffer.append(" And preCompensateNo=? ");
    	dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
    	 dbManager.setString(1,preCompensateNo);
         ResultSet resultSet = dbManager.executePreparedQuery();
         PrepaidMainInfo prepaidMainInfo = null;
         if(resultSet.next()){
        	 prepaidMainInfo = new PrepaidMainInfo();
        	 String comCode = dbManager.getString(resultSet, 1);
        	 prepaidMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//���չ�˾��������
        	 prepaidMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//������
        	 prepaidMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//������
        	 prepaidMainInfo.setPrepayCaseNumber(dbManager.getString(resultSet, 4));//Ԥ�ⰸ��
        	 prepaidMainInfo.setAssessmentDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//��������
        	 prepaidMainInfo.setPrepaidAmount(dbManager.getDouble(resultSet, 6));//Ԥ�����
        	 prepaidMainInfo.setPrepaidDirectExpense(dbManager.getDouble(resultSet, 7));//���У�Ԥ��ֱ���������
        	 prepaidMainInfo.setFarmerCount(dbManager.getLong(resultSet, 8));//�ֻ�Ԥ�⸶�嵥��¼��
        	 prepaidMainInfo.setClaimSequenceNo("");//�������
         }
    	return prepaidMainInfo;
    	
    }
}
