package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDreportDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdreport��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDreportAction extends BLPrpDreportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDreportAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDreportAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDreportDto prpDreportDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDreportDto prpDreportDto,String mode) throws Exception{
    }
}
