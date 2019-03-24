package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogFindByPrimaryKeyCommand extends BaseCommand{
    private String flowID="";
    private int logNo =0;
    /**
     *  ���췽��,����һ��SwfLogFindByPrimaryKeyCommand����
     * @param flowID ����flowID
     * @param logNo ����logNo
     * @throws Exception
     */
    public SwfLogFindByPrimaryKeyCommand(String flowID ,int logNo) throws Exception {
    		this.flowID = flowID;
    		this.logNo = logNo;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        return  blSwfLogFacade.findByPrimaryKey(flowID,logNo);
    }
    
    /**
     * ɾ��ע��/�������񣨼�Ϊ�˻�ע��/��������add 2005-11-24
     * @param flowID ���̺�
     * @param logNo  ���
     * @throws Exception
     * */
    public void cancelBack() throws Exception {
        BLWorkFlowFacade blWorkFlowFacade = new BLWorkFlowFacade();
        blWorkFlowFacade.cancelBack(flowID, logNo);
        
    }
}
