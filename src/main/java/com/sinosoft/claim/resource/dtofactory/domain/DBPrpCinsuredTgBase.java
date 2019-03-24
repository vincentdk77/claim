package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsured保险关系人表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsuredTgBase{
    protected  DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCinsuredTgBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCinsuredTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void insert(PrpCinsuredDto prpCinsuredDto) throws Exception{
        String statement = " Insert Into PrpCinsuredTg(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " Language," + 
                           " InsuredType," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " InsuredNature," + 
                           " InsuredFlag," + 
                           " insuredidentity," + 
                           " relateserialno," + 
                           " identifytype," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Bank," + 
                           " accountname," + 
                           " Account," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " BenefitFlag," + 
                           " BenefitRate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCinsuredDto.getPolicyNo());
        dbManager.setString(2,prpCinsuredDto.getRiskCode());
        dbManager.setInt(3,prpCinsuredDto.getSerialNo());
        dbManager.setString(4,prpCinsuredDto.getLanguage());
        dbManager.setString(5,prpCinsuredDto.getInsuredType());
        dbManager.setString(6,prpCinsuredDto.getInsuredCode());
        dbManager.setString(7,prpCinsuredDto.getInsuredName());
        dbManager.setString(8,prpCinsuredDto.getInsuredAddress());
        dbManager.setString(9,prpCinsuredDto.getInsuredNature());
        dbManager.setString(10,prpCinsuredDto.getInsuredFlag());
        dbManager.setString(11,prpCinsuredDto.getInsuredidentity());
        dbManager.setInt(12,prpCinsuredDto.getRelateserialno());
        dbManager.setString(13,prpCinsuredDto.getIdentifytype());
        dbManager.setString(14,prpCinsuredDto.getIdentifyNumber());
        dbManager.setString(15,prpCinsuredDto.getCreditLevel());
        dbManager.setString(16,prpCinsuredDto.getPossessNature());
        dbManager.setString(17,prpCinsuredDto.getBusinessSource());
        dbManager.setString(18,prpCinsuredDto.getBusinessSort());
        dbManager.setString(19,prpCinsuredDto.getOccupationCode());
        dbManager.setString(20,prpCinsuredDto.getEducationCode());
        dbManager.setString(21,prpCinsuredDto.getBank());
        dbManager.setString(22,prpCinsuredDto.getAccountname());
        dbManager.setString(23,prpCinsuredDto.getAccount());
        dbManager.setString(24,prpCinsuredDto.getLinkerName());
        dbManager.setString(25,prpCinsuredDto.getPostAddress());
        dbManager.setString(26,prpCinsuredDto.getPostCode());
        dbManager.setString(27,prpCinsuredDto.getPhoneNumber());
        dbManager.setString(28,prpCinsuredDto.getMobile());
        dbManager.setString(29,prpCinsuredDto.getEmail());
        dbManager.setString(30,prpCinsuredDto.getBenefitFlag());
        dbManager.setDouble(31,prpCinsuredDto.getBenefitRate());
        dbManager.setString(32,prpCinsuredDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto)i.next();
            insert(prpCinsuredDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCinsuredTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCinsuredBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void update(PrpCinsuredDto prpCinsuredDto) throws Exception{
        String statement = " Update PrpCinsuredTg Set RiskCode = ?," + 
                           " Language = ?," + 
                           " InsuredType = ?," + 
                           " InsuredCode = ?," + 
                           " InsuredName = ?," + 
                           " InsuredAddress = ?," + 
                           " InsuredNature = ?," + 
                           " InsuredFlag = ?," + 
                           " insuredidentity = ?," + 
                           " relateserialno = ?," + 
                           " identifytype = ?," + 
                           " IdentifyNumber = ?," + 
                           " CreditLevel = ?," + 
                           " PossessNature = ?," + 
                           " BusinessSource = ?," + 
                           " BusinessSort = ?," + 
                           " OccupationCode = ?," + 
                           " EducationCode = ?," + 
                           " Bank = ?," + 
                           " accountname = ?," + 
                           " Account = ?," + 
                           " LinkerName = ?," + 
                           " PostAddress = ?," + 
                           " PostCode = ?," + 
                           " PhoneNumber = ?," + 
                           " Mobile = ?," + 
                           " Email = ?," + 
                           " BenefitFlag = ?," + 
                           " BenefitRate = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCinsuredDto.getRiskCode());
        dbManager.setString(2,prpCinsuredDto.getLanguage());
        dbManager.setString(3,prpCinsuredDto.getInsuredType());
        dbManager.setString(4,prpCinsuredDto.getInsuredCode());
        dbManager.setString(5,prpCinsuredDto.getInsuredName());
        dbManager.setString(6,prpCinsuredDto.getInsuredAddress());
        dbManager.setString(7,prpCinsuredDto.getInsuredNature());
        dbManager.setString(8,prpCinsuredDto.getInsuredFlag());
        dbManager.setString(9,prpCinsuredDto.getInsuredidentity());
        dbManager.setInt(10,prpCinsuredDto.getRelateserialno());
        dbManager.setString(11,prpCinsuredDto.getIdentifytype());
        dbManager.setString(12,prpCinsuredDto.getIdentifyNumber());
        dbManager.setString(13,prpCinsuredDto.getCreditLevel());
        dbManager.setString(14,prpCinsuredDto.getPossessNature());
        dbManager.setString(15,prpCinsuredDto.getBusinessSource());
        dbManager.setString(16,prpCinsuredDto.getBusinessSort());
        dbManager.setString(17,prpCinsuredDto.getOccupationCode());
        dbManager.setString(18,prpCinsuredDto.getEducationCode());
        dbManager.setString(19,prpCinsuredDto.getBank());
        dbManager.setString(20,prpCinsuredDto.getAccountname());
        dbManager.setString(21,prpCinsuredDto.getAccount());
        dbManager.setString(22,prpCinsuredDto.getLinkerName());
        dbManager.setString(23,prpCinsuredDto.getPostAddress());
        dbManager.setString(24,prpCinsuredDto.getPostCode());
        dbManager.setString(25,prpCinsuredDto.getPhoneNumber());
        dbManager.setString(26,prpCinsuredDto.getMobile());
        dbManager.setString(27,prpCinsuredDto.getEmail());
        dbManager.setString(28,prpCinsuredDto.getBenefitFlag());
        dbManager.setDouble(29,prpCinsuredDto.getBenefitRate());
        dbManager.setString(30,prpCinsuredDto.getFlag());
        //设置条件字段;
        dbManager.setString(31,prpCinsuredDto.getPolicyNo());
        dbManager.setInt(32,prpCinsuredDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return PrpCinsuredDto
     * @throws Exception
     */
    public PrpCinsuredDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " Language," + 
                           " InsuredType," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " InsuredNature," + 
                           " InsuredFlag," + 
                           " insuredidentity," + 
                           " relateserialno," + 
                           " identifytype," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Bank," + 
                           " accountname," + 
                           " Account," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " BenefitFlag," + 
                           " BenefitRate," + 
                           " Flag From PrpCinsuredTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCinsuredDto prpCinsuredDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCinsuredDto = new PrpCinsuredDto();
            prpCinsuredDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCinsuredDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCinsuredDto.setLanguage(dbManager.getString(resultSet,4));
            prpCinsuredDto.setInsuredType(dbManager.getString(resultSet,5));
            prpCinsuredDto.setInsuredCode(dbManager.getString(resultSet,6));
            prpCinsuredDto.setInsuredName(dbManager.getString(resultSet,7));
            prpCinsuredDto.setInsuredAddress(dbManager.getString(resultSet,8));
            prpCinsuredDto.setInsuredNature(dbManager.getString(resultSet,9));
            prpCinsuredDto.setInsuredFlag(dbManager.getString(resultSet,10));
            prpCinsuredDto.setInsuredidentity(dbManager.getString(resultSet,11));
            prpCinsuredDto.setRelateserialno(dbManager.getInt(resultSet,12));
            prpCinsuredDto.setIdentifytype(dbManager.getString(resultSet,13));
            prpCinsuredDto.setIdentifyNumber(dbManager.getString(resultSet,14));
            prpCinsuredDto.setCreditLevel(dbManager.getString(resultSet,15));
            prpCinsuredDto.setPossessNature(dbManager.getString(resultSet,16));
            prpCinsuredDto.setBusinessSource(dbManager.getString(resultSet,17));
            prpCinsuredDto.setBusinessSort(dbManager.getString(resultSet,18));
            prpCinsuredDto.setOccupationCode(dbManager.getString(resultSet,19));
            prpCinsuredDto.setEducationCode(dbManager.getString(resultSet,20));
            prpCinsuredDto.setBank(dbManager.getString(resultSet,21));
            prpCinsuredDto.setAccountname(dbManager.getString(resultSet,22));
            prpCinsuredDto.setAccount(dbManager.getString(resultSet,23));
            prpCinsuredDto.setLinkerName(dbManager.getString(resultSet,24));
            prpCinsuredDto.setPostAddress(dbManager.getString(resultSet,25));
            prpCinsuredDto.setPostCode(dbManager.getString(resultSet,26));
            prpCinsuredDto.setPhoneNumber(dbManager.getString(resultSet,27));
            prpCinsuredDto.setMobile(dbManager.getString(resultSet,28));
            prpCinsuredDto.setEmail(dbManager.getString(resultSet,29));
            prpCinsuredDto.setBenefitFlag(dbManager.getString(resultSet,30));
            prpCinsuredDto.setBenefitRate(dbManager.getDouble(resultSet,31));
            prpCinsuredDto.setFlag(dbManager.getString(resultSet,32));
        }
        resultSet.close();
        log.info("DBPrpCinsuredBase.findByPrimaryKey() success!");
        return prpCinsuredDto;
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
                           " RiskCode," + 
                           " SerialNo," + 
                           " Language," + 
                           " InsuredType," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " InsuredNature," + 
                           " InsuredFlag," + 
                           " insuredidentity," + 
                           " relateserialno," + 
                           " identifytype," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Bank," + 
                           " accountname," + 
                           " Account," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " BenefitFlag," + 
                           " BenefitRate," + 
                           " Flag From PrpCinsuredTg Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCinsuredDto prpCinsuredDto = null;
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

            prpCinsuredDto = new PrpCinsuredDto();
            prpCinsuredDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCinsuredDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCinsuredDto.setLanguage(dbManager.getString(resultSet,4));
            prpCinsuredDto.setInsuredType(dbManager.getString(resultSet,5));
            prpCinsuredDto.setInsuredCode(dbManager.getString(resultSet,6));
            prpCinsuredDto.setInsuredName(dbManager.getString(resultSet,7));
            prpCinsuredDto.setInsuredAddress(dbManager.getString(resultSet,8));
            prpCinsuredDto.setInsuredNature(dbManager.getString(resultSet,9));
            prpCinsuredDto.setInsuredFlag(dbManager.getString(resultSet,10));
            prpCinsuredDto.setInsuredidentity(dbManager.getString(resultSet,11));
            prpCinsuredDto.setRelateserialno(dbManager.getInt(resultSet,12));
            prpCinsuredDto.setIdentifytype(dbManager.getString(resultSet,13));
            prpCinsuredDto.setIdentifyNumber(dbManager.getString(resultSet,14));
            prpCinsuredDto.setCreditLevel(dbManager.getString(resultSet,15));
            prpCinsuredDto.setPossessNature(dbManager.getString(resultSet,16));
            prpCinsuredDto.setBusinessSource(dbManager.getString(resultSet,17));
            prpCinsuredDto.setBusinessSort(dbManager.getString(resultSet,18));
            prpCinsuredDto.setOccupationCode(dbManager.getString(resultSet,19));
            prpCinsuredDto.setEducationCode(dbManager.getString(resultSet,20));
            prpCinsuredDto.setBank(dbManager.getString(resultSet,21));
            prpCinsuredDto.setAccountname(dbManager.getString(resultSet,22));
            prpCinsuredDto.setAccount(dbManager.getString(resultSet,23));
            prpCinsuredDto.setLinkerName(dbManager.getString(resultSet,24));
            prpCinsuredDto.setPostAddress(dbManager.getString(resultSet,25));
            prpCinsuredDto.setPostCode(dbManager.getString(resultSet,26));
            prpCinsuredDto.setPhoneNumber(dbManager.getString(resultSet,27));
            prpCinsuredDto.setMobile(dbManager.getString(resultSet,28));
            prpCinsuredDto.setEmail(dbManager.getString(resultSet,29));
            prpCinsuredDto.setBenefitFlag(dbManager.getString(resultSet,30));
            prpCinsuredDto.setBenefitRate(dbManager.getDouble(resultSet,31));
            prpCinsuredDto.setFlag(dbManager.getString(resultSet,32));
            collection.add(prpCinsuredDto);
        }
        resultSet.close();
        log.info("DBPrpCinsuredBase.findByConditions() success!");
        return collection;
    }
    
    /**
     * 按条件查询出理赔分户的多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select distinct cv.policyno,cv.riskcode,cv.familyno,cv.familyname,cv.identifynumber,cv.familyage,cv.familysex,cv.benname,cv.bensex from prpcvirturlitem cv where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCvirturlItemSchema prpCvirturlItemSchema = null;
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

            prpCvirturlItemSchema = new PrpCvirturlItemSchema();
           // prpCvirturlItemSchema.setPolicyNo(dbManager.getString(resultSet,1));
            prpCvirturlItemSchema.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpCvirturlItemSchema.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            prpCvirturlItemSchema.setFamilyNo(dbManager.getString(resultSet,"FamilyNo"));
            prpCvirturlItemSchema.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            prpCvirturlItemSchema.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            prpCvirturlItemSchema.setFamilyAge(dbManager.getString(resultSet,"FamilyAge"));
            prpCvirturlItemSchema.setFamilySex(dbManager.getString(resultSet,"FamilySex"));
            prpCvirturlItemSchema.setBenName(dbManager.getString(resultSet,"BenName"));
            prpCvirturlItemSchema.setBenSex(dbManager.getString(resultSet,"BenSex"));
            collection.add(prpCvirturlItemSchema);
        }
        resultSet.close();
        log.info("DBPrpCinsuredBase.findVirturlItemByConditions() success!");
        return collection;
    }
    /**
     * 按条件取乡村干部组合保险的数据
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findViturlItemDtoByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select distinct cv.policyno,cv.riskcode,cv.familyno,cv.familyname,cv.identifynumber,cv.familyage,cv.familysex,cv.benname,cv.bensex,cv.housenumber,cv.amount,cv.brandCode,cv.carNumber from prpcvirturlitem cv where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCvirturlItemSchema prpCvirturlItemSchema = null;
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

            prpCvirturlItemSchema = new PrpCvirturlItemSchema();
           // prpCvirturlItemSchema.setPolicyNo(dbManager.getString(resultSet,1));
            prpCvirturlItemSchema.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpCvirturlItemSchema.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            prpCvirturlItemSchema.setFamilyNo(dbManager.getString(resultSet,"FamilyNo"));
            prpCvirturlItemSchema.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            prpCvirturlItemSchema.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            prpCvirturlItemSchema.setFamilyAge(dbManager.getString(resultSet,"FamilyAge"));
            prpCvirturlItemSchema.setFamilySex(dbManager.getString(resultSet,"FamilySex"));
            prpCvirturlItemSchema.setBenName(dbManager.getString(resultSet,"BenName"));
            prpCvirturlItemSchema.setBenSex(dbManager.getString(resultSet,"BenSex"));
            prpCvirturlItemSchema.setHouseNumber(dbManager.getString(resultSet, "housenumber"));
            prpCvirturlItemSchema.setAmount(dbManager.getString(resultSet, "amount"));
            prpCvirturlItemSchema.setBrandCode(dbManager.getString(resultSet, "brandCode"));
            prpCvirturlItemSchema.setCarNumber(dbManager.getString(resultSet, "carNumber"));
            collection.add(prpCvirturlItemSchema);
        }
        resultSet.close();
        log.info("DBPrpCinsuredBase.findVirturlItemByConditions() success!");
        return collection;
    }
    /**
     * 按条件查询出理赔分户的收益人信息,只取一条信息
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findVirturlItemBeneInsured(String conditions) throws Exception{
        String statement = "select cv.benname,cv.bensex,cv.benidentifynumber,cv.remark  from prpcvirturlitem cv where " + conditions;
        log.error(statement);
        Collection collection = new ArrayList();
        PrpCvirturlItemSchema prpCvirturlItemSchema = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
      

        while(resultSet.next()){

            prpCvirturlItemSchema = new PrpCvirturlItemSchema();
            prpCvirturlItemSchema.setBenName(dbManager.getString(resultSet,"BenName"));
            prpCvirturlItemSchema.setBenSex(dbManager.getString(resultSet,"BenSex"));
            prpCvirturlItemSchema.setBenIdentifyNumber(dbManager.getString(resultSet,"BenIdentifyNumber"));
            prpCvirturlItemSchema.setRemark(dbManager.getString(resultSet,"Remark"));
            
            collection.add(prpCvirturlItemSchema);
        }
        resultSet.close();
        log.info("DBPrpCinsuredBase.findVirturlItemBeneInsured() success!");
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
        String statement = "Delete From PrpCinsuredTg Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCinsuredBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpCinsuredTg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredBase.getCount() success!");
        return count;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getVirturlItemCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpCvirturlItem Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredBase.getVirturlItemCount() success!");
        return count;
    }
}
