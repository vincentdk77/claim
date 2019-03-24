package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterAccdentPerson;

/**
 * 这是理算接口事故者信息的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterAccdentPersonAction extends BLPrpLinterAccdentPersonActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterAccdentPersonAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterAccdentPersonAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto,String mode)
            throws Exception{
    }
    
    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterAccdentPersonDto[] prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //插入记录
        for(int i=0;i<prpLinterAccdentPersonDto.length;i++){
        	dbPrpLinterAccdentPerson.insert(prpLinterAccdentPersonDto[i]);
        }
    }
}
