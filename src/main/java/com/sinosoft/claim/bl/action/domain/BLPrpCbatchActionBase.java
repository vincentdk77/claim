package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCbatchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCbatch;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcbatch�������������ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCbatchActionBase{
    private static Log log = LogFactory.getLog(BLPrpCbatchActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCbatchActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCbatchDto prpCbatchDto) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //�����¼
        dbPrpCbatch.insert(prpCbatchDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //ɾ����¼
        dbPrpCbatch.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //������ɾ����¼
        dbPrpCbatch.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCbatchDto prpCbatchDto) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //���¼�¼
        dbPrpCbatch.update(prpCbatchDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public PrpCbatchDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //����DTO
        PrpCbatchDto prpCbatchDto = null;
        //��ѯ����,��ֵ��DTO
        prpCbatchDto = dbPrpCbatch.findByPrimaryKey(policyNo, serialNo);
        return prpCbatchDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCbatchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCbatch.getCount(conditions);
        collection = dbPrpCbatch.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCbatch.getCount(conditions);
        return count;
    }
}
