package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemLogDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־���ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemLogAction extends BLPrpLcheckItemLogActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemLogAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckItemLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckItemLogDto prpLcheckItemLogDto,String mode) throws Exception{
    }
}
