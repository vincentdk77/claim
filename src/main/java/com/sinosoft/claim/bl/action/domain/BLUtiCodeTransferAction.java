package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiCodeTransfer -�������������ձ��ҵ�������չ��<br>
 * ������ 2005-05-09 09:01:23.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLUtiCodeTransferAction extends BLUtiCodeTransferActionBase{
    private static Log logger = LogFactory.getLog(BLUtiCodeTransferAction.class);

    /**
     * ���캯��
     */
    public BLUtiCodeTransferAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiCodeTransferDto utiCodeTransferDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiCodeTransferDto utiCodeTransferDto,String mode) throws Exception{
    }
}
