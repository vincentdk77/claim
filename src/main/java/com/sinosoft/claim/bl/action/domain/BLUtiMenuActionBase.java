package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiMenuDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiMenu;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utimenu�˵����Ʊ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiMenuActionBase{
    private static Log log = LogFactory.getLog(BLUtiMenuActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiMenuActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiMenuDto utiMenuDto) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //�����¼
        dbUtiMenu.insert(utiMenuDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param menuName �˵���
     * @param hotKey �ȼ�
     * @param riskCode ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String menuName,String hotKey,String riskCode) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //ɾ����¼
        dbUtiMenu.delete(menuName, hotKey, riskCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //������ɾ����¼
        dbUtiMenu.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiMenuDto utiMenuDto) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //���¼�¼
        dbUtiMenu.update(utiMenuDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param menuName �˵���
     * @param hotKey �ȼ�
     * @param riskCode ����
     * @return utiMenuDto utiMenuDto
     * @throws Exception
     */
    public UtiMenuDto findByPrimaryKey(DBManager dbManager,String menuName,String hotKey,String riskCode) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //����DTO
        UtiMenuDto utiMenuDto = null;
        //��ѯ����,��ֵ��DTO
        utiMenuDto = dbUtiMenu.findByPrimaryKey(menuName, hotKey, riskCode);
        return utiMenuDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiMenuDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiMenu.getCount(conditions);
        collection = dbUtiMenu.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiMenu.getCount(conditions);
        return count;
    }
}
