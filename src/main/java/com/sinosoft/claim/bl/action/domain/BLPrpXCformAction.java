package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXCformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxcform�б������ֵ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXCformAction extends BLPrpXCformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXCformAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpXCformAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpXCformDto prpXCformDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpXCformDto prpXCformDto,String mode) throws Exception{
    }
}
