package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCreditAssure;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCreditAssure����Ԥ��ȷ�Ϻ��ű��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditAssureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditAssureActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCreditAssureActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //�����¼
        dbPrpCreditAssure.insert(prpCreditAssureDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param confirmNo ����Ԥ��ȷ�Ϻ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String confirmNo) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //ɾ����¼
        dbPrpCreditAssure.delete(confirmNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //������ɾ����¼
        dbPrpCreditAssure.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //���¼�¼
        dbPrpCreditAssure.update(prpCreditAssureDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param confirmNo ����Ԥ��ȷ�Ϻ���
     * @return prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public PrpCreditAssureDto findByPrimaryKey(DBManager dbManager,String confirmNo) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //����DTO
        PrpCreditAssureDto prpCreditAssureDto = null;
        //��ѯ����,��ֵ��DTO
        prpCreditAssureDto = dbPrpCreditAssure.findByPrimaryKey(confirmNo);
        return prpCreditAssureDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCreditAssureDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCreditAssure.getCount(conditions);
        collection = dbPrpCreditAssure.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCreditAssure.getCount(conditions);
        return count;
    }
}
