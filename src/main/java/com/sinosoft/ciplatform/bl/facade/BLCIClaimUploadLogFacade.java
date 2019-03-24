package com.sinosoft.ciplatform.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;

/**
 * 这是理赔信息上传平台日志表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogFacade extends BLCIClaimUploadLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadLogFacade.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadLogFacade(){
        super();
    }
}
