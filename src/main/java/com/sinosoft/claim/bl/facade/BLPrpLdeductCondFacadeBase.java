package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLdeductCondAction;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLdeductCond-�����������������ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLdeductCondFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void insert(PrpLdeductCondDto prpLdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blPrpLdeductCondAction.insert(dbManager,prpLdeductCondDto);
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
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @throws Exception
     */
    public void delete(String compensateNo,String deductCondCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLdeductCondAction.delete(dbManager,compensateNo, deductCondCode);
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
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLdeductCondAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void update(PrpLdeductCondDto prpLdeductCondDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLdeductCondAction.update(dbManager,prpLdeductCondDto);
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
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @return prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public PrpLdeductCondDto findByPrimaryKey(String compensateNo,String deductCondCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        //����DTO
        PrpLdeductCondDto prpLdeductCondDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //��ѯ����,��ֵ��DTO
            prpLdeductCondDto = blPrpLdeductCondAction.findByPrimaryKey(dbManager,compensateNo, deductCondCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLdeductCondDto;
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
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrpLdeductCondAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLdeductCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrpLdeductCondAction.findByConditions(dbManager,conditions);
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
        BLPrpLdeductCondAction blPrpLdeductCondAction = new BLPrpLdeductCondAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrpLdeductCondAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
