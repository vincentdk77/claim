package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * ����BLBackVisitFacade��UI Command��<br>
 * ������ 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitSaveCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��BackVisitSaveCommand����
     * @param backVisitDto ����backVisitDto
     * @param workFlowDto ����workFlowDto
     * @throws Exception
     */
    public BackVisitSaveCommand(BackVisitDto backVisitDto ,WorkFlowDto workFlowDto) throws Exception {
    		this.params = new Object[]{backVisitDto  ,workFlowDto };
    		this.paramTypes = new Class[]{BackVisitDto.class  ,WorkFlowDto.class };
    }
    /**
     *  ���췽��,����һ��BackVisitSaveCommand����
     * @param backVisitDto ����backVisitDto
     * @throws Exception
     */
    public BackVisitSaveCommand(BackVisitDto backVisitDto) throws Exception {
    		this.params = new Object[]{backVisitDto };
    		this.paramTypes = new Class[]{BackVisitDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLBackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("save",paramTypes);
        return method.invoke(object,params);
    }
}
