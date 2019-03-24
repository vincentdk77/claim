package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayExttg;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧������������ҵ���߼�������<br>
 */
public class BLPrpLpayExttgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExttgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayExttgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //�����¼
        dbPrpLpayExt.insert(prpLpayExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param paymentNo �ո����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo,int serialNo)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //ɾ����¼
        dbPrpLpayExt.delete(paymentNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //������ɾ����¼
        dbPrpLpayExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //���¼�¼
        dbPrpLpayExt.update(prpLpayExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param paymentNo �ո����
     * @param serialNo ���
     * @return prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public PrpLpayExtDto findByPrimaryKey(DBManager dbManager,String paymentNo,int serialNo)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //����DTO
        PrpLpayExtDto prpLpayExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayExtDto = dbPrpLpayExt.findByPrimaryKey(paymentNo, serialNo);
        return prpLpayExtDto;
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
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayExt.findByConditions(conditions);
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
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayExt.getCount(conditions);
        return count;
    }
    /***************************�Ż��޸ģ�start*****************************/
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //������ɾ����¼
        dbPrpLpayExt.deleteByConditionsByPrepered(conditions);
    }
    /***************************�Ż��޸ģ�end*****************************/
}
