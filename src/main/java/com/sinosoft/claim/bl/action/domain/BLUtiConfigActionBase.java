package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiConfigDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是uticonfig（无用数据表）的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiConfigActionBase{
    private static Log log = LogFactory.getLog(BLUtiConfigActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiConfigActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiConfigDto utiConfigDto) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //插入记录
        dbUtiConfig.insert(utiConfigDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @throws Exception
     */
    public void delete(DBManager dbManager,String cfgid,String cfgoth) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //删除记录
        dbUtiConfig.delete(cfgid, cfgoth);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //按条件删除记录
        dbUtiConfig.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiConfigDto utiConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiConfigDto utiConfigDto) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //更新记录
        dbUtiConfig.update(utiConfigDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param cfgid cfgid
     * @param cfgoth cfgoth
     * @return utiConfigDto utiConfigDto
     * @throws Exception
     */
    public UtiConfigDto findByPrimaryKey(DBManager dbManager,String cfgid,String cfgoth) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        //声明DTO
        UtiConfigDto utiConfigDto = null;
        //查询数据,赋值给DTO
        utiConfigDto = dbUtiConfig.findByPrimaryKey(cfgid, cfgoth);
        return utiConfigDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiConfigDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiConfig.getCount(conditions);
        collection = dbUtiConfig.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiConfig dbUtiConfig = new DBUtiConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfig.getCount(conditions);
        return count;
    }
}
