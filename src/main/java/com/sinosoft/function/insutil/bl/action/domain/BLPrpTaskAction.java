package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpTask��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskAction extends BLPrpTaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpTaskAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpTaskAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpTaskDto prpTaskDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpTaskDto prpTaskDto,String mode) throws Exception{
    }
}
