package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitQue--�ط���ѯ���ҵ�������չ��<br>
 * ������ 2005-03-23 09:00:24.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueAction extends BLPrpLbackVisitQueActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueAction.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitQueAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto,String mode) throws Exception{
    }
}
