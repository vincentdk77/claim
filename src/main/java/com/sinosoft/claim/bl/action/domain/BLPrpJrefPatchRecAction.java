package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefpatchrec�������ѵǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPatchRecAction extends BLPrpJrefPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPatchRecAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJrefPatchRecAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto,String mode) throws Exception{
    }
}
