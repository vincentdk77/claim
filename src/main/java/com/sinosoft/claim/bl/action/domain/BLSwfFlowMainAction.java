package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfFlowMain���������ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfFlowMainAction extends BLSwfFlowMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainAction.class);

    /**
     * ���캯��
     */
    public BLSwfFlowMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfFlowMainDto swfFlowMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfFlowMainDto swfFlowMainDto,String mode) throws Exception{
    }
}
