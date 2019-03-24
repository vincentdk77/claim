package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCguarantyDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcguaranty担保信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCguarantyBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCguarantyBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCguarantyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCguarantyDto prpCguarantyDto
     * @throws Exception
     */
    public void insert(PrpCguarantyDto prpCguarantyDto) throws Exception{
        String statement = " Insert Into PrpCguaranty(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " GuaranteeType," + 
                           " InpawnType," + 
                           " MortgageNo," + 
                           " ObligeeType," + 
                           " WarrantorName," + 
                           " GuarantyObligee," + 
                           " GuarantyName," + 
                           " Model," + 
                           " Unit," + 
                           " Quantity," + 
                           " Possessor," + 
                           " GuarantyAddress," + 
                           " GuarantyKeeper," + 
                           " PropCertifNo," + 
                           " GuarantyAssessment," + 
                           " OtherRating," + 
                           " InpawnQuality," + 
                           " OriginalValue," + 
                           " NetValue," + 
                           " Valuator," + 
                           " RightValidPeriod," + 
                           " EncashDate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCguarantyDto.getPolicyNo());
        dbManager.setInt(2,prpCguarantyDto.getSerialNo());
        dbManager.setString(3,prpCguarantyDto.getRiskCode());
        dbManager.setString(4,prpCguarantyDto.getGuaranteeType());
        dbManager.setString(5,prpCguarantyDto.getInpawnType());
        dbManager.setString(6,prpCguarantyDto.getMortgageNo());
        dbManager.setString(7,prpCguarantyDto.getObligeeType());
        dbManager.setString(8,prpCguarantyDto.getWarrantorName());
        dbManager.setString(9,prpCguarantyDto.getGuarantyObligee());
        dbManager.setString(10,prpCguarantyDto.getGuarantyName());
        dbManager.setString(11,prpCguarantyDto.getModel());
        dbManager.setString(12,prpCguarantyDto.getUnit());
        dbManager.setInt(13,prpCguarantyDto.getQuantity());
        dbManager.setString(14,prpCguarantyDto.getPossessor());
        dbManager.setString(15,prpCguarantyDto.getGuarantyAddress());
        dbManager.setString(16,prpCguarantyDto.getGuarantyKeeper());
        dbManager.setString(17,prpCguarantyDto.getPropCertifNo());
        dbManager.setDouble(18,prpCguarantyDto.getGuarantyAssessment());
        dbManager.setDouble(19,prpCguarantyDto.getOtherRating());
        dbManager.setString(20,prpCguarantyDto.getInpawnQuality());
        dbManager.setDouble(21,prpCguarantyDto.getOriginalValue());
        dbManager.setDouble(22,prpCguarantyDto.getNetValue());
        dbManager.setString(23,prpCguarantyDto.getValuator());
        dbManager.setDateTime(24,prpCguarantyDto.getRightValidPeriod());
        dbManager.setDateTime(25,prpCguarantyDto.getEncashDate());
        dbManager.setString(26,prpCguarantyDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCguarantyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCguarantyDto prpCguarantyDto = (PrpCguarantyDto)i.next();
            insert(prpCguarantyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCguaranty Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCguarantyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCguarantyDto prpCguarantyDto
     * @throws Exception
     */
    public void update(PrpCguarantyDto prpCguarantyDto) throws Exception{
        String statement = " Update PrpCguaranty Set RiskCode = ?," + 
                           " GuaranteeType = ?," + 
                           " InpawnType = ?," + 
                           " MortgageNo = ?," + 
                           " ObligeeType = ?," + 
                           " WarrantorName = ?," + 
                           " GuarantyObligee = ?," + 
                           " GuarantyName = ?," + 
                           " Model = ?," + 
                           " Unit = ?," + 
                           " Quantity = ?," + 
                           " Possessor = ?," + 
                           " GuarantyAddress = ?," + 
                           " GuarantyKeeper = ?," + 
                           " PropCertifNo = ?," + 
                           " GuarantyAssessment = ?," + 
                           " OtherRating = ?," + 
                           " InpawnQuality = ?," + 
                           " OriginalValue = ?," + 
                           " NetValue = ?," + 
                           " Valuator = ?," + 
                           " RightValidPeriod = ?," + 
                           " EncashDate = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCguarantyDto.getRiskCode());
        dbManager.setString(2,prpCguarantyDto.getGuaranteeType());
        dbManager.setString(3,prpCguarantyDto.getInpawnType());
        dbManager.setString(4,prpCguarantyDto.getMortgageNo());
        dbManager.setString(5,prpCguarantyDto.getObligeeType());
        dbManager.setString(6,prpCguarantyDto.getWarrantorName());
        dbManager.setString(7,prpCguarantyDto.getGuarantyObligee());
        dbManager.setString(8,prpCguarantyDto.getGuarantyName());
        dbManager.setString(9,prpCguarantyDto.getModel());
        dbManager.setString(10,prpCguarantyDto.getUnit());
        dbManager.setInt(11,prpCguarantyDto.getQuantity());
        dbManager.setString(12,prpCguarantyDto.getPossessor());
        dbManager.setString(13,prpCguarantyDto.getGuarantyAddress());
        dbManager.setString(14,prpCguarantyDto.getGuarantyKeeper());
        dbManager.setString(15,prpCguarantyDto.getPropCertifNo());
        dbManager.setDouble(16,prpCguarantyDto.getGuarantyAssessment());
        dbManager.setDouble(17,prpCguarantyDto.getOtherRating());
        dbManager.setString(18,prpCguarantyDto.getInpawnQuality());
        dbManager.setDouble(19,prpCguarantyDto.getOriginalValue());
        dbManager.setDouble(20,prpCguarantyDto.getNetValue());
        dbManager.setString(21,prpCguarantyDto.getValuator());
        dbManager.setDateTime(22,prpCguarantyDto.getRightValidPeriod());
        dbManager.setDateTime(23,prpCguarantyDto.getEncashDate());
        dbManager.setString(24,prpCguarantyDto.getFlag());
        //设置条件字段;
        dbManager.setString(25,prpCguarantyDto.getPolicyNo());
        dbManager.setInt(26,prpCguarantyDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCguarantyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return PrpCguarantyDto
     * @throws Exception
     */
    public PrpCguarantyDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " GuaranteeType," + 
                           " InpawnType," + 
                           " MortgageNo," + 
                           " ObligeeType," + 
                           " WarrantorName," + 
                           " GuarantyObligee," + 
                           " GuarantyName," + 
                           " Model," + 
                           " Unit," + 
                           " Quantity," + 
                           " Possessor," + 
                           " GuarantyAddress," + 
                           " GuarantyKeeper," + 
                           " PropCertifNo," + 
                           " GuarantyAssessment," + 
                           " OtherRating," + 
                           " InpawnQuality," + 
                           " OriginalValue," + 
                           " NetValue," + 
                           " Valuator," + 
                           " RightValidPeriod," + 
                           " EncashDate," + 
                           " Flag From PrpCguaranty Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCguarantyDto prpCguarantyDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCguarantyDto = new PrpCguarantyDto();
            prpCguarantyDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCguarantyDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCguarantyDto.setRiskCode(dbManager.getString(resultSet,3));
            prpCguarantyDto.setGuaranteeType(dbManager.getString(resultSet,4));
            prpCguarantyDto.setInpawnType(dbManager.getString(resultSet,5));
            prpCguarantyDto.setMortgageNo(dbManager.getString(resultSet,6));
            prpCguarantyDto.setObligeeType(dbManager.getString(resultSet,7));
            prpCguarantyDto.setWarrantorName(dbManager.getString(resultSet,8));
            prpCguarantyDto.setGuarantyObligee(dbManager.getString(resultSet,9));
            prpCguarantyDto.setGuarantyName(dbManager.getString(resultSet,10));
            prpCguarantyDto.setModel(dbManager.getString(resultSet,11));
            prpCguarantyDto.setUnit(dbManager.getString(resultSet,12));
            prpCguarantyDto.setQuantity(dbManager.getInt(resultSet,13));
            prpCguarantyDto.setPossessor(dbManager.getString(resultSet,14));
            prpCguarantyDto.setGuarantyAddress(dbManager.getString(resultSet,15));
            prpCguarantyDto.setGuarantyKeeper(dbManager.getString(resultSet,16));
            prpCguarantyDto.setPropCertifNo(dbManager.getString(resultSet,17));
            prpCguarantyDto.setGuarantyAssessment(dbManager.getDouble(resultSet,18));
            prpCguarantyDto.setOtherRating(dbManager.getDouble(resultSet,19));
            prpCguarantyDto.setInpawnQuality(dbManager.getString(resultSet,20));
            prpCguarantyDto.setOriginalValue(dbManager.getDouble(resultSet,21));
            prpCguarantyDto.setNetValue(dbManager.getDouble(resultSet,22));
            prpCguarantyDto.setValuator(dbManager.getString(resultSet,23));
            prpCguarantyDto.setRightValidPeriod(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpCguarantyDto.setEncashDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,25));
            prpCguarantyDto.setFlag(dbManager.getString(resultSet,26));
        }
        resultSet.close();
        log.info("DBPrpCguarantyBase.findByPrimaryKey() success!");
        return prpCguarantyDto;
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
        String statement = "Select PolicyNo," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " GuaranteeType," + 
                           " InpawnType," + 
                           " MortgageNo," + 
                           " ObligeeType," + 
                           " WarrantorName," + 
                           " GuarantyObligee," + 
                           " GuarantyName," + 
                           " Model," + 
                           " Unit," + 
                           " Quantity," + 
                           " Possessor," + 
                           " GuarantyAddress," + 
                           " GuarantyKeeper," + 
                           " PropCertifNo," + 
                           " GuarantyAssessment," + 
                           " OtherRating," + 
                           " InpawnQuality," + 
                           " OriginalValue," + 
                           " NetValue," + 
                           " Valuator," + 
                           " RightValidPeriod," + 
                           " EncashDate," + 
                           " Flag From PrpCguaranty Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCguarantyDto prpCguarantyDto = null;
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

            prpCguarantyDto = new PrpCguarantyDto();
            prpCguarantyDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCguarantyDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCguarantyDto.setRiskCode(dbManager.getString(resultSet,3));
            prpCguarantyDto.setGuaranteeType(dbManager.getString(resultSet,4));
            prpCguarantyDto.setInpawnType(dbManager.getString(resultSet,5));
            prpCguarantyDto.setMortgageNo(dbManager.getString(resultSet,6));
            prpCguarantyDto.setObligeeType(dbManager.getString(resultSet,7));
            prpCguarantyDto.setWarrantorName(dbManager.getString(resultSet,8));
            prpCguarantyDto.setGuarantyObligee(dbManager.getString(resultSet,9));
            prpCguarantyDto.setGuarantyName(dbManager.getString(resultSet,10));
            prpCguarantyDto.setModel(dbManager.getString(resultSet,11));
            prpCguarantyDto.setUnit(dbManager.getString(resultSet,12));
            prpCguarantyDto.setQuantity(dbManager.getInt(resultSet,13));
            prpCguarantyDto.setPossessor(dbManager.getString(resultSet,14));
            prpCguarantyDto.setGuarantyAddress(dbManager.getString(resultSet,15));
            prpCguarantyDto.setGuarantyKeeper(dbManager.getString(resultSet,16));
            prpCguarantyDto.setPropCertifNo(dbManager.getString(resultSet,17));
            prpCguarantyDto.setGuarantyAssessment(dbManager.getDouble(resultSet,18));
            prpCguarantyDto.setOtherRating(dbManager.getDouble(resultSet,19));
            prpCguarantyDto.setInpawnQuality(dbManager.getString(resultSet,20));
            prpCguarantyDto.setOriginalValue(dbManager.getDouble(resultSet,21));
            prpCguarantyDto.setNetValue(dbManager.getDouble(resultSet,22));
            prpCguarantyDto.setValuator(dbManager.getString(resultSet,23));
            prpCguarantyDto.setRightValidPeriod(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            prpCguarantyDto.setEncashDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,25));
            prpCguarantyDto.setFlag(dbManager.getString(resultSet,26));
            collection.add(prpCguarantyDto);
        }
        resultSet.close();
        log.info("DBPrpCguarantyBase.findByConditions() success!");
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
        String statement = "Delete From PrpCguaranty Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCguarantyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCguaranty Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCguarantyBase.getCount() success!");
        return count;
    }
}
