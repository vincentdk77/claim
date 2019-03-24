package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiWorkFlowDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiWorkFlow;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiworkflow���������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiWorkFlowActionBase{
    private static Log log = LogFactory.getLog(BLUtiWorkFlowActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiWorkFlowActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //�����¼
        dbUtiWorkFlow.insert(utiWorkFlowDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param workflowName ����������
     * @param orderNo ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String workflowName,String orderNo) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //ɾ����¼
        dbUtiWorkFlow.delete(workflowName, orderNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //������ɾ����¼
        dbUtiWorkFlow.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //���¼�¼
        dbUtiWorkFlow.update(utiWorkFlowDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param workflowName ����������
     * @param orderNo ����
     * @return utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public UtiWorkFlowDto findByPrimaryKey(DBManager dbManager,String workflowName,String orderNo) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //����DTO
        UtiWorkFlowDto utiWorkFlowDto = null;
        //��ѯ����,��ֵ��DTO
        utiWorkFlowDto = dbUtiWorkFlow.findByPrimaryKey(workflowName, orderNo);
        return utiWorkFlowDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiWorkFlowDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiWorkFlow.getCount(conditions);
        collection = dbUtiWorkFlow.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiWorkFlow.getCount(conditions);
        return count;
    }
}
