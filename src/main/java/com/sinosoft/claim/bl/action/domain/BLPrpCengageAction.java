package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcengage�ر�Լ�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCengageAction extends BLPrpCengageActionBase{
    private static Log log = LogFactory.getLog(BLPrpCengageAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCengageAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCengageDto prpCengageDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCengageDto prpCengageDto,String mode) throws Exception{
    }
}
