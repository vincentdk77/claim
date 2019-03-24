package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiGroup  权限组号表的数据访问对象基类<br>
 * 创建于 2004-11-09 10:40:49.301<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiGroupBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBUtiGroupBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(UtiGroupDto utiGroupDto) throws Exception{
        String mainStatement = " Insert Into UtiGroup (" + 
                           " GroupCode," + 
                           " GroupName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + utiGroupDto.getGroupCode() + "'," + 
                           "'" + utiGroupDto.getGroupName() + "'," + 
                           "'" + utiGroupDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiGroupDto.getGroupCode());
        dbManager.setString(2,utiGroupDto.getGroupName());
        dbManager.setString(3,utiGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBUtiGroupBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiGroupDto utiGroupDto = (UtiGroupDto)i.next();
            insert(utiGroupDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param groupCode 权限组号代码
     * @throws Exception
     */
    public void delete(String groupCode) throws Exception{
        String statement = " Delete From UtiGroup" + 
	            		   " Where " +
                           " GroupCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From UtiGroup Where " +
                           " GroupCode = '" + groupCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupCode);
        dbManager.executePreparedUpdate();
        logger.info("DBUtiGroupBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(UtiGroupDto utiGroupDto) throws Exception{
        String statement = " Update UtiGroup Set GroupName = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " GroupCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update UtiGroup Set " + 
                           " GroupCode = '" + utiGroupDto.getGroupCode() + "'," + 
                           " GroupName = '" + utiGroupDto.getGroupName() + "'," + 
                           " Flag = '" + utiGroupDto.getFlag() + "'" + 
			               " Where " +
                           " GroupCode = '" + utiGroupDto.getGroupCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiGroupDto.getGroupName());
        dbManager.setString(2,utiGroupDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,utiGroupDto.getGroupCode());
        dbManager.executePreparedUpdate();

        logger.info("DBUtiGroupBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param groupCode 权限组号代码
     * @return UtiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(String groupCode) throws Exception{
        String mainStatement = " Select GroupCode," + 
                           " GroupName," + 
                           " Flag From UtiGroup";
        String statement = mainStatement + " Where " +
                           " GroupCode = ?";
        UtiGroupDto utiGroupDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " GroupCode = '" + groupCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiGroupDto = new UtiGroupDto();
            utiGroupDto.setGroupCode(dbManager.getString(resultSet,1));
            utiGroupDto.setGroupName(dbManager.getString(resultSet,2));
            utiGroupDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        logger.info("DBUtiGroupBase.findByPrimaryKey() success!");
        return utiGroupDto;
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
        String statement = "Select GroupCode," + 
                           " GroupName," + 
                           " Flag From UtiGroup Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        UtiGroupDto utiGroupDto = null;
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

            utiGroupDto = new UtiGroupDto();
            utiGroupDto.setGroupCode(dbManager.getString(resultSet,1));
            utiGroupDto.setGroupName(dbManager.getString(resultSet,2));
            utiGroupDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(utiGroupDto);
        }
        resultSet.close();
        logger.info("DBUtiGroupBase.findByConditions() success!");
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
        String statement = "Delete From UtiGroup Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBUtiGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiGroup Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBUtiGroupBase.getCount() success!");
        return count;
    }
}
