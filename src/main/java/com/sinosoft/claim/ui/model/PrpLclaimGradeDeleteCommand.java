package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimGradeFacade��UI Command��<br>
 * ������ 2005-04-19 09:24:27.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimGradeDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimGradeDeleteCommand����
     * @param userCode ����userCode
     * @param taskCode ����taskCode
     * @throws Exception
     */
    public PrpLclaimGradeDeleteCommand(String userCode ,String taskCode,String configPara) throws Exception {
    		this.params = new Object[]{userCode  ,taskCode ,configPara};
    		this.paramTypes = new Class[]{String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
