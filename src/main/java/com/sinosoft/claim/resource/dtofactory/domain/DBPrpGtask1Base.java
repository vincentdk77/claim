package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtask1Dto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgtask1任务日志表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGtask1Base{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpGtask1Base.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGtask1Base(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void insert(PrpGtask1Dto prpGtask1Dto) throws Exception{
        String statement = " Insert Into PrpGtask1(" + 
                           " TaskType," + 
                           " ModelNo," + 
                           " CaseIdNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " FatherNode," + 
                           " CurrentNode," + 
                           " SonNode," + 
                           " LimitDay," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGtask1Dto.getTaskType());
        dbManager.setInt(2,prpGtask1Dto.getModelNo());
        dbManager.setString(3,prpGtask1Dto.getCaseIdNo());
        dbManager.setString(4,prpGtask1Dto.getClassCode());
        dbManager.setString(5,prpGtask1Dto.getRiskCode());
        dbManager.setString(6,prpGtask1Dto.getComCode());
        dbManager.setString(7,prpGtask1Dto.getMakeCom());
        dbManager.setString(8,prpGtask1Dto.getOperatorCode());
        dbManager.setString(9,prpGtask1Dto.getCertiType());
        dbManager.setString(10,prpGtask1Dto.getCertiNo());
        dbManager.setInt(11,prpGtask1Dto.getSerialNo());
        dbManager.setInt(12,prpGtask1Dto.getTimes());
        dbManager.setInt(13,prpGtask1Dto.getMaxGrade());
        dbManager.setString(14,prpGtask1Dto.getTaskExplain());
        dbManager.setDateTime(15,prpGtask1Dto.getSysTime());
        dbManager.setInt(16,prpGtask1Dto.getFatherNode());
        dbManager.setInt(17,prpGtask1Dto.getCurrentNode());
        dbManager.setInt(18,prpGtask1Dto.getSonNode());
        dbManager.setInt(19,prpGtask1Dto.getLimitDay());
        dbManager.setInt(20,prpGtask1Dto.getCurrentGrade());
        dbManager.setString(21,prpGtask1Dto.getUnderWriteCode());
        dbManager.setDateTime(22,prpGtask1Dto.getDealDate());
        dbManager.setString(23,prpGtask1Dto.getDealResult());
        dbManager.setString(24,prpGtask1Dto.getHandleText());
        dbManager.setInt(25,prpGtask1Dto.getNextGrade());
        dbManager.setString(26,prpGtask1Dto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGtask1Base.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGtask1Dto prpGtask1Dto = (PrpGtask1Dto)i.next();
            insert(prpGtask1Dto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param taskType 任务类型
     * @param modelNo 模板号
     * @param caseIdNo 案件标识号
     * @param certiNo 单证号码
     * @param serialNo 序号
     * @param currentNode 当前结点号
     * @throws Exception
     */
    public void delete(String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        String statement = " Delete From PrpGtask1 Where " +
                           " TaskType = ? And " + 
                           " ModelNo = ? And " + 
                           " CaseIdNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " CurrentNode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskType);
        dbManager.setInt(2,modelNo);
        dbManager.setString(3,caseIdNo);
        dbManager.setString(4,certiNo);
        dbManager.setInt(5,serialNo);
        dbManager.setInt(6,currentNode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGtask1Base.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void update(PrpGtask1Dto prpGtask1Dto) throws Exception{
        String statement = " Update PrpGtask1 Set ClassCode = ?," + 
                           " RiskCode = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " OperatorCode = ?," + 
                           " CertiType = ?," + 
                           " Times = ?," + 
                           " MaxGrade = ?," + 
                           " TaskExplain = ?," + 
                           " SysTime = ?," + 
                           " FatherNode = ?," + 
                           " SonNode = ?," + 
                           " LimitDay = ?," + 
                           " CurrentGrade = ?," + 
                           " UnderWriteCode = ?," + 
                           " DealDate = ?," + 
                           " DealResult = ?," + 
                           " HandleText = ?," + 
                           " NextGrade = ?," + 
                           " Flag = ? Where " +
                           " TaskType = ? And " + 
                           " ModelNo = ? And " + 
                           " CaseIdNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " CurrentNode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGtask1Dto.getClassCode());
        dbManager.setString(2,prpGtask1Dto.getRiskCode());
        dbManager.setString(3,prpGtask1Dto.getComCode());
        dbManager.setString(4,prpGtask1Dto.getMakeCom());
        dbManager.setString(5,prpGtask1Dto.getOperatorCode());
        dbManager.setString(6,prpGtask1Dto.getCertiType());
        dbManager.setInt(7,prpGtask1Dto.getTimes());
        dbManager.setInt(8,prpGtask1Dto.getMaxGrade());
        dbManager.setString(9,prpGtask1Dto.getTaskExplain());
        dbManager.setDateTime(10,prpGtask1Dto.getSysTime());
        dbManager.setInt(11,prpGtask1Dto.getFatherNode());
        dbManager.setInt(12,prpGtask1Dto.getSonNode());
        dbManager.setInt(13,prpGtask1Dto.getLimitDay());
        dbManager.setInt(14,prpGtask1Dto.getCurrentGrade());
        dbManager.setString(15,prpGtask1Dto.getUnderWriteCode());
        dbManager.setDateTime(16,prpGtask1Dto.getDealDate());
        dbManager.setString(17,prpGtask1Dto.getDealResult());
        dbManager.setString(18,prpGtask1Dto.getHandleText());
        dbManager.setInt(19,prpGtask1Dto.getNextGrade());
        dbManager.setString(20,prpGtask1Dto.getFlag());
        //设置条件字段;
        dbManager.setString(21,prpGtask1Dto.getTaskType());
        dbManager.setInt(22,prpGtask1Dto.getModelNo());
        dbManager.setString(23,prpGtask1Dto.getCaseIdNo());
        dbManager.setString(24,prpGtask1Dto.getCertiNo());
        dbManager.setInt(25,prpGtask1Dto.getSerialNo());
        dbManager.setInt(26,prpGtask1Dto.getCurrentNode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGtask1Base.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param taskType 任务类型
     * @param modelNo 模板号
     * @param caseIdNo 案件标识号
     * @param certiNo 单证号码
     * @param serialNo 序号
     * @param currentNode 当前结点号
     * @return PrpGtask1Dto
     * @throws Exception
     */
    public PrpGtask1Dto findByPrimaryKey(String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        String statement = " Select TaskType," + 
                           " ModelNo," + 
                           " CaseIdNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " FatherNode," + 
                           " CurrentNode," + 
                           " SonNode," + 
                           " LimitDay," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag From PrpGtask1 Where " +
                           " TaskType = ? And " + 
                           " ModelNo = ? And " + 
                           " CaseIdNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " CurrentNode = ?";
        PrpGtask1Dto prpGtask1Dto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskType);
        dbManager.setInt(2,modelNo);
        dbManager.setString(3,caseIdNo);
        dbManager.setString(4,certiNo);
        dbManager.setInt(5,serialNo);
        dbManager.setInt(6,currentNode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGtask1Dto = new PrpGtask1Dto();
            prpGtask1Dto.setTaskType(dbManager.getString(resultSet,1));
            prpGtask1Dto.setModelNo(dbManager.getInt(resultSet,2));
            prpGtask1Dto.setCaseIdNo(dbManager.getString(resultSet,3));
            prpGtask1Dto.setClassCode(dbManager.getString(resultSet,4));
            prpGtask1Dto.setRiskCode(dbManager.getString(resultSet,5));
            prpGtask1Dto.setComCode(dbManager.getString(resultSet,6));
            prpGtask1Dto.setMakeCom(dbManager.getString(resultSet,7));
            prpGtask1Dto.setOperatorCode(dbManager.getString(resultSet,8));
            prpGtask1Dto.setCertiType(dbManager.getString(resultSet,9));
            prpGtask1Dto.setCertiNo(dbManager.getString(resultSet,10));
            prpGtask1Dto.setSerialNo(dbManager.getInt(resultSet,11));
            prpGtask1Dto.setTimes(dbManager.getInt(resultSet,12));
            prpGtask1Dto.setMaxGrade(dbManager.getInt(resultSet,13));
            prpGtask1Dto.setTaskExplain(dbManager.getString(resultSet,14));
            prpGtask1Dto.setSysTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpGtask1Dto.setFatherNode(dbManager.getInt(resultSet,16));
            prpGtask1Dto.setCurrentNode(dbManager.getInt(resultSet,17));
            prpGtask1Dto.setSonNode(dbManager.getInt(resultSet,18));
            prpGtask1Dto.setLimitDay(dbManager.getInt(resultSet,19));
            prpGtask1Dto.setCurrentGrade(dbManager.getInt(resultSet,20));
            prpGtask1Dto.setUnderWriteCode(dbManager.getString(resultSet,21));
            prpGtask1Dto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpGtask1Dto.setDealResult(dbManager.getString(resultSet,23));
            prpGtask1Dto.setHandleText(dbManager.getString(resultSet,24));
            prpGtask1Dto.setNextGrade(dbManager.getInt(resultSet,25));
            prpGtask1Dto.setFlag(dbManager.getString(resultSet,26));
        }
        resultSet.close();
        log.info("DBPrpGtask1Base.findByPrimaryKey() success!");
        return prpGtask1Dto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select TaskType," + 
                           " ModelNo," + 
                           " CaseIdNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " FatherNode," + 
                           " CurrentNode," + 
                           " SonNode," + 
                           " LimitDay," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag From PrpGtask1 Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGtask1Dto prpGtask1Dto = null;
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

            prpGtask1Dto = new PrpGtask1Dto();
            prpGtask1Dto.setTaskType(dbManager.getString(resultSet,1));
            prpGtask1Dto.setModelNo(dbManager.getInt(resultSet,2));
            prpGtask1Dto.setCaseIdNo(dbManager.getString(resultSet,3));
            prpGtask1Dto.setClassCode(dbManager.getString(resultSet,4));
            prpGtask1Dto.setRiskCode(dbManager.getString(resultSet,5));
            prpGtask1Dto.setComCode(dbManager.getString(resultSet,6));
            prpGtask1Dto.setMakeCom(dbManager.getString(resultSet,7));
            prpGtask1Dto.setOperatorCode(dbManager.getString(resultSet,8));
            prpGtask1Dto.setCertiType(dbManager.getString(resultSet,9));
            prpGtask1Dto.setCertiNo(dbManager.getString(resultSet,10));
            prpGtask1Dto.setSerialNo(dbManager.getInt(resultSet,11));
            prpGtask1Dto.setTimes(dbManager.getInt(resultSet,12));
            prpGtask1Dto.setMaxGrade(dbManager.getInt(resultSet,13));
            prpGtask1Dto.setTaskExplain(dbManager.getString(resultSet,14));
            prpGtask1Dto.setSysTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpGtask1Dto.setFatherNode(dbManager.getInt(resultSet,16));
            prpGtask1Dto.setCurrentNode(dbManager.getInt(resultSet,17));
            prpGtask1Dto.setSonNode(dbManager.getInt(resultSet,18));
            prpGtask1Dto.setLimitDay(dbManager.getInt(resultSet,19));
            prpGtask1Dto.setCurrentGrade(dbManager.getInt(resultSet,20));
            prpGtask1Dto.setUnderWriteCode(dbManager.getString(resultSet,21));
            prpGtask1Dto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpGtask1Dto.setDealResult(dbManager.getString(resultSet,23));
            prpGtask1Dto.setHandleText(dbManager.getString(resultSet,24));
            prpGtask1Dto.setNextGrade(dbManager.getInt(resultSet,25));
            prpGtask1Dto.setFlag(dbManager.getString(resultSet,26));
            collection.add(prpGtask1Dto);
        }
        resultSet.close();
        log.info("DBPrpGtask1Base.findByConditions() success!");
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
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpGtask1 Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGtask1Base.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(*) from PrpGtask1 Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGtask1Base.getCount() success!");
        return count;
    }
}
