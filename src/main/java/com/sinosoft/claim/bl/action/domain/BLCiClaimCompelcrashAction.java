package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����CIClaimCompelcrash ���⳵���������ݱ��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashAction extends BLCiClaimCompelcrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashAction.class);

    /**
     * ���캯��
     */
    public BLCiClaimCompelcrashAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto,String mode)
            throws Exception{
    }
}
