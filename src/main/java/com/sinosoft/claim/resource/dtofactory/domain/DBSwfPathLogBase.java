package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPathLog������·����־�������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfPathLogBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfPathLogBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPathLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void insert(SwfPathLogDto swfPathLogDto) throws Exception{
        String mainStatement = " Insert Into SwfPathLog (" + 
                           " FlowID," + 
                           " PathNo," + 
                           " ModelNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " FlowInTime," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + swfPathLogDto.getFlowID() + "'," + 
                           "" + swfPathLogDto.getPathNo() + "," + 
                           "" + swfPathLogDto.getModelNo() + "," + 
                           "'" + swfPathLogDto.getPathName() + "'," + 
                           "" + swfPathLogDto.getStartNodeNo() + "," + 
                           "'" + swfPathLogDto.getStartNodeName() + "'," + 
                           "" + swfPathLogDto.getEndNodeNo() + "," + 
                           "'" + swfPathLogDto.getEndNodeName() + "'," + 
                           "'" + swfPathLogDto.getFlowInTime() + "'," + 
                           "'" + swfPathLogDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,swfPathLogDto.getFlowID());
        dbManager.setInt(2,swfPathLogDto.getPathNo());
        dbManager.setInt(3,swfPathLogDto.getModelNo());
        dbManager.setString(4,swfPathLogDto.getPathName());
        dbManager.setInt(5,swfPathLogDto.getStartNodeNo());
        dbManager.setString(6,swfPathLogDto.getStartNodeName());
        dbManager.setInt(7,swfPathLogDto.getEndNodeNo());
        dbManager.setString(8,swfPathLogDto.getEndNodeName());
        dbManager.setDateTime(9,swfPathLogDto.getFlowInTime());
        dbManager.setString(10,swfPathLogDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPathLogBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfPathLog (" + 
                           " FlowID," + 
                           " PathNo," + 
                           " ModelNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " FlowInTime," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfPathLogDto swfPathLogDto = (SwfPathLogDto)i.next();
            dbManager.setString(1,swfPathLogDto.getFlowID());
            dbManager.setInt(2,swfPathLogDto.getPathNo());
            dbManager.setInt(3,swfPathLogDto.getModelNo());
            dbManager.setString(4,swfPathLogDto.getPathName());
            dbManager.setInt(5,swfPathLogDto.getStartNodeNo());
            dbManager.setString(6,swfPathLogDto.getStartNodeName());
            dbManager.setInt(7,swfPathLogDto.getEndNodeNo());
            dbManager.setString(8,swfPathLogDto.getEndNodeName());
            dbManager.setDateTime(9,swfPathLogDto.getFlowInTime());
            dbManager.setString(10,swfPathLogDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfPathLogBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param flowID ���̱��
     * @param pathNo ���̱ߺ�
     * @throws Exception
     */
    public void delete(String flowID,int pathNo) throws Exception{
        String statement = " Delete From SwfPathLog" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " PathNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfPathLog Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " PathNo = " + pathNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,pathNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfPathLogBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfPathLogDto swfPathLogDto
     * @throws Exception
     */
    public void update(SwfPathLogDto swfPathLogDto) throws Exception{
        String statement = " Update SwfPathLog Set ModelNo = ?," + 
                           " PathName = ?," + 
                           " StartNodeNo = ?," + 
                           " StartNodeName = ?," + 
                           " EndNodeNo = ?," + 
                           " EndNodeName = ?," + 
                           " FlowInTime = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " PathNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfPathLog Set " + 
                           " FlowID = '" + swfPathLogDto.getFlowID() + "'," + 
                           " PathNo = " + swfPathLogDto.getPathNo() + "," + 
                           " ModelNo = " + swfPathLogDto.getModelNo() + "," + 
                           " PathName = '" + swfPathLogDto.getPathName() + "'," + 
                           " StartNodeNo = " + swfPathLogDto.getStartNodeNo() + "," + 
                           " StartNodeName = '" + swfPathLogDto.getStartNodeName() + "'," + 
                           " EndNodeNo = " + swfPathLogDto.getEndNodeNo() + "," + 
                           " EndNodeName = '" + swfPathLogDto.getEndNodeName() + "'," + 
                           " FlowInTime = '" + swfPathLogDto.getFlowInTime() + "'," + 
                           " Flag = '" + swfPathLogDto.getFlag() + "'" + 
			               " Where " +
                           " FlowID = '" + swfPathLogDto.getFlowID() + "' And " + 
                           " PathNo = " + swfPathLogDto.getPathNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setInt(1,swfPathLogDto.getModelNo());
        dbManager.setString(2,swfPathLogDto.getPathName());
        dbManager.setInt(3,swfPathLogDto.getStartNodeNo());
        dbManager.setString(4,swfPathLogDto.getStartNodeName());
        dbManager.setInt(5,swfPathLogDto.getEndNodeNo());
        dbManager.setString(6,swfPathLogDto.getEndNodeName());
        dbManager.setDateTime(7,swfPathLogDto.getFlowInTime());
        dbManager.setString(8,swfPathLogDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,swfPathLogDto.getFlowID());
        dbManager.setInt(10,swfPathLogDto.getPathNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPathLogBase.update() success!");
    }

    /**
     * ����������һ������
     * @param flowID ���̱��
     * @param pathNo ���̱ߺ�
     * @return SwfPathLogDto
     * @throws Exception
     */
    public SwfPathLogDto findByPrimaryKey(String flowID,int pathNo) throws Exception{
        String mainStatement = " Select FlowID," + 
                           " PathNo," + 
                           " ModelNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " FlowInTime," + 
                           " Flag From SwfPathLog";
        String statement = mainStatement + " Where " +
                           " FlowID = ? And " + 
                           " PathNo = ?";
        SwfPathLogDto swfPathLogDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " PathNo = " + pathNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,pathNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfPathLogDto = new SwfPathLogDto();
            swfPathLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfPathLogDto.setPathNo(dbManager.getInt(resultSet,2));
            swfPathLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfPathLogDto.setPathName(dbManager.getString(resultSet,4));
            swfPathLogDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathLogDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathLogDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathLogDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathLogDto.setFlowInTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            swfPathLogDto.setFlag(dbManager.getString(resultSet,10));
            logger.info("DBSwfPathLogBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfPathLogBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfPathLogDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select FlowID," + 
                           " PathNo," + 
                           " ModelNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " FlowInTime," + 
                           " Flag From SwfPathLog Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfPathLogDto swfPathLogDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            swfPathLogDto = new SwfPathLogDto();
            swfPathLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfPathLogDto.setPathNo(dbManager.getInt(resultSet,2));
            swfPathLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfPathLogDto.setPathName(dbManager.getString(resultSet,4));
            swfPathLogDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathLogDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathLogDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathLogDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathLogDto.setFlowInTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            swfPathLogDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(swfPathLogDto);
        }
        resultSet.close();
        logger.info("DBSwfPathLogBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From SwfPathLog Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfPathLogBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfPathLog Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfPathLogBase.getCount() success!");
        return count;
    }
}
