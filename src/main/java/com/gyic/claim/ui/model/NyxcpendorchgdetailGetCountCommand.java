package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxcpendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxcpendorchgdetailFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxcpendorchgdetailGetCountCommand extends BaseCommand{
    private String stringConditions;
    /**
     * ���췽��,����һ��NyxcpendorchgdetailGetCountCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public NyxcpendorchgdetailGetCountCommand(String conditions)
            throws Exception{
        this.stringConditions = conditions;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        return new Integer(facade.getCount(stringConditions));
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringImpl();
        return object;
    }
}
