package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDfieldExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdfieldext��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDfieldExtAction extends BLPrpDfieldExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpDfieldExtAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDfieldExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDfieldExtDto prpDfieldExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDfieldExtDto prpDfieldExtDto,String mode) throws Exception{
    }
}
