package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelisttemp;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorsettlelisttemp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELISTTEMP��ҵ���߼�������<br>
 */
public class BLTemblorsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelisttempActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorsettlelisttempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //�����¼
        dbTemblorsettlelisttemp.insert(temblorsettlelisttempDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //ɾ����¼
        dbTemblorsettlelisttemp.delete(registcode, stringtimestamp, indexofsettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //������ɾ����¼
        dbTemblorsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //���¼�¼
        dbTemblorsettlelisttemp.update(temblorsettlelisttempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public TemblorsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //����DTO
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        //��ѯ����,��ֵ��DTO
        temblorsettlelisttempDto = dbTemblorsettlelisttemp.findByPrimaryKey(registcode, stringtimestamp, indexofsettle);
        return temblorsettlelisttempDto;
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
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorsettlelisttemp.findByConditions(conditions);
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
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelisttemp.getCount(conditions);
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
    	DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbTemblorsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
