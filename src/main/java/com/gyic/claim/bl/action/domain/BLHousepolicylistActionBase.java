package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBHousepolicylist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HOUSEPOLICYLIST��ҵ���߼�������<br>
 */
public class BLHousepolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistActionBase.class);

    /**
     * ���캯��
     */
    public BLHousepolicylistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HousepolicylistDto housepolicylistDto)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //�����¼
        dbHousepolicylist.insert(housepolicylistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //ɾ����¼
        dbHousepolicylist.delete(inusrelistcode, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //������ɾ����¼
        dbHousepolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HousepolicylistDto housepolicylistDto)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //���¼�¼
        dbHousepolicylist.update(housepolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @return housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public HousepolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //����DTO
        HousepolicylistDto housepolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        housepolicylistDto = dbHousepolicylist.findByPrimaryKey(inusrelistcode, idcard);
        return housepolicylistDto;
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
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHousepolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����housepolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHousepolicylist.findByConditions(conditions);
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
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHousepolicylist.getCount(conditions);
        return count;
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
    public PageRecord findIdcardByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHousepolicylist.getIdcardCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findIdcardByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findIdcardByConditions1(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHousepolicylist.getIdcardCount1(SqlUtils.getWherePartForGetCount(conditions));
collection = dbHousepolicylist.findIdcardByConditions1(conditions,pageNo,rowsPerPage);
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
    public PageRecord findAreacodeByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHousepolicylist.getAreacodeCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findAreacodeByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findAreacodeByConditions1(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHousepolicylist.getAreacodeCount1(SqlUtils.getWherePartForGetCount(conditions));
//System.err.println("conditions:"+ conditions);
collection = dbHousepolicylist.findAreacodeByConditions1(conditions,pageNo,rowsPerPage);
PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
return pageRecord;
}
}
