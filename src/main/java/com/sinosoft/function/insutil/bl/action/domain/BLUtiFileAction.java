package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiFileDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utifile��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiFileAction extends BLUtiFileActionBase{
    private static Log log = LogFactory.getLog(BLUtiFileAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiFileAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiFileDto utiFileDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiFileDto utiFileDto,String mode) throws Exception{
    }
}
