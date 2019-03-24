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
public class PrplcompensatehouseUpdateCommand extends BaseCommand{
    private PrplcompensatehouseDto prplcompensatehouseDtoPrplcompensatehouseDto;
    /**
     * ���췽��,����һ��PrplcompensatehouseUpdateCommand����
     * @param prplcompensatehouseDto ����prplcompensatehouseDto
     * @throws Exception
     */
    public PrplcompensatehouseUpdateCommand(PrplcompensatehouseDto prplcompensatehouseDto)
            throws Exception{
        this.prplcompensatehouseDtoPrplcompensatehouseDto = prplcompensatehouseDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandPrplcompensatehouseDtoImpl()
            throws Exception{
        BLPrplcompensatehouseFacade facade = new BLPrplcompensatehouseFacade();
        facade.update(prplcompensatehouseDtoPrplcompensatehouseDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandPrplcompensatehouseDtoImpl();
        return object;
    }
}
