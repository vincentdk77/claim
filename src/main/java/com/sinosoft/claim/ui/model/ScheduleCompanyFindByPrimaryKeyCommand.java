package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ScheduleCompanyFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��WorkFlowFindByPrimaryKeyCommand����
     * @param modelNo ����modelNo
     * @param pathNo ����pathNo
     * @param conditionNo ����conditionNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public ScheduleCompanyFindByPrimaryKeyCommand(String comCode) throws Exception {
    		this.params = new Object[]{new String(comCode)};
    		this.paramTypes = new Class[]{String.class};
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLScheduleCompanyFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}