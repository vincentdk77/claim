package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDkindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdkind�ձ������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDkindAction extends BLPrpDkindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDkindAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDkindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDkindDto prpDkindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDkindDto prpDkindDto,String mode) throws Exception{
    }
}
