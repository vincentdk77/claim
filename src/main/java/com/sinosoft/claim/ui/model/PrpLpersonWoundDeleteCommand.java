package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLpersonWoundFacade��UI Command��<br>
 * ������ 2005-02-18 10:47:33.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonWoundDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLpersonWoundDeleteCommand����
     * @param registNo ����registNo
     * @param serialNo ����serialNo
     * @param personNo ����personNo
     * @throws Exception
     */
    public PrpLpersonWoundDeleteCommand(String registNo ,int serialNo ,int personNo) throws Exception {
    		this.params = new Object[]{registNo  ,new Integer(serialNo)  ,new Integer(personNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonWoundFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
