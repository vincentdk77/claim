package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdCarLoss-��ʧ��λ(����)��ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdCarLossAction extends BLPrpLthirdCarLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdCarLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdCarLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdCarLossDto prpLthirdCarLossDto,String mode) throws Exception{
    }
}
