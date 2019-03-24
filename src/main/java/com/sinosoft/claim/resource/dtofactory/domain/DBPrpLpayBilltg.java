package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;

/**
 * 这是prpLpayBill的数据访问对象类<br>
 * 创建于 2014-07-22 16:16:56.421<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayBilltg extends DBPrpLpayBilltgBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayBilltg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayBilltg(DBManager dbManager){
        super(dbManager);
    }

	public Collection findByPaymentNo(String conditions) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("distinct prplpaymain.paymentNo ");
        buffer.append("FROM PrpLpayBilltg PrpLpayBill,prplpaymaintg prplpaymain WHERE ");
        buffer.append("PrpLpayBill.paymentNo=prplpaymain.paymentNo ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;

        //定义返回结果集合
        Collection collection = new ArrayList();
        PrpLpayBillDto prpLpayBillDto = null;
        while(resultSet.next()){
            prpLpayBillDto = new PrpLpayBillDto();
            prpLpayBillDto.setPaymentNo(dbManager.getString(resultSet,1));
            collection.add(prpLpayBillDto);
        }
        resultSet.close();
        return collection;
	}

	/**
     * 按主键查找一条数据
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return PrpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(String registNo,String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount ");
        buffer.append("FROM PrpLpayBilltg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,compensateNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayBillDto prpLpayBillDto = null;
        if(resultSet.next()){
            prpLpayBillDto = new PrpLpayBillDto();
            prpLpayBillDto.setBillNo(dbManager.getString(resultSet, 1));
            prpLpayBillDto.setPaymentNo(dbManager.getString(resultSet,2));
            prpLpayBillDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLpayBillDto.setCompensateNo(dbManager.getString(resultSet,4));
            prpLpayBillDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLpayBillDto.setPayAmount(dbManager.getDouble(resultSet,6));
        }
        resultSet.close();
        return prpLpayBillDto;
    }
    /*********************优化修改：start**********************/
    /**
     * 按主键查找一条数据
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return PrpLpayBillDto
     * @throws Exception
     */
    public Collection findByCollection(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount ");
        buffer.append("FROM PrpLpayBilltg ");
        buffer.append("WHERE ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
        	PrpLpayBillDto prpLpayBillDto = (PrpLpayBillDto) iterator.next();
			dbManager.setString(1,prpLpayBillDto.getRegistNo());
	        dbManager.setString(2,prpLpayBillDto.getCompensateNo());
	        dbManager.setInt(3,prpLpayBillDto.getSerialNo());
	        dbManager.addBatch();
		}
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayBillDto prpLpayBillDto = null;
        if(resultSet.next()){
            prpLpayBillDto = new PrpLpayBillDto();
            prpLpayBillDto.setBillNo(dbManager.getString(resultSet, 1));
            prpLpayBillDto.setPaymentNo(dbManager.getString(resultSet,2));
            prpLpayBillDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLpayBillDto.setCompensateNo(dbManager.getString(resultSet,4));
            prpLpayBillDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLpayBillDto.setPayAmount(dbManager.getDouble(resultSet,6));
        }
        resultSet.close();
        return null;
    }
    /*********************优化修改：end**********************/
}
