package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowModelFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowModelUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��WorkFlowModelUpdateCommand����
     * @param workFlowModelDto ����workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelUpdateCommand(WorkFlowModelDto workFlowModelDto) throws Exception {
    		this.params = new Object[]{workFlowModelDto };
    		this.paramTypes = new Class[]{WorkFlowModelDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
