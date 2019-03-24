package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRecoveryOrPay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLRecoveryOrPayActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLRecoveryOrPayActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLRecoveryOrPayActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLRecoveryOrPayDto prpLRecoveryOrPaysDto) throws Exception{
        DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //�����¼
        dbPrpLRecoveryOrPay.insert(prpLRecoveryOrPaysDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //ɾ����¼
    	dbPrpLRecoveryOrPay.delete(compensateNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //������ɾ����¼
    	dbPrpLRecoveryOrPay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLRecoveryOrPayDto prpLRecoveryOrPayDto) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //���¼�¼
    	dbPrpLRecoveryOrPay.update(prpLRecoveryOrPayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @return prpLlossDto prpLlossDto
     * @throws Exception
     */
    public PrpLRecoveryOrPayDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //����DTO
    	PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        //��ѯ����,��ֵ��DTO
    	prpLRecoveryOrPayDto = dbPrpLRecoveryOrPay.findByPrimaryKey(compensateNo, serialNo);
        return prpLRecoveryOrPayDto;
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
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRecoveryOrPay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLRecoveryOrPay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLlossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLRecoveryOrPay.findByConditions(conditions);
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
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRecoveryOrPay.getCount(conditions);
        return count;
    }
}
