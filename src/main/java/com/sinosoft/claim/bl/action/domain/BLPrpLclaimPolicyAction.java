package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaimpolicy���������嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimPolicyAction extends BLPrpLclaimPolicyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimPolicyAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimPolicyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto,String mode) throws Exception{
    }
}
