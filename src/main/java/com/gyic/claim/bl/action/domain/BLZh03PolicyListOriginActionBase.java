package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyListOrigin;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03PolicyListOrigin��ҵ���߼�������<br>
 */
public class BLZh03PolicyListOriginActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListOriginActionBase.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListOriginActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //�����¼
        dbZh03PolicyListOrigin.insert(zh03PolicyListOriginDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //ɾ����¼
        dbZh03PolicyListOrigin.delete(inusrelistcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //������ɾ����¼
        dbZh03PolicyListOrigin.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //���¼�¼
        dbZh03PolicyListOrigin.update(zh03PolicyListOriginDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @return zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public Zh03PolicyListOriginDto findByPrimaryKey(DBManager dbManager,String inusrelistcode)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        //����DTO
        Zh03PolicyListOriginDto zh03PolicyListOriginDto = null;
        //��ѯ����,��ֵ��DTO
        zh03PolicyListOriginDto = dbZh03PolicyListOrigin.findByPrimaryKey(inusrelistcode);
        return zh03PolicyListOriginDto;
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
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyListOrigin.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03PolicyListOrigin.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����zh03PolicyListOriginDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03PolicyListOrigin.findByConditions(conditions);
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
        DBZh03PolicyListOrigin dbZh03PolicyListOrigin = new DBZh03PolicyListOrigin(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03PolicyListOrigin.getCount(conditions);
        return count;
    }
}
