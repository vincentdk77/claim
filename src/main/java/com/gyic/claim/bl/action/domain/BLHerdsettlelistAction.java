package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdsettlelist;

/**
 * 这是HERDSETTLELIST的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLHerdsettlelistAction extends BLHerdsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistAction.class);

    /**
     * 构造函数
     */
    public BLHerdsettlelistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param herdsettlelistDto herdsettlelistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,HerdsettlelistDto herdsettlelistDto,String mode)
            throws Exception{
    }

	public Collection findAccountByConditions(DBManager dbManager,
			String conditions) throws Exception{
		DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHerdsettlelist.findAccountByConditions(conditions);
        return collection;
	}
}
