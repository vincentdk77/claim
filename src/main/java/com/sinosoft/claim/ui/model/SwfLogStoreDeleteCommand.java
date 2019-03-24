package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLSwfLogStoreFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreDeleteCommand extends BaseCommand{
    private String stringFlowID;
    /**
     * ���췽��,����һ��SwfLogStoreDeleteCommand����
     * @param flowID ����flowID
     * @throws Exception
     */
    public SwfLogStoreDeleteCommand(String flowID)
            throws Exception{
        this.stringFlowID = flowID;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLSwfLogStoreFacade facade = new BLSwfLogStoreFacade();
        facade.delete(stringFlowID);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringImpl();
        return object;
    }
}
