package com.sinosoft.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLPrplcompensatehouseFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class PrplcompensatehouseDeleteCommand extends BaseCommand{
    private String stringBusinessno;
    private String stringIdcard;
    private String stringNodetype;
    private String stringRegistno;
    /**
     * ���췽��,����һ��PrplcompensatehouseDeleteCommand����
     * @param idcard ����idcard
     * @param registno ����registno
     * @param nodetype ����nodetype
     * @param businessno ����businessno
     * @throws Exception
     */
    public PrplcompensatehouseDeleteCommand(String idcard ,String registno ,String nodetype ,String businessno)
            throws Exception{
        this.stringIdcard = idcard;
        this.stringRegistno = registno;
        this.stringNodetype = nodetype;
        this.stringBusinessno = businessno;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringStringStringImpl()
            throws Exception{
        BLPrplcompensatehouseFacade facade = new BLPrplcompensatehouseFacade();
        facade.delete(stringIdcard ,stringRegistno ,stringNodetype ,stringBusinessno);
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
