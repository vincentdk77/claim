package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpaytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPAY��ҵ���߼�������<br>
 */
public class BLPrplpaytgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplpaytgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplpaytgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplpayDto prplpaytgDto)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //�����¼
        dbPrplpaytg.insert(prplpaytgDto);
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
//        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
//        //ɾ����¼
//        dbPrplpaytg.delete(serialno, compensateno);
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //ɾ����¼
        dbPrplpaytg.delete(serialno, compensateno, serialno2);
    }
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //������ɾ����¼
        dbPrplpaytg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplpayDto prplpaytgDto)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //���¼�¼
        dbPrplpaytg.update(prplpaytgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
//        //����DTO
//        PrplpayDto prplpaytgDto = null;
//        //��ѯ����,��ֵ��DTO
//        prplpaytgDto = dbPrplpaytg.findByPrimaryKey(serialno, compensateno);
//        return prplpaytgDto;
//    }
    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //����DTO
        PrplpayDto prplpaytgDto = null;
        //��ѯ����,��ֵ��DTO
        prplpaytgDto = dbPrplpaytg.findByPrimaryKey(serialno, compensateno, serialno2);
        return prplpaytgDto;
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpaytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplpaytg.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.findByConditions(conditions);
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpaytg.getCount(conditions);
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
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        //������ɾ����¼
        dbPrplpaytg.deleteByConditionsByPrepered(conditions);
    }
    /******************************�Ż��޸�:end***********************************/
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplpayDto�ļ���
     * @throws Exception
     */
    public Collection getSumPayamount(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpaytg dbPrplpaytg = new DBPrplpaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpaytg.getSumPayamount(conditions);
        return collection;
    }
}
