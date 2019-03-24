package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLWflogAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是SwfLog工作流日志表的业务对象Facade类<br>
 * 创建于 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCplanFacade extends BLSwfLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogFacade.class);

    /**
     * 构造函数
     */
    public BLPrpCplanFacade(){
        super();
    }
    /**
     * 按自定义SQL查询多条数据
     * @param conditions 自定义SQL
     * @param blnAll 自定义参数
     * @return Collection 包含wfLogDto的集合
     * @throws Exception
     * @author luyang
     */
    public Collection findByConditions(String conditions) throws
    Exception
    {
        Collection collection = new ArrayList();
        if (conditions.trim().length() == 0)
        {
            conditions = "1=1";
        }
        DBManager dbManager = new DBManager();
        BLWflogAction blWfLogAction = new BLWflogAction();
        try
        {
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blWfLogAction.findByConditions(dbManager, conditions, true);
            
        }
        catch (Exception exception)
        {
            throw exception;
        }
        finally
        {
            dbManager.close();
        }
        return collection;
    }    


}