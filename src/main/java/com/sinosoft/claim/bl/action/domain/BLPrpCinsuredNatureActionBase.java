package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsuredNature;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsurednature��Ȼ����Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredNatureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredNatureActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCinsuredNatureActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //�����¼
        dbPrpCinsuredNature.insert(prpCinsuredNatureDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //ɾ����¼
        dbPrpCinsuredNature.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //������ɾ����¼
        dbPrpCinsuredNature.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //���¼�¼
        dbPrpCinsuredNature.update(prpCinsuredNatureDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredNatureDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //����DTO
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
        //��ѯ����,��ֵ��DTO
        prpCinsuredNatureDto = dbPrpCinsuredNature.findByPrimaryKey(policyNo, serialNo);
        return prpCinsuredNatureDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCinsuredNatureDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsuredNature.getCount(conditions);
        collection = dbPrpCinsuredNature.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsuredNature.getCount(conditions);
        return count;
    }
}
