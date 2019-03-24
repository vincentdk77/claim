package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtask1Dto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGtask1;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgtask1������־���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtask1ActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtask1ActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGtask1ActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGtask1Dto prpGtask1Dto) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //�����¼
        dbPrpGtask1.insert(prpGtask1Dto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param taskType ��������
     * @param modelNo ģ���
     * @param caseIdNo ������ʶ��
     * @param certiNo ��֤����
     * @param serialNo ���
     * @param currentNode ��ǰ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //ɾ����¼
        dbPrpGtask1.delete(taskType, modelNo, caseIdNo, certiNo, serialNo, currentNode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //������ɾ����¼
        dbPrpGtask1.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGtask1Dto prpGtask1Dto) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //���¼�¼
        dbPrpGtask1.update(prpGtask1Dto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param taskType ��������
     * @param modelNo ģ���
     * @param caseIdNo ������ʶ��
     * @param certiNo ��֤����
     * @param serialNo ���
     * @param currentNode ��ǰ����
     * @return prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public PrpGtask1Dto findByPrimaryKey(DBManager dbManager,String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //����DTO
        PrpGtask1Dto prpGtask1Dto = null;
        //��ѯ����,��ֵ��DTO
        prpGtask1Dto = dbPrpGtask1.findByPrimaryKey(taskType, modelNo, caseIdNo, certiNo, serialNo, currentNode);
        return prpGtask1Dto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGtask1Dto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGtask1.getCount(conditions);
        collection = dbPrpGtask1.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGtask1.getCount(conditions);
        return count;
    }
}
