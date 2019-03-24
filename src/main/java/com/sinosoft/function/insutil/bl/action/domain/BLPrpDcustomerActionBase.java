package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcustomer;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:19<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcustomerActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerDto prpDcustomerDto) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //�����¼
        dbPrpDcustomer.insert(prpDcustomerDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param customerCode customercode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //ɾ����¼
        dbPrpDcustomer.delete(customerCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //������ɾ����¼
        dbPrpDcustomer.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerDto prpDcustomerDto) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //���¼�¼
        dbPrpDcustomer.update(prpDcustomerDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param customerCode customercode
     * @return prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public PrpDcustomerDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //����DTO
        PrpDcustomerDto prpDcustomerDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcustomerDto = dbPrpDcustomer.findByPrimaryKey(customerCode);
        return prpDcustomerDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcustomerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcustomer.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcustomer.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcustomerDto�ļ���
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
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomer.getCount(conditions);
        return count;
    }
}
