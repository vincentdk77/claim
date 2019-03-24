package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcurrencyDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcurrency;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcurrency��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcurrencyActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcurrencyActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param currencyCode currencycode
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
     * @param currencyCode currencycode
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

        count = dbPrpDcurrency.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcurrency.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcurrencyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcurrency.getCount(conditions);
        return count;
    }
}
