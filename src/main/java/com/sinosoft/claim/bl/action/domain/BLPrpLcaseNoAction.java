package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcaseno�ⰸ�ű��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcaseNoAction extends BLPrpLcaseNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcaseNoAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcaseNoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcaseNoDto prpLcaseNoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto,String mode) throws Exception{
    }
}
