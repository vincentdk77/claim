package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpGrant ��Ȩ��¼���ҵ�������չ��<br>
 * ������ 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantAction extends BLPrpGrantActionBase{
    private static Log logger = LogFactory.getLog(BLPrpGrantAction.class);

    /**
     * ���캯��
     */
    public BLPrpGrantAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGrantDto prpGrantDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGrantDto prpGrantDto,String mode) throws Exception{
    }
}
