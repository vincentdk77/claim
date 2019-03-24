package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxuploadinsurancelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxuploadinsurancelistFacade的UI Command类，用于集中式部署<br>
 */
public class NyxuploadinsurancelistUpdateCommand extends BaseCommand{
    private NyxuploadinsurancelistDto nyxuploadinsurancelistDtoNyxuploadinsurancelistDto;
    /**
     * 构造方法,构造一个NyxuploadinsurancelistUpdateCommand对象
     * @param nyxuploadinsurancelistDto 参数nyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistUpdateCommand(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        this.nyxuploadinsurancelistDtoNyxuploadinsurancelistDto = nyxuploadinsurancelistDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandNyxuploadinsurancelistDtoImpl()
            throws Exception{
        BLNyxuploadinsurancelistFacade facade = new BLNyxuploadinsurancelistFacade();
        facade.update(nyxuploadinsurancelistDtoNyxuploadinsurancelistDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxuploadinsurancelistDtoImpl();
        return object;
    }
}
