package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsurednature��Ȼ����Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredNatureAction extends BLPrpCinsuredNatureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredNatureAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCinsuredNatureAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCinsuredNatureDto prpCinsuredNatureDto,String mode) throws Exception{
    }
}
