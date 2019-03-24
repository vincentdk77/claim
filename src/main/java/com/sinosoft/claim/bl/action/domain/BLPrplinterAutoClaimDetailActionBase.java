package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterAutoClaimDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�������Զ�����״̬��ѯ���ҵ���߼�������<br>
 */
public class BLPrplinterAutoClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplinterAutoClaimDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //�����¼
        dbPrplinterAutoClaimDetail.insert(prplinterAutoClaimDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,String registNo)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //ɾ����¼
        dbPrplinterAutoClaimDetail.delete(id, registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //������ɾ����¼
        dbPrplinterAutoClaimDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //���¼�¼
        dbPrplinterAutoClaimDetail.update(prplinterAutoClaimDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����
     * @param registNo ��������
     * @return prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public PrplinterAutoClaimDetailDto findByPrimaryKey(DBManager dbManager,String id,String registNo)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //����DTO
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prplinterAutoClaimDetailDto = dbPrplinterAutoClaimDetail.findByPrimaryKey(id, registNo);
        return prplinterAutoClaimDetailDto;
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
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterAutoClaimDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterAutoClaimDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplinterAutoClaimDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterAutoClaimDetail.findByConditions(conditions);
        return collection;
    }
    
    /**
     * ��SQL����һ������(���������޷����)
     * @param dbManager DB������
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void updateBySQL(DBManager dbManager,String sql)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //���¼�¼
        dbPrplinterAutoClaimDetail.updateBySQL(sql);
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
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterAutoClaimDetail.getCount(conditions);
        return count;
    }
}
