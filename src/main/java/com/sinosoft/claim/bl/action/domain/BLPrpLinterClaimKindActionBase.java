package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimKind;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������������Ϣ��ҵ���߼�������<br>
 */
public class BLPrpLinterClaimKindActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimKindActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterClaimKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //�����¼
        dbPrpLinterClaimKind.insert(prpLinterClaimKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //ɾ����¼
        dbPrpLinterClaimKind.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //������ɾ����¼
        dbPrpLinterClaimKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //���¼�¼
        dbPrpLinterClaimKind.update(prpLinterClaimKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @return prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public PrpLinterClaimKindDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //����DTO
        PrpLinterClaimKindDto prpLinterClaimKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterClaimKindDto = dbPrpLinterClaimKind.findByPrimaryKey(id);
        return prpLinterClaimKindDto;
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
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterClaimKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterClaimKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterClaimKind.findByConditions(conditions);
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
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimKind.getCount(conditions);
        return count;
    }
}
