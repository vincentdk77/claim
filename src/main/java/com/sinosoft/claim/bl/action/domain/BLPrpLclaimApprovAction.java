package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov��������ת��ȷ�ϱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimApprovAction extends BLPrpLclaimApprovActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimApprovAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimApprovAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimApprovDto prpLclaimApprovDto,String mode) throws Exception{
    }
}
