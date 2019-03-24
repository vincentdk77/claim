package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLMedicalsettlelisttempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELISTTEMP��ҵ���߼�����Facade����<br>
 */
public class BLMedicalsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelisttempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLMedicalsettlelisttempFacadeBase(){
    }

    /**
     * ����һ������
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void insert(MedicalsettlelisttempDto medicalsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //�����¼
            blMedicalsettlelisttempAction.insert(dbManager,medicalsettlelisttempDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blMedicalsettlelisttempAction.delete(dbManager,registcode, indexofsettle, stringtimestamp);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blMedicalsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void update(MedicalsettlelisttempDto medicalsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blMedicalsettlelisttempAction.update(dbManager,medicalsettlelisttempDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public MedicalsettlelisttempDto findByPrimaryKey(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        //����DTO
        MedicalsettlelisttempDto medicalsettlelisttempDto = null;
        try{
            dbManager.open("JKXDataSource");
            //��ѯ����,��ֵ��DTO
            medicalsettlelisttempDto = blMedicalsettlelisttempAction.findByPrimaryKey(dbManager,registcode, indexofsettle, stringtimestamp);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return medicalsettlelisttempDto;
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            pageRecord = blMedicalsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����medicalsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blMedicalsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelisttempAction.getCount(dbManager,conditions);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            sum = blMedicalsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
