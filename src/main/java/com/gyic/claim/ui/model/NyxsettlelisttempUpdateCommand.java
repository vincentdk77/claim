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
public class NyxsettlelisttempUpdateCommand extends BaseCommand{
    private NyxsettlelisttempDto nyxsettlelisttempDtoNyxsettlelisttempDto;
    /**
     * ���췽��,����һ��NyxsettlelisttempUpdateCommand����
     * @param nyxsettlelisttempDto ����nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempUpdateCommand(NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        this.nyxsettlelisttempDtoNyxsettlelisttempDto = nyxsettlelisttempDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxsettlelisttempDtoImpl()
            throws Exception{
        BLNyxsettlelisttempFacade facade = new BLNyxsettlelisttempFacade();
        facade.update(nyxsettlelisttempDtoNyxsettlelisttempDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxsettlelisttempDtoImpl();
        return object;
    }
}
