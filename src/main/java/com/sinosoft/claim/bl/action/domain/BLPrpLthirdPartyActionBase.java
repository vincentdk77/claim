package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdParty-���⳵����Ϣ(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPartyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPartyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdPartyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLthirdPartyDto prpLthirdPartyDto) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        //�����¼
        dbPrpLthirdParty.insert(prpLthirdPartyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        //ɾ����¼
        dbPrpLthirdParty.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        //������ɾ����¼
        dbPrpLthirdParty.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLthirdPartyDto prpLthirdPartyDto) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        //���¼�¼
        dbPrpLthirdParty.update(prpLthirdPartyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @return prpLthirdPartyDto prpLthirdPartyDto
     * @throws Exception
     */
    public PrpLthirdPartyDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        //����DTO
        PrpLthirdPartyDto prpLthirdPartyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLthirdPartyDto = dbPrpLthirdParty.findByPrimaryKey(registNo, serialNo);
        return prpLthirdPartyDto;
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
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdParty.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLthirdParty.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLthirdPartyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLthirdParty.findByConditions(conditions);
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
        DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdParty.getCount(conditions);
        return count;
    }
}
