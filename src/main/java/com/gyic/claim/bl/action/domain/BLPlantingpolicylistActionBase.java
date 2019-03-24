package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGPOLICYLIST��ҵ���߼�������<br>
 */
public class BLPlantingpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistActionBase.class);

    /**
     * ���캯��
     */
    public BLPlantingpolicylistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //�����¼
        dbPlantingpolicylist.insert(plantingpolicylistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //ɾ����¼
        dbPlantingpolicylist.delete(inusrelistcode, fcode, kindcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //������ɾ����¼
        dbPlantingpolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //���¼�¼
        dbPlantingpolicylist.update(plantingpolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public PlantingpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //����DTO
        PlantingpolicylistDto plantingpolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        plantingpolicylistDto = dbPlantingpolicylist.findByPrimaryKey(inusrelistcode, fcode, kindcode);
        return plantingpolicylistDto;
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����plantingpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingpolicylist.findByConditions(conditions);
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingpolicylist.getCount(conditions);
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingpolicylist.getSum(conditions,fieldName);
        return sum;
    }
}
