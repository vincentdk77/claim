package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLcfeecoinsAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcfeecoins��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcfeecoinsFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void insert(PrpLcfeecoinsDto prpLcfeecoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLcfeecoinsAction.insert(dbManager,prpLcfeecoinsDto);
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
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcfeecoinsAction.delete(dbManager,businessNo, serialNo);
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcfeecoinsAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void update(PrpLcfeecoinsDto prpLcfeecoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcfeecoinsAction.update(dbManager,prpLcfeecoinsDto);
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
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @return prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public PrpLcfeecoinsDto findByPrimaryKey(String businessNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        //����DTO
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLcfeecoinsDto = blPrpLcfeecoinsAction.findByPrimaryKey(dbManager,businessNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcfeecoinsDto;
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcfeecoinsAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcfeecoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcfeecoinsAction.findByConditions(dbManager,conditions);
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcfeecoinsAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
