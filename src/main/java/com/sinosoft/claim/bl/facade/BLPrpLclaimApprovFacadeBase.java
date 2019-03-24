package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimApprovAction;
import com.sinosoft.claim.dto.domain.PrpLclaimApprovDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov-��������ת��ȷ�ϱ��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimApprovFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimApprovFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimApprovFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void insert(PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimApprovAction.insert(dbManager,prpLclaimApprovDto);
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
     * @throws Exception
     */
    public void delete(String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimApprovAction.delete(dbManager,registNo);
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
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimApprovAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void update(PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimApprovAction.update(dbManager,prpLclaimApprovDto);
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
     * @return prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public PrpLclaimApprovDto findByPrimaryKey(String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        //����DTO
        PrpLclaimApprovDto prpLclaimApprovDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimApprovDto = blPrpLclaimApprovAction.findByPrimaryKey(dbManager,registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimApprovDto;
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
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimApprovAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimApprovDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimApprovAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimApprovAction blPrpLclaimApprovAction = new BLPrpLclaimApprovAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimApprovAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
