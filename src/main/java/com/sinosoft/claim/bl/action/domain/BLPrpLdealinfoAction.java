package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdealinfoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpldealinfo��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLdealinfoAction extends BLPrpLdealinfoActionBase{
    private static Log log = LogFactory.getLog(BLPrpLdealinfoAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLdealinfoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLdealinfoDto prpLdealinfoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLdealinfoDto prpLdealinfoDto,String mode) throws Exception{
    }
}
