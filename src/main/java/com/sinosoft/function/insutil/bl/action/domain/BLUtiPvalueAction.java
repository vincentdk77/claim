package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPvalueDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipvalue��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPvalueAction extends BLUtiPvalueActionBase{
    private static Log log = LogFactory.getLog(BLUtiPvalueAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPvalueAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPvalueDto utiPvalueDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPvalueDto utiPvalueDto,String mode) throws Exception{
    }
}
