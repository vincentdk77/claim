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
public class NyxsettlelistUpdateCommand extends BaseCommand{
    private NyxsettlelistDto nyxsettlelistDtoNyxsettlelistDto;
    /**
     * ���췽��,����һ��NyxsettlelistUpdateCommand����
     * @param nyxsettlelistDto ����nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistUpdateCommand(NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        this.nyxsettlelistDtoNyxsettlelistDto = nyxsettlelistDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxsettlelistDtoImpl()
            throws Exception{
        BLNyxsettlelistFacade facade = new BLNyxsettlelistFacade();
        facade.update(nyxsettlelistDtoNyxsettlelistDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxsettlelistDtoImpl();
        return object;
    }
}
