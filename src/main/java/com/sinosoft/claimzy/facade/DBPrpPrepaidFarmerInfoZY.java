package com.sinosoft.claimzy.facade;



import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidFarmerInfo;
import com.sinosoft.claimzy.common.NXZYAppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ũ�գ����������ԣ��ֻ�Ԥ�⸶��Ϣ�����ݷ�����
 * @author CDB
 *
 */
public class DBPrpPrepaidFarmerInfoZY {
	/**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpPrepaidFarmerInfoZY.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPrepaidFarmerInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    
    /**
     * ��������������
     * @throws Exception 
     */
    public PrepaidFarmerInfo[] findByPrimaryKey(String preCompensateNo) throws Exception{
		StringBuffer buffer = new StringBuffer(200);
		//ƴ��SQL
		buffer.append("select ");
		buffer.append(" Distinct ");
		buffer.append(" a.precompensateno, ");
		buffer.append(" c.insuredname, ");//ũ������(��prpcinsured���в����)
		buffer.append(" c.identifytype, ");
		buffer.append(" c.identifynumber, ");//֤������(��prpcinsured���в����)
		buffer.append(" c.phonenumber, ");//��ϵ�绰(��prpcinsured���в����)
		buffer.append(" a.sumprepaid, ");//Ԥ�����
		buffer.append(" c.serialno ");//��ţ����嵥�ӱ��в�ѯ������
		buffer.append(" from prplprepay a,prpcinsured c ");
		if(logger.isDebugEnabled()){
			StringBuffer debugBuffer = new StringBuffer(buffer.length()*4);
			debugBuffer.append(buffer.toString());
			debugBuffer.append(" where a.policyno = c.policyno ");
            debugBuffer.append(" And preCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
		}
		buffer.append(" where a.policyno = c.policyno ");
		buffer.append(" And preCompensateNo=? ");
		dbManager.prepareStatement(buffer.toString());
		//���������ֶ�
		dbManager.setString(1, preCompensateNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		PrepaidFarmerInfo prepaidFarmerInfo =null;
		if(resultSet.next()){
			prepaidFarmerInfo = new PrepaidFarmerInfo();
			prepaidFarmerInfo.setPrepayCaseNumber(dbManager.getString(resultSet, 1));//Ԥ�ⰸ��
			prepaidFarmerInfo.setFarmerName(dbManager.getString(resultSet, 2));//ũ������
			//����֤������
        	if(dbManager.getString(resultSet, 3).equals("61")){
        		prepaidFarmerInfo.setFarmerIDType("71");//��֯��������֤
        	}else if(dbManager.getString(resultSet, 3).equals("62")){
        		prepaidFarmerInfo.setFarmerIDType("72");//˰��Ǽ�֤
        	}else{
        		prepaidFarmerInfo.setFarmerIDType(dbManager.getString(resultSet, 3));
        	}
            prepaidFarmerInfo.setFarmerIDNumber(dbManager.getString(resultSet, 4));//֤������
            prepaidFarmerInfo.setFarmerTelephone(dbManager.getString(resultSet, 5));//��ϵ�绰
            prepaidFarmerInfo.setPrepaidLoss(dbManager.getDouble(resultSet, 6));//Ԥ�����
            prepaidFarmerInfo.setSerialNo(dbManager.getLong(resultSet, 7));//���
		}
		List<PrepaidFarmerInfo> list = new ArrayList<PrepaidFarmerInfo>();
		list.add(prepaidFarmerInfo);
		PrepaidFarmerInfo[] prepaidFarmerInfoList = new PrepaidFarmerInfo[list.size()];
		for(int i=0;i<list.size();i++){
			prepaidFarmerInfoList[i] = list.get(i);
		}
		 resultSet.close();
    	return prepaidFarmerInfoList;
    	
    }
}
