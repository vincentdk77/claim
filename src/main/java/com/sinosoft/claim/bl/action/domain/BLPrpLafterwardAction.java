package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLafterwardDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplafterward������ô�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLafterwardAction extends BLPrpLafterwardActionBase{
    private static Log log = LogFactory.getLog(BLPrpLafterwardAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLafterwardAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLafterwardDto prpLafterwardDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLafterwardDto prpLafterwardDto,String mode) throws Exception{
    }
}
