package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.claim.dto.domain.PrpLpropDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplprop�Ʋ��˶�����ϸ�嵥���ҵ�������չ��<br>
 * ������ 2004-05-09 11:07:45.913<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpropAction extends BLPrpLpropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpropAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpropAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpropDto prpLpropDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpropDto prpLpropDto,String mode) throws Exception{
    }
}
