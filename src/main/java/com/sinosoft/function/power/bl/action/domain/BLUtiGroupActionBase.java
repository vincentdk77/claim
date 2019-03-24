package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBUtiGroup;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiGroup  权限组号表的业务逻辑对象类<br>
 * 创建于 2004-11-09 10:40:54.648<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupActionBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupActionBase.class);

    /**
     * 构造函数
     */
    public BLUtiGroupActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiGroupDto utiGroupDto) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //插入记录
        dbUtiGroup.insert(utiGroupDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param groupCode 权限组号代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupCode) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //删除记录
        dbUtiGroup.delete(groupCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //按条件删除记录
        dbUtiGroup.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiGroupDto utiGroupDto) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //更新记录
        dbUtiGroup.update(utiGroupDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param groupCode 权限组号代码
     * @return utiGroupDto utiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(DBManager dbManager,String groupCode) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //声明DTO
        UtiGroupDto utiGroupDto = null;
        //查询数据,赋值给DTO
        utiGroupDto = dbUtiGroup.findByPrimaryKey(groupCode);
        return utiGroupDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiGroup.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含utiGroupDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiGroup.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiGroup.getCount(conditions);
        return count;
    }
}
