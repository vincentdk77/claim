package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoins;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccoins������Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcoinsActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcoinsActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCcoinsActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcoinsDto prpCcoinsDto) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //�����¼
        dbPrpCcoins.insert(prpCcoinsDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //ɾ����¼
        dbPrpCcoins.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //������ɾ����¼
        dbPrpCcoins.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcoinsDto prpCcoinsDto) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //���¼�¼
        dbPrpCcoins.update(prpCcoinsDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //����DTO
        PrpCcoinsDto prpCcoinsDto = null;
        //��ѯ����,��ֵ��DTO
        prpCcoinsDto = dbPrpCcoins.findByPrimaryKey(policyNo, serialNo);
        return prpCcoinsDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCcoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcoins.getCount(conditions);
        collection = dbPrpCcoins.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoins.getCount(conditions);
        return count;
    }
}
