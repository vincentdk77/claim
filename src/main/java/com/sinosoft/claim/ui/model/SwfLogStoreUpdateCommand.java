package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLSwfLogStoreFacade��UI Command�࣬���ڼ���ʽ����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreUpdateCommand extends BaseCommand{
    private SwfLogStoreDto swfLogStoreDtoSwfLogStoreDto;
    /**
     * ���췽��,����һ��SwfLogStoreUpdateCommand����
     * @param swfLogStoreDto ����swfLogStoreDto
     * @throws Exception
     */
    public SwfLogStoreUpdateCommand(SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        this.swfLogStoreDtoSwfLogStoreDto = swfLogStoreDto;
    }
    /**
     * ִ�з���
     * @return ִ�н��
     * @throws Exception
     */
    private Object executeCommandSwfLogStoreDtoImpl()
            throws Exception{
        BLSwfLogStoreFacade facade = new BLSwfLogStoreFacade();
        facade.update(swfLogStoreDtoSwfLogStoreDto);
        return null;
    }
    /**
     * ִ�з��� (����ֱ�ӵ��ô˷����������execute����)
     * @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        object = executeCommandSwfLogStoreDtoImpl();
        return object;
    }
}
