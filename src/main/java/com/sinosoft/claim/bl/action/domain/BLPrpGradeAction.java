package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrade��λ������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeAction extends BLPrpGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGradeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGradeDto prpGradeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGradeDto prpGradeDto,String mode) throws Exception{
    }
}
