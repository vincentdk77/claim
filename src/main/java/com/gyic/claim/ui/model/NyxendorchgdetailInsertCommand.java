package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxendorchgdetailFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxendorchgdetailInsertCommand extends BaseCommand{
    private NyxendorchgdetailDto nyxendorchgdetailDtoNyxendorchgdetailDto;
    /**
     * ���췽��,����һ��NyxendorchgdetailInsertCommand����
     * @param nyxendorchgdetailDto ����nyxendorchgdetailDto
     * @throws Exception
     */
    public NyxendorchgdetailInsertCommand(NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        this.nyxendorchgdetailDtoNyxendorchgdetailDto = nyxendorchgdetailDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxendorchgdetailDtoImpl()
            throws Exception{
        BLNyxendorchgdetailFacade facade = new BLNyxendorchgdetailFacade();
        facade.insert(nyxendorchgdetailDtoNyxendorchgdetailDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxendorchgdetailDtoImpl();
        return object;
    }
}
