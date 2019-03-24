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
import com.sinosoft.claim.bl.action.domain.BLPrplpaytgAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPAY��ҵ���߼�����tgFacade����<br>
 */
public class BLPrplpaytgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplpaytgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplpaytgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void insert(PrplpayDto prplpaytgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blPrplpaytgAction.insert(dbManager,prplpaytgDto);
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
//        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            dbManager.beginTransaction();
//            //ɾ����¼
//            blPrplpaytgAction.delete(dbManager,serialno, compensateno);
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
    public void delete(String serialno,String compensateno,String serialno2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplpaytgAction.delete(dbManager,serialno, compensateno, serialno2);
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplpaytgAction.deleteByConditions(dbManager,conditions);
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
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void update(PrplpayDto prplpaytgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blPrplpaytgAction.update(dbManager,prplpaytgDto);
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
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(String serialno,String compensateno)
//        throws Exception{
//        DBManager dbManager = new DBManager();
//        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
//        //����DTO
//        PrplpayDto prplpaytgDto = null;
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            //��ѯ����,��ֵ��DTO
//            prplpaytgDto = blPrplpaytgAction.findByPrimaryKey(dbManager,serialno, compensateno);
//        }catch(Exception exception){
//            throw exception;
//        }finally{
//            dbManager.close();
//        }
//        return prplpaytgDto;
//    }
    /**
     * ����������һ������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(String serialno,String compensateno,String serialno2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        //����DTO
        PrplpayDto prplpaytgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplpaytgDto = blPrplpaytgAction.findByPrimaryKey(dbManager,serialno, compensateno, serialno2);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplpaytgDto;
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrplpaytgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplpaytgAction.findByConditions(dbManager,conditions);
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrplpaytgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��������ѯ�������� ��ͬ������,�ո�ԭ��,�������˽�����
     * @param conditions ��ѯ����
     * @return Collection ����prplpayDto�ļ���
     * @throws Exception
     */
    public Collection getSumPayamount(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplpaytgAction.getSumPayamount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
