package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcplan�շѼƻ����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCplanAction extends BLPrpCplanActionBase{
    private static Log log = LogFactory.getLog(BLPrpCplanAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCplanAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCplanDto prpCplanDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCplanDto prpCplanDto,String mode) throws Exception{
    }
}
