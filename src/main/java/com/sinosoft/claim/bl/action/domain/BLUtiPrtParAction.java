package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtParDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtpar��֤��ӡ�ļ�������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtParAction extends BLUtiPrtParActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtParAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPrtParAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPrtParDto utiPrtParDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtParDto utiPrtParDto,String mode) throws Exception{
    }
}
