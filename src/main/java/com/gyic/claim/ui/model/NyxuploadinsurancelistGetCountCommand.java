package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxuploadinsurancelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxuploadinsurancelistFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxuploadinsurancelistGetCountCommand extends BaseCommand{
    private String stringConditions;
    /**
     * ���췽��,����һ��NyxuploadinsurancelistGetCountCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public NyxuploadinsurancelistGetCountCommand(String conditions)
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
        BLNyxuploadinsurancelistFacade facade = new BLNyxuploadinsurancelistFacade();
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
