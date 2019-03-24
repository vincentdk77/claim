package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorcpendorchgdetailDto;
import com.gyic.claim.bl.action.domain.BLTemblorcpendorchgdetailAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORCPENDORCHGDETAIL的业务逻辑对象Facade基类<br>
 */
public class BLTemblorcpendorchgdetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorcpendorchgdetailFacadeBase.class);

    /**
     * 构造函数
     */
    public BLTemblorcpendorchgdetailFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blTemblorcpendorchgdetailAction.insert(dbManager,temblorcpendorchgdetailDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blTemblorcpendorchgdetailAction.delete(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blTemblorcpendorchgdetailAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void update(TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blTemblorcpendorchgdetailAction.update(dbManager,temblorcpendorchgdetailDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public TemblorcpendorchgdetailDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        //声明DTO
        TemblorcpendorchgdetailDto temblorcpendorchgdetailDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            temblorcpendorchgdetailDto = blTemblorcpendorchgdetailAction.findByPrimaryKey(dbManager,inusrelistcode, kindcode, itemcode, address, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorcpendorchgdetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorcpendorchgdetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含temblorcpendorchgdetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorcpendorchgdetailAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorcpendorchgdetailAction blTemblorcpendorchgdetailAction = new BLTemblorcpendorchgdetailAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorcpendorchgdetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
