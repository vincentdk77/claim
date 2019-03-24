package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPrepayFee;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ԥ�������Ϣ���ҵ���߼�������<br>
 */
public class BLPrpLinterPrepayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPrepayFeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPrepayFeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //�����¼
        dbPrpLinterPrepayFee.insert(prpLinterPrepayFeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //ɾ����¼
        dbPrpLinterPrepayFee.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //������ɾ����¼
        dbPrpLinterPrepayFee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //���¼�¼
        dbPrpLinterPrepayFee.update(prpLinterPrepayFeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ���� PK
     * @return prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public PrpLinterPrepayFeeDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        //����DTO
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPrepayFeeDto = dbPrpLinterPrepayFee.findByPrimaryKey(id);
        return prpLinterPrepayFeeDto;
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
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPrepayFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPrepayFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPrepayFeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPrepayFee.findByConditions(conditions);
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
        DBPrpLinterPrepayFee dbPrpLinterPrepayFee = new DBPrpLinterPrepayFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPrepayFee.getCount(conditions);
        return count;
    }
}
