package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxcpendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLNyxcpendorchgdetailFacade的UI Command类，用于集中式部署<br>
 */
public class NyxcpendorchgdetailFindByConditionsCommand extends BaseCommand{
    private String type; //用于标识方法类型
    private int intRowsPerPage;
    private int intPageNo;
    private String stringConditions;
    /**
     * 构造方法,构造一个NyxcpendorchgdetailFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public NyxcpendorchgdetailFindByConditionsCommand(String conditions)
            throws Exception{
        this.type = "executeCommandStringImpl";
        this.stringConditions = conditions;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        return facade.findByConditions(stringConditions);
    }
    /**
     * 构造方法,构造一个NyxcpendorchgdetailFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public NyxcpendorchgdetailFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage)
            throws Exception{
        this.type = "executeCommandStringintintImpl";
        this.stringConditions = conditions;
        this.intPageNo = pageNo;
        this.intRowsPerPage = rowsPerPage;
    }
    /**
     * 执行方法
     * @return 执行结果
     * @throws Exception
     */
    private Object executeCommandStringintintImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        return facade.findByConditions(stringConditions ,intPageNo ,intRowsPerPage);
    }
    /**
     * 执行方法 (请勿直接调用此方法，请调用execute方法)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        if (type.equals("executeCommandStringImpl")){
            object = executeCommandStringImpl();
        } else if (type.equals("executeCommandStringintintImpl")){
            object = executeCommandStringintintImpl();
        } else {
            throw new UnsupportedOperationException(type);
        }
        return object;
    }
}
