package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;

/**
 * ����֧����Ϣ�����ҵ�����Facade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaymainFacade extends BLPrplfiscalpaymainFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymainFacade.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaymainFacade(){
        super();
    }
    
    /**
     * �����ո���Ÿ���֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param vflag ֧��״̬
     * @throws Exception
     */
    public void updateByKey(String fiscalno,String vflag,String status)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplfiscalmainpayAction.updateByKey(dbManager,fiscalno,vflag,status);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplfiscalmainpayAction.findPayQueryByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPayQueryByConditionsNew(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findPayQueryByConditionsNew(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * �����ո���Ÿ��µ�����֧��״̬ add by zhongfen
     * @param paymentNo �ո����
     * @param thirdPayFlag ֧��״̬
     * @throws Exception
     */
    public void updateThirdPayFlag(String paymentNo,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymainAction.updateThirdPayFlag(dbManager,paymentNo,thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findPaybackByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplfiscalmainpayAction.findPaybackByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
