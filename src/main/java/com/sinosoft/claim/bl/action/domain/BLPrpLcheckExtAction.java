package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcheckext�鿱/���鿱��չ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcheckExtAction extends BLPrpLcheckExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcheckExtAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcheckExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcheckExtDto prpLcheckExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto,String mode) throws Exception{
    }
}
