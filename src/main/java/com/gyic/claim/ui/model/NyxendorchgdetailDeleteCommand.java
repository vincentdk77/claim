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
public class NyxendorchgdetailDeleteCommand extends BaseCommand{
    private String stringKindcode;
    private String stringEndorseno;
    private String stringBusinessno;
    private String stringInusrelistcode;
    private String stringItemcode;
    /**
     * ���췽��,����һ��NyxendorchgdetailDeleteCommand����
     * @param inusrelistcode ����inusrelistcode
     * @param businessno ����businessno
     * @param endorseno ����endorseno
     * @param kindcode ����kindcode
     * @param itemcode ����itemcode
     * @throws Exception
     */
    public NyxendorchgdetailDeleteCommand(String inusrelistcode ,String businessno ,String endorseno ,String kindcode ,String itemcode)
            throws Exception{
        this.stringInusrelistcode = inusrelistcode;
        this.stringBusinessno = businessno;
        this.stringEndorseno = endorseno;
        this.stringKindcode = kindcode;
        this.stringItemcode = itemcode;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringStringImpl()
            throws Exception{
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        facade.delete(stringInusrelistcode ,stringBusinessno ,stringEndorseno ,stringKindcode ,stringItemcode);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringStringStringStringImpl();
        return object;
    }
}
