package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDtypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdtype��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDtypeAction extends BLPrpDtypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDtypeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDtypeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDtypeDto prpDtypeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDtypeDto prpDtypeDto,String mode) throws Exception{
    }
}