package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLRecoveryOrPay extends DBPrpLRecoveryOrPayBase{
    private static Log log = LogFactory.getLog(DBPrpLRecoveryOrPay.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLRecoveryOrPay(DBManager dbManager){
        super(dbManager);
    }

	public Collection findbyRecovery(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("RecoveryCode,");
        buffer.append("sum(RecoveryOrPayAmount) ");
        buffer.append("FROM PrpLRecoveryOrPay WHERE ");
        buffer.append(conditions);
        if(log.isDebugEnabled()){
        	log.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLRecoveryOrPayDto = new PrpLRecoveryOrPayDto();
        	prpLRecoveryOrPayDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLRecoveryOrPayDto.setRecoveryOrPayFlag(dbManager.getString(resultSet,2));
        	prpLRecoveryOrPayDto.setRecoveryCode(dbManager.getString(resultSet,3));
        	prpLRecoveryOrPayDto.setRecoveryOrPayAmount(dbManager.getDouble(resultSet, 4));
            collection.add(prpLRecoveryOrPayDto);
        }
        resultSet.close();
        return collection;
	}
	

	public Collection findDistinctbyRecovery(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("sum(RecoveryOrPayAmount) ");
        buffer.append("FROM PrpLRecoveryOrPay WHERE ");
        buffer.append(conditions);
        if(log.isDebugEnabled()){
        	log.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLRecoveryOrPayDto = new PrpLRecoveryOrPayDto();
        	prpLRecoveryOrPayDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLRecoveryOrPayDto.setRecoveryOrPayFlag(dbManager.getString(resultSet,2));
        	prpLRecoveryOrPayDto.setRecoveryOrPayAmount(dbManager.getDouble(resultSet, 3));
            collection.add(prpLRecoveryOrPayDto);
        }
        resultSet.close();
        return collection;
	}
	
}
