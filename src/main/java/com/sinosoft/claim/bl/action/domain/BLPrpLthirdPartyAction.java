package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplthirdparty���⳵����Ϣ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLthirdPartyAction extends BLPrpLthirdPartyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLthirdPartyAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLthirdPartyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdPartyDto prpLthirdPartyDto,String mode) throws Exception{
    }
}
