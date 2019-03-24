package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorhead;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORENDORHEAD的业务逻辑对象类<br>
 */
public class BLTemblorendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorheadActionBase.class);

    /**
     * 构造函数
     */
    public BLTemblorendorheadActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //插入记录
        dbTemblorendorhead.insert(temblorendorheadDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseno)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //删除记录
        dbTemblorendorhead.delete(endorseno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //按条件删除记录
        dbTemblorendorhead.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //更新记录
        dbTemblorendorhead.update(temblorendorheadDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseno ENDORSENO
     * @return temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public TemblorendorheadDto findByPrimaryKey(DBManager dbManager,String endorseno)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        //声明DTO
        TemblorendorheadDto temblorendorheadDto = null;
        //查询数据,赋值给DTO
        temblorendorheadDto = dbTemblorendorhead.findByPrimaryKey(endorseno);
        return temblorendorheadDto;
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
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorhead.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorendorhead.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含temblorendorheadDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorendorhead.findByConditions(conditions);
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
        DBTemblorendorhead dbTemblorendorhead = new DBTemblorendorhead(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorhead.getCount(conditions);
        return count;
    }
}
