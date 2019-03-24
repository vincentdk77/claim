package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcfeeAction;
import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcfee-����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.359<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcfeeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcfeeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcfeeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void insert(PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcfeeAction.insert(dbManager,prpLcfeeDto);
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
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(String compensateNo,String policyNo,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcfeeAction.delete(dbManager,compensateNo, policyNo, currency);
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
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcfeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void update(PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcfeeAction.update(dbManager,prpLcfeeDto);
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
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @return prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public PrpLcfeeDto findByPrimaryKey(String compensateNo,String policyNo,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        //����DTO
        PrpLcfeeDto prpLcfeeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcfeeDto = blPrpLcfeeAction.findByPrimaryKey(dbManager,compensateNo, policyNo, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcfeeDto;
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
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcfeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcfeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcfeeAction.findByConditions(dbManager,conditions);
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
        BLPrpLcfeeAction blPrpLcfeeAction = new BLPrpLcfeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcfeeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
