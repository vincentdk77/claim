package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_RepfeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Repfee��������嵥�ӿ����ݱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_RepfeeAction extends BLPrpLpeds_RepfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_RepfeeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLpeds_RepfeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_RepfeeDto prpLpeds_RepfeeDto,String mode) throws Exception{
    }
}
