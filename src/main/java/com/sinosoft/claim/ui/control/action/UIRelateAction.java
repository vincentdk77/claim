package com.sinosoft.claim.ui.control.action;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PrpLclaimFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByConCommand;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 查询相关业务号
 * <p>Title: 查询相关业务号</p>
 * <p>Description: 查询相关业务号</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class UIRelateAction {
  public UIRelateAction() {
  }

/**
 * 保存留言页面相关查询
 * @param bussinessNo String 业务号
 * @param nodeType String  节点类型
 * @throws Exception
 * @return Object
 */

   public PrpLmessageDto queryRelateInfo(String businessNo,String nodeType,
                                         String policyNo,String riskCode,String
                                         claimNo)
       throws Exception
   {
     String conditions = "";
     String registNo = "";

     PrpLclaimFindByConCommand prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
     if(nodeType.equals("regis"))
       {
         registNo = businessNo;
       }

     else if(nodeType.equals("sched")||nodeType.equals("schel"))
       {
         registNo = businessNo;
       }

     else if(nodeType.equals("check"))
       {
         registNo = businessNo;
       }
       
        else if(nodeType.equals("propc"))
       {
         registNo = businessNo;
       }
        else if(nodeType.equals("propv"))
       {
         registNo = businessNo;
       }
     else if(nodeType.equals("claim"))
       {
         registNo = businessNo;
       }

     else if(nodeType.equals("certi"))
       {
         conditions = " RegistNo='" + businessNo + "'";
         prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
         Collection c = (Collection) prpLclaimFindByConCommand.executeCommand();
         Iterator i = c.iterator();

         while (i.hasNext()) {
           PrpLclaimDto prpLclaimDto = (PrpLclaimDto) i.next();
           claimNo = prpLclaimDto.getClaimNo();
           riskCode = prpLclaimDto.getRiskCode();
           registNo=prpLclaimDto.getRegistNo();

           }

         //如果在prpLclaim表中没有查到该报案号记录,从prpLregist表中查险种代码
           if (c.size() < 1) {
              conditions = " RegistNo='" + businessNo + "'";
              PrpLregistFindByConCommand prpLregistFindByConCommand = new PrpLregistFindByConCommand(conditions);

              Collection collection = (Collection) prpLregistFindByConCommand.executeCommand();
              Iterator it = collection.iterator();

              while (it.hasNext()) {
              PrpLregistDto prpLregistDto = (PrpLregistDto) it.next();
              riskCode = prpLregistDto.getRiskCode();
              registNo = prpLregistDto.getRegistNo();

              }
            }
       }

     else if(nodeType.equals("certa"))
        {
           registNo = businessNo;
        }

     else if(nodeType.equals("verif"))
        {
           registNo = businessNo;
        }


     else if(nodeType.equals("prepa"))
       {
         conditions = " ClaimNo='" +businessNo+ "'" ;
         prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
         Collection c = (Collection)prpLclaimFindByConCommand.executeCommand();
         Iterator i = c.iterator();

           while(i.hasNext()){
             PrpLclaimDto prpLclaimDto = (PrpLclaimDto)i.next();
             registNo = prpLclaimDto.getRegistNo();

           }
       }

      else if(nodeType.equals("compe") || nodeType.equals("veric"))
        {
           conditions = " ClaimNo='" +businessNo+ "'";
           prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
           Collection c= (Collection)prpLclaimFindByConCommand.executeCommand();
           Iterator i = c.iterator();

           while(i.hasNext()){
           PrpLclaimDto prpLclaimDto = (PrpLclaimDto)i.next();
           registNo = prpLclaimDto.getRegistNo();
          }
        }
       else if(nodeType.equals("endca"))
         {

             conditions = " ClaimNo='" +claimNo+ "'";
             prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
             Collection c= (Collection)prpLclaimFindByConCommand.executeCommand();
             Iterator i = c.iterator();

             while(i.hasNext()){
             PrpLclaimDto prpLclaimDto = (PrpLclaimDto)i.next();
             riskCode = prpLclaimDto.getRiskCode();
             }


             registNo=businessNo;
           }else
           {//不明节点一律认为是报案号
                registNo=businessNo;
           }

      //System.out.println("这里输出报案号"+registNo);
      //取得系统当前时间
      DateTime dateTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY);
      //查到结果,赋值
      PrpLmessageDto prpLmessageDto = new PrpLmessageDto();
      prpLmessageDto.setInputDate(dateTime) ;
      prpLmessageDto.setRegistNo(registNo) ;
      prpLmessageDto.setNodeType(nodeType) ;
      prpLmessageDto.setPolicyNo(policyNo);
      prpLmessageDto.setRiskCode(riskCode);
      prpLmessageDto.setClaimNo(claimNo);
      return prpLmessageDto;
   }

   public PrpLclaimDto queryRelateClaim(String claimNo)
          throws Exception
      {
         String  conditions = " ClaimNo='" + claimNo + "'";

             PrpLclaimFindByConCommand  prpLclaimFindByConCommand = new PrpLclaimFindByConCommand(conditions);
            Collection c = (Collection) prpLclaimFindByConCommand.executeCommand();
            Iterator i = c.iterator();
             PrpLclaimDto prpLclaimDto =new PrpLclaimDto ();
              while (i.hasNext()) {
              prpLclaimDto = (PrpLclaimDto) i.next();
              break;

              }

         return prpLclaimDto;
      }

}
