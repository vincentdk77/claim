package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpTask����������ҵ�������չ��<br>
 * ������ 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskAction extends BLPrpTaskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskAction.class);

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
