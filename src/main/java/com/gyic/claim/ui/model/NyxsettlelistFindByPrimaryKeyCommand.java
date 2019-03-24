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
public class NyxsettlelistFindByPrimaryKeyCommand extends BaseCommand{
    private String stringKindcode;
    private String stringItemcode;
    private String stringFcode;
    private String stringNodetype;
    private int intIndexofsettle;
    private String stringSettlelistcode;
    /**
     * 构造方法,构造一个NyxsettlelistFindByPrimaryKeyCommand对象
     * @param settlelistcode 参数settlelistcode
     * @param fcode 参数fcode
     * @param kindcode 参数kindcode
     * @param itemcode 参数itemcode
     * @param nodetype 参数nodetype
     * @param indexofsettle 参数indexofsettle
     * @throws Exception
     */
    public NyxsettlelistFindByPrimaryKeyCommand(String settlelistcode ,String fcode ,String kindcode ,String itemcode ,String nodetype ,int indexofsettle)
            throws Exception{
        this.stringSettlelistcode = settlelistcode;
        this.stringFcode = fcode;
        this.stringKindcode = kindcode;
        this.stringItemcode = itemcode;
        this.stringNodetype = nodetype;
        this.intIndexofsettle = indexofsettle;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringStringintImpl()
            throws Exception{
        BLNyxsettlelistFacade facade = new BLNyxsettlelistFacade();
        return facade.findByPrimaryKey(stringSettlelistcode ,stringFcode ,stringKindcode ,stringItemcode ,stringNodetype ,intIndexofsettle);
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringStringintImpl();
        return object;
    }
}
