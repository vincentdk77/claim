package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifierdesc��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierDescAction extends BLPrpDidentifierDescActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierDescAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDidentifierDescAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto,String mode) throws Exception{
    }
}
