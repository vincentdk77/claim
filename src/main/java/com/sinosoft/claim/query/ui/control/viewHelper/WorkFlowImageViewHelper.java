package com.sinosoft.claim.query.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.query.ui.control.actioin.UICodeAction;
import com.sinosoft.claim.query.ui.control.actioin.UIWorkFlowAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * <p>Title: ScheduleViewHelper</p>c
 * <p>Description:工作流图象展现ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 lixiang
 * @version 1.0
 * <br>
 */

 public  class WorkFlowImageViewHelper
 {
   /**
    * 默认构造方法
    */
   public WorkFlowImageViewHelper()
   {
   }
    /*========================第三部分：工作流图像展现操作========================*/
   /*========================第三部分：工作流图像展现操作========================*/
   /**
   * 设置工作流流程到界面
   * @param httpServletRequest HttpServletRequest
   * @param businessNo String
   * @throws Exception
   */
  public void setFlowDtoToView(HttpServletRequest httpServletRequest,String swfLogFlowID) throws Exception
  {
    UICodeAction uiCodeAction = new UICodeAction();
    String editType = httpServletRequest.getParameter("editType");
  
    String   flowID   = swfLogFlowID ;//流程号
  
    UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
    //查询流程主表，通过流程主表中的flowstatus的状态，如果是1，表示没有完成，从swflog表里查询
    //如果是flowstatus=0 ，则表示 需要从swflogstore和swfpathlogstore表里取数据的。
    SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
    swfFlowMainDto =uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
    
    //根据业务号得到多行的wfLog列表
    ArrayList swfLogList = new ArrayList();
    SwfLogDto swfLogDto = new SwfLogDto();
    //根据流程号查询流程路径信息
    SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
    ArrayList   swfPathLogList = new ArrayList();
    
    if (swfFlowMainDto==null) return;
    
    if (!("1").equals(swfFlowMainDto.getStoreFlag())){
    	//从现在的swflog和swfpathlog中查询
    	swfLogList = (ArrayList)uiWorkFlowAction.findNodesByFlowID(flowID) ;
      swfPathLogList = (ArrayList)uiWorkFlowAction.findFlowPathLogByFlowID(flowID) ;
    }else {
      //lixiang 2005-6-21 从存储表里查询，并复制到swfloglist，和swfpathloglist
    	ArrayList swfLogStoreList = (ArrayList)uiWorkFlowAction.findStoreNodesByFlowID(flowID) ;
      ArrayList swfPathLogStoreList = (ArrayList)uiWorkFlowAction.findStoreFlowPathLogByFlowID(flowID) ;
      Iterator swfLogStoreIterator = swfLogStoreList.iterator();
      while(swfLogStoreIterator.hasNext()){
      	SwfLogDto swfLogStoreDto = (SwfLogDto)swfLogStoreIterator.next();
      	SwfLogDto swfLogDtoTemp = new SwfLogDto(); 
          PropertyUtils.copyProperties(swfLogDtoTemp,swfLogStoreDto);
          swfLogList.add(swfLogDtoTemp);
      }
         
      Iterator swfPathLogStoreIterator = swfPathLogStoreList.iterator();
      while(swfPathLogStoreIterator.hasNext()){
      	SwfPathLogDto swfPathLogStoreDto = (SwfPathLogDto)swfPathLogStoreIterator.next();
      	SwfPathLogDto swfPathLogDtoTemp = new SwfPathLogDto(); 
          PropertyUtils.copyProperties(swfPathLogDtoTemp,swfPathLogStoreDto);
          swfPathLogList.add(swfPathLogDtoTemp); 
      }
    }
      //状态中文名称转换
      SwfLogDto swfLogDtoTemp1 = null;
      for(int iStatus=0;iStatus<swfLogList.size();iStatus++){
        swfLogDtoTemp1=(SwfLogDto)swfLogList.get(iStatus);
        swfLogDtoTemp1.setNodeStatusName(uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp1.getNodeStatus(),true));
      }

      SwfLogDto sswfLogListDto = (SwfLogDto)swfLogList.get(0) ;  //第一个节点
      flowID = swfLogFlowID ;
      swfLogDto.setSwfLogList(swfLogList) ;
      httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      //added by zhangli 20070424
      String registNo = sswfLogListDto.getKeyOut();
      httpServletRequest.setAttribute("registNo", registNo);

      swfPathLogDto.setPathLogList(swfPathLogList) ;
      httpServletRequest.setAttribute("wfPathLogdto",swfPathLogDto) ;

      int    treeLayerDeep        = 0  ;//节点层深度
      int    treeStartNodeNo      = 1  ;//缺省开始节点为1
      Collection swfLogTreeList  = new ArrayList();
      System.out.println("swfLogList.size="+swfLogList.size());
      System.out.println("swfPathLogList.size="+swfPathLogList.size());

      //加入第一个报案节点
      if(treeLayerDeep==0)
      {
        for(int j=0;j<swfLogList.size() ;j++)
        {
          SwfLogDto swfLogFirstDto  = (SwfLogDto) swfLogList.get(j);
          if(swfLogFirstDto.getNodeNo() == 1)
          {
            treeLayerDeep = 1;
            swfLogFirstDto.setTreeLayer(treeLayerDeep);
            //将得到层与节点信息装入节点树

            swfLogFirstDto.setStartNodeNo(0);
            swfLogFirstDto.setEndNodeNo(1);
            swfLogList.add(swfLogFirstDto);
            break;
          }
        }
      }

      createNodeTree(swfLogTreeList,swfLogList,swfPathLogList,treeStartNodeNo,treeLayerDeep);
      //第一个节点，节点数为1
      //System.out.println("树列表中的数量swfLogTreeList="+swfLogTreeList.size() );
      swfLogTreeList.add(sswfLogListDto);
      //以下为测试代码
      Collection treeList = new ArrayList();
      treeList = orderFlowList((ArrayList)swfLogTreeList);

      //System.out.println("树列表中的数量treeList="+treeList.size() );
      SwfLogDto wfLogTestDto = null ;
      /*
      for (Iterator i = treeList.iterator(); i.hasNext(); ) {
            wfLogTestDto = (SwfLogDto)i.next();
            //System.out.println("layer"+wfLogTestDto.getTreeLayer() +"|"+ "startNo=" + wfLogTestDto.getStartNodeNo() + "|endNo=" +wfLogTestDto.getEndNodeNo() +  "||" + wfLogTestDto.getNodeNo() + "|"+wfLogTestDto.getNodeName() );
      }
      */
      SwfLogDto swfLogDtoTree = new SwfLogDto();
      swfLogDtoTree.setSwfLogList(treeList) ;
      httpServletRequest.setAttribute("swfLogDto",swfLogDtoTree) ;
      httpServletRequest.setAttribute("swfPathLogList",swfPathLogList) ;

      //得到状态代码
      ArrayList claimStatus = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      httpServletRequest.setAttribute("claimStatus", claimStatus);

     //查询当前工作流主要信息
      //SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
      //swfFlowMainDto= uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
      httpServletRequest.setAttribute("swfFlowMainDto", swfFlowMainDto);
      return ;
    }
    /**
     * 产生节点树的方法
     * @param wfLogTreeDto Collection  节点树
     * @param swfLogList Collection     wfLog列表
     * @param swfPathLogList Collection wfPathLog列表
     * @param treeStartNodeNo int      树的开始节点
     * @param treeLayerDeep int        树的层深
     * @throws Exception
     */
  private static  void createNodeTree(Collection swfLogTreeList,ArrayList swfLogList,ArrayList swfPathLogList,int treeStartNodeNo,int treeLayerDeep) throws Exception
    {
      /**
       * 程序设计思路:
       * 根据第一个节点，做为开始节点，得到startNode节点的endNode,以此endNode节点的做为
       * startNode再查询它的EndNode,以此方法递归得到一个树状结构
       */

      int treeEndNodeNo   = 0 ;                //树或边的终止节点
      ArrayList layerPathList = new ArrayList();   //存放本层的节点

      for(int i=0;i<swfPathLogList.size()  ;i++)
      {
         SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)swfPathLogList.get(i) ;

        if(swfPathLogNodeDto.getStartNodeNo()==treeStartNodeNo)
        {
           layerPathList.add(swfPathLogNodeDto) ;

        }//end if
      }
      /*
      //加入第一个报案节点
      System.out.println("是否加入第一个报案节点="+treeLayerDeep);
      if(treeLayerDeep==0)
      {
        System.out.println("加入第一个报案节点="+treeLayerDeep);
        SwfLogDto swfLogFirstDto = (SwfLogDto) swfLogList.get(0);
        treeLayerDeep = 1;
        swfLogFirstDto.setTreeLayer(treeLayerDeep);
        //将得到层与节点信息装入节点树

        swfLogFirstDto.setStartNodeNo(0);
        swfLogFirstDto.setEndNodeNo(1);
        swfLogTreeList.add(swfLogFirstDto);
      }
     */


      //从层里查询到有哪些结束节点，判断结束节点是否有后续节点，如果有则取后续节点，没有则结束
      for(int k=0;k<layerPathList.size();k++)
      {
          SwfPathLogDto swfPathLogLayerDto = (SwfPathLogDto)layerPathList.get(k) ;
          treeEndNodeNo = swfPathLogLayerDto.getEndNodeNo() ;

          //是否有后续节点
          if(isExistNextNode(swfPathLogList,treeEndNodeNo))
          {
            //System.out.println("startNo2=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo2=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName()  );
            //查找与条件中的结束节点
            for(int j=0 ;j<swfLogList.size() ;j++)
            {
               SwfLogDto swfLogNodeDto = (SwfLogDto)swfLogList.get(j);
               //System.out.println("######要处理的数据="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
               if(swfLogNodeDto.getLogNo()==treeEndNodeNo)
               {
                 //设置层
                 if (k == 0) {
                   treeLayerDeep = treeLayerDeep + 1;
                 }

                  swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                  //将得到层与节点信息装入节点树
                  //System.out.println("layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
                  swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                  swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                  swfLogTreeList.add(swfLogNodeDto);

                  //递归查找下一节点
                  createNodeTree(swfLogTreeList,swfLogList,swfPathLogList,treeEndNodeNo,treeLayerDeep);
                  break;    //取得下一节点后不再循环
               }
            }//end for
          }
          else
          {
            //查找与条件中的结束节点
            for(int j=0 ;j<swfLogList.size() ;j++)
            {
               SwfLogDto swfLogNodeDto = (SwfLogDto)swfLogList.get(j);
               if(swfLogNodeDto.getLogNo()==treeEndNodeNo)
               {
                  //设置层
                  if (k == 0) {
                    treeLayerDeep = treeLayerDeep + 1;
                  }
                  swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                  //将得到层与节点信息装入节点树
                  System.out.println("无后序节点layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() + "|"  );
                  swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                  swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                  swfLogTreeList.add(swfLogNodeDto);
                  break;    //取得下一节点后不再循环
               }
            }//end for
          }
      }

      treeLayerDeep = treeLayerDeep - 1 ;
    }
    /**
     * 判断是否有后续节点
     * @param sourceList ArrayList
     * @param startNode int
     * @throws Exception
     * @return boolean
     */
    private static boolean isExistNextNode(ArrayList sourceList,int startNode) throws Exception
    {
      boolean isExist = false;  //是否有后续节点
      for(int i=0;i<sourceList.size() ;i++)
      {
        SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)sourceList.get(i) ;
        if(swfPathLogNodeDto.getStartNodeNo() ==startNode)
        {
          isExist = true;
        }
      }
      return isExist;
    }
    /**
     * 整理成要输出的顺序列表
     * @param sourceList ArrayList
     * @throws Exception
     * @return ArrayList
     */
    private Collection orderFlowList(ArrayList sourceList) throws Exception
    {
        ArrayList sameLayerList = new ArrayList();  //存放同层
        ArrayList noSameNodeList = new ArrayList(); //同层没有相同节点列表
        ArrayList orderList      = new ArrayList(); //已排好次序的列表
        int startNodeNo     = 0 ;  //开始节点
        int endNodeNo       = 0 ;  //结束节点
        int treeLayerDeep   = 0 ;  //层中节点数
        int countLayerSameNode = 0 ;//同层中相同节点的个数

        //去掉startNodeNo，endNodeNo相同的同层节点,
        for(int i=0;i<sourceList.size();i++)
        {

           SwfLogDto swfLogSource = (SwfLogDto)sourceList.get(i);
           startNodeNo = swfLogSource.getStartNodeNo() ;
           //System.out.println("sourceList.size="+sourceList.size()+"|"+ "startNo=" + swfLogSource.getStartNodeNo() +"|endNo=" +swfLogSource.getEndNodeNo() + "||" + swfLogSource.getNodeNo() + "|"+swfLogSource.getNodeName() + "|"  );
           endNodeNo = swfLogSource.getEndNodeNo();
           treeLayerDeep = swfLogSource.getTreeLayer() ;
           for(int j=0;j<noSameNodeList.size();j++)
           {
             SwfLogDto swfLogDiff = (SwfLogDto)noSameNodeList.get(j);  //用于比较的Dto
             if(swfLogDiff.getStartNodeNo()==startNodeNo && swfLogDiff.getEndNodeNo()==endNodeNo&&swfLogDiff.getTreeLayer() == treeLayerDeep)
             {
                countLayerSameNode = 1 ;
                break;
             }
           }
           if(countLayerSameNode==0)
                  noSameNodeList.add(swfLogSource) ;
           countLayerSameNode = 0 ;
        }
        //将同层按顺序排列
        for(int k=0;k<noSameNodeList.size() ;k++)
        {
          for(int n=0;n<noSameNodeList.size() ;n++)
          {
            SwfLogDto swfLogList = (SwfLogDto) noSameNodeList.get(n);
            if (swfLogList.getTreeLayer() == k + 1) {
              sameLayerList.add(swfLogList);
            }
          }
        }
        //对同层节点计数，并列出位置次序，从高到低的次序
        int nodeCount      = 0 ;//节点数
        int nodePosOrder   = 0 ;//节点在层的位置
        int oldLayer       = 0 ;//旧的层
        int currLayer      = 0 ;//当前层

        for(int k=0;k<sameLayerList.size() ;k++)
        {

          SwfLogDto swfLogOrder = (SwfLogDto)sameLayerList.get(k);
          //得到前一节点的层数,根据前一节点的层数判断是否放在一个层
          if (k == 0) {
            oldLayer = 1;
          }
          else {
            oldLayer = currLayer;
          }
          currLayer = swfLogOrder.getTreeLayer() ;

          for(int n=0;n<sameLayerList.size() ;n++)
          {
            SwfLogDto swfLogList = (SwfLogDto) sameLayerList.get(n);
            if (swfLogList.getTreeLayer() == currLayer ) {
              nodeCount = nodeCount + 1;
            }
          }
          currLayer = swfLogOrder.getTreeLayer() ;
          swfLogOrder.setCountNode(nodeCount) ;

          //设置次序
          //第一个节点nodePosOrder为1
          if(oldLayer==currLayer)
          {
            if(nodePosOrder>0)
            {
              nodePosOrder = nodePosOrder - 1;
            }
            else
            {
                nodePosOrder = 1;
            }
            swfLogOrder.setNodePosLayer(nodePosOrder) ;
          }
          else
          {
              nodePosOrder = 1;
              swfLogOrder.setNodePosLayer(nodePosOrder) ;
              nodePosOrder = nodeCount+1 ;
          }
          orderList.add(swfLogOrder);
          nodeCount =  0 ;
        }
        //modify by weishixin add 20050225 start
        //reason:计算流入和流出时间差
        //计算停留时间差
        int size =  orderList.size();
        DateTime beginTime = null ;   //开始时间
        DateTime endTime   = null  ;  //结束时间
        String   flowInTime = "" ;    //流入时间
        String   submitTime = "" ;    //提交时间
        int      stopTime   = 0 ;     //停留时间
        boolean  isDate     = false ;     //是否是日期
        boolean  isDateInput    = false ; //输入日期是否正确
        StringBuffer stopTimeDesc  = null ;
        for(int i=0;i<size;i++)
        {
          SwfLogDto swfLogListStopTime = (SwfLogDto) orderList.get(i);
          flowInTime = swfLogListStopTime.getFlowInTime() ;
          submitTime = swfLogListStopTime.getSubmitTime() ;

          //对于没有时间的案件 设置stopTime = 0 ;
          if(flowInTime==null||flowInTime.equals("null") ||flowInTime.equals("")||submitTime==null||submitTime.equals("null") ||submitTime.equals("") )
          {
            stopTime = 0 ;
          }
          else  //计算差值
          {
              isDate = this.isDateTime(flowInTime);
              //判断输入日期是否正确
              if(isDate)
              {
                if(flowInTime.length() <11)
                {
                  beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_DAY);
                }
                else
                {
                   beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_SECOND);
                }
                 isDateInput = true ;
              }
              else
              {
                  isDateInput = false ;
              }
              isDate = this.isDateTime(submitTime);
              if(isDate)
              {
                 if(submitTime.length()<11)
                 {
                   endTime = new DateTime(submitTime, DateTime.YEAR_TO_DAY);
                 }
                 else
                 {
                   endTime = new DateTime(submitTime, DateTime.YEAR_TO_SECOND);
                 }
                 isDateInput = true ;
              }
              else
              {
                  isDateInput = false ;
              }

              if(isDateInput)
              {
              long diffTime = endTime.getTime()- beginTime.getTime() ;

              swfLogListStopTime.setStopTime(diffTime) ;
              //计算文字描述
              long dayToMiins = 1000*60*60*24 ;
              long hourToMiins = 60*60*1000;
              long minuteToMiins = 60*1000;
              int  secondToMiins = 1000;
              long hourCount   = 0 ;  //小时数
              long minuteCount = 0 ;  //分钟
              int  secondCount = 0;
              long dayCount   = (long)diffTime/dayToMiins  ;
              long remainNum = diffTime % dayToMiins  ;
              if(remainNum>0)
              {
                hourCount = (long)remainNum/hourToMiins;  //计算小时
                remainNum      = remainNum % hourToMiins;
                if(remainNum > 0)
                {
                  minuteCount = (long)remainNum/minuteToMiins; //计算分钟
                  remainNum   = remainNum % minuteToMiins;
                  if(remainNum>0)
                  {
                     secondCount = (int)remainNum/secondToMiins;

                  }
                  else
                  {
                      secondCount = 0 ;
                  }
                }
                else
                {
                    minuteCount = 0 ;
                }
              }
              else
              {
                hourCount = 0 ;
              }
              stopTimeDesc = new StringBuffer();

              stopTimeDesc =  stopTimeDesc.append(dayCount+"天"+hourCount+"小时"+minuteCount + "分钟"+secondCount+"秒");
              }
              stopTimeDesc = stopTimeDesc.append("日期格式不正确");
              swfLogListStopTime.setStopTimeDesc(stopTimeDesc.toString()) ;
              //modify by weishixin add 20050225 end

          }
        }
        return orderList;
    }
    //modify by weishixin add 20050225 start
    //reason:判断日期源串是否是日期
    /**
     * 判断日期源串是否是日期
     * @param sourceDateTime String
     * @throws Exception
     * @return boolean
     */
    private boolean isDateTime(String sourceDateTime) throws Exception
    {
      boolean isDate = false ;
      DateTime checkTime = null ;
      try
      {
         if(sourceDateTime.length()<11)
         {
           checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_DAY);
           isDate = true ;
         }
         else
         {
             checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_SECOND);
             isDate = true ;
         }
         System.out.println("不是日期："+sourceDateTime);
      }
      catch(Exception e)
      {
         System.out.println("不是日期："+sourceDateTime);
         isDate = false ;
      }

      return isDate;
    }
    //modify by weishixin add 20050225 end
    /*========================（工作流图像展现操作）结束============================*/
 }
