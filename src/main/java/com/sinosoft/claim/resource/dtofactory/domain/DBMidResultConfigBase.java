package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的数据访问对象基类<br>
 * 创建于 2005-03-13 11:18:21.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBMidResultConfigBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBMidResultConfigBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMidResultConfigBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void insert(MidResultConfigDto midResultConfigDto) throws Exception{
        String mainStatement = " Insert Into MidResultConfig (" + 
                           " ConfigOwner," + 
                           " ResultType," + 
                           " ResultTypeName," + 
                           " ItemNo," + 
                           " ItemTable," + 
                           " ItemColumn," + 
                           " ItemColumnName," + 
                           " DataType," + 
                           " ColumnType," + 
                           " GroupFlag," + 
                           " OrderType," + 
                           " SelectFlag," + 
                           " ShowStatus," + 
                           " ShowAlign," + 
                           " ShowWidth," + 
                           " LinkFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + midResultConfigDto.getConfigOwner() + "'," + 
                           "'" + midResultConfigDto.getResultType() + "'," + 
                           "'" + midResultConfigDto.getResultTypeName() + "'," + 
                           "" + midResultConfigDto.getItemNo() + "," + 
                           "'" + midResultConfigDto.getItemTable() + "'," + 
                           "'" + midResultConfigDto.getItemColumn() + "'," + 
                           "'" + midResultConfigDto.getItemColumnName() + "'," + 
                           "'" + midResultConfigDto.getDataType() + "'," + 
                           "'" + midResultConfigDto.getColumnType() + "'," + 
                           "'" + midResultConfigDto.getGroupFlag() + "'," + 
                           "'" + midResultConfigDto.getOrderType() + "'," + 
                           "'" + midResultConfigDto.getSelectFlag() + "'," + 
                           "'" + midResultConfigDto.getShowStatus() + "'," + 
                           "'" + midResultConfigDto.getShowAlign() + "'," + 
                           "" + midResultConfigDto.getShowWidth() + "," + 
                           "'" + midResultConfigDto.getLinkFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,midResultConfigDto.getConfigOwner());
        dbManager.setString(2,midResultConfigDto.getResultType());
        dbManager.setString(3,midResultConfigDto.getResultTypeName());
        dbManager.setInt(4,midResultConfigDto.getItemNo());
        dbManager.setString(5,midResultConfigDto.getItemTable());
        dbManager.setString(6,midResultConfigDto.getItemColumn());
        dbManager.setString(7,midResultConfigDto.getItemColumnName());
        dbManager.setString(8,midResultConfigDto.getDataType());
        dbManager.setString(9,midResultConfigDto.getColumnType());
        dbManager.setString(10,midResultConfigDto.getGroupFlag());
        dbManager.setString(11,midResultConfigDto.getOrderType());
        dbManager.setString(12,midResultConfigDto.getSelectFlag());
        dbManager.setString(13,midResultConfigDto.getShowStatus());
        dbManager.setString(14,midResultConfigDto.getShowAlign());
        dbManager.setInt(15,midResultConfigDto.getShowWidth());
        dbManager.setString(16,midResultConfigDto.getLinkFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBMidResultConfigBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into MidResultConfig (" + 
                           " ConfigOwner," + 
                           " ResultType," + 
                           " ResultTypeName," + 
                           " ItemNo," + 
                           " ItemTable," + 
                           " ItemColumn," + 
                           " ItemColumnName," + 
                           " DataType," + 
                           " ColumnType," + 
                           " GroupFlag," + 
                           " OrderType," + 
                           " SelectFlag," + 
                           " ShowStatus," + 
                           " ShowAlign," + 
                           " ShowWidth," + 
                           " LinkFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            MidResultConfigDto midResultConfigDto = (MidResultConfigDto)i.next();
            dbManager.setString(1,midResultConfigDto.getConfigOwner());
            dbManager.setString(2,midResultConfigDto.getResultType());
            dbManager.setString(3,midResultConfigDto.getResultTypeName());
            dbManager.setInt(4,midResultConfigDto.getItemNo());
            dbManager.setString(5,midResultConfigDto.getItemTable());
            dbManager.setString(6,midResultConfigDto.getItemColumn());
            dbManager.setString(7,midResultConfigDto.getItemColumnName());
            dbManager.setString(8,midResultConfigDto.getDataType());
            dbManager.setString(9,midResultConfigDto.getColumnType());
            dbManager.setString(10,midResultConfigDto.getGroupFlag());
            dbManager.setString(11,midResultConfigDto.getOrderType());
            dbManager.setString(12,midResultConfigDto.getSelectFlag());
            dbManager.setString(13,midResultConfigDto.getShowStatus());
            dbManager.setString(14,midResultConfigDto.getShowAlign());
            dbManager.setInt(15,midResultConfigDto.getShowWidth());
            dbManager.setString(16,midResultConfigDto.getLinkFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBMidResultConfigBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @throws Exception
     */
    public void delete(String configOwner,String resultType,int itemNo) throws Exception{
        String statement = " Delete From MidResultConfig" + 
	            		   " Where " +
                           " ConfigOwner = ? And " + 
                           " ResultType = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From MidResultConfig Where " +
                           " ConfigOwner = '" + configOwner + "' And " + 
                           " ResultType = '" + resultType + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,configOwner);
        dbManager.setString(2,resultType);
        dbManager.setInt(3,itemNo);
        dbManager.executePreparedUpdate();
        logger.info("DBMidResultConfigBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void update(MidResultConfigDto midResultConfigDto) throws Exception{
        String statement = " Update MidResultConfig Set ResultTypeName = ?," + 
                           " ItemTable = ?," + 
                           " ItemColumn = ?," + 
                           " ItemColumnName = ?," + 
                           " DataType = ?," + 
                           " ColumnType = ?," + 
                           " GroupFlag = ?," + 
                           " OrderType = ?," + 
                           " SelectFlag = ?," + 
                           " ShowStatus = ?," + 
                           " ShowAlign = ?," + 
                           " ShowWidth = ?," + 
                           " LinkFlag = ?" + 
	            		   " Where " +
                           " ConfigOwner = ? And " + 
                           " ResultType = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update MidResultConfig Set " + 
                           " ConfigOwner = '" + midResultConfigDto.getConfigOwner() + "'," + 
                           " ResultType = '" + midResultConfigDto.getResultType() + "'," + 
                           " ResultTypeName = '" + midResultConfigDto.getResultTypeName() + "'," + 
                           " ItemNo = " + midResultConfigDto.getItemNo() + "," + 
                           " ItemTable = '" + midResultConfigDto.getItemTable() + "'," + 
                           " ItemColumn = '" + midResultConfigDto.getItemColumn() + "'," + 
                           " ItemColumnName = '" + midResultConfigDto.getItemColumnName() + "'," + 
                           " DataType = '" + midResultConfigDto.getDataType() + "'," + 
                           " ColumnType = '" + midResultConfigDto.getColumnType() + "'," + 
                           " GroupFlag = '" + midResultConfigDto.getGroupFlag() + "'," + 
                           " OrderType = '" + midResultConfigDto.getOrderType() + "'," + 
                           " SelectFlag = '" + midResultConfigDto.getSelectFlag() + "'," + 
                           " ShowStatus = '" + midResultConfigDto.getShowStatus() + "'," + 
                           " ShowAlign = '" + midResultConfigDto.getShowAlign() + "'," + 
                           " ShowWidth = " + midResultConfigDto.getShowWidth() + "," + 
                           " LinkFlag = '" + midResultConfigDto.getLinkFlag() + "'" + 
			               " Where " +
                           " ConfigOwner = '" + midResultConfigDto.getConfigOwner() + "' And " + 
                           " ResultType = '" + midResultConfigDto.getResultType() + "' And " + 
                           " ItemNo = " + midResultConfigDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,midResultConfigDto.getResultTypeName());
        dbManager.setString(2,midResultConfigDto.getItemTable());
        dbManager.setString(3,midResultConfigDto.getItemColumn());
        dbManager.setString(4,midResultConfigDto.getItemColumnName());
        dbManager.setString(5,midResultConfigDto.getDataType());
        dbManager.setString(6,midResultConfigDto.getColumnType());
        dbManager.setString(7,midResultConfigDto.getGroupFlag());
        dbManager.setString(8,midResultConfigDto.getOrderType());
        dbManager.setString(9,midResultConfigDto.getSelectFlag());
        dbManager.setString(10,midResultConfigDto.getShowStatus());
        dbManager.setString(11,midResultConfigDto.getShowAlign());
        dbManager.setInt(12,midResultConfigDto.getShowWidth());
        dbManager.setString(13,midResultConfigDto.getLinkFlag());
        //设置条件字段;
        dbManager.setString(14,midResultConfigDto.getConfigOwner());
        dbManager.setString(15,midResultConfigDto.getResultType());
        dbManager.setInt(16,midResultConfigDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBMidResultConfigBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @return MidResultConfigDto
     * @throws Exception
     */
    public MidResultConfigDto findByPrimaryKey(String configOwner,String resultType,int itemNo) throws Exception{
        String mainStatement = " Select ConfigOwner," + 
                           " ResultType," + 
                           " ResultTypeName," + 
                           " ItemNo," + 
                           " ItemTable," + 
                           " ItemColumn," + 
                           " ItemColumnName," + 
                           " DataType," + 
                           " ColumnType," + 
                           " GroupFlag," + 
                           " OrderType," + 
                           " SelectFlag," + 
                           " ShowStatus," + 
                           " ShowAlign," + 
                           " ShowWidth," + 
                           " LinkFlag From MidResultConfig";
        String statement = mainStatement + " Where " +
                           " ConfigOwner = ? And " + 
                           " ResultType = ? And " + 
                           " ItemNo = ?";
        MidResultConfigDto midResultConfigDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ConfigOwner = '" + configOwner + "' And " + 
                           " ResultType = '" + resultType + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,configOwner);
        dbManager.setString(2,resultType);
        dbManager.setInt(3,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            midResultConfigDto = new MidResultConfigDto();
            midResultConfigDto.setConfigOwner(dbManager.getString(resultSet,1));
            midResultConfigDto.setResultType(dbManager.getString(resultSet,2));
            midResultConfigDto.setResultTypeName(dbManager.getString(resultSet,3));
            midResultConfigDto.setItemNo(dbManager.getInt(resultSet,4));
            midResultConfigDto.setItemTable(dbManager.getString(resultSet,5));
            midResultConfigDto.setItemColumn(dbManager.getString(resultSet,6));
            midResultConfigDto.setItemColumnName(dbManager.getString(resultSet,7));
            midResultConfigDto.setDataType(dbManager.getString(resultSet,8));
            midResultConfigDto.setColumnType(dbManager.getString(resultSet,9));
            midResultConfigDto.setGroupFlag(dbManager.getString(resultSet,10));
            midResultConfigDto.setOrderType(dbManager.getString(resultSet,11));
            midResultConfigDto.setSelectFlag(dbManager.getString(resultSet,12));
            midResultConfigDto.setShowStatus(dbManager.getString(resultSet,13));
            midResultConfigDto.setShowAlign(dbManager.getString(resultSet,14));
            midResultConfigDto.setShowWidth(dbManager.getInt(resultSet,15));
            midResultConfigDto.setLinkFlag(dbManager.getString(resultSet,16));
            logger.info("DBMidResultConfigBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBMidResultConfigBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return midResultConfigDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ConfigOwner," + 
                           " ResultType," + 
                           " ResultTypeName," + 
                           " ItemNo," + 
                           " ItemTable," + 
                           " ItemColumn," + 
                           " ItemColumnName," + 
                           " DataType," + 
                           " ColumnType," + 
                           " GroupFlag," + 
                           " OrderType," + 
                           " SelectFlag," + 
                           " ShowStatus," + 
                           " ShowAlign," + 
                           " ShowWidth," + 
                           " LinkFlag From MidResultConfig Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        MidResultConfigDto midResultConfigDto = null;
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

            midResultConfigDto = new MidResultConfigDto();
            midResultConfigDto.setConfigOwner(dbManager.getString(resultSet,1));
            midResultConfigDto.setResultType(dbManager.getString(resultSet,2));
            midResultConfigDto.setResultTypeName(dbManager.getString(resultSet,3));
            midResultConfigDto.setItemNo(dbManager.getInt(resultSet,4));
            midResultConfigDto.setItemTable(dbManager.getString(resultSet,5));
            midResultConfigDto.setItemColumn(dbManager.getString(resultSet,6));
            midResultConfigDto.setItemColumnName(dbManager.getString(resultSet,7));
            midResultConfigDto.setDataType(dbManager.getString(resultSet,8));
            midResultConfigDto.setColumnType(dbManager.getString(resultSet,9));
            midResultConfigDto.setGroupFlag(dbManager.getString(resultSet,10));
            midResultConfigDto.setOrderType(dbManager.getString(resultSet,11));
            midResultConfigDto.setSelectFlag(dbManager.getString(resultSet,12));
            midResultConfigDto.setShowStatus(dbManager.getString(resultSet,13));
            midResultConfigDto.setShowAlign(dbManager.getString(resultSet,14));
            midResultConfigDto.setShowWidth(dbManager.getInt(resultSet,15));
            midResultConfigDto.setLinkFlag(dbManager.getString(resultSet,16));
            collection.add(midResultConfigDto);
        }
        resultSet.close();
        logger.info("DBMidResultConfigBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From MidResultConfig Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBMidResultConfigBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from MidResultConfig Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBMidResultConfigBase.getCount() success!");
        return count;
    }
}
