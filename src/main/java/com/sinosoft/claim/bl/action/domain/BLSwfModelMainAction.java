package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfModelMainģ�������ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:54.986<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfModelMainAction extends BLSwfModelMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelMainAction.class);

    /**
     * ���캯��
     */
    public BLSwfModelMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param wfModelMainDto wfModelMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfModelMainDto swfModelMainDto,String mode) throws Exception{
    }
}
