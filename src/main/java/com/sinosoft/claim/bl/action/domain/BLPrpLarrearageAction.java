package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLarrearageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplarrearage���Ƿ���嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLarrearageAction extends BLPrpLarrearageActionBase{
    private static Log log = LogFactory.getLog(BLPrpLarrearageAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLarrearageAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLarrearageDto prpLarrearageDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLarrearageDto prpLarrearageDto,String mode) throws Exception{
    }
}
