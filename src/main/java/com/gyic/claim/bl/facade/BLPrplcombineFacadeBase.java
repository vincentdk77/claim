package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.bl.action.domain.BLPrplcombineAction;


public class BLPrplcombineFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineFacadeBase.class);


    public BLPrplcombineFacadeBase(){
    }


    public void insert(PrplcombineDto prplcombineDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();

            blPrplcombineAction.insert(dbManager,prplcombineDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }


    public void delete(String registno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            blPrplcombineAction.delete(dbManager,registno);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

   
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            blPrplcombineAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }


    public void update(PrplcombineDto prplcombineDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();

            blPrplcombineAction.update(dbManager,prplcombineDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }


    public PrplcombineDto findByPrimaryKey(String registno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();

        PrplcombineDto prplcombineDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));

            prplcombineDto = blPrplcombineAction.findByPrimaryKey(dbManager,registno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcombineDto;
    }
    public ArrayList findByConbineNo(String combineNo)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();

    ArrayList arrayList = null;
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));

        arrayList = blPrplcombineAction.findByComBineNo(dbManager,combineNo);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return arrayList;
}

   
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcombineAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcombineAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcombineAction blPrplcombineAction = new BLPrplcombineAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcombineAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
