package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDeviceDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardeviceͶ�������������豸��Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDeviceAction extends BLPrpCcarDeviceActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDeviceAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCcarDeviceAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcarDeviceDto prpCcarDeviceDto,String mode) throws Exception{
    }
}
