package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpChospitalPerson��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpChospitalPersonAction extends BLPrpChospitalPersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpChospitalPersonAction.class);

    /**
     * ���캯��
     */
    public BLPrpChospitalPersonAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto,String mode)
            throws Exception{
    }
}
