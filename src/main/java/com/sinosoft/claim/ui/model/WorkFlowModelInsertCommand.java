package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade;
import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * ����BLWorkFlowModelFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowModelInsertCommand extends BaseCommand{
    //private Class[] paramTypes;
    //private Object[] params;
    private WorkFlowModelDto workFlowModelDto = null;
    /**
     *  ���췽��,����һ��WorkFlowModelInsertCommand����
     * @param workFlowModelDto ����workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelInsertCommand(WorkFlowModelDto workFlowModelDto) throws Exception {
    		//this.params = new Object[]{workFlowModelDto };
    		//this.paramTypes = new Class[]{WorkFlowModelDto.class };
               this.workFlowModelDto = workFlowModelDto;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        //Thread.currentThread().setContextClassLoader(myClassLoader);
       // Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade");
        //Object object = loaderClass.newInstance();
       // Method method = loaderClass.getMethod("insert",paramTypes);
       // return method.invoke(object,params);
       BLWorkFlowModelFacade blWorkFlowModelFacade = new BLWorkFlowModelFacade();
       blWorkFlowModelFacade.insert(this.workFlowModelDto) ;
       return null;
    }
}
