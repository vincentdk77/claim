package com.sinosoft.claimciplatform.bl.action.domain;

import com.sinosoft.claimciplatform.dto.domain.CIInsureValidDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����Ͷ��ȷ������-CIInsureValid��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIInsureValidAction extends BLCIInsureValidActionBase{
    private static Log logger = LogFactory.getLog(BLCIInsureValidAction.class);

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
