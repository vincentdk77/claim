package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidcode�ӿڴ�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDCodeAction extends BLPrpIDCodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDCodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpIDCodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpIDCodeDto prpIDCodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpIDCodeDto prpIDCodeDto,String mode) throws Exception{
    }
}
