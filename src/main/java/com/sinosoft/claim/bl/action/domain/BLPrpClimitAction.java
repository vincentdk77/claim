package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpClimit��ҵ�������չ��<br>
 * ������ 2006-06-09 15:31:32.937<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpClimitAction extends BLPrpClimitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpClimitAction.class);

    /**
     * ���캯��
     */
    public BLPrpClimitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpClimitDto prpClimitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpClimitDto prpClimitDto,String mode) throws Exception{
    }
}
