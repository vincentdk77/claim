package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaimagent�����Ᵽ����Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimAgentAction extends BLPrpLclaimAgentActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimAgentAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimAgentAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimAgentDto prpLclaimAgentDto,String mode) throws Exception{
    }
}
