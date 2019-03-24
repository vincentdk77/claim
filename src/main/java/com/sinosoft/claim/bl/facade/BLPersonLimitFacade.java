package com.sinosoft.claim.bl.facade;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLPersonLimitAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * <p>Title: 人员权限查询</p>
 * <p>Description: 人员权限查询</p>
 * <p>Copyright: Copyright (c) 2005/11/15</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class BLPersonLimitFacade {
 
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPersonLimitFacade(){
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        Collection collection = null;
        DBManager dbManager = new DBManager();
        BLPersonLimitAction blPersonLimitAction = new BLPersonLimitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPersonLimitAction.findByQueryConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    
    
    
    
}