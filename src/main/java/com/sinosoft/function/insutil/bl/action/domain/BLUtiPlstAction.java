package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPlstDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiplst��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPlstAction extends BLUtiPlstActionBase{
    private static Log log = LogFactory.getLog(BLUtiPlstAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiPlstAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiPlstDto utiPlstDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPlstDto utiPlstDto,String mode) throws Exception{
    }
}
