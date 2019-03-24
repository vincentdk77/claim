package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.bl.action.domain.BLPrplcomplaintAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPLAINT��ҵ���߼�����Facade����<br>
 */
public class BLPrplcomplaintFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcomplaintFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplcomplaintFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void insert(PrplcomplaintDto prplcomplaintDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplcomplaintAction.insert(dbManager,prplcomplaintDto);
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
     * @param complaintno COMPLAINTNO
     * @throws Exception
     */
    public void delete(String complaintno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplcomplaintAction.delete(dbManager,complaintno);
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplcomplaintAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void update(PrplcomplaintDto prplcomplaintDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplcomplaintAction.update(dbManager,prplcomplaintDto);
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
     * @param complaintno COMPLAINTNO
     * @return prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public PrplcomplaintDto findByPrimaryKey(String complaintno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        //����DTO
        PrplcomplaintDto prplcomplaintDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplcomplaintDto = blPrplcomplaintAction.findByPrimaryKey(dbManager,complaintno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcomplaintDto;
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcomplaintAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplcomplaintDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcomplaintAction.findByConditions(dbManager,conditions);
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcomplaintAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
