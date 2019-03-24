package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxpolicylistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxpolicylistFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxpolicylistInsertCommand extends BaseCommand{
    private NyxpolicylistDto nyxpolicylistDtoNyxpolicylistDto;
    /**
     * ���췽��,����һ��NyxpolicylistInsertCommand����
     * @param nyxpolicylistDto ����nyxpolicylistDto
     * @throws Exception
     */
    public NyxpolicylistInsertCommand(NyxpolicylistDto nyxpolicylistDto)
            throws Exception{
        this.nyxpolicylistDtoNyxpolicylistDto = nyxpolicylistDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxpolicylistDtoImpl()
            throws Exception{
        BLNyxpolicylistFacade facade = new BLNyxpolicylistFacade();
        facade.insert(nyxpolicylistDtoNyxpolicylistDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxpolicylistDtoImpl();
        return object;
    }
}
