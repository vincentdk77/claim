package com.sinosoft.claimzy.facade;
/**
 * ���Ǳ�����Ϣ�����ݷ�����
 */
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.RegistInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpRegistInfoZY {
	 /**
    * ��Դ�������ʵ�����������ݿ����.
    */
   protected DBManager dbManager = new DBManager();
   private static Log logger = LogFactory.getLog(DBPrpRegistInfoZY.class);

   /**
    * ���캯��
    * @param dbManager ��Դ������
    */
   public DBPrpRegistInfoZY(DBManager dbManager){
	   this.dbManager = dbManager;
   }
   /**
    * ��������������
    * @throws Exception 
    * 
    */
   public RegistInfo findByPrimaryKey(String registNo) throws Exception{
   	StringBuffer buffer = new StringBuffer(200);
   	 //ƴSQL���
   	buffer.append("select ");
   	buffer.append("registNo, ");//������
   	buffer.append("reportorName, ");//������
   	buffer.append("phoneNumber, ");//�绰
   	buffer.append("reportDate, ");//��������
   	buffer.append("damageName ");//����ԭ��
   	buffer.append("from prplregist ");
   	if(logger.isDebugEnabled()){
   		StringBuffer debugBuffer = new StringBuffer(buffer.length()*4);
   		debugBuffer.append(buffer.toString());
   		debugBuffer.append(" Where registNo=").append("'").append(registNo).append("'");
   		logger.debug(debugBuffer.toString());
   	}
   	buffer.append("Where registNo=? ");
    dbManager.prepareStatement(buffer.toString());
   	//���������ֶ�
   	dbManager.setString(1, registNo);
   	ResultSet resultSet = dbManager.executePreparedQuery();
   	RegistInfo registInfo = new RegistInfo();;
   	if(resultSet.next()){
   		 registInfo.setNotificationNumber(dbManager.getString(resultSet, 1));//������
   	     //������(����)
   		 String reptorName = dbManager.getString(resultSet, 2);
   		 if(reptorName.equals("")){
   			 registInfo.setNotifier("**");
   		 }else{
   			 registInfo.setNotifier(dbManager.getString(resultSet, 2));
   		 }
   		 registInfo.setNotifierTelephone(dbManager.getString(resultSet, 3));//��ϵ�绰
   		 registInfo.setNotificationTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 4));//����ʱ��
   		//����ԭ��ת��
   		if(dbManager.getString(resultSet, 5).equals("����")){
   			registInfo.setLossReason("103");//����
    	}else if(dbManager.getString(resultSet, 5).equals("��ˮ")){
    		registInfo.setLossReason("105");//��ˮ
    	}else if(dbManager.getString(resultSet,5).equals("���֡��溦������")){
    		registInfo.setLossReason("401");//���֡��溦������
    	}else if(dbManager.getString(resultSet, 5).equals("�ݺ�")){
    		registInfo.setLossReason("402");//�ݺ�
    	}else if(dbManager.getString(resultSet, 5).equals("��")){
    		registInfo.setLossReason("403");//��
    	}else if(dbManager.getString(resultSet, 5).equals("����")){
    		registInfo.setLossReason("104");//����
    	}else if(dbManager.getString(resultSet, 5).equals("����")){
    		registInfo.setLossReason("101");//����
    	}else if(dbManager.getString(resultSet, 5).equals("����������")){
    		registInfo.setLossReason("107");//����������
    	}else if(dbManager.getString(resultSet, 5).equals("�䶳������")){
    		registInfo.setLossReason("109");//�䶳������
    	}else if(dbManager.getString(resultSet, 5).equals("�ɺ�������")){
    		registInfo.setLossReason("106");//�ɺ�������
    	}else{
    		registInfo.setLossReason("9");//����
    	}
   	}
   	resultSet.close();
    return registInfo;
   	
   }
}
