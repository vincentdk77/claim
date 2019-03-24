package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCaddressDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCaddress;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcaddress���յ�ַ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCaddressActionBase{
    private static Log log = LogFactory.getLog(BLPrpCaddressActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCaddressActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCaddressDto prpCaddressDto) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //�����¼
        dbPrpCaddress.insert(prpCaddressDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param addressNo ��ַ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int addressNo) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //ɾ����¼
        dbPrpCaddress.delete(policyNo, addressNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //������ɾ����¼
        dbPrpCaddress.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCaddressDto prpCaddressDto) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //���¼�¼
        dbPrpCaddress.update(prpCaddressDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param addressNo ��ַ���
     * @return prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto findByPrimaryKey(DBManager dbManager,String policyNo,int addressNo) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //����DTO
        PrpCaddressDto prpCaddressDto = null;
        //��ѯ����,��ֵ��DTO
        prpCaddressDto = dbPrpCaddress.findByPrimaryKey(policyNo, addressNo);
        return prpCaddressDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCaddressDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCaddress.getCount(conditions);
        collection = dbPrpCaddress.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCaddress.getCount(conditions);
        return count;
    }
}
