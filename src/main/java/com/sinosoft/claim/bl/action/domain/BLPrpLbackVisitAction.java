package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisit--�ط���Ϣ�����ҵ�������չ��<br>
 * ������ 2005-03-25 20:44:46.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitAction extends BLPrpLbackVisitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitAction.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLbackVisitDto prpLbackVisitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto,String mode) throws Exception{
    }
}
