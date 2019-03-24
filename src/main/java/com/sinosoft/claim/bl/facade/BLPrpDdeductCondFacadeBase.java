package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDdeductCondAction;
import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDdeductCond-免赔条件表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDdeductCondFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void insert(PrpDdeductCondDto prpDdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDdeductCondAction.insert(dbManager,prpDdeductCondDto);
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
     * @param riskCode 险种
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param deductCondCode 免赔条件代码
     * @param dEDUCTPERIOD 期数
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDdeductCondAction.delete(dbManager,riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDdeductCondAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void update(PrpDdeductCondDto prpDdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDdeductCondAction.update(dbManager,prpDdeductCondDto);
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
     * @param riskCode 险种
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param deductCondCode 免赔条件代码
     * @param dEDUCTPERIOD 期数
     * @return prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public PrpDdeductCondDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        //声明DTO
        PrpDdeductCondDto prpDdeductCondDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDdeductCondDto = blPrpDdeductCondAction.findByPrimaryKey(dbManager,riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDdeductCondDto;
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDdeductCondAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDdeductCondDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDdeductCondAction.findByConditions(dbManager,conditions);
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
        BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDdeductCondAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
