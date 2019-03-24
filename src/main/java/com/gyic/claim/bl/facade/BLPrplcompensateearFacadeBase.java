package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.bl.action.domain.BLPrplcompensateearAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Prplcompensateear��ҵ���߼�����Facade����<br>
 */
public class BLPrplcompensateearFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplcompensateearFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void insert(PrplcompensateearDto prplcompensateearDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplcompensateearAction.insert(dbManager,prplcompensateearDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String earno,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplcompensateearAction.delete(dbManager,earno, registno, nodetype,businessno);
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplcompensateearAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void update(PrplcompensateearDto prplcompensateearDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplcompensateearAction.update(dbManager,prplcompensateearDto);
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
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @return prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public PrplcompensateearDto findByPrimaryKey(String earno,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        //����DTO
        PrplcompensateearDto prplcompensateearDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplcompensateearDto = blPrplcompensateearAction.findByPrimaryKey(dbManager,earno, registno, nodetype,businessno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcompensateearDto;
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcompensateearAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplcompensateearDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcompensateearAction.findByConditions(dbManager,conditions);
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensateearAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String earno) 
        throws Exception{
        int rowCount=0;

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensateearAction.getInprocessCount(dbManager,policyno,earno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ����ģ����ѯ������Ԥ�Ƹ������
     * @param conditions conditions
     * @return ����ģ����ѯ������Ԥ�Ƹ������
     * @throws Exception
     */
    public double getSumLoss(String conditions) 
        throws Exception{
        double sumLoss=0.00;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            sumLoss = blPrplcompensateearAction.getSumLoss(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sumLoss;
    }
}
