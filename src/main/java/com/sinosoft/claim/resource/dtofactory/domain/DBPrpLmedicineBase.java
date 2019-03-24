package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmedicineDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmedicine-雇员医药费清单表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLmedicineBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLmedicineBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLmedicineBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLmedicineDto prpLmedicineDto
     * @throws Exception
     */
    public void insert(PrpLmedicineDto prpLmedicineDto) throws Exception{
        String mainStatement = " Insert Into PrpLmedicine (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " IndemnityLimit," + 
                           " ReceiptCount," + 
                           " ReceiptAmt," + 
                           " ReceiptDate," + 
                           " MissWorkDays," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLmedicineDto.getClaimNo() + "'," + 
                           "'" + prpLmedicineDto.getRiskCode() + "'," + 
                           "'" + prpLmedicineDto.getPolicyNo() + "'," + 
                           "" + prpLmedicineDto.getSerialNo() + "," + 
                           "" + prpLmedicineDto.getItemKindNo() + "," + 
                           "" + prpLmedicineDto.getFamilyNo() + "," + 
                           "'" + prpLmedicineDto.getFamilyName() + "'," + 
                           "'" + prpLmedicineDto.getKindCode() + "'," + 
                           "'" + prpLmedicineDto.getItemCode() + "'," + 
                           "'" + prpLmedicineDto.getEmployeeCode() + "'," + 
                           "'" + prpLmedicineDto.getEmployeeName() + "'," + 
                           "'" + prpLmedicineDto.getFeeTypeCode() + "'," + 
                           "'" + prpLmedicineDto.getFeeTypeName() + "'," + 
                           "'" + prpLmedicineDto.getCurrency() + "'," + 
                           "'" + prpLmedicineDto.getIndemnityLimit() + "'," + 
                           "" + prpLmedicineDto.getReceiptCount() + "," + 
                           "'" + prpLmedicineDto.getReceiptAmt() + "'," + 
                           "'" + prpLmedicineDto.getReceiptDate() + "'," + 
                           "" + prpLmedicineDto.getMissWorkDays() + "," + 
                           "'" + prpLmedicineDto.getSumLoss() + "'," + 
                           "'" + prpLmedicineDto.getSumReject() + "'," + 
                           "'" + prpLmedicineDto.getRejectReason() + "'," + 
                           "'" + prpLmedicineDto.getLossRate() + "'," + 
                           "'" + prpLmedicineDto.getSumDefLoss() + "'," + 
                           "'" + prpLmedicineDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLmedicineDto.getClaimNo());
        dbManager.setString(2,prpLmedicineDto.getRiskCode());
        dbManager.setString(3,prpLmedicineDto.getPolicyNo());
        dbManager.setInt(4,prpLmedicineDto.getSerialNo());
        dbManager.setInt(5,prpLmedicineDto.getItemKindNo());
        dbManager.setInt(6,prpLmedicineDto.getFamilyNo());
        dbManager.setString(7,prpLmedicineDto.getFamilyName());
        dbManager.setString(8,prpLmedicineDto.getKindCode());
        dbManager.setString(9,prpLmedicineDto.getItemCode());
        dbManager.setString(10,prpLmedicineDto.getEmployeeCode());
        dbManager.setString(11,prpLmedicineDto.getEmployeeName());
        dbManager.setString(12,prpLmedicineDto.getFeeTypeCode());
        dbManager.setString(13,prpLmedicineDto.getFeeTypeName());
        dbManager.setString(14,prpLmedicineDto.getCurrency());
        dbManager.setDouble(15,prpLmedicineDto.getIndemnityLimit());
        dbManager.setInt(16,prpLmedicineDto.getReceiptCount());
        dbManager.setDouble(17,prpLmedicineDto.getReceiptAmt());
        dbManager.setDateTime(18,prpLmedicineDto.getReceiptDate());
        dbManager.setInt(19,prpLmedicineDto.getMissWorkDays());
        dbManager.setDouble(20,prpLmedicineDto.getSumLoss());
        dbManager.setDouble(21,prpLmedicineDto.getSumReject());
        dbManager.setString(22,prpLmedicineDto.getRejectReason());
        dbManager.setDouble(23,prpLmedicineDto.getLossRate());
        dbManager.setDouble(24,prpLmedicineDto.getSumDefLoss());
        dbManager.setString(25,prpLmedicineDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmedicineBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLmedicine (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " IndemnityLimit," + 
                           " ReceiptCount," + 
                           " ReceiptAmt," + 
                           " ReceiptDate," + 
                           " MissWorkDays," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLmedicineDto prpLmedicineDto = (PrpLmedicineDto)i.next();
            dbManager.setString(1,prpLmedicineDto.getClaimNo());
            dbManager.setString(2,prpLmedicineDto.getRiskCode());
            dbManager.setString(3,prpLmedicineDto.getPolicyNo());
            dbManager.setInt(4,prpLmedicineDto.getSerialNo());
            dbManager.setInt(5,prpLmedicineDto.getItemKindNo());
            dbManager.setInt(6,prpLmedicineDto.getFamilyNo());
            dbManager.setString(7,prpLmedicineDto.getFamilyName());
            dbManager.setString(8,prpLmedicineDto.getKindCode());
            dbManager.setString(9,prpLmedicineDto.getItemCode());
            dbManager.setString(10,prpLmedicineDto.getEmployeeCode());
            dbManager.setString(11,prpLmedicineDto.getEmployeeName());
            dbManager.setString(12,prpLmedicineDto.getFeeTypeCode());
            dbManager.setString(13,prpLmedicineDto.getFeeTypeName());
            dbManager.setString(14,prpLmedicineDto.getCurrency());
            dbManager.setDouble(15,prpLmedicineDto.getIndemnityLimit());
            dbManager.setInt(16,prpLmedicineDto.getReceiptCount());
            dbManager.setDouble(17,prpLmedicineDto.getReceiptAmt());
            dbManager.setDateTime(18,prpLmedicineDto.getReceiptDate());
            dbManager.setInt(19,prpLmedicineDto.getMissWorkDays());
            dbManager.setDouble(20,prpLmedicineDto.getSumLoss());
            dbManager.setDouble(21,prpLmedicineDto.getSumReject());
            dbManager.setString(22,prpLmedicineDto.getRejectReason());
            dbManager.setDouble(23,prpLmedicineDto.getLossRate());
            dbManager.setDouble(24,prpLmedicineDto.getSumDefLoss());
            dbManager.setString(25,prpLmedicineDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLmedicineBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLmedicine" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLmedicine Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLmedicineBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLmedicineDto prpLmedicineDto
     * @throws Exception
     */
    public void update(PrpLmedicineDto prpLmedicineDto) throws Exception{
        String statement = " Update PrpLmedicine Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " FamilyNo = ?," + 
                           " FamilyName = ?," + 
                           " KindCode = ?," + 
                           " ItemCode = ?," + 
                           " EmployeeCode = ?," + 
                           " EmployeeName = ?," + 
                           " FeeTypeCode = ?," + 
                           " FeeTypeName = ?," + 
                           " Currency = ?," + 
                           " IndemnityLimit = ?," + 
                           " ReceiptCount = ?," + 
                           " ReceiptAmt = ?," + 
                           " ReceiptDate = ?," + 
                           " MissWorkDays = ?," + 
                           " SumLoss = ?," + 
                           " SumReject = ?," + 
                           " RejectReason = ?," + 
                           " LossRate = ?," + 
                           " SumDefLoss = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLmedicine Set " + 
                           " ClaimNo = '" + prpLmedicineDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLmedicineDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLmedicineDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLmedicineDto.getSerialNo() + "," + 
                           " ItemKindNo = " + prpLmedicineDto.getItemKindNo() + "," + 
                           " FamilyNo = " + prpLmedicineDto.getFamilyNo() + "," + 
                           " FamilyName = '" + prpLmedicineDto.getFamilyName() + "'," + 
                           " KindCode = '" + prpLmedicineDto.getKindCode() + "'," + 
                           " ItemCode = '" + prpLmedicineDto.getItemCode() + "'," + 
                           " EmployeeCode = '" + prpLmedicineDto.getEmployeeCode() + "'," + 
                           " EmployeeName = '" + prpLmedicineDto.getEmployeeName() + "'," + 
                           " FeeTypeCode = '" + prpLmedicineDto.getFeeTypeCode() + "'," + 
                           " FeeTypeName = '" + prpLmedicineDto.getFeeTypeName() + "'," + 
                           " Currency = '" + prpLmedicineDto.getCurrency() + "'," + 
                           " IndemnityLimit = '" + prpLmedicineDto.getIndemnityLimit() + "'," + 
                           " ReceiptCount = " + prpLmedicineDto.getReceiptCount() + "," + 
                           " ReceiptAmt = '" + prpLmedicineDto.getReceiptAmt() + "'," + 
                           " ReceiptDate = '" + prpLmedicineDto.getReceiptDate() + "'," + 
                           " MissWorkDays = " + prpLmedicineDto.getMissWorkDays() + "," + 
                           " SumLoss = '" + prpLmedicineDto.getSumLoss() + "'," + 
                           " SumReject = '" + prpLmedicineDto.getSumReject() + "'," + 
                           " RejectReason = '" + prpLmedicineDto.getRejectReason() + "'," + 
                           " LossRate = '" + prpLmedicineDto.getLossRate() + "'," + 
                           " SumDefLoss = '" + prpLmedicineDto.getSumDefLoss() + "'," + 
                           " Flag = '" + prpLmedicineDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLmedicineDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLmedicineDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLmedicineDto.getRiskCode());
        dbManager.setString(2,prpLmedicineDto.getPolicyNo());
        dbManager.setInt(3,prpLmedicineDto.getItemKindNo());
        dbManager.setInt(4,prpLmedicineDto.getFamilyNo());
        dbManager.setString(5,prpLmedicineDto.getFamilyName());
        dbManager.setString(6,prpLmedicineDto.getKindCode());
        dbManager.setString(7,prpLmedicineDto.getItemCode());
        dbManager.setString(8,prpLmedicineDto.getEmployeeCode());
        dbManager.setString(9,prpLmedicineDto.getEmployeeName());
        dbManager.setString(10,prpLmedicineDto.getFeeTypeCode());
        dbManager.setString(11,prpLmedicineDto.getFeeTypeName());
        dbManager.setString(12,prpLmedicineDto.getCurrency());
        dbManager.setDouble(13,prpLmedicineDto.getIndemnityLimit());
        dbManager.setInt(14,prpLmedicineDto.getReceiptCount());
        dbManager.setDouble(15,prpLmedicineDto.getReceiptAmt());
        dbManager.setDateTime(16,prpLmedicineDto.getReceiptDate());
        dbManager.setInt(17,prpLmedicineDto.getMissWorkDays());
        dbManager.setDouble(18,prpLmedicineDto.getSumLoss());
        dbManager.setDouble(19,prpLmedicineDto.getSumReject());
        dbManager.setString(20,prpLmedicineDto.getRejectReason());
        dbManager.setDouble(21,prpLmedicineDto.getLossRate());
        dbManager.setDouble(22,prpLmedicineDto.getSumDefLoss());
        dbManager.setString(23,prpLmedicineDto.getFlag());
        //设置条件字段;
        dbManager.setString(24,prpLmedicineDto.getClaimNo());
        dbManager.setInt(25,prpLmedicineDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmedicineBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @return PrpLmedicineDto
     * @throws Exception
     */
    public PrpLmedicineDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " IndemnityLimit," + 
                           " ReceiptCount," + 
                           " ReceiptAmt," + 
                           " ReceiptDate," + 
                           " MissWorkDays," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Flag From PrpLmedicine";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLmedicineDto prpLmedicineDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLmedicineDto = new PrpLmedicineDto();
            prpLmedicineDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLmedicineDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLmedicineDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLmedicineDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLmedicineDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLmedicineDto.setFamilyNo(dbManager.getInt(resultSet,6));
            prpLmedicineDto.setFamilyName(dbManager.getString(resultSet,7));
            prpLmedicineDto.setKindCode(dbManager.getString(resultSet,8));
            prpLmedicineDto.setItemCode(dbManager.getString(resultSet,9));
            prpLmedicineDto.setEmployeeCode(dbManager.getString(resultSet,10));
            prpLmedicineDto.setEmployeeName(dbManager.getString(resultSet,11));
            prpLmedicineDto.setFeeTypeCode(dbManager.getString(resultSet,12));
            prpLmedicineDto.setFeeTypeName(dbManager.getString(resultSet,13));
            prpLmedicineDto.setCurrency(dbManager.getString(resultSet,14));
            prpLmedicineDto.setIndemnityLimit(dbManager.getDouble(resultSet,15));
            prpLmedicineDto.setReceiptCount(dbManager.getInt(resultSet,16));
            prpLmedicineDto.setReceiptAmt(dbManager.getDouble(resultSet,17));
            prpLmedicineDto.setReceiptDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLmedicineDto.setMissWorkDays(dbManager.getInt(resultSet,19));
            prpLmedicineDto.setSumLoss(dbManager.getDouble(resultSet,20));
            prpLmedicineDto.setSumReject(dbManager.getDouble(resultSet,21));
            prpLmedicineDto.setRejectReason(dbManager.getString(resultSet,22));
            prpLmedicineDto.setLossRate(dbManager.getDouble(resultSet,23));
            prpLmedicineDto.setSumDefLoss(dbManager.getDouble(resultSet,24));
            prpLmedicineDto.setFlag(dbManager.getString(resultSet,25));
            logger.info("DBPrpLmedicineBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLmedicineBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLmedicineDto;
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
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " IndemnityLimit," + 
                           " ReceiptCount," + 
                           " ReceiptAmt," + 
                           " ReceiptDate," + 
                           " MissWorkDays," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Flag From PrpLmedicine Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLmedicineDto prpLmedicineDto = null;
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

            prpLmedicineDto = new PrpLmedicineDto();
            prpLmedicineDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLmedicineDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLmedicineDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLmedicineDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLmedicineDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLmedicineDto.setFamilyNo(dbManager.getInt(resultSet,6));
            prpLmedicineDto.setFamilyName(dbManager.getString(resultSet,7));
            prpLmedicineDto.setKindCode(dbManager.getString(resultSet,8));
            prpLmedicineDto.setItemCode(dbManager.getString(resultSet,9));
            prpLmedicineDto.setEmployeeCode(dbManager.getString(resultSet,10));
            prpLmedicineDto.setEmployeeName(dbManager.getString(resultSet,11));
            prpLmedicineDto.setFeeTypeCode(dbManager.getString(resultSet,12));
            prpLmedicineDto.setFeeTypeName(dbManager.getString(resultSet,13));
            prpLmedicineDto.setCurrency(dbManager.getString(resultSet,14));
            prpLmedicineDto.setIndemnityLimit(dbManager.getDouble(resultSet,15));
            prpLmedicineDto.setReceiptCount(dbManager.getInt(resultSet,16));
            prpLmedicineDto.setReceiptAmt(dbManager.getDouble(resultSet,17));
            prpLmedicineDto.setReceiptDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLmedicineDto.setMissWorkDays(dbManager.getInt(resultSet,19));
            prpLmedicineDto.setSumLoss(dbManager.getDouble(resultSet,20));
            prpLmedicineDto.setSumReject(dbManager.getDouble(resultSet,21));
            prpLmedicineDto.setRejectReason(dbManager.getString(resultSet,22));
            prpLmedicineDto.setLossRate(dbManager.getDouble(resultSet,23));
            prpLmedicineDto.setSumDefLoss(dbManager.getDouble(resultSet,24));
            prpLmedicineDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpLmedicineDto);
        }
        resultSet.close();
        logger.info("DBPrpLmedicineBase.findByConditions() success!");
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
        String statement = "Delete From PrpLmedicine Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLmedicineBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLmedicine Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLmedicineBase.getCount() success!");
        return count;
    }
}
