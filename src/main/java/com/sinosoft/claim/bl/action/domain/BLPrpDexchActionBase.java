package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDexchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDexch;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdexch�һ��ʵ�ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDexchActionBase{
    private static Log log = LogFactory.getLog(BLPrpDexchActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDexchActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDexchDto prpDexchDto) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //�����¼
        dbPrpDexch.insert(prpDexchDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param exchDate ��������
     * @param baseCurrency ��׼�ұ�
     * @param exchCurrency �һ��ұ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //ɾ����¼
        dbPrpDexch.delete(exchDate, baseCurrency, exchCurrency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //������ɾ����¼
        dbPrpDexch.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDexchDto prpDexchDto) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //���¼�¼
        dbPrpDexch.update(prpDexchDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param exchDate ��������
     * @param baseCurrency ��׼�ұ�
     * @param exchCurrency �һ��ұ�
     * @return prpDexchDto prpDexchDto
     * @throws Exception
     */
    public PrpDexchDto findByPrimaryKey(DBManager dbManager,DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //����DTO
        PrpDexchDto prpDexchDto = null;
        //��ѯ����,��ֵ��DTO
        prpDexchDto = dbPrpDexch.findByPrimaryKey(exchDate, baseCurrency, exchCurrency);
        return prpDexchDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDexchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDexch.getCount(conditions);
        collection = dbPrpDexch.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDexch.getCount(conditions);
        return count;
    }
}
