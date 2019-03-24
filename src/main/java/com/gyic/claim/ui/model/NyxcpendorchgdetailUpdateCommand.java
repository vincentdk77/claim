package com.gyic.claim.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.gyic.claim.bl.facade.BLNyxcpendorchgdetailFacade;
import com.gyic.claim.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLNyxcpendorchgdetailFacade��UI Command�࣬���ڼ���ʽ����<br>
 */
public class NyxcpendorchgdetailUpdateCommand extends BaseCommand{
    private NyxcpendorchgdetailDto nyxcpendorchgdetailDtoNyxcpendorchgdetailDto;
    /**
     * ���췽��,����һ��NyxcpendorchgdetailUpdateCommand����
     * @param nyxcpendorchgdetailDto ����nyxcpendorchgdetailDto
     * @throws Exception
     */
    public NyxcpendorchgdetailUpdateCommand(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        this.nyxcpendorchgdetailDtoNyxcpendorchgdetailDto = nyxcpendorchgdetailDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandNyxcpendorchgdetailDtoImpl()
            throws Exception{
        BLNyxcpendorchgdetailFacade facade = new BLNyxcpendorchgdetailFacade();
        facade.update(nyxcpendorchgdetailDtoNyxcpendorchgdetailDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandNyxcpendorchgdetailDtoImpl();
        return object;
    }
}
