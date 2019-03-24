package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * 这是PLANTINGSETTLELIST的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingsettlelistAction extends BLPlantingsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistAction.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param plantingsettlelistDto plantingsettlelistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PlantingsettlelistDto plantingsettlelistDto,String mode)
            throws Exception{
    }

	public Collection findAccountByConditions(DBManager dbManager,
			String conditions) throws Exception {
		DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingsettlelist.findAccountByConditions(conditions);
        return collection;
	}
}
