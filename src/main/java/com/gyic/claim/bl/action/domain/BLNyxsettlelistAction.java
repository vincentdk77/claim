package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;

/**
 * 这是NYXSETTLELIST的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxsettlelistAction extends BLNyxsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistAction.class);

    /**
     * 构造函数
     */
    public BLNyxsettlelistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param nyxsettlelistDto nyxsettlelistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto,String mode)
            throws Exception{
    }
}
