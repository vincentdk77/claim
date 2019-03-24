package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyCollectAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyCollect-��֤�ռ�(�޸�)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-23 16:36:59.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyCollectFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyCollectFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLcertifyCollectAction.insert(dbManager,prpLcertifyCollectDto);
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
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(String businessNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcertifyCollectAction.delete(dbManager,businessNo, lossItemCode);
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcertifyCollectAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void update(PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcertifyCollectAction.update(dbManager,prpLcertifyCollectDto);
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
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @return prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public PrpLcertifyCollectDto findByPrimaryKey(String businessNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        //����DTO
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLcertifyCollectDto = blPrpLcertifyCollectAction.findByPrimaryKey(dbManager,businessNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcertifyCollectDto;
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcertifyCollectAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcertifyCollectDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcertifyCollectAction.findByConditions(dbManager,conditions);
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcertifyCollectAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
