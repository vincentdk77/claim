package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCaddressDto;

/**
 * ����prpcaddress���յ�ַ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCaddressAction extends BLPrpCaddressActionBase{
    private static Log log = LogFactory.getLog(BLPrpCaddressAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCaddressAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCaddressDto prpCaddressDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCaddressDto prpCaddressDto,String mode) throws Exception{
    }
}
