package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelUseFacade;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelUseFacade��UI Command��<br>
 * ������ 2004-08-10 10:49:39.367<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseInsertCommand extends BaseCommand{
    private SwfModelUseDto wfModelUseDto = null;
    /**
     *  ���췽��,����һ��SwfModelUseInsertCommand����
     * @param wfModelUseDto ����wfModelUseDto
     * @throws Exception
     */
    public SwfModelUseInsertCommand(SwfModelUseDto wfModelUseDto) throws Exception {
    		this.wfModelUseDto = wfModelUseDto;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfModelUseFacade blSwfModelUseFacade = new BLSwfModelUseFacade();
        blSwfModelUseFacade.insertAll(this.wfModelUseDto) ;
        return null;
    }
}
