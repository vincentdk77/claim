package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainMainͶ����Ϣ���ҵ�������չ��<br>
 * ������ 2005-08-20 17:41:17.193<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainAction extends BLEdaComplainMainActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainAction.class);

    /**
     * ���캯��
     */
    public BLEdaComplainMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param edaComplainMainDto edaComplainMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaComplainMainDto edaComplainMainDto,String mode) throws Exception{
    }
}
