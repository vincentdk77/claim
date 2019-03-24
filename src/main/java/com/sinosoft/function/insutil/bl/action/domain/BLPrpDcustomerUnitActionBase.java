package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcustomerUnit;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomerunit��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerUnitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerUnitActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcustomerUnitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcustomerUnitDto prpDcustomerUnitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //�����¼
        dbPrpDcustomerUnit.insert(prpDcustomerUnitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param customerCode customercode
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
     * @param prpDcustomerUnitDto prpDcustomerUnitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //���¼�¼
        dbPrpDcustomerUnit.update(prpDcustomerUnitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param customerCode customercode
     * @return prpDcustomerUnitDto prpDcustomerUnitDto
     * @throws Exception
     */
    public PrpDcustomerUnitDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //����DTO
        PrpDcustomerUnitDto prpDcustomerUnitDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcustomerUnitDto = dbPrpDcustomerUnit.findByPrimaryKey(customerCode);
        return prpDcustomerUnitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcustomerUnitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcustomerUnit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcustomerUnit.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcustomerUnitDto�ļ���
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
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomerUnit.getCount(conditions);
        return count;
    }
}
