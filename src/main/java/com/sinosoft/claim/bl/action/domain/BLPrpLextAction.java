package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLext��ҵ�������չ��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLextAction extends BLPrpLextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLextAction.class);

    /**
     * ���캯��
     */
    public BLPrpLextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLextDto prpLextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLextDto prpLextDto,String mode) throws Exception{
    }
}
