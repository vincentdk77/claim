package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayShow;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是支付查询列表的业务逻辑对象类
 */
public class BLPrpLpayShowAction {
	private static Logger logger = Logger.getLogger(BLPrpLpayShowAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpayShowAction(){
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
    public ArrayList<PrpLpayShowDto> getShowList(DBManager dbManager,String payType,String paymentType,String comCode,String paymentNo,boolean judgeFlag,ArrayList<String> registNos,
    		ArrayList<String> certiNos,String status)throws Exception{
    	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
    	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
    	collection = dbPrpLpayShow.getShowList(payType, paymentType, comCode, paymentNo, judgeFlag, registNos, certiNos, status);
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
    public PageRecord getNewQueryShowList(DBManager dbManager,String payType,String paymentType,String conditions,int pageNo,int rowsPerPage)throws Exception{
    	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
    	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
    	int count = dbPrpLpayShow.getNewQueryCount(payType, paymentType, SqlUtils.getWherePartForGetCount(conditions));
    	collection = dbPrpLpayShow.getNewQueryShowList(payType, paymentType, conditions,pageNo,rowsPerPage);
    	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
       public PageRecord getNewQueryShowList(DBManager dbManager,String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
       	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
       	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
       	int count = dbPrpLpayShow.getNewQueryCount(payType, paymentType, SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
       	collection = dbPrpLpayShow.getNewQueryShowList(payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
       	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
      public PageRecord getNewQueryShowRegistList(DBManager dbManager,String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
      	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
      	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
      	int count = dbPrpLpayShow.getNewQueryRegistCount(payType, paymentType,SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
      	collection = dbPrpLpayShow.getNewQueryShowRegistList(payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode,type);
      	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
          return pageRecord;
      }
	public ArrayList<PrpLpayShowDto> getShowBillList(DBManager dbManager,
			String payType, String paymentType, String comCode, String paymentNo, String payName, String identifyNumber, boolean flag,
			String registNo, String compensateNo,  String status,String back) throws Exception{
		DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
    	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
    	collection = dbPrpLpayShow.getShowBillList(payType, paymentType, comCode, paymentNo, payName ,identifyNumber ,registNo, compensateNo, flag, status,back);
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
          public PageRecord getNewQueryShowList(DBManager dbManager,String payType,String paymentType,String back,String userCode,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
          	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
          	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
          	int count = dbPrpLpayShow.getNewQueryCount(payType, paymentType,SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
          	collection = dbPrpLpayShow.getNewQueryShowList(payType, paymentType,conditions,pageNo,rowsPerPage,casesType,userComcode);
          	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
     public PageRecord getFiscalQueryShowRegistList(DBManager dbManager,String payType,String paymentType,String back,String userCode,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
     	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
     	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
     	int count = dbPrpLpayShow.getFiscalQueryRegistCount(payType, paymentType,back, userCode,SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
     	collection = dbPrpLpayShow.getFiscalQueryShowRegistList(payType, paymentType, back,userCode,conditions,pageNo,rowsPerPage,casesType,userComcode);
     	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
         return pageRecord;
     }
     
     public PageRecord getNewAddQueryShowList(DBManager dbManager,String[] payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
        	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
        	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
        	int count = dbPrpLpayShow.getNewAddQueryCount(payType, paymentType, SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
        	collection = dbPrpLpayShow.getNewAddQueryShowList(payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
        	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
            return pageRecord;
        }
     /********************************************************************/
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
   public PageRecord getNewQueryShowRegistListNew(DBManager dbManager,String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode,String type)throws Exception{
   	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
   	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
   	int count = dbPrpLpayShow.getNewQueryRegistCountNew(payType, paymentType,SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
   	collection = dbPrpLpayShow.getNewQueryShowRegistListNew(payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode,type);
   	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
      public PageRecord getNewQueryShowListNew(DBManager dbManager,String payType,String paymentType,String conditions,int pageNo,int rowsPerPage,String casesType,String userComcode)throws Exception{
      	DBPrpLpayShow dbPrpLpayShow = new DBPrpLpayShow(dbManager);
      	ArrayList<PrpLpayShowDto> collection = new ArrayList<PrpLpayShowDto>();
      	int count = dbPrpLpayShow.getNewQueryCountNew(payType, paymentType, SqlUtils.getWherePartForGetCount(conditions), casesType,userComcode);
      	collection = dbPrpLpayShow.getNewQueryShowListNew(payType, paymentType, conditions,pageNo,rowsPerPage,casesType,userComcode);
      	PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
          return pageRecord;
      }
     /********************************************************************/
}
