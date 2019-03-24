package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCertify;

/**
 * 这是单证信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCertifyAction extends BLPrpLinterCertifyActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCertifyAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCertifyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterCertifyDto[] prpLinterCertifyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCertifyDto[] prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //插入记录
        for(int i=0;i<prpLinterCertifyDto.length;i++){
        	dbPrpLinterCertify.insert(prpLinterCertifyDto[i]);
        }
    }
}
