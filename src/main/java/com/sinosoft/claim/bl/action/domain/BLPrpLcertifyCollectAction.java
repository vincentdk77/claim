package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyCollect��ҵ�������չ��<br>
 * ������ 2004-07-05 17:16:11.606<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertifyCollectAction extends BLPrpLcertifyCollectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyCollectAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto,String mode) throws Exception{
    }
}
