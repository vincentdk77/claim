package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfNotionAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ��������������ҵ�����Facade��<br>
 * ������ 2005-04-05 10:45:06.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionFacade extends BLSwfNotionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionFacade.class);

    /**
     * ���캯��
     */
    public BLSwfNotionFacade(){
        super();
    }

        /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
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
