package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBUtiGroup;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiGroup  Ȩ����ű��ҵ���߼�������<br>
 * ������ 2004-11-09 10:40:54.648<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupActionBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupActionBase.class);

    /**
     * ���캯��
     */
    public BLUtiGroupActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiGroupDto utiGroupDto) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //�����¼
        dbUtiGroup.insert(utiGroupDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param groupCode Ȩ����Ŵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupCode) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //ɾ����¼
        dbUtiGroup.delete(groupCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //������ɾ����¼
        dbUtiGroup.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiGroupDto utiGroupDto) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //���¼�¼
        dbUtiGroup.update(utiGroupDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param groupCode Ȩ����Ŵ���
     * @return utiGroupDto utiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(DBManager dbManager,String groupCode) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        //����DTO
        UtiGroupDto utiGroupDto = null;
        //��ѯ����,��ֵ��DTO
        utiGroupDto = dbUtiGroup.findByPrimaryKey(groupCode);
        return utiGroupDto;
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
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiGroup.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiGroup.findByConditions(conditions);
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
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiGroup.getCount(conditions);
        return count;
    }
}
