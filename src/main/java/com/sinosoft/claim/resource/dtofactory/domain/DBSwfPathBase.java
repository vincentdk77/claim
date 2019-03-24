package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPath������·������������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfPathBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfPathBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPathBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void insert(SwfPathDto swfPathDto) throws Exception{
        String mainStatement = " Insert Into SwfPath (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " PathNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " Priority," + 
                           " DefaultFlag," + 
                           " Flag," + 
                           " ConditionStatus," + 
                           " ForwardServices," + 
                           " BackwardServices)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + swfPathDto.getModelNo() + "," + 
                           "'" + swfPathDto.getModelName() + "'," + 
                           "" + swfPathDto.getPathNo() + "," + 
                           "'" + swfPathDto.getPathName() + "'," + 
                           "" + swfPathDto.getStartNodeNo() + "," + 
                           "'" + swfPathDto.getStartNodeName() + "'," + 
                           "" + swfPathDto.getEndNodeNo() + "," + 
                           "'" + swfPathDto.getEndNodeName() + "'," + 
                           "" + swfPathDto.getPriority() + "," + 
                           "'" + swfPathDto.getDefaultFlag() + "'," + 
                           "'" + swfPathDto.getFlag() + "'," + 
                           "'" + swfPathDto.getConditionStatus() + "'," + 
                           "'" + swfPathDto.getForwardServices() + "'," + 
                           "'" + swfPathDto.getBackwardServices() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,swfPathDto.getModelNo());
        dbManager.setString(2,swfPathDto.getModelName());
        dbManager.setInt(3,swfPathDto.getPathNo());
        dbManager.setString(4,swfPathDto.getPathName());
        dbManager.setInt(5,swfPathDto.getStartNodeNo());
        dbManager.setString(6,swfPathDto.getStartNodeName());
        dbManager.setInt(7,swfPathDto.getEndNodeNo());
        dbManager.setString(8,swfPathDto.getEndNodeName());
        dbManager.setInt(9,swfPathDto.getPriority());
        dbManager.setString(10,swfPathDto.getDefaultFlag());
        dbManager.setString(11,swfPathDto.getFlag());
        dbManager.setString(12,swfPathDto.getConditionStatus());
        dbManager.setString(13,swfPathDto.getForwardServices());
        dbManager.setString(14,swfPathDto.getBackwardServices());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPathBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfPath (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " PathNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " Priority," + 
                           " DefaultFlag," + 
                           " Flag," + 
                           " ConditionStatus," + 
                           " ForwardServices," + 
                           " BackwardServices)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfPathDto swfPathDto = (SwfPathDto)i.next();
            dbManager.setInt(1,swfPathDto.getModelNo());
            dbManager.setString(2,swfPathDto.getModelName());
            dbManager.setInt(3,swfPathDto.getPathNo());
            dbManager.setString(4,swfPathDto.getPathName());
            dbManager.setInt(5,swfPathDto.getStartNodeNo());
            dbManager.setString(6,swfPathDto.getStartNodeName());
            dbManager.setInt(7,swfPathDto.getEndNodeNo());
            dbManager.setString(8,swfPathDto.getEndNodeName());
            dbManager.setInt(9,swfPathDto.getPriority());
            dbManager.setString(10,swfPathDto.getDefaultFlag());
            dbManager.setString(11,swfPathDto.getFlag());
            dbManager.setString(12,swfPathDto.getConditionStatus());
            dbManager.setString(13,swfPathDto.getForwardServices());
            dbManager.setString(14,swfPathDto.getBackwardServices());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfPathBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param modelNo ģ����
     * @param pathNo �̱ߺ�
     * @throws Exception
     */
    public void delete(int modelNo,int pathNo) throws Exception{
        String statement = " Delete From SwfPath" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfPath Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " PathNo = " + pathNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,pathNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfPathBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void update(SwfPathDto swfPathDto) throws Exception{
        String statement = " Update SwfPath Set ModelName = ?," + 
                           " PathName = ?," + 
                           " StartNodeNo = ?," + 
                           " StartNodeName = ?," + 
                           " EndNodeNo = ?," + 
                           " EndNodeName = ?," + 
                           " Priority = ?," + 
                           " DefaultFlag = ?," + 
                           " Flag = ?," + 
                           " ConditionStatus = ?," + 
                           " ForwardServices = ?," + 
                           " BackwardServices = ?" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfPath Set " + 
                           " ModelNo = " + swfPathDto.getModelNo() + "," + 
                           " ModelName = '" + swfPathDto.getModelName() + "'," + 
                           " PathNo = " + swfPathDto.getPathNo() + "," + 
                           " PathName = '" + swfPathDto.getPathName() + "'," + 
                           " StartNodeNo = " + swfPathDto.getStartNodeNo() + "," + 
                           " StartNodeName = '" + swfPathDto.getStartNodeName() + "'," + 
                           " EndNodeNo = " + swfPathDto.getEndNodeNo() + "," + 
                           " EndNodeName = '" + swfPathDto.getEndNodeName() + "'," + 
                           " Priority = " + swfPathDto.getPriority() + "," + 
                           " DefaultFlag = '" + swfPathDto.getDefaultFlag() + "'," + 
                           " Flag = '" + swfPathDto.getFlag() + "'," + 
                           " ConditionStatus = '" + swfPathDto.getConditionStatus() + "'," + 
                           " ForwardServices = '" + swfPathDto.getForwardServices() + "'," + 
                           " BackwardServices = '" + swfPathDto.getBackwardServices() + "'" + 
			               " Where " +
                           " ModelNo = " + swfPathDto.getModelNo() + " And " + 
                           " PathNo = " + swfPathDto.getPathNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfPathDto.getModelName());
        dbManager.setString(2,swfPathDto.getPathName());
        dbManager.setInt(3,swfPathDto.getStartNodeNo());
        dbManager.setString(4,swfPathDto.getStartNodeName());
        dbManager.setInt(5,swfPathDto.getEndNodeNo());
        dbManager.setString(6,swfPathDto.getEndNodeName());
        dbManager.setInt(7,swfPathDto.getPriority());
        dbManager.setString(8,swfPathDto.getDefaultFlag());
        dbManager.setString(9,swfPathDto.getFlag());
        dbManager.setString(10,swfPathDto.getConditionStatus());
        dbManager.setString(11,swfPathDto.getForwardServices());
        dbManager.setString(12,swfPathDto.getBackwardServices());
        //���������ֶ�;
        dbManager.setInt(13,swfPathDto.getModelNo());
        dbManager.setInt(14,swfPathDto.getPathNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPathBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelNo ģ����
     * @param pathNo �̱ߺ�
     * @return SwfPathDto
     * @throws Exception
     */
    public SwfPathDto findByPrimaryKey(int modelNo,int pathNo) throws Exception{
        String mainStatement = " Select ModelNo," + 
                           " ModelName," + 
                           " PathNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " Priority," + 
                           " DefaultFlag," + 
                           " Flag," + 
                           " ConditionStatus," + 
                           " ForwardServices," + 
                           " BackwardServices From SwfPath";
        String statement = mainStatement + " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ?";
        SwfPathDto swfPathDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " PathNo = " + pathNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,pathNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfPathDto = new SwfPathDto();
            swfPathDto.setModelNo(dbManager.getInt(resultSet,1));
            swfPathDto.setModelName(dbManager.getString(resultSet,2));
            swfPathDto.setPathNo(dbManager.getInt(resultSet,3));
            swfPathDto.setPathName(dbManager.getString(resultSet,4));
            swfPathDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathDto.setPriority(dbManager.getInt(resultSet,9));
            swfPathDto.setDefaultFlag(dbManager.getString(resultSet,10));
            swfPathDto.setFlag(dbManager.getString(resultSet,11));
            swfPathDto.setConditionStatus(dbManager.getString(resultSet,12));
            swfPathDto.setForwardServices(dbManager.getString(resultSet,13));
            swfPathDto.setBackwardServices(dbManager.getString(resultSet,14));
            logger.info("DBSwfPathBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfPathBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfPathDto;
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
        String statement = "Select ModelNo," + 
                           " ModelName," + 
                           " PathNo," + 
                           " PathName," + 
                           " StartNodeNo," + 
                           " StartNodeName," + 
                           " EndNodeNo," + 
                           " EndNodeName," + 
                           " Priority," + 
                           " DefaultFlag," + 
                           " Flag," + 
                           " ConditionStatus," + 
                           " ForwardServices," + 
                           " BackwardServices From SwfPath Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfPathDto swfPathDto = null;
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

            swfPathDto = new SwfPathDto();
            swfPathDto.setModelNo(dbManager.getInt(resultSet,1));
            swfPathDto.setModelName(dbManager.getString(resultSet,2));
            swfPathDto.setPathNo(dbManager.getInt(resultSet,3));
            swfPathDto.setPathName(dbManager.getString(resultSet,4));
            swfPathDto.setStartNodeNo(dbManager.getInt(resultSet,5));
            swfPathDto.setStartNodeName(dbManager.getString(resultSet,6));
            swfPathDto.setEndNodeNo(dbManager.getInt(resultSet,7));
            swfPathDto.setEndNodeName(dbManager.getString(resultSet,8));
            swfPathDto.setPriority(dbManager.getInt(resultSet,9));
            swfPathDto.setDefaultFlag(dbManager.getString(resultSet,10));
            swfPathDto.setFlag(dbManager.getString(resultSet,11));
            swfPathDto.setConditionStatus(dbManager.getString(resultSet,12));
            swfPathDto.setForwardServices(dbManager.getString(resultSet,13));
            swfPathDto.setBackwardServices(dbManager.getString(resultSet,14));
            collection.add(swfPathDto);
        }
        resultSet.close();
        logger.info("DBSwfPathBase.findByConditions() success!");
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
        String statement = "Delete From SwfPath Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfPathBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfPath Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfPathBase.getCount() success!");
        return count;
    }
}
