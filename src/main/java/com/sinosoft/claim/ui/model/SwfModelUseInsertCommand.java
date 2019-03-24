package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfModelUseFacade;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfModelUseFacade的UI Command类<br>
 * 创建于 2004-08-10 10:49:39.367<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseInsertCommand extends BaseCommand{
    private SwfModelUseDto wfModelUseDto = null;
    /**
     *  构造方法,构造一个SwfModelUseInsertCommand对象
     * @param wfModelUseDto 参数wfModelUseDto
     * @throws Exception
     */
    public SwfModelUseInsertCommand(SwfModelUseDto wfModelUseDto) throws Exception {
    		this.wfModelUseDto = wfModelUseDto;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        BLSwfModelUseFacade blSwfModelUseFacade = new BLSwfModelUseFacade();
        blSwfModelUseFacade.insertAll(this.wfModelUseDto) ;
        return null;
    }
}
