package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowFacade��UI Command��<br> Ŀǰû��ʹ��
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowDeleteByConditionsCommand extends BaseCommand{
    private String conditions="1=2 ";
    /**
     *  ���췽��,����һ��WorkFlowDeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public WorkFlowDeleteByConditionsCommand(String conditions) throws Exception {
    		this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLWorkFlowFacade bLWorkFlowFacade = new BLWorkFlowFacade();
       //bLWorkFlowFacade.(conditions);
       return null;

    }
}
