package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCitemKind-代赔保单投保险别表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLCitemKindBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLCitemKindBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLCitemKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void insert(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        String mainStatement = " Insert Into PrpLCitemKind (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ModeCode," + 
                           " ModeName," + 
                           " Currency," + 
                           " CalculateFlag," + 
                           " UnitAmount," + 
                           " Quantity," + 
                           " Value," + 
                           " Amount," + 
                           " Rate," + 
                           " ShortRateFlag," + 
                           " BasePremium," + 
                           " BenchMarkPremium," + 
                           " Discount," + 
                           " AdjustRate," + 
                           " Premium," + 
                           " DeductibleRate," + 
                           " Deductible," + 
                           " ShortRate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLCitemKindDto.getClaimNo() + "'," + 
                           "'" + prpLCitemKindDto.getRegistNo() + "'," + 
                           "'" + prpLCitemKindDto.getPolicyNo() + "'," + 
                           "'" + prpLCitemKindDto.getRiskCode() + "'," + 
                           "" + prpLCitemKindDto.getItemKindNo() + "," + 
                           "'" + prpLCitemKindDto.getKindCode() + "'," + 
                           "'" + prpLCitemKindDto.getKindName() + "'," + 
                           "'" + prpLCitemKindDto.getItemCode() + "'," + 
                           "'" + prpLCitemKindDto.getItemDetailName() + "'," + 
                           "'" + prpLCitemKindDto.getModeCode() + "'," + 
                           "'" + prpLCitemKindDto.getModeName() + "'," + 
                           "'" + prpLCitemKindDto.getCurrency() + "'," + 
                           "'" + prpLCitemKindDto.getCalculateFlag() + "'," + 
                           "'" + prpLCitemKindDto.getUnitAmount() + "'," + 
                           "'" + prpLCitemKindDto.getQuantity() + "'," + 
                           "'" + prpLCitemKindDto.getValue() + "'," + 
                           "'" + prpLCitemKindDto.getAmount() + "'," + 
                           "'" + prpLCitemKindDto.getRate() + "'," + 
                           "'" + prpLCitemKindDto.getShortRateFlag() + "'," + 
                           "'" + prpLCitemKindDto.getBasePremium() + "'," + 
                           "'" + prpLCitemKindDto.getBenchMarkPremium() + "'," + 
                           "'" + prpLCitemKindDto.getDiscount() + "'," + 
                           "'" + prpLCitemKindDto.getAdjustRate() + "'," + 
                           "'" + prpLCitemKindDto.getPremium() + "'," + 
                           "'" + prpLCitemKindDto.getDeductibleRate() + "'," + 
                           "'" + prpLCitemKindDto.getDeductible() + "'," + 
                           "'" + prpLCitemKindDto.getShortRate() + "'," + 
                           "'" + prpLCitemKindDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLCitemKindDto.getClaimNo());
        dbManager.setString(2,prpLCitemKindDto.getRegistNo());
        dbManager.setString(3,prpLCitemKindDto.getPolicyNo());
        dbManager.setString(4,prpLCitemKindDto.getRiskCode());
        dbManager.setInt(5,prpLCitemKindDto.getItemKindNo());
        dbManager.setString(6,prpLCitemKindDto.getKindCode());
        dbManager.setString(7,prpLCitemKindDto.getKindName());
        dbManager.setString(8,prpLCitemKindDto.getItemCode());
        dbManager.setString(9,prpLCitemKindDto.getItemDetailName());
        dbManager.setString(10,prpLCitemKindDto.getModeCode());
        dbManager.setString(11,prpLCitemKindDto.getModeName());
        dbManager.setString(12,prpLCitemKindDto.getCurrency());
        dbManager.setString(13,prpLCitemKindDto.getCalculateFlag());
        dbManager.setDouble(14,prpLCitemKindDto.getUnitAmount());
        dbManager.setDouble(15,prpLCitemKindDto.getQuantity());
        dbManager.setDouble(16,prpLCitemKindDto.getValue());
        dbManager.setDouble(17,prpLCitemKindDto.getAmount());
        dbManager.setDouble(18,prpLCitemKindDto.getRate());
        dbManager.setString(19,prpLCitemKindDto.getShortRateFlag());
        dbManager.setDouble(20,prpLCitemKindDto.getBasePremium());
        dbManager.setDouble(21,prpLCitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(22,prpLCitemKindDto.getDiscount());
        dbManager.setDouble(23,prpLCitemKindDto.getAdjustRate());
        dbManager.setDouble(24,prpLCitemKindDto.getPremium());
        dbManager.setDouble(25,prpLCitemKindDto.getDeductibleRate());
        dbManager.setDouble(26,prpLCitemKindDto.getDeductible());
        dbManager.setDouble(27,prpLCitemKindDto.getShortRate());
        dbManager.setString(28,prpLCitemKindDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCitemKindBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLCitemKind (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ModeCode," + 
                           " ModeName," + 
                           " Currency," + 
                           " CalculateFlag," + 
                           " UnitAmount," + 
                           " Quantity," + 
                           " Value," + 
                           " Amount," + 
                           " Rate," + 
                           " ShortRateFlag," + 
                           " BasePremium," + 
                           " BenchMarkPremium," + 
                           " Discount," + 
                           " AdjustRate," + 
                           " Premium," + 
                           " DeductibleRate," + 
                           " Deductible," + 
                           " ShortRate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLCitemKindDto prpLCitemKindDto = (PrpLCitemKindDto)i.next();
            dbManager.setString(1,prpLCitemKindDto.getClaimNo());
            dbManager.setString(2,prpLCitemKindDto.getRegistNo());
            dbManager.setString(3,prpLCitemKindDto.getPolicyNo());
            dbManager.setString(4,prpLCitemKindDto.getRiskCode());
            dbManager.setInt(5,prpLCitemKindDto.getItemKindNo());
            dbManager.setString(6,prpLCitemKindDto.getKindCode());
            dbManager.setString(7,prpLCitemKindDto.getKindName());
            dbManager.setString(8,prpLCitemKindDto.getItemCode());
            dbManager.setString(9,prpLCitemKindDto.getItemDetailName());
            dbManager.setString(10,prpLCitemKindDto.getModeCode());
            dbManager.setString(11,prpLCitemKindDto.getModeName());
            dbManager.setString(12,prpLCitemKindDto.getCurrency());
            dbManager.setString(13,prpLCitemKindDto.getCalculateFlag());
            dbManager.setDouble(14,prpLCitemKindDto.getUnitAmount());
            dbManager.setDouble(15,prpLCitemKindDto.getQuantity());
            dbManager.setDouble(16,prpLCitemKindDto.getValue());
            dbManager.setDouble(17,prpLCitemKindDto.getAmount());
            dbManager.setDouble(18,prpLCitemKindDto.getRate());
            dbManager.setString(19,prpLCitemKindDto.getShortRateFlag());
            dbManager.setDouble(20,prpLCitemKindDto.getBasePremium());
            dbManager.setDouble(21,prpLCitemKindDto.getBenchMarkPremium());
            dbManager.setDouble(22,prpLCitemKindDto.getDiscount());
            dbManager.setDouble(23,prpLCitemKindDto.getAdjustRate());
            dbManager.setDouble(24,prpLCitemKindDto.getPremium());
            dbManager.setDouble(25,prpLCitemKindDto.getDeductibleRate());
            dbManager.setDouble(26,prpLCitemKindDto.getDeductible());
            dbManager.setDouble(27,prpLCitemKindDto.getShortRate());
            dbManager.setString(28,prpLCitemKindDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLCitemKindBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo,int itemKindNo) throws Exception{
        String statement = " Delete From PrpLCitemKind" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLCitemKind Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "' And " + 
                           " ItemKindNo = " + itemKindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,itemKindNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLCitemKindBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void update(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        String statement = " Update PrpLCitemKind Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " KindCode = ?," + 
                           " KindName = ?," + 
                           " ItemCode = ?," + 
                           " ItemDetailName = ?," + 
                           " ModeCode = ?," + 
                           " ModeName = ?," + 
                           " Currency = ?," + 
                           " CalculateFlag = ?," + 
                           " UnitAmount = ?," + 
                           " Quantity = ?," + 
                           " Value = ?," + 
                           " Amount = ?," + 
                           " Rate = ?," + 
                           " ShortRateFlag = ?," + 
                           " BasePremium = ?," + 
                           " BenchMarkPremium = ?," + 
                           " Discount = ?," + 
                           " AdjustRate = ?," + 
                           " Premium = ?," + 
                           " DeductibleRate = ?," + 
                           " Deductible = ?," + 
                           " ShortRate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLCitemKind Set " + 
                           " ClaimNo = '" + prpLCitemKindDto.getClaimNo() + "'," + 
                           " RegistNo = '" + prpLCitemKindDto.getRegistNo() + "'," + 
                           " PolicyNo = '" + prpLCitemKindDto.getPolicyNo() + "'," + 
                           " RiskCode = '" + prpLCitemKindDto.getRiskCode() + "'," + 
                           " ItemKindNo = " + prpLCitemKindDto.getItemKindNo() + "," + 
                           " KindCode = '" + prpLCitemKindDto.getKindCode() + "'," + 
                           " KindName = '" + prpLCitemKindDto.getKindName() + "'," + 
                           " ItemCode = '" + prpLCitemKindDto.getItemCode() + "'," + 
                           " ItemDetailName = '" + prpLCitemKindDto.getItemDetailName() + "'," + 
                           " ModeCode = '" + prpLCitemKindDto.getModeCode() + "'," + 
                           " ModeName = '" + prpLCitemKindDto.getModeName() + "'," + 
                           " Currency = '" + prpLCitemKindDto.getCurrency() + "'," + 
                           " CalculateFlag = '" + prpLCitemKindDto.getCalculateFlag() + "'," + 
                           " UnitAmount = '" + prpLCitemKindDto.getUnitAmount() + "'," + 
                           " Quantity = '" + prpLCitemKindDto.getQuantity() + "'," + 
                           " Value = '" + prpLCitemKindDto.getValue() + "'," + 
                           " Amount = '" + prpLCitemKindDto.getAmount() + "'," + 
                           " Rate = '" + prpLCitemKindDto.getRate() + "'," + 
                           " ShortRateFlag = '" + prpLCitemKindDto.getShortRateFlag() + "'," + 
                           " BasePremium = '" + prpLCitemKindDto.getBasePremium() + "'," + 
                           " BenchMarkPremium = '" + prpLCitemKindDto.getBenchMarkPremium() + "'," + 
                           " Discount = '" + prpLCitemKindDto.getDiscount() + "'," + 
                           " AdjustRate = '" + prpLCitemKindDto.getAdjustRate() + "'," + 
                           " Premium = '" + prpLCitemKindDto.getPremium() + "'," + 
                           " DeductibleRate = '" + prpLCitemKindDto.getDeductibleRate() + "'," + 
                           " Deductible = '" + prpLCitemKindDto.getDeductible() + "'," + 
                           " ShortRate = '" + prpLCitemKindDto.getShortRate() + "'," + 
                           " Flag = '" + prpLCitemKindDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLCitemKindDto.getRegistNo() + "' And " + 
                           " PolicyNo = '" + prpLCitemKindDto.getPolicyNo() + "' And " + 
                           " ItemKindNo = " + prpLCitemKindDto.getItemKindNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLCitemKindDto.getClaimNo());
        dbManager.setString(2,prpLCitemKindDto.getRiskCode());
        dbManager.setString(3,prpLCitemKindDto.getKindCode());
        dbManager.setString(4,prpLCitemKindDto.getKindName());
        dbManager.setString(5,prpLCitemKindDto.getItemCode());
        dbManager.setString(6,prpLCitemKindDto.getItemDetailName());
        dbManager.setString(7,prpLCitemKindDto.getModeCode());
        dbManager.setString(8,prpLCitemKindDto.getModeName());
        dbManager.setString(9,prpLCitemKindDto.getCurrency());
        dbManager.setString(10,prpLCitemKindDto.getCalculateFlag());
        dbManager.setDouble(11,prpLCitemKindDto.getUnitAmount());
        dbManager.setDouble(12,prpLCitemKindDto.getQuantity());
        dbManager.setDouble(13,prpLCitemKindDto.getValue());
        dbManager.setDouble(14,prpLCitemKindDto.getAmount());
        dbManager.setDouble(15,prpLCitemKindDto.getRate());
        dbManager.setString(16,prpLCitemKindDto.getShortRateFlag());
        dbManager.setDouble(17,prpLCitemKindDto.getBasePremium());
        dbManager.setDouble(18,prpLCitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(19,prpLCitemKindDto.getDiscount());
        dbManager.setDouble(20,prpLCitemKindDto.getAdjustRate());
        dbManager.setDouble(21,prpLCitemKindDto.getPremium());
        dbManager.setDouble(22,prpLCitemKindDto.getDeductibleRate());
        dbManager.setDouble(23,prpLCitemKindDto.getDeductible());
        dbManager.setDouble(24,prpLCitemKindDto.getShortRate());
        dbManager.setString(25,prpLCitemKindDto.getFlag());
        //设置条件字段;
        dbManager.setString(26,prpLCitemKindDto.getRegistNo());
        dbManager.setString(27,prpLCitemKindDto.getPolicyNo());
        dbManager.setInt(28,prpLCitemKindDto.getItemKindNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCitemKindBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @return PrpLCitemKindDto
     * @throws Exception
     */
    public PrpLCitemKindDto findByPrimaryKey(String registNo,String policyNo,int itemKindNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ModeCode," + 
                           " ModeName," + 
                           " Currency," + 
                           " CalculateFlag," + 
                           " UnitAmount," + 
                           " Quantity," + 
                           " Value," + 
                           " Amount," + 
                           " Rate," + 
                           " ShortRateFlag," + 
                           " BasePremium," + 
                           " BenchMarkPremium," + 
                           " Discount," + 
                           " AdjustRate," + 
                           " Premium," + 
                           " DeductibleRate," + 
                           " Deductible," + 
                           " ShortRate," + 
                           " Flag From PrpLCitemKind";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        PrpLCitemKindDto prpLCitemKindDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "' And " + 
                           " ItemKindNo = " + itemKindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,itemKindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLCitemKindDto = new PrpLCitemKindDto();
            prpLCitemKindDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCitemKindDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCitemKindDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCitemKindDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLCitemKindDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLCitemKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpLCitemKindDto.setKindName(dbManager.getString(resultSet,7));
            prpLCitemKindDto.setItemCode(dbManager.getString(resultSet,8));
            prpLCitemKindDto.setItemDetailName(dbManager.getString(resultSet,9));
            prpLCitemKindDto.setModeCode(dbManager.getString(resultSet,10));
            prpLCitemKindDto.setModeName(dbManager.getString(resultSet,11));
            prpLCitemKindDto.setCurrency(dbManager.getString(resultSet,12));
            prpLCitemKindDto.setCalculateFlag(dbManager.getString(resultSet,13));
            prpLCitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,14));
            prpLCitemKindDto.setQuantity(dbManager.getDouble(resultSet,15));
            prpLCitemKindDto.setValue(dbManager.getDouble(resultSet,16));
            prpLCitemKindDto.setAmount(dbManager.getDouble(resultSet,17));
            prpLCitemKindDto.setRate(dbManager.getDouble(resultSet,18));
            prpLCitemKindDto.setShortRateFlag(dbManager.getString(resultSet,19));
            prpLCitemKindDto.setBasePremium(dbManager.getDouble(resultSet,20));
            prpLCitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,21));
            prpLCitemKindDto.setDiscount(dbManager.getDouble(resultSet,22));
            prpLCitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,23));
            prpLCitemKindDto.setPremium(dbManager.getDouble(resultSet,24));
            prpLCitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,25));
            prpLCitemKindDto.setDeductible(dbManager.getDouble(resultSet,26));
            prpLCitemKindDto.setShortRate(dbManager.getDouble(resultSet,27));
            prpLCitemKindDto.setFlag(dbManager.getString(resultSet,28));
            logger.info("DBPrpLCitemKindBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLCitemKindBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLCitemKindDto;
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
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ModeCode," + 
                           " ModeName," + 
                           " Currency," + 
                           " CalculateFlag," + 
                           " UnitAmount," + 
                           " Quantity," + 
                           " Value," + 
                           " Amount," + 
                           " Rate," + 
                           " ShortRateFlag," + 
                           " BasePremium," + 
                           " BenchMarkPremium," + 
                           " Discount," + 
                           " AdjustRate," + 
                           " Premium," + 
                           " DeductibleRate," + 
                           " Deductible," + 
                           " ShortRate," + 
                           " Flag From PrpLCitemKind Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLCitemKindDto prpLCitemKindDto = null;
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

            prpLCitemKindDto = new PrpLCitemKindDto();
            prpLCitemKindDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCitemKindDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCitemKindDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCitemKindDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLCitemKindDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLCitemKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpLCitemKindDto.setKindName(dbManager.getString(resultSet,7));
            prpLCitemKindDto.setItemCode(dbManager.getString(resultSet,8));
            prpLCitemKindDto.setItemDetailName(dbManager.getString(resultSet,9));
            prpLCitemKindDto.setModeCode(dbManager.getString(resultSet,10));
            prpLCitemKindDto.setModeName(dbManager.getString(resultSet,11));
            prpLCitemKindDto.setCurrency(dbManager.getString(resultSet,12));
            prpLCitemKindDto.setCalculateFlag(dbManager.getString(resultSet,13));
            prpLCitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,14));
            prpLCitemKindDto.setQuantity(dbManager.getDouble(resultSet,15));
            prpLCitemKindDto.setValue(dbManager.getDouble(resultSet,16));
            prpLCitemKindDto.setAmount(dbManager.getDouble(resultSet,17));
            prpLCitemKindDto.setRate(dbManager.getDouble(resultSet,18));
            prpLCitemKindDto.setShortRateFlag(dbManager.getString(resultSet,19));
            prpLCitemKindDto.setBasePremium(dbManager.getDouble(resultSet,20));
            prpLCitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,21));
            prpLCitemKindDto.setDiscount(dbManager.getDouble(resultSet,22));
            prpLCitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,23));
            prpLCitemKindDto.setPremium(dbManager.getDouble(resultSet,24));
            prpLCitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,25));
            prpLCitemKindDto.setDeductible(dbManager.getDouble(resultSet,26));
            prpLCitemKindDto.setShortRate(dbManager.getDouble(resultSet,27));
            prpLCitemKindDto.setFlag(dbManager.getString(resultSet,28));
            collection.add(prpLCitemKindDto);
        }
        resultSet.close();
        logger.info("DBPrpLCitemKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpLCitemKind Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLCitemKindBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLCitemKind Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLCitemKindBase.getCount() success!");
        return count;
    }
}
