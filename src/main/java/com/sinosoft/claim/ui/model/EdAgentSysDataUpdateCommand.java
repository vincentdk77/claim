package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLEdAgentSysDataFacade��UI Command��<br>
 * ������ 2005-07-19 09:59:09.665<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdAgentSysDataUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��EdAgentSysDataUpdateCommand����
     * @param edAgentSysDataDto ����edAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataUpdateCommand(EdAgentSysDataDto edAgentSysDataDto) throws Exception {
    		this.params = new Object[]{edAgentSysDataDto };
    		this.paramTypes = new Class[]{EdAgentSysDataDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLEdAgentSysDataFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
