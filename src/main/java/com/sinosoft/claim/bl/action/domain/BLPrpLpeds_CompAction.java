package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_CompDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Comp�����嵥�ӿ����ݱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_CompAction extends BLPrpLpeds_CompActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_CompAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLpeds_CompAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_CompDto prpLpeds_CompDto,String mode) throws Exception{
    }
}
