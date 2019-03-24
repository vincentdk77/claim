package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDPOLICYLIST��ҵ���߼�������<br>
 */
public class BLHerdpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistActionBase.class);

    /**
     * ���캯��
     */
    public BLHerdpolicylistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //�����¼
        dbHerdpolicylist.insert(herdpolicylistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //ɾ����¼
        dbHerdpolicylist.delete(inusrelistcode, earlabel, kindcode, fcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //������ɾ����¼
        dbHerdpolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //���¼�¼
        dbHerdpolicylist.update(herdpolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @return herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public HerdpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //����DTO
        HerdpolicylistDto herdpolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        herdpolicylistDto = dbHerdpolicylist.findByPrimaryKey(inusrelistcode, earlabel, kindcode, fcode);
        return herdpolicylistDto;
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
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHerdpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public PageRecord findEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHerdpolicylist.getEarCount(SqlUtils.getWherePartForGetCount(conditions),fname,earno);
        collection = dbHerdpolicylist.findEarByConditions(conditions,pageNo,rowsPerPage,fname,earno);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHerdpolicylist.getEarCount(SqlUtils.getWherePartForGetCount(conditions));
collection = dbHerdpolicylist.findEarByConditions(conditions,pageNo,rowsPerPage);
PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
return pageRecord;
}
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����herdpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHerdpolicylist.findByConditions(conditions);
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
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdpolicylist.getCount(conditions);
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
    	DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbHerdpolicylist.getSum(conditions,fieldName);
        return sum;
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
    public PageRecord findNEWEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHerdpolicylist.getNEWEarCount(SqlUtils.getWherePartForGetCount(conditions),fname,earno);
        collection = dbHerdpolicylist.findNEWEarByConditions(conditions,pageNo,rowsPerPage,fname,earno);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
