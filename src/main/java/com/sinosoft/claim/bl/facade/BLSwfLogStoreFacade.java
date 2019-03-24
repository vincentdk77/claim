package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogStoreAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLogStore��ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreFacade extends BLSwfLogStoreFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreFacade.class);

    /**
     * ���캯��
     */
    public BLSwfLogStoreFacade(){
        super();
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
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
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
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
