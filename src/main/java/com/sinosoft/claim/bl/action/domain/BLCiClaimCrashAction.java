package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����CIClaimCrash ���������¼��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCrashAction extends BLCiClaimCrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCrashAction.class);

    /**
     * ���캯��
     */
    public BLCiClaimCrashAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param ciClaimCrashDto ciClaimCrashDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimCrashDto ciClaimCrashDto,String mode)
            throws Exception{
    }
}
