package com.sinosoft.claim.bl.facade;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.viewHelper.LossProcessDto;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaydetailtgAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpaytgAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPAY��ҵ���߼�����tgFacade����<br>
 */
public class BLPrplfiscalpaydetailtgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailtgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplfiscalpaydetailtgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void insert(PrplpayDto prplpayDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blPrplpayAction.insert(dbManager,prplpayDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    public void save(HttpServletRequest request,String vflag)
    throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            LossProcessDto lp=new LossProcessDto();
            lp.saveOrUpdatePay(dbManager, request, null,vflag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public void save(HttpServletRequest request,WorkFlowDto workFlowDto)
    throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            LossProcessDto lp=new LossProcessDto();
            //
            lp.saveOrUpdatePay(dbManager, request, null,"");
            if(workFlowDto!=null){
                new BLWorkFlowAction().deal(dbManager,workFlowDto);
            }
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(String serialno,String compensateno)
//        throws Exception{
//        DBManager dbManager = new DBManager();
//        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            dbManager.beginTransaction();
//            //ɾ����¼
//            blPrplpayAction.delete(dbManager,serialno, compensateno);
//            dbManager.commitTransaction();
//        }catch(Exception exception){
//            dbManager.rollbackTransaction();
//            throw exception;
//        }finally{
//            dbManager.close();
//        }
//    }
    /**
     * ������ɾ��һ������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(String fiscalNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplfiscalpaydetailtgAction blPrplfiscalpaydetailAction = new BLPrplfiscalpaydetailtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplfiscalpaydetailAction.delete(dbManager,fiscalNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplpayAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void update(PrplpayDto prplpayDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blPrplpayAction.update(dbManager,prplpayDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(String serialno,String compensateno)
//        throws Exception{
//        DBManager dbManager = new DBManager();
//        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
//        //����DTO
//        PrplpayDto prplpayDto = null;
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            //��ѯ����,��ֵ��DTO
//            prplpayDto = blPrplpayAction.findByPrimaryKey(dbManager,serialno, compensateno);
//        }catch(Exception exception){
//            throw exception;
//        }finally{
//            dbManager.close();
//        }
//        return prplpayDto;
//    }
    /**
     * ����������һ������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(String serialno,String compensateno,String serialno2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        //����DTO
        PrplpayDto prplpayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplpayDto = blPrplpayAction.findByPrimaryKey(dbManager,serialno, compensateno, serialno2);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplpayDto;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrplpayAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplpayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplpayAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpayAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrplpayAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
