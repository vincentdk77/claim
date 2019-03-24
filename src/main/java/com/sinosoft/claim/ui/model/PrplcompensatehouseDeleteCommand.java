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
public class PrplcompensatehouseDeleteCommand extends BaseCommand{
    private String stringBusinessno;
    private String stringIdcard;
    private String stringNodetype;
    private String stringRegistno;
    /**
     * 构造方法,构造一个PrplcompensatehouseDeleteCommand对象
     * @param idcard 参数idcard
     * @param registno 参数registno
     * @param nodetype 参数nodetype
     * @param businessno 参数businessno
     * @throws Exception
     */
    public PrplcompensatehouseDeleteCommand(String idcard ,String registno ,String nodetype ,String businessno)
            throws Exception{
        this.stringIdcard = idcard;
        this.stringRegistno = registno;
        this.stringNodetype = nodetype;
        this.stringBusinessno = businessno;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringImpl()
            throws Exception{
        BLPrplcompensatehouseFacade facade = new BLPrplcompensatehouseFacade();
        facade.delete(stringIdcard ,stringRegistno ,stringNodetype ,stringBusinessno);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringImpl();
        return object;
    }
}
