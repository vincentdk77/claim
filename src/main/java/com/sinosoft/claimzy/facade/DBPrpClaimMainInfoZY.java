package com.sinosoft.claimzy.facade;
/**
 * ����ũ�գ����������ԣ�����������Ϣ�����ݷ�����
 * @author CDB
 *
 */
import java.sql.ResultSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


public class DBPrpClaimMainInfoZY {
	 /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpClaimMainInfoZY.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpClaimMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    
    /**
     * ��������������
     * @throws Exception 
     */
    public ClaimMainInfo findByPrimaryKey(String claimNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//���ڻ��������ת��
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
    	buffer.append("select ");
    	buffer.append("prpcmain.Comcode, ");
    	buffer.append("prplclaim.policyno, ");
    	buffer.append("prplclaim.claimNo, ");
    	buffer.append("prplclaim.damagestartdate, ");
    	buffer.append("prplclaim.claimdate, ");
    	buffer.append("prplclaim.damagename, ");
    	buffer.append("prplclaim.damageaddress, ");
    	buffer.append("prplclaim.lossesunitcode, ");
    	//buffer.append("prplclaim.lossname, ");
    	buffer.append("prpcitemkind.itemdetailname, ");
    	buffer.append("prplclaim.lossquantity, ");
    	buffer.append("prplclaim.sumclaim, ");
    	buffer.append("prplclaim.noproductionarea, ");
    	buffer.append("prplclaim.affectedarea, ");
    	buffer.append("prplclaim.disasterarea, ");
    	buffer.append("prplclaim.damageinsured, ");
    	buffer.append("prplregist.catastrophecode1, ");
    	buffer.append("prplregist.catastrophename1  ");
    	buffer.append(" from prplclaim,prplregist,prpcitemkind,prpcmain ");
    	if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" WHERE prplclaim.registno = prplregist.registno ");
            debugBuffer.append(" And prplclaim.policyno = prpcitemkind.policyno ");
            debugBuffer.append(" And prplclaim.policyno = prpcmain.policyno ");
            debugBuffer.append(" And claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append("where prplclaim.registno = prplregist.registno "); 
    	buffer.append("And prplclaim.policyno = prpcitemkind.policyno ");
    	buffer.append("And prplclaim.policyno = prpcmain.policyno ");
    	buffer.append("And claimNo=? ");
    	dbManager.prepareStatement(buffer.toString());//
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        ClaimMainInfo claimMainInfo = new ClaimMainInfo();
        if(resultSet.next()){
        	String comCode = dbManager.getString(resultSet, 1);
        	claimMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//���չ�˾��������
        	claimMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//������
        	claimMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//������
        	claimMainInfo.setAccidentTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 4));//����ʱ��
        	claimMainInfo.setClaimDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//��������
        	//����ԭ��ת��
        	if(dbManager.getString(resultSet, 6).equals("����")){
        		claimMainInfo.setLossOccurredCause("103");//����
        	}else if(dbManager.getString(resultSet, 6).equals("��ˮ")){
        		claimMainInfo.setLossOccurredCause("105");//��ˮ
        	}else if(dbManager.getString(resultSet, 6).equals("���֡��溦������")){
        		claimMainInfo.setLossOccurredCause("401");//���֡��溦������
        	}else if(dbManager.getString(resultSet, 6).equals("�ݺ�")){
        		claimMainInfo.setLossOccurredCause("402");//�ݺ�
        	}else if(dbManager.getString(resultSet, 6).equals("��")){
        		claimMainInfo.setLossOccurredCause("403");//��
        	}else if(dbManager.getString(resultSet, 6).equals("����")){
        		claimMainInfo.setLossOccurredCause("104");//����
        	}else if(dbManager.getString(resultSet, 6).equals("����")){
        		claimMainInfo.setLossOccurredCause("101");//����
        	}else if(dbManager.getString(resultSet, 6).equals("����������")){
        		claimMainInfo.setLossOccurredCause("107");//����������
        	}else if(dbManager.getString(resultSet, 6).equals("�䶳������")){
        		claimMainInfo.setLossOccurredCause("109");//�䶳������
        	}else if(dbManager.getString(resultSet, 6).equals("�ɺ�������")){
        		claimMainInfo.setLossOccurredCause("106");//�ɺ�������
        	}else{
        		claimMainInfo.setLossOccurredCause("9");//����
        	}
        	claimMainInfo.setLossOccurredLocation(dbManager.getString(resultSet, 7));//���յص�
        	claimMainInfo.setMeasuremantUnit("1");//������λ
        	//������ת��
        	if(dbManager.getString(resultSet, 9).equals("ˮ��")){
        		claimMainInfo.setLossSubject("110101");//ˮ��
        	}else if(dbManager.getString(resultSet, 9).equals("��С��")){
        		claimMainInfo.setLossSubject("110103");//��С��
        	}else if(dbManager.getString(resultSet, 9).equals("��С��")){
        		claimMainInfo.setLossSubject("110102");//��С��
        	}else if(dbManager.getString(resultSet, 9).equals("�Ͳ�")){
        		claimMainInfo.setLossSubject("120201");//�Ͳ�
        	}else if(dbManager.getString(resultSet, 9).equals("����")){
        		claimMainInfo.setLossSubject("110108");//����
        	}else if(dbManager.getString(resultSet, 9).equals("�޻�")){
        		claimMainInfo.setLossSubject("120101");//�޻�
        	}else if(dbManager.getString(resultSet, 9).equals("��")){
        		claimMainInfo.setLossSubject("110201");//��
        	}else{
        		claimMainInfo.setLossSubject(dbManager.getString(resultSet, 9));
        	}
        	claimMainInfo.setLossQuantity(dbManager.getDouble(resultSet, 10));//��������
        	claimMainInfo.setEstimateLossAmout(dbManager.getDouble(resultSet, 11));//������
        	claimMainInfo.setLossArea(dbManager.getDouble(resultSet, 12));//�������/Ķ
        	claimMainInfo.setDamagedArea(dbManager.getDouble(resultSet, 13));//�������/Ķ
        	claimMainInfo.setAffectedArea(dbManager.getDouble(resultSet, 14));//�������/Ķ
        	claimMainInfo.setOutstandingFamily(dbManager.getLong(resultSet, 15));//δ��ũ�����ε����������ڵĳ��ջ���
        	claimMainInfo.setBlueRuinCode(dbManager.getString(resultSet, 16));//���ִ���
        	claimMainInfo.setBlueRuinDesc(dbManager.getString(resultSet, 17));//��������
        	claimMainInfo.setConfirmSequenceNo("");//Ͷ��ȷ���루�Ǳش���,����Ϊ��
        }
        resultSet.close();
		return claimMainInfo;
    }
}
