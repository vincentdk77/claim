package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainText投诉文字表的业务对象扩展类<br>
 * 创建于 2005-08-20 17:41:17.213<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextAction extends BLEdaComplainTextActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextAction.class);

    /**
     * 构造函数
     */
    public BLEdaComplainTextAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param edaComplainTextDto edaComplainTextDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaComplainTextDto edaComplainTextDto,String mode) throws Exception{
    }
}
