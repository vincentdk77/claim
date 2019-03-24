package com.gyic.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gyic.claim.dto.custom.ClaimCombineDto;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogBase;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class PrpCombineSwfLogBase {
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBSwfLogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public PrpCombineSwfLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
//    public Collection findAllStatusByConditions(String swflogConditions,String swflogStoreConditions,int pageNo,int rowsPerPage) throws Exception{
//        String statement = "Select FlowID," + 
//                           " LogNo," + 
//                           " ModelNo," + 
//                           " NodeNo," + 
//                           " NodeName," + 
//                           " BusinessNo," + 
//                           " HandleDept," + 
//                           " HandlerCode," + 
//                           " HandlerName," + 
//                           " FlowInTime," + 
//                           " TimeLimit," + 
//                           " HandleTime," + 
//                           " SubmitTime," + 
//                           " NodeStatus," + 
//                           " FlowStatus," + 
//                           " PackageID," + 
//                           " Flag," + 
//                           " TaskNo," + 
//                           " TaskType," + 
//                           " NodeType," + 
//                           " TitleStr," + 
//                           " BusinessType," + 
//                           " RiskCode," + 
//                           " KeyIn," + 
//                           " KeyOut," + 
//                           " DeptName," + 
//                           " MainFlowID," + 
//                           " SubFlowID," + 
//                           " PosX," + 
//                           " PosY," + 
//                           " EndFlag," + 
//                           " BeforeHandlerCode," + 
//                           " BeforeHandlerName," + 
//                           " PolicyNo," + 
//                           " TypeFlag," + 
//                           " ComCode," + 
//                           " ScheduleID," + 
//                           " LossItemCode," + 
//                           " LossItemName," + 
//                           " InsureCarFlag," + 
//                           " HandlerRange," + 
//                           " ExigenceGree," + 
//                           " RegistNo," + 
//                           " InsuredName " +
//                           " From (" +
//                           " select * From SwfLog Where " + swflogConditions + 
//                           " union all " +
//                           " select * From SwfLogStore Where " + swflogStoreConditions +
//                           ")  order by handleTime desc" ;
//        logger.debug(statement);
//        Collection collection = new ArrayList();
//        SwfLogDto swfLogDto = null;
//        ResultSet resultSet = dbManager.executeQuery(statement);
//        int count=0;
//        if(pageNo>1){
//            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
//        }
//
//        while(resultSet.next()){
//            count++;
//            if(pageNo>0){
//                if(count > rowsPerPage){
//                	break;
//                }
//            }
//
//            swfLogDto = new SwfLogDto();
//            swfLogDto.setFlowID(dbManager.getString(resultSet,1));
//            swfLogDto.setLogNo(dbManager.getInt(resultSet,2));
//            swfLogDto.setModelNo(dbManager.getInt(resultSet,3));
//            swfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
//            swfLogDto.setNodeName(dbManager.getString(resultSet,5));
//            swfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
//            swfLogDto.setHandleDept(dbManager.getString(resultSet,7));
//            swfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
//            swfLogDto.setHandlerName(dbManager.getString(resultSet,9));
//            swfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
//            swfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
//            swfLogDto.setHandleTime(dbManager.getString(resultSet,12));
//            swfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
//            swfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
//            swfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
//            swfLogDto.setPackageID(dbManager.getString(resultSet,16));
//            swfLogDto.setFlag(dbManager.getString(resultSet,17));
//            swfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
//            swfLogDto.setTaskType(dbManager.getString(resultSet,19));
//            swfLogDto.setNodeType(dbManager.getString(resultSet,20));
//            swfLogDto.setTitleStr(dbManager.getString(resultSet,21));
//            swfLogDto.setBusinessType(dbManager.getString(resultSet,22));
//            swfLogDto.setRiskCode(dbManager.getString(resultSet,23));
//            swfLogDto.setKeyIn(dbManager.getString(resultSet,24));
//            swfLogDto.setKeyOut(dbManager.getString(resultSet,25));
//            swfLogDto.setDeptName(dbManager.getString(resultSet,26));
//            swfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
//            swfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
//            swfLogDto.setPosX(dbManager.getInt(resultSet,29));
//            swfLogDto.setPosY(dbManager.getInt(resultSet,30));
//            swfLogDto.setEndFlag(dbManager.getString(resultSet,31));
//            swfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
//            swfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
//            swfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
//            swfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
//            swfLogDto.setComCode(dbManager.getString(resultSet,36));
//            swfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
//            swfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
//            swfLogDto.setLossItemName(dbManager.getString(resultSet,39));
//            swfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
//            swfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
//            swfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
//            swfLogDto.setRegistNo(dbManager.getString(resultSet,43));
//            swfLogDto.setInsuredName(dbManager.getString(resultSet,44));
//            collection.add(swfLogDto);
//        }
//        resultSet.close();
//        logger.info("DBSwfLogBase.findByConditions() success!");
//        return collection;
//    }
    /**
     * 锟斤拷锟斤拷锟斤拷锟窖拷锟斤拷锟斤拷锟斤拷
     * @param dbManager DB锟斤拷锟斤拷锟斤拷
     * @param conditions 锟斤拷询锟斤拷锟�
     * @param pageNo 页锟斤拷
     * @param rowsPerPage 每页锟斤拷锟斤拷锟斤拷
     * @return PageRecord 锟斤拷询锟斤拷一页锟侥斤拷锟�
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrplcombine dbPrplcombine = new DBPrplcombine(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcombine.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcombine.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * 按条件查询多条数据
     * swflog 与 prplcombine联表查询得到。
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select SWFLOG.FlowID," + 
                           " SWFLOG.LogNo," + 
                           " SWFLOG.ModelNo," + 
                           " SWFLOG.NodeNo," + 
                           " SWFLOG.NodeName," + 
                           " SWFLOG.BusinessNo," + 
                           " SWFLOG.HandleDept," + 
                           " SWFLOG.HandlerCode," + 
                           " SWFLOG.HandlerName," + 
                           " SWFLOG.FlowInTime," + 
                           " SWFLOG.TimeLimit," + 
                           " SWFLOG.HandleTime," + 
                           " SWFLOG.SubmitTime," + 
                           " SWFLOG.NodeStatus," + 
                           " SWFLOG.FlowStatus," + 
                           " SWFLOG.PackageID," + 
                           " SWFLOG.Flag," + 
                           " SWFLOG.TaskNo," + 
                           " SWFLOG.TaskType," + 
                           " SWFLOG.NodeType," + 
                           " SWFLOG.TitleStr," + 
                           " SWFLOG.BusinessType," + 
                           " SWFLOG.RiskCode," + 
                           " SWFLOG.KeyIn," + 
                           " SWFLOG.KeyOut," + 
                           " SWFLOG.DeptName," + 
                           " SWFLOG.MainFlowID," + 
                           " SWFLOG.SubFlowID," + 
                           " SWFLOG.PosX," + 
                           " SWFLOG.PosY," + 
                           " SWFLOG.EndFlag," + 
                           " SWFLOG.BeforeHandlerCode," + 
                           " SWFLOG.BeforeHandlerName," + 
                           " SWFLOG.PolicyNo," + 
                           " SWFLOG.TypeFlag," + 
                           " SWFLOG.ComCode," + 
                           " SWFLOG.ScheduleID," + 
                           " SWFLOG.LossItemCode," + 
                           " SWFLOG.LossItemName," + 
                           " SWFLOG.InsureCarFlag," + 
                           " SWFLOG.HandlerRange," + 
                           " SWFLOG.ExigenceGree," + 
                           " SWFLOG.RegistNo," + 
                           " SWFLOG.InsuredName," + 
                           " PRPLCOMBINE.COMBINENO," + 
                           " PRPLCOMBINE.PolicyNo," + 
                           " PRPLCOMBINE.RegistNo From SwfLog, PRPLCOMBINE Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfLogDto swfLogDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }
            ClaimCombineDto claimCombineDto = new ClaimCombineDto();
            swfLogDto = new SwfLogDto();
            swfLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogDto.setFlag(dbManager.getString(resultSet,17));
            swfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogDto.setComCode(dbManager.getString(resultSet,36)); 
            swfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,43));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,44));
            claimCombineDto.setSwfLogDto(swfLogDto);
            PrplcombineDto prplcombineDto = new PrplcombineDto();
            prplcombineDto.setCombineno(dbManager.getString(resultSet,45));
            prplcombineDto.setPolicyno(dbManager.getString(resultSet,46));
            prplcombineDto.setRegistno(dbManager.getString(resultSet,47));
            claimCombineDto.setPrplcombineDto(prplcombineDto);
            collection.add(claimCombineDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
//    public int deleteByConditions(String conditions) throws Exception{
//        String statement = "Delete From SwfLog Where " + conditions;
//        logger.debug(statement);
//        int count = dbManager.executeUpdate(statement);
//        logger.info("DBSwfLogBase.deleteByConditions() success!");
//        return count;
//    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(*) from SwfLog, PRPLCOMBINE Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
}
