package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCitemKind���Ᵽ��Ͷ���ձ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLCitemKindAction extends BLPrpLCitemKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpLCitemKindAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLCitemKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLCitemKindDto prpLCitemKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto,String mode) throws Exception{
    }
}
