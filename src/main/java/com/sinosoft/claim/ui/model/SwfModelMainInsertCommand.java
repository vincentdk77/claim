package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelMainFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelMainInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfModelMainInsertCommand����
     * @param wfModelMainDto ����wfModelMainDto
     * @throws Exception
     */
    public SwfModelMainInsertCommand(SwfModelMainDto wfModelMainDto) throws Exception {
    		this.params = new Object[]{wfModelMainDto };
    		this.paramTypes = new Class[]{SwfModelMainDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfModelMainFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
