package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtFormDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtform��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtFormAction extends BLUtiPrtFormActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtFormAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPrtFormAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPrtFormDto utiPrtFormDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtFormDto utiPrtFormDto,String mode) throws Exception{
    }
}
