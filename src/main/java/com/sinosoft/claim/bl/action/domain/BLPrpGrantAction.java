package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrant��Ȩ��¼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantAction extends BLPrpGrantActionBase{
    private static Log log = LogFactory.getLog(BLPrpGrantAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGrantAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGrantDto prpGrantDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGrantDto prpGrantDto,String mode) throws Exception{
    }
}
