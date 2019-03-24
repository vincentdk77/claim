package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPACKAGE工作流日志业务信息表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPackageAction extends BLSwfPackageActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPackageAction.class);

    /**
     * 构造函数
     */
    public BLSwfPackageAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param SwfPackageDto SwfPackageDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPackageDto swfPackageDto,String mode) throws Exception{
    }
}
