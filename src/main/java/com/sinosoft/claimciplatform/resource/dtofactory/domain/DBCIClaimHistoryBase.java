package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 平台返回历次赔付信息数据传输对象基类
 * 创建时间：2010-03-29
 * @author sinosoft
 */
public class DBCIClaimHistoryBase {
	/**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimHistoryBase.class);
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimHistoryBase(DBManager dbManager){
        this.dbManager = dbManager;
    }
    
    /**
     * 插入一条数据
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insert(HistoryClaim historyClaim)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
    	buffer.append("Insert into CIClaimHistory( ClaimCode           ,");
    	buffer.append("SerialNo            ,");
    	buffer.append("LicenseNo           ,");
    	buffer.append("ClaimCompany        ,");
    	buffer.append("CarMark             ,");
    	buffer.append("VehicleType         ,");
    	buffer.append("IsInsuredCar        ,");
    	buffer.append("CoverageType        ,");
    	buffer.append("RegistNo            ,");
    	buffer.append("CLaimNo             ,");
    	buffer.append("PolicyNo            ,");
    	buffer.append("DamageDate          ,");
    	buffer.append("ReportDate          ,");
    	buffer.append("EndcaseDate         ,");
    	buffer.append("SumClaim            ,");
    	buffer.append("SumPaid             ,");
    	buffer.append("Status              ,");
    	buffer.append("AccidentPlace       ,");
    	buffer.append("AccidentDescription ,");
    	buffer.append("DutyCode             ");
    	if(logger.isDebugEnabled()){
    		StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(historyClaim.getClaimCode          ()).append("',");
            debugBuffer.append("'").append(historyClaim.getSerialNo           ()).append("',");
            debugBuffer.append("'").append(historyClaim.getLicenseNo          ()).append("',");
            debugBuffer.append("'").append(historyClaim.getClaimCompany       ()).append("',");
            debugBuffer.append("'").append(historyClaim.getLicenseNo          ()).append("',");
            debugBuffer.append("'").append(historyClaim.getVehicleType        ()).append("',");
            debugBuffer.append("'").append(historyClaim.getIsInsuredCar       ()).append("',");
            debugBuffer.append("'").append(historyClaim.getCoverageType       ()).append("',");
            debugBuffer.append("'").append(historyClaim.getRegistNo           ()).append("',");
            debugBuffer.append("'").append(historyClaim.getClaimNo            ()).append("',");
            debugBuffer.append("'").append(historyClaim.getPolicyNo           ()).append("',");
            debugBuffer.append("'").append(historyClaim.getAccidentTime       ()).append("',");
            debugBuffer.append("'").append(historyClaim.getRegistTime         ()).append("',");
            debugBuffer.append("'").append(historyClaim.getEndCaseTime        ()).append("',");
            debugBuffer.append("").append(historyClaim.getUnClaimAmount      ()).append(",");
            debugBuffer.append("").append(historyClaim.getClaimAmount        ()).append(",");
            debugBuffer.append("'").append(historyClaim.getCaseStatus         ()).append("',");
            debugBuffer.append("'").append(historyClaim.getAccidentPlace      ()).append("',");
            debugBuffer.append("'").append(historyClaim.getAccidentDesc       ()).append("',");
            debugBuffer.append("'").append(historyClaim.getIndemnityDuty      ()).append("')");
            logger.debug(debugBuffer.toString());
    	}
    	buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	dbManager.prepareStatement(buffer.toString());
    	dbManager.setString(1 ,historyClaim.getClaimCode          ());
    	dbManager.setInt(2 ,historyClaim.getSerialNo           ());
    	dbManager.setString(2 ,historyClaim.getLicenseNo          ());
    	dbManager.setString(3 ,historyClaim.getClaimCompany       ());
    	dbManager.setString(4 ,historyClaim.getLicenseNo          ());
    	dbManager.setString(5 ,historyClaim.getVehicleType        ());
    	dbManager.setString(6 ,historyClaim.getIsInsuredCar       ());
    	dbManager.setString(7 ,historyClaim.getCoverageType       ());
    	dbManager.setString(8 ,historyClaim.getRegistNo           ());
    	dbManager.setString(9 ,historyClaim.getClaimNo            ());
    	dbManager.setString(10,historyClaim.getPolicyNo           ());
    	dbManager.setDateTime(11,historyClaim.getAccidentTime       ());
    	dbManager.setDateTime(12,historyClaim.getRegistTime         ());
    	dbManager.setDateTime(13,historyClaim.getEndCaseTime        ());
    	dbManager.setDouble(14,historyClaim.getUnClaimAmount      ());
    	dbManager.setDouble(15,historyClaim.getClaimAmount        ());
    	dbManager.setString(16,historyClaim.getCaseStatus         ());
    	dbManager.setString(17,historyClaim.getAccidentPlace      ());
    	dbManager.setString(18,historyClaim.getAccidentDesc       ());
    	dbManager.setString(19,historyClaim.getIndemnityDuty      ());
        dbManager.executePreparedUpdate();
    }
    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
    	buffer.append("Insert into CIClaimHistory( ClaimCode           ,");
    	buffer.append("SerialNo            ,");
    	buffer.append("LicenseNo           ,");
    	buffer.append("ClaimCompany        ,");
    	buffer.append("CarMark             ,");
    	buffer.append("VehicleType         ,");
    	buffer.append("IsInsuredCar        ,");
    	buffer.append("CoverageType        ,");
    	buffer.append("RegistNo            ,");
    	buffer.append("CLaimNo             ,");
    	buffer.append("PolicyNo            ,");
    	buffer.append("DamageDate          ,");
    	buffer.append("ReportDate          ,");
    	buffer.append("EndcaseDate         ,");
    	buffer.append("SumClaim            ,");
    	buffer.append("SumPaid             ,");
    	buffer.append("Status              ,");
    	buffer.append("AccidentPlace       ,");
    	buffer.append("AccidentDescription ,");
    	buffer.append("DutyCode            ) ");
    	buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
    		HistoryClaim historyClaim = (HistoryClaim)i.next();
    		int index = 1;
    		dbManager.setString(1 ,historyClaim.getClaimCode          ());
    		dbManager.setInt(2 ,historyClaim.getSerialNo           ());
        	dbManager.setString(3 ,historyClaim.getLicenseNo          ());
        	dbManager.setString(4 ,historyClaim.getClaimCompany       ());
        	dbManager.setString(5 ,historyClaim.getLicenseNo          ());
        	dbManager.setString(6 ,historyClaim.getVehicleType        ());
        	dbManager.setString(7 ,historyClaim.getIsInsuredCar       ());
        	dbManager.setString(8 ,historyClaim.getCoverageType       ());
        	dbManager.setString(9 ,historyClaim.getRegistNo           ());
        	dbManager.setString(10 ,historyClaim.getClaimNo            ());
        	dbManager.setString(11,historyClaim.getPolicyNo           ());
        	dbManager.setDateTime(12,historyClaim.getAccidentTime       ());
        	dbManager.setDateTime(13,historyClaim.getRegistTime         ());
        	dbManager.setDateTime(14,historyClaim.getEndCaseTime        ());
        	dbManager.setDouble(15,historyClaim.getUnClaimAmount      ());
        	dbManager.setDouble(16,historyClaim.getClaimAmount        ());
        	dbManager.setString(17,historyClaim.getCaseStatus         ());
        	dbManager.setString(18,historyClaim.getAccidentPlace      ());
        	dbManager.setString(19,historyClaim.getAccidentDesc       ());
        	dbManager.setString(20,historyClaim.getIndemnityDuty      ());
        	dbManager.addBatch();
    	}
        dbManager.executePreparedUpdateBatch();
    }
    /**
     * 按主键删除一条数据
     * @param claimCode 理赔编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String claimCode,int serialNo)throws Exception{
    	StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimHistory ");
        if(logger.isDebugEnabled()){
        	StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(claimCode).append("',");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }
        buffer.append("WHERE ");
        buffer.append("claimCode = ?,");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimCode);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void update(HistoryClaim historyClaim)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimHistory SET ");
        buffer.append("SerialNo           =?,");
        buffer.append("LicenseNo          =?,");
        buffer.append("ClaimCompany       =?,");
        buffer.append("CarMark            =?,");
        buffer.append("VehicleType        =?,");
        buffer.append("IsInsuredCar       =?,");
        buffer.append("CoverageType       =?,");
        buffer.append("RegistNo           =?,");
        buffer.append("CLaimNo            =?,");
        buffer.append("PolicyNo           =?,");
        buffer.append("DamageDate         =?,");
        buffer.append("ReportDate         =?,");
        buffer.append("EndcaseDate        =?,");
        buffer.append("SumClaim           =?,");
        buffer.append("SumPaid            =?,");
        buffer.append("Status             =?,");
        buffer.append("AccidentPlace      =?,");
        buffer.append("AccidentDescription=?,");
        buffer.append("DutyCode           =? ");        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimHistory SET ");
            debugBuffer.append("ClaimCode          ='").append(historyClaim.getClaimCode          ()).append("',");
            debugBuffer.append("SerialNo           ='").append(historyClaim.getSerialNo           ()).append("',");
            debugBuffer.append("LicenseNo          ='").append(historyClaim.getLicenseNo          ()).append("',");
            debugBuffer.append("ClaimCompany       ='").append(historyClaim.getClaimCompany       ()).append("',");
            debugBuffer.append("CarMark            ='").append(historyClaim.getLicenseNo          ()).append("',");
            debugBuffer.append("VehicleType        ='").append(historyClaim.getVehicleType        ()).append("',");
            debugBuffer.append("IsInsuredCar       ='").append(historyClaim.getIsInsuredCar       ()).append("',");
            debugBuffer.append("CoverageType       ='").append(historyClaim.getCoverageType       ()).append("',");
            debugBuffer.append("RegistNo           ='").append(historyClaim.getRegistNo           ()).append("',");
            debugBuffer.append("CLaimNo            ='").append(historyClaim.getClaimNo            ()).append("',");
            debugBuffer.append("PolicyNo           ='").append(historyClaim.getPolicyNo           ()).append("',");
            debugBuffer.append("DamageDate         ='").append(historyClaim.getAccidentTime       ()).append("',");
            debugBuffer.append("ReportDate         ='").append(historyClaim.getRegistTime         ()).append("',");
            debugBuffer.append("EndcaseDate        ='").append(historyClaim.getEndCaseTime        ()).append("',");
            debugBuffer.append("SumClaim           =") .append(historyClaim.getUnClaimAmount      ()).append(",");
            debugBuffer.append("SumPaid            =") .append(historyClaim.getClaimAmount        ()).append(",");
            debugBuffer.append("Status             ='").append(historyClaim.getCaseStatus         ()).append("',");
            debugBuffer.append("AccidentPlace      ='").append(historyClaim.getAccidentPlace      ()).append("',");
            debugBuffer.append("AccidentDescription='").append(historyClaim.getAccidentDesc       ()).append("',");
            debugBuffer.append("DutyCode           ='").append(historyClaim.getIndemnityDuty      ()).append("')");
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(historyClaim.getClaimCode()).append("'");
            debugBuffer.append("and serialNo=").append("").append(historyClaim.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }
        
        buffer.append("WHERE ");
        buffer.append("ClaimCode = ?,");
        buffer.append("SerialNo = ?");
        
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1 ,historyClaim.getClaimCode          ());
		dbManager.setInt(2 ,historyClaim.getSerialNo           ());
    	dbManager.setString(2 ,historyClaim.getLicenseNo          ());
    	dbManager.setString(3 ,historyClaim.getClaimCompany       ());
    	dbManager.setString(4 ,historyClaim.getLicenseNo          ());
    	dbManager.setString(5 ,historyClaim.getVehicleType        ());
    	dbManager.setString(6 ,historyClaim.getIsInsuredCar       ());
    	dbManager.setString(7 ,historyClaim.getCoverageType       ());
    	dbManager.setString(8 ,historyClaim.getRegistNo           ());
    	dbManager.setString(9 ,historyClaim.getClaimNo            ());
    	dbManager.setString(10,historyClaim.getPolicyNo           ());
    	dbManager.setDateTime(11,historyClaim.getAccidentTime       ());
    	dbManager.setDateTime(12,historyClaim.getRegistTime         ());
    	dbManager.setDateTime(13,historyClaim.getEndCaseTime        ());
    	dbManager.setDouble(14,historyClaim.getUnClaimAmount      ());
    	dbManager.setDouble(15,historyClaim.getClaimAmount        ());
    	dbManager.setString(16,historyClaim.getCaseStatus         ());
    	dbManager.setString(17,historyClaim.getAccidentPlace      ());
    	dbManager.setString(18,historyClaim.getAccidentDesc       ());
    	dbManager.setString(19,historyClaim.getIndemnityDuty      ());
        //设置条件字段;
        dbManager.setString(20,historyClaim.getClaimCode());
        dbManager.setInt(21,historyClaim.getSerialNo());
        dbManager.executePreparedUpdate();
    }
    /**
     * 按主键查找一条数据
     * @param claimNo 理赔编码
     * @param serialNo 序号
     * @return HistoryClaim
     * @throws Exception
     */
    public HistoryClaim findByPrimaryKey(String claimCode,int serialNo)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
    	//拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimCode           ,");
    	buffer.append("SerialNo            ,");
    	buffer.append("LicenseNo           ,");
    	buffer.append("ClaimCompany        ,");
    	buffer.append("CarMark             ,");
    	buffer.append("VehicleType         ,");
    	buffer.append("IsInsuredCar        ,");
    	buffer.append("CoverageType        ,");
    	buffer.append("RegistNo            ,");
    	buffer.append("CLaimNo             ,");
    	buffer.append("PolicyNo            ,");
    	buffer.append("DamageDate          ,");
    	buffer.append("ReportDate          ,");
    	buffer.append("EndcaseDate         ,");
    	buffer.append("SumClaim            ,");
    	buffer.append("SumPaid             ,");
    	buffer.append("Status              ,");
    	buffer.append("AccidentPlace       ,");
    	buffer.append("AccidentDescription ,");
    	buffer.append("DutyCode             ");
    	buffer.append("FROM CIClaimHistory ");
    	if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(claimCode).append("'");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

