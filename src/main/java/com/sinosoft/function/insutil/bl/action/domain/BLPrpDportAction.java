package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDportDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdport��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDportAction extends BLPrpDportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDportAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDportAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDportDto prpDportDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDportDto prpDportDto,String mode) throws Exception{
    }
}
