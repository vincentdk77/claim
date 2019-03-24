package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLacciCheckAction;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciCheck--�⽡�յ��������ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blPrpLacciCheckAction.insert(dbManager,prpLacciCheckDto);
            
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
     * @param checkNo �����
     * @throws Exception
     */
    public void delete(String checkNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLacciCheckAction.delete(dbManager,checkNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLacciCheckAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void update(PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLacciCheckAction.update(dbManager,prpLacciCheckDto);
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
     * @param checkNo �����
     * @return prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckDto findByPrimaryKey(String checkNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        //����DTO
        PrpLacciCheckDto prpLacciCheckDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //��ѯ����,��ֵ��DTO
            prpLacciCheckDto = blPrpLacciCheckAction.findByPrimaryKey(dbManager,checkNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLacciCheckDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrpLacciCheckAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLacciCheckDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrpLacciCheckAction.findByConditions(dbManager,conditions);
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
        BLPrpLacciCheckAction blPrpLacciCheckAction = new BLPrpLacciCheckAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrpLacciCheckAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
