package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISITSWFLOG��ҵ���߼�����Facade����<br>
 */
public class BLPrplreturnvisitswflogFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitswflogFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void insert(PrplreturnvisitswflogDto prplreturnvisitswflogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplreturnvisitswflogAction.insert(dbManager,prplreturnvisitswflogDto);
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
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String businessno,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplreturnvisitswflogAction.delete(dbManager,businessno, nodetype);
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
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplreturnvisitswflogAction.deleteByConditions(dbManager,conditions);
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
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void update(PrplreturnvisitswflogDto prplreturnvisitswflogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplreturnvisitswflogAction.update(dbManager,prplreturnvisitswflogDto);
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
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public PrplreturnvisitswflogDto findByPrimaryKey(String businessno,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        //����DTO
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplreturnvisitswflogDto = blPrplreturnvisitswflogAction.findByPrimaryKey(dbManager,businessno, nodetype);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplreturnvisitswflogDto;
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
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplreturnvisitswflogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplreturnvisitswflogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplreturnvisitswflogAction.findByConditions(dbManager,conditions);
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
        BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplreturnvisitswflogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
