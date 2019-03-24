package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalInsuremainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalInsuremainlist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ���嵥ͷ���ҵ���߼�������<br>
 */
public class BLMedicalInsuremainlistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalInsuremainlistActionBase.class);

    /**
     * ���캯��
     */
    public BLMedicalInsuremainlistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalInsuremainlistDto insuremainlistDto)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //�����¼
        dbInsuremainlist.insert(insuremainlistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode Ͷ���嵥���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //ɾ����¼
        dbInsuremainlist.delete(inusrelistcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //������ɾ����¼
        dbInsuremainlist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalInsuremainlistDto insuremainlistDto)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //���¼�¼
        dbInsuremainlist.update(insuremainlistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode Ͷ���嵥���
     * @return insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public MedicalInsuremainlistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        //����DTO
        MedicalInsuremainlistDto insuremainlistDto = null;
        //��ѯ����,��ֵ��DTO
        insuremainlistDto = dbInsuremainlist.findByPrimaryKey(inusrelistcode);
        return insuremainlistDto;
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
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbInsuremainlist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbInsuremainlist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����insuremainlistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbInsuremainlist.findByConditions(conditions);
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
        DBMedicalInsuremainlist dbInsuremainlist = new DBMedicalInsuremainlist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbInsuremainlist.getCount(conditions);
        return count;
    }
}
