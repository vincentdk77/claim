package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredArtifDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsuredartif������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredArtifAction extends BLPrpCinsuredArtifActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredArtifAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCinsuredArtifAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCinsuredArtifDto prpCinsuredArtifDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCinsuredArtifDto prpCinsuredArtifDto,String mode) throws Exception{
    }
}
