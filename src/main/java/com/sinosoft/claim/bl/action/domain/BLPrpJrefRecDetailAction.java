package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefrecdetail���ѵǼ���ϸ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecDetailAction extends BLPrpJrefRecDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecDetailAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJrefRecDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto,String mode) throws Exception{
    }
}
