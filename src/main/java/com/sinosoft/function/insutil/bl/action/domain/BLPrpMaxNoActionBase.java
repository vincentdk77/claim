package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpMaxNoDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpMaxNo;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxno��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxNoActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpMaxNoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //�����¼
        dbPrpMaxNo.insert(prpMaxNoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param groupNo groupno
     * @param tableName tablename
     * @param maxNo maxno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupNo,String tableName,String maxNo) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //ɾ����¼
        dbPrpMaxNo.delete(groupNo, tableName, maxNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //������ɾ����¼
        dbPrpMaxNo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //���¼�¼
        dbPrpMaxNo.update(prpMaxNoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param groupNo groupno
     * @param tableName tablename
     * @param maxNo maxno
     * @return prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public PrpMaxNoDto findByPrimaryKey(DBManager dbManager,String groupNo,String tableName,String maxNo) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //����DTO
        PrpMaxNoDto prpMaxNoDto = null;
        //��ѯ����,��ֵ��DTO
        prpMaxNoDto = dbPrpMaxNo.findByPrimaryKey(groupNo, tableName, maxNo);
        return prpMaxNoDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpMaxNoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpMaxNo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpMaxNo.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpMaxNoDto�ļ���
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
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpMaxNo.getCount(conditions);
        return count;
    }
}
