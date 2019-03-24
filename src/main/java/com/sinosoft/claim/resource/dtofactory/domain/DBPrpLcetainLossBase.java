package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcetainLoss的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.921<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcetainLossBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcetainLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcetainLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void insert(PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        String mainStatement = " Insert Into PrpLcetainLoss (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " LicenseNo," + 
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
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcetainLossDto.getClaimNo() + "'," + 
                           "'" + prpLcetainLossDto.getRiskCode() + "'," + 
                           "'" + prpLcetainLossDto.getRegistNo() + "'," + 
                           "" + prpLcetainLossDto.getItemNo() + "," + 
                           "'" + prpLcetainLossDto.getLicenseNo() + "'," + 
                           "'" + prpLcetainLossDto.getPolicyNo() + "'," + 
                           "'" + prpLcetainLossDto.getStartDate() + "'," + 
                           "'" + prpLcetainLossDto.getStartHour() + "'," + 
                           "'" + prpLcetainLossDto.getEndDate() + "'," + 
                           "'" + prpLcetainLossDto.getEndHour() + "'," + 
                           "'" + prpLcetainLossDto.getCurrency() + "'," + 
                           "'" + prpLcetainLossDto.getSumRest() + "'," + 
                           "'" + prpLcetainLossDto.getSumManager() + "'," + 
                           "'" + prpLcetainLossDto.getSumCertainLoss() + "'," + 
                           "'" + prpLcetainLossDto.getSumVerifyLoss() + "'," + 
                           "'" + prpLcetainLossDto.getLossDesc() + "'," + 
                           "'" + prpLcetainLossDto.getIndemnityDuty() + "'," + 
                           "'" + prpLcetainLossDto.getIndemnityDutyRate() + "'," + 
                           "'" + prpLcetainLossDto.getRemark() + "'," + 
                           "'" + prpLcetainLossDto.getOperatorCode() + "'," + 
                           "'" + prpLcetainLossDto.getApproverCode() + "'," + 
                           "'" + prpLcetainLossDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcetainLossDto.getClaimNo());
        dbManager.setString(2,prpLcetainLossDto.getRiskCode());
        dbManager.setString(3,prpLcetainLossDto.getRegistNo());
        dbManager.setInt(4,prpLcetainLossDto.getItemNo());
        dbManager.setString(5,prpLcetainLossDto.getLicenseNo());
        dbManager.setString(6,prpLcetainLossDto.getPolicyNo());
        dbManager.setDateTime(7,prpLcetainLossDto.getStartDate());
        dbManager.setString(8,prpLcetainLossDto.getStartHour());
        dbManager.setDateTime(9,prpLcetainLossDto.getEndDate());
        dbManager.setString(10,prpLcetainLossDto.getEndHour());
        dbManager.setString(11,prpLcetainLossDto.getCurrency());
        dbManager.setDouble(12,prpLcetainLossDto.getSumRest());
        dbManager.setDouble(13,prpLcetainLossDto.getSumManager());
        dbManager.setDouble(14,prpLcetainLossDto.getSumCertainLoss());
        dbManager.setDouble(15,prpLcetainLossDto.getSumVerifyLoss());
        dbManager.setString(16,prpLcetainLossDto.getLossDesc());
        dbManager.setString(17,prpLcetainLossDto.getIndemnityDuty());
        dbManager.setDouble(18,prpLcetainLossDto.getIndemnityDutyRate());
        dbManager.setString(19,prpLcetainLossDto.getRemark());
        dbManager.setString(20,prpLcetainLossDto.getOperatorCode());
        dbManager.setString(21,prpLcetainLossDto.getApproverCode());
        dbManager.setString(22,prpLcetainLossDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcetainLossBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcetainLoss (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " LicenseNo," + 
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
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcetainLossDto prpLcetainLossDto = (PrpLcetainLossDto)i.next();
            dbManager.setString(1,prpLcetainLossDto.getClaimNo());
            dbManager.setString(2,prpLcetainLossDto.getRiskCode());
            dbManager.setString(3,prpLcetainLossDto.getRegistNo());
            dbManager.setInt(4,prpLcetainLossDto.getItemNo());
            dbManager.setString(5,prpLcetainLossDto.getLicenseNo());
            dbManager.setString(6,prpLcetainLossDto.getPolicyNo());
            dbManager.setDateTime(7,prpLcetainLossDto.getStartDate());
            dbManager.setString(8,prpLcetainLossDto.getStartHour());
            dbManager.setDateTime(9,prpLcetainLossDto.getEndDate());
            dbManager.setString(10,prpLcetainLossDto.getEndHour());
            dbManager.setString(11,prpLcetainLossDto.getCurrency());
            dbManager.setDouble(12,prpLcetainLossDto.getSumRest());
            dbManager.setDouble(13,prpLcetainLossDto.getSumManager());
            dbManager.setDouble(14,prpLcetainLossDto.getSumCertainLoss());
            dbManager.setDouble(15,prpLcetainLossDto.getSumVerifyLoss());
            dbManager.setString(16,prpLcetainLossDto.getLossDesc());
            dbManager.setString(17,prpLcetainLossDto.getIndemnityDuty());
            dbManager.setDouble(18,prpLcetainLossDto.getIndemnityDutyRate());
            dbManager.setString(19,prpLcetainLossDto.getRemark());
            dbManager.setString(20,prpLcetainLossDto.getOperatorCode());
            dbManager.setString(21,prpLcetainLossDto.getApproverCode());
            dbManager.setString(22,prpLcetainLossDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcetainLossBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(String claimNo,int itemNo) throws Exception{
        String statement = " Delete From PrpLcetainLoss" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcetainLoss Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,itemNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcetainLossBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void update(PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        String statement = " Update PrpLcetainLoss Set RiskCode = ?," + 
                           " RegistNo = ?," + 
                           " LicenseNo = ?," + 
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
                           " ClaimNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcetainLoss Set " + 
                           " ClaimNo = '" + prpLcetainLossDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLcetainLossDto.getRiskCode() + "'," + 
                           " RegistNo = '" + prpLcetainLossDto.getRegistNo() + "'," + 
                           " ItemNo = " + prpLcetainLossDto.getItemNo() + "," + 
                           " LicenseNo = '" + prpLcetainLossDto.getLicenseNo() + "'," + 
                           " PolicyNo = '" + prpLcetainLossDto.getPolicyNo() + "'," + 
                           " StartDate = '" + prpLcetainLossDto.getStartDate() + "'," + 
                           " StartHour = '" + prpLcetainLossDto.getStartHour() + "'," + 
                           " EndDate = '" + prpLcetainLossDto.getEndDate() + "'," + 
                           " EndHour = '" + prpLcetainLossDto.getEndHour() + "'," + 
                           " Currency = '" + prpLcetainLossDto.getCurrency() + "'," + 
                           " SumRest = '" + prpLcetainLossDto.getSumRest() + "'," + 
                           " SumManager = '" + prpLcetainLossDto.getSumManager() + "'," + 
                           " SumCertainLoss = '" + prpLcetainLossDto.getSumCertainLoss() + "'," + 
                           " SumVerifyLoss = '" + prpLcetainLossDto.getSumVerifyLoss() + "'," + 
                           " LossDesc = '" + prpLcetainLossDto.getLossDesc() + "'," + 
                           " IndemnityDuty = '" + prpLcetainLossDto.getIndemnityDuty() + "'," + 
                           " IndemnityDutyRate = '" + prpLcetainLossDto.getIndemnityDutyRate() + "'," + 
                           " Remark = '" + prpLcetainLossDto.getRemark() + "'," + 
                           " OperatorCode = '" + prpLcetainLossDto.getOperatorCode() + "'," + 
                           " ApproverCode = '" + prpLcetainLossDto.getApproverCode() + "'," + 
                           " Flag = '" + prpLcetainLossDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLcetainLossDto.getClaimNo() + "' And " + 
                           " ItemNo = " + prpLcetainLossDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcetainLossDto.getRiskCode());
        dbManager.setString(2,prpLcetainLossDto.getRegistNo());
        dbManager.setString(3,prpLcetainLossDto.getLicenseNo());
        dbManager.setString(4,prpLcetainLossDto.getPolicyNo());
        dbManager.setDateTime(5,prpLcetainLossDto.getStartDate());
        dbManager.setString(6,prpLcetainLossDto.getStartHour());
        dbManager.setDateTime(7,prpLcetainLossDto.getEndDate());
        dbManager.setString(8,prpLcetainLossDto.getEndHour());
        dbManager.setString(9,prpLcetainLossDto.getCurrency());
        dbManager.setDouble(10,prpLcetainLossDto.getSumRest());
        dbManager.setDouble(11,prpLcetainLossDto.getSumManager());
        dbManager.setDouble(12,prpLcetainLossDto.getSumCertainLoss());
        dbManager.setDouble(13,prpLcetainLossDto.getSumVerifyLoss());
        dbManager.setString(14,prpLcetainLossDto.getLossDesc());
        dbManager.setString(15,prpLcetainLossDto.getIndemnityDuty());
        dbManager.setDouble(16,prpLcetainLossDto.getIndemnityDutyRate());
        dbManager.setString(17,prpLcetainLossDto.getRemark());
        dbManager.setString(18,prpLcetainLossDto.getOperatorCode());
        dbManager.setString(19,prpLcetainLossDto.getApproverCode());
        dbManager.setString(20,prpLcetainLossDto.getFlag());
        //设置条件字段;
        dbManager.setString(21,prpLcetainLossDto.getClaimNo());
        dbManager.setInt(22,prpLcetainLossDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcetainLossBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param itemNo 标的序号
     * @return PrpLcetainLossDto
     * @throws Exception
     */
    public PrpLcetainLossDto findByPrimaryKey(String claimNo,int itemNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " LicenseNo," + 
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
                           " Flag From PrpLcetainLoss";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " ItemNo = ?";
        PrpLcetainLossDto prpLcetainLossDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcetainLossDto = new PrpLcetainLossDto();
            prpLcetainLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcetainLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcetainLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcetainLossDto.setItemNo(dbManager.getInt(resultSet,4));
            prpLcetainLossDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLcetainLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcetainLossDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcetainLossDto.setStartHour(dbManager.getString(resultSet,8));
            prpLcetainLossDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLcetainLossDto.setEndHour(dbManager.getString(resultSet,10));
            prpLcetainLossDto.setCurrency(dbManager.getString(resultSet,11));
            prpLcetainLossDto.setSumRest(dbManager.getDouble(resultSet,12));
            prpLcetainLossDto.setSumManager(dbManager.getDouble(resultSet,13));
            prpLcetainLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,14));
            prpLcetainLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,15));
            prpLcetainLossDto.setLossDesc(dbManager.getString(resultSet,16));
            prpLcetainLossDto.setIndemnityDuty(dbManager.getString(resultSet,17));
            prpLcetainLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,18));
            prpLcetainLossDto.setRemark(dbManager.getString(resultSet,19));
            prpLcetainLossDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLcetainLossDto.setApproverCode(dbManager.getString(resultSet,21));
            prpLcetainLossDto.setFlag(dbManager.getString(resultSet,22));
            logger.info("DBPrpLcetainLossBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcetainLossBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcetainLossDto;
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
                           " ItemNo," + 
                           " LicenseNo," + 
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
                           " Flag From PrpLcetainLoss Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcetainLossDto prpLcetainLossDto = null;
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

            prpLcetainLossDto = new PrpLcetainLossDto();
            prpLcetainLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcetainLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcetainLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcetainLossDto.setItemNo(dbManager.getInt(resultSet,4));
            prpLcetainLossDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLcetainLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcetainLossDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcetainLossDto.setStartHour(dbManager.getString(resultSet,8));
            prpLcetainLossDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLcetainLossDto.setEndHour(dbManager.getString(resultSet,10));
            prpLcetainLossDto.setCurrency(dbManager.getString(resultSet,11));
            prpLcetainLossDto.setSumRest(dbManager.getDouble(resultSet,12));
            prpLcetainLossDto.setSumManager(dbManager.getDouble(resultSet,13));
            prpLcetainLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,14));
            prpLcetainLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,15));
            prpLcetainLossDto.setLossDesc(dbManager.getString(resultSet,16));
            prpLcetainLossDto.setIndemnityDuty(dbManager.getString(resultSet,17));
            prpLcetainLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,18));
            prpLcetainLossDto.setRemark(dbManager.getString(resultSet,19));
            prpLcetainLossDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLcetainLossDto.setApproverCode(dbManager.getString(resultSet,21));
            prpLcetainLossDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpLcetainLossDto);
        }
        resultSet.close();
        logger.info("DBPrpLcetainLossBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcetainLoss Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcetainLossBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcetainLoss Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcetainLossBase.getCount() success!");
        return count;
    }
}
