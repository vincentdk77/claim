package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardriver������ʻԱ��ϵ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDriverAction extends BLPrpCcarDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDriverAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCcarDriverAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCcarDriverDto prpCcarDriverDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcarDriverDto prpCcarDriverDto,String mode) throws Exception{
    }
}
