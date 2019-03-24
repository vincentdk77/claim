package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpTask;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpTask����������ҵ���߼�������<br>
 * ������ 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskActionBase.class);

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
     * @param checkCode Ȩ�޼������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskCode,String checkCode) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //ɾ����¼
        dbPrpTask.delete(taskCode, checkCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
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
     * @param checkCode Ȩ�޼������
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(DBManager dbManager,String taskCode,String checkCode) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //����DTO
        PrpTaskDto prpTaskDto = null;
        //��ѯ����,��ֵ��DTO
        prpTaskDto = dbPrpTask.findByPrimaryKey(taskCode, checkCode);
        return prpTaskDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpTask.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpTaskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpTask.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(conditions);
        return count;
    }
}
