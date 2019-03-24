package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfNodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfNodeFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeFindByPrimaryKeyCommand extends BaseCommand{
    private int modelNo=0;
    private int nodeNo=0;
    /**
     *  ���췽��,����һ��SwfNodeFindByPrimaryKeyCommand����
     * @param modelNo ����modelNo
     * @param nodeNo ����nodeNo
     * @throws Exception
     */
    public SwfNodeFindByPrimaryKeyCommand(int modelNo ,int nodeNo) throws Exception {
    		this.modelNo= modelNo;
    		this.nodeNo = nodeNo;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
    
     BLSwfNodeFacade bLSwfNodeFacade = new BLSwfNodeFacade();
      return bLSwfNodeFacade.findByPrimaryKey(modelNo,nodeNo);
    }
}
