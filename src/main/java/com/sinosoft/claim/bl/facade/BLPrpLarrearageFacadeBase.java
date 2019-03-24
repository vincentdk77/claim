package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLarrearageAction;
import com.sinosoft.claim.dto.domain.PrpLarrearageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLarrearage-���Ƿ���嵥���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLarrearageFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLarrearageFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLarrearageFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void insert(PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLarrearageAction.insert(dbManager,prpLarrearageDto);
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
     * @param policyNo ������
     * @param arrearageEndDate ����Ӧ�����ֹ����
     * @throws Exception
     */
    public void delete(String policyNo,DateTime arrearageEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLarrearageAction.delete(dbManager,policyNo, arrearageEndDate);
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
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLarrearageAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void update(PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLarrearageAction.update(dbManager,prpLarrearageDto);
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
     * @param policyNo ������
     * @param arrearageEndDate ����Ӧ�����ֹ����
     * @return prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public PrpLarrearageDto findByPrimaryKey(String policyNo,DateTime arrearageEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        //����DTO
        PrpLarrearageDto prpLarrearageDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLarrearageDto = blPrpLarrearageAction.findByPrimaryKey(dbManager,policyNo, arrearageEndDate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLarrearageDto;
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
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLarrearageAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLarrearageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLarrearageAction.findByConditions(dbManager,conditions);
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
        BLPrpLarrearageAction blPrpLarrearageAction = new BLPrpLarrearageAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLarrearageAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
