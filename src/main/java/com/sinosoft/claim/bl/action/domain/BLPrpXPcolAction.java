package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXPcolDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxpcol���������ֵ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPcolAction extends BLPrpXPcolActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPcolAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpXPcolAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpXPcolDto prpXPcolDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpXPcolDto prpXPcolDto,String mode) throws Exception{
    }
}
