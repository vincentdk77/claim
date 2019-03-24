package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLregistExtFacade��UI Command��<br>
 * ������ 2005-03-11 11:11:52.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistExtFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLregistExtFindByPrimaryKeyCommand����
     * @param registNo ����registNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public PrpLregistExtFindByPrimaryKeyCommand(String registNo ,int serialNo) throws Exception {
    		this.params = new Object[]{registNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLregistExtFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
