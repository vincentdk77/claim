package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpaytg;

/**
 * 这是PRPLPAY的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpaytgAction extends BLPrplpaytgActionBase {
    private static Logger logger = Logger.getLogger(BLPrplpaytgAction.class);

    /**
     * 构造函数
     */
    public BLPrplpaytgAction() {
        super();
    }

    /**
     * 转换Dto
     * 
     * @param dbManager
     *            dbManager
     * @param prplpaytgDto
     *            prplpaytgDto
     * @param mode
     *            模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrplpayDto prplpaytgDto,
            String mode) throws Exception {
    }

    /**
     * 插入多条数据
     * 
     * @param dbManager
     *            DB管理器
     * @param prplpaytgDto
     *            prplpaytgDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager, Collection prplpayDtoList)
            throws Exception {
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        // 插入记录
        dbPrplpaytg.insertAll(prplpayDtoList);
    }

    public void updatePayFlag(DBManager dbManager, PrplpayDto prplpaytgDto)
            throws Exception {
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        // 更新记录
        dbPrplpaytg.updatePayFlag(prplpaytgDto);
    }
    public void updateVFlag(DBManager dbManager, String vflag,String registNo,String compensateNo)
    throws Exception {
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
		// 更新记录
		dbPrplpaytg.updateVFlag(vflag,registNo,compensateNo);
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
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
		// 更新记录
		dbPrplpaytg.updateVFlag(vflag,serialno);
    }
    
    /**
     * 根据收付编号更新收付状态 add by zhongfen
     * @param dbManager
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateVflagByPaymentNo(DBManager dbManager, String paymentNo,String vflag)throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	dbPrplpaytg.updateVflagByPaymentNo(paymentNo,vflag);
    }
    
    /**
     * 根据通知单号获取支付信息、车牌号码、被保险人名称 add by zhongfen
     * @param dbManager
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(DBManager dbManager,String noticeNo) throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	Collection colls = dbPrplpaytg.findPrintByNoticeNo(noticeNo);
    	return colls ;
    }
    /**
     * 根据支付编号获取支付信息、车牌号码、被保险人名称 add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(DBManager dbManager,String paymentNo) throws Exception{
    	DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
    	Collection colls = dbPrplpaytg.findPrintByPaymentNo(paymentNo);
    	return colls ;
    }

	public Collection findByConditionsSql(DBManager dbManager, String conditions) throws Exception{
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditionsSql(conditions);
        return collection;
    	
	}
	/***********************优化修改：start****************************/
	public Collection findByConditionsSqlByPrepered(DBManager dbManager, String conditions,String Serialno,String Compensateno,double Payamount) throws Exception{
		DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditionsSqlByprepered(conditions,Serialno,Compensateno,Payamount);
        return collection;
    	
	}
	/***********************优化修改：end*******************************/
}
