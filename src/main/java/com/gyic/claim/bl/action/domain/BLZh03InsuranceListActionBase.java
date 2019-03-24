package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03InsuranceList;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03InsuranceList��ҵ���߼�������<br>
 */
public class BLZh03InsuranceListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03InsuranceListActionBase.class);

    /**
     * ���캯��
     */
    public BLZh03InsuranceListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //�����¼
        dbZh03InsuranceList.insert(zh03InsuranceListDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //ɾ����¼
        dbZh03InsuranceList.delete(inusreListCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //������ɾ����¼
        dbZh03InsuranceList.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //���¼�¼
        dbZh03InsuranceList.update(zh03InsuranceListDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusreListCode InusreListCode
     * @return zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public Zh03InsuranceListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //����DTO
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        //��ѯ����,��ֵ��DTO
        zh03InsuranceListDto = dbZh03InsuranceList.findByPrimaryKey(inusreListCode);
        return zh03InsuranceListDto;
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
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03InsuranceList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03InsuranceList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����zh03InsuranceListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03InsuranceList.findByConditions(conditions);
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
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03InsuranceList.getCount(conditions);
        return count;
    }
}
