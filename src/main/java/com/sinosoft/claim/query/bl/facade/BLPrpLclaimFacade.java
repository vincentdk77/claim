package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLPrpPheadFacade;
import com.sinosoft.claim.dto.custom.PrpDangerShareDto;
import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.reins.out.bl.facade.BLPrpCdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpPdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpCdangerUnitDto;
import com.sinosoft.reins.out.dto.domain.PrpPdangerUnitDto;

/**
 * 这是PrpLclaim-立案基本信息表的业务对象Facade类<br>
 * 创建于 2005-03-18 17:08:11.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFacade extends BLPrpLclaimFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFacade(){
        super();
    }
    /**
     * 取此保单离出险日期最近的危险单位的比例
     * @param policyno 保单号码
     * @param ednorserTimes 批改次数
     * @param damageDate 出险日期
     * @return List prpDangerShareDtoList 危险单位比例
     * @throws Exception
     */
    public List getDangerShareList(String policyno,int ednorserTimes,String damageDate) throws Exception
    {
        BLPrpCdangerUnitFacade blPrpCdangerUnitFacade =  new  BLPrpCdangerUnitFacade();
        BLPrpPdangerUnitFacade blPrpPdangerUnitFacade =  new BLPrpPdangerUnitFacade();
        
        List prpCdangerUnitList = new ArrayList();
        PrpCdangerUnitDto prpCdangerUnitDto = new PrpCdangerUnitDto();
        
        List prpPdangerUnitList = new ArrayList();
        PrpPdangerUnitDto prpPdangerUnitDto = new PrpPdangerUnitDto();
        
        BLPrpPheadFacade blPrpPheadFacade  = new BLPrpPheadFacade();
        List prpPheadList = new ArrayList();
        
        String sql  = "";
        String endorseno = "";
        
        PrpPheadDto prpPheadDto = new PrpPheadDto(); 
        if(ednorserTimes>0)
        {
     	      sql = "policyno='"+policyno+"' and validdate < date '"+damageDate+"' order by endorsetimes desc";
     	      prpPheadList = (ArrayList)blPrpPheadFacade.findByConditions(sql);
     	      for(int i=0;i<prpPheadList.size();i++)
     	      {
     		     prpPheadDto =  (PrpPheadDto)prpPheadList.get(i);
     		     endorseno = prpPheadDto.getEndorseNo();
     		     break;
     	      }
     	      if("".equals(endorseno))//出险日期之前没有发生过批改,直接查prpcdangerunit
     	      {
         	     sql = "policyno='"+policyno+"'";
         	     prpCdangerUnitList =  (ArrayList)blPrpCdangerUnitFacade.findByConditions(sql);
     	      }else
     	      {
     	         //select * from prppdangerunit pd where pd.endorseno='+endorseNo+';
     		     sql = "endorseno='"+endorseno+"'";
     		     prpPdangerUnitList = (ArrayList)blPrpPdangerUnitFacade.findByConditions(sql);
     	      }
        }else
        {
     	     sql = "policyno='"+policyno+"'";
     	     prpCdangerUnitList =  (ArrayList)blPrpCdangerUnitFacade.findByConditions(sql);
        }
        
        //把保单危险单位List和批单危险单位list组合成一个共用的list
        List prpDangerShareDtoList = new ArrayList();
        PrpDangerShareDto  prpDangerShareDto = null;
        if(prpCdangerUnitList.size()>0)
        {
      	  for(int i=0;i<prpCdangerUnitList.size();i++)
      	  {
      		  prpDangerShareDto = new PrpDangerShareDto();
      		  prpCdangerUnitDto = (PrpCdangerUnitDto)prpCdangerUnitList.get(i);
      		  prpDangerShareDto.setDangerNo(prpCdangerUnitDto.getDangerNo());
      		  prpDangerShareDto.setDangerShare(prpCdangerUnitDto.getDangerShare()); 
	      	  prpDangerShareDto.setBusinessNature(prpCdangerUnitDto.getBusinessNature());
	      	  prpDangerShareDto.setPolicyBizType(prpCdangerUnitDto.getPolicyBizType());
	      	  prpDangerShareDto.setPolicyType(prpCdangerUnitDto.getPolicyType());
	      	  prpDangerShareDto.setBusinessType(prpCdangerUnitDto.getBusinessType());
	      	  prpDangerShareDto.setBusinessType1(prpCdangerUnitDto.getBusinessType1());
	      	  prpDangerShareDto.setOthFlag(prpCdangerUnitDto.getOthFlag());
	      	  prpDangerShareDto.setBusinessProvince(prpCdangerUnitDto.getBusinessProvince());
	          prpDangerShareDto.setBusinessTown(prpCdangerUnitDto.getBusinessTown());
	      	  prpDangerShareDto.setBusinessCounty(prpCdangerUnitDto.getBusinessCounty());
	          prpDangerShareDto.setBusinessAreaName(prpCdangerUnitDto.getBusinessAreaName());
      		  prpDangerShareDtoList.add(prpDangerShareDto);
      	  } 
        }else
        {
      	  for(int i=0;i<prpPdangerUnitList.size();i++)
      	  {
      		  prpDangerShareDto = new PrpDangerShareDto();
      		  prpPdangerUnitDto = (PrpPdangerUnitDto)prpPdangerUnitList.get(i);
      		  prpDangerShareDto.setDangerNo(prpPdangerUnitDto.getDangerNo());
      		  prpDangerShareDto.setDangerShare(prpPdangerUnitDto.getDangerShare());
	      	  prpDangerShareDto.setBusinessNature(prpPdangerUnitDto.getBusinessNature());
	      	  prpDangerShareDto.setPolicyBizType(prpPdangerUnitDto.getPolicyBizType());
	      	  prpDangerShareDto.setPolicyType(prpPdangerUnitDto.getPolicyType());
	      	  prpDangerShareDto.setBusinessType(prpPdangerUnitDto.getBusinessType());
	      	  prpDangerShareDto.setBusinessType1(prpPdangerUnitDto.getBusinessType1());
	      	  prpDangerShareDto.setOthFlag(prpPdangerUnitDto.getOthFlag());
	      	  prpDangerShareDto.setBusinessProvince(prpPdangerUnitDto.getBusinessProvince());
	          prpDangerShareDto.setBusinessTown(prpPdangerUnitDto.getBusinessTown());
	      	  prpDangerShareDto.setBusinessCounty(prpPdangerUnitDto.getBusinessCounty());
	          prpDangerShareDto.setBusinessAreaName(prpPdangerUnitDto.getBusinessAreaName());
      		  prpDangerShareDtoList.add(prpDangerShareDto);
      	  } 
        }
        return prpDangerShareDtoList;
    }
}
