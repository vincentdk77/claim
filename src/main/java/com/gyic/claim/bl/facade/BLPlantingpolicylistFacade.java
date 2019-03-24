package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * 这是PLANTINGPOLICYLIST的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingpolicylistFacade extends BLPlantingpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistFacade.class);

    /**
     * 构造函数
     */
    public BLPlantingpolicylistFacade(){
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
    public PageRecord findPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingpolicylistAction.findPlantingByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 查询新农险，种植险清单信息
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord findNewPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
    PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        pageRecord = blPlantingpolicylistAction.findNewPlantingByConditions(dbManager,conditions,pageNo,rowsPerPage);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return pageRecord;
}
}
