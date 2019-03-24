package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDpersonPay;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonPay��Ա�⸶��׼�����ҵ���߼�������<br>
 * ������ 2004-09-20 14:11:31.382<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDpersonPayActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //�����¼
        dbPrpDpersonPay.insert(prpDpersonPayDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //ɾ����¼
        dbPrpDpersonPay.delete(serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //������ɾ����¼
        dbPrpDpersonPay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //���¼�¼
        dbPrpDpersonPay.update(prpDpersonPayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @return prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public PrpDpersonPayDto findByPrimaryKey(DBManager dbManager,int serialNo) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //����DTO
        PrpDpersonPayDto prpDpersonPayDto = null;
        //��ѯ����,��ֵ��DTO
        prpDpersonPayDto = dbPrpDpersonPay.findByPrimaryKey(serialNo);
        return prpDpersonPayDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonPay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDpersonPay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDpersonPayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDpersonPay.findByConditions(conditions);
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
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonPay.getCount(conditions);
        return count;
    }
}
