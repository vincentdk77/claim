package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxpolicylistoriginFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxpolicylistoriginFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxpolicylistoriginDeleteCommand extends BaseCommand{
    private String stringKindcode;
    private String stringBusinessno;
    private String stringInusrelistcode;
    private String stringItemcode;
    /**
     * ���췽��,����һ��NyxpolicylistoriginDeleteCommand����
     * @param inusrelistcode ����inusrelistcode
     * @param businessno ����businessno
     * @param kindcode ����kindcode
     * @param itemcode ����itemcode
     * @throws Exception
     */
    public NyxpolicylistoriginDeleteCommand(String inusrelistcode ,String businessno ,String kindcode ,String itemcode)
            throws Exception{
        this.stringInusrelistcode = inusrelistcode;
        this.stringBusinessno = businessno;
        this.stringKindcode = kindcode;
        this.stringItemcode = itemcode;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringImpl()
            throws Exception{
        BLNyxpolicylistoriginFacade facade = new BLNyxpolicylistoriginFacade();
        facade.delete(stringInusrelistcode ,stringBusinessno ,stringKindcode ,stringItemcode);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringImpl();
        return object;
    }
}
