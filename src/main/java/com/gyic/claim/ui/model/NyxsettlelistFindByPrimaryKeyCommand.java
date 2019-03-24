package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxsettlelistFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxsettlelistFindByPrimaryKeyCommand extends BaseCommand{
    private String stringKindcode;
    private String stringItemcode;
    private String stringFcode;
    private String stringNodetype;
    private int intIndexofsettle;
    private String stringSettlelistcode;
    /**
     * ���췽��,����һ��NyxsettlelistFindByPrimaryKeyCommand����
     * @param settlelistcode ����settlelistcode
     * @param fcode ����fcode
     * @param kindcode ����kindcode
     * @param itemcode ����itemcode
     * @param nodetype ����nodetype
     * @param indexofsettle ����indexofsettle
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
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringStringintImpl()
            throws Exception{
        BLNyxsettlelistFacade facade = new BLNyxsettlelistFacade();
        return facade.findByPrimaryKey(stringSettlelistcode ,stringFcode ,stringKindcode ,stringItemcode ,stringNodetype ,intIndexofsettle);
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringStringintImpl();
        return object;
    }
}
