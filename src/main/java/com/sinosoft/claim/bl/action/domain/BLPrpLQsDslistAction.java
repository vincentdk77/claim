package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsDslistDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_Dslist����ͨ�������ϸ�嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsDslistAction extends BLPrpLQsDslistActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsDslistAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLQsDslistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto,String mode) throws Exception{
    }
}
