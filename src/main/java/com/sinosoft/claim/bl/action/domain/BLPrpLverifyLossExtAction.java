package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLossExt��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLverifyLossExtAction extends BLPrpLverifyLossExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossExtAction.class);

    /**
     * ���캯��
     */
    public BLPrpLverifyLossExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto,String mode)
            throws Exception{
    }
}
