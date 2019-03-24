package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxsettlelisttempFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxsettlelisttempFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxsettlelisttempDeleteCommand extends BaseCommand{
    private String stringRegistcode;
    private String stringStringtimestamp;
    private int intIndexofsettle;
    /**
     * ���췽��,����һ��NyxsettlelisttempDeleteCommand����
     * @param registcode ����registcode
     * @param stringtimestamp ����stringtimestamp
     * @param indexofsettle ����indexofsettle
     * @throws Exception
     */
    public NyxsettlelisttempDeleteCommand(String registcode ,String stringtimestamp ,int indexofsettle)
            throws Exception{
        this.stringRegistcode = registcode;
        this.stringStringtimestamp = stringtimestamp;
        this.intIndexofsettle = indexofsettle;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringintImpl()
            throws Exception{
        BLNyxsettlelisttempFacade facade = new BLNyxsettlelisttempFacade();
        facade.delete(stringRegistcode ,stringStringtimestamp ,intIndexofsettle);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringintImpl();
        return object;
    }
}
