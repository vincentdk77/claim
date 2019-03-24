package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * 这是PLANTINGPOLICYLIST的数据访问对象类<br>
 * 创建于 2011-11-01 17:13:56.406<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlantingpolicylist extends DBPlantingpolicylistBase{
    private static Logger logger = Logger.getLogger(DBPlantingpolicylist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlantingpolicylist(DBManager dbManager){
        super(dbManager);
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getPlantingCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(400);
        buffer.append(" SELECT count(*) FROM (SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Plantingpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Planting31policylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM nyxpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
    " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
        buffer.append(conditions);
        buffer.append(")");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try
        {
	        resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        count = dbManager.getInt(resultSet,1);
	        resultSet.close();
	        return count;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }
        
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findPlantingByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
	    	StringBuffer buffer = new StringBuffer(400);
	        //拼SQL语句
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM Plantingpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        buffer.append(" union ");
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM Planting31policylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        buffer.append(" union ");
	        buffer.append("SELECT distinct ");
	    	buffer.append("a.PolicyNo,");
	    	//buffer.append("b.LicenseNo,");
	    	buffer.append("a.InsuredName,");
	    	buffer.append("a.StartDate,");
	    	buffer.append("a.EndDate,");
	    	//buffer.append("b.BrandName,");
	    	buffer.append("a.OthFlag,");
	    	buffer.append("a.riskcode,");
	    	buffer.append("a.classcode,");
	    	buffer.append("a.sumquantity,");
	    	buffer.append("a.flag,");
	    	buffer.append("a.underwriteflag ");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	
	        buffer.append("FROM nyxpolicylist d,insuremainlist e ,PrpCmain@sinodb a ,uticodetransfer@sinodb c" +
	        		" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
	        buffer.append(conditions);
	        boolean supportPaging = false;//数据库是否支持分页
	        if (pageNo > 0){
	            //对Oracle优化
	            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
	                supportPaging=true;
	            }
	            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
	                String sql = buffer.toString();
	                buffer.setLength(0);
	                buffer.append("select * from ( select rownumber() over(");
	                int orderByIndex = sql.toLowerCase().indexOf("order by");
	                if ( orderByIndex>0 ) {
	                   buffer.append( sql.substring(orderByIndex) );
	                }
	                buffer.append(") as rownumber_,");
	                buffer.append(sql.substring( 6 ));
	                buffer.append(" ) as temp_ where rownumber_");
	                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
	                supportPaging=true;
	            }
	        }
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = null;
	        try
	        {
		        resultSet = dbManager.executeQuery(buffer.toString());
		        int count=0;
		        if(supportPaging==false && pageNo>1){
		            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		        }
		
		        //定义返回结果集合
		        Collection collection = new ArrayList(rowsPerPage);
		        HerdpolicylistDto herdpolicylistDto = null;
		        while(resultSet.next()){
		            if (supportPaging == false && pageNo>0) {
		                count++;
		                if(count > rowsPerPage){
		                    break;
		                }
		            }
		
		            herdpolicylistDto = new HerdpolicylistDto();
		            PrpCmainDto prpCmainDto = new PrpCmainDto();
					prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
					//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
					prpCmainDto.setInsuredName(dbManager.getString(resultSet,2));
					prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
					prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
					//prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
					//添加保单是否已经注销标志
					prpCmainDto.setOthFlag(dbManager.getString(resultSet,5));
					prpCmainDto.setRiskCode( dbManager.getString(resultSet,6));
					prpCmainDto.setClassCode( dbManager.getString(resultSet,7));
					 //add by guolei  20070519 增加团单
		            if(dbManager.getString(resultSet,9).length()>=2){
		            	prpCmainDto.setInsuredName(dbManager.getString(resultSet,2)+"等"+dbManager.getString(resultSet,8)+"人");	
		            }
		            //添加见费出单的标志
		            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 10));
		            //增加车牌号码
		            //prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
					///////////////////////////////////////////////////////////////////////////////////////
		           
		            collection.add(prpCmainDto);
		        }
		        resultSet.close();
		        return collection;
	        }
	        catch(Exception exception){
	            resultSet.close();
	            throw exception;
	        }
	        finally{
	        	resultSet.close();
	        }
	        
    }
    /**
     * 新农险，种植险条数查询方法
     * @param conditions
     * @return
     * @throws Exception
     */
    public int getNewPlantingCount(String conditions) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(400);
		buffer
				.append(" SELECT count(*) FROM (SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Plantingpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer
				.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM Planting31policylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer
				.append("union SELECT distinct a.PolicyNo,a.InsuredName,a.StartDate,a.EndDate,a.OthFlag,a.riskcode,a.classcode,a.sumquantity,a.flag,a.underwriteflag   FROM nyxpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY ='2' and d.VALIDITY ='1' and ");
		buffer.append(conditions);
		buffer.append(")");
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		System.err.println(buffer.toString());
		ResultSet resultSet = null;
		try {
			resultSet = dbManager.executeQuery(buffer.toString());
			resultSet.next();
			count = dbManager.getInt(resultSet, 1);
			resultSet.close();
			return count;
		} catch (Exception exception) {
			resultSet.close();
			throw exception;
		} finally {
			resultSet.close();
		}

	}
    /**
     * 新农险，种植险查询方法
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findNewPlantingByConditions(String conditions,
			int pageNo, int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(400);
		//拼SQL语句
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM Plantingpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		buffer.append(" union ");
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM Planting31policylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		buffer.append(" union ");
		buffer.append("SELECT distinct ");
		buffer.append("a.PolicyNo,");
		//buffer.append("b.LicenseNo,");
		buffer.append("a.InsuredName,");
		buffer.append("a.StartDate,");
		buffer.append("a.EndDate,");
		//buffer.append("b.BrandName,");
		buffer.append("a.OthFlag,");
		buffer.append("a.riskcode,");
		buffer.append("a.classcode,");
		buffer.append("a.sumquantity,");
		buffer.append("a.flag,");
		buffer.append("a.underwriteflag ");
		//buffer.append("b.licenseno,");
		////////////////////

		buffer
				.append("FROM nyxpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e ,PrpCmain a ,uticodetransfer c"
						+ " WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY= '2' and d.VALIDITY= '1' and ");
		buffer.append(conditions);
		System.err.print(buffer.toString());
		boolean supportPaging = false;//数据库是否支持分页
		if (pageNo > 0) {
			//对Oracle优化
			if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
				buffer.insert(0,
						"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
				buffer.append(") row_ WHERE rownum <= " + rowsPerPage * pageNo
						+ ") WHERE rownum_ > " + rowsPerPage * (pageNo - 1));
				supportPaging = true;
			} else if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("DB2")) {
				String sql = buffer.toString();
				buffer.setLength(0);
				buffer.append("select * from ( select rownumber() over(");
				int orderByIndex = sql.toLowerCase().indexOf("order by");
				if (orderByIndex > 0) {
					buffer.append(sql.substring(orderByIndex));
				}
				buffer.append(") as rownumber_,");
				buffer.append(sql.substring(6));
				buffer.append(" ) as temp_ where rownumber_");
				buffer.append(" between " + (rowsPerPage * (pageNo - 1) + 1)
						+ " and " + rowsPerPage * pageNo);
				supportPaging = true;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = null;
		try {
			resultSet = dbManager.executeQuery(buffer.toString());
			int count = 0;
			if (supportPaging == false && pageNo > 1) {
				dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
			}

			//定义返回结果集合
			Collection collection = new ArrayList(rowsPerPage);
			HerdpolicylistDto herdpolicylistDto = null;
			while (resultSet.next()) {
				if (supportPaging == false && pageNo > 0) {
					count++;
					if (count > rowsPerPage) {
						break;
					}
				}

				herdpolicylistDto = new HerdpolicylistDto();
				PrpCmainDto prpCmainDto = new PrpCmainDto();
				prpCmainDto.setPolicyNo(dbManager.getString(resultSet, 1));
				//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
				prpCmainDto.setInsuredName(dbManager.getString(resultSet, 2));
				prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 3));
				prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 4));
				//prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
				//添加保单是否已经注销标志
				prpCmainDto.setOthFlag(dbManager.getString(resultSet, 5));
				prpCmainDto.setRiskCode(dbManager.getString(resultSet, 6));
				prpCmainDto.setClassCode(dbManager.getString(resultSet, 7));
				//add by guolei  20070519 增加团单
				if (dbManager.getString(resultSet, 9).length() >= 2) {
					prpCmainDto.setInsuredName(dbManager
							.getString(resultSet, 2)
							+ "等" + dbManager.getString(resultSet, 8) + "人");
				}
				//添加见费出单的标志
				prpCmainDto.setUnderWriteFlag(dbManager
						.getString(resultSet, 10));
				//增加车牌号码
				//prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
				///////////////////////////////////////////////////////////////////////////////////////

				collection.add(prpCmainDto);
			}
			resultSet.close();
			return collection;
		} catch (Exception exception) {
			resultSet.close();
			throw exception;
		} finally {
			resultSet.close();
		}
	}
}
