package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiGroupDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiGroup;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utigroup��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupActionBase{
    private static Log log = LogFactory.getLog(BLUtiGroupActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param groupCode groupcode
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
     * @param condtions ɾ������
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
     * @param groupCode groupcode
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
     * @return Collection ����utiGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiGroup.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiGroupDto�ļ���
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
        DBUtiGroup dbUtiGroup = new DBUtiGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiGroup.getCount(conditions);
        return count;
    }
}
