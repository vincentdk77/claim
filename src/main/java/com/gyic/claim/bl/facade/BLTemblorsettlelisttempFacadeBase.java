package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelisttempAction;
import com.gyic.claim.bl.action.domain.BLTemblorsettlelisttempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELISTTEMP��ҵ���߼�����Facade����<br>
 */
public class BLTemblorsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelisttempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorsettlelisttempFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void insert(TemblorsettlelisttempDto temblorsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorsettlelisttempAction.insert(dbManager,temblorsettlelisttempDto);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorsettlelisttempAction.delete(dbManager,registcode, stringtimestamp, indexofsettle);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void update(TemblorsettlelisttempDto temblorsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorsettlelisttempAction.update(dbManager,temblorsettlelisttempDto);
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
     * @return temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public TemblorsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        //����DTO
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorsettlelisttempDto = blTemblorsettlelisttempAction.findByPrimaryKey(dbManager,registcode, stringtimestamp, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorsettlelisttempDto;
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelisttempAction.getCount(dbManager,conditions);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blTemblorsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
