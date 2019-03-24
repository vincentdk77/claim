package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��WorkFlowDeleteCommand����
     * @param modelNo ����modelNo
     * @param pathNo ����pathNo
     * @param conditionNo ����conditionNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public WorkFlowDeleteCommand(int modelNo ,int pathNo ,int conditionNo ,int serialNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,new Integer(pathNo)  ,new Integer(conditionNo)  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{int.class  ,int.class  ,int.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLWorkFlowFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
