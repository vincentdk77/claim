package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * ����BLBackVisitFacade��UI Command��<br>
 * ������ 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��BackVisitDeleteCommand����
     * @param backVisitNo ����backVisitNo
     * @param registNo ����registNo
     * @param backVisitType ����backVisitType
     * @param workFlowDto ����workFlowDto
     * @throws Exception
     */
    public BackVisitDeleteCommand(int backVisitNo ,String registNo ,String backVisitType ,WorkFlowDto workFlowDto) throws Exception {
    		this.params = new Object[]{new Integer(backVisitNo)  ,registNo  ,backVisitType  ,workFlowDto };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class  ,WorkFlowDto.class };
    }
    /**
     *  ���췽��,����һ��BackVisitDeleteCommand����
     * @param backVisitNo ����backVisitNo
     * @param registNo ����registNo
     * @param backVisitType ����backVisitType
     * @throws Exception
     */
    public BackVisitDeleteCommand(int backVisitNo ,String registNo ,String backVisitType) throws Exception {
    		this.params = new Object[]{new Integer(backVisitNo)  ,registNo  ,backVisitType };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLBackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
