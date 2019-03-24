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
public class NyxcpendorchgdetailUpdateCommand extends BaseCommand{
    private NyxcpendorchgdetailDto nyxcpendorchgdetailDtoNyxcpendorchgdetailDto;
    /**
     * 构造方法,构造一个NyxcpendorchgdetailUpdateCommand对象
     * @param nyxcpendorchgdetailDto 参数nyxcpendorchgdetailDto
     * @throws Exception
     */
    public NyxcpendorchgdetailUpdateCommand(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        this.nyxcpendorchgdetailDtoNyxcpendorchgdetailDto = nyxcpendorchgdetailDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandNyxcpendorchgdetailDtoImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        facade.update(nyxcpendorchgdetailDtoNyxcpendorchgdetailDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxcpendorchgdetailDtoImpl();
        return object;
    }
}
