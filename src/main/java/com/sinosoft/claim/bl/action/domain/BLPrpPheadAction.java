package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpphead������Ϣ���ҵ�������չ��<br>
 * ������ 2004-11-22 15:24:30.890<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPheadAction extends BLPrpPheadActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPheadAction.class);

    /**
     * ���캯��
     */
    public BLPrpPheadAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPheadDto prpPheadDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPheadDto prpPheadDto,String mode) throws Exception{
    }
}
