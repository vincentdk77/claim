package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovtgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov��������ת��ȷ�ϱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimApprovtgAction extends BLPrpLclaimApprovtgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimApprovtgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimApprovtgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto,String mode) throws Exception{
    }
}
