package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPATH������·��������ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPathAction extends BLSwfPathActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathAction.class);

    /**
     * ���캯��
     */
    public BLSwfPathAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfPathDto swfPathDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathDto swfPathDto,String mode) throws Exception{
    }
}
