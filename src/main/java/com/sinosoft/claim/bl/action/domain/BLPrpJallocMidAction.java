package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJallocMidDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjallocmid������ҵ�񱣷ѷ�̯�м���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJallocMidAction extends BLPrpJallocMidActionBase{
    private static Log log = LogFactory.getLog(BLPrpJallocMidAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJallocMidAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJallocMidDto prpJallocMidDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJallocMidDto prpJallocMidDto,String mode) throws Exception{
    }
}
