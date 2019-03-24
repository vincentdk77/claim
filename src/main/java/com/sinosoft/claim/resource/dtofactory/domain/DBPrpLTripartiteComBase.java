package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是PrpLTripartiteEnterprise 第三方数据维护基础表 修理厂的数据访问对象类<br>
 * 创建于 2012/11/9
 */
public class DBPrpLTripartiteComBase {
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpLTripartiteComBase.class.getName());
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLTripartiteComBase(DBManager dbManager){
        this.dbManager = dbManager;
    }
    
    /**
     * 插入一条数据
     * @param prpDTripartiteEnterpriseDto 第三方数据修理厂数据传输类对象
     * @throws Exception
     */
    public void insert(PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
        String statement = " Insert Into PrpLTripartiteCom(" + 
                           " EnterpriseCode," + 
                           " comCode," + 
                           " comCname," + 
                           " enterpriseDateType," + 
                           " phoneNumber," + 
                           " enterpriseCname," + 
                           " enterpriseAbbreviation," + 
                           " enterpriseType," + 
                           " organizationCode," + 
                           " legalPerson," + 
                           " legalPersonMobileNo," + 
                           " provinceCode," + 
                           " cityCode," + 
                           " addressDetail," + 
                           " hotLine," + 
                           " linkerName," + 
                           " linkerMobileNo," + 
                           " email," + 
                           " qqNo," + 
                          // " agentClaimFlag," + 
                           " bankType," + 
                           " bankCode," + 
                           " bankDetail," + 
                           " bankAccount," + 
                           " createDate," + 
                           " handlerCode," + 
                           " handlerCname," +
                           " updateDate," + 
                           " operateDate," + 
                           " operateCode," + 
                           " operateCname," +
                           " suggestion," + 
                           " validstatus," +
                           " illustrations," +
                           " approveFlag,"+
                           " buslicenseCode," + 
                           " taxregistCode," + 
                           " cooperationType," + 
                           " comlinkname," +
                           " comlinktel," + 
                           " towncode," +
                           " timestart," +
                           " timeend,"+
                           " licenseNo," +
                           " lawyerLevel,"+
                           " flag," +
                           " accountName,"+
                           " openprovinceCode,"+
                           " opencityCode,"+
                           " accountype, "+
                           " amountPower "+
                           ")" +
                           " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        int index = 1;
        dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseCode());
        dbManager.setString(index++,prpLTripartiteComDto.getComCode());
        dbManager.setString(index++,prpLTripartiteComDto.getComCname());
        dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseDateType());
        dbManager.setString(index++,prpLTripartiteComDto.getPhoneNumber());
        dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseCname());
        dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseAbbreviation());
        dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseType());
        dbManager.setString(index++,prpLTripartiteComDto.getOrganizationCode());
        dbManager.setString(index++,prpLTripartiteComDto.getLegalPerson());
        dbManager.setString(index++,prpLTripartiteComDto.getLegalPersonMobileNo());
        dbManager.setString(index++,prpLTripartiteComDto.getProvinceCode());
        dbManager.setString(index++,prpLTripartiteComDto.getCityCode());
        dbManager.setString(index++,prpLTripartiteComDto.getAddressDetail());
        dbManager.setString(index++,prpLTripartiteComDto.getHotLine());
        dbManager.setString(index++,prpLTripartiteComDto.getLinkerName());
        dbManager.setString(index++,prpLTripartiteComDto.getLinkerMobileNo());
        dbManager.setString(index++,prpLTripartiteComDto.getEmail());
        dbManager.setString(index++,prpLTripartiteComDto.getQqNo());
       // dbManager.setString(20,prpLTripartiteComDto.getAgentClaimFlag());
        dbManager.setString(index++,prpLTripartiteComDto.getBankType());
        dbManager.setString(index++,prpLTripartiteComDto.getBankCode());
        dbManager.setString(index++,prpLTripartiteComDto.getBankDetail());
        dbManager.setString(index++,prpLTripartiteComDto.getBankAccount());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getCreateDate());
        dbManager.setString(index++,prpLTripartiteComDto.getHandlerCode());
        dbManager.setString(index++,prpLTripartiteComDto.getHandlerCname());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getUpdateDate());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getOperateDate());
        dbManager.setString(index++,prpLTripartiteComDto.getOperateCode());
        dbManager.setString(index++,prpLTripartiteComDto.getOperateCname());
        dbManager.setString(index++,prpLTripartiteComDto.getSuggestion());
        dbManager.setString(index++,prpLTripartiteComDto.getValidstatus());
        dbManager.setString(index++,prpLTripartiteComDto.getIllustrations());
        dbManager.setString(index++,prpLTripartiteComDto.getApproveFlag());
        dbManager.setString(index++,prpLTripartiteComDto.getBuslicenseCode());
        dbManager.setString(index++,prpLTripartiteComDto.getTaxregistCode());
        dbManager.setString(index++,prpLTripartiteComDto.getCooperationType());
        dbManager.setString(index++,prpLTripartiteComDto.getComLinkName());
        dbManager.setString(index++,prpLTripartiteComDto.getComLinkTel());
        dbManager.setString(index++,prpLTripartiteComDto.getTownCode());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getTimeStart());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getTimeEnd());
        dbManager.setString(index++,prpLTripartiteComDto.getLicenseNo());
        dbManager.setString(index++,prpLTripartiteComDto.getLawyerLevel());
        dbManager.setString(index++,prpLTripartiteComDto.getFlag());
        dbManager.setString(index++,prpLTripartiteComDto.getAccountName());
        dbManager.setString(index++,prpLTripartiteComDto.getOpenProvinceCode());
        dbManager.setString(index++,prpLTripartiteComDto.getOpenCityCode());
        dbManager.setString(index++,prpLTripartiteComDto.getAccountType());
        dbManager.setDouble(index++,prpLTripartiteComDto.getAmountPower());
        dbManager.executePreparedUpdate();
        log.info("DBPrpLTripartiteComBase.insert() success!");
    }
    
    public void insertAll(Collection<PrpLTripartiteComDto> prpLTripartiteComDtos) throws Exception{
    	Iterator it = prpLTripartiteComDtos.iterator();
    	while(it.hasNext()){
    		PrpLTripartiteComDto prpLTripartiteComDto = (PrpLTripartiteComDto)it.next();
    		insert(prpLTripartiteComDto);
    	}
    }
    
    public void update(String enterpriseCode,String approveFlag,String suggestion) throws Exception{
    	String statement = "update PrpLTripartiteCom set suggestion = ?, approveflag = ? where enterprisecode = ? ";
    	log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,suggestion);
        dbManager.setString(2,approveFlag);
        dbManager.setString(3,enterpriseCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLTripartiteComBase.update() success!");
    }
    
    public void update(String enterpriseCode,PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
    	String statement = "update PrpLTripartiteCom set "+
					        " comCode=?," + 
					        " comCname=?," + 
					        " enterpriseDateType=?," + 
					        " phoneNumber=?," + 
					        " enterpriseCname=?," + 
					        " enterpriseAbbreviation=?," + 
					        " enterpriseType=?," + 
					        " organizationCode=?," + 
					        " legalPerson=?," + 
					        " legalPersonMobileNo=?," + 
					        " provinceCode=?," + 
					        " cityCode=?," + 
					        " addressDetail=?," + 
					        " hotLine=?," + 
					        " linkerName=?," + 
					        " linkerMobileNo=?," + 
					        " email=?," + 
					        " qqNo=?," + 
					       // " agentClaimFlag=?," + 
					        " bankType=?," + 
					        " bankCode=?," + 
					        " bankDetail=?," + 
					        " bankAccount=?," + 
					        " createDate=?," + 
					        " handlerCode=?," + 
					        " handlerCname=?," +
					        " updateDate=?," + 
					        " operateDate=?," + 
					        " operateCode=?," + 
					        " operateCname=?," +
					        " suggestion=?," + 
					        " validstatus=?," +
					        " illustrations=?," +
					        " approveFlag =?," +
					        " buslicenseCode=?," + 
	                        " taxregistCode=?," + 
	                        " cooperationType=?," + 
	                        " comlinkname=?," +
	                        " comlinktel=?," + 
	                        " towncode=?," +
	                        " timestart=?," +
	                        " timeend=?,"+
	                        " licenseNo=?," +
	                        " lawyerLevel=?,"+
					        " flag = ?," +
					        " accountName = ?,"+
	                        " openprovinceCode = ?,"+
	                        " opencityCode = ?,"+
	                        " accountype = ?, "+
	                        " amountPower = ? "+
					        " where EnterpriseCode = ?";
		log.debug(statement);
		dbManager.prepareStatement(statement);
		int index = 1;
		dbManager.setString(index++,prpLTripartiteComDto.getComCode());
		dbManager.setString(index++,prpLTripartiteComDto.getComCname());
		dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseDateType());
		dbManager.setString(index++,prpLTripartiteComDto.getPhoneNumber());
		dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseCname());
		dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseAbbreviation());
		dbManager.setString(index++,prpLTripartiteComDto.getEnterpriseType());
		dbManager.setString(index++,prpLTripartiteComDto.getOrganizationCode());
		dbManager.setString(index++,prpLTripartiteComDto.getLegalPerson());
		dbManager.setString(index++,prpLTripartiteComDto.getLegalPersonMobileNo());
		dbManager.setString(index++,prpLTripartiteComDto.getProvinceCode());
		dbManager.setString(index++,prpLTripartiteComDto.getCityCode());
		dbManager.setString(index++,prpLTripartiteComDto.getAddressDetail());
		dbManager.setString(index++,prpLTripartiteComDto.getHotLine());
		dbManager.setString(index++,prpLTripartiteComDto.getLinkerName());
		dbManager.setString(index++,prpLTripartiteComDto.getLinkerMobileNo());
		dbManager.setString(index++,prpLTripartiteComDto.getEmail());
		dbManager.setString(index++,prpLTripartiteComDto.getQqNo());
		//dbManager.setString(index++,prpLTripartiteComDto.getAgentClaimFlag());
		dbManager.setString(index++,prpLTripartiteComDto.getBankType());
		dbManager.setString(index++,prpLTripartiteComDto.getBankCode());
		dbManager.setString(index++,prpLTripartiteComDto.getBankDetail());
		dbManager.setString(index++,prpLTripartiteComDto.getBankAccount());
		dbManager.setDateTime(index++,prpLTripartiteComDto.getCreateDate());
		dbManager.setString(index++,prpLTripartiteComDto.getHandlerCode());
		dbManager.setString(index++,prpLTripartiteComDto.getHandlerCname());
		dbManager.setDateTime(index++,prpLTripartiteComDto.getUpdateDate());
		dbManager.setDateTime(index++,prpLTripartiteComDto.getOperateDate());
		dbManager.setString(index++,prpLTripartiteComDto.getOperateCode());
		dbManager.setString(index++,prpLTripartiteComDto.getOperateCname());
		dbManager.setString(index++,prpLTripartiteComDto.getSuggestion());
		dbManager.setString(index++,prpLTripartiteComDto.getValidstatus());
		dbManager.setString(index++,prpLTripartiteComDto.getIllustrations());
		dbManager.setString(index++,prpLTripartiteComDto.getApproveFlag());
		dbManager.setString(index++,prpLTripartiteComDto.getBuslicenseCode());
        dbManager.setString(index++,prpLTripartiteComDto.getTaxregistCode());
        dbManager.setString(index++,prpLTripartiteComDto.getCooperationType());
        dbManager.setString(index++,prpLTripartiteComDto.getComLinkName());
        dbManager.setString(index++,prpLTripartiteComDto.getComLinkTel());
        dbManager.setString(index++,prpLTripartiteComDto.getTownCode());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getTimeStart());
        dbManager.setDateTime(index++,prpLTripartiteComDto.getTimeEnd());
        dbManager.setString(index++,prpLTripartiteComDto.getLicenseNo());
        dbManager.setString(index++,prpLTripartiteComDto.getLawyerLevel());
        dbManager.setString(index++,prpLTripartiteComDto.getFlag());
        dbManager.setString(index++,prpLTripartiteComDto.getAccountName());
        dbManager.setString(index++,prpLTripartiteComDto.getOpenProvinceCode());
        dbManager.setString(index++,prpLTripartiteComDto.getOpenCityCode());
        dbManager.setString(index++,prpLTripartiteComDto.getAccountType());
        dbManager.setDouble(index++,prpLTripartiteComDto.getAmountPower());
		dbManager.setString(index++,enterpriseCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLTripartiteComBase.Queryupdate() success!");
    }
    
    public void delete(String enterpriseCode)throws Exception{
    	String statement = "delete from prpltripartitecom where enterpriseCode = ?";
    	log.debug(statement);
    	dbManager.prepareStatement(statement);
    	dbManager.setString(1, enterpriseCode);
    	dbManager.executePreparedUpdate();
    	 log.info("DBPrpLTripartiteComBase.delete() success!");
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
        String statement = "Select enterpriseCode," + 
                           " enterpriseCname," + 
                           " comCode," +
                           " comCname," +
                           " enterpriseDateType," +
                           " phoneNumber," +
                           " enterpriseAbbreviation," +
                           " enterpriseType," +
                           " organizationCode," +
                           " legalPerson," +
                           " legalPersonMobileNo,"+
                           " provinceCode," +
                           " cityCode," +
                           " addressDetail," +
                           " hotLine," +
                           " linkerName," +
                           " linkerMobileNo," +
                           " email," +
                           " qqNo," +
                         //  " agentClaimFlag," +
                           " bankType," +
                           " bankCode," +
                           " bankDetail," +
                           " bankAccount," +
                           " createDate," +
                           " operateCode," +
                           " operateCname," +
                           " operateDate," +
                           " suggestion," +
                           " illustrations," +
                           " updateDate," +
                           " handlerCode," +
                           " handlerCname," +
                           " approveFlag," +
                           " buslicenseCode," + 
                           " taxregistCode," + 
                           " cooperationType," + 
                           " comlinkname," +
                           " comlinktel," + 
                           " towncode," +
                           " timestart," +
                           " timeend,"+
                           " licenseNo,"+
                           " lawyerLevel,"+
                           " flag," +
                           " accountName,"+
                           " openprovinceCode,"+
                           " opencityCode,"+
                           " accountype, "+
                           " validstatus,amountPower From PrpLTripartiteCom Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLTripartiteComDto prpLTripartiteComDto = null;
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
            int index = 1;
            prpLTripartiteComDto = new PrpLTripartiteComDto();
            prpLTripartiteComDto.setEnterpriseCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseDateType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setPhoneNumber(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseAbbreviation(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOrganizationCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLegalPerson(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLegalPersonMobileNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setProvinceCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCityCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAddressDetail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setHotLine(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLinkerName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLinkerMobileNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEmail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setQqNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankDetail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankAccount(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setOperateCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOperateCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setSuggestion(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setIllustrations(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setHandlerCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setApproveFlag(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBuslicenseCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTaxregistCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCooperationType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComLinkName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComLinkTel(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTownCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTimeStart(dbManager.getDateTime(resultSet,index++));
            prpLTripartiteComDto.setTimeEnd(dbManager.getDateTime(resultSet,index++));
            prpLTripartiteComDto.setLicenseNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLawyerLevel(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setFlag(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAccountName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOpenProvinceCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOpenCityCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAccountType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setValidstatus(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAmountPower(dbManager.getDouble(resultSet,index++));
            collection.add(prpLTripartiteComDto);
        }
        resultSet.close();
        log.info("DBPrpLTripartiteComBase.findByConditions() success!");
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
    
    public PrpLTripartiteComDto findByKeys(String conditions) throws Exception{
    	PrpLTripartiteComDto prpLTripartiteComDto = new PrpLTripartiteComDto();
    	String statement =  "Select enterpriseCode," + 
					        " enterpriseCname," + 
					        " comCode," +
					        " comCname," +
					        " enterpriseDateType," +
					        " phoneNumber," +
					        " enterpriseAbbreviation," +
					        " enterpriseType," +
					        " organizationCode," +
					        " legalPerson," +
					        " legalPersonMobileNo,"+
					        " provinceCode," +
					        " cityCode," +
					        " addressDetail," +
					        " hotLine," +
					        " linkerName," +
					        " linkerMobileNo," +
					        " email," +
					        " qqNo," +
					   //     " agentClaimFlag," +
					        " bankType," +
					        " bankCode," +
					        " bankDetail," +
					        " bankAccount," +
					        " createDate," +
					        " operateCode," +
					        " operateCname," +
					        " operateDate," +
					        " suggestion," +
					        " illustrations," +
					        " updateDate," +
					        " handlerCode," +
					        " handlerCname," +
					        " approveFlag," +
					        " buslicenseCode," + 
	                        " taxregistCode," + 
	                        " cooperationType," + 
	                        " comlinkname," +
	                        " comlinktel," + 
	                        " towncode," +
	                        " timestart," +
	                        " timeend,"+
	                        " licenseNo," +
	                        " lawyerLevel,"+
					        " flag," +
					        " accountName,"+
	                        " openprovinceCode,"+
	                        " opencityCode,"+
	                        " accountype, "+
					        " validstatus,amountPower From PrpLTripartiteCom Where " + conditions;
    		log.debug(statement);
    		ResultSet resultSet = dbManager.executeQuery(statement);
    		while(resultSet.next()){
    			int index = 1;
    			prpLTripartiteComDto = new PrpLTripartiteComDto();
                prpLTripartiteComDto.setEnterpriseCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setEnterpriseCname(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setComCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setComCname(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setEnterpriseDateType(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setPhoneNumber(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setEnterpriseAbbreviation(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setEnterpriseType(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setOrganizationCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setLegalPerson(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setLegalPersonMobileNo(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setProvinceCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setCityCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setAddressDetail(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setHotLine(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setLinkerName(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setLinkerMobileNo(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setEmail(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setQqNo(dbManager.getString(resultSet,index++));
               // prpLTripartiteComDto.setAgentClaimFlag(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setBankType(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setBankCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setBankDetail(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setBankAccount(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setCreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
                prpLTripartiteComDto.setOperateCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setOperateCname(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
                prpLTripartiteComDto.setSuggestion(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setIllustrations(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
                prpLTripartiteComDto.setHandlerCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setHandlerCname(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setApproveFlag(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setBuslicenseCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setTaxregistCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setCooperationType(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setComLinkName(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setComLinkTel(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setTownCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setTimeStart(dbManager.getDateTime(resultSet,index++));
                prpLTripartiteComDto.setTimeEnd(dbManager.getDateTime(resultSet,index++));
                prpLTripartiteComDto.setLicenseNo(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setLawyerLevel(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setFlag(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setAccountName(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setOpenProvinceCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setOpenCityCode(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setAccountType(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setValidstatus(dbManager.getString(resultSet,index++));
                prpLTripartiteComDto.setAmountPower(dbManager.getDouble(resultSet,index++));
    		}
    		resultSet.close();
            log.info("DBPrpLTripartiteComBase.findBykeys() success!");
    		return prpLTripartiteComDto;
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM PrpLTripartiteCom WHERE ");
        buffer.append(conditions);
        if(log.isDebugEnabled()){
        	log.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findTripartiteInfoByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select t.enterpriseCode," + 
                           " t.enterpriseCname," + 
                           " t.comCode," +
                           " t.comCname," +
                           " t.enterpriseDateType," +
                           " t.phoneNumber," +
                           " t.enterpriseAbbreviation," +
                           " t.enterpriseType," +
                           " t.organizationCode," +
                           " t.legalPerson," +
                           " t.legalPersonMobileNo,"+
                           " t.provinceCode," +
                           " t.cityCode," +
                           " t.addressDetail," +
                           " t.hotLine," +
                           " t.linkerName," +
                           " t.linkerMobileNo," +
                           " t.email," +
                           " t.qqNo," +
                           " t.bankType," +
                           " t.bankCode," +
                           " t.bankDetail," +
                           " t.bankAccount," +
                           " t.createDate," +
                           " t.operateCode," +
                           " t.operateCname," +
                           " t.operateDate," +
                           " t.suggestion," +
                           " t.illustrations," +
                           " t.updateDate," +
                           " t.handlerCode," +
                           " t.handlerCname," +
                           " t.approveFlag," +
                           " t.buslicenseCode," + 
                           " t.taxregistCode," + 
                           " t.cooperationType," + 
                           " t.comlinkname," +
                           " t.comlinktel," + 
                           " t.towncode," +
                           " t.timestart," +
                           " t.timeend,"+
                           " t.licenseNo,"+
                           " t.lawyerLevel,"+
                           " t.flag," +
                           " t.accountName,"+
                           " t.openprovinceCode,"+
                           " t.opencityCode,"+
                           " t.accountype, "+
                           " t.validstatus," +
                           " t.amountPower," +
                           " d.brandname," +
                           " d.brandcode," +
                           " d.discountrate " +
                           " From PrpLTripartiteCom t,prplapprovedrule d Where t.enterprisecode=d.enterprisecode(+) and" + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLTripartiteComDto prpLTripartiteComDto = null;
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
            int index = 1;
            prpLTripartiteComDto = new PrpLTripartiteComDto();
            prpLTripartiteComDto.setEnterpriseCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseDateType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setPhoneNumber(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseAbbreviation(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEnterpriseType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOrganizationCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLegalPerson(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLegalPersonMobileNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setProvinceCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCityCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAddressDetail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setHotLine(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLinkerName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLinkerMobileNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setEmail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setQqNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankDetail(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBankAccount(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setOperateCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOperateCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setSuggestion(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setIllustrations(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++));
            prpLTripartiteComDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setHandlerCname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setApproveFlag(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBuslicenseCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTaxregistCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setCooperationType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComLinkName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setComLinkTel(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTownCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setTimeStart(dbManager.getDateTime(resultSet,index++));
            prpLTripartiteComDto.setTimeEnd(dbManager.getDateTime(resultSet,index++));
            prpLTripartiteComDto.setLicenseNo(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setLawyerLevel(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setFlag(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAccountName(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOpenProvinceCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setOpenCityCode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAccountType(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setValidstatus(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setAmountPower(dbManager.getDouble(resultSet,index++));
            prpLTripartiteComDto.setBrandname(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setBrandcode(dbManager.getString(resultSet,index++));
            prpLTripartiteComDto.setDiscountRate(dbManager.getDouble(resultSet,index++));
            collection.add(prpLTripartiteComDto);
        }
        resultSet.close();
        log.info("DBPrpLTripartiteComBase.findByConditions() success!");
        return collection;
    }
    
}
