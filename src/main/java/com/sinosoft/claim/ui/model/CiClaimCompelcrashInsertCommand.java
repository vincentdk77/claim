package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCiClaimCompelcrashFacade;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLCiClaimCompelcrashFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashInsertCommand extends BaseCommand{
    private CiClaimCompelcrashDto ciClaimCompelcrashDtoCiClaimCompelcrashDto;
    /**
     * ���췽��,����һ��CiClaimCompelcrashInsertCommand����
     * @param ciClaimCompelcrashDto ����ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashInsertCommand(CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        this.ciClaimCompelcrashDtoCiClaimCompelcrashDto = ciClaimCompelcrashDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandCiClaimCompelcrashDtoImpl()
            throws Exception{
        BLCiClaimCompelcrashFacade facade = new BLCiClaimCompelcrashFacade();
        facade.insert(ciClaimCompelcrashDtoCiClaimCompelcrashDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandCiClaimCompelcrashDtoImpl();
        return object;
    }
}
