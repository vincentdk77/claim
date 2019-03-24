package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;

/**
 * 这是PRPLFISCALMAINPAY的数据访问对象类<br>
 * 创建于 2014-07-18 08:47:18.468<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplfiscalpaymain extends DBPrplfiscalpaymainBase{
    private static Logger logger = Logger.getLogger(DBPrplfiscalpaymain.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplfiscalpaymain(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getPayQueryCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM (SELECT distinct PrpLfiscalpaymain.* FROM PrpLfiscalpaymain,prplfiscalpaydetail,prplregist WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
    public Collection findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT DISTINCT ");
        buffer.append("PrpLfiscalpaymain.fiscalno,");
        buffer.append("PrpLfiscalpaymain.registno,");
        buffer.append("PrpLfiscalpaymain.sumamount,");
        buffer.append("PrpLfiscalpaymain.operatorcode,");
        buffer.append("PrpLfiscalpaymain.inputdate,");
        buffer.append("PrpLfiscalpaymain.operatorcomcode ");
        buffer.append("FROM PrpLfiscalpaymain,prplfiscalpaydetail,prplregist WHERE ");
        buffer.append(conditions);
        buffer.append(" order by PrpLfiscalpaymain.inputdate desc ");
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
        PrplfiscalpaymainDto prplfiscalpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }
            prplfiscalpaymainDto = new PrplfiscalpaymainDto();
            prplfiscalpaymainDto.setFiscalno(dbManager.getString(resultSet,1));
            prplfiscalpaymainDto.setRegistno(dbManager.getString(resultSet,2));
            prplfiscalpaymainDto.setSumamount(dbManager.getDouble(resultSet,3));
            prplfiscalpaymainDto.setOperatorcode(dbManager.getString(resultSet,4));
            prplfiscalpaymainDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,5));
            prplfiscalpaymainDto.setOperatorcomcode(dbManager.getString(resultSet,6));
            collection.add(prplfiscalpaymainDto);
        }
        resultSet.close();
        return collection;
    }
    
    /**
     * 更新支付标记，
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void updateByKey(String fiscalno,String vflag,String status)
    throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplfiscalpaymain SET ");
        buffer.append("vflag = ?, ");
        buffer.append("status = ? ");
        buffer.append("WHERE ");
        //buffer.append("registno = ? And ");
        buffer.append("fiscalno = ? ");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,vflag);
        dbManager.setString(2,status);
        //设置条件字段;
        dbManager.setString(3,fiscalno);
        dbManager.executePreparedUpdate();
        
    }
    
    public Collection findPaybackByConditions(String conditions,int pageNo,int rowsPerPage)
	    throws Exception{
	StringBuffer buffer = new StringBuffer(200);
	//拼SQL语句
	buffer.append("SELECT DISTINCT ");
	buffer.append("PrpLfiscalpaymain.fiscalno,");
	buffer.append("PrpLfiscalpaymain.registno,");
	buffer.append("Prplfiscalpaydetail.payamount,");
	buffer.append("PrpLfiscalpaymain.operatorcode,");
	buffer.append("PrpLfiscalpaymain.inputdate,");
	buffer.append("PrpLfiscalpaymain.operatorcomcode, ");
	buffer.append("prplfiscalpaydetail.compensateno, ");
	buffer.append("Prplfiscalpaydetail.receiverfullname,");
	buffer.append("Prplfiscalpaydetail.identifynumber,");
	buffer.append("Prplfiscalpaydetail.insuredcode,");
	buffer.append("Prplfiscalpaydetail.bankaccount ");
	buffer.append("FROM PrpLfiscalpaymain,prplfiscalpaydetail,prplregist WHERE ");
	buffer.append(conditions);
	buffer.append(" order by PrpLfiscalpaymain.inputdate desc ");
	boolean supportPaging = false;//数据库是否支持分页
	if (pageNo > 0){
	    //目前只对Oracle优化
	    if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	        buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	        buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
	PrplfiscalpaymainDto prplfiscalpaymainDto = null;
	while(resultSet.next()){
	    if (supportPaging == false && pageNo>0) {
	        count++;
	        if(count > rowsPerPage){
	            break;
	        }
	    }
	    prplfiscalpaymainDto = new PrplfiscalpaymainDto();
	    prplfiscalpaymainDto.setFiscalno(dbManager.getString(resultSet,1));
	    prplfiscalpaymainDto.setRegistno(dbManager.getString(resultSet,2));
	    prplfiscalpaymainDto.setSumamount(dbManager.getDouble(resultSet,3));
	    prplfiscalpaymainDto.setOperatorcode(dbManager.getString(resultSet,4));
	    prplfiscalpaymainDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,5));
	    prplfiscalpaymainDto.setOperatorcomcode(dbManager.getString(resultSet,6));
	    prplfiscalpaymainDto.setCompensateNo(dbManager.getString(resultSet, 7));
	    prplfiscalpaymainDto.setReceiverfullName(dbManager.getString(resultSet, 8));
	    prplfiscalpaymainDto.setIdentifyNumber(dbManager.getString(resultSet, 9));
	    prplfiscalpaymainDto.setInsuredCode(dbManager.getString(resultSet, 10));
	    prplfiscalpaymainDto.setBankAccount(dbManager.getString(resultSet, 11));
	    collection.add(prplfiscalpaymainDto);
	}
	resultSet.close();
	return collection;
	}
	}
