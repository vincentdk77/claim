package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfNode�������ڵ㶨��������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfNodeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfNodeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfNodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void insert(SwfNodeDto swfNodeDto) throws Exception{
        String mainStatement = " Insert Into SwfNode (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " TimeLimit," + 
                           " EndFlag," + 
                           " Criterion," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " PosX," + 
                           " PosY)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + swfNodeDto.getModelNo() + "," + 
                           "'" + swfNodeDto.getModelName() + "'," + 
                           "" + swfNodeDto.getNodeNo() + "," + 
                           "'" + swfNodeDto.getNodeName() + "'," + 
                           "" + swfNodeDto.getTimeLimit() + "," + 
                           "'" + swfNodeDto.getEndFlag() + "'," + 
                           "'" + swfNodeDto.getCriterion() + "'," + 
                           "'" + swfNodeDto.getFlag() + "'," + 
                           "" + swfNodeDto.getTaskNo() + "," + 
                           "'" + swfNodeDto.getTaskType() + "'," + 
                           "'" + swfNodeDto.getNodeType() + "'," + 
                           "'" + swfNodeDto.getUnitCode() + "'," + 
                           "'" + swfNodeDto.getUnitName() + "'," + 
                           "'" + swfNodeDto.getHandlerCode() + "'," + 
                           "'" + swfNodeDto.getHandlerName() + "'," + 
                           "" + swfNodeDto.getPosX() + "," + 
                           "" + swfNodeDto.getPosY() + ")";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,swfNodeDto.getModelNo());
        dbManager.setString(2,swfNodeDto.getModelName());
        dbManager.setInt(3,swfNodeDto.getNodeNo());
        dbManager.setString(4,swfNodeDto.getNodeName());
        dbManager.setInt(5,swfNodeDto.getTimeLimit());
        dbManager.setString(6,swfNodeDto.getEndFlag());
        dbManager.setString(7,swfNodeDto.getCriterion());
        dbManager.setString(8,swfNodeDto.getFlag());
        dbManager.setInt(9,swfNodeDto.getTaskNo());
        dbManager.setString(10,swfNodeDto.getTaskType());
        dbManager.setString(11,swfNodeDto.getNodeType());
        dbManager.setString(12,swfNodeDto.getUnitCode());
        dbManager.setString(13,swfNodeDto.getUnitName());
        dbManager.setString(14,swfNodeDto.getHandlerCode());
        dbManager.setString(15,swfNodeDto.getHandlerName());
        dbManager.setInt(16,swfNodeDto.getPosX());
        dbManager.setInt(17,swfNodeDto.getPosY());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfNodeBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfNode (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " TimeLimit," + 
                           " EndFlag," + 
                           " Criterion," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " PosX," + 
                           " PosY)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfNodeDto swfNodeDto = (SwfNodeDto)i.next();
            dbManager.setInt(1,swfNodeDto.getModelNo());
            dbManager.setString(2,swfNodeDto.getModelName());
            dbManager.setInt(3,swfNodeDto.getNodeNo());
            dbManager.setString(4,swfNodeDto.getNodeName());
            dbManager.setInt(5,swfNodeDto.getTimeLimit());
            dbManager.setString(6,swfNodeDto.getEndFlag());
            dbManager.setString(7,swfNodeDto.getCriterion());
            dbManager.setString(8,swfNodeDto.getFlag());
            dbManager.setInt(9,swfNodeDto.getTaskNo());
            dbManager.setString(10,swfNodeDto.getTaskType());
            dbManager.setString(11,swfNodeDto.getNodeType());
            dbManager.setString(12,swfNodeDto.getUnitCode());
            dbManager.setString(13,swfNodeDto.getUnitName());
            dbManager.setString(14,swfNodeDto.getHandlerCode());
            dbManager.setString(15,swfNodeDto.getHandlerName());
            dbManager.setInt(16,swfNodeDto.getPosX());
            dbManager.setInt(17,swfNodeDto.getPosY());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfNodeBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param modelNo ģ����
     * @param nodeNo �ڵ���
     * @throws Exception
     */
    public void delete(int modelNo,int nodeNo) throws Exception{
        String statement = " Delete From SwfNode" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfNode Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " NodeNo = " + nodeNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,nodeNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfNodeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void update(SwfNodeDto swfNodeDto) throws Exception{
        String statement = " Update SwfNode Set ModelName = ?," + 
                           " NodeName = ?," + 
                           " TimeLimit = ?," + 
                           " EndFlag = ?," + 
                           " Criterion = ?," + 
                           " Flag = ?," + 
                           " TaskNo = ?," + 
                           " TaskType = ?," + 
                           " NodeType = ?," + 
                           " UnitCode = ?," + 
                           " UnitName = ?," + 
                           " HandlerCode = ?," + 
                           " HandlerName = ?," + 
                           " PosX = ?," + 
                           " PosY = ?" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfNode Set " + 
                           " ModelNo = " + swfNodeDto.getModelNo() + "," + 
                           " ModelName = '" + swfNodeDto.getModelName() + "'," + 
                           " NodeNo = " + swfNodeDto.getNodeNo() + "," + 
                           " NodeName = '" + swfNodeDto.getNodeName() + "'," + 
                           " TimeLimit = " + swfNodeDto.getTimeLimit() + "," + 
                           " EndFlag = '" + swfNodeDto.getEndFlag() + "'," + 
                           " Criterion = '" + swfNodeDto.getCriterion() + "'," + 
                           " Flag = '" + swfNodeDto.getFlag() + "'," + 
                           " TaskNo = " + swfNodeDto.getTaskNo() + "," + 
                           " TaskType = '" + swfNodeDto.getTaskType() + "'," + 
                           " NodeType = '" + swfNodeDto.getNodeType() + "'," + 
                           " UnitCode = '" + swfNodeDto.getUnitCode() + "'," + 
                           " UnitName = '" + swfNodeDto.getUnitName() + "'," + 
                           " HandlerCode = '" + swfNodeDto.getHandlerCode() + "'," + 
                           " HandlerName = '" + swfNodeDto.getHandlerName() + "'," + 
                           " PosX = " + swfNodeDto.getPosX() + "," + 
                           " PosY = " + swfNodeDto.getPosY() + "" + 
			               " Where " +
                           " ModelNo = " + swfNodeDto.getModelNo() + " And " + 
                           " NodeNo = " + swfNodeDto.getNodeNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfNodeDto.getModelName());
        dbManager.setString(2,swfNodeDto.getNodeName());
        dbManager.setInt(3,swfNodeDto.getTimeLimit());
        dbManager.setString(4,swfNodeDto.getEndFlag());
        dbManager.setString(5,swfNodeDto.getCriterion());
        dbManager.setString(6,swfNodeDto.getFlag());
        dbManager.setInt(7,swfNodeDto.getTaskNo());
        dbManager.setString(8,swfNodeDto.getTaskType());
        dbManager.setString(9,swfNodeDto.getNodeType());
        dbManager.setString(10,swfNodeDto.getUnitCode());
        dbManager.setString(11,swfNodeDto.getUnitName());
        dbManager.setString(12,swfNodeDto.getHandlerCode());
        dbManager.setString(13,swfNodeDto.getHandlerName());
        dbManager.setInt(14,swfNodeDto.getPosX());
        dbManager.setInt(15,swfNodeDto.getPosY());
        //���������ֶ�;
        dbManager.setInt(16,swfNodeDto.getModelNo());
        dbManager.setInt(17,swfNodeDto.getNodeNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfNodeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelNo ģ����
     * @param nodeNo �ڵ���
     * @return SwfNodeDto
     * @throws Exception
     */
    public SwfNodeDto findByPrimaryKey(int modelNo,int nodeNo) throws Exception{
        String mainStatement = " Select ModelNo," + 
                           " ModelName," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " TimeLimit," + 
                           " EndFlag," + 
                           " Criterion," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " PosX," + 
                           " PosY From SwfNode";
        String statement = mainStatement + " Where " +
                           " ModelNo = ? And " + 
                           " NodeNo = ?";
        SwfNodeDto swfNodeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " NodeNo = " + nodeNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,nodeNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfNodeDto = new SwfNodeDto();
            swfNodeDto.setModelNo(dbManager.getInt(resultSet,1));
            swfNodeDto.setModelName(dbManager.getString(resultSet,2));
            swfNodeDto.setNodeNo(dbManager.getInt(resultSet,3));
            swfNodeDto.setNodeName(dbManager.getString(resultSet,4));
            swfNodeDto.setTimeLimit(dbManager.getInt(resultSet,5));
            swfNodeDto.setEndFlag(dbManager.getString(resultSet,6));
            swfNodeDto.setCriterion(dbManager.getString(resultSet,7));
            swfNodeDto.setFlag(dbManager.getString(resultSet,8));
            swfNodeDto.setTaskNo(dbManager.getInt(resultSet,9));
            swfNodeDto.setTaskType(dbManager.getString(resultSet,10));
            swfNodeDto.setNodeType(dbManager.getString(resultSet,11));
            swfNodeDto.setUnitCode(dbManager.getString(resultSet,12));
            swfNodeDto.setUnitName(dbManager.getString(resultSet,13));
            swfNodeDto.setHandlerCode(dbManager.getString(resultSet,14));
            swfNodeDto.setHandlerName(dbManager.getString(resultSet,15));
            swfNodeDto.setPosX(dbManager.getInt(resultSet,16));
            swfNodeDto.setPosY(dbManager.getInt(resultSet,17));
            logger.info("DBSwfNodeBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfNodeBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfNodeDto;
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
                           " NodeNo," + 
                           " NodeName," + 
                           " TimeLimit," + 
                           " EndFlag," + 
                           " Criterion," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " UnitCode," + 
                           " UnitName," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " PosX," + 
                           " PosY From SwfNode Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfNodeDto swfNodeDto = null;
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

            swfNodeDto = new SwfNodeDto();
            swfNodeDto.setModelNo(dbManager.getInt(resultSet,1));
            swfNodeDto.setModelName(dbManager.getString(resultSet,2));
            swfNodeDto.setNodeNo(dbManager.getInt(resultSet,3));
            swfNodeDto.setNodeName(dbManager.getString(resultSet,4));
            swfNodeDto.setTimeLimit(dbManager.getInt(resultSet,5));
            swfNodeDto.setEndFlag(dbManager.getString(resultSet,6));
            swfNodeDto.setCriterion(dbManager.getString(resultSet,7));
            swfNodeDto.setFlag(dbManager.getString(resultSet,8));
            swfNodeDto.setTaskNo(dbManager.getInt(resultSet,9));
            swfNodeDto.setTaskType(dbManager.getString(resultSet,10));
            swfNodeDto.setNodeType(dbManager.getString(resultSet,11));
            swfNodeDto.setUnitCode(dbManager.getString(resultSet,12));
            swfNodeDto.setUnitName(dbManager.getString(resultSet,13));
            swfNodeDto.setHandlerCode(dbManager.getString(resultSet,14));
            swfNodeDto.setHandlerName(dbManager.getString(resultSet,15));
            swfNodeDto.setPosX(dbManager.getInt(resultSet,16));
            swfNodeDto.setPosY(dbManager.getInt(resultSet,17));
            collection.add(swfNodeDto);
        }
        resultSet.close();
        logger.info("DBSwfNodeBase.findByConditions() success!");
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
        String statement = "Delete From SwfNode Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfNodeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfNode Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfNodeBase.getCount() success!");
        return count;
    }
}
