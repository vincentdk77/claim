package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgtask核保核赔任务日志表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtaskAction extends BLPrpGtaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtaskAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpGtaskAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpGtaskDto prpGtaskDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGtaskDto prpGtaskDto,String mode) throws Exception{
    }
}
