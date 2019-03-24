package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpCcoinsDetailAction;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoinsDetail��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpCcoinsDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void insert(PrpCcoinsDetailDto prpCcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpCcoinsDetailAction.insert(dbManager,prpCcoinsDetailDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(String policyNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpCcoinsDetailAction.delete(dbManager,policyNo, serialNo, currency);
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
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpCcoinsDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void update(PrpCcoinsDetailDto prpCcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpCcoinsDetailAction.update(dbManager,prpCcoinsDetailDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public PrpCcoinsDetailDto findByPrimaryKey(String policyNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        //����DTO
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpCcoinsDetailDto = blPrpCcoinsDetailAction.findByPrimaryKey(dbManager,policyNo, serialNo, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCcoinsDetailDto;
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
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpCcoinsDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpCcoinsDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpCcoinsDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpCcoinsDetailAction blPrpCcoinsDetailAction = new BLPrpCcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpCcoinsDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
