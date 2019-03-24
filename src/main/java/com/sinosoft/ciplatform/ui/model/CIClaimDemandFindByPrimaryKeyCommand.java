package com.sinosoft.ciplatform.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimDemandFacade;
import com.sinosoft.claimciplatform.dto.domain.*;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLCiClaimDemandFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimDemandFindByPrimaryKeyCommand extends BaseCommand{
    private String stringClaimCode;
    /**
     * ���췽��,����һ��CiClaimDemandFindByPrimaryKeyCommand����
     * @param claimCode ����claimCode
     * @throws Exception
     */
    public CIClaimDemandFindByPrimaryKeyCommand(String claimCode)
            throws Exception{
        this.stringClaimCode = claimCode;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringImpl()
            throws Exception{
        BLCIClaimDemandFacade facade = new BLCIClaimDemandFacade();
        return facade.findByPrimaryKey(stringClaimCode);
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringImpl();
        return object;
    }
}
