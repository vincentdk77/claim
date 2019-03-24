package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleObject-���ȶ��������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleObjectBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLscheduleObjectBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleObjectBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void insert(PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleObject (" + 
                           " Flag," + 
                           " ObjectGroup," + 
                           " ObjectArea," + 
                           " ObjectTable," + 
                           " ObjectKey," + 
                           " ObjectType," + 
                           " ScheduleObjectName," + 
                           " ScheduleObjectID)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLscheduleObjectDto.getFlag() + "'," + 
                           "" + prpLscheduleObjectDto.getObjectGroup() + "," + 
                           "'" + prpLscheduleObjectDto.getObjectArea() + "'," + 
                           "'" + prpLscheduleObjectDto.getObjectTable() + "'," + 
                           "'" + prpLscheduleObjectDto.getObjectKey() + "'," + 
                           "'" + prpLscheduleObjectDto.getObjectType() + "'," + 
                           "'" + prpLscheduleObjectDto.getScheduleObjectName() + "'," + 
                           "'" + prpLscheduleObjectDto.getScheduleObjectID() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLscheduleObjectDto.getFlag());
        dbManager.setInt(2,prpLscheduleObjectDto.getObjectGroup());
        dbManager.setString(3,prpLscheduleObjectDto.getObjectArea());
        dbManager.setString(4,prpLscheduleObjectDto.getObjectTable());
        dbManager.setString(5,prpLscheduleObjectDto.getObjectKey());
        dbManager.setString(6,prpLscheduleObjectDto.getObjectType());
        dbManager.setString(7,prpLscheduleObjectDto.getScheduleObjectName());
        dbManager.setString(8,prpLscheduleObjectDto.getScheduleObjectID());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleObjectBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleObject (" + 
                           " Flag," + 
                           " ObjectGroup," + 
                           " ObjectArea," + 
                           " ObjectTable," + 
                           " ObjectKey," + 
                           " ObjectType," + 
                           " ScheduleObjectName," + 
                           " ScheduleObjectID)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLscheduleObjectDto prpLscheduleObjectDto = (PrpLscheduleObjectDto)i.next();
            dbManager.setString(1,prpLscheduleObjectDto.getFlag());
            dbManager.setInt(2,prpLscheduleObjectDto.getObjectGroup());
            dbManager.setString(3,prpLscheduleObjectDto.getObjectArea());
            dbManager.setString(4,prpLscheduleObjectDto.getObjectTable());
            dbManager.setString(5,prpLscheduleObjectDto.getObjectKey());
            dbManager.setString(6,prpLscheduleObjectDto.getObjectType());
            dbManager.setString(7,prpLscheduleObjectDto.getScheduleObjectName());
            dbManager.setString(8,prpLscheduleObjectDto.getScheduleObjectID());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLscheduleObjectBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param scheduleObjectID ���ȶ������
     * @throws Exception
     */
    public void delete(String scheduleObjectID) throws Exception{
        String statement = " Delete From PrpLscheduleObject" + 
	            		   " Where " +
                           " ScheduleObjectID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleObject Where " +
                           " ScheduleObjectID = '" + scheduleObjectID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,scheduleObjectID);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleObjectBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void update(PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        String statement = " Update PrpLscheduleObject Set Flag = ?," + 
                           " ObjectGroup = ?," + 
                           " ObjectArea = ?," + 
                           " ObjectTable = ?," + 
                           " ObjectKey = ?," + 
                           " ObjectType = ?," + 
                           " ScheduleObjectName = ?" + 
	            		   " Where " +
                           " ScheduleObjectID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleObject Set " + 
                           " Flag = '" + prpLscheduleObjectDto.getFlag() + "'," + 
                           " ObjectGroup = " + prpLscheduleObjectDto.getObjectGroup() + "," + 
                           " ObjectArea = '" + prpLscheduleObjectDto.getObjectArea() + "'," + 
                           " ObjectTable = '" + prpLscheduleObjectDto.getObjectTable() + "'," + 
                           " ObjectKey = '" + prpLscheduleObjectDto.getObjectKey() + "'," + 
                           " ObjectType = '" + prpLscheduleObjectDto.getObjectType() + "'," + 
                           " ScheduleObjectName = '" + prpLscheduleObjectDto.getScheduleObjectName() + "'," + 
                           " ScheduleObjectID = '" + prpLscheduleObjectDto.getScheduleObjectID() + "'" + 
			               " Where " +
                           " ScheduleObjectID = '" + prpLscheduleObjectDto.getScheduleObjectID() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLscheduleObjectDto.getFlag());
        dbManager.setInt(2,prpLscheduleObjectDto.getObjectGroup());
        dbManager.setString(3,prpLscheduleObjectDto.getObjectArea());
        dbManager.setString(4,prpLscheduleObjectDto.getObjectTable());
        dbManager.setString(5,prpLscheduleObjectDto.getObjectKey());
        dbManager.setString(6,prpLscheduleObjectDto.getObjectType());
        dbManager.setString(7,prpLscheduleObjectDto.getScheduleObjectName());
        //���������ֶ�;
        dbManager.setString(8,prpLscheduleObjectDto.getScheduleObjectID());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleObjectBase.update() success!");
    }

    /**
     * ����������һ������
     * @param scheduleObjectID ���ȶ������
     * @return PrpLscheduleObjectDto
     * @throws Exception
     */
    public PrpLscheduleObjectDto findByPrimaryKey(String scheduleObjectID) throws Exception{
        String mainStatement = " Select Flag," + 
                           " ObjectGroup," + 
                           " ObjectArea," + 
                           " ObjectTable," + 
                           " ObjectKey," + 
                           " ObjectType," + 
                           " ScheduleObjectName," + 
                           " ScheduleObjectID From PrpLscheduleObject";
        String statement = mainStatement + " Where " +
                           " ScheduleObjectID = ?";
        PrpLscheduleObjectDto prpLscheduleObjectDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ScheduleObjectID = '" + scheduleObjectID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,scheduleObjectID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLscheduleObjectDto = new PrpLscheduleObjectDto();
            prpLscheduleObjectDto.setFlag(dbManager.getString(resultSet,1));
            prpLscheduleObjectDto.setObjectGroup(dbManager.getInt(resultSet,2));
            prpLscheduleObjectDto.setObjectArea(dbManager.getString(resultSet,3));
            prpLscheduleObjectDto.setObjectTable(dbManager.getString(resultSet,4));
            prpLscheduleObjectDto.setObjectKey(dbManager.getString(resultSet,5));
            prpLscheduleObjectDto.setObjectType(dbManager.getString(resultSet,6));
            prpLscheduleObjectDto.setScheduleObjectName(dbManager.getString(resultSet,7));
            prpLscheduleObjectDto.setScheduleObjectID(dbManager.getString(resultSet,8));
            logger.info("DBPrpLscheduleObjectBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLscheduleObjectBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLscheduleObjectDto;
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
        String statement = "Select Flag," + 
                           " ObjectGroup," + 
                           " ObjectArea," + 
                           " ObjectTable," + 
                           " ObjectKey," + 
                           " ObjectType," + 
                           " ScheduleObjectName," + 
                           " ScheduleObjectID From PrpLscheduleObject Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleObjectDto prpLscheduleObjectDto = null;
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

            prpLscheduleObjectDto = new PrpLscheduleObjectDto();
            prpLscheduleObjectDto.setFlag(dbManager.getString(resultSet,1));
            prpLscheduleObjectDto.setObjectGroup(dbManager.getInt(resultSet,2));
            prpLscheduleObjectDto.setObjectArea(dbManager.getString(resultSet,3));
            prpLscheduleObjectDto.setObjectTable(dbManager.getString(resultSet,4));
            prpLscheduleObjectDto.setObjectKey(dbManager.getString(resultSet,5));
            prpLscheduleObjectDto.setObjectType(dbManager.getString(resultSet,6));
            prpLscheduleObjectDto.setScheduleObjectName(dbManager.getString(resultSet,7));
            prpLscheduleObjectDto.setScheduleObjectID(dbManager.getString(resultSet,8));
            collection.add(prpLscheduleObjectDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleObjectBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleObject Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleObjectBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleObject Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleObjectBase.getCount() success!");
        return count;
    }
}
