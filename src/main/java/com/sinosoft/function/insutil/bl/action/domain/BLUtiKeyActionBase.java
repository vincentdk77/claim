package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiKeyDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiKey;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utikey��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiKeyActionBase{
    private static Log log = LogFactory.getLog(BLUtiKeyActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiKeyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //�����¼
        dbUtiKey.insert(utiKeyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param tableName tablename
     * @throws Exception
     */
    public void delete(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //ɾ����¼
        dbUtiKey.delete(tableName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //������ɾ����¼
        dbUtiKey.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiKeyDto utiKeyDto) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //���¼�¼
        dbUtiKey.update(utiKeyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param tableName tablename
     * @return utiKeyDto utiKeyDto
     * @throws Exception
     */
    public UtiKeyDto findByPrimaryKey(DBManager dbManager,String tableName) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        //����DTO
        UtiKeyDto utiKeyDto = null;
        //��ѯ����,��ֵ��DTO
        utiKeyDto = dbUtiKey.findByPrimaryKey(tableName);
        return utiKeyDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiKeyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiKey.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiKey.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiKeyDto�ļ���
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
        DBUtiKey dbUtiKey = new DBUtiKey(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiKey.getCount(conditions);
        return count;
    }
}
