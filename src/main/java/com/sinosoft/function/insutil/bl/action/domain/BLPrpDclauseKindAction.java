package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclausekind��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseKindAction extends BLPrpDclauseKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseKindAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDclauseKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDclauseKindDto prpDclauseKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto,String mode) throws Exception{
    }
}
