package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxsettlelistFacade的UI Command类，用于集中式部署<br>
 */
public class NyxsettlelistUpdateCommand extends BaseCommand{
    private NyxsettlelistDto nyxsettlelistDtoNyxsettlelistDto;
    /**
     * 构造方法,构造一个NyxsettlelistUpdateCommand对象
     * @param nyxsettlelistDto 参数nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistUpdateCommand(NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        this.nyxsettlelistDtoNyxsettlelistDto = nyxsettlelistDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandNyxsettlelistDtoImpl()
            throws Exception{
        BLNyxsettlelistFacade facade = new BLNyxsettlelistFacade();
        facade.update(nyxsettlelistDtoNyxsettlelistDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxsettlelistDtoImpl();
        return object;
    }
}
