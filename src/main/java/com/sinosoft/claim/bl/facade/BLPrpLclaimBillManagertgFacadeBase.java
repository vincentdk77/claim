package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagertgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimBillManager��ҵ���߼�����tgFacade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagertgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagertgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimBillManagertgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void insert(PrpLclaimBillManagerDto prpLclaimBillManagertgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimBillManagertgAction.insert(dbManager,prpLclaimBillManagertgDto);
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
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimBillManagertgAction.delete(dbManager,registNo);
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
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimBillManagertgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void update(PrpLclaimBillManagerDto prpLclaimBillManagertgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimBillManagertgAction.update(dbManager,prpLclaimBillManagertgDto);
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
     * @param registNo registNo
     * @return prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public PrpLclaimBillManagerDto findByPrimaryKey(String registNo,String compensateNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        //����DTO
        PrpLclaimBillManagerDto prpLclaimBillManagertgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimBillManagertgDto = blPrpLclaimBillManagertgAction.findByPrimaryKey(dbManager,registNo,compensateNo,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimBillManagertgDto;
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
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimBillManagertgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimBillManagerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimBillManagertgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimBillManagertgAction blPrpLclaimBillManagertgAction = new BLPrpLclaimBillManagertgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimBillManagertgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
