package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCplan;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcplan�շѼƻ����ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCplanActionBase{
    private static Log log = LogFactory.getLog(BLPrpCplanActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCplanActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCplanDto prpCplanDto) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //�����¼
        dbPrpCplan.insert(prpCplanDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���Ѵ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //ɾ����¼
        dbPrpCplan.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //������ɾ����¼
        dbPrpCplan.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCplanDto prpCplanDto) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //���¼�¼
        dbPrpCplan.update(prpCplanDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���Ѵ������
     * @return prpCplanDto prpCplanDto
     * @throws Exception
     */
    public PrpCplanDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //����DTO
        PrpCplanDto prpCplanDto = null;
        //��ѯ����,��ֵ��DTO
        prpCplanDto = dbPrpCplan.findByPrimaryKey(policyNo, serialNo);
        return prpCplanDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCplanDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCplan.getCount(conditions);
        collection = dbPrpCplan.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCplan.getCount(conditions);
        return count;
    }
}
