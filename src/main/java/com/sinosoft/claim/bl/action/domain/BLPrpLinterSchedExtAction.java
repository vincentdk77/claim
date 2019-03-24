package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterSchedExt;

/**
 * 这是补充说明信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterSchedExtAction extends BLPrpLinterSchedExtActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterSchedExtAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterSchedExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterSchedExtDto prpLinterSchedExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterSchedExtDto prpLinterSchedExtDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterSchedExtDto[] prpLinterSchedExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterSchedExtDto[] prpLinterSchedExtDto)
            throws Exception{
        DBPrpLinterSchedExt dbPrpLinterSchedExt = new DBPrpLinterSchedExt(dbManager);
        //插入记录
        for(int i=0;i<prpLinterSchedExtDto.length;i++){
        	dbPrpLinterSchedExt.insert(prpLinterSchedExtDto[i]);
        }
    }
}
