package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittycode�ն����Լ�¼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyCodeAction extends BLUtiTtyCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyCodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiTtyCodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiTtyCodeDto utiTtyCodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiTtyCodeDto utiTtyCodeDto,String mode) throws Exception{
    }
}
