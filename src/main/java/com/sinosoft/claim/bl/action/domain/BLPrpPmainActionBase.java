package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPmain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppmain���ı�����Ϣ���ҵ���߼�������<br>
 * ������ 2004-11-22 15:24:30.906<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPmainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPmainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPmainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPmainDto prpPmainDto) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //�����¼
        dbPrpPmain.insert(prpPmainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //ɾ����¼
        dbPrpPmain.delete(endorseNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //������ɾ����¼
        dbPrpPmain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPmainDto prpPmainDto) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //���¼�¼
        dbPrpPmain.update(prpPmainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo ��������
     * @return prpPmainDto prpPmainDto
     * @throws Exception
     */
    public PrpPmainDto findByPrimaryKey(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //����DTO
        PrpPmainDto prpPmainDto = null;
        //��ѯ����,��ֵ��DTO
        prpPmainDto = dbPrpPmain.findByPrimaryKey(endorseNo);
        return prpPmainDto;
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
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPmain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPmain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPmainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPmain.findByConditions(conditions);
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
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPmain.getCount(conditions);
        return count;
    }
}
