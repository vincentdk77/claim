package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJcommAllocDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjcommalloc�����ѷ�̯���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJcommAllocAction extends BLPrpJcommAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJcommAllocAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJcommAllocAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJcommAllocDto prpJcommAllocDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto,String mode) throws Exception{
    }
}
