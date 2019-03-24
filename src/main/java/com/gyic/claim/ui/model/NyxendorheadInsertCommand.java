package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxendorheadFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxendorheadFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxendorheadInsertCommand extends BaseCommand{
    private NyxendorheadDto nyxendorheadDtoNyxendorheadDto;
    /**
     * ���췽��,����һ��NyxendorheadInsertCommand����
     * @param nyxendorheadDto ����nyxendorheadDto
     * @throws Exception
     */
    public NyxendorheadInsertCommand(NyxendorheadDto nyxendorheadDto)
            throws Exception{
        this.nyxendorheadDtoNyxendorheadDto = nyxendorheadDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxendorheadDtoImpl()
            throws Exception{
        BLNyxendorheadFacade facade = new BLNyxendorheadFacade();
        facade.insert(nyxendorheadDtoNyxendorheadDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxendorheadDtoImpl();
        return object;
    }
}
