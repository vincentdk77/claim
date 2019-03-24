package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;

/**
 * 这是PLANTINGSETTLELIST的数据访问对象类<br>
 * 创建于 2011-10-28 15:06:47.562<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlantingsettlelist extends DBPlantingsettlelistBase{
    private static Logger logger = Logger.getLogger(DBPlantingsettlelist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlantingsettlelist(DBManager dbManager){
        super(dbManager);
    }

	public Collection findAccountByConditions(String conditions) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fcode,");
        buffer.append("max(Zhibuka) as Zhibuka,");
        buffer.append("sum(Settlesum) as Settlesum,");
        buffer.append("max(Bank) as Bank ");
        buffer.append("FROM Plantingsettlelist WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("Settlelistcode,Fname,Fidcard,Fcode ");
        boolean supportPaging = false;//数据库是否支持分页
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;

        //定义返回结果集合
        Collection collection = new ArrayList();
        PlantingsettlelistDto plantingsettlelistDto = null;
        while(resultSet.next()){
            plantingsettlelistDto = new PlantingsettlelistDto();
            plantingsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            plantingsettlelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            plantingsettlelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            plantingsettlelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            plantingsettlelistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            plantingsettlelistDto.setSettlesum(dbManager.getString(resultSet,"Settlesum"));
            plantingsettlelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            collection.add(plantingsettlelistDto);
        }
        resultSet.close();
        return collection;
	}
}
