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
public class NyxsettlelisttempDeleteCommand extends BaseCommand{
    private String stringRegistcode;
    private String stringStringtimestamp;
    private int intIndexofsettle;
    /**
     * 构造方法,构造一个NyxsettlelisttempDeleteCommand对象
     * @param registcode 参数registcode
     * @param stringtimestamp 参数stringtimestamp
     * @param indexofsettle 参数indexofsettle
     * @throws Exception
     */
    public NyxsettlelisttempDeleteCommand(String registcode ,String stringtimestamp ,int indexofsettle)
            throws Exception{
        this.stringRegistcode = registcode;
        this.stringStringtimestamp = stringtimestamp;
        this.intIndexofsettle = indexofsettle;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringintImpl()
            throws Exception{
        BLNyxsettlelisttempFacade facade = new BLNyxsettlelisttempFacade();
        facade.delete(stringRegistcode ,stringStringtimestamp ,intIndexofsettle);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringintImpl();
        return object;
    }
}
