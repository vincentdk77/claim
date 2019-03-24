package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDSETTLELIST的业务逻辑对象类<br>
 */
public class BLHerdsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistActionBase.class);

    /**
     * 构造函数
     */
    public BLHerdsettlelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //插入记录
        dbHerdsettlelist.insert(herdsettlelistDto);
    }
    
    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,List list)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //插入记录
        dbHerdsettlelist.insertAll(list);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //删除记录
        dbHerdsettlelist.delete(settlelistcode, earlabel, fcode, kindcode, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //按条件删除记录
        dbHerdsettlelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //更新记录
        dbHerdsettlelist.update(herdsettlelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @return herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public HerdsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //声明DTO
        HerdsettlelistDto herdsettlelistDto = null;
        //查询数据,赋值给DTO
        herdsettlelistDto = dbHerdsettlelist.findByPrimaryKey(settlelistcode, earlabel, fcode, kindcode, serialno);
        return herdsettlelistDto;
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
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHerdsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含herdsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHerdsettlelist.findByConditions(conditions);
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
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdsettlelist.getCount(conditions);
        return count;
    }
}
