package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplrtext׷����������˵����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLrtextAction extends BLPrpLrtextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLrtextAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLrtextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLrtextDto prpLrtextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLrtextDto prpLrtextDto,String mode) throws Exception{
    }
}
