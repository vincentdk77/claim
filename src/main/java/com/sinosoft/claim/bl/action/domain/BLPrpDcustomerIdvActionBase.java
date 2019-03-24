package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomerIdv;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer_idv���˿ͻ�������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcustomerIdvActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //�����¼
        dbPrpDcustomer_idv.insert(prpDcustomer_idvDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param customerCode �ͻ�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //ɾ����¼
        dbPrpDcustomer_idv.delete(customerCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //������ɾ����¼
        dbPrpDcustomer_idv.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //���¼�¼
        dbPrpDcustomer_idv.update(prpDcustomer_idvDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param customerCode �ͻ�����
     * @return prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //����DTO
        PrpDcustomerIdvDto prpDcustomer_idvDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcustomer_idvDto = dbPrpDcustomer_idv.findByPrimaryKey(customerCode);
        return prpDcustomer_idvDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcustomer_idvDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcustomer_idv.getCount(conditions);
        collection = dbPrpDcustomer_idv.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomer_idv.getCount(conditions);
        return count;
    }
}
