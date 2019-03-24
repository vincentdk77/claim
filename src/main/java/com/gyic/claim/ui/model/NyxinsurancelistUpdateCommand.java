package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxinsurancelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxinsurancelistFacade的UI Command类，用于集中式部署<br>
 */
public class NyxinsurancelistUpdateCommand extends BaseCommand{
    private NyxinsurancelistDto nyxinsurancelistDtoNyxinsurancelistDto;
    /**
     * 构造方法,构造一个NyxinsurancelistUpdateCommand对象
     * @param nyxinsurancelistDto 参数nyxinsurancelistDto
     * @throws Exception
     */
    public NyxinsurancelistUpdateCommand(NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        this.nyxinsurancelistDtoNyxinsurancelistDto = nyxinsurancelistDto;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandNyxinsurancelistDtoImpl()
            throws Exception{
        BLNyxinsurancelistFacade facade = new BLNyxinsurancelistFacade();
        facade.update(nyxinsurancelistDtoNyxinsurancelistDto);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxinsurancelistDtoImpl();
        return object;
    }
}
