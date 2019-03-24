package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCguarantyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCguaranty;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcguaranty������Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCguarantyActionBase{
    private static Log log = LogFactory.getLog(BLPrpCguarantyActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCguarantyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCguarantyDto prpCguarantyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCguarantyDto prpCguarantyDto) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        //�����¼
        dbPrpCguaranty.insert(prpCguarantyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        //ɾ����¼
        dbPrpCguaranty.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        //������ɾ����¼
        dbPrpCguaranty.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCguarantyDto prpCguarantyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCguarantyDto prpCguarantyDto) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        //���¼�¼
        dbPrpCguaranty.update(prpCguarantyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCguarantyDto prpCguarantyDto
     * @throws Exception
     */
    public PrpCguarantyDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        //����DTO
        PrpCguarantyDto prpCguarantyDto = null;
        //��ѯ����,��ֵ��DTO
        prpCguarantyDto = dbPrpCguaranty.findByPrimaryKey(policyNo, serialNo);
        return prpCguarantyDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCguarantyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCguaranty.getCount(conditions);
        collection = dbPrpCguaranty.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCguaranty dbPrpCguaranty = new DBPrpCguaranty(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCguaranty.getCount(conditions);
        return count;
    }
}
