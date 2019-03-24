package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredArtifDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsuredArtif;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsuredartif������Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredArtifActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredArtifActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCinsuredArtifActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCinsuredArtifDto prpCinsuredArtifDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredArtifDto prpCinsuredArtifDto) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        //�����¼
        dbPrpCinsuredArtif.insert(prpCinsuredArtifDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        //ɾ����¼
        dbPrpCinsuredArtif.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        //������ɾ����¼
        dbPrpCinsuredArtif.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCinsuredArtifDto prpCinsuredArtifDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredArtifDto prpCinsuredArtifDto) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        //���¼�¼
        dbPrpCinsuredArtif.update(prpCinsuredArtifDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCinsuredArtifDto prpCinsuredArtifDto
     * @throws Exception
     */
    public PrpCinsuredArtifDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        //����DTO
        PrpCinsuredArtifDto prpCinsuredArtifDto = null;
        //��ѯ����,��ֵ��DTO
        prpCinsuredArtifDto = dbPrpCinsuredArtif.findByPrimaryKey(policyNo, serialNo);
        return prpCinsuredArtifDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCinsuredArtifDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsuredArtif.getCount(conditions);
        collection = dbPrpCinsuredArtif.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCinsuredArtif dbPrpCinsuredArtif = new DBPrpCinsuredArtif(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsuredArtif.getCount(conditions);
        return count;
    }
}
