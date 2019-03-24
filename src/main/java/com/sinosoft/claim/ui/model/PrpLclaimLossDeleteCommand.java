package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimLossFacade��UI Command��<br>
 * ������ 2004-06-24 14:46:42.929<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimLossDeleteCommand����
     * @param claimNo ����claimNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public PrpLclaimLossDeleteCommand(String claimNo ,int serialNo) throws Exception {
    		this.params = new Object[]{claimNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
