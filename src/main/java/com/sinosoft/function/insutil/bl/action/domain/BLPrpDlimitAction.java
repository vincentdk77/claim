package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDlimitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdlimit��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDlimitAction extends BLPrpDlimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDlimitAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDlimitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDlimitDto prpDlimitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDlimitDto prpDlimitDto,String mode) throws Exception{
    }
}
