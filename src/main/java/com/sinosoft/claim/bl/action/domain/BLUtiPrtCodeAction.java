package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtcode��ӡ����ָ�������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtCodeAction extends BLUtiPrtCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtCodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPrtCodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPrtCodeDto utiPrtCodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto,String mode) throws Exception{
    }
}
