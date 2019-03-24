package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpremAllocDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpremAlloc;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpremalloc������ҵ�񱣷ѷ�̯���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpremAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpremAllocActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJpremAllocActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJpremAllocDto prpJpremAllocDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpremAllocDto prpJpremAllocDto) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        //�����¼
        dbPrpJpremAlloc.insert(prpJpremAllocDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        //ɾ����¼
        dbPrpJpremAlloc.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        //������ɾ����¼
        dbPrpJpremAlloc.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJpremAllocDto prpJpremAllocDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpremAllocDto prpJpremAllocDto) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        //���¼�¼
        dbPrpJpremAlloc.update(prpJpremAllocDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpJpremAllocDto prpJpremAllocDto
     * @throws Exception
     */
    public PrpJpremAllocDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        //����DTO
        PrpJpremAllocDto prpJpremAllocDto = null;
        //��ѯ����,��ֵ��DTO
        prpJpremAllocDto = dbPrpJpremAlloc.findByPrimaryKey(policyNo, serialNo);
        return prpJpremAllocDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJpremAllocDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpremAlloc.getCount(conditions);
        collection = dbPrpJpremAlloc.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpremAlloc dbPrpJpremAlloc = new DBPrpJpremAlloc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpremAlloc.getCount(conditions);
        return count;
    }
}
