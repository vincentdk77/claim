package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrplpaytgAction;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * ����PRPLPAY��ҵ�����tgFacade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplpaytgFacade extends BLPrplpaytgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplpaytgFacade.class);

    /**
     * ���캯��
     */
    public BLPrplpaytgFacade(){
        super();
    }
    public void updatePayFlag(PrplpayDto prplpaytgDto)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        //���¼�¼
        blPrplpaytgAction.updatePayFlag(dbManager,prplpaytgDto);
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
    BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        //���¼�¼
        blPrplpaytgAction.updateVFlag(dbManager,vflag,registNo,compensateNo);
        dbManager.commitTransaction();
    }catch(Exception exception){
        dbManager.rollbackTransaction();
        throw exception;
    }finally{
        dbManager.close();
    }
}
    /**
     *  ����֧��״̬
     * @param vflag
     * @param serialno
     * @throws Exception
     */
    public void updateVFlag(String vflag,String serialno)
    throws Exception{
	    DBManager dbManager = new DBManager();
	    BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
	    try{
	        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	        dbManager.beginTransaction();
	        //���¼�¼
	        blPrplpaytgAction.updateVFlag(dbManager,vflag,serialno);
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
    BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        dbManager.beginTransaction();
        String sql ="p.compensateNO='"+compensateNO+"' and p.paymenttype='"+paymenttype+"'";
        //���¼�¼
       ArrayList<PrplpayDto> list=(ArrayList<PrplpayDto> ) blPrplpaytgAction.findByConditions(dbManager, sql);
       if(list!=null&&!list.isEmpty()){
    	   for(PrplpayDto prplpaytgDto:list){
    		   prplpaytgDto.setPaydate(new DateTime(DateTime.current(),DateTime.YEAR_TO_MINUTE));
    		   prplpaytgDto.setPaycode(usercode);
    		   prplpaytgDto.setPayflag("1");
    		   blPrplpaytgAction.updatePayFlag(dbManager,prplpaytgDto);
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
     * ����֪ͨ���Ż�ȡ֧����Ϣ�����ƺ��롢������������  add by zhongfen
     * @param noticeNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByNoticeNo(String noticeNo) throws Exception{
    	Collection colls = new ArrayList();
    	DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            colls = blPrplpaytgAction.findPrintByNoticeNo(dbManager,noticeNo);
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
     * ����֧����Ż�ȡ֧����Ϣ�����ƺ��롢������������ add by chu
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Collection findPrintByPaymentNo(String paymentNo) throws Exception{
    	Collection colls = new ArrayList();
    	DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //dbManager.beginTransaction();
            colls = blPrplpaytgAction.findPrintByPaymentNo(dbManager, paymentNo);
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
