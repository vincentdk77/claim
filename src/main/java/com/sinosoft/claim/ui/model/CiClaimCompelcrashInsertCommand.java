package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCompelcrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLCiClaimCompelcrashFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashInsertCommand extends BaseCommand{
    private CiClaimCompelcrashDto ciClaimCompelcrashDtoCiClaimCompelcrashDto;
    /**
     * 构造方法,构造一个CiClaimCompelcrashInsertCommand对象
     * @param ciClaimCompelcrashDto 参数ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashInsertCommand(CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        this.ciClaimCompelcrashDtoCiClaimCompelcrashDto = ciClaimCompelcrashDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandCiClaimCompelcrashDtoImpl()
            throws Exception{
        BLCiClaimCompelcrashFacade facade = new BLCiClaimCompelcrashFacade();
        facade.insert(ciClaimCompelcrashDtoCiClaimCompelcrashDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandCiClaimCompelcrashDtoImpl();
        return object;
    }
}
