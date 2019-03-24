package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxendorheadFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxendorheadFacade的UI Command类，用于集中式部署<br>
 */
public class NyxendorheadFindByPrimaryKeyCommand extends BaseCommand{
    private String stringEndorseno;
    /**
     * 构造方法,构造一个NyxendorheadFindByPrimaryKeyCommand对象
     * @param endorseno 参数endorseno
     * @throws Exception
     */
    public NyxendorheadFindByPrimaryKeyCommand(String endorseno)
            throws Exception{
        this.stringEndorseno = endorseno;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLNyxendorheadFacade facade = new BLNyxendorheadFacade();
        return facade.findByPrimaryKey(stringEndorseno);
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
