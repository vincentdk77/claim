package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLendor��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorAction extends BLPrpLendorActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorAction.class);

    /**
     * ���캯��
     */
    public BLPrpLendorAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLendorDto prpLendorDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLendorDto prpLendorDto,String mode)
            throws Exception{
    }
}
