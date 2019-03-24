package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELISTTEMP��ҵ���߼�������<br>
 */
public class BLPlantingsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelisttempActionBase.class);

    /**
     * ���캯��
     */
    public BLPlantingsettlelisttempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //�����¼
        dbPlantingsettlelisttemp.insert(plantingsettlelisttempDto);
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
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //ɾ����¼
        dbPlantingsettlelisttemp.delete(registcode, indexofsettle, stringtimestamp);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //������ɾ����¼
        dbPlantingsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //���¼�¼
        dbPlantingsettlelisttemp.update(plantingsettlelisttempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public PlantingsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //����DTO
        PlantingsettlelisttempDto plantingsettlelisttempDto = null;
        //��ѯ����,��ֵ��DTO
        plantingsettlelisttempDto = dbPlantingsettlelisttemp.findByPrimaryKey(registcode, indexofsettle, stringtimestamp);
        return plantingsettlelisttempDto;
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
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����plantingsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingsettlelisttemp.findByConditions(conditions);
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
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelisttemp.getCount(conditions);
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
    	DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
