package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPathLogStore��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfPathLogStoreAction extends BLSwfPathLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogStoreAction.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogStoreAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathLogStoreDto swfPathLogStoreDto,String mode)
            throws Exception{
    }
}
