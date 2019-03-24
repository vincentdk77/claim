package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * 这是PRPLPAY的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpayFacade extends BLPrplpayFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplpayFacade.class);

    /**
     * 构造函数
     */
    public BLPrplpayFacade(){
        super();
    }
    public void updatePayFlag(PrplpayDto prplpayDto)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        //更新记录
        blPrplpayAction.updatePayFlag(dbManager,prplpayDto);
        dbManager.commitTransaction();
    }catch(Exception exception){
        dbManager.rollbackTransaction();
        throw exception;
    }finally{
        dbManager.close();
    }
}
    public void updateVFlag(String vflag,String registNo,String compensateNo)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        //更新记录
        blPrplpayAction.updateVFlag(dbManager,vflag,registNo,compensateNo);
        dbManager.commitTransaction();
    }catch(Exception exception){
        dbManager.rollbackTransaction();
        throw exception;
    }finally{
        dbManager.close();
    }
}
    /**
     *  更新支付状态
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlag(String vflag,String serialno)
    throws Exception{
	    DBManager dbManager = new DBManager();
	    BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
	    try{
	        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	        dbManager.beginTransaction();
	        //更新记录
	        blPrplpayAction.updateVFlag(dbManager,vflag,serialno);
	        dbManager.commitTransaction();
	    }catch(Exception exception){
	        dbManager.rollbackTransaction();
	        throw exception;
	    }finally{
	        dbManager.close();
	    }
	}
    /**
     *  更新支付状态
	* 审核占用必须是待审核状态
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlagFor6(String vflag,String serialno)
    throws Exception{
	    DBManager dbManager = new DBManager();
	    BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
	    try{
	        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	        dbManager.beginTransaction();
	        //更新记录
	        blPrplpayAction.updateVFlagFor6(dbManager,vflag,serialno);
	        dbManager.commitTransaction();
	    }catch(Exception exception){
	        dbManager.rollbackTransaction();
	        throw exception;
	    }finally{
	        dbManager.close();
	    }
	}
    public void updatebackPayFlag(String compensateNO ,String paymenttype,String usercode )
    throws Exception{
    DBManager dbManager = new DBManager();
    BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        String sql ="p.compensateNO='"+compensateNO+"' and p.paymenttype='"+paymenttype+"'";
        //更新记录
       ArrayList<PrplpayDto> list=(ArrayList<PrplpayDto> ) blPrplpayAction.findByConditions(dbManager, sql);
       if(list!=null&&!list.isEmpty()){
    	   for(PrplpayDto prplpayDto:list){
    		   prplpayDto.setPaydate(new DateTime(DateTime.current(),DateTime.YEAR_TO_MINUTE));
    		   prplpayDto.setPaycode(usercode);
    		   prplpayDto.setPayflag("1");
    		   blPrplpayAction.updatePayFlag(dbManager,prplpayDto);
    	   }
       }
       dbManager.commitTransaction();
    }catch(Exception exception){
        dbManager.rollbackTransaction();
        throw exception;
    }finally{
        dbManager.close();
    }
}
    
    /**
     * 根据通知单号获取支付信息、车牌号码、被保险人名称  add by zhongfen
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(String noticeNo) throws Exception{
    	Collection colls = new ArrayList();
    	DBManager dbManager = new DBManager();
        BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            colls = blPrplpayAction.findPrintByNoticeNo(dbManager,noticeNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	return colls;
    }
    /**
     * 根据支付编号获取支付信息、车牌号码、被保险人名称 add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(String paymentNo) throws Exception{
    	Collection colls = new ArrayList();
    	DBManager dbManager = new DBManager();
        BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //dbManager.beginTransaction();
            colls = blPrplpayAction.findPrintByPaymentNo(dbManager, paymentNo);
            //dbManager.commitTransaction();
        }catch(Exception exception){
            //dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	return colls;
    }
}
