package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXPformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxpform��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPformAction extends BLPrpXPformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPformAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpXPformAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpXPformDto prpXPformDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpXPformDto prpXPformDto,String mode) throws Exception{
    }
}
