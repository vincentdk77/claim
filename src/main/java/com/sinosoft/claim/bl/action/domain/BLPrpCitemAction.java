package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcitem保险标的项目表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemAction extends BLPrpCitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCitemAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCitemDto prpCitemDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemDto prpCitemDto,String mode) throws Exception{
    }
}
