package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplptextԤ�����ֱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLptextAction extends BLPrpLptextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLptextAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLptextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLptextDto prpLptextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLptextDto prpLptextDto,String mode) throws Exception{
    }
}
