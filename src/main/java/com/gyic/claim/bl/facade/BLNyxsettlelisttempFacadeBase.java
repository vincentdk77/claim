package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelisttempAction;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListTempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELISTTEMP��ҵ���߼�����Facade����<br>
 */
public class BLNyxsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelisttempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelisttempFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void insert(NyxsettlelisttempDto nyxsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxsettlelisttempAction.insert(dbManager,nyxsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxsettlelisttempAction.delete(dbManager,registcode, stringtimestamp, indexofsettle);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void update(NyxsettlelisttempDto nyxsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxsettlelisttempAction.update(dbManager,nyxsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        //����DTO
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxsettlelisttempDto = blNyxsettlelisttempAction.findByPrimaryKey(dbManager,registcode, stringtimestamp, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxsettlelisttempDto;
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxsettlelisttempAction.getCount(dbManager,conditions);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
