package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLtrackDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpltrack��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLtrackAction extends BLPrpLtrackActionBase{
    private static Log log = LogFactory.getLog(BLPrpLtrackAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLtrackAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLtrackDto prpLtrackDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLtrackDto prpLtrackDto,String mode) throws Exception{
    }
}
