package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsList;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_list��������ͨ�������ϸ�嵥��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsListActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsListActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLQsListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsListDto prpLQs_listDto) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //�����¼
        dbPrpLQs_list.insert(prpLQs_listDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //ɾ����¼
        dbPrpLQs_list.delete(procNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //������ɾ����¼
        dbPrpLQs_list.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsListDto prpLQs_listDto) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //���¼�¼
        dbPrpLQs_list.update(prpLQs_listDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param procNo ���㵥���κ�
     * @param serialNo ���ν���˳���
     * @return prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public PrpLQsListDto findByPrimaryKey(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //����DTO
        PrpLQsListDto prpLQs_listDto = null;
        //��ѯ����,��ֵ��DTO
        prpLQs_listDto = dbPrpLQs_list.findByPrimaryKey(procNo, serialNo);
        return prpLQs_listDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLQs_listDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_list.getCount(conditions);
        collection = dbPrpLQs_list.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_list.getCount(conditions);
        return count;
    }
}
