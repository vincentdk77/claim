package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjprofit�Żݼ�¼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJprofitAction extends BLPrpJprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpJprofitAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJprofitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJprofitDto prpJprofitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJprofitDto prpJprofitDto,String mode) throws Exception{
    }
}
