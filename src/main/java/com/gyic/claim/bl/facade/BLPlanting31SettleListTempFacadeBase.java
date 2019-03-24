package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListTempAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelisttempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31SettleListTemp��ҵ���߼�����Facade����<br>
 */
public class BLPlanting31SettleListTempFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListTempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPlanting31SettleListTempFacadeBase(){
    }

    /**
     * ����һ������
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void insert(Planting31SettleListTempDto planting31SettleListTempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blPlanting31SettleListTempAction.insert(dbManager,planting31SettleListTempDto);
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
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(String registCode,String stringTimeStamp,int indexOfSettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPlanting31SettleListTempAction.delete(dbManager,registCode, stringTimeStamp, indexOfSettle);
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
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPlanting31SettleListTempAction.deleteByConditions(dbManager,conditions);
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
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void update(Planting31SettleListTempDto planting31SettleListTempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPlanting31SettleListTempAction.update(dbManager,planting31SettleListTempDto);
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
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public Planting31SettleListTempDto findByPrimaryKey(String registCode,String stringTimeStamp,int indexOfSettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        //����DTO
        Planting31SettleListTempDto planting31SettleListTempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            planting31SettleListTempDto = blPlanting31SettleListTempAction.findByPrimaryKey(dbManager,registCode, stringTimeStamp, indexOfSettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return planting31SettleListTempDto;
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
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlanting31SettleListTempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����planting31SettleListTempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlanting31SettleListTempAction.findByConditions(dbManager,conditions);
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
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlanting31SettleListTempAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
        double sum=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlanting31SettleListTempAction blPlanting31SettleListTempAction = new BLPlanting31SettleListTempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlanting31SettleListTempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
