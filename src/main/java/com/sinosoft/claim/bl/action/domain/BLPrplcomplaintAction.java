package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcomplaint;

/**
 * 这是PRPLCOMPLAINT的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcomplaintAction extends BLPrplcomplaintActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcomplaintAction.class);

    /**
     * 构造函数
     */
    public BLPrplcomplaintAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplcomplaintDto prplcomplaintDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcomplaintDto prplcomplaintDto,String mode)
            throws Exception{
    }
}
