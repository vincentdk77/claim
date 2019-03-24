package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayBill;

/**
 * 这是prpLpayBill的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillAction extends BLPrpLpayBillActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpayBillAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpayBillDto prpLpayBillDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayBillDto prpLpayBillDto,String mode)
            throws Exception{
    }

	public Collection findByPaymentNo(DBManager dbManager, String conditions) throws Exception {
		DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayBill.findByPaymentNo(conditions);
        return collection;
	}
	
	/**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(DBManager dbManager,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //声明DTO
        PrpLpayBillDto prpLpayBillDto = null;
        //查询数据,赋值给DTO
        prpLpayBillDto = dbPrpLpayBill.findByPrimaryKey( registNo, compensateNo, serialNo);
        return prpLpayBillDto;
    }
    /**************************优化修改：start****************************/
    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
	public Collection findByCollection(DBManager dbManager,Collection collection) throws Exception{
		DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
		Collection result = new ArrayList();
		result =  dbPrpLpayBill.findByCollection(collection);
		return result;
	}
	/**************************优化修改：start****************************/
	public PrpLpayBillDto findByBillFlag(DBManager dbManager,String registNo,String compensateNo,int serialNo)
	    throws Exception{
		DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
		//声明DTO
		PrpLpayBillDto prpLpayBillDto = null;
		//查询数据,赋值给DTO
		prpLpayBillDto = dbPrpLpayBill.findByBillFlag( registNo, compensateNo, serialNo);
		return prpLpayBillDto;
	}
}
