package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcompany����������ҵ�������չ��<br>
 * ������ 2004-11-09 18:29:25.850<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyAction extends BLPrpDcompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyAction.class);

    /**
     * ���캯��
     */
    public BLPrpDcompanyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcompanyDto prpDcompanyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcompanyDto prpDcompanyDto,String mode) throws Exception{
    }
}
