package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCrashFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLCiClaimCrashFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashFindByPrimaryKeyCommand extends BaseCommand{
    private int intSerialNo;
    private String stringPolicyNo;
    /**
     * 构造方法,构造一个CiClaimCrashFindByPrimaryKeyCommand对象
     * @param policyNo 参数policyNo
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public CiClaimCrashFindByPrimaryKeyCommand(String policyNo ,int serialNo)
            throws Exception{
        this.stringPolicyNo = policyNo;
        this.intSerialNo = serialNo;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringintImpl()
            throws Exception{
        BLCiClaimCrashFacade facade = new BLCiClaimCrashFacade();
        return facade.findByPrimaryKey(stringPolicyNo ,intSerialNo);
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringintImpl();
        return object;
    }
}
