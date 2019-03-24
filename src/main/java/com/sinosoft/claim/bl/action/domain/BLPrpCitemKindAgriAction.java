package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCitemKindAgri的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCitemKindAgriAction extends BLPrpCitemKindAgriActionBase{
    private static Log logger = LogFactory.getLog(BLPrpCitemKindAgriAction.class);

    /**
     * 构造函数
     */
    public BLPrpCitemKindAgriAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto,String mode)
            throws Exception{
    }
}
