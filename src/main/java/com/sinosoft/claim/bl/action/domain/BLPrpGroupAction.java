package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgroup��֤�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGroupAction extends BLPrpGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpGroupAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGroupAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGroupDto prpGroupDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGroupDto prpGroupDto,String mode) throws Exception{
    }
}
