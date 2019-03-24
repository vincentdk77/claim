package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiRouteDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiRoute;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiroute��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiRouteActionBase{
    private static Log log = LogFactory.getLog(BLUtiRouteActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiRouteActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiRouteDto utiRouteDto) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //�����¼
        dbUtiRoute.insert(utiRouteDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comCode comcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //ɾ����¼
        dbUtiRoute.delete(comCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //������ɾ����¼
        dbUtiRoute.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiRouteDto utiRouteDto) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //���¼�¼
        dbUtiRoute.update(utiRouteDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comCode comcode
     * @return utiRouteDto utiRouteDto
     * @throws Exception
     */
    public UtiRouteDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //����DTO
        UtiRouteDto utiRouteDto = null;
        //��ѯ����,��ֵ��DTO
        utiRouteDto = dbUtiRoute.findByPrimaryKey(comCode);
        return utiRouteDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiRouteDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiRoute.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiRoute.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiRouteDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiRoute.getCount(conditions);
        return count;
    }
}
