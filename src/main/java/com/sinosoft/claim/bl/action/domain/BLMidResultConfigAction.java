package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的业务对象扩展类<br>
 * 创建于 2005-03-11 10:51:28.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigAction extends BLMidResultConfigActionBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigAction.class);

    /**
     * 构造函数
     */
    public BLMidResultConfigAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param midResultConfigDto midResultConfigDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MidResultConfigDto midResultConfigDto,String mode) throws Exception{
    }
}
