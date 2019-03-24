package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxuploadinsurancelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXUPLOADINSURANCELIST��ҵ���߼�������<br>
 */
public class BLNyxuploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxuploadinsurancelistActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxuploadinsurancelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //�����¼
        dbNyxuploadinsurancelist.insert(nyxuploadinsurancelistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //ɾ����¼
        dbNyxuploadinsurancelist.delete(inusrelistcode, businessno, mulchtype);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //������ɾ����¼
        dbNyxuploadinsurancelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //���¼�¼
        dbNyxuploadinsurancelist.update(nyxuploadinsurancelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @return nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //����DTO
        NyxuploadinsurancelistDto nyxuploadinsurancelistDto = null;
        //��ѯ����,��ֵ��DTO
        nyxuploadinsurancelistDto = dbNyxuploadinsurancelist.findByPrimaryKey(inusrelistcode, businessno, mulchtype);
        return nyxuploadinsurancelistDto;
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
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxuploadinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxuploadinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxuploadinsurancelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxuploadinsurancelist.findByConditions(conditions);
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
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxuploadinsurancelist.getCount(conditions);
        return count;
    }
}
