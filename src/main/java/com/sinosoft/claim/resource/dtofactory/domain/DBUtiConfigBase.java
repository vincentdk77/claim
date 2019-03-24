package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiConfigDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是uticonfig（无用数据表）的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiConfigBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiConfigBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiConfigBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void insert(UtiConfigDto utiConfigDto) throws Exception{
        String statement = " Insert Into UtiConfig(" + 
                           " Cfgid," + 
                           " Cfgoth," + 
                           " Cfgothmean," + 
                           " Cfgvalue," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiConfigDto.getCfgid());
        dbManager.setString(2,utiConfigDto.getCfgoth());
        dbManager.setString(3,utiConfigDto.getCfgothmean());
        dbManager.setString(4,utiConfigDto.getCfgvalue());
        dbManager.setString(5,utiConfigDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiConfigBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiConfigDto utiConfigDto = (UtiConfigDto)i.next();
            insert(utiConfigDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @throws Exception
     */
    public void delete(String cfgid,String cfgoth) throws Exception{
        String statement = " Delete From UtiConfig Where " +
                           " Cfgid = ? And " + 
                           " Cfgoth = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,cfgid);
        dbManager.setString(2,cfgoth);
        dbManager.executePreparedUpdate();
        log.info("DBUtiConfigBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void update(UtiConfigDto utiConfigDto) throws Exception{
        String statement = " Update UtiConfig Set Cfgothmean = ?," + 
                           " Cfgvalue = ?," + 
                           " Flag = ? Where " +
                           " Cfgid = ? And " + 
                           " Cfgoth = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiConfigDto.getCfgothmean());
        dbManager.setString(2,utiConfigDto.getCfgvalue());
        dbManager.setString(3,utiConfigDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,utiConfigDto.getCfgid());
        dbManager.setString(5,utiConfigDto.getCfgoth());
        dbManager.executePreparedUpdate();

        log.info("DBUtiConfigBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @return UtiConfigDto
     * @throws Exception
     */
    public UtiConfigDto findByPrimaryKey(String cfgid,String cfgoth) throws Exception{
        String statement = " Select Cfgid," + 
                           " Cfgoth," + 
                           " Cfgothmean," + 
                           " Cfgvalue," + 
                           " Flag From UtiConfig Where " +
                           " Cfgid = ? And " + 
                           " Cfgoth = ?";
        UtiConfigDto utiConfigDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,cfgid);
        dbManager.setString(2,cfgoth);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiConfigDto = new UtiConfigDto();
            utiConfigDto.setCfgid(dbManager.getString(resultSet,1));
            utiConfigDto.setCfgoth(dbManager.getString(resultSet,2));
            utiConfigDto.setCfgothmean(dbManager.getString(resultSet,3));
            utiConfigDto.setCfgvalue(dbManager.getString(resultSet,4));
            utiConfigDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBUtiConfigBase.findByPrimaryKey() success!");
        return utiConfigDto;
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
        String statement = "Select Cfgid," + 
                           " Cfgoth," + 
                           " Cfgothmean," + 
                           " Cfgvalue," + 
                           " Flag From UtiConfig Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiConfigDto utiConfigDto = null;
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

            utiConfigDto = new UtiConfigDto();
            utiConfigDto.setCfgid(dbManager.getString(resultSet,1));
            utiConfigDto.setCfgoth(dbManager.getString(resultSet,2));
            utiConfigDto.setCfgothmean(dbManager.getString(resultSet,3));
            utiConfigDto.setCfgvalue(dbManager.getString(resultSet,4));
            utiConfigDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(utiConfigDto);
        }
        resultSet.close();
        log.info("DBUtiConfigBase.findByConditions() success!");
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
        String statement = "Delete From UtiConfig Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiConfigBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiConfig Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiConfigBase.getCount() success!");
        return count;
    }
}
