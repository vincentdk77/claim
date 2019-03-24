package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLEdaUserFacade��UI Command��<br>
 * ������ 2005-06-22 14:57:01.769<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaUserUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��EdaUserUpdateCommand����
     * @param edaUserDto ����edaUserDto
     * @throws Exception
     */
    public EdaUserUpdateCommand(EdaUserDto edaUserDto) throws Exception {
    		this.params = new Object[]{edaUserDto };
    		this.paramTypes = new Class[]{EdaUserDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLEdaUserFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
