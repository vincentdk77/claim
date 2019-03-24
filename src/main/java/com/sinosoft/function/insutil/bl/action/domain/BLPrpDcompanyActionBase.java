package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcompanyDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcompany��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcompanyActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param comCode comcode
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
     * @param condtions ɾ������
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
     * @param comCode comcode
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
     * @return Collection ����prpDcompanyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcompany.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcompanyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
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
