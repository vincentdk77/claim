package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtaskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGtask;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgtask�˱�����������־���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtaskActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGtaskActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGtaskDto prpGtaskDto) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //�����¼
        dbPrpGtask.insert(prpGtaskDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param taskType ��������
     * @param certiType ��֤����
     * @param certiNo ��֤����
     * @param times ����
     * @param currentNode ��ǰ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //ɾ����¼
        dbPrpGtask.delete(taskType, certiType, certiNo, times, currentNode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //������ɾ����¼
        dbPrpGtask.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGtaskDto prpGtaskDto) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //���¼�¼
        dbPrpGtask.update(prpGtaskDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param taskType ��������
     * @param certiType ��֤����
     * @param certiNo ��֤����
     * @param times ����
     * @param currentNode ��ǰ����
     * @return prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public PrpGtaskDto findByPrimaryKey(DBManager dbManager,String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //����DTO
        PrpGtaskDto prpGtaskDto = null;
        //��ѯ����,��ֵ��DTO
        prpGtaskDto = dbPrpGtask.findByPrimaryKey(taskType, certiType, certiNo, times, currentNode);
        return prpGtaskDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGtaskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGtask.getCount(conditions);
        collection = dbPrpGtask.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGtask.getCount(conditions);
        return count;
    }
}
