package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpdBankBranch;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpdBankBranch��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpdBankBranchActionBase{
    private static Logger logger = Logger.getLogger(BLPrpdBankBranchActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpdBankBranchActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //�����¼
        dbPrpdBankBranch.insert(prpdBankBranchDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param bank_number bank_number
     * @throws Exception
     */
    public void delete(DBManager dbManager,String bank_number)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //ɾ����¼
        dbPrpdBankBranch.delete(bank_number);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //������ɾ����¼
        dbPrpdBankBranch.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //���¼�¼
        dbPrpdBankBranch.update(prpdBankBranchDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param bank_number bank_number
     * @return prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public PrpdBankBranchDto findByPrimaryKey(DBManager dbManager,String bank_number)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        //����DTO
        PrpdBankBranchDto prpdBankBranchDto = null;
        //��ѯ����,��ֵ��DTO
        prpdBankBranchDto = dbPrpdBankBranch.findByPrimaryKey(bank_number);
        return prpdBankBranchDto;
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
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpdBankBranch.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpdBankBranch.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpdBankBranchDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpdBankBranch.findByConditions(conditions);
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
        DBPrpdBankBranch dbPrpdBankBranch = new DBPrpdBankBranch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpdBankBranch.getCount(conditions);
        return count;
    }
}
