package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCompelcrashFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLCiClaimCompelcrashFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashDeleteCommand extends BaseCommand{
    private String stringRegistNo;
    private String stringPolicyNo;
    /**
     * 构造方法,构造一个CiClaimCompelcrashDeleteCommand对象
     * @param registNo 参数registNo
     * @param policyNo 参数policyNo
     * @throws Exception
     */
    public CiClaimCompelcrashDeleteCommand(String registNo ,String policyNo)
            throws Exception{
        this.stringRegistNo = registNo;
        this.stringPolicyNo = policyNo;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringImpl()
            throws Exception{
        BLCiClaimCompelcrashFacade facade = new BLCiClaimCompelcrashFacade();
        facade.delete(stringRegistNo ,stringPolicyNo);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringImpl();
        return object;
    }
}
