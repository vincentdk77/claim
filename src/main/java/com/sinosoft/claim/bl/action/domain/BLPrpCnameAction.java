package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCnameDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcname��Ա�嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCnameAction extends BLPrpCnameActionBase{
    private static Log log = LogFactory.getLog(BLPrpCnameAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCnameAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCnameDto prpCnameDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCnameDto prpCnameDto,String mode) throws Exception{
    }
}
