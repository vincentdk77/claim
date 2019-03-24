package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelisttemp;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleListTemp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELISTTEMP��ҵ���߼�������<br>
 */
public class BLNyxsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelisttempActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelisttempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //�����¼
        dbNyxsettlelisttemp.insert(nyxsettlelisttempDto);
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
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //ɾ����¼
        dbNyxsettlelisttemp.delete(registcode, stringtimestamp, indexofsettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //������ɾ����¼
        dbNyxsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //���¼�¼
        dbNyxsettlelisttemp.update(nyxsettlelisttempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        //����DTO
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        //��ѯ����,��ֵ��DTO
        nyxsettlelisttempDto = dbNyxsettlelisttemp.findByPrimaryKey(registcode, stringtimestamp, indexofsettle);
        return nyxsettlelisttempDto;
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
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxsettlelisttemp.findByConditions(conditions);
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
        DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelisttemp.getCount(conditions);
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
    	DBNyxsettlelisttemp dbNyxsettlelisttemp = new DBNyxsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbNyxsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
