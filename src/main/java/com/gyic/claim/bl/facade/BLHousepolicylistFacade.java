package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.bl.action.domain.BLHousepolicylistAction;
import com.gyic.claim.dto.domain.HousepolicylistDto;

/**
 * 这是HOUSEPOLICYLIST的业务对象Facade类<br>
 * 创建于 JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLHousepolicylistFacade extends BLHousepolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistFacade.class);

    /**
     * 构造函数
     */
    public BLHousepolicylistFacade(){
        super();
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findIdcardByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHousepolicylistAction.findIdcardByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    public PageRecord findIdcardByConditions1(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
    PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
    try{
        dbManager.open("NXDADataSource");
        pageRecord = blHousepolicylistAction.findIdcardByConditions1(dbManager,conditions,pageNo,rowsPerPage);
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
    public PageRecord findAreacodeByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHousepolicylistAction.findAreacodeByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    public PageRecord findAreacodeByConditions1(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
    PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLHousepolicylistAction blHousepolicylistAction = new BLHousepolicylistAction();
    try{
        dbManager.open("NXDADataSource");
        pageRecord = blHousepolicylistAction.findAreacodeByConditions1(dbManager,conditions,pageNo,rowsPerPage);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return pageRecord;
}
}
