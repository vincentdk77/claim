package com.sinosoft.claimciplatform.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣƽ̨�ϴ�ע����ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistAction extends BLCIClaimUploadRegistActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadRegistAction.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadRegistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto,String mode)
            throws Exception{
    }
}
