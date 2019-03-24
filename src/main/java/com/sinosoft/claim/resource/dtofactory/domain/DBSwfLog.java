package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLog工作流日志表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.922<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfLog extends DBSwfLogBase{
    private static Log logger = LogFactory.getLog(DBSwfLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfLog(DBManager dbManager){
        super(dbManager);
    }


     /**
     * 获取logno号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxLogNo(String flowID)
        throws Exception{
        int LogNo = -1;
        String statement = "Select max(LogNo+1) from swfLog Where flowID='" +flowID+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        LogNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLog.getMaxLogNo() success!");
        if (LogNo==0)
        {
          LogNo=1;
        }

        return LogNo ;
    }
    
    /**
     * 获取logno号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxNodeLogNo(String flowID,String nodeType,String businessNo)
        throws Exception{
        int LogNo = -1;
        String statement = "Select max(LogNo) from swfLog Where flowID='" +flowID+"' and  nodeType='"+ nodeType +"' and businessNo='"+businessNo+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        LogNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLog.getMaxLogNo() success!");
        if (LogNo==0)
        {
          LogNo=1;
        }

        return LogNo ;
    }
    
    /**
     * 根据flowId查询最大节点的节点名称
     * @param flowID
     * @return nodeName 节点名称
     * @throws Exception
     */
    public String getMaxNodeName(String flowID)
        throws Exception{
        String nodeName = "";
        String statement = "Select  nodename From (Select s.logno,s.Nodename ,Rownum As num  " +
        		"From swflog s Where s.flowid='" + flowID + "' " +
        		"Order By s.logno Desc ) Where num=1";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        nodeName = dbManager.getString(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLog.getMaxLogNo() success!");
       
        return nodeName ;
    }
    /**
     * 更新节点的状态 和keyOut 的logno号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public void updateStatus(SwfLogDto swfLogDto)
     throws SQLException,Exception
    {

            String statement = "update swflog set nodestatus='"+ swfLogDto.getNodeStatus()
                     +"', keyOut ='"+ swfLogDto.getKeyOut()+ "' Where logno ="+ swfLogDto.getLogNo()+ " and flowID='"+ swfLogDto.getFlowID()+"'";
            dbManager.executeUpdate(statement);


    }
    
    /**
     * 查勘退回更新submittime，nodestatus，flowStatus
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public void updateReturnStatus(SwfLogDto swfLogDto)
     throws SQLException,Exception
    {

            String statement = "update swflog set nodestatus='"+ swfLogDto.getNodeStatus()
                     +"', flowStatus ='"+ swfLogDto.getFlowStatus()+"' ,submittime=''  Where logno ="+ swfLogDto.getLogNo()+ " and flowID='"+ swfLogDto.getFlowID()+"'";
            
            dbManager.executeUpdate(statement);
    }

     /**
     * 按条件对节点进行状态统计
     * @param conditions 统计条件
     * @return Collection
     * @throws Exception
     */
    public Collection getNodeStatusStat(String conditions) throws Exception{

      String statement =  " SELECT c.NODETYPE,"+
                          " a.CODECNAME,"+
                          " c.nodeSTATUS,"+
                          " b.CODECNAME,"+
                          " count(1) "+
                          " FROM swflog c LEFT JOIN PRPDCODE a ON c.NODETYPE = "+
                          " a.CODECODE and a.CODETYPE = 'ClaimNodeType'"+
                          " LEFT JOIN PRPDCODE b ON c.nodeSTATUS+0 = b.CODECODE+0  and b.CODETYPE = 'ClaimStatus'"+
                          " where "+conditions+
                          " GROUP BY  c.NODETYPE,"+
                          " a.CODECNAME,"+
                          " c.nodeSTATUS,"+
                          " b.CODECNAME" +
                          " order by 2,3";

        logger.debug(statement);
        Collection collection = new ArrayList();
        StatStatusDto statStatusDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            statStatusDto = new StatStatusDto();
            statStatusDto.setCount(dbManager.getInt(resultSet,5));
            statStatusDto.setNodeType(dbManager.getString(resultSet,1));
            statStatusDto.setNodeTypeName(dbManager.getString(resultSet,2));
            statStatusDto.setStatus(dbManager.getString(resultSet,3));
            statStatusDto.setStatusName(dbManager.getString(resultSet,4));
            collection.add(statStatusDto);
            count++;
        }
        resultSet.close();
        logger.info("DBSwfLog.getNodeStatusStat() success!"+count);
        return collection;
    }


     /**
     * 按条件对节点进行状态统计用户
     * @param conditions 统计条件
     * @return Collection
     * @throws Exception
     */
    public Collection getNodeUserStatusStat(String conditions) throws Exception{

      String statement =  " SELECT c.NODETYPE,"+
                          " a.CODECNAME,"+
                          " c.handlerCode,"+
                          " c.handlerName,"+
                          " c.nodeSTATUS,"+
                          " b.CODECNAME,"+
                          " count(1) "+
                          " FROM swflog c LEFT JOIN PRPDCODE a ON c.NODETYPE = "+
                          " a.CODECODE and a.CODETYPE = 'ClaimNodeType'"+
                          " LEFT JOIN PRPDCODE b ON c.nodeSTATUS+0 = b.CODECODE+0  and b.CODETYPE = 'ClaimStatus'"+
                          " where "+conditions+
                          " GROUP BY  c.NODETYPE,"+
                          " a.CODECNAME,"+
                          " c.handlerCode,"+
                          " c.handlerName,"+
                          " c.nodeSTATUS,"+
                          " b.CODECNAME" +
                          " order by 2,4,5";

        logger.debug(statement);
        Collection collection = new ArrayList();
        StatStatusDto statStatusDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){
            statStatusDto = new StatStatusDto();
            statStatusDto.setCount(dbManager.getInt(resultSet,7));
            statStatusDto.setNodeType(dbManager.getString(resultSet,1));
            statStatusDto.setNodeTypeName(dbManager.getString(resultSet,2));
            statStatusDto.setUserCode(dbManager.getString(resultSet,3));
            statStatusDto.setUserName(dbManager.getString(resultSet,4));
            statStatusDto.setStatus(dbManager.getString(resultSet,5));
            statStatusDto.setStatusName(dbManager.getString(resultSet,6));
            collection.add(statStatusDto);
            count++;
        }
        resultSet.close();
        logger.info("DBSwfLog.getNodeStatusStat() success!"+count);
        return collection;
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
                           " Status From PrpLclaimStatus Where " + conditions +" group by status,nodetype,HandlerCode";
       */

       String statement =" SELECT NodeType, "
                        +" NodeName,"
                        +" NodeStatus,"
                        +" count(1) "
                        +" FROM swfLog"
                        + " WHERE " + conditions
                        + " GROUP BY NodeType,"  
                        + " NodeName,"
                        + "NodeStatus"
                        + " order by NodeType,NodeStatus desc";
        logger.debug(statement);
        Collection collection = new ArrayList();
        StatStatusDto statStatusDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        while(resultSet.next()){ 
            statStatusDto = new StatStatusDto();
            statStatusDto.setNodeType(dbManager.getString(resultSet,1));
            statStatusDto.setNodeTypeName(dbManager.getString(resultSet,2));
            statStatusDto.setStatus(dbManager.getString(resultSet,3));
            statStatusDto.setCount(dbManager.getInt(resultSet,4));
            collection.add(statStatusDto);
        } 
        resultSet.close();
        logger.info("DBPrpLclaimStatusBase.findByConditions() success!");
        return collection;
    }

//  modify by liuyanmei add 20051102 start
    public void updateFlowStatus(DBManager dbManager,String flowId)
    throws SQLException,Exception
  {
    String statement = "";
    String condition = " flowId='" + StringUtils.rightTrim(flowId) + "'";
    statement = " update swflog set flowStatus='1' Where " + condition;
    dbManager.executeUpdate(statement);
  }
//modify by liuyanmei add 20051102 end 
    
    //add by qiansong start
    public void updateNodeStatus(DBManager dbManager,String nodeStatus,String str)
        throws SQLException,Exception
    {
        String statement = "";
        statement = " update swflog set nodeStatus='"+nodeStatus+"' Where " + str;
        dbManager.executeUpdate(statement);
    }
    //add by qiansong end
}
