package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfConditionFacade;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfConditionFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionInsertCommand extends BaseCommand{
    private SwfConditionDto  swfConditionDto = null;
    /**
     *  ���췽��,����һ��SwfConditionInsertCommand����
     * @param wfConditionDto ����wfConditionDto
     * @throws Exception
     */
    public SwfConditionInsertCommand(SwfConditionDto swfConditionDto) throws Exception {
    		this.swfConditionDto = swfConditionDto;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfConditionFacade blSwfConditionFacade = new BLSwfConditionFacade();
        blSwfConditionFacade.insert(this.swfConditionDto ) ;
        return null;
    }
}
