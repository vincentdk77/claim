package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCrenewal;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcrenewal������Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCrenewalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCrenewalActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCrenewalActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCrenewalDto prpCrenewalDto) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //�����¼
        dbPrpCrenewal.insert(prpCrenewalDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //ɾ����¼
        dbPrpCrenewal.delete(policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //������ɾ����¼
        dbPrpCrenewal.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCrenewalDto prpCrenewalDto) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //���¼�¼
        dbPrpCrenewal.update(prpCrenewalDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @return prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public PrpCrenewalDto findByPrimaryKey(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //����DTO
        PrpCrenewalDto prpCrenewalDto = null;
        //��ѯ����,��ֵ��DTO
        prpCrenewalDto = dbPrpCrenewal.findByPrimaryKey(policyNo);
        return prpCrenewalDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCrenewalDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCrenewal.getCount(conditions);
        collection = dbPrpCrenewal.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCrenewal.getCount(conditions);
        return count;
    }
}
