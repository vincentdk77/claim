package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


public class ReCaseFindByPrimaryCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLpersonWoundFindByPrimaryKeyCommand����
     * @param registNo ����registNo
     * @param serialNo ����serialNo
     * @param personNo ����personNo
     * @throws Exception
     */
    public ReCaseFindByPrimaryCommand(String claimNo ,int serialNo ) throws Exception {
    		this.params = new Object[]{claimNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class  };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLReCaseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}