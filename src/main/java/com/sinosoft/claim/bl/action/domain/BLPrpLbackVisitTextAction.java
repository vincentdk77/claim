package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitText--�طñ�ע���ҵ�������չ��<br>
 * ������ 2005-03-23 09:00:38.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextAction extends BLPrpLbackVisitTextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextAction.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitTextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitTextDto prpLbackVisitTextDto,String mode) throws Exception{
    }
}
