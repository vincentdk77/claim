package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclassDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclass���������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclassAction extends BLPrpDclassActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclassAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDclassAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDclassDto prpDclassDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDclassDto prpDclassDto,String mode) throws Exception{
    }
}
