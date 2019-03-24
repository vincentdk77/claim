package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyList;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03PolicyList��ҵ���߼�������<br>
 */
public class BLZh03PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListActionBase.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //�����¼
        dbZh03PolicyList.insert(zh03PolicyListDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //ɾ����¼
        dbZh03PolicyList.delete(inusreListCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //������ɾ����¼
        dbZh03PolicyList.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //���¼�¼
        dbZh03PolicyList.update(zh03PolicyListDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @return zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public Zh03PolicyListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        //����DTO
        Zh03PolicyListDto zh03PolicyListDto = null;
        //��ѯ����,��ֵ��DTO
        zh03PolicyListDto = dbZh03PolicyList.findByPrimaryKey(inusreListCode);
        return zh03PolicyListDto;
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
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����zh03PolicyListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03PolicyList.findByConditions(conditions);
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
        DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyList.getCount(conditions);
        return count;
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
    public PageRecord findFamilyNoByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
    	DBZh03PolicyList dbZh03PolicyList = new DBZh03PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbZh03PolicyList.getFamilyNoCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyList.findFamilyNoByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
