package com.sinosoft.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLPrplcompensatehouseFacade的UI Command类，用于集中式部署<br>
 */
public class PrplcompensatehouseGetCountCommand extends BaseCommand{
    private String stringConditions;
    /**
     * 构造方法,构造一个PrplcompensatehouseGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrplcompensatehouseGetCountCommand(String conditions)
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
        BLPrplcompensatehouseFacade facade = new BLPrplcompensatehouseFacade();
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
