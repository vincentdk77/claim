package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcode��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeAction extends BLPrpDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcodeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcodeDto prpDcodeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcodeDto prpDcodeDto,String mode) throws Exception{
    }
}