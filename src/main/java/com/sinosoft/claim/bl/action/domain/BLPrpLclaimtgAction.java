package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaim����������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimtgAction extends BLPrpLclaimtgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimtgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimtgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimtgDto prpLclaimtgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto,String mode) throws Exception{
    }
}
