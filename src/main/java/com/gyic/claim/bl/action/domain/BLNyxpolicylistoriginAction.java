package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistoriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxpolicylistorigin;

/**
 * 这是NYXPOLICYLISTORIGIN的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxpolicylistoriginAction extends BLNyxpolicylistoriginActionBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistoriginAction.class);

    /**
     * 构造函数
     */
    public BLNyxpolicylistoriginAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxpolicylistoriginDto nyxpolicylistoriginDto,String mode)
            throws Exception{
    }
}
