package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpeds_Person;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Person��Ա������ϸ��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_PersonActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_PersonActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLpeds_PersonActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpeds_PersonDto prpLpeds_PersonDto) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        //�����¼
        dbPrpLpeds_Person.insert(prpLpeds_PersonDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        //ɾ����¼
        dbPrpLpeds_Person.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        //������ɾ����¼
        dbPrpLpeds_Person.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpeds_PersonDto prpLpeds_PersonDto) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        //���¼�¼
        dbPrpLpeds_Person.update(prpLpeds_PersonDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @return prpLpeds_PersonDto prpLpeds_PersonDto
     * @throws Exception
     */
    public PrpLpeds_PersonDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        //����DTO
        PrpLpeds_PersonDto prpLpeds_PersonDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpeds_PersonDto = dbPrpLpeds_Person.findByPrimaryKey(registNo, serialNo);
        return prpLpeds_PersonDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLpeds_PersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLpeds_Person.getCount(conditions);
        collection = dbPrpLpeds_Person.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpeds_Person dbPrpLpeds_Person = new DBPrpLpeds_Person(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpeds_Person.getCount(conditions);
        return count;
    }
}
