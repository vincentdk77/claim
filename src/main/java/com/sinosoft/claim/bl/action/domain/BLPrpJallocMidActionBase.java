package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJallocMidDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJallocMid;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjallocmid������ҵ�񱣷ѷ�̯�м���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJallocMidActionBase{
    private static Log log = LogFactory.getLog(BLPrpJallocMidActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJallocMidActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJallocMidDto prpJallocMidDto) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //�����¼
        dbPrpJallocMid.insert(prpJallocMidDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //ɾ����¼
        dbPrpJallocMid.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //������ɾ����¼
        dbPrpJallocMid.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJallocMidDto prpJallocMidDto) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //���¼�¼
        dbPrpJallocMid.update(prpJallocMidDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param serialNo ���
     * @return prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public PrpJallocMidDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //����DTO
        PrpJallocMidDto prpJallocMidDto = null;
        //��ѯ����,��ֵ��DTO
        prpJallocMidDto = dbPrpJallocMid.findByPrimaryKey(policyNo, serialNo);
        return prpJallocMidDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJallocMidDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJallocMid.getCount(conditions);
        collection = dbPrpJallocMid.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJallocMid.getCount(conditions);
        return count;
    }
}
