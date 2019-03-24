package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDuser Ա��������ҵ���߼�������<br>
 * ������ 2004-11-09 18:30:44.594<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDuserActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDuserActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDuserActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //�����¼
        dbPrpDuser.insert(prpDuserDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //ɾ����¼
        dbPrpDuser.delete(userCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //������ɾ����¼
        dbPrpDuser.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDuserDto prpDuserDto) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //���¼�¼
        dbPrpDuser.update(prpDuserDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @return prpDuserDto prpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(DBManager dbManager,String userCode) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        //����DTO
        PrpDuserDto prpDuserDto = null;
        //��ѯ����,��ֵ��DTO
        prpDuserDto = dbPrpDuser.findByPrimaryKey(userCode);
        return prpDuserDto;
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
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDuser.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDuser.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDuserDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDuser.findByConditions(conditions);
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
        DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDuser.getCount(conditions);
        return count;
    }
}
