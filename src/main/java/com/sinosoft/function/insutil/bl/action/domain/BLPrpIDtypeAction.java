package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDtypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDtypeAction extends BLPrpIDtypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDtypeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpIDtypeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpIDtypeDto prpIDtypeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpIDtypeDto prpIDtypeDto,String mode) throws Exception{
    }
}
