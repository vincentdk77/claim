package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxendorchgdetailFacade的UI Command类，用于集中式部署<br>
 */
public class NyxendorchgdetailDeleteCommand extends BaseCommand{
    private String stringKindcode;
    private String stringEndorseno;
    private String stringBusinessno;
    private String stringInusrelistcode;
    private String stringItemcode;
    /**
     * 构造方法,构造一个NyxendorchgdetailDeleteCommand对象
     * @param inusrelistcode 参数inusrelistcode
     * @param businessno 参数businessno
     * @param endorseno 参数endorseno
     * @param kindcode 参数kindcode
     * @param itemcode 参数itemcode
     * @throws Exception
     */
    public NyxendorchgdetailDeleteCommand(String inusrelistcode ,String businessno ,String endorseno ,String kindcode ,String itemcode)
            throws Exception{
        this.stringInusrelistcode = inusrelistcode;
        this.stringBusinessno = businessno;
        this.stringEndorseno = endorseno;
        this.stringKindcode = kindcode;
        this.stringItemcode = itemcode;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringStringImpl()
            throws Exception{
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        facade.delete(stringInusrelistcode ,stringBusinessno ,stringEndorseno ,stringKindcode ,stringItemcode);
        return null;
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringStringImpl();
        return object;
    }
}
