package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_RepfeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpeds_Repfee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Repfee��������嵥�ӿ����ݱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_RepfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_RepfeeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLpeds_RepfeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpeds_RepfeeDto prpLpeds_RepfeeDto) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        //�����¼
        dbPrpLpeds_Repfee.insert(prpLpeds_RepfeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        //ɾ����¼
        dbPrpLpeds_Repfee.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        //������ɾ����¼
        dbPrpLpeds_Repfee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpeds_RepfeeDto prpLpeds_RepfeeDto) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        //���¼�¼
        dbPrpLpeds_Repfee.update(prpLpeds_RepfeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @return prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @throws Exception
     */
    public PrpLpeds_RepfeeDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        //����DTO
        PrpLpeds_RepfeeDto prpLpeds_RepfeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpeds_RepfeeDto = dbPrpLpeds_Repfee.findByPrimaryKey(registNo, serialNo);
        return prpLpeds_RepfeeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLpeds_RepfeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLpeds_Repfee.getCount(conditions);
        collection = dbPrpLpeds_Repfee.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpeds_Repfee dbPrpLpeds_Repfee = new DBPrpLpeds_Repfee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpeds_Repfee.getCount(conditions);
        return count;
    }
}
