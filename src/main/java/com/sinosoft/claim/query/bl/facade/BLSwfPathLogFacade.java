package com.sinosoft.claim.query.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfPathLogAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPATHLOG������·����־���ҵ�����Facade��<br>
 * ������ 2004-08-09 19:54:55.317<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPathLogFacade extends BLSwfPathLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogFacade.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogFacade(){
        super();
    }
    
    public int getMaxPathNo(String flowID)
        throws Exception{

        int PathNo=0;

        DBManager dbManager = new DBManager();
        BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            PathNo = blSwfPathLogAction.getMaxPathNo(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return PathNo;
    }
    
}
