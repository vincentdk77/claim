package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtRecordDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtrecord��ӡ��¼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtRecordAction extends BLUtiPrtRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtRecordAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPrtRecordAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPrtRecordDto utiPrtRecordDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPrtRecordDto utiPrtRecordDto,String mode) throws Exception{
    }
}
