package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitemkind���������Ϣ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemKindActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCitemKindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCitemKindDto prpCitemKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCitemKindDto prpCitemKindDto) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        //�����¼
        dbPrpCitemKind.insert(prpCitemKindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemKindNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int itemKindNo) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        //ɾ����¼
        dbPrpCitemKind.delete(policyNo, itemKindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        //������ɾ����¼
        dbPrpCitemKind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCitemKindDto prpCitemKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCitemKindDto prpCitemKindDto) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        //���¼�¼
        dbPrpCitemKind.update(prpCitemKindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param itemKindNo ���
     * @return prpCitemKindDto prpCitemKindDto
     * @throws Exception
     */
    public PrpCitemKindDto findByPrimaryKey(DBManager dbManager,String policyNo,int itemKindNo) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        //����DTO
        PrpCitemKindDto prpCitemKindDto = null;
        //��ѯ����,��ֵ��DTO
        prpCitemKindDto = dbPrpCitemKind.findByPrimaryKey(policyNo, itemKindNo);
        return prpCitemKindDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCitemKind.getCount(conditions);
        collection = dbPrpCitemKind.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCitemKindDto�ļ���
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCitemKind.getCount(conditions);
        collection = dbPrpCitemKind.findVirturlItemByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemKind.getCount(conditions);
        return count;
    }
}
