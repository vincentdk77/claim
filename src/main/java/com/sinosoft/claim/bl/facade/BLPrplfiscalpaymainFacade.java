package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;

/**
 * 这是支付信息主表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaymainFacade extends BLPrplfiscalpaymainFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymainFacade.class);

    /**
     * 构造函数
     */
    public BLPrplfiscalpaymainFacade(){
        super();
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateByKey(String fiscalno,String vflag,String status)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplfiscalmainpayAction.updateByKey(dbManager,fiscalno,vflag,status);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplfiscalmainpayAction.findPayQueryByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPayQueryByConditionsNew(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditionsNew(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * 根据收付编号更新第三方支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateThirdPayFlag(String paymentNo,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpaymainAction.updateThirdPayFlag(dbManager,paymentNo,thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPaybackByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplfiscalmainpayAction.findPaybackByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
