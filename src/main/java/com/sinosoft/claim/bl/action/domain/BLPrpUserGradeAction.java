package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpusergradeԱ��Ȩ�ޱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeAction extends BLPrpUserGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUserGradeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpUserGradeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpUserGradeDto prpUserGradeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUserGradeDto prpUserGradeDto,String mode) throws Exception{
    }
}
