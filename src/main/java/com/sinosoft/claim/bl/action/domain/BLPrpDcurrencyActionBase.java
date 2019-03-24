package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcurrency;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcurrency�ұ������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcurrencyActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcurrencyActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcurrencyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //�����¼
        dbPrpDcurrency.insert(prpDcurrencyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param currencyCode �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String currencyCode) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //ɾ����¼
        dbPrpDcurrency.delete(currencyCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //������ɾ����¼
        dbPrpDcurrency.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //���¼�¼
        dbPrpDcurrency.update(prpDcurrencyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param currencyCode �ұ����
     * @return prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public PrpDcurrencyDto findByPrimaryKey(DBManager dbManager,String currencyCode) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //����DTO
        PrpDcurrencyDto prpDcurrencyDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcurrencyDto = dbPrpDcurrency.findByPrimaryKey(currencyCode);
        return prpDcurrencyDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcurrencyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcurrency.getCount(conditions);
        collection = dbPrpDcurrency.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcurrency.getCount(conditions);
        return count;
    }
}
