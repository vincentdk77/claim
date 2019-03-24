package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterrelation;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * �����м����������ŵ�ҵ���߼�������<br>
 */
public class BLPrplinterrelationActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplinterrelationActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //�����¼
        dbPrplinterrelation.insert(prplinterrelationDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,String outId)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //ɾ����¼
        dbPrplinterrelation.delete(id, outId);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //������ɾ����¼
        dbPrplinterrelation.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //���¼�¼
        dbPrplinterrelation.update(prplinterrelationDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id
     * @param outId �ͻ�������
     * @return prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public PrplinterrelationDto findByPrimaryKey(DBManager dbManager,String id,String outRigstNo)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //����DTO
        PrplinterrelationDto prplinterrelationDto = null;
        //��ѯ����,��ֵ��DTO
        prplinterrelationDto = dbPrplinterrelation.findByPrimaryKey(id, outRigstNo);
        return prplinterrelationDto;
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
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterrelation.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterrelation.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplinterrelationDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterrelation.findByConditions(conditions);
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
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterrelation.getCount(conditions);
        return count;
    }
    
}
