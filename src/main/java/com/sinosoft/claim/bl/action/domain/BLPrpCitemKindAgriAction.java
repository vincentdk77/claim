package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCitemKindAgri��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCitemKindAgriAction extends BLPrpCitemKindAgriActionBase{
    private static Log logger = LogFactory.getLog(BLPrpCitemKindAgriAction.class);

    /**
     * ���캯��
     */
    public BLPrpCitemKindAgriAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto,String mode)
            throws Exception{
    }
}
