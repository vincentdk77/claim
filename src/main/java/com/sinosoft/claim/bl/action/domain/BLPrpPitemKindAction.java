package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppitemkind���������Ϣ��ҵ�������չ��<br>
 * ������ 2004-11-22 15:24:31.187<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPitemKindAction extends BLPrpPitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPitemKindAction.class);

    /**
     * ���캯��
     */
    public BLPrpPitemKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPitemKindDto prpPitemKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPitemKindDto prpPitemKindDto,String mode) throws Exception{
    }
}
