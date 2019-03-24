package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorpolicylistorigin;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORPOLICYLISTORIGIN的业务逻辑对象类<br>
 */
public class BLTemblorpolicylistoriginActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorpolicylistoriginActionBase.class);

    /**
     * 构造函数
     */
    public BLTemblorpolicylistoriginActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //插入记录
        dbTemblorpolicylistorigin.insert(temblorpolicylistoriginDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //删除记录
        dbTemblorpolicylistorigin.delete(inusrelistcode, kindcode, itemcode, address, idcard);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //按条件删除记录
        dbTemblorpolicylistorigin.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //更新记录
        dbTemblorpolicylistorigin.update(temblorpolicylistoriginDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public TemblorpolicylistoriginDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        //声明DTO
        TemblorpolicylistoriginDto temblorpolicylistoriginDto = null;
        //查询数据,赋值给DTO
        temblorpolicylistoriginDto = dbTemblorpolicylistorigin.findByPrimaryKey(inusrelistcode, kindcode, itemcode, address, idcard);
        return temblorpolicylistoriginDto;
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
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylistorigin.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorpolicylistorigin.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含temblorpolicylistoriginDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorpolicylistorigin.findByConditions(conditions);
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
        DBTemblorpolicylistorigin dbTemblorpolicylistorigin = new DBTemblorpolicylistorigin(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorpolicylistorigin.getCount(conditions);
        return count;
    }
}
