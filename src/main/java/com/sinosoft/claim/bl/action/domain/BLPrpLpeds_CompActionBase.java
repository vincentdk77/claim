package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_CompDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpeds_Comp;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Comp�����嵥�ӿ����ݱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_CompActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_CompActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLpeds_CompActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //�����¼
        dbPrpLpeds_Comp.insert(prpLpeds_CompDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //ɾ����¼
        dbPrpLpeds_Comp.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //������ɾ����¼
        dbPrpLpeds_Comp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //���¼�¼
        dbPrpLpeds_Comp.update(prpLpeds_CompDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @return prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public PrpLpeds_CompDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //����DTO
        PrpLpeds_CompDto prpLpeds_CompDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpeds_CompDto = dbPrpLpeds_Comp.findByPrimaryKey(registNo, serialNo);
        return prpLpeds_CompDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLpeds_CompDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLpeds_Comp.getCount(conditions);
        collection = dbPrpLpeds_Comp.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpeds_Comp.getCount(conditions);
        return count;
    }
}
