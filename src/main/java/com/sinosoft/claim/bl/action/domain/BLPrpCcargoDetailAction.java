package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcargoDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccargodetail�����ջ�����ϸ��Ϣ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcargoDetailAction extends BLPrpCcargoDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcargoDetailAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCcargoDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto,String mode) throws Exception{
    }
}
