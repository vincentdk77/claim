package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpendtrackDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * 这是PRPLRETURNVISITSWFLOG的数据访问对象类<br>
 * 创建于 2011-12-28 14:22:22.671<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplreturnvisitswflog extends DBPrplreturnvisitswflogBase{
    private static Logger logger = Logger.getLogger(DBPrplreturnvisitswflog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplreturnvisitswflog(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
	public int getCountQuery(String conditions) throws Exception {
		int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(Distinct(g.businessno)) FROM prplreturnvisitswflog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
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

	/**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
	public Collection findByQueryConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Distinct(g.Businessno),");
        buffer.append("g.Nodetype,");
        buffer.append("g.Registno,");
        buffer.append("g.Policyno,");
        buffer.append("g.Comcode,");
        buffer.append("g.Comcodename,");
        buffer.append("g.Insuredname,");
        buffer.append("g.Reportdate,");
        buffer.append("g.Ceasedate,");
        buffer.append("g.Licenseno,");
        buffer.append("g.Handlercode,");
        buffer.append("g.Handlername,");
        buffer.append("g.Handlercomcode,");
        buffer.append("g.Flowintotime,");
        buffer.append("g.Ceasetime,");
        buffer.append("g.Classcode,");
        buffer.append("c.bycomplaintcode,");
        buffer.append("c.bycomplaintcomcode,");
        buffer.append("c.complaintdate,");
        buffer.append("r.receivername,");
        buffer.append("r.Reportdate as stReportdate,");
        buffer.append("r.Reporthour,");
        buffer.append("g.State, ");
        buffer.append("g.RiskCode ");
        buffer.append("FROM prplreturnvisitswflog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_) WHERE rownum_ > "+rowsPerPage * (pageNo - 1)+" and rownum_ <= "+rowsPerPage * pageNo);
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }
        
        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
            prplreturnvisitswflogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            prplreturnvisitswflogDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplreturnvisitswflogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplreturnvisitswflogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplreturnvisitswflogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplreturnvisitswflogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
            prplreturnvisitswflogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
            prplreturnvisitswflogDto.setReportdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Reportdate"));
            prplreturnvisitswflogDto.setCeasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasedate"));
            prplreturnvisitswflogDto.setLicenseno(dbManager.getString(resultSet,"Licenseno"));
            prplreturnvisitswflogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplreturnvisitswflogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplreturnvisitswflogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
            prplreturnvisitswflogDto.setFlowintotime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Flowintotime"));
            prplreturnvisitswflogDto.setCeasetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasetime"));
            prplreturnvisitswflogDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplreturnvisitswflogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
            prplreturnvisitswflogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
            prplreturnvisitswflogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
            prplreturnvisitswflogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
            prplreturnvisitswflogDto.setStReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"stReportdate").toString());
            prplreturnvisitswflogDto.setStReportHour(dbManager.getString(resultSet,"Reporthour"));
            prplreturnvisitswflogDto.setState(dbManager.getString(resultSet,"State"));
            prplreturnvisitswflogDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            collection.add(prplreturnvisitswflogDto);
            
        }
        resultSet.close();
        return collection;
	}
	
	
	/**
     * 导出查询
     * add by zhangzhiqiang 20120914
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
	public Collection findByQueryExpConditions(String conditions, int pageNo,int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Distinct(g.Businessno),");
        buffer.append("g.Nodetype,");
        buffer.append("g.Registno,");
        buffer.append("g.Policyno,");
        buffer.append("g.Comcode,");
        buffer.append("g.Comcodename,");
        buffer.append("g.Insuredname,");
        buffer.append("g.Reportdate,");
        buffer.append("g.Ceasedate,");
        buffer.append("g.Licenseno,");
        buffer.append("g.Handlercode,");
        buffer.append("g.Handlername,");
        buffer.append("g.Handlercomcode,");
        buffer.append("g.Flowintotime,");
        buffer.append("g.Ceasetime,");
        buffer.append("g.Classcode,");
        buffer.append("c.bycomplaintcode,");
        buffer.append("c.bycomplaintcomcode,");
        buffer.append("c.complaintdate,");
        buffer.append("r.receivername,");
        buffer.append("g.State ");
        buffer.append("FROM prplreturnvisitswflog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        while(resultSet.next()){  
            prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
            prplreturnvisitswflogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            prplreturnvisitswflogDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplreturnvisitswflogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplreturnvisitswflogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplreturnvisitswflogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplreturnvisitswflogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
            prplreturnvisitswflogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
            prplreturnvisitswflogDto.setReportdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Reportdate"));
            prplreturnvisitswflogDto.setCeasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasedate"));
            prplreturnvisitswflogDto.setLicenseno(dbManager.getString(resultSet,"Licenseno"));
            prplreturnvisitswflogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplreturnvisitswflogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplreturnvisitswflogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
            prplreturnvisitswflogDto.setFlowintotime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Flowintotime"));
            prplreturnvisitswflogDto.setCeasetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasetime"));
            prplreturnvisitswflogDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplreturnvisitswflogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
            prplreturnvisitswflogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
            prplreturnvisitswflogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
            prplreturnvisitswflogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
            prplreturnvisitswflogDto.setState(dbManager.getString(resultSet,"State"));
            collection.add(prplreturnvisitswflogDto);
        }
        resultSet.close();
        return collection;
	}

	public Double findSumprepaidBySQL(String sql) throws Exception {
		 ResultSet resultSet = dbManager.executeQuery(sql);
		 if(logger.isDebugEnabled()){
	            logger.debug(sql);
	        }
		 Double sumprepaid = 0d;
		 while(resultSet.next()){
			 sumprepaid +=dbManager.getDouble(resultSet, 1);
		 }
		 resultSet.close();
		
		return sumprepaid;
	}
	/**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @thro	ws Exception
     */
	public Collection findByQueryConditionsEndca(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Distinct(g.Businessno),");
        buffer.append("g.Nodetype,");
        buffer.append("g.Registno,");
        buffer.append("g.Policyno,");
        buffer.append("g.Comcode,");
        buffer.append("g.Comcodename,");
        buffer.append("g.Insuredname,");
        buffer.append("g.Reportdate,");
        buffer.append("g.Ceasedate,");
        buffer.append("g.Licenseno,");
        buffer.append("g.Handlercode,");
        buffer.append("g.Handlername,");
        buffer.append("g.Handlercomcode,");
        buffer.append("g.Flowintotime,");
        buffer.append("g.Ceasetime,");
        buffer.append("g.Classcode,");
        buffer.append("c.bycomplaintcode,");
        buffer.append("c.bycomplaintcomcode,");
        buffer.append("c.complaintdate,");
        buffer.append("r.receivername,");
        buffer.append("r.Reportdate as stReportdate,");
        buffer.append("r.Reporthour,");
        buffer.append("g.State ,");
        buffer.append(" (select min(f.payrefdate) ");
        buffer.append("   from prpjpayrefrec f ");
        buffer.append("   where 1 = 1 ");
        buffer.append("   and f.certitype in ('C', 'Y') ");
        buffer.append("   and f.payrefreason in ('P50', 'P60') ");
        buffer.append("      and exists (select 1 ");
        buffer.append("      from prplclaim l ");
        buffer.append("         where f.claimno = l.claimno ");
        buffer.append("    and l.registno = g.registno)) as payrefdate  ");
        buffer.append("FROM prplreturnvisitswflog g Left Join prplregistrpolicy y On g.registno=y.registno Left Join prplComplaint c On g.businessno=c.complaintno Left Join prplregist r On g.Businessno = r.registNo WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_) WHERE rownum_ > "+rowsPerPage * (pageNo - 1)+" and rownum_ <= "+rowsPerPage * pageNo);
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }
        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }
            prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
            prplreturnvisitswflogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            prplreturnvisitswflogDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplreturnvisitswflogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplreturnvisitswflogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplreturnvisitswflogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplreturnvisitswflogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
            prplreturnvisitswflogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
            prplreturnvisitswflogDto.setReportdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Reportdate"));
            prplreturnvisitswflogDto.setCeasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasedate"));
            prplreturnvisitswflogDto.setLicenseno(dbManager.getString(resultSet,"Licenseno"));
            prplreturnvisitswflogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplreturnvisitswflogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplreturnvisitswflogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
            prplreturnvisitswflogDto.setFlowintotime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Flowintotime"));
            prplreturnvisitswflogDto.setCeasetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Ceasetime"));
            prplreturnvisitswflogDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplreturnvisitswflogDto.setBycomplaintcode(dbManager.getString(resultSet,"bycomplaintcode"));
            prplreturnvisitswflogDto.setBycomplaintcomcode(dbManager.getString(resultSet,"bycomplaintcomcode"));
            prplreturnvisitswflogDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"complaintdate").toString());
            prplreturnvisitswflogDto.setReceivername(dbManager.getString(resultSet,"receivername"));
            prplreturnvisitswflogDto.setStReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"stReportdate").toString());
            prplreturnvisitswflogDto.setStReportHour(dbManager.getString(resultSet,"Reporthour"));
            prplreturnvisitswflogDto.setState(dbManager.getString(resultSet,"State"));
            collection.add(prplreturnvisitswflogDto);
        }
        resultSet.close();
        return collection;
	}
	
	
}
