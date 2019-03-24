package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfPathFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.408<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfPathInsertCommand����
     * @param wfPathDto ����wfPathDto
     * @throws Exception
     */
    public SwfPathInsertCommand(SwfPathDto wfPathDto) throws Exception {
    		this.params = new Object[]{wfPathDto };
    		this.paramTypes = new Class[]{SwfPathDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPathFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
