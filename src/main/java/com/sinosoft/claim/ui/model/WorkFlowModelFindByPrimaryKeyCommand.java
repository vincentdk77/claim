package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLWorkFlowModelFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowModelFindByPrimaryKeyCommand extends BaseCommand{
    int modelNo = 0 ;
    /**
     *  ���췽��,����һ��WorkFlowModelFindByPrimaryKeyCommand����
     * @param modelNo ����modelNo
     * @param pathNo ����pathNo
     * @param conditionNo ����conditionNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public WorkFlowModelFindByPrimaryKeyCommand(int modelNo) throws Exception {
    		this.modelNo = modelNo;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLWorkFlowModelFacade blWorkFlowModelFacade = new BLWorkFlowModelFacade();
        return (Object)blWorkFlowModelFacade.findByPrimaryKey(this.modelNo ) ;
    }
}
