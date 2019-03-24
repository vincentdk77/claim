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
public class NyxsettlelisttempFindByPrimaryKeyCommand extends BaseCommand{
    private String stringRegistcode;
    private String stringStringtimestamp;
    private int intIndexofsettle;
    /**
     * ���췽��,����һ��NyxsettlelisttempFindByPrimaryKeyCommand����
     * @param registcode ����registcode
     * @param stringtimestamp ����stringtimestamp
     * @param indexofsettle ����indexofsettle
     * @throws Exception
     */
    public NyxsettlelisttempFindByPrimaryKeyCommand(String registcode ,String stringtimestamp ,int indexofsettle)
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
        return facade.findByPrimaryKey(stringRegistcode ,stringStringtimestamp ,intIndexofsettle);
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
