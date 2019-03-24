package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;

/**
 * 这是PrpdBankBranch的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpdBankBranchAction extends BLPrpdBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLPrpdBankBranchAction.class);

    /**
     * 构造函数
     */
    public BLPrpdBankBranchAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpdBankBranchDto prpdBankBranchDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto,String mode)
            throws Exception{
    }
}
