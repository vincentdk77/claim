package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdAgentSysData��ҵ�������չ��<br>
 * ������ 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdAgentSysDataAction extends BLEdAgentSysDataActionBase{
    private static Log logger = LogFactory.getLog(BLEdAgentSysDataAction.class);

    /**
     * ���캯��
     */
    public BLEdAgentSysDataAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param edAgentSysDataDto edAgentSysDataDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto,String mode) throws Exception{
    }
}
