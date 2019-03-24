package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDaccidentDeductAction;
import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDaccidentDeduct-事故责任免赔率的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDaccidentDeductFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void insert(PrpDaccidentDeductDto prpDaccidentDeductDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDaccidentDeductAction.insert(dbManager,prpDaccidentDeductDto);
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
     * @param indemnityDuty 赔偿责任代码
     * @param dangerLevel 风险水平
     * @param deductPeriod 期数
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDaccidentDeductAction.delete(dbManager,riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDaccidentDeductAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void update(PrpDaccidentDeductDto prpDaccidentDeductDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDaccidentDeductAction.update(dbManager,prpDaccidentDeductDto);
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
     * @param indemnityDuty 赔偿责任代码
     * @param dangerLevel 风险水平
     * @param deductPeriod 期数
     * @return prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public PrpDaccidentDeductDto findByPrimaryKey(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        //声明DTO
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        try{
            // 创建数据库管理对象
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDaccidentDeductDto = blPrpDaccidentDeductAction.findByPrimaryKey(dbManager,riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
            
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDaccidentDeductDto;
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDaccidentDeductAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDaccidentDeductDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDaccidentDeductAction.findByConditions(dbManager,conditions);
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
        BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDaccidentDeductAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
