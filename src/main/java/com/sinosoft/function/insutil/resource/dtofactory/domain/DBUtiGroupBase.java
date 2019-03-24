package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utigroup的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiGroupBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiGroupBase.class.getName());

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
        String statement = " Insert Into UtiGroup(" + 
                           " GroupCode," + 
                           " GroupName," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiGroupDto.getGroupCode());
        dbManager.setString(2,utiGroupDto.getGroupName());
        dbManager.setString(3,utiGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiGroupBase.insert() success!");
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
     * @param groupCode groupcode
     * @throws Exception
     */
    public void delete(String groupCode) throws Exception{
        String statement = " Delete From UtiGroup Where " +
                           " GroupCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiGroupBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(UtiGroupDto utiGroupDto) throws Exception{
        String statement = " Update UtiGroup Set GroupName = ?," + 
                           " Flag = ? Where " +
                           " GroupCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiGroupDto.getGroupName());
        dbManager.setString(2,utiGroupDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,utiGroupDto.getGroupCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiGroupBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param groupCode groupcode
     * @return UtiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(String groupCode) throws Exception{
        String statement = " Select GroupCode," + 
                           " GroupName," + 
                           " Flag From UtiGroup Where " +
                           " GroupCode = ?";
        UtiGroupDto utiGroupDto = null;
        log.debug(statement);
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
        log.info("DBUtiGroupBase.findByPrimaryKey() success!");
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
        log.debug(statement);
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
        log.info("DBUtiGroupBase.findByConditions() success!");
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
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiGroup Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiGroupBase.getCount() success!");
        return count;
    }
}
