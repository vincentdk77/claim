package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPACKAGE��������־ҵ����Ϣ���ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPackageAction extends BLSwfPackageActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPackageAction.class);

    /**
     * ���캯��
     */
    public BLSwfPackageAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param SwfPackageDto SwfPackageDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPackageDto swfPackageDto,String mode) throws Exception{
    }
}
