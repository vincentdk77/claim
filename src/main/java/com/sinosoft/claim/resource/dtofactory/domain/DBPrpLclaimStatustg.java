package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimStatus理赔节点状态表的数据访问对象类<br>
 * 创建于 2004-05-09 11:07:31.332<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimStatustg extends DBPrpLclaimStatustgBase{
    private static Log logger = LogFactory.getLog(DBPrpLclaimStatustg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimStatustg(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件对节点进行状态统计
     * @param conditions 统计条件
     * @return Collection
     * @throws Exception
     */
    public Collection getStatStatus(String conditions) throws Exception{
    //select count(*),status,nodetype from prplclaimstatus where nodetype='claim' group by status,nodetype;
       /*
        String statement = "Select count(*)," +
                           " NodeType," +
                           " HandlerCode," +
                           " Status From PrpLclaimStatustg Where " + conditions +" group by status,nodetype,HandlerCode";
       */

       String statement ="SELECT PRPLCLAIMSTATUSTG.NODETYPE, " +
                        " a.CODECNAME," +
                        " PRPLCLAIMSTATUSTG.STATUS," +
                        " PRPLCLAIMSTATUSTG.handlerCode," +
                        " b.CODECNAME," +
                        " count(1) " +
                        " FROM PRPLCLAIMSTATUSTG LEFT JOIN PRPDCODE a ON PRPLCLAIMSTATUSTG.NODETYPE = a.CODECODE and a.CODETYPE = 'ClaimNodeType'" +
                        " LEFT JOIN PRPDCODE b ON PRPLCLAIMSTATUSTG.STATUS+0 = b.CODECODE+0  and b.CODETYPE = 'ClaimStatus'" +
                        " WHERE " + conditions +
                        " GROUP BY PRPLCLAIMSTATUSTG.NODETYPE," +
                        " a.CODECNAME," +
                        " PRPLCLAIMSTATUSTG.STATUS," +
                        " PRPLCLAIMSTATUSTG.handlerCode," +
                        " b.CODECNAME ";

        logger.debug(statement);
        Collection collection = new ArrayList();
        StatStatusDto statStatustgDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            statStatustgDto = new StatStatusDto();
            statStatustgDto.setCount(dbManager.getInt(resultSet,6));
            statStatustgDto.setNodeType(dbManager.getString(resultSet,1));
            statStatustgDto.setNodeTypeName(dbManager.getString(resultSet,2));
            statStatustgDto.setUserCode(dbManager.getString(resultSet,4));
            statStatustgDto.setStatus(dbManager.getString(resultSet,3));
            statStatustgDto.setStatusName(dbManager.getString(resultSet,5));
            collection.add(statStatustgDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimStatustgBase.findByConditions() success!");
        return collection;
    }

}
