package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxsettlelisttempFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxsettlelisttempFacade的UI Command类，用于集中式部署<br>
 */
public class NyxsettlelisttempUpdateCommand extends BaseCommand{
    private NyxsettlelisttempDto nyxsettlelisttempDtoNyxsettlelisttempDto;
    /**
     * 构造方法,构造一个NyxsettlelisttempUpdateCommand对象
     * @param nyxsettlelisttempDto 参数nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempUpdateCommand(NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        this.nyxsettlelisttempDtoNyxsettlelisttempDto = nyxsettlelisttempDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandNyxsettlelisttempDtoImpl()
            throws Exception{
        BLNyxsettlelisttempFacade facade = new BLNyxsettlelisttempFacade();
        facade.update(nyxsettlelisttempDtoNyxsettlelisttempDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxsettlelisttempDtoImpl();
        return object;
    }
}
