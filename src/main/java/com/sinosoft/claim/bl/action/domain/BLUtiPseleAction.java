package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPseleDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipsele��֤��ӡ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPseleAction extends BLUtiPseleActionBase{
    private static Log log = LogFactory.getLog(BLUtiPseleAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPseleAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPseleDto utiPseleDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPseleDto utiPseleDto,String mode) throws Exception{
    }
}