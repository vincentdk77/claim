package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertainLossFindByConCommand extends BaseCommand
{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLverifyLossFindByPrimaryKeyCommand����
     * @param registNo ����registNo
     * @throws Exception
     */
    public CertainLossFindByConCommand(String registNo) throws Exception {
    		this.params = new Object[]{registNo};
    		this.paramTypes = new Class[]{String.class};
    }
    /**
     *  ���췽��,����һ��PrpLverifyLossFindByPrimaryKeyCommand����
     * @param registNo ����registNo
     * @param lossItemCode ����lossItemCode
     * @throws Exception
     */
    public CertainLossFindByConCommand(String registNo ,String lossItemCode) throws Exception {
    		this.params = new Object[]{registNo  ,lossItemCode };
    		this.paramTypes = new Class[]{String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCertainLossFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
