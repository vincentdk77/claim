package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)��ҵ�������չ��<br>
 * ������ 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgAction extends BLPrpLclaimGradetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimGradetgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto,String mode) throws Exception{
    }
}
