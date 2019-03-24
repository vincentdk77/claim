package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJcommAllocDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJcommAlloc;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjcommalloc�����ѷ�̯���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJcommAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJcommAllocActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJcommAllocActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //�����¼
        dbPrpJcommAlloc.insert(prpJcommAllocDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param allocNo ��̯��
     * @param policyNo ������
     * @param serialNo ��̯���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String allocNo,String policyNo,int serialNo) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //ɾ����¼
        dbPrpJcommAlloc.delete(allocNo, policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //������ɾ����¼
        dbPrpJcommAlloc.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //���¼�¼
        dbPrpJcommAlloc.update(prpJcommAllocDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param allocNo ��̯��
     * @param policyNo ������
     * @param serialNo ��̯���
     * @return prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public PrpJcommAllocDto findByPrimaryKey(DBManager dbManager,String allocNo,String policyNo,int serialNo) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //����DTO
        PrpJcommAllocDto prpJcommAllocDto = null;
        //��ѯ����,��ֵ��DTO
        prpJcommAllocDto = dbPrpJcommAlloc.findByPrimaryKey(allocNo, policyNo, serialNo);
        return prpJcommAllocDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJcommAllocDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJcommAlloc.getCount(conditions);
        collection = dbPrpJcommAlloc.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJcommAlloc.getCount(conditions);
        return count;
    }
}
