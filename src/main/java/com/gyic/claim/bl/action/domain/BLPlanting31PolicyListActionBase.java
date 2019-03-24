package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31PolicyList;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31PolicyList��ҵ���߼�������<br>
 */
public class BLPlanting31PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31PolicyListActionBase.class);

    /**
     * ���캯��
     */
    public BLPlanting31PolicyListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //�����¼
        dbPlanting31PolicyList.insert(planting31PolicyListDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //ɾ����¼
        dbPlanting31PolicyList.delete(inusreListCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //������ɾ����¼
        dbPlanting31PolicyList.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //���¼�¼
        dbPlanting31PolicyList.update(planting31PolicyListDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @return planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public Planting31PolicyListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //����DTO
        Planting31PolicyListDto planting31PolicyListDto = null;
        //��ѯ����,��ֵ��DTO
        planting31PolicyListDto = dbPlanting31PolicyList.findByPrimaryKey(inusreListCode);
        return planting31PolicyListDto;
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31PolicyList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31PolicyList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����planting31PolicyListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31PolicyList.findByConditions(conditions);
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31PolicyList.getCount(conditions);
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31PolicyList.getSum(conditions,fieldName);
        return sum;
    }
}
