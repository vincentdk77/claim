package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPfieldDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipfield��֤��ӡ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPfieldAction extends BLUtiPfieldActionBase{
    private static Log log = LogFactory.getLog(BLUtiPfieldAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPfieldAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPfieldDto utiPfieldDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPfieldDto utiPfieldDto,String mode) throws Exception{
    }
}
