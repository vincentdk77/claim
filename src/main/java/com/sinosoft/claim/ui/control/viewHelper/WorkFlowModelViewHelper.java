package com.sinosoft.claim.ui.control.viewHelper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.UICompanyAction;
import com.sinosoft.claim.ui.control.action.UIRiskAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowModelAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;


/**
 * <p>Title: WorkFlowModelViewHelper</p>
 * <p>Description:工作流模板viewHelper</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 weishixin
 * @version 1.0
 * <br>
 */

 public class WorkFlowModelViewHelper
 {
   /**
    * 默认构造方法
    */
   public WorkFlowModelViewHelper()
   {
   }

   /**
    * 工作流模板数据收集
    * @param httpServletRequest
    * @return workFlowModelDto 工作流模板DTO
    * @throws Exception
    */
    public WorkFlowModelDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //取得当前用户信息，写操作员信息到实赔中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
     // System.out.println("---------------userCode----------"+user.getUserCode());
      String    userCode = user.getUserCode() ;  //用户代码
      WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();
      /*---------------------工作流模板主表------------------------------------*/
      SwfModelMainDto swfModelMain = new SwfModelMainDto();
      int    modelNo     = 0;  //模板代码
      String modelName   = "" ;//模板名称
      String modelType   = "" ;//模板类型
      String modelStatus = "" ;//模板状态
      String createDate  = "" ;//创建时间
      String modifyDate  = "" ;//修改时间
      String rightID     = "" ; //使用范围
      String modelAttr   = "" ; //业务属性
      String closeService   = "" ; //结束服务
      String activeService   = "" ; //激活服务
      String wfModelMainFlag = "" ; //标志位

      modelNo      = Integer.parseInt(httpServletRequest.getParameter("swfModelMainModelNo"));
      modelName    = httpServletRequest.getParameter("swfModelMainModelName");
      modelType    = httpServletRequest.getParameter("modelType");
      modelStatus  = httpServletRequest.getParameter("modelStatus");
      createDate   = httpServletRequest.getParameter("swfModelMainCreateDate") ;
      modifyDate   = httpServletRequest.getParameter("swfModelMainModifyDate") ;
      rightID      = httpServletRequest.getParameter("swfModelMainRightID");
      modelAttr          = httpServletRequest.getParameter("swfModelMainModelAttr");
      closeService       = httpServletRequest.getParameter("swfModelMainCloseService");
      activeService      = httpServletRequest.getParameter("swfModelMainActiveService");
      wfModelMainFlag    = httpServletRequest.getParameter("swfModelMainFlag");

      swfModelMain.setModelNo(modelNo) ;
      swfModelMain.setModelName(modelName);
      swfModelMain.setModelType(modelType);
      swfModelMain.setModelStatus(modelStatus);
      swfModelMain.setCreateDate(new DateTime(createDate));
      swfModelMain.setModifyDate(new DateTime(modifyDate));
      swfModelMain.setAuthorCode(userCode) ;
      swfModelMain.setRightId(rightID) ;
      swfModelMain.setModelAttr(modelAttr);
      swfModelMain.setCloseService(closeService) ;
      swfModelMain.setActiveService(activeService) ;
      swfModelMain.setFlag(wfModelMainFlag) ;

      workFlowModelDto.setSwfModelMainDto(swfModelMain);

      /*---------------------节点表WfNode------------------------------------*/
      ArrayList wfNodeList = new ArrayList();
      SwfNodeDto swfNodeDto = null ;

      String[] swfNodeNodeNo      = httpServletRequest.getParameterValues("swfNodeNodeNo") ;
      String[] swfNodeNodeName    = httpServletRequest.getParameterValues("swfNodeNodeName") ;
      String[] swfNodeTimeLimit   = httpServletRequest.getParameterValues("swfNodeTimeLimit") ;
      String[] endFlag           = httpServletRequest.getParameterValues("endFlag") ;
      String[] swfNodeCriterion   = httpServletRequest.getParameterValues("swfNodeCriterion") ;
      String[] nodeType          = httpServletRequest.getParameterValues("nodeType") ;
      String[] swfNodePosX        = httpServletRequest.getParameterValues("swfNodePosX") ;
      String[] swfNodePosY        = httpServletRequest.getParameterValues("swfNodePosY") ;
      String[] taskType           = httpServletRequest.getParameterValues("taskType");
      String[] swfNodeTaskNo          = httpServletRequest.getParameterValues("swfNodeTaskNo");

      for(int i=1;i<swfNodeNodeNo.length;i++)
      {
        swfNodeDto = new SwfNodeDto();
        swfNodeDto.setModelNo(modelNo) ;
        swfNodeDto.setModelName(modelName);
        swfNodeDto.setNodeNo(Integer.parseInt(DataUtils.nullToZero(swfNodeNodeNo[i])));
        swfNodeDto.setNodeName(swfNodeNodeName[i]);
        swfNodeDto.setTimeLimit(Integer.parseInt(DataUtils.nullToZero(swfNodeTimeLimit[i]))) ;
        swfNodeDto.setEndFlag(endFlag[i]) ;
        swfNodeDto.setCriterion(swfNodeCriterion[i]) ;
        swfNodeDto.setNodeType(nodeType[i]) ;
        swfNodeDto.setPosX(Integer.parseInt(DataUtils.nullToZero(swfNodePosX[i]))) ;
        swfNodeDto.setPosY(Integer.parseInt(DataUtils.nullToZero(swfNodePosY[i]))) ;
        swfNodeDto.setTaskNo(Integer.parseInt(DataUtils.nullToZero(swfNodeTaskNo[i]))) ;
        swfNodeDto.setTaskType(taskType[i]);
        wfNodeList.add(swfNodeDto);
      }
     //装入wfNodeDto
      workFlowModelDto.setSwfNodeDtoList(wfNodeList);


      /*---------------------节点表WfPath------------------------------------*/
      ArrayList wfPathList = new ArrayList();
      SwfPathDto swfPathDto = null ;
      String[] swfPathPathNo          = httpServletRequest.getParameterValues("swfPathPathNo") ;
      String[] swfPathPathName        = httpServletRequest.getParameterValues("swfPathPathName") ;
      String[] swfPathStartNodeNo     = httpServletRequest.getParameterValues("swfPathStartNodeNo") ;
      String[] swfPathStartNodeName   = httpServletRequest.getParameterValues("swfPathStartNodeName") ;
      String[] swfPathEndNodeNo       = httpServletRequest.getParameterValues("swfPathEndNodeNo") ;
      String[] swfPathEndNodeName     = httpServletRequest.getParameterValues("swfPathEndNodeName") ;
      String[] swfPathPriority        = httpServletRequest.getParameterValues("swfPathPriority") ;
      String[] swfPathDefaultFlag     = httpServletRequest.getParameterValues("swfPathDefaultFlag") ;

     for(int i=1;i<swfPathPathNo.length;i++)
     {
       swfPathDto = new SwfPathDto();
       swfPathDto.setModelNo(modelNo) ;
       swfPathDto.setModelName(modelName);
       swfPathDto.setPathNo(Integer.parseInt(DataUtils.nullToZero(swfPathPathNo[i])));
       swfPathDto.setPathName(swfPathPathName[i]);
       swfPathDto.setStartNodeNo(Integer.parseInt(swfPathStartNodeNo[i])) ;
       swfPathDto.setStartNodeName(swfPathStartNodeName[i]) ;
       swfPathDto.setEndNodeNo(Integer.parseInt(swfPathEndNodeNo[i])) ;
       swfPathDto.setEndNodeName(swfPathEndNodeName[i]) ;
       swfPathDto.setPriority(Integer.parseInt(DataUtils.nullToZero(swfPathPriority[i]))) ;
       swfPathDto.setDefaultFlag(swfPathDefaultFlag[i]) ;

       wfPathList.add(swfPathDto);
     }
    //装入wfNodeDto
     workFlowModelDto.setSwfPathDtoList(wfPathList);


      return workFlowModelDto;

    }

   /**
    * 取初始化信息需要的数据的整理.
    * @param httpServletRequest
    * @return WorkFlowModelDto 取初始化信息需要的数据
    * @throws Exception
    */
   public  WorkFlowModelDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
   {
      WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();

      return workFlowModelDto;
   }
   /**
    * 初始化Dto到View
    * @param httpServletRequest HttpServletRequest
    * @throws Exception
    */
   public void intDtoToView(HttpServletRequest httpServletRequest) throws Exception
   {
     int modelNo = 0 ;
     String editType = "" ;//编辑类型
     //初始化模板主表
     SwfModelMainDto swfModelMainDto = new SwfModelMainDto();
     UIWorkFlowModelAction uiWorkFlowModelAction = new UIWorkFlowModelAction();
     //取得模板号
     modelNo = uiWorkFlowModelAction.getModelNo() ;
     //取得编辑类型
     editType = httpServletRequest.getParameter("editType") ;
     swfModelMainDto.setModelNo(modelNo);
     swfModelMainDto.setEditType(editType);
     swfModelMainDto.setCreateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY)) ;
     swfModelMainDto.setModifyDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY)) ;
     httpServletRequest.setAttribute("swfModelMainDto", swfModelMainDto);

     //初始化节点
     Collection arrayList = new ArrayList();
     SwfNodeDto swfNodeDtoList = new SwfNodeDto();
     SwfNodeDto swfNodeDto     = new SwfNodeDto();
     swfNodeDtoList.setNodeNo(1);
     arrayList.add(swfNodeDtoList);
     swfNodeDto.setNodeList(arrayList) ;
     httpServletRequest.setAttribute("swfNodeDto",swfNodeDto) ;
     //初始化路径
     Collection pathArrayList = new ArrayList();
     SwfPathDto swfPathDto      = new SwfPathDto();
     SwfPathDto swfPathDtoList      = new SwfPathDto();
     swfPathDtoList.setPathNo(1) ;
     pathArrayList.add(swfPathDtoList);
     swfPathDto.setPathList(pathArrayList) ;
     httpServletRequest.setAttribute("swfPathDto",swfPathDto) ;
     //初始化边条件
     Collection conditionArrayList = new ArrayList();
     SwfConditionDto swfConditionDto = new SwfConditionDto();
     SwfConditionDto swfConditionDtoList = new SwfConditionDto();
     conditionArrayList.add(swfConditionDtoList);
     swfConditionDto.setConditionList(conditionArrayList) ;
     httpServletRequest.setAttribute("swfConditionDto",swfConditionDto) ;
   }

   /**
    * 初始化wfModelUseDto到View
    * @param httpServletRequest HttpServletRequest
    * @throws Exception
    */
   public void iniWfModelUseDtoToView(HttpServletRequest httpServletRequest) throws Exception
   {
     int modelNo = 0 ;
     String editType = "" ;//编辑类型
     String conditions = ""; //条件
     //初始化模板使用设置Dto
     SwfModelUseDto swfModelUseDto = new SwfModelUseDto();
     UIWorkFlowModelAction uiWorkFlowModelAction = new UIWorkFlowModelAction();
     //取得编辑类型
     editType = httpServletRequest.getParameter("editType") ;
     swfModelUseDto.setEditType(editType) ;
     httpServletRequest.setAttribute("swfModelUseDto", swfModelUseDto);

     //得到模板列表
       Collection modelMainList = new ArrayList();
       Collection modelMainListNew = new ArrayList();

       conditions = " 1=1 AND modelStatus='1' order by modelNo" ;
       modelMainList = new UIWorkFlowModelAction().findByModelMainConditions(conditions) ;
       //将模板名称改成1-财产险模板的方式
       SwfModelMainDto swfModelMainDto = null;
       Iterator moderMainIterator = modelMainList.iterator() ;
       while(moderMainIterator.hasNext())
       {
         Object test = moderMainIterator.next();
         if(test instanceof SwfModelMainDto)
         {
           swfModelMainDto = (SwfModelMainDto) test;
         }
         swfModelMainDto.setModelName(swfModelMainDto.getModelNo() + "-" + swfModelMainDto.getModelName()) ;
         modelMainListNew.add(swfModelMainDto) ;
       }
       httpServletRequest.setAttribute("modelMainList",modelMainListNew) ;

       //得到险种列表
       ArrayList riskList = new ArrayList();
       Collection riskListNew = new ArrayList();
       conditions =" ValidStatus = '1' order by riskCode " ;
       riskList  = (ArrayList)new UIRiskAction().findByConditions(conditions) ;

       //将险种名称改成QAA-财产险的方式

       for(int i=0;i<riskList.size();i++)
       {
         PrpDriskDto prpDriskDto = (PrpDriskDto)riskList.get(i);
         if(prpDriskDto instanceof PrpDriskDto)
         {

         }

         prpDriskDto.setRiskCName(prpDriskDto.getRiskCode() + "-" + prpDriskDto.getRiskCName()) ;
         riskListNew.add(prpDriskDto) ;
       }
       httpServletRequest.setAttribute("riskList",riskListNew) ;
       //得到部门列表
       ArrayList companyList = new ArrayList();
       Collection companyListNew = new ArrayList();
       conditions = " ValidStatus = '1' AND SUBSTR(ComType,1,1) ='1' order by comcode" ;
       companyList = (ArrayList)new UICompanyAction().findByConditions(conditions) ;

       //将单位名称改成00000000-总公司的方式

       for(int i=0;i<companyList.size();i++)
       {
         PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)companyList.get(i);
         prpDcompanyDto.setComCName(prpDcompanyDto.getComCode() + "-" + prpDcompanyDto.getComCName()) ;
         companyListNew.add(prpDcompanyDto) ;
       }
       httpServletRequest.setAttribute("companyList",companyListNew) ;

   }


   /**
    * 查询结果显示
    * @param httpServletRequest 返回给页面的request
    * @param modelNo 模板号
    * @throws Exception
    */
    public void dtoToView(HttpServletRequest httpServletRequest, int modelNo) throws Exception
    {
       WorkFlowModelDto workFlowModelDto = null;
       workFlowModelDto = new UIWorkFlowModelAction().findByPrimaryKey(modelNo) ;
       //准备模板数据
       SwfModelMainDto  swfModelMainDto = workFlowModelDto.getSwfModelMainDto() ;
       //加入编辑类型
       swfModelMainDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("swfModelMainDto",swfModelMainDto) ;
       //准备节点数据
       Collection      nodeList = new ArrayList();
       SwfNodeDto      swfNodeDto      = new SwfNodeDto();
       nodeList        = workFlowModelDto.getSwfNodeDtoList() ;
       swfNodeDto.setNodeList(nodeList) ;

       for(int i=0;i<((ArrayList)nodeList).size() ;i++)
       {
         System.out.println("endFlg="+((SwfNodeDto)((ArrayList)nodeList).get(i)).getEndFlag() );
         System.out.println("nodeType="+((SwfNodeDto)((ArrayList)nodeList).get(i)).getNodeType() );
       }
       httpServletRequest.setAttribute("swfNodeDto",swfNodeDto) ;
       //准备路径数据
       Collection pathList   = new ArrayList();
       SwfPathDto swfPathDto   = new SwfPathDto();
       pathList              = workFlowModelDto.getSwfPathDtoList() ;
       swfPathDto.setPathList(pathList) ;
       httpServletRequest.setAttribute("swfPathDto",swfPathDto) ;
       //准备路径条件数据
       Collection conditionList = new ArrayList();
       SwfConditionDto swfConditionDto = new SwfConditionDto();
       conditionList = workFlowModelDto.getSwfConditionDtoList() ;
       swfConditionDto.setConditionList(conditionList) ;
       httpServletRequest.setAttribute("swfConditionDto",swfConditionDto);

    }
    /**
     * 查询模板列表
     * @param httpServletRequest HttpServletRequest
     * @throws Exception
     */
    public void setWfModelMainDtoToView(HttpServletRequest httpServletRequest) throws Exception
    {
      String conditions = "" ;
      conditions = " 1=1 ORDER BY modelNo";
      SwfModelMainDto swfModelMainDto = new SwfModelMainDto();
      //得到多行的模板列表
      Collection arrayList = new ArrayList();
      UIWorkFlowModelAction  uiWorkFlowModelAction = new UIWorkFlowModelAction();
      arrayList = uiWorkFlowModelAction.findByModelMainConditions(conditions) ;
      swfModelMainDto.setModelMainList(arrayList) ;
      httpServletRequest.setAttribute("swfModelMainDto",swfModelMainDto) ;
      return ;
    }

    /**
     * 查询模板条件列表
     * @param httpServletRequest HttpServletRequest
     * @throws Exception
     */
    public void setWfConditionDtoToView(HttpServletRequest httpServletRequest,int modelNo,int pathNo) throws Exception
    {
      String conditions = "" ;
      String pathName   = "" ; //路径名
      conditions = " modelNo=" + modelNo + " AND pathNo=" + pathNo ;
      String editType = httpServletRequest.getParameter("editType");
      pathName = httpServletRequest.getParameter("pathName");
      SwfConditionDto swfConditionDto = new SwfConditionDto();
      //得到多行的模板列表
      Collection arrayList = new ArrayList();
      UIWorkFlowModelAction  uiWorkFlowModelAction = new UIWorkFlowModelAction();
      arrayList = uiWorkFlowModelAction.findByWfConditionConditions(conditions) ;
      swfConditionDto.setModelNo(modelNo) ;
      swfConditionDto.setPathNo(pathNo);
      swfConditionDto.setEditType(editType) ;
      swfConditionDto.setPathName(pathName) ;
      swfConditionDto.setConditionList(arrayList) ;

      for (Iterator i = arrayList.iterator(); i.hasNext(); ) {
            SwfConditionDto swfCondition1 = (SwfConditionDto)i.next();
            System.out.println("conditionNo="+ swfCondition1.getConditionNo() );
            System.out.println("DBName="+ swfCondition1.getDBName());
            System.out.println("configType="+ swfCondition1.getConfigType());

      }


      httpServletRequest.setAttribute("swfConditionDto",swfConditionDto) ;
      System.out.println("查询模板条件列表成功");
      return ;
    }

    /**
     * 工作流模板条件数据收集
     * @param httpServletRequest
     * @return wfConditionDto 工作流模板条件DTO
     * @throws Exception
     */
     public SwfConditionDto viewSwfConditionToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       //取得当前用户信息，写操作员信息到实赔中
       HttpSession session = httpServletRequest.getSession();

       SwfConditionDto swfConditionDtoAll = new SwfConditionDto();
       /*---------------------节点表WfCondition------------------------------------*/
       ArrayList swfConditionList       = new ArrayList();
       SwfConditionDto swfConditionDto   = null ;
       String   swfConditionModelNo     = httpServletRequest.getParameter("swfConditionModelNo");
       String   swfConditionPathNo      = httpServletRequest.getParameter("swfConditionPathNo") ;
       String[] swfConditionConditionNo = httpServletRequest.getParameterValues("swfConditionConditionNo") ;
       String[] swfConditionSerialNo    = httpServletRequest.getParameterValues("swfConditionSerialNo") ;
       String[] swfConditionConfigType  = httpServletRequest.getParameterValues("configType") ;
       String[] swfConditionValidStatus = httpServletRequest.getParameterValues("validStatus") ;
       String[] swfConditionBusinessKey = httpServletRequest.getParameterValues("swfConditionBusinessKey") ;
       String[] swfConditionDBName      = httpServletRequest.getParameterValues("swfConditionDBName") ;
       String[] swfConditionTableName   = httpServletRequest.getParameterValues("swfConditionTableName") ;
       String[] swfConditionDataType    = httpServletRequest.getParameterValues("swfConditionDataType") ;
       String[] swfConditionColumnName  = httpServletRequest.getParameterValues("swfConditionColumnName") ;
       String[] swfConditionColumnDesc  = httpServletRequest.getParameterValues("swfConditionColumnDesc") ;
       String[] swfConditionOperator    = httpServletRequest.getParameterValues("operator") ;
       String[] swfConditionValue       = httpServletRequest.getParameterValues("swfConditionValue") ;


      for(int i=1;i<swfConditionConditionNo.length;i++)
      {

        swfConditionDto = new SwfConditionDto();
        swfConditionDto.setModelNo(Integer.parseInt(DataUtils.nullToZero(swfConditionModelNo))) ;
        swfConditionDto.setPathNo(Integer.parseInt(DataUtils.nullToZero(swfConditionPathNo)));
        swfConditionDto.setConditionNo(Integer.parseInt(DataUtils.nullToZero(swfConditionConditionNo[i])));
        swfConditionDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(swfConditionSerialNo[i])));
        swfConditionDto.setConfigType(swfConditionConfigType[i]) ;
        swfConditionDto.setValidStatus(swfConditionValidStatus[i]) ;
        swfConditionDto.setBusinessKey(swfConditionBusinessKey[i]) ;
        swfConditionDto.setDBName(swfConditionDBName[i]) ;
        swfConditionDto.setTableName(swfConditionTableName[i]) ;
        swfConditionDto.setDataType(swfConditionDataType[i]) ;
        swfConditionDto.setColumnName(swfConditionColumnName[i]) ;
        swfConditionDto.setColumnDesc(swfConditionColumnDesc[i]) ;
        swfConditionDto.setOperator(swfConditionOperator[i]) ;
        swfConditionDto.setValue(swfConditionValue[i]) ;

        swfConditionList.add(swfConditionDto);
      }
     //装入wfNodeDto
      swfConditionDtoAll.setConditionList(swfConditionList);
      swfConditionDtoAll.setModelNo(Integer.parseInt(swfConditionModelNo)) ;
      swfConditionDtoAll.setPathNo(Integer.parseInt(swfConditionPathNo)) ;


      return swfConditionDtoAll;

     }
     /**
      * 将界面的wfModelUse转成wfModelUseDto
      * @param httpServletRequest HttpServletRequest
      * @throws Exception
      */
     public SwfModelUseDto viewSwfModelUseToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       //取得当前用户信息，写操作员信息到实赔中
       HttpSession session = httpServletRequest.getSession();

       SwfModelUseDto swfModelUseDtoAll = new SwfModelUseDto();
       /*---------------------模板使用表WfModelUse------------------------------------*/
       ArrayList swfModelUseList       = new ArrayList();
       SwfModelUseDto swfModelUseDto    = null ;

       String swfModelUseModelNo      = httpServletRequest.getParameter("modelNo") ;
       String[] swfModelUseRiskCode     = httpServletRequest.getParameterValues("riskCode") ;
       String[] swfModelUseComCode      = httpServletRequest.getParameterValues("comCode") ;
       String   swfModelUseModelStatus  = httpServletRequest.getParameter("swfModelUseModelStatus");
       //System.out.println("#############swfModelUseModelStatus="+swfModelUseModelStatus);
      System.out.println("$$$$$$$swfModelUseRiskCode="+swfModelUseRiskCode.length );
      System.out.println("$$$$$$$swfModelUseComCode="+swfModelUseComCode.length );
      for(int i=0;i<swfModelUseRiskCode.length;i++)
      {
        for(int j=0;j<swfModelUseComCode.length;j++)
        {
          swfModelUseDto = new SwfModelUseDto();
          swfModelUseDto.setModelNo(Integer.parseInt(swfModelUseModelNo));
          swfModelUseDto.setRiskCode(swfModelUseRiskCode[i]);
          swfModelUseDto.setComCode(swfModelUseComCode[j]);
          swfModelUseDto.setModelStatus(swfModelUseModelStatus) ;
          //System.out.println("|" + swfModelUseModelNo+ "|" + swfModelUseRiskCode[i]+"|" + swfModelUseComCode[j]);
          swfModelUseDto.setModelType("01") ;
          swfModelUseList.add(swfModelUseDto);
        }
      }
      System.out.println("######ModelUseList###="+swfModelUseList.size() );
     //装入wfModelUseDto
      swfModelUseDtoAll.setModelUseList(swfModelUseList);
      return swfModelUseDtoAll;

     }

     /**
      * 将界面的wfModelUse转成wfModelUseDto
      * @param httpServletRequest HttpServletRequest
      * @throws Exception
      */
     public SwfModelUseDto viewSwfModelUseEditToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       //取得当前用户信息，写操作员信息到实赔中
       HttpSession session = httpServletRequest.getSession();

       SwfModelUseDto swfModelUseDtoAll = new SwfModelUseDto();
       /*---------------------模板使用表WfModelUse------------------------------------*/
       ArrayList swfModelUseList       = new ArrayList();
       SwfModelUseDto swfModelUseDto    = null ;

       String[] swfModelUseModelNo        = httpServletRequest.getParameterValues("modelNo") ;
       String[] swfModelUseRiskCode     = httpServletRequest.getParameterValues("riskCode") ;
       String[] swfModelUseComCode      = httpServletRequest.getParameterValues("comCode") ;

      for(int i=1;i<swfModelUseModelNo.length ;i++)
      {

            swfModelUseDto = new SwfModelUseDto();
            swfModelUseDto.setModelNo(Integer.parseInt(swfModelUseModelNo[i]));
            swfModelUseDto.setRiskCode(swfModelUseRiskCode[i]);
            swfModelUseDto.setComCode(swfModelUseComCode[i]);
            System.out.println("|" + swfModelUseModelNo[i] + "|" +
                               swfModelUseRiskCode[i] + "|" + swfModelUseComCode[i]);
            swfModelUseDto.setModelType("01") ;
            swfModelUseList.add(swfModelUseDto);


      }
     //装入wfModelUseDto
      swfModelUseDtoAll.setModelUseList(swfModelUseList);
      return swfModelUseDtoAll;

     }


     /**
      * 初始化wfModelUseDto到View
      * @param httpServletRequest HttpServletRequest
      * @throws Exception
      */
     public void getSwfModelUseDtoToView(HttpServletRequest httpServletRequest) throws Exception
     {
       int modelNo = 0 ;
       String editType = "" ;//编辑类型
       String conditions = ""; //条件
       //初始化模板使用设置Dto
       SwfModelUseDto swfModelUseDto = new SwfModelUseDto();
       UIWorkFlowModelAction uiWorkFlowModelAction = new UIWorkFlowModelAction();
       //取得编辑类型
       editType = httpServletRequest.getParameter("editType") ;
       conditions = " 1=1";
       Collection modelUseList = new ArrayList();
       modelUseList = uiWorkFlowModelAction.findByModelUseConditions(conditions) ;
       swfModelUseDto.setEditType(editType) ;
       swfModelUseDto.setModelUseList(modelUseList) ;
       httpServletRequest.setAttribute("swfModelUseDto", swfModelUseDto);

       //得到模板列表
       ArrayList modelMainList = new ArrayList();
       Collection modelMainListNew = new ArrayList();

       conditions = " 1=1 AND ModelStatus='1' ORDER BY modelNo" ;
       modelMainList = (ArrayList)new UIWorkFlowModelAction().findByModelMainConditions(conditions) ;
       //将模板名称改成1-财产险模板的方式
       for(int i=0;i<modelMainList.size();i++)
       {
         SwfModelMainDto swfModelMainDto = (SwfModelMainDto)modelMainList.get(i);
         swfModelMainDto.setModelName(swfModelMainDto.getModelNo() + "-" + swfModelMainDto.getModelName()) ;
         modelMainListNew.add(swfModelMainDto) ;
       }

       httpServletRequest.setAttribute("modelMainList",modelMainList) ;

       //得到险种列表
       ArrayList riskList = new ArrayList();
       Collection riskListNew = new ArrayList();
       conditions =" ValidStatus = '1' ORDER BY riskcode" ;
       riskList  = (ArrayList)new UIRiskAction().findByConditions(conditions) ;

       //将险种名称改成QAA-财产险的方式
       for(int i=0;i<riskList.size();i++)
       {
         PrpDriskDto prpDriskDto = (PrpDriskDto)riskList.get(i);
         prpDriskDto.setRiskCName(prpDriskDto.getRiskCode() + "-" + prpDriskDto.getRiskCName()) ;
         riskListNew.add(prpDriskDto) ;
       }
       httpServletRequest.setAttribute("riskList",riskListNew) ;
       //得到部门列表
       ArrayList companyList = new ArrayList();
       Collection companyListNew = new ArrayList();
       conditions = " ValidStatus = '1' AND SUBSTR(ComType,1,1) ='1' ORDER BY ComCode" ;
       companyList = (ArrayList)new UICompanyAction().findByConditions(conditions) ;

       //将单位名称改成00000000-总公司的方式
       for(int i=0;i<companyList.size();i++)
       {
         PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)companyList.get(i);
         prpDcompanyDto.setComCName(prpDcompanyDto.getComCode() + "-" + prpDcompanyDto.getComCName()) ;
         companyListNew.add(prpDcompanyDto) ;
       }
       httpServletRequest.setAttribute("companyList",companyListNew) ;
     }


 }
