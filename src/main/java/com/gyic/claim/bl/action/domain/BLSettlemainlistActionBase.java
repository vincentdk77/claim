package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBSettlemainlist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SETTLEMAINLIST的业务逻辑对象类<br>
 */
public class BLSettlemainlistActionBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistActionBase.class);

    /**
     * 构造函数
     */
    public BLSettlemainlistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SettlemainlistDto settlemainlistDto)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //插入记录
        dbSettlemainlist.insert(settlemainlistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //删除记录
        dbSettlemainlist.delete(settlelistcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //按条件删除记录
        dbSettlemainlist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SettlemainlistDto settlemainlistDto)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //更新记录
        dbSettlemainlist.update(settlemainlistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @return settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public SettlemainlistDto findByPrimaryKey(DBManager dbManager,String settlelistcode)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        //声明DTO
        SettlemainlistDto settlemainlistDto = null;
        //查询数据,赋值给DTO
        settlemainlistDto = dbSettlemainlist.findByPrimaryKey(settlelistcode);
        return settlemainlistDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSettlemainlist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSettlemainlist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含settlemainlistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSettlemainlist.findByConditions(conditions);
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
        DBSettlemainlist dbSettlemainlist = new DBSettlemainlist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSettlemainlist.getCount(conditions);
        return count;
    }
}
