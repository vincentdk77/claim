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
public class NyxuploadinsurancelistInsertCommand extends BaseCommand{
    private NyxuploadinsurancelistDto nyxuploadinsurancelistDtoNyxuploadinsurancelistDto;
    /**
     * ���췽��,����һ��NyxuploadinsurancelistInsertCommand����
     * @param nyxuploadinsurancelistDto ����nyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistInsertCommand(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        this.nyxuploadinsurancelistDtoNyxuploadinsurancelistDto = nyxuploadinsurancelistDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxuploadinsurancelistDtoImpl()
            throws Exception{
        BLNyxuploadinsurancelistFacade facade = new BLNyxuploadinsurancelistFacade();
        facade.insert(nyxuploadinsurancelistDtoNyxuploadinsurancelistDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxuploadinsurancelistDtoImpl();
        return object;
    }
}
