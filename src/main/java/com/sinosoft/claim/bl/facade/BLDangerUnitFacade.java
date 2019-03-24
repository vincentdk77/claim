package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.List;


import com.sinosoft.claim.bl.action.custom.BLDangerUnitAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 查询危险单位信息的BL类
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>@createdate 2011-01-17</p>
 * @Author  :国元项目组
 * @version 1.0
 */

public class BLDangerUnitFacade{

    /**
     * 构造函数
     */
    public BLDangerUnitFacade(){
    }





    
    public List getPrpCdangerUnit(String policyNo,String itemKindNo) throws Exception{
    	List list = new ArrayList();


        DBManager dbManager = new DBManager();
        BLDangerUnitAction blDangerUnitAction = new BLDangerUnitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            list = blDangerUnitAction.getPrpCdangerUnit(dbManager,policyNo,itemKindNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return list;
    }
    
    public List getCompensatePrpCdangerUnit(String policyNo,String kingCodeList) throws Exception{
    	List list = new ArrayList();


        DBManager dbManager = new DBManager();
        BLDangerUnitAction blDangerUnitAction = new BLDangerUnitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            list = blDangerUnitAction.getCompensatePrpCdangerUnit(dbManager,policyNo, kingCodeList);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return list;
    }
    


   public List getPrpPdangerUnit(String registNo,String policyNo,String itemKindNo) throws Exception{
    	List List = new ArrayList();


        DBManager dbManager = new DBManager();
        BLDangerUnitAction blDangerUnitAction = new BLDangerUnitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            List = blDangerUnitAction.getPrpPdangerUnit(dbManager,registNo, policyNo, itemKindNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return List;
    }
    
    public List getCompensatePrpPdangerUnit(String registNo,String policyNo,String kingCodeList) throws Exception{
    	List List = new ArrayList();


        DBManager dbManager = new DBManager();
        BLDangerUnitAction blDangerUnitAction = new BLDangerUnitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
             List = blDangerUnitAction.getCompensatePrpPdangerUnit(dbManager,registNo, policyNo, kingCodeList);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return List;
    }
    
    
    
    public List getPrpLdangerUnit(String certino) throws Exception{
    	List list = new ArrayList();


        DBManager dbManager = new DBManager();
        BLDangerUnitAction blDangerUnitAction = new BLDangerUnitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            list = blDangerUnitAction.getPrpLdangerUnit(dbManager,certino);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return list;
    }
}
