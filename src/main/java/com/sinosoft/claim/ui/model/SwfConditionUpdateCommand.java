package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfConditionFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfConditionUpdateCommand����
     * @param wfConditionDto ����wfConditionDto
     * @throws Exception
     */
    public SwfConditionUpdateCommand(SwfConditionDto swfConditionDto) throws Exception {
    		this.params = new Object[]{swfConditionDto };
    		this.paramTypes = new Class[]{SwfConditionDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfConditionFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
