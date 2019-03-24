package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfFlowMainFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfFlowMainUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfFlowMainUpdateCommand����
     * @param wfFlowMainDto ����wfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainUpdateCommand(SwfFlowMainDto wfFlowMainDto) throws Exception {
    		this.params = new Object[]{wfFlowMainDto };
    		this.paramTypes = new Class[]{SwfFlowMainDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
