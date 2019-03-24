package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingstgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittingstg;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����prplcompensate����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimFittingstgAction extends BLPrpLclaimFittingstgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimFittingstgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingstgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimFittingstgDto prpLclaimFittingstgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimFittingstgDto prpLclaimFittingstgDto,String mode) throws Exception{
    }

    /**
     * ����
     * @param Collection fittingsList
     * @throws SQLException
     * @throws Exception
     */
    public void save(DBManager dbManager,Collection fittingsList) throws SQLException,Exception
    {
      //�������ݿ�������
      DBPrpLclaimFittingstg dbPrpLclaimFittingstg = null;
      PrpLclaimFittingstgDto prpLclaimFittingstgDto = null;
      String condition = "";
      boolean bDelete = false;
      
      //ҵ�����
      dbPrpLclaimFittingstg = new DBPrpLclaimFittingstg(dbManager);
      
      Iterator it = fittingsList.iterator();
      while(it.hasNext()){
      	prpLclaimFittingstgDto = (PrpLclaimFittingstgDto)it.next();
      	if("D".equals(prpLclaimFittingstgDto.getStatus())){
      		dbPrpLclaimFittingstg.updateStatus(prpLclaimFittingstgDto);
      		it.remove();
      	}else{
      		condition = " registNo = '" + prpLclaimFittingstgDto.getRegistNo() + "'"+
      			" and lossItemCode = '" + prpLclaimFittingstgDto.getLossItemCode() +"'"+
      			" and partId = '" + prpLclaimFittingstgDto.getPartId() + "'";
      		dbPrpLclaimFittingstg.deleteByConditions(condition);
      	}
      	
      } 
      
      dbPrpLclaimFittingstg.insertAll(fittingsList);
    }

    /**
     * ��������ѯ��������
     * @param dbManager DBManager
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
      DBPrpLclaimFittingstg dbPrpLclaimFittingstg = new DBPrpLclaimFittingstg(dbManager);
      Collection collection = null;

      if(conditions.trim().length()==0){
          conditions = "1=1";
      }

      collection = dbPrpLclaimFittingstg.findByConditions(conditions,pageNo,rowsPerPage);
      /* ȡ������ɾ�� */
      //dbPrpLclaimFittingstg.deleteByConditions(conditions);
      return collection;
    }
}