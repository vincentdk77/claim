package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpPtextAction;
import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpptext批改文字信息的业务逻辑对象Facade基类<br>
 * 创建于 2004-11-22 15:24:35.625<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpPtextFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void insert(PrpPtextDto prpPtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpPtextAction.insert(dbManager,prpPtextDto);
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
     * @param endorseNo 批单号次
     * @param policyNo 保险单号次
     * @param lineNo 批文的行号
     * @throws Exception
     */
    public void delete(String endorseNo,String policyNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpPtextAction.delete(dbManager,endorseNo, policyNo, lineNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpPtextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void update(PrpPtextDto prpPtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpPtextAction.update(dbManager,prpPtextDto);
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
     * @param endorseNo 批单号次
     * @param policyNo 保险单号次
     * @param lineNo 批文的行号
     * @return prpPtextDto prpPtextDto
     * @throws Exception
     */
    public PrpPtextDto findByPrimaryKey(String endorseNo,String policyNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        //声明DTO
        PrpPtextDto prpPtextDto = null;
        try{
            dbManager.open("claimTempDataSource");
            //查询数据,赋值给DTO
            prpPtextDto = blPrpPtextAction.findByPrimaryKey(dbManager,endorseNo, policyNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPtextDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            pageRecord = blPrpPtextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpPtextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            collection = blPrpPtextAction.findByConditions(dbManager,conditions);
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
        BLPrpPtextAction blPrpPtextAction = new BLPrpPtextAction();
        try{
            dbManager.open("claimTempDataSource");
            rowCount = blPrpPtextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
