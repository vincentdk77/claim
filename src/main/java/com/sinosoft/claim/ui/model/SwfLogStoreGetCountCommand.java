package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLSwfLogStoreFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreGetCountCommand extends BaseCommand{
    private String stringConditions;
    /**
     * ���췽��,����һ��SwfLogStoreGetCountCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfLogStoreGetCountCommand(String conditions)
            throws Exception{
        this.stringConditions = conditions;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLSwfLogStoreFacade facade = new BLSwfLogStoreFacade();
        return new Integer(facade.getCount(stringConditions));
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
