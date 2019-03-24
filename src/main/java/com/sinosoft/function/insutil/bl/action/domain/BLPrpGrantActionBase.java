package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpGrantDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpGrant;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrant��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantActionBase{
    private static Log log = LogFactory.getLog(BLPrpGrantActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGrantActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGrantDto prpGrantDto) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //�����¼
        dbPrpGrant.insert(prpGrantDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @param grantStartDate grantstartdate
     * @param grantEndDate grantenddate
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //ɾ����¼
        dbPrpGrant.delete(userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //������ɾ����¼
        dbPrpGrant.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGrantDto prpGrantDto) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //���¼�¼
        dbPrpGrant.update(prpGrantDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @param grantStartDate grantstartdate
     * @param grantEndDate grantenddate
     * @return prpGrantDto prpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        //����DTO
        PrpGrantDto prpGrantDto = null;
        //��ѯ����,��ֵ��DTO
        prpGrantDto = dbPrpGrant.findByPrimaryKey(userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
        return prpGrantDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGrantDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpGrant.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpGrant.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpGrantDto�ļ���
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
        DBPrpGrant dbPrpGrant = new DBPrpGrant(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGrant.getCount(conditions);
        return count;
    }
}
