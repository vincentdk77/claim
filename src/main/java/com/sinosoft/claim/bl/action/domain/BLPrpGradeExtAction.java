package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgradeext��λ��չ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeExtAction extends BLPrpGradeExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeExtAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpGradeExtAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpGradeExtDto prpGradeExtDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGradeExtDto prpGradeExtDto,String mode) throws Exception{
    }
}
