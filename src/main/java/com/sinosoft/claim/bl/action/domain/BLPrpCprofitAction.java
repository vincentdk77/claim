package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofit�Ż���Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitAction extends BLPrpCprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCprofitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCprofitDto prpCprofitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCprofitDto prpCprofitDto,String mode) throws Exception{
    }
}
