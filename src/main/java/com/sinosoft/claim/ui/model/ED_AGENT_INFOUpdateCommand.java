package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLED_AGENT_INFOFacade��UI Command��<br>
 * ������ 2005-07-19 09:59:09.675<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFOUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��ED_AGENT_INFOUpdateCommand����
     * @param eD_AGENT_INFODto ����eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFOUpdateCommand(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception {
    		this.params = new Object[]{eD_AGENT_INFODto };
    		this.paramTypes = new Class[]{ED_AGENT_INFODto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLED_AGENT_INFOFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
