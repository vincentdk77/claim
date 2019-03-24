package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxinsurancelistFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxinsurancelistFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxinsurancelistInsertCommand extends BaseCommand{
    private NyxinsurancelistDto nyxinsurancelistDtoNyxinsurancelistDto;
    /**
     * ���췽��,����һ��NyxinsurancelistInsertCommand����
     * @param nyxinsurancelistDto ����nyxinsurancelistDto
     * @throws Exception
     */
    public NyxinsurancelistInsertCommand(NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        this.nyxinsurancelistDtoNyxinsurancelistDto = nyxinsurancelistDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxinsurancelistDtoImpl()
            throws Exception{
        BLNyxinsurancelistFacade facade = new BLNyxinsurancelistFacade();
        facade.insert(nyxinsurancelistDtoNyxinsurancelistDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxinsurancelistDtoImpl();
        return object;
    }
}
