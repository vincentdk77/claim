package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentComDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagentcom�б�����,�б���˾���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentComAction extends BLPrpDagentComActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentComAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDagentComAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDagentComDto prpDagentComDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDagentComDto prpDagentComDto,String mode) throws Exception{
    }
}
