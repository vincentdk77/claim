package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcfee��������ѱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCfeeAction extends BLPrpCfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpCfeeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCfeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCfeeDto prpCfeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCfeeDto prpCfeeDto,String mode) throws Exception{
    }
}
