package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬���ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdpartyStatusAction extends BLPrpLthirdpartyStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdpartyStatusAction.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdpartyStatusAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto,String mode) throws Exception{
    }
}
