package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLearBase {
	 /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLearBase.class);
    
	public DBPrpLearBase(DBManager dbManager) {
		this.dbManager = dbManager;
	}
    
	public void insert(PrpLearDto earDto)throws Exception {
		
		 StringBuffer buffer = new StringBuffer(200);
	        buffer.append("INSERT INTO PrpLear (");
	        buffer.append("policyNo,");
	        buffer.append("earNo,");
	        buffer.append("registNo,");
	        buffer.append("insuredName,");
	        buffer.append("validStatus");
	        buffer.append(") ");
	        if(logger.isDebugEnabled()){
	            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
	            debugBuffer.append(buffer.toString());
	            debugBuffer.append("VALUES(");
	            debugBuffer.append("'").append(earDto.getPolicyNo()).append("',");
	            debugBuffer.append("'").append(earDto.getEarNo()).append("',");
	            debugBuffer.append("'").append(earDto.getRegistNo()).append("',");
	            debugBuffer.append("'").append(earDto.getInsuredName()).append("',");
	            debugBuffer.append("'").append(earDto.getValidStatus()).append("',");
	            logger.debug(debugBuffer.toString());
	        }
	        buffer.append("VALUES(?,?,?,?,?)");
	        dbManager.prepareStatement(buffer.toString());
	        dbManager.setString(1,earDto.getPolicyNo());
	        dbManager.setString(2,earDto.getEarNo());
	        dbManager.setString(3,earDto.getRegistNo());
	        dbManager.setString(4,earDto.getInsuredName());
	        dbManager.setString(5,earDto.getValidStatus());
	        dbManager.executePreparedUpdateBatch();
	        
	        logger.info("earDto insert Success!");
	}
	
	// 插入一条数据
	public void insertAll(Collection collection) throws Exception{
		 StringBuffer buffer = new StringBuffer(200);
	        buffer.append("INSERT INTO PrpLear (");
	        buffer.append("policyNo,");
	        buffer.append("earNo,");
	        buffer.append("registNo,");
	        buffer.append("insuredName,");
	        buffer.append("validStatus");
	        buffer.append(") ");
	        buffer.append("VALUES(?,?,?,?,?)");
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        dbManager.prepareStatement(buffer.toString());
	        for (Iterator i = collection.iterator(); i.hasNext();) {
	            PrpLearDto prpLearDto = (PrpLearDto)i.next();
		        dbManager.setString(1,prpLearDto.getPolicyNo());
		        dbManager.setString(2,prpLearDto.getEarNo());
		        dbManager.setString(3,prpLearDto.getRegistNo());
		        dbManager.setString(4,prpLearDto.getInsuredName());
		        dbManager.setString(5,prpLearDto.getValidStatus());
		        dbManager.addBatch();
	        }
		        dbManager.executePreparedUpdateBatch();
		        logger.info("DBPrpLearBase insertAll Success!");
	}

	 /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLear ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
    }
    
    public void update(PrpLearDto earDto)throws Exception{
		 StringBuffer buffer = new StringBuffer(200);
	        buffer.append("UPDATE PrpLear SET ");
	        buffer.append("earNo = ?, ");
	        buffer.append("insuredName = ?, ");
	        buffer.append("policyNo = ?, ");
	        buffer.append("validStatus = ? ");
	        buffer.append("WHERE ");
	        buffer.append("registNo = ?");
	        buffer.append("AND earNo = ?");
	        dbManager.prepareStatement(buffer.toString());
	        //设置更新字段;
	        dbManager.setString(1,earDto.getEarNo());
	        dbManager.setString(2,earDto.getInsuredName());
	        dbManager.setString(3,earDto.getPolicyNo());
	        dbManager.setString(4,earDto.getValidStatus());
	        //设置查询条件
	        dbManager.setString(5,earDto.getRegistNo());
	        dbManager.setString(6,earDto.getEarNo());
		dbManager.executePreparedUpdate();
		logger.info("DBEar update Success!");
		
	}
    
    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @return PrpLclaimDto
     * @throws Exception
     */
    public PrpLearDto findByRegistNo(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("policyNo,");
        buffer.append("earNo,");
        buffer.append("registNo,");
        buffer.append("insuredName,");
        buffer.append("validStatus");
        buffer.append("FROM PrpLear ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLearDto prpLearDto = null;
        if(resultSet.next()){
        	prpLearDto = new PrpLearDto();
        	prpLearDto.setPolicyNo(dbManager.getString(resultSet,1));
        	prpLearDto.setEarNo(dbManager.getString(resultSet,2));
        	prpLearDto.setRegistNo(dbManager.getString(resultSet,3));
        	prpLearDto.setInsuredName(dbManager.getString(resultSet,4));
        	prpLearDto.setValidStatus(dbManager.getString(resultSet,5));
        }else{
            logger.info("DBPrpLearBase.findByRegistNo() failure!");
        }
        resultSet.close();
        return prpLearDto;
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
        buffer.append("policyNo,");
        buffer.append("earNo,");
        buffer.append("registNo,");
        buffer.append("insuredName,");
        buffer.append("validStatus");
        buffer.append(" FROM PrpLear WHERE ");
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
        PrpLearDto prpLearDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLearDto = new PrpLearDto();
            prpLearDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpLearDto.setEarNo(dbManager.getString(resultSet,2));
            prpLearDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLearDto.setInsuredName(dbManager.getString(resultSet,4));
            prpLearDto.setValidStatus(dbManager.getString(resultSet,5));
            collection.add(prpLearDto);
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
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLear WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
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
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        
       String  statement ;
           statement = "SELECT count(1) FROM PrpLear WHERE ";
             statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }

}
