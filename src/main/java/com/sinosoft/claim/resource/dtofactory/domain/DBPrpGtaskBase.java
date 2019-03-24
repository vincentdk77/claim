package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtaskDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgtask核保核赔任务日志表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGtaskBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpGtaskBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGtaskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void insert(PrpGtaskDto prpGtaskDto) throws Exception{
        String statement = " Insert Into PrpGtask(" + 
                           " TaskType," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " CurrentNode," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGtaskDto.getTaskType());
        dbManager.setString(2,prpGtaskDto.getClassCode());
        dbManager.setString(3,prpGtaskDto.getRiskCode());
        dbManager.setString(4,prpGtaskDto.getComCode());
        dbManager.setString(5,prpGtaskDto.getMakeCom());
        dbManager.setString(6,prpGtaskDto.getOperatorCode());
        dbManager.setString(7,prpGtaskDto.getCertiType());
        dbManager.setString(8,prpGtaskDto.getCertiNo());
        dbManager.setInt(9,prpGtaskDto.getTimes());
        dbManager.setInt(10,prpGtaskDto.getMaxGrade());
        dbManager.setString(11,prpGtaskDto.getTaskExplain());
        dbManager.setDateTime(12,prpGtaskDto.getSysTime());
        dbManager.setInt(13,prpGtaskDto.getCurrentNode());
        dbManager.setInt(14,prpGtaskDto.getCurrentGrade());
        dbManager.setString(15,prpGtaskDto.getUnderWriteCode());
        dbManager.setDateTime(16,prpGtaskDto.getDealDate());
        dbManager.setString(17,prpGtaskDto.getDealResult());
        dbManager.setString(18,prpGtaskDto.getHandleText());
        dbManager.setInt(19,prpGtaskDto.getNextGrade());
        dbManager.setString(20,prpGtaskDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGtaskBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGtaskDto prpGtaskDto = (PrpGtaskDto)i.next();
            insert(prpGtaskDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param taskType 任务类型
     * @param certiType 单证类型
     * @param certiNo 单证号码
     * @param times 次数
     * @param currentNode 当前结点号
     * @throws Exception
     */
    public void delete(String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        String statement = " Delete From PrpGtask Where " +
                           " TaskType = ? And " + 
                           " CertiType = ? And " + 
                           " CertiNo = ? And " + 
                           " Times = ? And " + 
                           " CurrentNode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskType);
        dbManager.setString(2,certiType);
        dbManager.setString(3,certiNo);
        dbManager.setInt(4,times);
        dbManager.setInt(5,currentNode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGtaskBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void update(PrpGtaskDto prpGtaskDto) throws Exception{
        String statement = " Update PrpGtask Set ClassCode = ?," + 
                           " RiskCode = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " OperatorCode = ?," + 
                           " MaxGrade = ?," + 
                           " TaskExplain = ?," + 
                           " SysTime = ?," + 
                           " CurrentGrade = ?," + 
                           " UnderWriteCode = ?," + 
                           " DealDate = ?," + 
                           " DealResult = ?," + 
                           " HandleText = ?," + 
                           " NextGrade = ?," + 
                           " Flag = ? Where " +
                           " TaskType = ? And " + 
                           " CertiType = ? And " + 
                           " CertiNo = ? And " + 
                           " Times = ? And " + 
                           " CurrentNode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGtaskDto.getClassCode());
        dbManager.setString(2,prpGtaskDto.getRiskCode());
        dbManager.setString(3,prpGtaskDto.getComCode());
        dbManager.setString(4,prpGtaskDto.getMakeCom());
        dbManager.setString(5,prpGtaskDto.getOperatorCode());
        dbManager.setInt(6,prpGtaskDto.getMaxGrade());
        dbManager.setString(7,prpGtaskDto.getTaskExplain());
        dbManager.setDateTime(8,prpGtaskDto.getSysTime());
        dbManager.setInt(9,prpGtaskDto.getCurrentGrade());
        dbManager.setString(10,prpGtaskDto.getUnderWriteCode());
        dbManager.setDateTime(11,prpGtaskDto.getDealDate());
        dbManager.setString(12,prpGtaskDto.getDealResult());
        dbManager.setString(13,prpGtaskDto.getHandleText());
        dbManager.setInt(14,prpGtaskDto.getNextGrade());
        dbManager.setString(15,prpGtaskDto.getFlag());
        //设置条件字段;
        dbManager.setString(16,prpGtaskDto.getTaskType());
        dbManager.setString(17,prpGtaskDto.getCertiType());
        dbManager.setString(18,prpGtaskDto.getCertiNo());
        dbManager.setInt(19,prpGtaskDto.getTimes());
        dbManager.setInt(20,prpGtaskDto.getCurrentNode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGtaskBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param taskType 任务类型
     * @param certiType 单证类型
     * @param certiNo 单证号码
     * @param times 次数
     * @param currentNode 当前结点号
     * @return PrpGtaskDto
     * @throws Exception
     */
    public PrpGtaskDto findByPrimaryKey(String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        String statement = " Select TaskType," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " CurrentNode," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag From PrpGtask Where " +
                           " TaskType = ? And " + 
                           " CertiType = ? And " + 
                           " CertiNo = ? And " + 
                           " Times = ? And " + 
                           " CurrentNode = ?";
        PrpGtaskDto prpGtaskDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskType);
        dbManager.setString(2,certiType);
        dbManager.setString(3,certiNo);
        dbManager.setInt(4,times);
        dbManager.setInt(5,currentNode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGtaskDto = new PrpGtaskDto();
            prpGtaskDto.setTaskType(dbManager.getString(resultSet,1));
            prpGtaskDto.setClassCode(dbManager.getString(resultSet,2));
            prpGtaskDto.setRiskCode(dbManager.getString(resultSet,3));
            prpGtaskDto.setComCode(dbManager.getString(resultSet,4));
            prpGtaskDto.setMakeCom(dbManager.getString(resultSet,5));
            prpGtaskDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpGtaskDto.setCertiType(dbManager.getString(resultSet,7));
            prpGtaskDto.setCertiNo(dbManager.getString(resultSet,8));
            prpGtaskDto.setTimes(dbManager.getInt(resultSet,9));
            prpGtaskDto.setMaxGrade(dbManager.getInt(resultSet,10));
            prpGtaskDto.setTaskExplain(dbManager.getString(resultSet,11));
            prpGtaskDto.setSysTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpGtaskDto.setCurrentNode(dbManager.getInt(resultSet,13));
            prpGtaskDto.setCurrentGrade(dbManager.getInt(resultSet,14));
            prpGtaskDto.setUnderWriteCode(dbManager.getString(resultSet,15));
            prpGtaskDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpGtaskDto.setDealResult(dbManager.getString(resultSet,17));
            prpGtaskDto.setHandleText(dbManager.getString(resultSet,18));
            prpGtaskDto.setNextGrade(dbManager.getInt(resultSet,19));
            prpGtaskDto.setFlag(dbManager.getString(resultSet,20));
        }
        resultSet.close();
        log.info("DBPrpGtaskBase.findByPrimaryKey() success!");
        return prpGtaskDto;
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
                           " ClassCode," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " Times," + 
                           " MaxGrade," + 
                           " TaskExplain," + 
                           " SysTime," + 
                           " CurrentNode," + 
                           " CurrentGrade," + 
                           " UnderWriteCode," + 
                           " DealDate," + 
                           " DealResult," + 
                           " HandleText," + 
                           " NextGrade," + 
                           " Flag From PrpGtask Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGtaskDto prpGtaskDto = null;
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

            prpGtaskDto = new PrpGtaskDto();
            prpGtaskDto.setTaskType(dbManager.getString(resultSet,1));
            prpGtaskDto.setClassCode(dbManager.getString(resultSet,2));
            prpGtaskDto.setRiskCode(dbManager.getString(resultSet,3));
            prpGtaskDto.setComCode(dbManager.getString(resultSet,4));
            prpGtaskDto.setMakeCom(dbManager.getString(resultSet,5));
            prpGtaskDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpGtaskDto.setCertiType(dbManager.getString(resultSet,7));
            prpGtaskDto.setCertiNo(dbManager.getString(resultSet,8));
            prpGtaskDto.setTimes(dbManager.getInt(resultSet,9));
            prpGtaskDto.setMaxGrade(dbManager.getInt(resultSet,10));
            prpGtaskDto.setTaskExplain(dbManager.getString(resultSet,11));
            prpGtaskDto.setSysTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpGtaskDto.setCurrentNode(dbManager.getInt(resultSet,13));
            prpGtaskDto.setCurrentGrade(dbManager.getInt(resultSet,14));
            prpGtaskDto.setUnderWriteCode(dbManager.getString(resultSet,15));
            prpGtaskDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpGtaskDto.setDealResult(dbManager.getString(resultSet,17));
            prpGtaskDto.setHandleText(dbManager.getString(resultSet,18));
            prpGtaskDto.setNextGrade(dbManager.getInt(resultSet,19));
            prpGtaskDto.setFlag(dbManager.getString(resultSet,20));
            collection.add(prpGtaskDto);
        }
        resultSet.close();
        log.info("DBPrpGtaskBase.findByConditions() success!");
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
        String statement = "Delete From PrpGtask Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGtaskBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpGtask Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGtaskBase.getCount() success!");
        return count;
    }
}
