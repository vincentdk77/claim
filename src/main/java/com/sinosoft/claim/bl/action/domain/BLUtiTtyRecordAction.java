package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyRecordDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittyrecord��¼��¼����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyRecordAction extends BLUtiTtyRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyRecordAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiTtyRecordAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiTtyRecordDto utiTtyRecordDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto,String mode) throws Exception{
    }
}