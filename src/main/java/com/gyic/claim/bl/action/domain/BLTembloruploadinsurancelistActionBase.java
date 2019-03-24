package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TembloruploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTembloruploadinsurancelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORUPLOADINSURANCELIST��ҵ���߼�������<br>
 */
public class BLTembloruploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLTembloruploadinsurancelistActionBase.class);

    /**
     * ���캯��
     */
    public BLTembloruploadinsurancelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //�����¼
        dbTembloruploadinsurancelist.insert(tembloruploadinsurancelistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String address,String idcard)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //ɾ����¼
        dbTembloruploadinsurancelist.delete(inusrelistcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //������ɾ����¼
        dbTembloruploadinsurancelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //���¼�¼
        dbTembloruploadinsurancelist.update(tembloruploadinsurancelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public TembloruploadinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String address,String idcard)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //����DTO
        TembloruploadinsurancelistDto tembloruploadinsurancelistDto = null;
        //��ѯ����,��ֵ��DTO
        tembloruploadinsurancelistDto = dbTembloruploadinsurancelist.findByPrimaryKey(inusrelistcode, address, idcard);
        return tembloruploadinsurancelistDto;
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
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTembloruploadinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTembloruploadinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����tembloruploadinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTembloruploadinsurancelist.findByConditions(conditions);
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
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTembloruploadinsurancelist.getCount(conditions);
        return count;
    }
}
