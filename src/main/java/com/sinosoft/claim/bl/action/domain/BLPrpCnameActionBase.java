package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCnameDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCname;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcname��Ա�嵥���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCnameActionBase{
    private static Log log = LogFactory.getLog(BLPrpCnameActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCnameActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCnameDto prpCnameDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCnameDto prpCnameDto) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        //�����¼
        dbPrpCname.insert(prpCnameDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        //ɾ����¼
        dbPrpCname.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        //������ɾ����¼
        dbPrpCname.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCnameDto prpCnameDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCnameDto prpCnameDto) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        //���¼�¼
        dbPrpCname.update(prpCnameDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param serialNo ���
     * @return prpCnameDto prpCnameDto
     * @throws Exception
     */
    public PrpCnameDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        //����DTO
        PrpCnameDto prpCnameDto = null;
        //��ѯ����,��ֵ��DTO
        prpCnameDto = dbPrpCname.findByPrimaryKey(policyNo, serialNo);
        return prpCnameDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCnameDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCname.getCount(conditions);
        collection = dbPrpCname.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCname dbPrpCname = new DBPrpCname(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCname.getCount(conditions);
        return count;
    }
}
