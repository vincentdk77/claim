package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDareaGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdareagroup�������������������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDareaGroupAction extends BLPrpDareaGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpDareaGroupAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDareaGroupAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDareaGroupDto prpDareaGroupDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto,String mode) throws Exception{
    }
}
