package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfNotionAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是工作流意见处理表的业务对象Facade类<br>
 * 创建于 2005-04-05 10:45:06.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionFacade extends BLSwfNotionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionFacade.class);

    /**
     * 构造函数
     */
    public BLSwfNotionFacade(){
        super();
    }

        /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxLineNo(String flowID,int logNo)
        throws Exception{

        int LineNo=0;

        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            LineNo = blSwfNotionAction.getMaxLineNo(dbManager,flowID,logNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return LineNo;
    }

}
