package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorchgdetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORENDORCHGDETAIL的业务逻辑对象类<br>
 */
public class BLTemblorendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorchgdetailActionBase.class);

    /**
     * 构造函数
     */
    public BLTemblorendorchgdetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //插入记录
        dbTemblorendorchgdetail.insert(temblorendorchgdetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //删除记录
        dbTemblorendorchgdetail.delete(inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //按条件删除记录
        dbTemblorendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //更新记录
        dbTemblorendorchgdetail.update(temblorendorchgdetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public TemblorendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //声明DTO
        TemblorendorchgdetailDto temblorendorchgdetailDto = null;
        //查询数据,赋值给DTO
        temblorendorchgdetailDto = dbTemblorendorchgdetail.findByPrimaryKey(inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
        return temblorendorchgdetailDto;
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
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含temblorendorchgdetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorendorchgdetail.findByConditions(conditions);
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
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorchgdetail.getCount(conditions);
        return count;
    }
}
