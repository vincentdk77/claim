package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCMain-���Ᵽ�������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCMainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCMainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLCMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCMainDto prpLCMainDto) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //�����¼
        dbPrpLCMain.insert(prpLCMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //ɾ����¼
        dbPrpLCMain.delete(registNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //������ɾ����¼
        dbPrpLCMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCMainDto prpLCMainDto) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //���¼�¼
        dbPrpLCMain.update(prpLCMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ��������
     * @return prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public PrpLCMainDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //����DTO
        PrpLCMainDto prpLCMainDto = null;
        //��ѯ����,��ֵ��DTO
        prpLCMainDto = dbPrpLCMain.findByPrimaryKey(registNo, policyNo);
        return prpLCMainDto;
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
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLCMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCMain.findByConditions(conditions);
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
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCMain.getCount(conditions);
        return count;
    }
}
