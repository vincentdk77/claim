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
public class NyxuploadinsurancelistFindByPrimaryKeyCommand extends BaseCommand{
    private String stringBusinessno;
    private String stringInusrelistcode;
    private String stringMulchtype;
    /**
     * 构造方法,构造一个NyxuploadinsurancelistFindByPrimaryKeyCommand对象
     * @param inusrelistcode 参数inusrelistcode
     * @param businessno 参数businessno
     * @param mulchtype 参数mulchtype
     * @throws Exception
     */
    public NyxuploadinsurancelistFindByPrimaryKeyCommand(String inusrelistcode ,String businessno ,String mulchtype)
            throws Exception{
        this.stringInusrelistcode = inusrelistcode;
        this.stringBusinessno = businessno;
        this.stringMulchtype = mulchtype;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringStringImpl()
            throws Exception{
        BLNyxuploadinsurancelistFacade facade = new BLNyxuploadinsurancelistFacade();
        return facade.findByPrimaryKey(stringInusrelistcode ,stringBusinessno ,stringMulchtype);
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringImpl();
        return object;
    }
}
