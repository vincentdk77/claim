package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息平台返回的三者车赔付信息的数据访问对象基类
 * 创建于 2010-03-30
 */
public class DBCIClaimThirdCarbase {
	 /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimThirdCarbase.class);
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimThirdCarbase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param CIClaimThirdCarDto ciClaimThirdCarDto
     * @throws Exception
     */
    public void insert(CIClaimThirdCarDto ciClaimThirdCarDto)throws Exception{
    	 StringBuffer buffer = new StringBuffer(200);
    	 buffer.append("INSERT INTO CIClaimThirdCar (");
    	 buffer.append("ClaimCode     ,");
    	 buffer.append("SerialNo      ,");
    	 buffer.append("PolicyNo      ,");
    	 buffer.append("ThirdClaimCode,");
    	 buffer.append("CarMark       ,");
    	 buffer.append("VehicleType   ,");
    	 buffer.append("ClaimCompany  ,");
    	 buffer.append("ClaimStatus   ,");
    	 buffer.append("PaySelfFlag   ,");
    	 buffer.append("RegistNo      ,");
    	 buffer.append("ClaimNo       ,");
    	 buffer.append("AccidentDate  ,");
    	 buffer.append("AccidentPlace ,");
    	 buffer.append("SumPaid       )");
    	 if(logger.isDebugEnabled()){
    		 StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
             debugBuffer.append(buffer.toString());
             debugBuffer.append("VALUES(");
             debugBuffer.append("ClaimCode     ='").append(ciClaimThirdCarDto.getClaimCode      ()).append("',");
             debugBuffer.append("SerialNo      =").append(ciClaimThirdCarDto.getSerialNo       ()).append(",");
             debugBuffer.append("PolicyNo      ='").append(ciClaimThirdCarDto.getPolicyNo       ()).append("',");
             debugBuffer.append("ThirdClaimCode='").append(ciClaimThirdCarDto.getThirdClaimCode ()).append("',");
             debugBuffer.append("CarMark       ='").append(ciClaimThirdCarDto.getCarMark        ()).append("',");
             debugBuffer.append("VehicleType   ='").append(ciClaimThirdCarDto.getVehicleType    ()).append("',");
             debugBuffer.append("ClaimCompany  ='").append(ciClaimThirdCarDto.getClaimCompany   ()).append("',");
             debugBuffer.append("ClaimStatus   ='").append(ciClaimThirdCarDto.getClaimStatus    ()).append("',");
             debugBuffer.append("PaySelfFlag   ='").append(ciClaimThirdCarDto.getPaySelfFlag    ()).append("',");
             debugBuffer.append("RegistNo      ='").append(ciClaimThirdCarDto.getRegistNo       ()).append("',");
             debugBuffer.append("ClaimNo       ='").append(ciClaimThirdCarDto.getClaimNo        ()).append("',");
             debugBuffer.append("AccidentDate  ='").append(ciClaimThirdCarDto.getAccidentDate   ()).append("',");
             debugBuffer.append("AccidentPlace ='").append(ciClaimThirdCarDto.getAccidentPlace  ()).append("',");
             debugBuffer.append("SumPaid       =") .append(ciClaimThirdCarDto.getSumPaid        ()).append(")");
             logger.debug(debugBuffer.toString());
    	 }
    	 buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	 dbManager.prepareStatement(buffer.toString());
    	 dbManager.setString(1 ,ciClaimThirdCarDto.getClaimCode      ());
    	 dbManager.setInt(2 ,ciClaimThirdCarDto.getSerialNo       ());
    	 dbManager.setString(3 ,ciClaimThirdCarDto.getPolicyNo       ());
    	 dbManager.setString(4 ,ciClaimThirdCarDto.getThirdClaimCode ());
    	 dbManager.setString(5 ,ciClaimThirdCarDto.getCarMark        ());
    	 dbManager.setString(6 ,ciClaimThirdCarDto.getVehicleType    ());
    	 dbManager.setString(7 ,ciClaimThirdCarDto.getClaimCompany   ());
    	 dbManager.setString(8 ,ciClaimThirdCarDto.getClaimStatus    ());
    	 dbManager.setString(9 ,ciClaimThirdCarDto.getPaySelfFlag    ());
    	 dbManager.setString(10,ciClaimThirdCarDto.getRegistNo       ());
    	 dbManager.setString(11,ciClaimThirdCarDto.getClaimNo        ());
    	 dbManager.setDateTime(12,ciClaimThirdCarDto.getAccidentDate   ());
    	 dbManager.setString(13,ciClaimThirdCarDto.getAccidentPlace  ());
    	 dbManager.setDouble(14,ciClaimThirdCarDto.getSumPaid        ());
    	 
    	 dbManager.executePreparedUpdate();
    }
    
    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIClaimThirdCar (");
        buffer.append("ClaimCode     ,");
   	    buffer.append("SerialNo      ,");
		buffer.append("PolicyNo      ,");
		buffer.append("ThirdClaimCode,");
		buffer.append("CarMark       ,");
		buffer.append("VehicleType   ,");
		buffer.append("ClaimCompany  ,");
		buffer.append("ClaimStatus   ,");
		buffer.append("PaySelfFlag   ,");
		buffer.append("RegistNo      ,");
		buffer.append("ClaimNo       ,");
		buffer.append("AccidentDate  ,");
		buffer.append("AccidentPlace ,");
		buffer.append("SumPaid        ");
		buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	CIClaimThirdCarDto ciClaimThirdCarDto = (CIClaimThirdCarDto)i.next();
        	dbManager.setString(1 ,ciClaimThirdCarDto.getClaimCode      ());
       	    dbManager.setInt(2, ciClaimThirdCarDto.getSerialNo());
			dbManager.setString(3, ciClaimThirdCarDto.getPolicyNo());
			dbManager.setString(4, ciClaimThirdCarDto.getThirdClaimCode());
			dbManager.setString(5, ciClaimThirdCarDto.getCarMark());
			dbManager.setString(6, ciClaimThirdCarDto.getVehicleType());
			dbManager.setString(7, ciClaimThirdCarDto.getClaimCompany());
			dbManager.setString(8, ciClaimThirdCarDto.getClaimStatus());
			dbManager.setString(9, ciClaimThirdCarDto.getPaySelfFlag());
			dbManager.setString(10, ciClaimThirdCarDto.getRegistNo());
			dbManager.setString(11, ciClaimThirdCarDto.getClaimNo());
			dbManager.setDateTime(12, ciClaimThirdCarDto.getAccidentDate());
			dbManager.setString(13, ciClaimThirdCarDto.getAccidentPlace());
			dbManager.setDouble(14, ciClaimThirdCarDto.getSumPaid());
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
    public void delete(String claimCode,int serialNo) throws Exception{
    	StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimThirdCar ");
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
     * @param CIClaimThirdCarDto ciClaimThirdCarDto
     * @throws Exception
     */
    public void update(CIClaimThirdCarDto ciClaimThirdCarDto)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimThirdCar SET ");
        buffer.append("ClaimCode     =?,");
        buffer.append("SerialNo      =?,");
        buffer.append("PolicyNo      =?,");
        buffer.append("ThirdClaimCode=?,");
        buffer.append("CarMark       =?,");
        buffer.append("VehicleType   =?,");
        buffer.append("ClaimCompany  =?,");
        buffer.append("ClaimStatus   =?,");
        buffer.append("PaySelfFlag   =?,");
        buffer.append("RegistNo      =?,");
        buffer.append("ClaimNo       =?,");
        buffer.append("AccidentDate  =?,");
        buffer.append("AccidentPlace =?,");
        buffer.append("SumPaid       =?");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimHistory SET ");
            debugBuffer.append("ClaimCode     ='").append(ciClaimThirdCarDto.getClaimCode      ()).append("',");
            debugBuffer.append("SerialNo      =").append(ciClaimThirdCarDto.getSerialNo       ()).append(",");
            debugBuffer.append("PolicyNo      ='").append(ciClaimThirdCarDto.getPolicyNo       ()).append("',");
            debugBuffer.append("ThirdClaimCode='").append(ciClaimThirdCarDto.getThirdClaimCode ()).append("',");
            debugBuffer.append("CarMark       ='").append(ciClaimThirdCarDto.getCarMark        ()).append("',");
            debugBuffer.append("VehicleType   ='").append(ciClaimThirdCarDto.getVehicleType    ()).append("',");
            debugBuffer.append("ClaimCompany  ='").append(ciClaimThirdCarDto.getClaimCompany   ()).append("',");
            debugBuffer.append("ClaimStatus   ='").append(ciClaimThirdCarDto.getClaimStatus    ()).append("',");
            debugBuffer.append("PaySelfFlag   ='").append(ciClaimThirdCarDto.getPaySelfFlag    ()).append("',");
            debugBuffer.append("RegistNo      ='").append(ciClaimThirdCarDto.getRegistNo       ()).append("',");
            debugBuffer.append("ClaimNo       ='").append(ciClaimThirdCarDto.getClaimNo        ()).append("',");
            debugBuffer.append("AccidentDate  ='").append(ciClaimThirdCarDto.getAccidentDate   ()).append("',");
            debugBuffer.append("AccidentPlace ='").append(ciClaimThirdCarDto.getAccidentPlace  ()).append("',");
            debugBuffer.append("SumPaid       =") .append(ciClaimThirdCarDto.getSumPaid        ()).append("");
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(ciClaimThirdCarDto.getClaimCode()).append("'");
            debugBuffer.append("and serialNo=").append("").append(ciClaimThirdCarDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }
        buffer.append("WHERE ");
        buffer.append("ClaimCode = ?,");
        buffer.append("SerialNo = ?");
        
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1 ,ciClaimThirdCarDto.getClaimCode      ());
   	    dbManager.setInt(2, ciClaimThirdCarDto.getSerialNo());
		dbManager.setString(3, ciClaimThirdCarDto.getPolicyNo());
		dbManager.setString(4, ciClaimThirdCarDto.getThirdClaimCode());
		dbManager.setString(5, ciClaimThirdCarDto.getCarMark());
		dbManager.setString(6, ciClaimThirdCarDto.getVehicleType());
		dbManager.setString(7, ciClaimThirdCarDto.getClaimCompany());
		dbManager.setString(8, ciClaimThirdCarDto.getClaimStatus());
		dbManager.setString(9, ciClaimThirdCarDto.getPaySelfFlag());
		dbManager.setString(10, ciClaimThirdCarDto.getRegistNo());
		dbManager.setString(11, ciClaimThirdCarDto.getClaimNo());
		dbManager.setDateTime(12, ciClaimThirdCarDto.getAccidentDate());
		dbManager.setString(13, ciClaimThirdCarDto.getAccidentPlace());
		dbManager.setDouble(14, ciClaimThirdCarDto.getSumPaid());
		
		//设置条件字段;
        dbManager.setString(15,ciClaimThirdCarDto.getClaimCode());
        dbManager.setInt(16,ciClaimThirdCarDto.getSerialNo());
        dbManager.executePreparedUpdate();
    }
    
    /**
     * 按主键查找一条数据
     * @param claimNo 理赔编码
     * @param serialNo 序号
     * @return HistoryClaim
     * @throws Exception
     */
    public CIClaimThirdCarDto  findByPrimaryKey(String claimCode,int serialNo)throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
    	//拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimCode     ,");
   	    buffer.append("SerialNo      ,");
		buffer.append("PolicyNo      ,");
		buffer.append("ThirdClaimCode,");
		buffer.append("CarMark       ,");
		buffer.append("VehicleType   ,");
		buffer.append("ClaimCompany  ,");
		buffer.append("ClaimStatus   ,");
		buffer.append("PaySelfFlag   ,");
		buffer.append("RegistNo      ,");
		buffer.append("ClaimNo       ,");
		buffer.append("AccidentDate  ,");
		buffer.append("AccidentPlace ,");
		buffer.append("SumPaid        ");
		buffer.append("FROM CIClaimThirdCar ");
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
         CIClaimThirdCarDto ciClaimThirdCarDto = null;
         if(resultSet.next()){
        	 ciClaimThirdCarDto = new CIClaimThirdCarDto();
        	 ciClaimThirdCarDto.setClaimCode          (dbManager.getString(resultSet,1 ));
        	 ciClaimThirdCarDto.setSerialNo           (dbManager.getInt(resultSet,2 ));
        	 ciClaimThirdCarDto.setPolicyNo           (dbManager.getString(resultSet,3 ));
        	 ciClaimThirdCarDto.setThirdClaimCode     (dbManager.getString(resultSet,4 ));
        	 ciClaimThirdCarDto.setCarMark            (dbManager.getString(resultSet,5 ));
        	 ciClaimThirdCarDto.setVehicleType        (dbManager.getString(resultSet,6 ));
        	 ciClaimThirdCarDto.setClaimCompany       (dbManager.getString(resultSet,7 ));
        	 ciClaimThirdCarDto.setClaimStatus        (dbManager.getString(resultSet,8 ));
        	 ciClaimThirdCarDto.setPaySelfFlag        (dbManager.getString(resultSet,9 ));
        	 ciClaimThirdCarDto.setRegistNo           (dbManager.getString(resultSet,10));
        	 ciClaimThirdCarDto.setClaimNo            (dbManager.getString(resultSet,11));
        	 ciClaimThirdCarDto.setAccidentDate       (dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND , 12));
        	 ciClaimThirdCarDto.setAccidentPlace      (dbManager.getString(resultSet,13));
        	 ciClaimThirdCarDto.setSumPaid            (dbManager.getDouble(resultSet,14));
         }
         if(resultSet != null){
        	 resultSet.close();
         }
         return ciClaimThirdCarDto;
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
    	buffer.append("ClaimCode     ,");
   	    buffer.append("SerialNo      ,");
		buffer.append("PolicyNo      ,");
		buffer.append("ThirdClaimCode,");
		buffer.append("CarMark       ,");
		buffer.append("VehicleType   ,");
		buffer.append("ClaimCompany  ,");
		buffer.append("ClaimStatus   ,");
		buffer.append("PaySelfFlag   ,");
		buffer.append("RegistNo      ,");
		buffer.append("ClaimNo       ,");
		buffer.append("AccidentDate  ,");
		buffer.append("AccidentPlace ,");
		buffer.append("SumPaid        ");
		buffer.append("FROM CIClaimThirdCar ");
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
        CIClaimThirdCarDto ciClaimThirdCarDto = null;
        while(resultSet.next()){
        	count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }
            
            ciClaimThirdCarDto = new CIClaimThirdCarDto();
            ciClaimThirdCarDto.setClaimCode(dbManager.getString(resultSet, 1));
			ciClaimThirdCarDto.setSerialNo(dbManager.getInt(resultSet, 2));
			ciClaimThirdCarDto.setPolicyNo(dbManager.getString(resultSet, 3));
			ciClaimThirdCarDto.setThirdClaimCode(dbManager.getString(resultSet,
					4));
			ciClaimThirdCarDto.setCarMark(dbManager.getString(resultSet, 5));
			ciClaimThirdCarDto
					.setVehicleType(dbManager.getString(resultSet, 6));
			ciClaimThirdCarDto.setClaimCompany(dbManager
					.getString(resultSet, 7));
			ciClaimThirdCarDto
					.setClaimStatus(dbManager.getString(resultSet, 8));
			ciClaimThirdCarDto
					.setPaySelfFlag(dbManager.getString(resultSet, 9));
			ciClaimThirdCarDto.setRegistNo(dbManager.getString(resultSet, 10));
			ciClaimThirdCarDto.setClaimNo(dbManager.getString(resultSet, 11));
			ciClaimThirdCarDto.setAccidentDate(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, 12));
			ciClaimThirdCarDto.setAccidentPlace(dbManager.getString(resultSet,
					13));
			ciClaimThirdCarDto.setSumPaid(dbManager.getDouble(resultSet, 14));
			
			collection.add(ciClaimThirdCarDto);
        }
        if(resultSet != null){
        	resultSet.close();
        }
        
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
		buffer.append("DELETE FROM CIClaimThirdCar WHERE ");
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
		buffer.append("SELECT count(*) FROM CIClaimThirdCar WHERE ");
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
