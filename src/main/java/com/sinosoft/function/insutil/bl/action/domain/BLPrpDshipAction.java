package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDshipDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdship��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshipAction extends BLPrpDshipActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshipAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDshipAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDshipDto prpDshipDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDshipDto prpDshipDto,String mode) throws Exception{
    }
}
