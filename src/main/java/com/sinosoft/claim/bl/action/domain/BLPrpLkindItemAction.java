package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǳб��ձ��ı��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemAction extends BLPrpLkindItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemAction.class);

    /**
     * ���캯��
     */
    public BLPrpLkindItemAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLkindItemDto prpLkindItemDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLkindItemDto prpLkindItemDto,String mode)
            throws Exception{
    }
}
