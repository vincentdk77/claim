package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CallCenterSendStatus�����ݷ��ʶ������<br>
 * ������ 2015-05-27 10:48:16.406<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCallCenterSendStatusBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCallCenterSendStatusBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCallCenterSendStatusBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void insert(CallCenterSendStatusDto callCenterSendStatusDto)
            throws Exception{
    	double serial = findSerial();
    	
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CallCenterSendStatus (");
        buffer.append("serial,");
        buffer.append("registNo,");
        buffer.append("caseStatus,");
        buffer.append("communicationNo,");
        buffer.append("userCode,");
        buffer.append("sendSystem,");
        buffer.append("sendStatus,");
        buffer.append("sendTime,");
        buffer.append("againSendTime,");
        buffer.append("sendType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("").append(serial).append(",");
            debugBuffer.append("'").append(callCenterSendStatusDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getCaseStatus()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getCommunicationNo()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getUserCode()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getSendSystem()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getSendStatus()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getSendTime()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getAgainSendTime()).append("',");
            debugBuffer.append("'").append(callCenterSendStatusDto.getSendType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setDouble(1,serial);
        dbManager.setString(2,callCenterSendStatusDto.getRegistNo());
        dbManager.setString(3,callCenterSendStatusDto.getCaseStatus());
        dbManager.setString(4,callCenterSendStatusDto.getCommunicationNo());
        dbManager.setString(5,callCenterSendStatusDto.getUserCode());
        dbManager.setString(6,callCenterSendStatusDto.getSendSystem());
        dbManager.setString(7,callCenterSendStatusDto.getSendStatus());
        dbManager.setDateTime(8,callCenterSendStatusDto.getSendTime());
        dbManager.setDateTime(9,callCenterSendStatusDto.getAgainSendTime());
        dbManager.setString(10,callCenterSendStatusDto.getSendType());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CallCenterSendStatus (");
        buffer.append("serial,");
        buffer.append("registNo,");
        buffer.append("caseStatus,");
        buffer.append("communicationNo,");
        buffer.append("userCode,");
        buffer.append("sendSystem,");
        buffer.append("sendStatus,");
        buffer.append("sendTime,");
        buffer.append("againSendTime,");
        buffer.append("sendType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	double serial = findSerial();
            CallCenterSendStatusDto callCenterSendStatusDto = (CallCenterSendStatusDto)i.next();
            dbManager.setDouble(1,serial);
            dbManager.setString(2,callCenterSendStatusDto.getRegistNo());
            dbManager.setString(3,callCenterSendStatusDto.getCaseStatus());
            dbManager.setString(4,callCenterSendStatusDto.getCommunicationNo());
            dbManager.setString(5,callCenterSendStatusDto.getUserCode());
            dbManager.setString(6,callCenterSendStatusDto.getSendSystem());
            dbManager.setString(7,callCenterSendStatusDto.getSendStatus());
            dbManager.setDateTime(8,callCenterSendStatusDto.getSendTime());
            dbManager.setDateTime(9,callCenterSendStatusDto.getAgainSendTime());
            dbManager.setString(10,callCenterSendStatusDto.getSendType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param serial serial
     * @throws Exception
     */
    public void delete(double serial)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CallCenterSendStatus ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("serial=").append("").append(serial).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serial = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setDouble(1,serial);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void update(CallCenterSendStatusDto callCenterSendStatusDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CallCenterSendStatus SET ");
        buffer.append("registNo = ?, ");
        buffer.append("caseStatus = ?, ");
        buffer.append("communicationNo = ?, ");
        buffer.append("userCode = ?, ");
        buffer.append("sendSystem = ?, ");
        buffer.append("sendStatus = ?, ");
        buffer.append("sendTime = ?, ");
        buffer.append("againSendTime = ?, ");
        buffer.append("sendType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CallCenterSendStatus SET ");
            debugBuffer.append("registNo = '" + callCenterSendStatusDto.getRegistNo() + "', ");
            debugBuffer.append("caseStatus = '" + callCenterSendStatusDto.getCaseStatus() + "', ");
            debugBuffer.append("communicationNo = '" + callCenterSendStatusDto.getCommunicationNo() + "', ");
            debugBuffer.append("userCode = '" + callCenterSendStatusDto.getUserCode() + "', ");
            debugBuffer.append("sendSystem = '" + callCenterSendStatusDto.getSendSystem() + "', ");
            debugBuffer.append("sendStatus = '" + callCenterSendStatusDto.getSendStatus() + "', ");
            debugBuffer.append("sendTime = '" + callCenterSendStatusDto.getSendTime() + "', ");
            debugBuffer.append("againSendTime = '" + callCenterSendStatusDto.getAgainSendTime() + "', ");
            debugBuffer.append("sendType = '" + callCenterSendStatusDto.getSendType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("serial=").append("").append(callCenterSendStatusDto.getSerial()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serial = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,callCenterSendStatusDto.getRegistNo());
        dbManager.setString(2,callCenterSendStatusDto.getCaseStatus());
        dbManager.setString(3,callCenterSendStatusDto.getCommunicationNo());
        dbManager.setString(4,callCenterSendStatusDto.getUserCode());
        dbManager.setString(5,callCenterSendStatusDto.getSendSystem());
        dbManager.setString(6,callCenterSendStatusDto.getSendStatus());
        dbManager.setDateTime(7,callCenterSendStatusDto.getSendTime());
        dbManager.setDateTime(8,callCenterSendStatusDto.getAgainSendTime());
        dbManager.setString(9,callCenterSendStatusDto.getSendType());
        //���������ֶ�;
        dbManager.setDouble(10,callCenterSendStatusDto.getSerial());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param serial serial
     * @return CallCenterSendStatusDto
     * @throws Exception
     */
    public CallCenterSendStatusDto findByPrimaryKey(double serial)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("serial,");
        buffer.append("registNo,");
        buffer.append("caseStatus,");
        buffer.append("communicationNo,");
        buffer.append("userCode,");
        buffer.append("sendSystem,");
        buffer.append("sendStatus,");
        buffer.append("sendTime,");
        buffer.append("againSendTime,");
        buffer.append("sendType ");
        buffer.append("FROM CallCenterSendStatus ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("serial=").append("").append(serial).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serial = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setDouble(1,serial);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CallCenterSendStatusDto callCenterSendStatusDto = null;
        if(resultSet.next()){
            callCenterSendStatusDto = new CallCenterSendStatusDto();
            callCenterSendStatusDto.setSerial(dbManager.getDouble(resultSet,1));
            callCenterSendStatusDto.setRegistNo(dbManager.getString(resultSet,2));
            callCenterSendStatusDto.setCaseStatus(dbManager.getString(resultSet,3));
            callCenterSendStatusDto.setCommunicationNo(dbManager.getString(resultSet,4));
            callCenterSendStatusDto.setUserCode(dbManager.getString(resultSet,5));
            callCenterSendStatusDto.setSendSystem(dbManager.getString(resultSet,6));
            callCenterSendStatusDto.setSendStatus(dbManager.getString(resultSet,7));
            callCenterSendStatusDto.setSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,8));
            callCenterSendStatusDto.setAgainSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
            callCenterSendStatusDto.setSendType(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return callCenterSendStatusDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("serial,");
        buffer.append("registNo,");
        buffer.append("caseStatus,");
        buffer.append("communicationNo,");
        buffer.append("userCode,");
        buffer.append("sendSystem,");
        buffer.append("sendStatus,");
        buffer.append("sendTime,");
        buffer.append("againSendTime,");
        buffer.append("sendType ");
        buffer.append("FROM CallCenterSendStatus WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        CallCenterSendStatusDto callCenterSendStatusDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            callCenterSendStatusDto = new CallCenterSendStatusDto();
            callCenterSendStatusDto.setSerial(dbManager.getDouble(resultSet,1));
            callCenterSendStatusDto.setRegistNo(dbManager.getString(resultSet,2));
            callCenterSendStatusDto.setCaseStatus(dbManager.getString(resultSet,3));
            callCenterSendStatusDto.setCommunicationNo(dbManager.getString(resultSet,4));
            callCenterSendStatusDto.setUserCode(dbManager.getString(resultSet,5));
            callCenterSendStatusDto.setSendSystem(dbManager.getString(resultSet,6));
            callCenterSendStatusDto.setSendStatus(dbManager.getString(resultSet,7));
            callCenterSendStatusDto.setSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,8));
            callCenterSendStatusDto.setAgainSendTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
            callCenterSendStatusDto.setSendType(dbManager.getString(resultSet,10));
            collection.add(callCenterSendStatusDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CallCenterSendStatus WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM CallCenterSendStatus WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
    public double findSerial() throws Exception{
    	double serial = 0;
    	String sql = "SELECT  sq_CallCenterSendStatus.Nextval from dual";
    	ResultSet resultSet = dbManager.executeQuery(sql);
    	 if(resultSet.next()){
    		 serial = dbManager.getDouble(resultSet,1);
         }
		return serial;
    	
    }
}
