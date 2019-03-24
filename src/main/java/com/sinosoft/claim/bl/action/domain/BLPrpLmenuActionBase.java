package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmenu;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmenu-�˵���(����)��ҵ���߼�������<br>
 * ������ 2005-05-08 15:15:53.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLmenuActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLmenuDto prpLmenuDto) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //�����¼
        dbPrpLmenu.insert(prpLmenuDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param funcID �˵����ܴ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String funcID) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //ɾ����¼
        dbPrpLmenu.delete(funcID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //������ɾ����¼
        dbPrpLmenu.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLmenuDto prpLmenuDto) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //���¼�¼
        dbPrpLmenu.update(prpLmenuDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param funcID �˵����ܴ���
     * @return prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public PrpLmenuDto findByPrimaryKey(DBManager dbManager,String funcID) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //����DTO
        PrpLmenuDto prpLmenuDto = null;
        //��ѯ����,��ֵ��DTO
        prpLmenuDto = dbPrpLmenu.findByPrimaryKey(funcID);
        return prpLmenuDto;
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
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmenu.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLmenu.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLmenuDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmenu.findByConditions(conditions);
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
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmenu.getCount(conditions);
        return count;
    }
}
