package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpMaxUseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxuse��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxUseAction extends BLPrpMaxUseActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxUseAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpMaxUseAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpMaxUseDto prpMaxUseDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpMaxUseDto prpMaxUseDto,String mode) throws Exception{
    }
}
