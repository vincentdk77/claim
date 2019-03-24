package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayShowtgAction;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是支付信息查询列表的业务逻辑对象tgFacade类
 * @author Administrator
 *
 */
public class BLPrpLpayShowtgFacade {
	private static Logger logger = Logger.getLogger(BLPrpLpayShowtgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLpayShowtgFacade(){
    }
    
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param paymentNo	支付编号
	 * @param judgeFlag	判断加核赔标志
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @param status	支付状态（0:新增，1：暂存，4：查询）
	 * @return
	 * @throws Exception
	 */
    public ArrayList<PrpLpayShowDto> getShowList(String payType,String paymentType,String comCode,String paymentNo,boolean judgeFlag,ArrayList<String> registNos,
    		ArrayList<String> certiNos,String status)throws Exception{
    	DBManager dbManager = new DBManager();
    	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayShowtgAction.getShowList(dbManager, payType, paymentType,comCode,paymentNo,judgeFlag, registNos, certiNos,status);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowList(dbManager, payType, paymentType,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowList(dbManager, payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
	 * 支付信息查询报案信息显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowRegistList(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowRegistList(dbManager, payType, paymentType,conditions,pageNo,rowsPerPage,casesType,userComcode,type);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

	public ArrayList<PrpLpayShowDto> getShowBillList(String payType,
			String paymentType, String comCode,String paymentNo,String payName,
			String identifyNumber, boolean flag, String registNo, String compensateNo, String status,String back) throws Exception{
		DBManager dbManager = new DBManager();
    	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayShowtgAction.getShowBillList(dbManager, payType, paymentType,comCode,paymentNo,payName,identifyNumber,flag, registNo, compensateNo,status,back);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
	}
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowList(String payType,String paymentType,String back,String userCode,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowList(dbManager, payType, paymentType, back,userCode,conditions,pageNo,rowsPerPage,casesType,userComcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
	 * 支付信息查询报案信息显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getFiscalQueryShowRegistList(String payType,String paymentType,String back,String userCode,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getFiscalQueryShowRegistList(dbManager, payType, paymentType, back,userCode,conditions,pageNo,rowsPerPage,casesType,userComcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    public PageRecord getNewAddQueryShowList(String[] payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewAddQueryShowList(dbManager, payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**************************************优化修改：start**********************************************/
    /**
	 * 支付信息查询报案信息显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowRegistListNew(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowRegistListNew(dbManager, payType, paymentType,conditions,pageNo,rowsPerPage,casesType,userComcode,type);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
	 * 支付信息查询列表显示方法
	 * @param payType	支付类型
	 * @param paymentType	赔款类型
	 * @param comCode	机构号码
	 * @param registNos	报案号集合
	 * @param certiNos	业务号集合
	 * @return
	 * @throws Exception
	 */
    public PageRecord getNewQueryShowListNew(String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
    	DBManager dbManager = new DBManager();
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        BLPrpLpayShowtgAction blPrpLpayShowtgAction = new BLPrpLpayShowtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayShowtgAction.getNewQueryShowListNew(dbManager, payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**************************************优化修改：end**********************************************/
}
