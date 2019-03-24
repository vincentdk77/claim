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
 * ����prpLpayBill��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillAction extends BLPrpLpayBillActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpayBillAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpayBillDto prpLpayBillDto
     * @param mode ģʽ
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
     * ����������һ������
     * @param dbManager DB������
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
        //����DTO
        PrpLpayBillDto prpLpayBillDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayBillDto = dbPrpLpayBill.findByPrimaryKey( registNo, compensateNo, serialNo);
        return prpLpayBillDto;
    }
    /**************************�Ż��޸ģ�start****************************/
    /**
     * ����������һ������
     * @param dbManager DB������
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
	/**************************�Ż��޸ģ�start****************************/
	public PrpLpayBillDto findByBillFlag(DBManager dbManager,String registNo,String compensateNo,int serialNo)
	    throws Exception{
		DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
		//����DTO
		PrpLpayBillDto prpLpayBillDto = null;
		//��ѯ����,��ֵ��DTO
		prpLpayBillDto = dbPrpLpayBill.findByBillFlag( registNo, compensateNo, serialNo);
		return prpLpayBillDto;
	}
}
