package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCompelcrashFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLCiClaimCompelcrashFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashDeleteCommand extends BaseCommand{
    private String stringRegistNo;
    private String stringPolicyNo;
    /**
     * ���췽��,����һ��CiClaimCompelcrashDeleteCommand����
     * @param registNo ����registNo
     * @param policyNo ����policyNo
     * @throws Exception
     */
    public CiClaimCompelcrashDeleteCommand(String registNo ,String policyNo)
            throws Exception{
        this.stringRegistNo = registNo;
        this.stringPolicyNo = policyNo;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandStringStringImpl()
            throws Exception{
        BLCiClaimCompelcrashFacade facade = new BLCiClaimCompelcrashFacade();
        facade.delete(stringRegistNo ,stringPolicyNo);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandStringStringImpl();
        return object;
    }
}
