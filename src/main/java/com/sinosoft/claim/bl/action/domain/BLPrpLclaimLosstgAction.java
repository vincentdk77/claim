package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLosstgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss��ҵ�������չ��<br>
 * ������ 2004-06-24 14:46:15.079<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLosstgAction extends BLPrpLclaimLosstgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLosstgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLosstgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimLosstgDto prpLclaimLosstgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimLosstgDto prpLclaimLosstgDto,String mode) throws Exception{
    }
}
