package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDidentifierDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifier��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierAction extends BLPrpDidentifierActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDidentifierAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDidentifierDto prpDidentifierDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDidentifierDto prpDidentifierDto,String mode) throws Exception{
    }
}