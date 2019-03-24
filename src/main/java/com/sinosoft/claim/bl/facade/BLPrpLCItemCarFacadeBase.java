package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLCItemCarAction;
import com.sinosoft.claim.dto.domain.PrpLCItemCarDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCItemCar-���Ᵽ�����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCItemCarFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLCItemCarFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLCItemCarFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void insert(PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLCItemCarAction.insert(dbManager,prpLCItemCarDto);
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
     * @param registNo ������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(String registNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLCItemCarAction.delete(dbManager,registNo, policyNo);
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
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLCItemCarAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void update(PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLCItemCarAction.update(dbManager,prpLCItemCarDto);
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
     * @param registNo ������
     * @param policyNo ��������
     * @return prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public PrpLCItemCarDto findByPrimaryKey(String registNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        //����DTO
        PrpLCItemCarDto prpLCItemCarDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLCItemCarDto = blPrpLCItemCarAction.findByPrimaryKey(dbManager,registNo, policyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLCItemCarDto;
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
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLCItemCarAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLCItemCarDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLCItemCarAction.findByConditions(dbManager,conditions);
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
        BLPrpLCItemCarAction blPrpLCItemCarAction = new BLPrpLCItemCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLCItemCarAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
