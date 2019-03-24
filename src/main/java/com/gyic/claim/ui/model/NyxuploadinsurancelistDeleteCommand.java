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
public class NyxuploadinsurancelistDeleteCommand extends BaseCommand{
    private String stringBusinessno;
    private String stringInusrelistcode;
    private String stringMulchtype;
    /**
     * ���췽��,����һ��NyxuploadinsurancelistDeleteCommand����
     * @param inusrelistcode ����inusrelistcode
     * @param businessno ����businessno
     * @param mulchtype ����mulchtype
     * @throws Exception
     */
    public NyxuploadinsurancelistDeleteCommand(String inusrelistcode ,String businessno ,String mulchtype)
            throws Exception{
        this.stringInusrelistcode = inusrelistcode;
        this.stringBusinessno = businessno;
        this.stringMulchtype = mulchtype;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringStringImpl()
            throws Exception{
        BLNyxuploadinsurancelistFacade facade = new BLNyxuploadinsurancelistFacade();
        facade.delete(stringInusrelistcode ,stringBusinessno ,stringMulchtype);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringImpl();
        return object;
    }
}
