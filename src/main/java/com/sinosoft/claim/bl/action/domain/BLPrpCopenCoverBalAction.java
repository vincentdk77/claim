package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCopenCoverBalDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcopencoverbalЭ������¼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCopenCoverBalAction extends BLPrpCopenCoverBalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCopenCoverBalAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCopenCoverBalAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto,String mode) throws Exception{
    }
}
