package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDcompanyDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcompany����������ҵ���߼�������<br>
 * ������ 2004-11-09 18:30:44.594<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDcompanyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //�����¼
        dbPrpDcompany.insert(prpDcompanyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comCode ComCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //ɾ����¼
        dbPrpDcompany.delete(comCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //������ɾ����¼
        dbPrpDcompany.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //���¼�¼
        dbPrpDcompany.update(prpDcompanyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comCode ComCode
     * @return prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public PrpDcompanyDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        //����DTO
        PrpDcompanyDto prpDcompanyDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(comCode);
        return prpDcompanyDto;
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
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcompanyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDcompany.findByConditions(conditions);
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
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcompany.getCount(conditions);
        return count;
    }
}
