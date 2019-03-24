package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfConditionAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfCondition工作流条件描述表的业务对象Facade类<br>
 * 创建于 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfConditionFacade extends BLSwfConditionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfConditionFacade.class);

    /**
     * 构造函数
     */
    public BLSwfConditionFacade(){
        super();
    }

     /**
     * 查询业务条件是否满足
     * @param conditions conditions
     * @return true/false
     * @throws Exception
     */
    public boolean executeResult(String conditions)
        throws Exception{

        boolean result=false;

        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            result = blSwfConditionAction.executeResult(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return result;
    }

}
