package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ע��������Ϣ�������ҵ���߼�������<br>
 */
public class BLPrpLinterCancelClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //�����¼
        dbPrpLinterCancelClaimDetail.insert(prpLinterCancelClaimDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //ɾ����¼
        dbPrpLinterCancelClaimDetail.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //������ɾ����¼
        dbPrpLinterCancelClaimDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //���¼�¼
        dbPrpLinterCancelClaimDetail.update(prpLinterCancelClaimDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public PrpLinterCancelClaimDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //����DTO
        PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCancelClaimDetailDto = dbPrpLinterCancelClaimDetail.findByPrimaryKey(id);
        return prpLinterCancelClaimDetailDto;
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
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCancelClaimDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCancelClaimDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCancelClaimDetail.findByConditions(conditions);
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
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimDetail.getCount(conditions);
        return count;
    }
}
