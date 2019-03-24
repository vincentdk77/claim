package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelisttemp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����MEDICALSETTLELISTTEMP��ҵ���߼�������<br>
 */
public class BLMedicalsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelisttempActionBase.class);

    /**
     * ���캯��
     */
    public BLMedicalsettlelisttempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalsettlelisttempDto medicalsettlelisttempDto)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //�����¼
        dbMedicalsettlelisttemp.insert(medicalsettlelisttempDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //ɾ����¼
        dbMedicalsettlelisttemp.delete(registcode, indexofsettle, stringtimestamp);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //������ɾ����¼
        dbMedicalsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalsettlelisttempDto medicalsettlelisttempDto)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //���¼�¼
        dbMedicalsettlelisttemp.update(medicalsettlelisttempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public MedicalsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //����DTO
        MedicalsettlelisttempDto medicalsettlelisttempDto = null;
        //��ѯ����,��ֵ��DTO
        medicalsettlelisttempDto = dbMedicalsettlelisttemp.findByPrimaryKey(registcode, indexofsettle, stringtimestamp);
        return medicalsettlelisttempDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMedicalsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����medicalsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalsettlelisttemp.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelisttemp.getCount(conditions);
        return count;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
    	DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbMedicalsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
