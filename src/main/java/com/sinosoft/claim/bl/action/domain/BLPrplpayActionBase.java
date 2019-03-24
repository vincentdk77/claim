package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPAY��ҵ���߼�������<br>
 */
public class BLPrplpayActionBase{
    private static Logger logger = Logger.getLogger(BLPrplpayActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplpayActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplpayDto prplpayDto)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //�����¼
        dbPrplpay.insert(prplpayDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
//        //ɾ����¼
//        dbPrplpay.delete(serialno, compensateno);
//    }
    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //ɾ����¼
        dbPrplpay.delete(serialno, compensateno, serialno2);
    }
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //������ɾ����¼
        dbPrplpay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplpayDto prplpayDto)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //���¼�¼
        dbPrplpay.update(prplpayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
//        //����DTO
//        PrplpayDto prplpayDto = null;
//        //��ѯ����,��ֵ��DTO
//        prplpayDto = dbPrplpay.findByPrimaryKey(serialno, compensateno);
//        return prplpayDto;
//    }
    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //����DTO
        PrplpayDto prplpayDto = null;
        //��ѯ����,��ֵ��DTO
        prplpayDto = dbPrplpay.findByPrimaryKey(serialno, compensateno, serialno2);
        return prplpayDto;
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
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplpay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplpayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditions(conditions);
        return collection;
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplpayDto�ļ���
     * @throws Exception
     */
    public Collection getSumPayamount(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.getSumPayamount(conditions);
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
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpay.getCount(conditions);
        return count;
    }
    /******************************�Ż��޸�:start***********************************/
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //������ɾ����¼
        dbPrplpay.deleteByConditionsByPrepered(conditions);
    }
    /******************************�Ż��޸�:end***********************************/
}
