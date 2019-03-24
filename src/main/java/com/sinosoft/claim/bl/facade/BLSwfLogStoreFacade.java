package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogStoreAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLogStore的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreFacade extends BLSwfLogStoreFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreFacade.class);

    /**
     * 构造函数
     */
    public BLSwfLogStoreFacade(){
        super();
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxLogNo(String flowID)
        throws Exception{

        int LogNo=0;

        DBManager dbManager = new DBManager();
        BLSwfLogStoreAction blSwfLogStoreAction = new BLSwfLogStoreAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            LogNo = blSwfLogStoreAction.getMaxLogNo(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return LogNo;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxNodeLogNo(String flowID,String nodeType,String businessNo)
        throws Exception{

        int LogNo=0;

        DBManager dbManager = new DBManager();
        BLSwfLogStoreAction blSwfLogStoreAction = new BLSwfLogStoreAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            LogNo = blSwfLogStoreAction.getMaxNodeLogNo(dbManager,flowID,nodeType,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return LogNo;
    }
}
