package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagent�����˴�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentAction extends BLPrpDagentActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDagentAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDagentDto prpDagentDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDagentDto prpDagentDto,String mode) throws Exception{
    }
}
