package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpUserGradeFacade��UI Command��<br>
 * ������ 2004-11-09 10:41:01.168<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpUserGradeFindByPrimaryKeyCommand����
     * @param userCode ����userCode
     * @param groupCode ����groupCode
     * @param taskCode ����taskCode
     * @param checkCode ����checkCode
     * @throws Exception
     */
    public PrpUserGradeFindByPrimaryKeyCommand(String userCode ,String groupCode ,String taskCode ,String checkCode) throws Exception {
    		this.params = new Object[]{userCode  ,groupCode  ,taskCode  ,checkCode };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpUserGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
