package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLperson-��Ա�⸶��Ϣ��(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonDto prpLpersonDto) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //�����¼
        dbPrpLperson.insert(prpLpersonDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //ɾ����¼
        dbPrpLperson.delete(serialNo, registNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //������ɾ����¼
        dbPrpLperson.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonDto prpLpersonDto) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //���¼�¼
        dbPrpLperson.update(prpLpersonDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serialNo ���
     * @param registNo ��������
     * @return prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public PrpLpersonDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //����DTO
        PrpLpersonDto prpLpersonDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpersonDto = dbPrpLperson.findByPrimaryKey(serialNo, registNo);
        return prpLpersonDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLperson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLperson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLperson.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLperson.getCount(conditions);
        return count;
    }
}
