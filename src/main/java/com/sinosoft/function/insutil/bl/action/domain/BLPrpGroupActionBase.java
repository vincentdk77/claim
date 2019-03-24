package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpGroupDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpGroup;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgroup��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpGroupActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGroupActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGroupDto prpGroupDto) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //�����¼
        dbPrpGroup.insert(prpGroupDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param groupNo groupno
     * @param subGroupNo subgroupno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupNo,String subGroupNo) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //ɾ����¼
        dbPrpGroup.delete(groupNo, subGroupNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //������ɾ����¼
        dbPrpGroup.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGroupDto prpGroupDto) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //���¼�¼
        dbPrpGroup.update(prpGroupDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param groupNo groupno
     * @param subGroupNo subgroupno
     * @return prpGroupDto prpGroupDto
     * @throws Exception
     */
    public PrpGroupDto findByPrimaryKey(DBManager dbManager,String groupNo,String subGroupNo) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //����DTO
        PrpGroupDto prpGroupDto = null;
        //��ѯ����,��ֵ��DTO
        prpGroupDto = dbPrpGroup.findByPrimaryKey(groupNo, subGroupNo);
        return prpGroupDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpGroup.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpGroupDto�ļ���
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
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGroup.getCount(conditions);
        return count;
    }
    /*************************�Ż��޸ģ�start**************************/
    /**�������-֧��¼��-֧���嵥����-֧���嵥�ύ
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGroupDto�ļ���
     * @throws Exception
     */
    public Collection findByConditionsByPrepered(DBManager dbManager,String conditions,int pageNo,int rowsPerPage,String GroupNo) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        //count = dbPrpGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpGroup.findByConditionsByPrepered(conditions,pageNo,rowsPerPage,GroupNo);
        return collection;
    }
}