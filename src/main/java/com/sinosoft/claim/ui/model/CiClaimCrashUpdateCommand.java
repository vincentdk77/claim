package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLCiClaimCrashFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashUpdateCommand extends BaseCommand{
    private CiClaimCrashDto ciClaimCrashDtoCiClaimCrashDto;
    /**
     * ���췽��,����һ��CiClaimCrashUpdateCommand����
     * @param ciClaimCrashDto ����ciClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashUpdateCommand(CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        this.ciClaimCrashDtoCiClaimCrashDto = ciClaimCrashDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandCiClaimCrashDtoImpl()
            throws Exception{
        BLCiClaimCrashFacade facade = new BLCiClaimCrashFacade();
        facade.update(ciClaimCrashDtoCiClaimCrashDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandCiClaimCrashDtoImpl();
        return object;
    }
}
