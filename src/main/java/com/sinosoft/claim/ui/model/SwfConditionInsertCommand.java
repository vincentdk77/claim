package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfConditionFacade;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfConditionFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionInsertCommand extends BaseCommand{
    private SwfConditionDto  swfConditionDto = null;
    /**
     *  构造方法,构造一个SwfConditionInsertCommand对象
     * @param wfConditionDto 参数wfConditionDto
     * @throws Exception
     */
    public SwfConditionInsertCommand(SwfConditionDto swfConditionDto) throws Exception {
    		this.swfConditionDto = swfConditionDto;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfConditionFacade blSwfConditionFacade = new BLSwfConditionFacade();
        blSwfConditionFacade.insert(this.swfConditionDto ) ;
        return null;
    }
}
