package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLacciCheckText--�����ı���Ϣ���ҵ�������չ��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckTextAction extends BLPrpLacciCheckTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckTextAction.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckTextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLacciCheckTextDto prpLacciCheckTextDto,String mode) throws Exception{
    }
}
