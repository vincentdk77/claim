package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpptext����������Ϣ��ҵ�������չ��<br>
 * ������ 2004-11-22 15:24:31.281<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextAction extends BLPrpPtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextAction.class);

    /**
     * ���캯��
     */
    public BLPrpPtextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPtextDto prpPtextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPtextDto prpPtextDto,String mode) throws Exception{
    }
}
