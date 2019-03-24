package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * 这是PRPLPAY的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpayAction extends BLPrplpayActionBase {
    private static Logger logger = Logger.getLogger(BLPrplpayAction.class);

    /**
     * 构造函数
     */
    public BLPrplpayAction() {
        super();
    }

    /**
     * 转换Dto
     * 
     * @param dbManager
     *            dbManager
     * @param prplpayDto
     *            prplpayDto
     * @param mode
     *            模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrplpayDto prplpayDto,
            String mode) throws Exception {
    }

    /**
     * 插入多条数据
     * 
     * @param dbManager
     *            DB管理器
     * @param prplpayDto
     *            prplpayDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplpayDtoList)
            throws Exception {
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        // 插入记录
        dbPrplpay.insertAll(prplpayDtoList);
    }

    public void updatePayFlag(DBManager dbManager, PrplpayDto prplpayDto)
            throws Exception {
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        // 更新记录
        dbPrplpay.updatePayFlag(prplpayDto);
    }
    public void updateVFlag(DBManager dbManager, String vflag,String registNo,String compensateNo)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// 更新记录
		dbPrplpay.updateVFlag(vflag,registNo,compensateNo);
    }
    /**
     * 更新支付状态
     * @param dbManager
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlag(DBManager dbManager, String vflag,String serialno)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// 更新记录
		dbPrplpay.updateVFlag(vflag,serialno);
    }
    /**
     * 更新支付状态
	* 审核占用必须是待审核状态
     * @param dbManager
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlagFor6(DBManager dbManager, String vflag,String serialno)
    throws Exception {
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
		// 更新记录
		dbPrplpay.updateVFlagFor6(vflag,serialno);
    }
    
    /**
     * 根据收付编号更新收付状态 add by zhongfen
     * @param dbManager
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateVflagByPaymentNo(DBManager dbManager, String paymentNo,String vflag)throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	dbPrplpay.updateVflagByPaymentNo(paymentNo,vflag);
    }
    
    /**
     * 根据通知单号获取支付信息、车牌号码、被保险人名称 add by zhongfen
     * @param dbManager
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(DBManager dbManager,String noticeNo) throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	Collection colls = dbPrplpay.findPrintByNoticeNo(noticeNo);
    	return colls ;
    }
    /**
     * 根据支付编号获取支付信息、车牌号码、被保险人名称 add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
    	Collection colls = dbPrplpay.findPrintByPaymentNo(paymentNo);
    	return colls ;
    }

	public Collection findByConditionsSql(DBManager dbManager, String conditions) throws Exception{
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditionsSql(conditions);
        return collection;
    	
	}
	/***********************优化修改：start****************************/
	public Collection findByConditionsSqlByPrepered(DBManager dbManager, String conditions,String Serialno,String Compensateno,double Payamount) throws Exception{
		DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditionsSqlByprepered(conditions,Serialno,Compensateno,Payamount);
        return collection;
    	
	}
	/***********************优化修改：end*******************************/
}
