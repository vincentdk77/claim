package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpremAllocDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpremalloc������ҵ�񱣷ѷ�̯���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpremAllocAction extends BLPrpJpremAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpremAllocAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJpremAllocAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJpremAllocDto prpJpremAllocDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpremAllocDto prpJpremAllocDto,String mode) throws Exception{
    }
}
