package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDSETTLELIST��ҵ���߼�������<br>
 */
public class BLHerdsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistActionBase.class);

    /**
     * ���캯��
     */
    public BLHerdsettlelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //�����¼
        dbHerdsettlelist.insert(herdsettlelistDto);
    }
    
    /**
     * �����������
     * @param dbManager DB������
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,List list)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //�����¼
        dbHerdsettlelist.insertAll(list);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //ɾ����¼
        dbHerdsettlelist.delete(settlelistcode, earlabel, fcode, kindcode, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //������ɾ����¼
        dbHerdsettlelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //���¼�¼
        dbHerdsettlelist.update(herdsettlelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @return herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public HerdsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        //����DTO
        HerdsettlelistDto herdsettlelistDto = null;
        //��ѯ����,��ֵ��DTO
        herdsettlelistDto = dbHerdsettlelist.findByPrimaryKey(settlelistcode, earlabel, fcode, kindcode, serialno);
        return herdsettlelistDto;
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
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHerdsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����herdsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHerdsettlelist.findByConditions(conditions);
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
        DBHerdsettlelist dbHerdsettlelist = new DBHerdsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdsettlelist.getCount(conditions);
        return count;
    }
}
