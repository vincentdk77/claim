package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcfee����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcfeeAction extends BLPrpLcfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcfeeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcfeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcfeeDto prpLcfeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcfeeDto prpLcfeeDto,String mode) throws Exception{
    }
}
