package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGnodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgnode�������ڵ�ģ����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGnodeAction extends BLPrpGnodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGnodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGnodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGnodeDto prpGnodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGnodeDto prpGnodeDto,String mode) throws Exception{
    }
}
