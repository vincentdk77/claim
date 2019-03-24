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
 * ����HOUSEPOLICYLIST��ҵ�����Facade��<br>
 * ������ JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLHousepolicylistFacade extends BLHousepolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistFacade.class);

    /**
     * ���캯��
     */
    public BLHousepolicylistFacade(){
        super();
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
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
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
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
