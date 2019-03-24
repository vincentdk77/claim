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
public class NyxpolicylistoriginUpdateCommand extends BaseCommand{
    private NyxpolicylistoriginDto nyxpolicylistoriginDtoNyxpolicylistoriginDto;
    /**
     * ���췽��,����һ��NyxpolicylistoriginUpdateCommand����
     * @param nyxpolicylistoriginDto ����nyxpolicylistoriginDto
     * @throws Exception
     */
    public NyxpolicylistoriginUpdateCommand(NyxpolicylistoriginDto nyxpolicylistoriginDto)
            throws Exception{
        this.nyxpolicylistoriginDtoNyxpolicylistoriginDto = nyxpolicylistoriginDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxpolicylistoriginDtoImpl()
            throws Exception{
        BLNyxpolicylistoriginFacade facade = new BLNyxpolicylistoriginFacade();
        facade.update(nyxpolicylistoriginDtoNyxpolicylistoriginDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxpolicylistoriginDtoImpl();
        return object;
    }
}
