package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainTextͶ�����ֱ��ҵ�������չ��<br>
 * ������ 2005-08-20 17:41:17.213<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextAction extends BLEdaComplainTextActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextAction.class);

    /**
     * ���캯��
     */
    public BLEdaComplainTextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param edaComplainTextDto edaComplainTextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaComplainTextDto edaComplainTextDto,String mode) throws Exception{
    }
}
