package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclause��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseAction extends BLPrpDclauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDclauseAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDclauseDto prpDclauseDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDclauseDto prpDclauseDto,String mode) throws Exception{
    }
}
