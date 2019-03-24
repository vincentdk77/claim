package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfPathLogStore�����ݷ��ʶ������<br>
 * ������ 2006-12-08 14:08:41.953<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfPathLogStoreBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBSwfPathLogStoreBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPathLogStoreBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void insert(SwfPathLogStoreDto swfPathLogStoreDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO SwfPathLogStore (");
        buffer.append("flowID,");
        buffer.append("pathNo,");
        buffer.append("modelNo,");
        buffer.append("pathName,");
        buffer.append("startNodeNo,");
        buffer.append("startNodeName,");
        buffer.append("endNodeNo,");
        buffer.append("endNodeName,");
        buffer.append("flowInTime,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(swfPathLogStoreDto.getFlowID()).append("',");
            debugBuffer.append("").append(swfPathLogStoreDto.getPathNo()).append(",");
            debugBuffer.append("").append(swfPathLogStoreDto.getModelNo()).append(",");
            debugBuffer.append("'").append(swfPathLogStoreDto.getPathName()).append("',");
            debugBuffer.append("").append(swfPathLogStoreDto.getStartNodeNo()).append(",");
            debugBuffer.append("'").append(swfPathLogStoreDto.getStartNodeName()).append("',");
            debugBuffer.append("").append(swfPathLogStoreDto.getEndNodeNo()).append(",");
            debugBuffer.append("'").append(swfPathLogStoreDto.getEndNodeName()).append("',");
            debugBuffer.append("'").append(swfPathLogStoreDto.getFlowInTime()).append("',");
            debugBuffer.append("'").append(swfPathLogStoreDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,swfPathLogStoreDto.getFlowID());
        dbManager.setInt(2,swfPathLogStoreDto.getPathNo());
        dbManager.setInt(3,swfPathLogStoreDto.getModelNo());
        dbManager.setString(4,swfPathLogStoreDto.getPathName());
        dbManager.setInt(5,swfPathLogStoreDto.getStartNodeNo());
        dbManager.setString(6,swfPathLogStoreDto.getStartNodeName());
        dbManager.setInt(7,swfPathLogStoreDto.getEndNodeNo());
        dbManager.setString(8,swfPathLogStoreDto.getEndNodeName());
        dbManager.setDateTime(9,swfPathLogStoreDto.getFlowInTime());
        dbManager.setString(10,swfPathLogStoreDto.getFlag());
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
        buffer.append("INSERT INTO SwfPathLogStore (");
        buffer.append("flowID,");
        buffer.append("pathNo,");
        buffer.append("modelNo,");
        buffer.append("pathName,");
        buffer.append("startNodeNo,");
        buffer.append("startNodeName,");
        buffer.append("endNodeNo,");
        buffer.append("endNodeName,");
        buffer.append("flowInTime,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfPathLogStoreDto swfPathLogStoreDto = (SwfPathLogStoreDto)i.next();
            dbManager.setString(1,swfPathLogStoreDto.getFlowID());
            dbManager.setInt(2,swfPathLogStoreDto.getPathNo());
            dbManager.setInt(3,swfPathLogStoreDto.getModelNo());
            dbManager.setString(4,swfPathLogStoreDto.getPathName());
            dbManager.setInt(5,swfPathLogStoreDto.getStartNodeNo());
            dbManager.setString(6,swfPathLogStoreDto.getStartNodeName());
            dbManager.setInt(7,swfPathLogStoreDto.getEndNodeNo());
            dbManager.setString(8,swfPathLogStoreDto.getEndNodeName());
            dbManager.setDateTime(9,swfPathLogStoreDto.getFlowInTime());
            dbManager.setString(10,swfPathLogStoreDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(String flowID)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM SwfPathLogStore ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @throws Exception
     */
    public void update(SwfPathLogStoreDto swfPathLogStoreDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE SwfPathLogStore SET ");
        buffer.append("pathNo = ?, ");
        buffer.append("modelNo = ?, ");
        buffer.append("pathName = ?, ");
        buffer.append("startNodeNo = ?, ");
        buffer.append("startNodeName = ?, ");
        buffer.append("endNodeNo = ?, ");
        buffer.append("endNodeName = ?, ");
        buffer.append("flowInTime = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE SwfPathLogStore SET ");
            debugBuffer.append("pathNo = " + swfPathLogStoreDto.getPathNo() + ", ");
            debugBuffer.append("modelNo = " + swfPathLogStoreDto.getModelNo() + ", ");
            debugBuffer.append("pathName = '" + swfPathLogStoreDto.getPathName() + "', ");
            debugBuffer.append("startNodeNo = " + swfPathLogStoreDto.getStartNodeNo() + ", ");
            debugBuffer.append("startNodeName = '" + swfPathLogStoreDto.getStartNodeName() + "', ");
            debugBuffer.append("endNodeNo = " + swfPathLogStoreDto.getEndNodeNo() + ", ");
            debugBuffer.append("endNodeName = '" + swfPathLogStoreDto.getEndNodeName() + "', ");
            debugBuffer.append("flowInTime = '" + swfPathLogStoreDto.getFlowInTime() + "', ");
            debugBuffer.append("flag = '" + swfPathLogStoreDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(swfPathLogStoreDto.getFlowID()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,swfPathLogStoreDto.getPathNo());
        dbManager.setInt(2,swfPathLogStoreDto.getModelNo());
        dbManager.setString(3,swfPathLogStoreDto.getPathName());
        dbManager.setInt(4,swfPathLogStoreDto.getStartNodeNo());
        dbManager.setString(5,swfPathLogStoreDto.getStartNodeName());
        dbManager.setInt(6,swfPathLogStoreDto.getEndNodeNo());
        dbManager.setString(7,swfPathLogStoreDto.getEndNodeName());
        dbManager.setDateTime(8,swfPathLogStoreDto.getFlowInTime());
        dbManager.setString(9,swfPathLogStoreDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,swfPathLogStoreDto.getFlowID());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param flowID flowID
     * @return SwfPathLogStoreDto
     * @throws Exception
     */
    public SwfPathLogStoreDto findByPrimaryKey(String flowID)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("flowID,");
        buffer.append("pathNo,");
        buffer.append("modelNo,");
        buffer.append("pathName,");
        buffer.append("startNodeNo,");
        buffer.append("startNodeName,");
        buffer.append("endNodeNo,");
        buffer.append("endNodeName,");
        buffer.append("flowInTime,");
        buffer.append("flag ");
        buffer.append("FROM SwfPathLogStore ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,flowID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        SwfPathLogStoreDto swfPathLogStoreDto = null;
        if(resultSet.next()){
            swfPathLogStoreDto = new SwfPathLogStoreDto();
            swfPathLogStoreDto.setFlowID(dbManager.getString(resultSet,1));
            swfPathLogStoreDto.setPathNo(dbManager.getInt(resultSet,2));
            swfPathLogStoreDto.setModelNo(dbManager.getInt(resultSet,3));
            swfPathLogStoreDto.setPathName(dbManager.getString(resultSet,4));
            swfPathLogStoreDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathLogStoreDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathLogStoreDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathLogStoreDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathLogStoreDto.setFlowInTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            swfPathLogStoreDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return swfPathLogStoreDto;
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
        buffer.append("flowID,");
        buffer.append("pathNo,");
        buffer.append("modelNo,");
        buffer.append("pathName,");
        buffer.append("startNodeNo,");
        buffer.append("startNodeName,");
        buffer.append("endNodeNo,");
        buffer.append("endNodeName,");
        buffer.append("flowInTime,");
        buffer.append("flag ");
        buffer.append("FROM SwfPathLogStore WHERE ");
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
        SwfPathLogStoreDto swfPathLogStoreDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            swfPathLogStoreDto = new SwfPathLogStoreDto();
            swfPathLogStoreDto.setFlowID(dbManager.getString(resultSet,1));
            swfPathLogStoreDto.setPathNo(dbManager.getInt(resultSet,2));
            swfPathLogStoreDto.setModelNo(dbManager.getInt(resultSet,3));
            swfPathLogStoreDto.setPathName(dbManager.getString(resultSet,4));
            swfPathLogStoreDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathLogStoreDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathLogStoreDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathLogStoreDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathLogStoreDto.setFlowInTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            swfPathLogStoreDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(swfPathLogStoreDto);
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
        buffer.append("DELETE FROM SwfPathLogStore WHERE ");
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
       String statement ;
        statement = "SELECT count(1) FROM SwfPathLogStore WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
}
