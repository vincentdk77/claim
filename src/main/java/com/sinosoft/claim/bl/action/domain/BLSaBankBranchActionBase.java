package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSaBankBranch;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SaBankBranch��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchActionBase.class);

    /**
     * ���캯��
     */
    public BLSaBankBranchActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SaBankBranchDto saBankBranchDto)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //�����¼
        dbSaBankBranch.insert(saBankBranchDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param bankCode bankCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String bankCode)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //ɾ����¼
        dbSaBankBranch.delete(bankCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //������ɾ����¼
        dbSaBankBranch.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SaBankBranchDto saBankBranchDto)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //���¼�¼
        dbSaBankBranch.update(saBankBranchDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param bankCode bankCode
     * @return saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public SaBankBranchDto findByPrimaryKey(DBManager dbManager,String bankCode)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        //����DTO
        SaBankBranchDto saBankBranchDto = null;
        //��ѯ����,��ֵ��DTO
        saBankBranchDto = dbSaBankBranch.findByPrimaryKey(bankCode);
        return saBankBranchDto;
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
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSaBankBranch.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSaBankBranch.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����saBankBranchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSaBankBranch.findByConditions(conditions);
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
        DBSaBankBranch dbSaBankBranch = new DBSaBankBranch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSaBankBranch.getCount(conditions);
        return count;
    }
}
