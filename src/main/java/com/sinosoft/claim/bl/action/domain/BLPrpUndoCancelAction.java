package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancel���ϻ�ɾ�������켣�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelAction extends BLPrpUndoCancelActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpUndoCancelAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpUndoCancelDto prpUndoCancelDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto,String mode) throws Exception{
    }
}
