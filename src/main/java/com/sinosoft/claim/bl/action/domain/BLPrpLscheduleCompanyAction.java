package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleCompany--����������ʾ��Ϣ���ñ��ҵ�������չ��<br>
 * ������ 2005-08-17 15:04:01.050<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleCompanyAction extends BLPrpLscheduleCompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleCompanyAction.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleCompanyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto,String mode) throws Exception{
    }
}
