package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCMain���Ᵽ�������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLCMainAction extends BLPrpLCMainActionBase{
    private static Log log = LogFactory.getLog(BLPrpLCMainAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLCMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLCMainDto prpLCMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLCMainDto prpLCMainDto,String mode) throws Exception{
    }
}
