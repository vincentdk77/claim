package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertainLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertainLoss定损主表的数据访问对象基类<br>
 * 创建于 2004-07-15 14:09:26.101<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcertainLossBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcertainLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertainLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void insert(PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        String mainStatement = " Insert Into PrpLcertainLoss (" +
                           " ClaimNo," +
                           " RiskCode," +
                           " RegistNo," +
                           " LossItemCode," +
                           " LossItemName," +
                           " PolicyNo," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Currency," +
                           " SumRest," +
                           " SumManager," +
                           " SumCertainLoss," +
                           " SumVerifyLoss," +
                           " LossDesc," +
                           " IndemnityDuty," +
                           " IndemnityDutyRate," +
                           " Remark," +
                           " OperatorCode," +
                           " ApproverCode," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            String debugStatement = mainStatement + " values(" +
                           "'" + prpLcertainLossDto.getClaimNo() + "'," +
                           "'" + prpLcertainLossDto.getRiskCode() + "'," +
                           "'" + prpLcertainLossDto.getRegistNo() + "'," +
                           "'" + prpLcertainLossDto.getLossItemCode() + "'," +
                           "'" + prpLcertainLossDto.getLossItemName() + "'," +
                           "'" + prpLcertainLossDto.getPolicyNo() + "'," +
                           "'" + prpLcertainLossDto.getStartDate() + "'," +
                           "'" + prpLcertainLossDto.getStartHour() + "'," +
                           "'" + prpLcertainLossDto.getEndDate() + "'," +
                           "'" + prpLcertainLossDto.getEndHour() + "'," +
                           "'" + prpLcertainLossDto.getCurrency() + "'," +
                           "'" + prpLcertainLossDto.getSumRest() + "'," +
                           "'" + prpLcertainLossDto.getSumManager() + "'," +
                           "'" + prpLcertainLossDto.getSumCertainLoss() + "'," +
                           "'" + prpLcertainLossDto.getSumVerifyLoss() + "'," +
                           "'" + prpLcertainLossDto.getLossDesc() + "'," +
                           "'" + prpLcertainLossDto.getIndemnityDuty() + "'," +
                           "'" + prpLcertainLossDto.getIndemnityDutyRate() + "'," +
                           "'" + prpLcertainLossDto.getRemark() + "'," +
                           "'" + prpLcertainLossDto.getOperatorCode() + "'," +
                           "'" + prpLcertainLossDto.getApproverCode() + "'," +
                           "'" + prpLcertainLossDto.getFlag() + "')";
            logger.debug(debugStatement);


        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcertainLossDto.getClaimNo());
        dbManager.setString(2,prpLcertainLossDto.getRiskCode());
        dbManager.setString(3,prpLcertainLossDto.getRegistNo());
        dbManager.setString(4,prpLcertainLossDto.getLossItemCode());
        dbManager.setString(5,prpLcertainLossDto.getLossItemName());
        dbManager.setString(6,prpLcertainLossDto.getPolicyNo());
        dbManager.setDateTime(7,prpLcertainLossDto.getStartDate());
        dbManager.setString(8,prpLcertainLossDto.getStartHour());
        dbManager.setDateTime(9,prpLcertainLossDto.getEndDate());
        dbManager.setString(10,prpLcertainLossDto.getEndHour());
        dbManager.setString(11,prpLcertainLossDto.getCurrency());
        dbManager.setDouble(12,prpLcertainLossDto.getSumRest());
        dbManager.setDouble(13,prpLcertainLossDto.getSumManager());
        dbManager.setDouble(14,prpLcertainLossDto.getSumCertainLoss());
        dbManager.setDouble(15,prpLcertainLossDto.getSumVerifyLoss());
        dbManager.setString(16,prpLcertainLossDto.getLossDesc());
        dbManager.setString(17,prpLcertainLossDto.getIndemnityDuty());
        dbManager.setDouble(18,prpLcertainLossDto.getIndemnityDutyRate());
        dbManager.setString(19,prpLcertainLossDto.getRemark());
        dbManager.setString(20,prpLcertainLossDto.getOperatorCode());
        dbManager.setString(21,prpLcertainLossDto.getApproverCode());
        dbManager.setString(22,prpLcertainLossDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcertainLossBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLcertainLossDto prpLcertainLossDto = (PrpLcertainLossDto)i.next();
            insert(prpLcertainLossDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param lossItemCode 标的序号
     * @throws Exception
     */
    public void delete(String registNo,String lossItemCode) throws Exception{
        String statement = " Delete From PrpLcertainLoss" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " LossItemCode = ?";

            String debugStatement = "Delete From PrpLcertainLoss Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);


        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcertainLossBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void update(PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        String statement = " Update PrpLcertainLoss Set ClaimNo = ?," +
                           " RiskCode = ?," +
                           " LossItemName = ?," +
                           " PolicyNo = ?," +
                           " StartDate = ?," +
                           " StartHour = ?," +
                           " EndDate = ?," +
                           " EndHour = ?," +
                           " Currency = ?," +
                           " SumRest = ?," +
                           " SumManager = ?," +
                           " SumCertainLoss = ?," +
                           " SumVerifyLoss = ?," +
                           " LossDesc = ?," +
                           " IndemnityDuty = ?," +
                           " IndemnityDutyRate = ?," +
                           " Remark = ?," +
                           " OperatorCode = ?," +
                           " ApproverCode = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " LossItemCode = ?";

            String debugStatement = "Update PrpLcertainLoss Set " +
                           " ClaimNo = '" + prpLcertainLossDto.getClaimNo() + "'," +
                           " RiskCode = '" + prpLcertainLossDto.getRiskCode() + "'," +
                           " RegistNo = '" + prpLcertainLossDto.getRegistNo() + "'," +
                           " LossItemCode = '" + prpLcertainLossDto.getLossItemCode() + "'," +
                           " LossItemName = '" + prpLcertainLossDto.getLossItemName() + "'," +
                           " PolicyNo = '" + prpLcertainLossDto.getPolicyNo() + "'," +
                           " StartDate = '" + prpLcertainLossDto.getStartDate() + "'," +
                           " StartHour = '" + prpLcertainLossDto.getStartHour() + "'," +
                           " EndDate = '" + prpLcertainLossDto.getEndDate() + "'," +
                           " EndHour = '" + prpLcertainLossDto.getEndHour() + "'," +
                           " Currency = '" + prpLcertainLossDto.getCurrency() + "'," +
                           " SumRest = '" + prpLcertainLossDto.getSumRest() + "'," +
                           " SumManager = '" + prpLcertainLossDto.getSumManager() + "'," +
                           " SumCertainLoss = '" + prpLcertainLossDto.getSumCertainLoss() + "'," +
                           " SumVerifyLoss = '" + prpLcertainLossDto.getSumVerifyLoss() + "'," +
                           " LossDesc = '" + prpLcertainLossDto.getLossDesc() + "'," +
                           " IndemnityDuty = '" + prpLcertainLossDto.getIndemnityDuty() + "'," +
                           " IndemnityDutyRate = '" + prpLcertainLossDto.getIndemnityDutyRate() + "'," +
                           " Remark = '" + prpLcertainLossDto.getRemark() + "'," +
                           " OperatorCode = '" + prpLcertainLossDto.getOperatorCode() + "'," +
                           " ApproverCode = '" + prpLcertainLossDto.getApproverCode() + "'," +
                           " Flag = '" + prpLcertainLossDto.getFlag() + "'" +
			               " Where " +
                           " RegistNo = '" + prpLcertainLossDto.getRegistNo() + "' And " +
                           " LossItemCode = '" + prpLcertainLossDto.getLossItemCode() + "'";
            logger.debug(debugStatement);


        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcertainLossDto.getClaimNo());
        dbManager.setString(2,prpLcertainLossDto.getRiskCode());
        dbManager.setString(3,prpLcertainLossDto.getLossItemName());
        dbManager.setString(4,prpLcertainLossDto.getPolicyNo());
        dbManager.setDateTime(5,prpLcertainLossDto.getStartDate());
        dbManager.setString(6,prpLcertainLossDto.getStartHour());
        dbManager.setDateTime(7,prpLcertainLossDto.getEndDate());
        dbManager.setString(8,prpLcertainLossDto.getEndHour());
        dbManager.setString(9,prpLcertainLossDto.getCurrency());
        dbManager.setDouble(10,prpLcertainLossDto.getSumRest());
        dbManager.setDouble(11,prpLcertainLossDto.getSumManager());
        dbManager.setDouble(12,prpLcertainLossDto.getSumCertainLoss());
        dbManager.setDouble(13,prpLcertainLossDto.getSumVerifyLoss());
        dbManager.setString(14,prpLcertainLossDto.getLossDesc());
        dbManager.setString(15,prpLcertainLossDto.getIndemnityDuty());
        dbManager.setDouble(16,prpLcertainLossDto.getIndemnityDutyRate());
        dbManager.setString(17,prpLcertainLossDto.getRemark());
        dbManager.setString(18,prpLcertainLossDto.getOperatorCode());
        dbManager.setString(19,prpLcertainLossDto.getApproverCode());
        dbManager.setString(20,prpLcertainLossDto.getFlag());
        //设置条件字段;
        dbManager.setString(21,prpLcertainLossDto.getRegistNo());
        dbManager.setString(22,prpLcertainLossDto.getLossItemCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcertainLossBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param lossItemCode 标的序号
     * @return PrpLcertainLossDto
     * @throws Exception
     */
    public PrpLcertainLossDto findByPrimaryKey(String registNo,String lossItemCode) throws Exception{
        String mainStatement = " Select ClaimNo," +
                           " RiskCode," +
                           " RegistNo," +
                           " LossItemCode," +
                           " LossItemName," +
                           " PolicyNo," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Currency," +
                           " SumRest," +
                           " SumManager," +
                           " SumCertainLoss," +
                           " SumVerifyLoss," +
                           " LossDesc," +
                           " IndemnityDuty," +
                           " IndemnityDutyRate," +
                           " Remark," +
                           " OperatorCode," +
                           " ApproverCode," +
                           " Flag From PrpLcertainLoss";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " +
                           " LossItemCode = ?";
        PrpLcertainLossDto prpLcertainLossDto = null;

            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);


        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcertainLossDto = new PrpLcertainLossDto();
            prpLcertainLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcertainLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcertainLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcertainLossDto.setLossItemCode(dbManager.getString(resultSet,4));
            prpLcertainLossDto.setLossItemName(dbManager.getString(resultSet,5));
            prpLcertainLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcertainLossDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcertainLossDto.setStartHour(dbManager.getString(resultSet,8));
            prpLcertainLossDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLcertainLossDto.setEndHour(dbManager.getString(resultSet,10));
            prpLcertainLossDto.setCurrency(dbManager.getString(resultSet,11));
            prpLcertainLossDto.setSumRest(dbManager.getDouble(resultSet,12));
            prpLcertainLossDto.setSumManager(dbManager.getDouble(resultSet,13));
            prpLcertainLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,14));
            prpLcertainLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,15));
            prpLcertainLossDto.setLossDesc(dbManager.getString(resultSet,16));
            prpLcertainLossDto.setIndemnityDuty(dbManager.getString(resultSet,17));
            prpLcertainLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,18));
            prpLcertainLossDto.setRemark(dbManager.getString(resultSet,19));
            prpLcertainLossDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLcertainLossDto.setApproverCode(dbManager.getString(resultSet,21));
            prpLcertainLossDto.setFlag(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        logger.info("DBPrpLcertainLossBase.findByPrimaryKey() success!");
        return prpLcertainLossDto;
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
        String statement = "Select ClaimNo," +
                           " RiskCode," +
                           " RegistNo," +
                           " LossItemCode," +
                           " LossItemName," +
                           " PolicyNo," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Currency," +
                           " SumRest," +
                           " SumManager," +
                           " SumCertainLoss," +
                           " SumVerifyLoss," +
                           " LossDesc," +
                           " IndemnityDuty," +
                           " IndemnityDutyRate," +
                           " Remark," +
                           " OperatorCode," +
                           " ApproverCode," +
                           " Flag From PrpLcertainLoss Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcertainLossDto prpLcertainLossDto = null;
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

            prpLcertainLossDto = new PrpLcertainLossDto();
            prpLcertainLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcertainLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcertainLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcertainLossDto.setLossItemCode(dbManager.getString(resultSet,4));
            prpLcertainLossDto.setLossItemName(dbManager.getString(resultSet,5));
            prpLcertainLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcertainLossDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcertainLossDto.setStartHour(dbManager.getString(resultSet,8));
            prpLcertainLossDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLcertainLossDto.setEndHour(dbManager.getString(resultSet,10));
            prpLcertainLossDto.setCurrency(dbManager.getString(resultSet,11));
            prpLcertainLossDto.setSumRest(dbManager.getDouble(resultSet,12));
            prpLcertainLossDto.setSumManager(dbManager.getDouble(resultSet,13));
            prpLcertainLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,14));
            prpLcertainLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,15));
            prpLcertainLossDto.setLossDesc(dbManager.getString(resultSet,16));
            prpLcertainLossDto.setIndemnityDuty(dbManager.getString(resultSet,17));
            prpLcertainLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,18));
            prpLcertainLossDto.setRemark(dbManager.getString(resultSet,19));
            prpLcertainLossDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLcertainLossDto.setApproverCode(dbManager.getString(resultSet,21));
            prpLcertainLossDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpLcertainLossDto);
        }
        resultSet.close();
        logger.info("DBPrpLcertainLossBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcertainLoss Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcertainLossBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcertainLoss Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcertainLossBase.getCount() success!");
        return count;
    }
}
