package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCguarantyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcguaranty������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCguarantyAction extends BLPrpCguarantyActionBase{
    private static Log log = LogFactory.getLog(BLPrpCguarantyAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCguarantyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCguarantyDto prpCguarantyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCguarantyDto prpCguarantyDto,String mode) throws Exception{
    }
}
