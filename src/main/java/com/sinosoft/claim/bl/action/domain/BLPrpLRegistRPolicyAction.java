package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLRegistRPolicy�ⰸ�����������ҵ�������չ��<br>
 * ������ 2006-06-04 15:22:15.047<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyAction extends BLPrpLRegistRPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyAction.class);

    /**
     * ���캯��
     */
    public BLPrpLRegistRPolicyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto,String mode) throws Exception{
    }
}
