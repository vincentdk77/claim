package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidcode��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDcodeAction extends BLPrpIDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDcodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpIDcodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpIDcodeDto prpIDcodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpIDcodeDto prpIDcodeDto,String mode) throws Exception{
    }
}
