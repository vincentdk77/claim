package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplinvestigate���������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLinvestigateAction extends BLPrpLinvestigateActionBase{
    private static Log log = LogFactory.getLog(BLPrpLinvestigateAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLinvestigateAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinvestigateDto prpLinvestigateDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinvestigateDto prpLinvestigateDto,String mode) throws Exception{
    }
}
