<%
//����Ϊ�⽡���ֵ�������ʾҳ�棬��Ҫȥ�����ȵȵ���ص��ж� ��
%>
<%@ page import="java.util.*"%>

<logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
<%
     if(index %2== 0)
          out.print("<tr class=listodd>");
     else
          out.print("<tr class=listeven>");
%>
         <td align="center">
             <%=index+1%>
         </td>
<%
      strindex = "'"+String.valueOf(index)+"'";
      //ȡ�ø��е�DTO������ �жϽڵ����ͺ�״̬�����ݲ�ͬ��״̬��ʵ�ֲ�ͬ�İ�Ť����
      swfLogDto = (SwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      typeFlag = swfLogDto.getTypeFlag();
      dealHref="";      //�����������
      backHref="";      //��մ�����˵�����
      dispHref="";      //�����ʾ������      
      EditLastType=editType; //����
      
  	 String strRiskType = uiCodeAction.translateRiskCodetoRiskType(swfLogDto.getRiskCode());
      carFlag="";//

      if (nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("99")){ //�жϵ�ǰ���������������͵ģ���������Ľڵ��״̬
%>
        <td align="center">
<%
      nowNodeStatus=swfLogDto.getNodeStatus();

      if (nowNodeStatus.equals("3")){

         if (!nodeStatus.equals("-1")){EditLastType="EDIT" ;}
%>
      ���˴���
<%
      }
      if (nowNodeStatus.equals("4")){ %>
      ���ύ
      <%}
      if (nowNodeStatus.equals("5")){ %>
      ��ͨ���˻�
      <%}
      if (nowNodeStatus.equals("0")){
%>
      �´���
<%
        if (swfLogDto.getNodeType().equals("cance"))  EditLastType="CANCELEDIT";
      }
             if (nowNodeStatus.equals("2")){ %> ���ڴ���
<%
             }
%>
          </td>
<%
       }
      // �ѹ���������ȵ�Ҳ��Ҫ ���ص�link��
      //modify by lixiang add 20050304 start
      //reason:���봫����������Ĺ���

      flowStr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
              +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
              +"&nodeType="+swfLogDto.getNodeType()
              +"&businessNo="+swfLogDto.getBusinessNo()
              +"&keyIn="+swfLogDto.getKeyIn()
              +"&policyNo="+swfLogDto.getPolicyNo()
              +"&modelNo="+swfLogDto.getModelNo()
              +"&nodeNo="+swfLogDto.getNodeNo();

       //modify by lixiang add 20050304 end
       //�����Ǹ��ݽڵ����ƵĲ�ͬ������ʾ��һ�еĳ��������ݲ�ͬ����һ����ҵ����룩
       // (nodeStatus.equals("0")&&nowNodeStatus.equals("0")�Ǳ�ʾ�����������е�������
       // nodeStatus.equals("-1") ��ʾ���ǰ���ע����������˵����������ʾ�� %>
          <td align="center">
                  <logic:equal name="swfLogList1" property="nodeType" value="prepa">

<%                if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                        dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
                        }else if (nodeStatus.equals("-1")){ //ע����������

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
		}else{

                        dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
			}
                        }
                        else if (nowNodeStatus.equals("3")) //�������˻صķ�ʽ
                        {  dealHref="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogDto.getKeyIn()+flowStr;
                        }else
                        {
                          dealHref="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogDto.getKeyIn()+flowStr;
                         }
                         dispHref=swfLogDto.getKeyIn();
                         %>
                      <input name=keyIN  type="hidden"  value=<bean:write name="swfLogList1" property="businessNo"/>>
                  </logic:equal>  <!--------acci end---���״̬������------------------------>

                  <logic:equal name="swfLogList1" property="nodeType" value="regis">
                          <% if (nodeStatus.equals("0")){
                          dealHref="/claim/registBeforeEdit.do?prpCmainPolicyNo="+swfLogDto.getBusinessNo()+flowStr;

                          }else{
                          dealHref="/claim/registFinishQueryList.do?prpLregistRegistNo="+swfLogDto.getBusinessNo()+flowStr+"&updateExt=true";
                           }
                          dispHref=swfLogDto.getBusinessNo();
                          %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="compe">
                  <%--modify by weishixin modify 20050227 start--%>
                  <%--resson:UNIX��Сдһ��--%>
                  <% riskCode=swfLogDto.getRiskCode();
                
				           strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
                     if("D".equals(strRiskType)) //add liuyanmei
                     {
                             // modify by wangli update start 20050417
                        String   flowStr1="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
                                 +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
                                  +"&nodeType="+swfLogDto.getNodeType()
                                  +"&businessNo="+swfLogDto.getBusinessNo()
                                  +"&policyNo="+swfLogDto.getPolicyNo()
                                  +"&modelNo="+swfLogDto.getModelNo()
                                  +"&nodeNo="+swfLogDto.getNodeNo();
                                 // +"&caseType="+swfLogDto.getTypeFlag();

                         //remark by wangli start
                     //  dealHref="/claim/common/compensate/CompensateBeforeEdit.jsp?ClaimNo="+swfLogDto.getKeyIn()+flowStr;
                     //remark by wangli end
                         dealHref="/claim/compensateBeforeEditList.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr1;
                       // dealHref="/claim/compensateBeforeEditList.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr;
                     //modify by wangli update end 20050417
                     }
                     else{
                    // out.println("<h1>"+" ClaimNo is "+swfLogDto.getBusinessNo());
                    // out.println("<h3>"+" ClaimNo is "+swfLogDto.getKeyIn());
                    //modify by wangli add 20050519 start
                    //reason:����caseType �������ж����Ǹ����� �˴�Ϊ�⽡��
                    dealHref="/claim/compensateBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+"&caseType="+swfLogDto.getTypeFlag()+flowStr+ "&compeCount=" + swfLogDto.getCompeCount();
		      intriskcode=7;
                   // out.println(" caseType is "+swfLogDto.getTypeFlag());
                    //modify by wangli add 20050519 end
                      //remark
    
                     }
                    dispHref=swfLogDto.getKeyIn();
                 %>
                  <%--modify by weishixin modify 20050227 end--%>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="compp">
                  <% 
                       dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()+flowStr;
                       dispHref=swfLogDto.getBusinessNo();
                  %>
                  </logic:equal>

                   <logic:equal name="swfLogList1" property="nodeType" value="speci">
                   <%
                   if (nowNodeStatus.equals("0")){
                    riskCode=swfLogDto.getRiskCode();
                    //modify by lixiang start at 2005-12-20
                    //reason:ԭ��ûд6״̬��������
                    if (typeFlag.equals("3")||typeFlag.equals("4") || typeFlag.equals("6")){
                    //modify by lixiang end at 2005-12-20
                    
                       if("D".equals(strRiskType)) //add liuyanmei
                         {
                            String   flowStr2="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
                                 +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
                                  +"&nodeType="+swfLogDto.getNodeType()
                                  +"&businessNo="+swfLogDto.getBusinessNo()
                                  +"&policyNo="+swfLogDto.getPolicyNo()
                                  +"&modelNo="+swfLogDto.getModelNo()
                                  +"&nodeNo="+swfLogDto.getNodeNo()
                                  +"&caseType="+swfLogDto.getTypeFlag();

                            dealHref="/claim/compensateBeforeEditList.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr2;
                         }
                        else{
                            dealHref="/claim/compensateBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+"&caseType="+swfLogDto.getTypeFlag()+flowStr;
                         }

                       }
                       if (typeFlag.equals("5")){
                       dealHref="/claim/prepayBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()
                         +"&caseType="+swfLogDto.getTypeFlag()
                         +flowStr;
                       }
                         dispHref=swfLogDto.getKeyIn();


                   }else{
                      //modify by lixiang start at 2005-12-20
                      //reason:ԭ��ûд6״̬��������
                 
                         if (typeFlag.equals("3")||typeFlag.equals("4")||typeFlag.equals("6")){
                       //modify by lixiang end at 2005-12-20
                     
                           dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getKeyOut()
                                       +"&caseType="+typeFlag+flowStr;
                         }
                         if (typeFlag.equals("5"))
                         {
                           dealHref="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
                         }

                         dispHref=swfLogDto.getKeyOut();
                   }
                      %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="claim">
                          <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                            dealHref="/claim/claimBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()+flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }else if (nodeStatus.equals("-1")){ //ע����������
                             if (!nowNodeStatus.equals("0"))
                             {
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
		}else{
                             dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyOut()
                                +flowStr;
			}
                             dispHref=swfLogDto.getKeyOut();
                             }else
                             {
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
		}else{
                              dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getBusinessNo()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}
                             dispHref=swfLogDto.getBusinessNo();
                             }
                            }else{
					if (funcName!=null&&funcName.equals("addLoss")){
				String Lossstr="";
				      Lossstr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
				              +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+"LOSS"
				              +"&nodeType="+swfLogDto.getNodeType()
				              +"&businessNo="+swfLogDto.getBusinessNo()
				              +"&keyIn="+swfLogDto.getKeyIn()
				              +"&policyNo="+swfLogDto.getPolicyNo()
				              +"&modelNo="+swfLogDto.getModelNo()
				              +"&nodeNo="+swfLogDto.getNodeNo();
                            dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyOut()+Lossstr;
						}else{
                            dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyOut()+flowStr;
							}
                           dispHref=swfLogDto.getKeyOut();
                           }
                         %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="check">
                      <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/checkBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                  +"&type=" + request.getAttribute("com.sinosoft.type")
                                  +"&lossItemName="+swfLogDto.getLossItemName()
                                  +"&lossItemCode="+swfLogDto.getLossItemCode()
                                  +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                  +flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
		}else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}
                             dispHref=swfLogDto.getKeyIn();
                            }else{
                            dealHref="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+swfLogDto.getKeyIn()
								    + "&type=" + request.getAttribute("com.sinosoft.type")
                                    +"&lossItemCode="+swfLogDto.getLossItemCode()
                                    +"&lossItemName="+swfLogDto.getLossItemName()
                                    +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                    +flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }
                          %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="endca">
                  <%
                     // modify by wangli update start 20050417
                     //dealHref="/claim/endcaseBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr;
                     dealHref="/claim/endcaseBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+"&ClaimNoSign= ="+"&caseType="+swfLogDto.getTypeFlag()+flowStr;
                     //modify by wangli update end 20050417
                     dispHref=swfLogDto.getKeyIn();
                  %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="certi">
                          <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){

                             dealHref="/claim/certifyBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()+flowStr;
                          }else if (nodeStatus.equals("-1")){ //ע����������

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
		}else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else{
                             dealHref="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+swfLogDto.getKeyIn()+flowStr;
                          }
                          dispHref=swfLogDto.getKeyIn();
                           %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="cance">
                  <%
                     if (nodeStatus.equals("0"))
                     {
                     // dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr;
                      dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()+flowStr
                     +"&typeFlag="+swfLogDto.getTypeFlag()+"&flowInTime="+swfLogDto.getFlowInTime();
                    
                     }else
                     {
                     dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()+flowStr;

                     }

                     dispHref=swfLogDto.getKeyIn();

                  %>
                  </logic:equal>

             <%--Modify by chenrenda add 20050315 begin--%>
             <%--Reason:���ӻطýڵ�  --%>
             <logic:equal name="swfLogList1" property="nodeType" value="backv">
                            <%
                            if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/backVisitBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else{
                            dealHref="/claim/backVisitBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"+flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
             <%--modify by chenrenda add 20050315 end--%>
<%
	if(intriskcode==5){%>
           <a href="<%=dealHref%>" title="<bean:write name="swfLogList1" property="titleStr"/>"><%=dispHref%></a>
<%           }else{%>
           <a href="<%=dealHref%>"title="<bean:write name="swfLogList1" property="titleStr"/>" onclick="return compeCount('<bean:write name="swfLogList1" property="compeCount"/>');" ><%=dispHref%></a>
<%}%>
        </td>
        <%//�������������%>
        <td align="center"> 
        <% //modify by lixiang start at 2006-6-5
           //reason :֧�ֶ����������%>
        <logic:iterate id="relatePolicyList1"  name="swfLogList1"  property="relatePolicyList">  
        <bean:write name="relatePolicyList1" property="policyNo"/>
        </logic:iterate>
         <% //modify by lixiang end at 2006-6-5%>
        </td>
        <td align="center"><bean:write name="swfLogList1" property="riskCodeName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="insuredName"/></td> <!-----acci----------->
        <%//����Ƕ�������г������е�����%>
      <%if (swfLogDto1.getNodeType().equals("certa")){%>
           <td align="center">
             <logic:equal name="swfLogList1" property="exigenceGree" value="0">
              ����
              </logic:equal>
             <logic:equal name="swfLogList1" property="exigenceGree" value="1">
              һ��
              </logic:equal>
           </td>
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
           <td align="center"><%=carFlag%></td>
        
          <%}%>

         <%//������������͵ģ�д���������¼����%>
        <%if (swfLogDto1.getNodeType().equals("compe")){%>
           <td align="center"> <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=<%=EditLastType%>&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>"><bean:write name='swfLogList1' property='keyOut'/></a></td>
        <%}%>

        <%//����Ǽ��������͵ģ�д��������%>
         <%if (swfLogDto1.getNodeType().equals("compp")){%>
          <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                  <bean:write name='swfLogList1' property='keyIn'/></a>
          <%}%>
          </td>

<%//��������ⰸ�����͵ģ�д��������%>
        <logic:equal name="swfLogDto" property="nodeType" value="speci">
         <td align="center">
           <logic:equal name="swfLogList1" property="nodeStatus" value="0">
                 <logic:equal name="swfLogList1" property="typeFlag" value="3">ͨ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="4">Ԥ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="5">Ԥ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="6">����</logic:equal>
           </logic:equal>

           <% if ((!swfLogDto.getNodeStatus().equals("0"))&&(!swfLogDto.getNodeStatus().equals("3"))){%>
             <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                   <bean:write name='swfLogList1' property='keyIn'/></a>
           <%}%>

            </td>
        </logic:equal>

<%//����ǻط�
if(nodeType.equals("backv")){
String backvType="�鿱�ط�";
  if (swfLogDto.getTypeFlag().equals("2")) backvType="����ط�";
%>
        <td align="center"><%=backvType%></td>
<%
}
%>
         <%//����ǲ鿱���͵ģ�д���峵�ƺ��룬%>
          <logic:notEqual name="com.sinosoft.type" value="acci">
          <logic:equal name="swfLogDto" property="nodeType" value="check">
             <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
          </logic:equal>
          </logic:notEqual>

          <%//����ǲ鿱���͵ģ�д���峵�ƺ��룬�������������Ⱥţ������� %>
          <logic:equal name="swfLogDto" property="nodeType" value="claim">
          <%
               afterDay=0;   //����ʱ���
               afterHour=0;
               if (nodeStatus.equals("0"))
               {
               afterDay=DateTime.intervalDay(new DateTime(swfLogDto.getFlowInTime(),DateTime.YEAR_TO_DAY),swfLogDto.getTimeLimit(),new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY) ,DateTime.current().getHour() ) ;
               //-1����Ϊ�������һ�죬�ǰ���һ�����ģ���Ϊ��Ҫ����Сʱ�����Ծ�Ӧ�ü�Ϊ0���
               afterHour=(afterDay-1)*24 - swfLogDto.getTimeLimit()+DateTime.current().getHour();

               //ʣ��ʱ�����
               afterHour=claimLimit-afterHour;
               %>
               <td align="center"><%=afterHour%></td>
               <%
               }

           %>
           </logic:equal>

        <%//д����������%>
        <td align="center"><bean:write name="swfLogList1" property="handlerName"/></td>
        <%//д����ʱ�����Ϣ%>
         <td align="center">
         <%
          if (nodeStatus.equals("4")){%>
           <bean:write name='swfLogList1' property='submitTime'/>
          <% } else {
           %>
             <bean:write name='swfLogList1' property='handleTime'/>

          <% }
          //modify by lixiang remark 20050309 end  %>
          <%//����Ϊÿ�������е����ݵľ�����Ϣ%>
          <input name=flowID type="hidden"  value=<bean:write name="swfLogList1" property="flowID"/>>
          <input name=logNo  type="hidden"  value=<bean:write name="swfLogList1" property="logNo"/>>
          <input name=keyIN  type="hidden"  value=<bean:write name="swfLogList1" property="keyIn"/>>
       </td>
         <logic:equal name="swfLogDto" property="nodeType" value="commo">
              <td align="center"><bean:write name="swfLogList1" property="nodeTypeName"/></td>
           </logic:equal>
