package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDprofitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdprofit��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDprofitAction extends BLPrpDprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDprofitAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDprofitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDprofitDto prpDprofitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDprofitDto prpDprofitDto,String mode) throws Exception{
    }
}
