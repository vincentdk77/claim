package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ũ�գ����������ԣ���ע��/������Ϣ�����ݷ�����
 * @author Administrator
 *
 */
public class DBPrpCancelMainInfoZY {
	/**
	 * ��Դ�������ʵ�����������ݿ����
	 */
	protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpCancelMainInfoZY.class);
    
    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCancelMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * ��������������
     * @throws Exception 
     */
    public CancelMainInfo findByPrimaryKey(String claimNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//���ڻ��������ת��
    	StringBuffer buffer = new StringBuffer(200);
    	//ƴ��SQL
    	buffer.append("select ");
    	////�������claimSequenceNo(δ�ҵ�)
    	buffer.append("prplclaim.comcode, ");
        buffer.append("prplclaim.policyno, ");
 	    buffer.append("prplclaim.claimno, ");
 	    buffer.append("prplclaim.casetype, ");//ע������
 		buffer.append("prplclaim.canceldate, ");
 		buffer.append("prplclaim.cancelreason ");//ԭ������
        buffer.append(" from prplclaim");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" Where claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append(" Where claimNo=? ");
    	dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CancelMainInfo cancelMainInfo = null;
        if(resultSet.next()){
        	cancelMainInfo = new CancelMainInfo();
        	String comCode = dbManager.getString(resultSet, 1);
        	cancelMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//���չ�˾��������
        	cancelMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//������
        	cancelMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//������
        	//ע��/��������ת��
        	String cancelType = dbManager.getString(resultSet, 4);
        	if(cancelType.equals("0")){//ע������
        		cancelMainInfo.setCancelType("01");//����ע��
        	}else if(cancelType.equals("1")){
        		cancelMainInfo.setCancelType("02");//��������
        	}else{
        		cancelMainInfo.setCancelType(dbManager.getString(resultSet, 4));
        	}
        	cancelMainInfo.setCancelTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//����ע��/����ʱ��
        	//ԭ������(����)
        	String cancelReason = dbManager.getString(resultSet, 6);
        	if(cancelReason.equals("")){
        		cancelMainInfo.setCancelReason("**");
        	}else{
        		cancelMainInfo.setCancelReason(dbManager.getString(resultSet, 6));
        	}
        	cancelMainInfo.setClaimSequenceNo("");//��������ÿ�
        }
        resultSet.close();
		return cancelMainInfo;
    	
    }
}
