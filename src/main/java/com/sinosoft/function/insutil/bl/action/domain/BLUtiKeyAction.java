package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiKeyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utikey��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiKeyAction extends BLUtiKeyActionBase{
    private static Log log = LogFactory.getLog(BLUtiKeyAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiKeyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiKeyDto utiKeyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiKeyDto utiKeyDto,String mode) throws Exception{
    }
}
