package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpGrantFacade��UI Command��<br>
 * ������ 2004-11-09 10:40:57.933<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpGrantDeleteCommand����
     * @param userCode ����userCode
     * @param groupCode ����groupCode
     * @param taskCode ����taskCode
     * @param checkCode ����checkCode
     * @param grantStartDate ����grantStartDate
     * @param grantEndDate ����grantEndDate
     * @throws Exception
     */
    public PrpGrantDeleteCommand(String userCode ,String groupCode ,String taskCode ,String checkCode ,DateTime grantStartDate ,DateTime grantEndDate) throws Exception {
    		this.params = new Object[]{userCode  ,groupCode  ,taskCode  ,checkCode  ,grantStartDate  ,grantEndDate };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,String.class  ,String.class  ,DateTime.class  ,DateTime.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpGrantFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
