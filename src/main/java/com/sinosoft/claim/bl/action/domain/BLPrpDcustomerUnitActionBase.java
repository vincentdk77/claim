package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomerUnit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcustomerUnit��λ�ͻ�������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerUnitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerUnitActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcustomerUnitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //�����¼
        dbPrpDcustomerUnit.insert(PrpDcustomerUnitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param customerCode �ͻ�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //ɾ����¼
        dbPrpDcustomerUnit.delete(customerCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //������ɾ����¼
        dbPrpDcustomerUnit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //���¼�¼
        dbPrpDcustomerUnit.update(PrpDcustomerUnitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param customerCode �ͻ�����
     * @return PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public PrpDcustomerUnitDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //����DTO
        PrpDcustomerUnitDto PrpDcustomerUnitDto = null;
        //��ѯ����,��ֵ��DTO
        PrpDcustomerUnitDto = dbPrpDcustomerUnit.findByPrimaryKey(customerCode);
        return PrpDcustomerUnitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����PrpDcustomerUnitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcustomerUnit.getCount(conditions);
        collection = dbPrpDcustomerUnit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomerUnit.getCount(conditions);
        return count;
    }
}
