package com.sinosoft.claim.ui.model;
import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class SwfLogFindByConditionsCommand extends BaseCommand
{
	private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfPathFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public SwfLogFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.params = new Object[]{conditions  ,new Integer(pageNo)  ,new Integer(rowsPerPage) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }  
    
   /**
     *  ���췽��,����һ��SwfPathFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfLogFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
  
 /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
