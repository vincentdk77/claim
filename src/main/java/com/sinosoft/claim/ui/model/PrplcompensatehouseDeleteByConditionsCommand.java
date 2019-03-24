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
public class PrplcompensatehouseDeleteByConditionsCommand extends BaseCommand{
    private String stringConditions;
    /**
     * ���췽��,����һ��PrplcompensatehouseDeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PrplcompensatehouseDeleteByConditionsCommand(String conditions)
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
        BLPrplcompensatehouseFacade facade = new BLPrplcompensatehouseFacade();
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
