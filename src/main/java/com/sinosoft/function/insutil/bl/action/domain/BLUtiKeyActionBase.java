package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiKeyDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiKey;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utikey的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiKeyActionBase{
    private static Log log = LogFactory.getLog(BLUtiKeyActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiKeyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //插入记录
        dbUtiKey.insert(utiKeyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param tableName tablename
     * @throws Exception
     */
    public void delete(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //删除记录
        dbUtiKey.delete(tableName);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //按条件删除记录
        dbUtiKey.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //更新记录
        dbUtiKey.update(utiKeyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param tableName tablename
     * @return utiKeyDto utiKeyDto
     * @throws Exception
     */
    public UtiKeyDto findByPrimaryKey(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //声明DTO
        UtiKeyDto utiKeyDto = null;
        //查询数据,赋值给DTO
        utiKeyDto = dbUtiKey.findByPrimaryKey(tableName);
        return utiKeyDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiKeyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiKey.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiKey.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含utiKeyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiKey.getCount(conditions);
        return count;
    }
}
