package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfNodeFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfNodeUpdateCommand����
     * @param wfNodeDto ����wfNodeDto
     * @throws Exception
     */
    public SwfNodeUpdateCommand(SwfNodeDto wfNodeDto) throws Exception {
    		this.params = new Object[]{wfNodeDto };
    		this.paramTypes = new Class[]{SwfNodeDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfNodeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
