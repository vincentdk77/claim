package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicytgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaimpolicy���������嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimPolicytgAction extends BLPrpLclaimPolicytgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimPolicytgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimPolicytgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto,String mode) throws Exception{
    }
}
