package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����MidResultConfig���ҳ�����ñ��ҵ�������չ��<br>
 * ������ 2005-03-11 10:51:28.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigAction extends BLMidResultConfigActionBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigAction.class);

    /**
     * ���캯��
     */
    public BLMidResultConfigAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param midResultConfigDto midResultConfigDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MidResultConfigDto midResultConfigDto,String mode) throws Exception{
    }
}
