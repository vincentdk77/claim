package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk���ִ�����ҵ�������չ��<br>
 * ������ 2004-08-25 16:51:29.983<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskAction extends BLPrpDriskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskAction.class);

    /**
     * ���캯��
     */
    public BLPrpDriskAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDriskDto prpDriskDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDriskDto prpDriskDto,String mode) throws Exception{
    }
}
