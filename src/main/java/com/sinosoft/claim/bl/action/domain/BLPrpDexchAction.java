package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDexchDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdexch�һ��ʵ�ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDexchAction extends BLPrpDexchActionBase{
    private static Log log = LogFactory.getLog(BLPrpDexchAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDexchAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDexchDto prpDexchDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDexchDto prpDexchDto,String mode) throws Exception{
    }
}
