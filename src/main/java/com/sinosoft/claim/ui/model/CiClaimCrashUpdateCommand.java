package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLCiClaimCrashFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashUpdateCommand extends BaseCommand{
    private CiClaimCrashDto ciClaimCrashDtoCiClaimCrashDto;
    /**
     * 构造方法,构造一个CiClaimCrashUpdateCommand对象
     * @param ciClaimCrashDto 参数ciClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashUpdateCommand(CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        this.ciClaimCrashDtoCiClaimCrashDto = ciClaimCrashDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandCiClaimCrashDtoImpl()
            throws Exception{
        BLCiClaimCrashFacade facade = new BLCiClaimCrashFacade();
        facade.update(ciClaimCrashDtoCiClaimCrashDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandCiClaimCrashDtoImpl();
        return object;
    }
}
