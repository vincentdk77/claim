package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofitdetail�Ż��ۿ���ϸ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitDetailAction extends BLPrpCprofitDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitDetailAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCprofitDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto,String mode) throws Exception{
    }
}
