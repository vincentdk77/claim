package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLkindItemAction;
import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是承保险别标的表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLkindItemFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void insert(PrpLkindItemDto prpLkindItemDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLkindItemAction.insert(dbManager,prpLkindItemDto);
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
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param itemCode 标的项目代码
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String itemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLkindItemAction.delete(dbManager,riskCode, kindCode, itemCode);
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
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLkindItemAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void update(PrpLkindItemDto prpLkindItemDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLkindItemAction.update(dbManager,prpLkindItemDto);
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
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param itemCode 标的项目代码
     * @return prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public PrpLkindItemDto findByPrimaryKey(String riskCode,String kindCode,String itemCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        //声明DTO
        PrpLkindItemDto prpLkindItemDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLkindItemDto = blPrpLkindItemAction.findByPrimaryKey(dbManager,riskCode, kindCode, itemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLkindItemDto;
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
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLkindItemAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLkindItemDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLkindItemAction.findByConditions(dbManager,conditions);
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
        BLPrpLkindItemAction blPrpLkindItemAction = new BLPrpLkindItemAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLkindItemAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
