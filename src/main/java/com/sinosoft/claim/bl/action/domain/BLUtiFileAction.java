package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiFileDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utifile��ӡ�ļ����ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
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
