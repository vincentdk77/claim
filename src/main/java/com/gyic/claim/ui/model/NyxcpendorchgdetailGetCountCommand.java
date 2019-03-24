package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxcpendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxcpendorchgdetailFacade的UI Command类，用于集中式部署<br>
 */
public class NyxcpendorchgdetailGetCountCommand extends BaseCommand{
    private String stringConditions;
    /**
     * 构造方法,构造一个NyxcpendorchgdetailGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public NyxcpendorchgdetailGetCountCommand(String conditions)
            throws Exception{
        this.stringConditions = conditions;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        return new Integer(facade.getCount(stringConditions));
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
