package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittings;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����prplcompensate����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimFittingsAction extends BLPrpLclaimFittingsActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimFittingsAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingsAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimFittingsDto prpLclaimFittingsDto,String mode) throws Exception{
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
      DBPrpLclaimFittings dbPrpLclaimFittings = null;
      PrpLclaimFittingsDto prpLclaimFittingsDto = null;
      String condition = "";
      boolean bDelete = false;
      
      //ҵ�����
      dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
      
      Iterator it = fittingsList.iterator();
      while(it.hasNext()){
      	prpLclaimFittingsDto = (PrpLclaimFittingsDto)it.next();
      	if("D".equals(prpLclaimFittingsDto.getStatus())){
      		dbPrpLclaimFittings.updateStatus(prpLclaimFittingsDto);
      		it.remove();
      	}else{
      		condition = " registNo = '" + prpLclaimFittingsDto.getRegistNo() + "'"+
      			" and lossItemCode = '" + prpLclaimFittingsDto.getLossItemCode() +"'"+
      			" and partId = '" + prpLclaimFittingsDto.getPartId() + "'";
      		dbPrpLclaimFittings.deleteByConditions(condition);
      	}
      	
      } 
      
      dbPrpLclaimFittings.insertAll(fittingsList);
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
      DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
      Collection collection = null;

      if(conditions.trim().length()==0){
          conditions = "1=1";
      }

      collection = dbPrpLclaimFittings.findByConditions(conditions,pageNo,rowsPerPage);
      /* ȡ������ɾ�� */
      //dbPrpLclaimFittings.deleteByConditions(conditions);
      return collection;
    }
}