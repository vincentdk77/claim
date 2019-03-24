package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpTaskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpTask;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prptask��������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpTaskActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpTaskActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpTaskDto prpTaskDto) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //�����¼
        dbPrpTask.insert(prpTaskDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param taskCode �������
     * @param checkType Ȩ�޼�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskCode,String checkType) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //ɾ����¼
        dbPrpTask.delete(taskCode, checkType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //������ɾ����¼
        dbPrpTask.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpTaskDto prpTaskDto) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //���¼�¼
        dbPrpTask.update(prpTaskDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param taskCode �������
     * @param checkType Ȩ�޼�������
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(DBManager dbManager,String taskCode,String checkType) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //����DTO
        PrpTaskDto prpTaskDto = null;
        //��ѯ����,��ֵ��DTO
        prpTaskDto = dbPrpTask.findByPrimaryKey(taskCode, checkType);
        return prpTaskDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpTaskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpTask.getCount(conditions);
        collection = dbPrpTask.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(conditions);
        return count;
    }
}
