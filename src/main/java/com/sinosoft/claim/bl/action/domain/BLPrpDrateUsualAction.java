package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateUsualDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateusual���ʴ�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateUsualAction extends BLPrpDrateUsualActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateUsualAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDrateUsualAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDrateUsualDto prpDrateUsualDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateUsualDto prpDrateUsualDto,String mode) throws Exception{
    }
}
