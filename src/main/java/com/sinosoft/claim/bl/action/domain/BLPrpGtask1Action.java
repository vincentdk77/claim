package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtask1Dto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgtask1������־���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtask1Action extends BLPrpGtask1ActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtask1Action.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGtask1Action(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGtask1Dto prpGtask1Dto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGtask1Dto prpGtask1Dto,String mode) throws Exception{
    }
}
