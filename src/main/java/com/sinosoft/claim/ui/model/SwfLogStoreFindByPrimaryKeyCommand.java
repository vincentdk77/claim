package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLSwfLogStoreFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreFindByPrimaryKeyCommand extends BaseCommand{
    private String stringFlowID;
    private int logno;
    /**
     * 构造方法,构造一个SwfLogStoreFindByPrimaryKeyCommand对象
     * @param flowID 参数flowID
     * @throws Exception
     */
    public SwfLogStoreFindByPrimaryKeyCommand(String flowID)
            throws Exception{
        this.stringFlowID = flowID;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLSwfLogStoreFacade facade = new BLSwfLogStoreFacade();
        return facade.findByPrimaryKey(stringFlowID,logno);
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringImpl();
        return object;
    }
}
