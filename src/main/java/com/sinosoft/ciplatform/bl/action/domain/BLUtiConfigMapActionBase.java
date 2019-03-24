package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBUtiConfigMap;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ������ҵ��ƽ̨���ñ��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLUtiConfigMapActionBase{
    private static Logger logger = Logger.getLogger(BLUtiConfigMapActionBase.class);

    /**
     * ���캯��
     */
    public BLUtiConfigMapActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //�����¼
        dbUtiConfigMap.insert(utiConfigMapDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param systemName ϵͳ��
     * @param className ����
     * @param mapName HashMap��
     * @param keyValue ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String systemName,String className,String mapName,String keyValue)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //ɾ����¼
        dbUtiConfigMap.delete(systemName, className, mapName, keyValue);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //������ɾ����¼
        dbUtiConfigMap.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //���¼�¼
        dbUtiConfigMap.update(utiConfigMapDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param systemName ϵͳ��
     * @param className ����
     * @param mapName HashMap��
     * @param keyValue ��
     * @return utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public UtiConfigMapDto findByPrimaryKey(DBManager dbManager,String systemName,String className,String mapName,String keyValue)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //����DTO
        UtiConfigMapDto utiConfigMapDto = null;
        //��ѯ����,��ֵ��DTO
        utiConfigMapDto = dbUtiConfigMap.findByPrimaryKey(systemName, className, mapName, keyValue);
        return utiConfigMapDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfigMap.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiConfigMap.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiConfigMapDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiConfigMap.findByConditions(conditions);
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
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfigMap.getCount(conditions);
        return count;
    }
}
