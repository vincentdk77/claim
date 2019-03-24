package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrecase;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrecase-�ؿ��ⰸ��;��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrecaseActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrecaseActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrecaseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrecaseDto prpLrecaseDto) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //�����¼
        dbPrpLrecase.insert(prpLrecaseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo �ؿ��ⰸ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //ɾ����¼
        dbPrpLrecase.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //������ɾ����¼
        dbPrpLrecase.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrecaseDto prpLrecaseDto) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //���¼�¼
        dbPrpLrecase.update(prpLrecaseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo �ؿ��ⰸ����
     * @return prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public PrpLrecaseDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        //����DTO
        PrpLrecaseDto prpLrecaseDto = null;
        //��ѯ����,��ֵ��DTO
        prpLrecaseDto = dbPrpLrecase.findByPrimaryKey(claimNo, serialNo);
        return prpLrecaseDto;
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
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecase.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrecase.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLrecaseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrecase.findByConditions(conditions);
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
        DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecase.getCount(conditions);
        return count;
    }
}
