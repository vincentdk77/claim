package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateLoanDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateloan��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateLoanAction extends BLPrpDrateLoanActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateLoanAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDrateLoanAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDrateLoanDto prpDrateLoanDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateLoanDto prpDrateLoanDto,String mode) throws Exception{
    }
}
