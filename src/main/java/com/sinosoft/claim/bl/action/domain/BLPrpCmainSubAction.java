package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcmainsub�����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainSubAction extends BLPrpCmainSubActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainSubAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCmainSubAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCmainSubDto prpCmainSubDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCmainSubDto prpCmainSubDto,String mode) throws Exception{
    }
}
