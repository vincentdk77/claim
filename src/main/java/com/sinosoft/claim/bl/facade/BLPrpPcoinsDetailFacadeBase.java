package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpPcoinsDetailAction;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoinsDetail��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void insert(PrpPcoinsDetailDto prpPcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpPcoinsDetailAction.insert(dbManager,prpPcoinsDetailDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(String endorseNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPcoinsDetailAction.delete(dbManager,endorseNo, serialNo, currency);
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPcoinsDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void update(PrpPcoinsDetailDto prpPcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPcoinsDetailAction.update(dbManager,prpPcoinsDetailDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public PrpPcoinsDetailDto findByPrimaryKey(String endorseNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        //����DTO
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpPcoinsDetailDto = blPrpPcoinsDetailAction.findByPrimaryKey(dbManager,endorseNo, serialNo, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPcoinsDetailDto;
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpPcoinsDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPcoinsDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpPcoinsDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpPcoinsDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
