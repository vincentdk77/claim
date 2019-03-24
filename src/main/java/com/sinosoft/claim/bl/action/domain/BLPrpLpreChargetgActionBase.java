package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreChargetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLpreChargetgActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLpreChargetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpreChargetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpreChargetgDto prpLpreChargetgDto) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //�����¼
        dbPrpLpreChargetg.insert(prpLpreChargetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //ɾ����¼
        dbPrpLpreChargetg.delete(preCompensateNo,serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //������ɾ����¼
        dbPrpLpreChargetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpreChargetgDto PrpLpreChargetgDto) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //���¼�¼
        dbPrpLpreChargetg.update(PrpLpreChargetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @return PrpLpreChargetgDto PrpLpreChargetgDto
     * @throws Exception
     */
    public PrpLpreChargetgDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        //����DTO
        PrpLpreChargetgDto PrpLpreChargetgDto = null;
        //��ѯ����,��ֵ��DTO
        PrpLpreChargetgDto = dbPrpLpreChargetg.findByPrimaryKey(preCompensateNo,serialNo);
        return PrpLpreChargetgDto;
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
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreChargetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpreChargetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����PrpLpreChargetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpreChargetg.findByConditions(conditions);
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
        DBPrpLpreChargetg dbPrpLpreChargetg = new DBPrpLpreChargetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreChargetg.getCount(conditions);
        return count;
    }
}
