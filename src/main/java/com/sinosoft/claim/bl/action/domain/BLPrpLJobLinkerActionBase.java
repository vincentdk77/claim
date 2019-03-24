package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLJobLinker;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLJobLinker��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLJobLinkerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLJobLinkerActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLJobLinkerActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //�����¼
        dbPrpLJobLinker.insert(prpLJobLinkerDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param staffId StaffId
     * @throws Exception
     */
    public void delete(DBManager dbManager,String staffId)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //ɾ����¼
        dbPrpLJobLinker.delete(staffId);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //������ɾ����¼
        dbPrpLJobLinker.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLJobLinkerDto prpLJobLinkerDto)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //���¼�¼
        dbPrpLJobLinker.update(prpLJobLinkerDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param staffId StaffId
     * @return prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public PrpLJobLinkerDto findByPrimaryKey(DBManager dbManager,String staffId)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        //����DTO
        PrpLJobLinkerDto prpLJobLinkerDto = null;
        //��ѯ����,��ֵ��DTO
        prpLJobLinkerDto = dbPrpLJobLinker.findByPrimaryKey(staffId);
        return prpLJobLinkerDto;
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
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLJobLinker.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLJobLinker.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLJobLinkerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLJobLinker.findByConditions(conditions);
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
        DBPrpLJobLinker dbPrpLJobLinker = new DBPrpLJobLinker(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLJobLinker.getCount(conditions);
        return count;
    }
}
