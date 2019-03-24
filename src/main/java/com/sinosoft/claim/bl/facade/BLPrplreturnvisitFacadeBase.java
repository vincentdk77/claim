package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISIT��ҵ���߼�����Facade����<br>
 */
public class BLPrplreturnvisitFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(PrplreturnvisitDto prplreturnvisitDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplreturnvisitAction.insert(dbManager,prplreturnvisitDto);
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
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplreturnvisitAction.delete(dbManager,registno, serialno);
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplreturnvisitAction.deleteByConditions(dbManager,conditions);
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
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(PrplreturnvisitDto prplreturnvisitDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplreturnvisitAction.update(dbManager,prplreturnvisitDto);
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
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public PrplreturnvisitDto findByPrimaryKey(String registno,String serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        //����DTO
        PrplreturnvisitDto prplreturnvisitDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplreturnvisitDto = blPrplreturnvisitAction.findByPrimaryKey(dbManager,registno, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplreturnvisitDto;
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplreturnvisitAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplreturnvisitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplreturnvisitAction.findByConditions(dbManager,conditions);
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplreturnvisitAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
