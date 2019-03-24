package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleListTemp;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31SettleListTemp��ҵ���߼�������<br>
 */
public class BLPlanting31SettleListTempActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListTempActionBase.class);

    /**
     * ���캯��
     */
    public BLPlanting31SettleListTempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //�����¼
        dbPlanting31SettleListTemp.insert(planting31SettleListTempDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //ɾ����¼
        dbPlanting31SettleListTemp.delete(registCode, stringTimeStamp, indexOfSettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //������ɾ����¼
        dbPlanting31SettleListTemp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //���¼�¼
        dbPlanting31SettleListTemp.update(planting31SettleListTempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public Planting31SettleListTempDto findByPrimaryKey(DBManager dbManager,String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //����DTO
        Planting31SettleListTempDto planting31SettleListTempDto = null;
        //��ѯ����,��ֵ��DTO
        planting31SettleListTempDto = dbPlanting31SettleListTemp.findByPrimaryKey(registCode, stringTimeStamp, indexOfSettle);
        return planting31SettleListTempDto;
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleListTemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31SettleListTemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����planting31SettleListTempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31SettleListTemp.findByConditions(conditions);
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleListTemp.getCount(conditions);
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleListTemp.getSum(conditions,fieldName);
        return sum;
    }

}
