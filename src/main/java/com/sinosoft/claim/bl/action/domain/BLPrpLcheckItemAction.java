package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItem-�鿱�����ı���������ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemAction extends BLPrpLcheckItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcheckItemDto prpLcheckItemDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto,String mode) throws Exception{
    }
}
