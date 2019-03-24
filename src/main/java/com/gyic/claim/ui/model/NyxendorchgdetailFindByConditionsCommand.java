package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxendorchgdetailFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxendorchgdetailFindByConditionsCommand extends BaseCommand{
    private String type; //���ڱ�ʶ��������
    private int intRowsPerPage;
    private int intPageNo;
    private String stringConditions;
    /**
     * ���췽��,����һ��NyxendorchgdetailFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public NyxendorchgdetailFindByConditionsCommand(String conditions)
            throws Exception{
        this.type = "executeCommandStringImpl";
        this.stringConditions = conditions;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        return facade.findByConditions(stringConditions);
    }
    /**
     * ���췽��,����һ��NyxendorchgdetailFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public NyxendorchgdetailFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage)
            throws Exception{
        this.type = "executeCommandStringintintImpl";
        this.stringConditions = conditions;
        this.intPageNo = pageNo;
        this.intRowsPerPage = rowsPerPage;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringintintImpl()
            throws Exception{
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        return facade.findByConditions(stringConditions ,intPageNo ,intRowsPerPage);
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
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