package com.sinosoft.ciplatform.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimDemandFacade;
import com.sinosoft.claimciplatform.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLCiClaimDemandFacade的UI Command类，用于集中式部署<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimDemandFindByPrimaryKeyCommand extends BaseCommand{
    private String stringClaimCode;
    /**
     * 构造方法,构造一个CiClaimDemandFindByPrimaryKeyCommand对象
     * @param claimCode 参数claimCode
     * @throws Exception
     */
    public CIClaimDemandFindByPrimaryKeyCommand(String claimCode)
            throws Exception{
        this.stringClaimCode = claimCode;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLCIClaimDemandFacade facade = new BLCIClaimDemandFacade();
        return facade.findByPrimaryKey(stringClaimCode);
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
