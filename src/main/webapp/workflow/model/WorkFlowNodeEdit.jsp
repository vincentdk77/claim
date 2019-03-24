 <%--
****************************************************************************
* DESC       ：模板节点
* AUTHOR     ：weishixin
* CREATEDATE ：2004-08-10
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
    <%--多行输入自定义JavaScript方法域--%>
 
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法

     /*
        插入一条新的WorkFlowNode之后的处理（可选方法）
      */
      function afterInsertWorkFlowNode()
      {
        setWorkFlowNodeNo();
      }
    
      /*
        删除本条之后的处理（可选方法）
      */
      function afterDeleteWorkFlowNode(field)
      {
        
        //setWorkFlowNodeNo();
      }
    
        /**
         * 设置setWorkFlowNodeNo
         */
        function setWorkFlowNodeNo()
        {
            var count=getElementCount("swfNodeNodeNo");
            var i = count -1;

           if(count!=2){
               fm.swfNodeNodeNo[i].value=parseInt(fm.swfNodeNodeNo[i-1].value)+1;
           }
           else
           {
             fm.swfNodeNodeNo[1].value = 1;
           }

        }
        
        /**
         * 限制删除，当是第一条时不删除
         */
         function deleteRowLimit(field,pageCode)
         {
            var order = getElementOrder(field);
            if(order==2)
            {
               alert("第一个节点不能删除！！");
            }
            else
            {
              deleteRow(field,pageCode);
            }
         }
         
         /**
           * 节点类型改变时也改变节点名称
           *
           */
          function  changeNodeType(field)
          {
            var order = getElementOrder(field);
            if(fm.nodeType[order-1].value=="regis")
            { 
              fm.swfNodeNodeName[order-1].value = "报案";
            }
            else if(fm.nodeType[order-1].value=="sched")
            { 
              fm.swfNodeNodeName[order-1].value = "查勘调度";
            }
            else if(fm.nodeType[order-1].value=="check")
            { 
              fm.swfNodeNodeName[order-1].value = "查勘";
            }
            else if(fm.nodeType[order-1].value=="certa")
            { 
              fm.swfNodeNodeName[order-1].value = "定损";
            }
            else if(fm.nodeType[order-1].value=="verip")
            { 
              fm.swfNodeNodeName[order-1].value = "核价";
            }
            else if(fm.nodeType[order-1].value=="verpo")
            { 
              fm.swfNodeNodeName[order-1].value = "向外询价";
            }
            else if(fm.nodeType[order-1].value=="verif")
            { 
              fm.swfNodeNodeName[order-1].value = "核损";
            }
            else if(fm.nodeType[order-1].value=="claim")
            { 
              fm.swfNodeNodeName[order-1].value = "立案";
            }
            else if(fm.nodeType[order-1].value=="certi")
            { 
              fm.swfNodeNodeName[order-1].value = "单证";
            }else if(fm.nodeType[order-1].value=="prepa")
            { 
              fm.swfNodeNodeName[order-1].value = "预赔";
            }
            else if(fm.nodeType[order-1].value=="compe")
            { 
              fm.swfNodeNodeName[order-1].value = "实赔";
            }
            else if(fm.nodeType[order-1].value=="compp")
            { 
              fm.swfNodeNodeName[order-1].value = "计算书";
            }
            else if(fm.nodeType[order-1].value=="endca")
            { 
              fm.swfNodeNodeName[order-1].value = "结案";
            }
            else if(fm.nodeType[order-1].value=="wound")
            { 
              fm.swfNodeNodeName[order-1].value = "人伤";
            }
             else if(fm.nodeType[order-1].value=="veriw")
            { 
              fm.swfNodeNodeName[order-1].value = "人伤核损";
            }
             else if(fm.nodeType[order-1].value=="cance")
            { 
              fm.swfNodeNodeName[order-1].value = "注销/拒赔";
            }
             else if(fm.nodeType[order-1].value=="speci")
            { 
              fm.swfNodeNodeName[order-1].value = "预赔案";
            }

            //modify by liujianbo modify 20050314 start
            //reason:增加财产定损/核损
             else if(fm.nodeType[order-1].value=="propc")
            { 
              fm.swfNodeNodeName[order-1].value = "财产定损";
            }
             else if(fm.nodeType[order-1].value=="propv")
            { 
              fm.swfNodeNodeName[order-1].value = "财产核损";
            }   
             else if(fm.nodeType[order-1].value=="backc")
            { 
              fm.swfNodeNodeName[order-1].value = "修复验车";
            } 
            //modify by liujianbo modify 20050314 end     
            //modify by lixiang modify 20050319 start
            //reason:定损调度
            
            else if(fm.nodeType[order-1].value=="schel")
            { 
              fm.swfNodeNodeName[order-1].value = "定损调度";
            }
            //modify by lixiang modify 20050319 end    
            //Modify by chenrenda update 20050323 begin
            //Reason:增加回访节点
            else if(fm.nodeType[order-1].value=="backv")
            { 
              fm.swfNodeNodeName[order-1].value = "回访";
            }
            //Modify by chenrenda update 20050323 end
             else if(fm.nodeType[order-1].value=="veric")
            { 
              fm.swfNodeNodeName[order-1].value = "核赔";
            }
            
            
                
          }
          /**
           * 功能：当选项为多任务时，任务编号可写
           */
           function setTaskNoEnable(field)
           {
              var order = getElementOrder(field);
              if(field.value=="M"||field.value=="T")
              {
                 fm.swfNodeTaskNo[order-1].readOnly = false;
              }
              else
              {
                 fm.swfNodeTaskNo[order-1].readOnly = true;
              }
           }
           
           /**
            * 功能 ：回置任务号
            *
            */
            function resetTaskNo(field)
            {
               var mutiTaskNo   = field.value;          //多任务节点的值
               var order = getElementOrder(field);
               var lengthTaskNo = fm.swfNodeTaskNo.length;  //多任务节点的
               
               if (fm.taskType[order-1].value=="T") return;
               
               for(var i=0;i<lengthTaskNo;i++)
               {
                  if(fm.swfNodeNodeNo[i].value == mutiTaskNo)
                  {
                     fm.swfNodeTaskNo[i].value = fm.swfNodeNodeNo[order-1].value;
                  }
               }
            }
    </script> 
   <br>
   <!--建立显示的录入条，可以收缩显示的-->
      <span style="display:none"> 
          <table class="common" style="display:none" id="WorkFlowNode_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr class=common>                                             
          <td class='input'>
             <input name="swfNodeNodeNo" class="readonly" readonly="true"  title="节点编号" value="1"> 
          </td>
          <td class='input'>                                                    
             <input name=swfNodeNodeName class="common" title="节点名称"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="nodeType" styleClass="common" onclick="changeNodeType(this);">
			      <html:option value="regis" >报案</html:option> 
			      <html:option value="sched" >查勘调度</html:option>       
			      <html:option value="check" >查勘</html:option>       
			      <html:option value="certa" >定损</html:option>       
			      <html:option value="verip" >核价</html:option>       
			      <html:option value="verpo" >向外询价</html:option>       
			      <html:option value="verif" >核损</html:option>       
			      <html:option value="claim" >立案</html:option>       
			      <html:option value="certi" >单证</html:option>       
			      <html:option value="prepa" >预赔</html:option>       
			      <html:option value="compe" >实赔</html:option> 
			      <html:option value="compp" >计算书</html:option>       
			      <html:option value="endca" >结案</html:option>     
			      <html:option value="wound" >人伤</html:option> 
			      <html:option value="veriw" >人伤核损</html:option>  
			      <html:option value="cance" >注销/拒赔</html:option>  
			      <html:option value="speci" >预赔案</html:option>  
			      <html:option value="veric" >核赔</html:option> 
			      
			           
          <%--modify by liujianbo modify 20050314 start--%>
          <%--resson:增加财产定损/核损--%>
			      <html:option value="propc" >财产定损</html:option>  
			      <html:option value="propv" >财产核损</html:option>  
			      <html:option value="backc" >修复验车</html:option>  
		        <html:option value="backv" >回访</html:option>  
            <html:option value="schel" >定损调度</html:option> 
              
              </html:select>
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="taskType" styleClass="three"  style="width:80px" onclick="return setTaskNoEnable(this);">
			      <html:option value="S" >单任务</html:option>       
			      <html:option value="M" >多任务</html:option> 
			      <html:option value="T" >特殊任务</html:option> 
			      
              </html:select>
          </td>
          <td class='input'>
              <input name=swfNodeTaskNo class="common" style="width:95%" readonly title="任务编号" onblur="return resetTaskNo(this);">
          </td>
          <td class='input'>
              <input name=swfNodeTimeLimit class="common" title="处理时限" value="0"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="endFlag" styleClass="three"  style="width:80px">
			      <html:option value="0" >否</html:option> 
			      <html:option value="1" >是</html:option> 
              </html:select>
          </td>                     
          <td class='input'>
              <input name=swfNodeCriterion class="common" style="width:95%" title="处理要求">
          </td>
          <td class='input'>
              <div align="center">
                <input type=button name="buttonWorkFlowNodeDelete"  class=smallbutton onclick="deleteRowLimit(this,'WorkFlowNode')" value="-" style="cursor: hand">
              </div>
              
           </td>
           <input type=hidden name="swfNodePosX" value="0">  
           <input type=hidden name="swfNodePosY" value="0">  
         </tr>
       </tbody>

    </table>
    </span>
        
        <span  id="spanWorkFlowNode" >
        <%-- 多行输入展现域 --%>
        <table id="WorkFlowNode" cellpadding="5" cellspacing="1"  class="common">
          <thead>
             <tr class="mline">
                <td class="title" colspan=11>
                 节点信息 <img src="/claim/images/markMustInput.gif">
                </td>
             </tr>
             <tr class="mline">
		         <td class="title" >节点编号</td>
		         <td class="title" >节点名称</td>
		         <td class="title" >节点类型</td>
		         <td class="title" >任务类型</td>
		         <td class="title" >任务编号</td>
		         <td class="title">处理时限(分钟)</td>
		         <td class="title" >结束标志</td>                                        
		         <td class="title" style="width:20%">处理要求</td>
		         <td class="title" style="width:5%">  </td>                                           
		     </tr> 
          </thead>
          <tfoot>
              <tr class="mline">
                <td class="title" colspan="8" style="width:97%"></td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('WorkFlowNode');" name="buttonWorkFlowNodeInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot> 
           
          <tbody>
        <%int indexNode=0;%>
        
		<logic:notEmpty  name="swfNodeDto"  property="nodeList"> 
        <logic:iterate id="swfNode" name="swfNodeDto" property="nodeList">
          <tr>                                             
          <td class='input'>
             <input name="swfNodeNodeNo" class="readonly" readonly="true" style='width:95%' title="节点编号" value="<bean:write name='swfNode' property='nodeNo'/>"> 
          </td>
          <td class='input'>                                                    
             <input name=swfNodeNodeName class="common" title="节点名称" value="<bean:write name='swfNode' property='nodeName'/>"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNode" property="nodeType" styleClass="three"  style="width:80px" onclick="changeNodeType(this);">
			      <html:option value="regis" >报案</html:option> 
			      <html:option value="sched" >查勘调度</html:option>       
			      <html:option value="check" >查勘</html:option>       
			      <html:option value="certa" >定损</html:option>       
			      <html:option value="verip" >核价</html:option>       
			      <html:option value="verpo" >向外询价</html:option>       
			      <html:option value="verif" >核损</html:option>       
			      <html:option value="claim" >立案</html:option>       
			      <html:option value="certi" >单证</html:option>       
			      <html:option value="prepa" >预赔</html:option>       
			      <html:option value="compe" >实赔</html:option> 
			      <html:option value="compp" >计算书</html:option>       
			      <html:option value="endca" >结案</html:option>
			      <html:option value="wound" >人伤</html:option>       
			      <html:option value="veriw" >人伤核损</html:option>    
			      <html:option value="cance" >注销/拒赔</html:option>  
			       <html:option value="speci" >预赔案</html:option>  
            <html:option value="propc" >财产定损</html:option>   
			      <html:option value="propv" >财产核损</html:option> 
			      <html:option value="backc" >修复验车</html:option>   
            <html:option value="backv" >回访</html:option>  
            <html:option value="schel" >定损调度</html:option> 
            <html:option value="veric" >核赔</html:option>
      	  </html:select> 
          </td>
          <td class='input'>
              <html:select name="swfNode" property="taskType" styleClass="three"  style="width:80px" onclick="return setTaskNoEnable(this);">
			      <html:option value="S" >单任务</html:option>   
			      <html:option value="M" >多任务</html:option> 
			       <html:option value="T" >特殊任务</html:option> 
              </html:select>
          </td>
          <td class='input'>
              <input name=swfNodeTaskNo class="common"  readonly style="width:95%" title="任务编号" onblur="return resetTaskNo(this);" value="<bean:write name='swfNode' property='taskNo'/>">
          </td>
          <td class='input'>
              <input name=swfNodeTimeLimit class="common" title="处理时限" value="<bean:write name='swfNode' property='timeLimit'/>"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNode" property="endFlag" styleClass="three"  style="width:80px">
			      <html:option value="0" >否</html:option> 
			      <html:option value="1" >是</html:option>  
              </html:select>
          </td>                     
          <td class='input'>
              <input name=swfNodeCriterion class="common" style="width:95%" title="处理要求" value="<bean:write name='swfNode' property='criterion'/>">
          </td>
          <td class='input'>
              <div align="center">
                <input type=button name="buttonWorkFlowNodeDelete"  onclick="deleteRowLimit(this,'WorkFlowNode')" class=smallbutton value="-" style="cursor: hand">
              </div>
              
           </td>
           <input type=hidden name="swfNodePosX" value="0" value="<bean:write name='swfNode' property='posX'/>">  
           <input type=hidden name="swfNodePosY" value="0" value="<bean:write name='swfNode' property='posY'/>">  
         </tr>        
       <% indexNode++;%>
        </logic:iterate>
        </logic:notEmpty>   
          </tbody>
        </table>  
        </span>    

