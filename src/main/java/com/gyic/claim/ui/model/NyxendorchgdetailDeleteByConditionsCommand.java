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
public class NyxendorchgdetailDeleteByConditionsCommand extends BaseCommand{
    private String stringConditions;
    /**
     * ���췽��,����һ��NyxendorchgdetailDeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public NyxendorchgdetailDeleteByConditionsCommand(String conditions)
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
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        facade.deleteByConditions(stringConditions);
        return null;
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
