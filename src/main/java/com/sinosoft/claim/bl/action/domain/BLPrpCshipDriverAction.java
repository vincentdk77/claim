package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCshipDriverDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcshipdriver�����մ�Ա��Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCshipDriverAction extends BLPrpCshipDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCshipDriverAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCshipDriverAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCshipDriverDto prpCshipDriverDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCshipDriverDto prpCshipDriverDto,String mode) throws Exception{
    }
}
