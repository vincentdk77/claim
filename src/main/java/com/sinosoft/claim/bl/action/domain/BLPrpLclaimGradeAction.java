package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)��ҵ�������չ��<br>
 * ������ 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradeAction extends BLPrpLclaimGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimGradeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimGradeDto prpLclaimGradeDto,String mode) throws Exception{
    }
}
