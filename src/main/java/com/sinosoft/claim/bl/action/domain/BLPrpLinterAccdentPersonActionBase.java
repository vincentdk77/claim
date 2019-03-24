package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterAccdentPerson;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ӿ��¹�����Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterAccdentPersonActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterAccdentPersonActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterAccdentPersonActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //�����¼
        dbPrpLinterAccdentPerson.insert(prpLinterAccdentPersonDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //ɾ����¼
        dbPrpLinterAccdentPerson.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //������ɾ����¼
        dbPrpLinterAccdentPerson.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //���¼�¼
        dbPrpLinterAccdentPerson.update(prpLinterAccdentPersonDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public PrpLinterAccdentPersonDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        //����DTO
        PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterAccdentPersonDto = dbPrpLinterAccdentPerson.findByPrimaryKey(id);
        return prpLinterAccdentPersonDto;
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
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterAccdentPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterAccdentPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterAccdentPersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterAccdentPerson.findByConditions(conditions);
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
        DBPrpLinterAccdentPerson dbPrpLinterAccdentPerson = new DBPrpLinterAccdentPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterAccdentPerson.getCount(conditions);
        return count;
    }
}
