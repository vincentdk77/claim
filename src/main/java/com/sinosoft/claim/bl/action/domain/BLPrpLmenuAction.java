package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmenu-�˵���(����)��ҵ�������չ��<br>
 * ������ 2005-05-08 15:15:53.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuAction extends BLPrpLmenuActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuAction.class);

    /**
     * ���캯��
     */
    public BLPrpLmenuAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLmenuDto prpLmenuDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmenuDto prpLmenuDto,String mode) throws Exception{
    }
}
