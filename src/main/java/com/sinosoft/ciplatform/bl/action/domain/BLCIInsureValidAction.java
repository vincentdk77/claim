package com.sinosoft.ciplatform.bl.action.domain;

import com.sinosoft.ciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����Ͷ��ȷ������-CIInsureValid��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIInsureValidAction extends BLCIInsureValidActionBase{
    private static Logger logger = Logger.getLogger(BLCIInsureValidAction.class);

    /**
     * ���캯��
     */
    public BLCIInsureValidAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIInsureValidDto cIInsureValidDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIInsureValidDto cIInsureValidDto,String mode)
            throws Exception{
    }
}