    	 buffer.append("WHERE ");
         buffer.append("ClaimCode = ?,");
         buffer.append("SerialNo = ?");
         
         dbManager.prepareStatement(buffer.toString());
         //设置条件字段;
         dbManager.setString(1,claimCode);
         dbManager.setInt(2,serialNo);
         ResultSet resultSet = dbManager.executePreparedQuery();
         HistoryClaim historyClaim = null;
         if(resultSet.next()){
        	 historyClaim = new HistoryClaim();
        	 historyClaim.setClaimCode          (dbManager.getString(resultSet,1 ));
        	 historyClaim.setLicenseNo          (dbManager.getString(resultSet,2 ));
        	 historyClaim.setClaimCompany       (dbManager.getString(resultSet,3 ));
        	 historyClaim.setLicenseNo          (dbManager.getString(resultSet,4 ));
        	 historyClaim.setVehicleType        (dbManager.getString(resultSet,5 ));
        	 historyClaim.setIsInsuredCar       (dbManager.getString(resultSet,6 ));
        	 historyClaim.setCoverageType       (dbManager.getString(resultSet,7 ));
        	 historyClaim.setRegistNo           (dbManager.getString(resultSet,8 ));
        	 historyClaim.setClaimNo            (dbManager.getString(resultSet,9 ));
        	 historyClaim.setPolicyNo           (dbManager.getString(resultSet,10));
        	 historyClaim.setAccidentTime       (dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,11));
        	 historyClaim.setRegistTime         (dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,12));
        	 historyClaim.setEndCaseTime        (dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,13));
        	 historyClaim.setUnClaimAmount      (dbManager.getDouble(resultSet,14));
        	 historyClaim.setClaimAmount        (dbManager.getDouble(resultSet,15));
        	 historyClaim.setCaseStatus         (dbManager.getString(resultSet,16));
        	 historyClaim.setAccidentPlace      (dbManager.getString(resultSet,17));
        	 historyClaim.setAccidentDesc       (dbManager.getString(resultSet,18));
        	 historyClaim.setIndemnityDuty      (dbManager.getString(resultSet,19));
         }
         if(resultSet != null){
        	 resultSet.close();
         }
         return historyClaim;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimCode           ,");
    	buffer.append("SerialNo            ,");
    	buffer.append("LicenseNo           ,");
    	buffer.append("ClaimCompany        ,");
    	buffer.append("CarMark             ,");
    	buffer.append("VehicleType         ,");
    	buffer.append("IsInsuredCar        ,");
    	buffer.append("CoverageType        ,");
    	buffer.append("RegistNo            ,");
    	buffer.append("CLaimNo             ,");
    	buffer.append("PolicyNo            ,");
    	buffer.append("DamageDate          ,");
    	buffer.append("ReportDate          ,");
    	buffer.append("EndcaseDate         ,");
    	buffer.append("SumClaim            ,");
    	buffer.append("SumPaid             ,");
    	buffer.append("Status              ,");
    	buffer.append("AccidentPlace       ,");
    	buffer.append("AccidentDescription ,");
    	buffer.append("DutyCode             ");
    	buffer.append("FROM CIClaimHistory ");
    	buffer.append(conditions);
    	if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }
      //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        HistoryClaim historyClaim = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }
            historyClaim = new HistoryClaim();
            
            historyClaim.setClaimCode(dbManager.getString(resultSet, 1));
			historyClaim.setLicenseNo(dbManager.getString(resultSet, 2));
			historyClaim.setClaimCompany(dbManager.getString(resultSet, 3));
			historyClaim.setLicenseNo(dbManager.getString(resultSet, 4));
			historyClaim.setVehicleType(dbManager.getString(resultSet, 5));
			historyClaim.setIsInsuredCar(dbManager.getString(resultSet, 6));
			historyClaim.setCoverageType(dbManager.getString(resultSet, 7));
			historyClaim.setRegistNo(dbManager.getString(resultSet, 8));
			historyClaim.setClaimNo(dbManager.getString(resultSet, 9));
			historyClaim.setPolicyNo(dbManager.getString(resultSet, 10));
			historyClaim.setAccidentTime(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, 11));
			historyClaim.setRegistTime(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, 12));
			historyClaim.setEndCaseTime(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, 13));
			historyClaim.setUnClaimAmount(dbManager.getDouble(resultSet, 14));
			historyClaim.setClaimAmount(dbManager.getDouble(resultSet, 15));
			historyClaim.setCaseStatus(dbManager.getString(resultSet, 16));
			historyClaim.setAccidentPlace(dbManager.getString(resultSet, 17));
			historyClaim.setAccidentDesc(dbManager.getString(resultSet, 18));
			historyClaim.setIndemnityDuty(dbManager.getString(resultSet, 19));
            
            collection.add(historyClaim);
        }
        resultSet.close();
        return collection;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }
    
    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception {
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("DELETE FROM CIClaimHistory WHERE ");
		buffer.append(conditions);
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		int count = dbManager.executeUpdate(buffer.toString());
		return count;
	}
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("SELECT count(*) FROM CIClaimHistory WHERE ");
		buffer.append(conditions);
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		resultSet.next();
		count = dbManager.getInt(resultSet, 1);
		resultSet.close();
		return count;
	}
    
    
}
