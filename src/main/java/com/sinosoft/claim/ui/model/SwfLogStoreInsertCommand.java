package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLSwfLogStoreFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreInsertCommand extends BaseCommand{
    private SwfLogStoreDto swfLogStoreDtoSwfLogStoreDto;
    /**
     * 构造方法,构造一个SwfLogStoreInsertCommand对象
     * @param swfLogStoreDto 参数swfLogStoreDto
     * @throws Exception
     */
    public SwfLogStoreInsertCommand(SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        this.swfLogStoreDtoSwfLogStoreDto = swfLogStoreDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandSwfLogStoreDtoImpl()
            throws Exception{
        BLSwfLogStoreFacade facade = new BLSwfLogStoreFacade();
        facade.insert(swfLogStoreDtoSwfLogStoreDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandSwfLogStoreDtoImpl();
        return object;
    }
}
