package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplltext�������ֱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLltextAction extends BLPrpLltextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLltextAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLltextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLltextDto prpLltextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLltextDto prpLltextDto,String mode) throws Exception{
    }
}
