package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsListDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_list��������ͨ�������ϸ�嵥��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsListAction extends BLPrpLQsListActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsListAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLQsListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLQs_listDto prpLQs_listDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsListDto prpLQs_listDto,String mode) throws Exception{
    }
}
