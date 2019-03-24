package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGER��ҵ���߼�������<br>
 */
public class BLPrpljobmanagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagerActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpljobmanagerActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //�����¼
        dbPrpljobmanager.insert(prpljobmanagerDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //ɾ����¼
        dbPrpljobmanager.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //������ɾ����¼
        dbPrpljobmanager.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //���¼�¼
        dbPrpljobmanager.update(prpljobmanagerDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ID
     * @return prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public PrpljobmanagerDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //����DTO
        PrpljobmanagerDto prpljobmanagerDto = null;
        //��ѯ����,��ֵ��DTO
        prpljobmanagerDto = dbPrpljobmanager.findByPrimaryKey(id);
        return prpljobmanagerDto;
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
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanager.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpljobmanager.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpljobmanagerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpljobmanager.findByConditions(conditions);
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
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanager.getCount(conditions);
        return count;
    }
}
