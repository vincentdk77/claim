package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * 这是BLBackVisitFacade的UI Command类<br>
 * 创建于 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个BackVisitDeleteCommand对象
     * @param backVisitNo 参数backVisitNo
     * @param registNo 参数registNo
     * @param backVisitType 参数backVisitType
     * @param workFlowDto 参数workFlowDto
     * @throws Exception
     */
    public BackVisitDeleteCommand(int backVisitNo ,String registNo ,String backVisitType ,WorkFlowDto workFlowDto) throws Exception {
    		this.params = new Object[]{new Integer(backVisitNo)  ,registNo  ,backVisitType  ,workFlowDto };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class  ,WorkFlowDto.class };
    }
    /**
     *  构造方法,构造一个BackVisitDeleteCommand对象
     * @param backVisitNo 参数backVisitNo
     * @param registNo 参数registNo
     * @param backVisitType 参数backVisitType
     * @throws Exception
     */
    public BackVisitDeleteCommand(int backVisitNo ,String registNo ,String backVisitType) throws Exception {
    		this.params = new Object[]{new Integer(backVisitNo)  ,registNo  ,backVisitType };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLBackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
