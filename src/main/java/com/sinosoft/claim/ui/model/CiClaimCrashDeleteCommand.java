package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCrashFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLCiClaimCrashFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashDeleteCommand extends BaseCommand{
    private int intSerialNo;
    private String stringPolicyNo;
    /**
     * ���췽��,����һ��CiClaimCrashDeleteCommand����
     * @param policyNo ����policyNo
     * @param serialNo ����serialNo
     * @throws Exception
     */
    public CiClaimCrashDeleteCommand(String policyNo ,int serialNo)
            throws Exception{
        this.stringPolicyNo = policyNo;
        this.intSerialNo = serialNo;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringintImpl()
            throws Exception{
        BLCiClaimCrashFacade facade = new BLCiClaimCrashFacade();
        facade.delete(stringPolicyNo ,intSerialNo);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringintImpl();
        return object;
    }
}