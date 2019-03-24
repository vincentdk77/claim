package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCengage;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcengage�ر�Լ�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCengageActionBase{
    private static Log log = LogFactory.getLog(BLPrpCengageActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCengageActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCengageDto prpCengageDto) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //�����¼
        dbPrpCengage.insert(prpCengageDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @param lineNo �����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo,int lineNo) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //ɾ����¼
        dbPrpCengage.delete(policyNo, serialNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //������ɾ����¼
        dbPrpCengage.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCengageDto prpCengageDto) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //���¼�¼
        dbPrpCengage.update(prpCengageDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @param lineNo �����
     * @return prpCengageDto prpCengageDto
     * @throws Exception
     */
    public PrpCengageDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo,int lineNo) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //����DTO
        PrpCengageDto prpCengageDto = null;
        //��ѯ����,��ֵ��DTO
        prpCengageDto = dbPrpCengage.findByPrimaryKey(policyNo, serialNo, lineNo);
        return prpCengageDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCengageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCengage.getCount(conditions);
        collection = dbPrpCengage.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCengage.getCount(conditions);
        return count;
    }
}