<%
       if (nodeStatus.equals("0")){ %>
        <td align="center">
<%           // ���������᰸���ܻ���,Ŀǰֻ�������Ѿ�����Ļ�������
             //��Щ�����ܻ��˵�
             if (swfLogDto.getNodeStatus().equals("3")||swfLogDto.getNodeType().equals("claim")
                ||swfLogDto.getNodeType().equals("sched")||swfLogDto.getNodeType().equals("schel")
                ||swfLogDto.getNodeType().equals("backv")||swfLogDto.getNodeType().equals("check")
                ||swfLogDto.getNodeType().equals("certa")||swfLogDto.getNodeType().equals("wound")
                ||swfLogDto.getNodeType().equals("backc")||swfLogDto.getNodeType().equals("speci")){  %>
            <a href="<%=dealHref%>"><img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"	hspace="5"  alt="ѡ����"></a>&nbsp;
<%}          else {        %>
<%
           if (intriskcode==7){}else{
           %>
            <a href="<%=dealHref%>"><img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"	hspace="5"  alt="ѡ����"></a><input type="image" name=buttonDistribute num=<%=strindex%> src="/claim/images/butReturn.gif" border="0"	hspace="0"  alt="���˴���" onclick="return backStepWorkFlow(this);">
           <%
            } } %>
        </td>
        <%}
        //��ʾע������Ĵ���ť

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("cancelApply")){
          %>
           <td align="center"><a href="<%=dealHref%>"><img name=buttonDistribute  src="/claim/images/butCancel.gif" border="0"	hspace="5"   alt="ע��/���� "></a>&nbsp;</td>
<%
          }
        //��ʾ�����ⰸ����Ĵ���ť
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;

          %>
           <td align="center"><a href="<%=dealHref%>" border="0"	hspace="5"   alt="Ԥ�ⰸ���� ">����</a>&nbsp;</td>
<% 
          }
          if (nodeStatus.equals("4") && !nodeType.equals("sched")&& !nodeType.equals("claim")){
%>
<%//modify by liujianbo modify 20051107 start
  //reason:����Ӧ�÷�����ջء����ܡ�
%>
           <td align="center"><a href="/claim/processWorkflow.do?editType=recycle&flowID=<bean:write name="swfLogList1" property="flowID"/>&logNo=<bean:write name="swfLogList1" property="logNo"/>">�ջ�</a>&nbsp;</td>
<%
          }          
%> 
<%//modify by liujianbo modify 20051107 end
%>
    </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
     