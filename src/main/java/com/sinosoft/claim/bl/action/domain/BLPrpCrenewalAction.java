package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcrenewal������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCrenewalAction extends BLPrpCrenewalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCrenewalAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCrenewalAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCrenewalDto prpCrenewalDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCrenewalDto prpCrenewalDto,String mode) throws Exception{
    }
}
