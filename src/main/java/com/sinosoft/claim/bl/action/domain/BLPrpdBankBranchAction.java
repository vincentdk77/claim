package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;

/**
 * ����PrpdBankBranch��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpdBankBranchAction extends BLPrpdBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLPrpdBankBranchAction.class);

    /**
     * ���캯��
     */
    public BLPrpdBankBranchAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpdBankBranchDto prpdBankBranchDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto,String mode)
            throws Exception{
    }
}
