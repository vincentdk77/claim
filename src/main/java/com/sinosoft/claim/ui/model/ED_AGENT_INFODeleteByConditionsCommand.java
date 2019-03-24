package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLED_AGENT_INFOFacade��UI Command��<br>
 * ������ 2005-07-19 09:59:09.675<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFODeleteByConditionsCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��ED_AGENT_INFODeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public ED_AGENT_INFODeleteByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLED_AGENT_INFOFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("deleteByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
