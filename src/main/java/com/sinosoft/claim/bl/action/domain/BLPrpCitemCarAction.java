package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitem_car�������ձ����Ϣ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemCarAction extends BLPrpCitemCarActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemCarAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCitemCarAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCitemCarDto prpCitemCarDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemCarDto prpCitemCarDto,String mode) throws Exception{
    }
}
