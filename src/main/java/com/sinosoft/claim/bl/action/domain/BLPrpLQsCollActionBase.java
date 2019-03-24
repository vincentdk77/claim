package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsCollDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsColl;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_coll��������ͨ�������ܱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsCollActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsCollActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLQsCollActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsCollDto prpLQs_collDto) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //�����¼
        dbPrpLQs_coll.insert(prpLQs_collDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param batchNo �����κ�
     * @param procNo ���㵥���κ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo,String procNo) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //ɾ����¼
        dbPrpLQs_coll.delete(batchNo, procNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //������ɾ����¼
        dbPrpLQs_coll.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsCollDto prpLQs_collDto) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //���¼�¼
        dbPrpLQs_coll.update(prpLQs_collDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param batchNo �����κ�
     * @param procNo ���㵥���κ�
     * @return prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public PrpLQsCollDto findByPrimaryKey(DBManager dbManager,String batchNo,String procNo) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //����DTO
        PrpLQsCollDto prpLQs_collDto = null;
        //��ѯ����,��ֵ��DTO
        prpLQs_collDto = dbPrpLQs_coll.findByPrimaryKey(batchNo, procNo);
        return prpLQs_collDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLQs_collDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_coll.getCount(conditions);
        collection = dbPrpLQs_coll.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_coll.getCount(conditions);
        return count;
    }
}
