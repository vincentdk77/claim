<%@page language="java" import="java.util.*" contentType="text/html; charset=GBK"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=8" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
        <title>OCR��Ϣ¼��ҳ��</title>
        <link href="/claim/css/StandardCar.css" rel="stylesheet" type="text/css">
        <!-- <link href="/claim/css/number.css" rel="stylesheet" type="text/css"> -->
        <script src="/claim/common/js/jquery-1.4.2.min.js"></script>
        <script src="/claim/DAA/payment/Math.uuid.js"></script>
        <script language="javascript" type="text/javascript">
		        var DeviceMain;//��ͷ
		        var DeviceAssist;//��ͷ
		        var VideoMain;//��ͷ
		        var VideoAssist;//��ͷ
				var videoCapMain;
				var videoCapAssist;	
				
		        var PicPath;
				var initFaceDetectSuccess;
				var readIDcard = false;
				
		        function plugin()
                {
                    return document.getElementById('view1');
                }
	
                function MainView()
                {
                    return document.getElementById('view1');
                }
        
		        function AssistView()
                {
                    return document.getElementById('view2');
                }
		
		        function thumb1()
                {
                    return document.getElementById('thumb1');
                }
		
		        function addEvent(obj, name, func)
                {
                    if (obj.attachEvent) {
                        obj.attachEvent("on"+name, func);
                    } else {
                        obj.addEventListener(name, func, false); 
                    }
                }
		        function OpenVideo()
		        {
					
		            OpenVideoMain();
			        OpenVideoAssist();
		        }
		        function CloseVideo()
		        {
		            CloseVideoMain();
			        CloseVideoAssist();
		        }
		        function CloseVideoMain()
		        {
		            if (VideoMain)
			        {
				        plugin().Video_Release(VideoMain);
				        VideoMain = null;
				
					    MainView().View_SetText("", 0);
			        }			
		        }
		        function CloseVideoAssist()
		        {
			        if (VideoAssist)
			        {
				        plugin().Video_Release(VideoAssist);
				        VideoAssist = null;

				        AssistView().View_SetText("", 0);
			        }
		        }
		
		        function OpenVideoMain()
		        {
		            CloseVideoMain();

		            if (!DeviceMain)
		                return;
			
			        var sSubType = document.getElementById('subType1'); 								
			        var sResolution = document.getElementById('selRes1'); 	
				
			        var SelectType = 0;
			        var txt;
			        if(sSubType.options.selectedIndex != -1)
			        {
				        txt = sSubType.options[sSubType.options.selectedIndex].text;
				        if(txt == "YUY2")
				        {
					        SelectType = 1;
				        }
				        else if(txt == "MJPG")
				        {
					        SelectType = 2;
				        }
				        else if(txt == "UYVY")
				        {
					        SelectType = 4;
				        }
			        }
			
			        var nResolution = sResolution.selectedIndex;
							
			        VideoMain = plugin().Device_CreateVideo(DeviceMain, nResolution, SelectType);
			        if (VideoMain)
			        {
					    MainView().View_SelectVideo(VideoMain);
					    MainView().View_SetText("����Ƶ�У���ȴ�...", 0);
							
			        }
		        }

		        function OpenVideoAssist()
		        {
		            CloseVideoAssist();

		            if (!DeviceAssist)
		                return;
			
			        var sSubType = document.getElementById('subType2'); 								
			        var sResolution = document.getElementById('selRes2'); 	
				
			        var SelectType = 0;
			        var txt;
			        if(sSubType.options.selectedIndex != -1)
			        {
				        txt = sSubType.options[sSubType.options.selectedIndex].text;
				        if(txt == "YUY2")
				        {
					        SelectType = 1;
				        }
				        else if(txt == "MJPG")
				        {
					        SelectType = 2;
				        }
				        else if(txt == "UYVY")
				        {
					        SelectType = 4;
				        }
			        }
			
			        var nResolution = sResolution.selectedIndex;
							
			        VideoAssist = plugin().Device_CreateVideo(DeviceAssist, nResolution, SelectType);
			        if (VideoAssist)
			        {
					    AssistView().View_SelectVideo(VideoAssist);
					    AssistView().View_SetText("����Ƶ�У���ȴ�...", 0);													    							
			        }	
		        }
		
		        function changesubTypeMain()
		        {
			        if (DeviceMain)
			        {	
				        var sSubType = document.getElementById('subType1'); 								
				        var sResolution = document.getElementById('selRes1'); 	
				        var SelectType = 0;
				        var txt;
				        if(sSubType.options.selectedIndex != -1)
				        {
					        var txt = sSubType.options[sSubType.options.selectedIndex].text;
					        if(txt == "YUY2")
					        {
						        SelectType = 1;
					        }
					        else if(txt == "MJPG")
					        {
						        SelectType = 2;
					        }
					        else if(txt == "UYVY")
					        {
						        SelectType = 4;
					        }
				        }
									
				        var nResolution = plugin().Device_GetResolutionCountEx(DeviceMain, SelectType);
				        sResolution.options.length = 0; 
				        for(var i = 0; i < nResolution; i++)
				        {
					        var width = plugin().Device_GetResolutionWidthEx(DeviceMain, SelectType, i);
					        var heigth = plugin().Device_GetResolutionHeightEx(DeviceMain, SelectType, i);
					        sResolution.add(new Option(width.toString() + "*" + heigth.toString())); 
				        }
				        sResolution.selectedIndex = 0;
			        }			
		        }

		        function changesubTypeAssist()
		        {
			        if (DeviceAssist)
			        {	
				        var sSubType = document.getElementById('subType2'); 								
				        var sResolution = document.getElementById('selRes2'); 	
				
				        var SelectType = 0;
				        var txt;
				        if(sSubType.options.selectedIndex != -1)
				        {
					        var txt = sSubType.options[sSubType.options.selectedIndex].text;
					        if(txt == "YUY2")
					        {
						        SelectType = 1;
					        }
					        else if(txt == "MJPG")
					        {
						        SelectType = 2;
					        }
					        else if(txt == "UYVY")
					        {
						        SelectType = 4;
					        }
				        }			
				
				        var nResolution = plugin().Device_GetResolutionCountEx(DeviceAssist, SelectType);
				        sResolution.options.length = 0; 
				        for(var i = 0; i < nResolution; i++)
				        {
					        var width = plugin().Device_GetResolutionWidthEx(DeviceAssist, SelectType, i);
					        var heigth = plugin().Device_GetResolutionHeightEx(DeviceAssist, SelectType, i);
					        sResolution.add(new Option(width.toString() + "*" + heigth.toString())); 
				        }
				        sResolution.selectedIndex = 0;
			        }			
		        }	
		
                function Load()
                {
			        //�豸����Ͷ�ʧ
			        //type�豸���ͣ� 1 ��ʾ��Ƶ�豸�� 2 ��ʾ��Ƶ�豸
			        //idx�豸����
			        //dbt 1 ��ʾ�豸��� 2 ��ʾ�豸��ʧ
			        
			        
                    addEvent(plugin(), 'DevChange', function (type, idx, dbt) 
					{
						if(1 == type)//��Ƶ�豸
						{
							if(1 == dbt)//�豸����
							{
								var deviceType = plugin().Global_GetEloamType(1, idx);
								if(1 == deviceType)//������ͷ
								{
									if(null == DeviceMain)
									{
										DeviceMain = plugin().Global_CreateDevice(1, idx);										
										if(DeviceMain)
										{
											document.getElementById('lab1').innerHTML = plugin().Device_GetFriendlyName(DeviceMain);
											
											var sSubType = document.getElementById('subType1');
											sSubType.options.length = 0;
											var subType = plugin().Device_GetSubtype(DeviceMain);
											if (subType & 1) 
											{
												sSubType.add(new Option("YUY2"));
											}
											if (subType & 2) 
											{
												sSubType.add(new Option("MJPG"));
											}
											if (subType & 4) 
											{
												sSubType.add(new Option("UYVY"));
											}
											
											sSubType.selectedIndex = 0;
											changesubTypeMain();
											
											OpenVideoMain();
										}
									}
								}
								else if(2 == deviceType || 3 == deviceType)//������ͷ
								{
									if(null == DeviceAssist)
									{
										DeviceAssist = plugin().Global_CreateDevice(1, idx);										
										if(DeviceAssist)
										{
											document.getElementById('lab2').innerHTML = plugin().Device_GetFriendlyName(DeviceAssist);
											
											var sSubType = document.getElementById('subType2');
											sSubType.options.length = 0;
											var subType = plugin().Device_GetSubtype(DeviceAssist);
											if (subType & 1) 
											{
												sSubType.add(new Option("YUY2"));
											}
											if (subType & 2) 
											{
												sSubType.add(new Option("MJPG"));
											}
											if (subType & 4) 
											{
												sSubType.add(new Option("UYVY"));
											}
											if ((0 != (subType & 2)) && (0 != (subType & 1)))//������ͷ���Ȳ���mjpgģʽ�� 
											{
												sSubType.selectedIndex = 1;
											}
											else 
											{
												sSubType.selectedIndex = 0;
											}
											initFaceDetectSuccess = plugin().InitFaceDetect();
											
											changesubTypeAssist();
											
											OpenVideoAssist();
										}
									}
								}
							}
							else if(2 == dbt)//�豸��ʧ
							{
								if (DeviceMain) 
								{
                                    if (plugin().Device_GetIndex(DeviceMain) == idx) 
									{
                                        CloseVideoMain();
                                        plugin().Device_Release(DeviceMain);
                                        DeviceMain = null;
										
										document.getElementById('lab1').innerHTML = "";
										document.getElementById('subType1').options.length = 0; 
										document.getElementById('selRes1').options.length = 0; 
                                    }
                                }
								
                                if (DeviceAssist) 
								{
                                    if (plugin().Device_GetIndex(DeviceAssist) == idx) 
									{
                                        CloseVideoAssist();
                                        plugin().Device_Release(DeviceAssist);
                                        DeviceAssist = null;
										
										document.getElementById('lab2').innerHTML = "";
										document.getElementById('subType2').options.length = 0; 
										document.getElementById('selRes2').options.length = 0; 
                                    }
                                }
							}
						}
                    });

			        addEvent(plugin(), 'Ocr', function(flag, ret)
			        {
				        if (1 == flag && 0 == ret)
				        {
					        var ret = plugin().Global_GetOcrPlainText(0);
					        alert(ret);
				        }
			        });
			
			        addEvent(plugin(), 'IdCard', function(ret)
			        {
				        if (1 == ret)
				        {
					        var str = GetTimeString() + "��";
					
					        for(var i = 0; i < 16; i++)
					        {
						        str += plugin().Global_GetIdCardData(i + 1);
						        str += ";";				
					        }
				
					        document.getElementById("idcard").value=str;	
							
							var image = plugin().Global_GetIdCardImage(1);//1��ʾͷ�� 2��ʾ���棬 3��ʾ���� ...
							plugin().Image_Save(image, "C:\\idcard.jpg", 0);
							plugin().Image_Release(image);
							
							document.getElementById("idcardimg").src= "C:\\idcard.jpg";
				        }
			        });
			
			        addEvent(plugin(), 'Biokey', function(ret)
			        {
				        if (4 == ret)
				        {
					        // �ɼ�ģ��ɹ�
					        var mem = plugin().Global_GetBiokeyTemplateData();
					        if (mem)
					        {
						        if (plugin().Memory_Save(mem, "C:\\1.tmp"))
						        {
							        document.getElementById("biokey").value="��ȡģ��ɹ����洢·��ΪC:\\1.tmp";
						        }						
						        plugin().Memory_Release(mem);
					        }
					
					        var img = plugin().Global_GetBiokeyImage();
					        plugin().Image_Save(img, "C:\\BiokeyImg1.jpg", 0);
					        plugin().Image_Release(img);
					
					        document.getElementById("BiokeyImg1").src= "C:\\BiokeyImg1.jpg";					
					        alert("��ȡָ��ģ��ɹ�");
				        }
				        else if (8 == ret)
				        {
					        var mem = plugin().Global_GetBiokeyFeatureData();
					        if (mem)
					        {
						        if (plugin().Memory_Save(mem, "C:\\2.tmp"))
						        {
							        document.getElementById("biokey").value="��ȡ�����ɹ����洢·��ΪC:\\2.tmp";
						        }						
						        plugin().Memory_Release(mem);
					        }
					
					        var img = plugin().Global_GetBiokeyImage();
					        plugin().Image_Save(img, "C:\\BiokeyImg2.jpg", 0);
					        plugin().Image_Release(img);
					
					        document.getElementById("BiokeyImg2").src= "C:\\BiokeyImg2.jpg";
					        alert("��ȡָ�������ɹ�");
				        }
				        else if (9 == ret)
				        {
					        document.getElementById("biokey").value += "\r\nˢ�Ĳ���";
				        }
				        else if (10 == ret)
				        {
					        document.getElementById("biokey").value+= "\r\nͼ������̫�";
				        }
				        else if (11 == ret)
				        {
					        document.getElementById("biokey").value+= "\r\nͼ�����̫�٣�";
				        }
				        else if (12 == ret)
				        {
					        document.getElementById("biokey").value+= "\r\n̫�죡";
				        }
				        else if (13 == ret)
				        {
					        document.getElementById("biokey").value+= "\r\n̫����";
				        }
				        else if (14 == ret)
				        {
					        document.getElementById("biokey").value+= "\r\n�����������⣡";
				        }				
			        });
			
			        addEvent(plugin(), 'Reader', function(type, subtype)
			        {
				        var str = "";
				        if (4 == type)
				        {
							if( 0 == subtype)//�Ӵ�ʽCPU��
							{
								str += "[�Ӵ�ʽCPU��][���п���]:";
								str += plugin().Global_ReaderGetCpuCreditCardNumber();
							}
							else if( 1 == subtype)//�ǽӴ�ʽCPU��
							{
								str += "[�ǽӴ�ʽCPU��] :";
								str += "[Id]:";
								str += plugin().Global_ReaderGetCpuId();
								str += "[���п���]:";
								str += plugin().Global_ReaderGetCpuCreditCardNumber();
								
								str += "[�ŵ�����]:";
								str += plugin().Global_CpuGetBankCardTrack();//�ŵ�����
								
								str += "[���׼�¼]:";
								var n = plugin().Global_CpuGetRecordNumber();//��������
								for(var i = 0; i < n; i++)
								{
									str += plugin().Global_CpuGetankCardRecord(i);
									str + ";";
								}			
							}							
						}
				        else if (2 == type)
				        {
					        str += "[M1��] Id:";
					        str += plugin().Global_ReaderGetM1Id();
				        }
				        else if (3 == type)
				        {
					        str += "[Memory��] Id:";
					        str += plugin().Global_ReaderGetMemoryId();	
				        }
				        else if (5 == type)
				        {
					        str += "[�籣��] :";
					        str += plugin().Global_ReaderGetSocialData(1);
					        str += plugin().Global_ReaderGetSocialData(2);
				        }
				        document.getElementById("reader").value=str;
			        });
			
			        addEvent(plugin(), 'Mag', function(ret)
			        {
				        var str = "";
				
				        str += "[�ſ�����] ";
				        str += plugin().Global_MagneticCardGetNumber();
				
				        str += "[�ŵ�����]";		

				        str += "�ŵ�1:";					
				        str += plugin(). Global_MagneticCardGetData(0);	
				        str += "�ŵ�2:";
				        str += plugin(). Global_MagneticCardGetData(1);	
				        str += "�ŵ�3:";
				        str += plugin(). Global_MagneticCardGetData(2);	
				
				        document.getElementById("mag").value=str;
			        });
			
			        addEvent(plugin(), 'ShenZhenTong', function(ret)
			        {
				        var str = "";
				
				        str += "[����ͨ����] ";
				        str += plugin().Global_GetShenZhenTongNumber();
						
						str += "[���:] ";
				        str += plugin().Global_GetShenZhenTongAmount();
				
				        str += "[���׼�¼:]";

						var n = plugin().Global_GetShenZhenTongCardRecordNumber();
						for(var i = 0; i < n ; i++)
						{			
							str += plugin().Global_GetShenZhenTongCardRecord( i);	
							str += ";";	
						}			
				        document.getElementById("shenzhentong").value=str;
			        });			
			
			        addEvent(plugin(), 'MoveDetec', function(video, id)
			        {
				        // �Զ������¼�	
			        });
			
			        addEvent(plugin(), 'Deskew', function(video, view, list)
			        {
				        // ��ƫ�ص��¼�
				        var count = plugin().RegionList_GetCount(list);				
				        for (var i = 0; i < count; ++i)
				        {				
					        var region = plugin().RegionList_GetRegion(list, i);
					
					        var x1 = plugin().Region_GetX1(region);
					        var y1 = plugin().Region_GetY1(region);
					
					        var width = plugin().Region_GetWidth(region);
					        var height = plugin().Region_GetHeight(region);
					
					        plugin().Region_Release(region);
				        }
				
				        plugin().RegionList_Release(list);
			        });
				
			        var title = document.title;
			        document.title = title + plugin().version;
				
			        MainView().Global_SetWindowName("view");
			        AssistView().Global_SetWindowName("view");
			        thumb1().Global_SetWindowName("thumb");
		
			        var ret;
					ret = plugin().Global_InitDevs();
					if(ret)
					{
						//��������ʶ���ʼ��ʱ����ƵӦ���ڹر�״̬
						 plugin().InitFaceDetect();
					}
					
					if( !plugin().Global_VideoCapInit())
					{
						alert("��ʼ��ʧ�ܣ�");
					}
                }
		
		        function Unload()
		        {
			        if (VideoMain)
			        {
				        MainView().View_SetText("", 0);
				        plugin().Video_Release(VideoMain);
				        VideoMain = null;
			        }
			        if(DeviceMain)
			        {
				        plugin().Device_Release(DeviceMain);
				        DeviceMain = null;		
			        }
			        if (VideoAssist)
			        {
				        AssistView().View_SetText("", 0);
				        plugin().Video_Release(VideoAssist);
				        VideoAssist = null;
			        }
			        if(DeviceAssist)
			        {
				        plugin().Device_Release(DeviceAssist);
				        DeviceAssist = null;		
			        }			
			
			        StopICCard();
					StopMagCard();
					StopShenZhenTongCard();
					StopIDCard();
			
			        plugin().Global_DeinitDevs();
					
					//��������ʶ�𷴳�ʼ��ʱ����ƵӦ���ڹر�״̬
					plugin().DeinitFaceDetect();
		        }
		        function EnableDate(obj)
		        {
			        if (obj.checked)
			        {
				        var offsetx = 1000;
				        var offsety = 60;
				
				        var font;
				        font = plugin().Global_CreateTypeface(50, 50, 0, 0, 2, 0, 0, 0, "����");
				
				        if (VideoMain)
				        {
					        var width = plugin().Video_GetWidth(VideoMain);
					        var heigth = plugin().Video_GetHeight(VideoMain);
					
					        plugin().Video_EnableDate(VideoMain, font, width - offsetx, heigth - offsety, 0xffffff, 0);
				        }
				        if (VideoAssist)
				        {
					        var width = plugin().Video_GetWidth(VideoAssist);
					        var heigth = plugin().Video_GetHeight(VideoAssist);	
					
					        plugin().Video_EnableDate(VideoAssist, font, width - offsetx, heigth - offsety, 0xffffff, 0);
				        }
				        plugin().Font_Release(font);
			        }
			        else
			        {
				        if(VideoMain)
				        {
					        plugin().Video_DisableDate(VideoMain);
				        }
				        if(VideoAssist)
				        {
					        plugin().Video_DisableDate(VideoAssist);
				        }
			        }
		        }
		
		        function AddText(obj)
		        {
			        if (obj.checked)
			        {			
				        var font;
				        font = plugin().Global_CreateTypeface(200, 200, 0, 0, 2, 0, 0, 0, "����");
				
				        if (VideoMain)
				        {				
					        plugin().Video_EnableAddText(VideoMain, font, 0, 0, "����ˮӡ", 65280, 150);
				        }
				        if (VideoAssist)
				        {
					        plugin().Video_EnableAddText(VideoAssist, font, 0, 0, "����ˮӡ", 65280, 150);
				        }
				        plugin().Font_Release(font);
			        }
			        else
			        {
				        if(VideoMain)
				        {
					        plugin().Video_DisableAddText(VideoMain);
				        }
				        if(VideoAssist)
				        {
					        plugin().Video_DisableAddText(VideoAssist);
				        }
			        }		
		        }
		
		        function ShowProperty()
		        {
			        if(DeviceMain)
			        {
				        plugin().Device_ShowProperty(DeviceMain, MainView().View_GetObject());
			        }
		        }
		
		        function Deskew(obj)
		        {
			        if (obj.checked)
			        {
				        if(VideoMain)
				        {
					        plugin().Video_EnableDeskewEx(VideoMain, 1);
				        }
				        if(VideoAssist)
				        {
					        plugin().Video_EnableDeskewEx(VideoAssist, 1);
				        }
			        }
			        else
			        {
				        if(VideoMain)
				        {
					        plugin().Video_DisableDeskew(VideoMain);
				        }
				        if(VideoAssist)
				        {
					        plugin().Video_DisableDeskew(VideoAssist);	
				        }		
			        }
		        }
		
		        function SetState(obj)
		        {
					if (obj.checked)
					{
						MainView().View_SetState(2);
						document.getElementById('scansize').disabled="disabled"; 
					}
					else
					{
						MainView().View_SetState(1);
						document.getElementById('scansize').disabled=""; 
					}
		        }
				function OpenVerifyFacRect(obj)
				{
					if(!initFaceDetectSuccess)
					{
						alert("������ʼ��ʧ�ܣ����Ͳ�֧�֣�");
						obj.checked = false;
					}
					else
					{
						if (VideoMain)
						{
							if (obj.checked)
								plugin().Global_EnableFaceRectCrop(VideoMain, 1);
							else
								plugin().Global_DisableFaceRectCrop(VideoMain);
						}
						if (VideoAssist)
						{
							if (obj.checked)
								plugin().Global_EnableFaceRectCrop(VideoAssist, 1);
							else
								plugin().Global_DisableFaceRectCrop(VideoAssist);
						}
					}
				}
				function changescansize()
				{
					var rect;
					var width =  plugin().Video_GetWidth(VideoMain);
					var heigth =  plugin().Video_GetHeight(VideoMain);	
					
					var s = document.getElementById('scansize'); 									
					var size = s.options.selectedIndex;
					
					 if(size == 0)
					{
						MainView().View_SetState(1);//ȡ����ѡ ״̬											
					}
					else if(size == 1)
					{
						rect = plugin().Global_CreateRect(width/2 - width/4, heigth/2 - heigth/4, width/2, heigth/2);
						MainView().View_SetState(2);//С�ߴ�
						MainView().View_SetSelectedRect(rect);						

					}
					 else if(size == 2)
					{
						rect = plugin().Global_CreateRect(width/2 - width/6, heigth/2 - heigth/6, width/3, heigth/3);
						MainView().View_SetState(2);//�гߴ�
						MainView().View_SetSelectedRect(rect);						
					} 
					
					if(size != 0)
					{
						document.getElementById('SetState').checked = false; 
						document.getElementById('SetState').disabled="disabled"; 
					}
					else
					{
						document.getElementById('SetState').disabled = ""
					}
				}
		
		        function Left()
		        {
			        if(VideoMain)
			        {
				        plugin().Video_RotateLeft(VideoMain);
			        }
			        if(VideoAssist)
			        {
				        plugin().Video_RotateLeft(VideoAssist);	
			        }	

		        }
		
		        function Right()
		        {
			        if(VideoMain)
			        {
				        plugin().Video_RotateRight(VideoMain);
			        }
			        if(VideoAssist)
			        {
				        plugin().Video_RotateRight(VideoAssist);		
			        }	

		        }
		
				function GetTimeString()
				{
					var date = new Date();
					var yy = date.getFullYear().toString();
					var mm = (date.getMonth() + 1).toString();
					var dd = date.getDate().toString();
					var hh = date.getHours().toString();
					var nn = date.getMinutes().toString();
					var ss = date.getSeconds().toString();
					var mi = date.getMilliseconds().toString();
					
					var ret = yy + mm + dd + hh + nn + ss + mi;
					return ret;
				}
		
                //����
		        function Scan()
		        {
		        var size=document.getElementById("scansize").value;
		        if(size!="small"){
		        var flag = confirm("ѡ��ǰ�ߴ���Ƭ���ܲ���ʶ��,��ѡ��ɨ��ߴ�ΪС.�Ƿ����ʹ�õ�ǰ�ߴ�����?");
		        if(flag==false){
		        return;
		        }
		        }
		            if (VideoMain) 
                    {
		                var imgList = plugin().Video_CreateImageList(VideoMain, 0, 0);
		                if (imgList) {
		                    var len = plugin().ImageList_GetCount(imgList);
		                    for (var i = 0; i < len; i++) {
		                        var img = plugin().ImageList_GetImage(imgList, i);
		                        var Name = "d:\\card.jpg";
		                        var b = plugin().Image_Save(img, Name, 0);
		                        if (b) {
		                            MainView().View_PlayCaptureEffect();
		                            thumb1().Thumbnail_Add(Name);

		                            PicPath = Name;
		                        }

		                        plugin().Image_Release(img);
		                    }

		                    plugin().ImageList_Release(imgList);
		                }
		            }

		           /*   if (VideoAssist) 
                    {
		                var imgList2 = plugin().Video_CreateImageList(VideoAssist, 0, 0);
		                if (imgList2) {
		                    var len = plugin().ImageList_GetCount(imgList2);
		                    for (var i = 0; i < len; i++) {
		                        var img = plugin().ImageList_GetImage(imgList2, i);
		                        var Name = "C:\\" + GetTimeString() + ".jpg";
		                        var b = plugin().Image_Save(img, Name, 0);
		                        if (b) {
		                            AssistView().View_PlayCaptureEffect();
		                            thumb1().Thumbnail_Add(Name);
		                        }

		                        plugin().Image_Release(img);
		                    }

		                    plugin().ImageList_Release(imgList2);
		                }
		            }  */
		        }
		
			
		        function OCR()
		        {
			        if (PicPath)
			        {
				        plugin().Global_InitOcr();
				
				        var img;
				        img = plugin().Global_CreateImageFromFile(PicPath, 0);
				        plugin().Global_DiscernOcr(1, img);
				        var b = plugin().Global_WaitOcrDiscern();
				        if (b)
				        {
					        alert(plugin().Global_GetOcrPlainText(0));
					        plugin().Global_SaveOcr("C:\\1.doc", 0);
				        }
				
				        plugin().Global_DeinitOcr();
				
				        plugin().Image_Release(img);
			        }	
			        else
			        {
				        alert("�������գ�");
			        }
		        }
				function getFullPath(obj){
				if(obj){
					if(window.navigator.userAgent.indexOf("MSIE")>=1){
					obj.select();
					obj.blur();
					return document.selection.createRange().text;
					}
				}
				}
				
		        function UploadToHttpServer()
		        {
		        	
		        	var upfile=document.getElementById("upfile");
		        	var copyfile=document.getElementById("copyfile").value=getFullPath(upfile);
					var url = document.getElementById("url").value;
			        //var http = plugin().Global_CreateHttp("http://192.168.1.56:80/upload.asp");//asp������demo��ַ
			        var http = plugin().Global_CreateHttp(url);//java������demo��ַ
			        if (http)
			        {
			        	
			        	var uuid = Math.uuid();
					    var name=uuid+".jpg";
					    document.getElementById("cardurl").value = name;
				        var b = plugin().Http_UploadImageFile(http, copyfile, name);
				        if (b)
				        {
					        alert("�ϴ��ɹ�");
				        }
				        else
				        {
					        alert("�ϴ�ʧ��");
				        }
				
				        plugin().Http_Release(http);
			        }
			        else
			        {
				        alert("url ����");
			        }
			        upfile.outerHTML=upfile.outerHTML;
			        document.getElementById("2").disabled=false;
			        document.getElementById("8").value="";
			        document.getElementById("9").value="";
			        document.getElementById("10").value="";
		        }
				function UploadThumbToServer()
				{
					var http =thumb1().Thumbnail_HttpUploadCheckImage("http://192.168.1.56:8080/FileStreamDemo/servlet/FileSteamUpload?",0);
					if(http)
					{
						var htInfo = thumb1().Thumbnail_GetHttpServerInfo();
						alert(htInfo);
					}
					else
					{
						alert("�ϴ�ʧ�ܣ�");
					}
				}
		        function ScanToHttpServer()
		        {
		        	var size=document.getElementById("scansize").value;
			        if(size!="mid"){
			        var flag = confirm("���֤����ѡ��ǰ�ߴ���Ƭ���ܲ���ʶ��,��ѡ��ɨ��ߴ�Ϊ��,Ӫҵִ���������������!");
			        if(flag==false){
				        return;
				        }
			        }
			        if(VideoMain)
			        {
				        var img = plugin().Video_CreateImage(VideoMain, 0, MainView().View_GetObject());
				        if (img)
				        {
				        	var url = document.getElementById("url").value;
					        //var http = plugin().Global_CreateHttp("http://192.168.1.193:8080/upload.asp");//asp������demo��ַ
					        var http = plugin().Global_CreateHttp(url);//java������demo��ַ
					        if (http)
					        {
					        	var uuid = Math.uuid();
					        	var name=uuid+".jpg";
					        	document.getElementById("cardurl").value = name;
						        var b = plugin().Http_UploadImage(http, img, 2, 0, name );
						        if (b)
						        {
							        alert("�ϴ��ɹ�");
						        }
						        else
						        {
							        alert("�ϴ�ʧ��");
						        }
						
						        plugin().Http_Release(http);
					        }

					        plugin().Image_Release(img);
				        }
			        }
			        document.getElementById("2").disabled=false;
			        document.getElementById("8").value="";
			        document.getElementById("9").value="";
			        document.getElementById("10").value="";
		        }
		        
		        
				function RGB(r, g, b)
				{
					return r | g<<8 | b<<16;
				}
				
				/******************¼��********************/
		        function StartMainRecord()
		        {
					if(VideoMain)
					{
						var videoOutputWidth = plugin().Video_GetWidth(VideoMain);
						var videoOutputHeight = plugin().Video_GetHeight(VideoMain);
						//¼��ʱ������Ƶ�ķֱ���Խ�ͣ�֡��Խ��,һ�㲻����200w����
						//�����õ�֡��Ӧ�����ܸ���ʵ��֡�ʣ����ⶪ֡
						var FrameRate = 15;//�˲����ɸ���¼��ֱ��������ʵ��֡�ʵ���
						var CheckWidth = 1600;
						var CheckHeight = 1200;
						//������Ƶ�ֱ������д���200��ģ����Ϊ��Լcpu��Դ�����ֱ��ʴ���200w��Ӧ����200w������¼��
						if (videoOutputWidth * videoOutputHeight > (CheckWidth * CheckHeight))
						{
							if(confirm("��ǰ�ֱ��ʹ��ߣ��л���200������ʱ��¼��Ч����ѣ�\r\n���'ȷ��'���ֶ��л���1600X1200������ֱ��ʺ��ٴγ���\r\n���'ȡ��'������¼�Ƽ���"))
							{
								return;
							}
							videoOutputWidth = CheckWidth;
							videoOutputHeight = CheckHeight;
						}
					
						if(	videoCapMain)
						{
							plugin().VideoCap_Stop(videoCapMain);
							plugin().VideoCap_Destroy(videoCapMain);
						}
						
						videoCapMain = plugin().Global_CreatVideoCap();
						if(null == videoCapMain)
						{
							alert("����¼�����ʧ��");
							return;
						}
						
						//����ˮӡ
						plugin().VideoCap_SetWatermark(videoCapMain, 1, 0, 0, 4, 100, 0, "����������Ƽ�", RGB(255,23,140), "Microsoft YaHei", 72, 50, 0);
						
						var selMicIdx = -1;
						if(plugin().Global_VideoCapGetAudioDevNum() > 0)//����˷�
						{
							selMicIdx = 0;
						}
						
						if(!plugin().VideoCap_PreCap(videoCapMain, "C:\\eloamPlugin_main.mp4", selMicIdx, FrameRate, 1, videoOutputWidth, videoOutputHeight))
						{
							alert("¼������ʧ��");
							return;
						}
						
						if(!plugin().VideoCap_AddVideoSrc(videoCapMain, VideoMain))
						{
							alert("�����ƵԴʧ��");
							return;
						}
						
						if(!plugin().VideoCap_Start(videoCapMain))
						{
							alert("����¼��ʧ��");
							return;
						}
						alert("�ѿ�ʼ¼��");
					}
		        }
		        function StopMainRecord()
		        {
					if(plugin().VideoCap_Stop(videoCapMain))
					{
						plugin().VideoCap_Destroy(videoCapMain);
						videoCapMain = null;
						alert("¼��������ļ�������C:\\eloamPlugin_main.mp4\r\n��¼��ʧ����ѡ���С�ķֱ��ʳ���");
					}
					else
					{
						alert("ֹͣ¼��ʧ��");
					}
		        }
				function StartAssistRecord()
		        {
					if(VideoAssist)
					{
						var videoOutputWidth = plugin().Video_GetWidth(VideoAssist);
						var videoOutputHeight = plugin().Video_GetHeight(VideoAssist);
						//¼��ʱ������Ƶ�ķֱ���Խ�ͣ�֡��Խ��,һ�㲻����200w����
						//�����õ�֡��Ӧ�����ܸ���ʵ��֡�ʣ����ⶪ֡
						var FrameRate = 15;//�˲����ɸ���¼��ֱ��������ʵ��֡�ʵ���
						var CheckWidth = 1600;
						var CheckHeight = 1200;
						//������Ƶ�ֱ������д���200��ģ����Ϊ��Լcpu��Դ�����ֱ��ʴ���200w��Ӧ����200w������¼��
						if (videoOutputWidth * videoOutputHeight > (CheckWidth * CheckHeight))
						{
							if(confirm("��ǰ�ֱ��ʹ��ߣ��л���200������ʱ��¼��Ч����ѣ�\r\n���'ȷ��'���ֶ��л���1600X1200������ֱ��ʺ��ٴγ���\r\n���'ȡ��'������¼�Ƽ���"))
							{
								return;
							}
							videoOutputWidth = CheckWidth;
							videoOutputHeight = CheckHeight;
						}
					
						if(	videoCapAssist)
						{
							plugin().VideoCap_Stop(videoCapAssist);
							plugin().VideoCap_Destroy(videoCapAssist);
						}
						
						videoCapAssist = plugin().Global_CreatVideoCap();					
						if(null == videoCapAssist)
						{
							alert("����¼�����ʧ��");
							return;
						}
						
						//����ˮӡ
						plugin().VideoCap_SetWatermark(videoCapAssist, 1, 0, 0, 1, 220, 0, "����������Ƽ�", RGB(255,23,140), "Microsoft YaHei", 72, 50, 0);
						
						var selMicIdx = -1;
						if(plugin().Global_VideoCapGetAudioDevNum() > 0)//����˷�
						{
							selMicIdx = 0;
						}
						
						if(!plugin().VideoCap_PreCap(videoCapAssist, "C:\\eloamPlugin_assist.mp4", selMicIdx, FrameRate, 1, videoOutputWidth, videoOutputHeight))
						{
							alert("����¼��ʧ��");
							return;
						}
						
						if(!plugin().VideoCap_AddVideoSrc(videoCapAssist, VideoAssist))
						{
							alert("�����ƵԴʧ��");
							return;
						}
						
						if(!plugin().VideoCap_Start(videoCapAssist))
						{
							alert("����¼��ʧ��");
							return;
						}
						alert("�ѿ�ʼ¼��");
					}
		        }
		        function StopAssistRecord()
		        {
					if(plugin().VideoCap_Stop(videoCapAssist))
					{
						plugin().VideoCap_Destroy(videoCapAssist);
						videoCapAssist = null;
						alert("¼��������ļ�������C:\\eloamPlugin_assist.mp4\r\n��¼��ʧ����ѡ���С�ķֱ��ʳ���");
					}
					else
					{
						alert("ֹͣ¼��ʧ��");
					}
		        }
				/******************¼��********************/
		        function GetImgMD5()
		        {		
			        if(PicPath)
			        {
				        var img;
				        img = plugin().Global_CreateImageFromFile(PicPath, 0);
				        var md5 = plugin().Image_GetMD5(img, 2, 0);
				        alert("ͼ���MD5ֵΪ��" + md5);
				
				        plugin().Image_Release(img);
			        }
			        else
			        {
				        alert("�������գ�");
			        }
		        }
        
		        function Barcode()
		        {
					if (DeviceMain)
					{
						if (VideoMain)
						{
							var imgList = plugin().Video_CreateImageList(VideoMain, 0, 0);
							if (imgList) 
							{
								plugin().Global_InitBarcode();
							
								var len = plugin().ImageList_GetCount(imgList);
								for (var i = 0; i < len; i++) 
								{
									var image = plugin().ImageList_GetImage(imgList, i);

									if (image)
									{
										var b = plugin().Global_DiscernBarcode(image);
										if (b)
										{
											if(plugin().Global_GetBarcodeCount() <= 0)
											{
												alert("ʶ��ʧ�ܣ�");
											}
											else
											{
												for(var i = 0 ; i < plugin().Global_GetBarcodeCount(); i++)
													alert(plugin().Global_GetBarcodeData(i));										
											}
										}						
									}
								}
								plugin().ImageList_Release(imgList);
								plugin().Global_DeinitBarcode();
							}
						}
					}
		        }
		
		
		        /******************ָ��ʶ��********************/
		        function InitBiokey()
		        {
			        if(!plugin().Global_InitBiokey())
			        {
				        alert("��ʼ��ָ��ʶ��ʧ�ܣ�");
			        }	
		        }
		        function DInitBiokey()
		        {
			        plugin().Global_DeinitBiokey();
		        }
		        function GetTemplate()
		        {
			        var b = plugin().Global_GetBiokeyTemplate();
			        if (b)
			        {
				        document.getElementById("BiokeyImg1").src= "";
				        document.getElementById("biokey").value="�밴ѹ��ָ�������ģ��ɼ���";
			        }
		        }
		
		        function StopGetTemplate()
		        {
			        var b = plugin().Global_StopGetBiokeyTemplate();
			        if (b)
			        {				
				        document.getElementById("biokey").value="��ֹͣ��ȡģ��";
			        }
		        }
		
		        function GetFeature()
		        {
			        var b = plugin().Global_GetBiokeyFeature();
			        if (b)
			        {
			        document.getElementById("BiokeyImg2").src= "";
				        document.getElementById("biokey").value="�밴ѹ��ָ";
			        }
		        }
		
		        function StopGetFeature()
		        {
			        var b = plugin().Global_StopGetBiokeyFeature();
			        if (b)
			        {
				        document.getElementById("biokey").value="��ֹͣ��ȡ����";
			        }
		        }
		
		        function BiokeyVerify()
		        {			
			        var mem1 = plugin().Global_CreateMemoryFromFile("C:\\1.tmp");			
			        var mem2 = plugin().Global_CreateMemoryFromFile("C:\\2.tmp");
			        if (mem1&&mem2)
			        {
				        // �Ƚ�
				        var ret = plugin().Global_BiokeyVerify(mem1, mem2);
				        if (ret > 50)
				        {
					        document.getElementById("biokey").value="ƥ��ɹ�" + ret.toString();
				        }
				        else
				        {
					        document.getElementById("biokey").value="ƥ��ʧ��" + ret.toString();
				        }
				        plugin().Memory_Release(mem1);
				        plugin().Memory_Release(mem2);
			        }
			        else
			        {
				        alert("��ɼ���ָ��ģ���ָ���������ٱȶԣ�");
			        }
		        }
		        /******************����֤�Ķ���********************/
		         function StartIDCard()
		        {					
					if(plugin().Global_InitIdCard())
					{
						if(plugin().Global_DiscernIdCard())
						{
							alert("��ˢ����");
							readIDcard = true;
						}
						else
						{
							document.getElementById("idcard").value= "��������֤�Ķ�ʧ�ܣ�";
						}
					}
					else
					{
						document.getElementById("idcard").value= "��ʼ������֤�Ķ���ʧ�ܣ�";
			        }
		        }
		        function StopIDCard()
		        {
			        plugin().Global_StopIdCardDiscern();
					plugin().Global_DeinitIdCard();
					readIDcard = false;
					
					document.getElementById("idcard").value= "��ֹͣ��";
		        }
				
				
				function ReadIDCard()
				{
					if(readIDcard)
					{
						alert("����ֹͣ����֤�Ķ�");
						return;
					}  
					if(plugin().Global_InitIdCard())
					{
					
						var ret = plugin().Global_ReadIdCard();
						if(ret)
						{
							var str = GetTimeString() + "��";
					
							for(var i = 0; i < 18; i++)
							{
								str += plugin().Global_GetIdCardData(i + 1);
								str += ";";				
							}						
							
							/* var image = plugin().Global_GetIdCardImage(1);//1��ʾͷ�� 2��ʾ���棬 3��ʾ���� ...
							plugin().Image_Save(image, "C:\\idcard.jpg", 0);
							plugin().Image_Release(image); */
							
							document.getElementById("idcardimg").src= "C:\\idcard.jpg";
							var arr=str.split("��");
							var a=arr[1].split(";");
							document.getElementById("8").value="�ڶ������֤";
							document.getElementById("9").value=a[7];
							document.getElementById("10").value=a[0];
							document.getElementById("11").value=a[1];
							document.getElementById("12").value=a[3]+"-"+a[4]+"-"+a[5];
							document.getElementById("13").value=a[6];
							document.getElementById("14").value=a[6];
						}
						else
						{
							document.getElementById("iddata").value= "��ȡ����֤ʧ�ܣ�";
						}
						
						plugin().Global_DeinitIdCard();
					}
					else
					{
				        alert("��ʼ������֤�Ķ���ʧ�ܣ�");
			        }
				}	
		        /******************IC���Ķ���********************/
		        function StartICCard()
		        {					
			        if(!plugin().Global_InitReader())
			        {
				        alert("��ʼ��IC���Ķ���ʧ�ܣ�");
				        return;
			        }
			        if(plugin().Global_ReaderStart())
			        {
				        alert("��ˢ����");
			        }
			        else
			        {
				        alert("����IC���Ķ�ʧ�ܣ�");
			        }
		        }
		        function StopICCard()
		        {
			        plugin().Global_ReaderStop();
			        plugin().Global_DeinitReader();
		        }
		        /******************�������Ķ���********************/
		        function StartMagCard()
		        {
			        if(!plugin().Global_InitMagneticCard())
			        {
				        alert("��ʼ���������Ķ���ʧ�ܣ�");
				        return;
			        }
			        if(plugin().Global_MagneticCardReaderStart())
			        {
				        alert("��ˢ����");
			        }
			        else
			        {
				        alert("���������Ķ�ʧ�ܣ�");
			        }		
		        }
		        function StopMagCard()
		        {
			        plugin().Global_MagneticCardReaderStop();
			        plugin().Global_DeinitMagneticCard();	
		        }
					        
				 /******************����ͨ���Ķ���********************/					
				function StartShenZhenTongCard()
		        {
					if(!plugin().Global_InitShenZhenTong())
			        {
				        alert("��ʼ������ͨ���Ķ���ʧ�ܣ�");
				        return;
			        }
			        if(plugin().Global_StartShenZhenTongCard())
			        {
				        alert("��ˢ����");
			        }
			        else
			        {
				        alert("��������ͨ���Ķ�ʧ�ܣ�");
			        }		
		        }			        
				
				function StopShenZhenTongCard()
		        {
			        plugin().Global_StopShenZhenTongCard();
			        plugin().Global_DeinitShenZhenTong();	
		        }
				/******************����ʶ��********************/
				function FaceDetect()
				{
					var image1 =  plugin().Global_CreateImageFromFile("C:\\1.jpg", 0);
					var image2 =  plugin().Global_CreateImageFromFile("C:\\2.jpg", 0);
					if(image1 && image2) 
					{
						var ret = plugin().DiscernFaceDetect(image1, image2);
						if(ret != -1)
						{
							ret += 20;
							if(ret > 100)
							{
								ret = 100;
							}
							var msg = "ʶ������ɣ�ƥ��ȣ�" + ret + "\r\n��ƥ����ֵΪ70��������ֵ��Ϊͬһ�ˣ�";
							alert(msg);
						}
						else
						{
							alert("ʶ��ʧ�ܣ�");
						}
					}
					else
					{
						alert("�Ҳ���ͼ��");
						return;
					}
					
					plugin().Image_Release(image1);
					plugin().Image_Release(image2);
				}
				
				function VerifyFaceDetect()
				{	
					if (VideoAssist)
					{		
						var image = plugin().Video_CreateImage(VideoAssist,0, AssistView().View_GetObject());
						var idcardImage = plugin().Global_CreateImageFromFile("C:\\idcard.jpg", 0);
						
						if(image && idcardImage) 
						{
							var ret = plugin().DiscernFaceDetect(image, idcardImage);
							if(ret != -1)
							{
								ret += 20;
								if(ret > 100)
								{
									ret = 100;
								}
								var msg = "ʶ������ɣ�ƥ��ȣ�" + ret + "\r\n��ƥ����ֵΪ70��������ֵ��Ϊͬһ�ˣ�";
								alert(msg);
							}
							else
							{
								alert("ʶ��ʧ�ܣ�");
							}
						}
						else
						{
							alert("��ȡͼ��ʧ�ܣ�δʶ�𵽶���֤��");
							return;
						}
						
						plugin().Image_Release(image);
						plugin().Image_Release(idcardImage);
					}
					
				}
				//ȥ�ո�
				function trimStr(str){
				return str.replace(/(^\s*)|(\s*$)/g,"");
				}
				//���п�ʶ��
				function fileUpload(){
					var fileName = document.getElementById("cardurl").value;
					$.ajax({
						url:'/claim/DAA/payment/IdCardData.jsp'
						,type:'POST'
						,dataType:"text"
						,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
						,data:{"fileName":fileName}
						,success:function(data){
						   if(trimStr(data)==""){
								alert("ʶ��ʧ��,�����������ϴ�!");
								return;
							}
							var arr=data.split(",");
							var arr1=arr[0].split(":");	
							var arr2=arr[1].split(":");
							var arr3=arr[2].split(":");
							document.getElementById("8").value=trimStr(arr1[1].replace(/\"/g,""));
							document.getElementById("9").value=trimStr(arr2[1].replace(/\"/g,""));
							document.getElementById("10").value=trimStr(arr3[1].replace(/\"/g,""));
							
						}
						,error:function(){alert('ϵͳ�쳣��');}
					});
				}
				
				function back(){
				var a=document.getElementById("8").value;
				window.opener.data8(a);
				var b=document.getElementById("9").value;
				window.opener.data9(b);
				var c=document.getElementById("10").value;
				window.opener.data10(c);
				window.close();
				}
<% 
     String url1 =  AppConfig.get("sysconst.UPLOADSEVISE_ADDRESS");
%>				
        </script>
    </head>

<body onload="Load()" onunload="Unload()">
<form name="fm" method="post" action="" enctype="multipart/form-data">
    <div align="center">
        <br/><object id="view1" style="display:" type="application/x-eloamplugin" width="1000" height="400" name="view"></object>
        <object style="display:none" id="view2" type="application/x-eloamplugin" width="600" height="300" name="view"></object>
    </div>

     <div align="center" style="display:none">
        <object id="thumb1" type="application/x-eloamplugin" width="1208" height="150" name="thumb"></object>
    </div> 
 <table align="center">
    <tr>
      <td>
	         
             <label style="display:none" id="lab1">�豸1</label>
            <select style="display:none" id="subType1" style="width: 90px" name="subType1" onchange="changesubTypeMain()"></select> 
            <select style="display:none" id="selRes1" style="width: 90px" name="selRes"></select> 
            <label style="display:none" id="lab2">�豸2</label>
            <select style="display:none" id="subType2" style="width: 90px" name="subType2" onchange="changesubTypeAssist()"></select> 
            <select style="display:none" id="selRes2" style="width: 90px" name="selRes"></select> 		
            <input style="display:none" class="submit_01" type="button" value="����Ƶ" onclick="OpenVideo()" />
            <input style="display:none" class="submit_01" type="button" value="�ر���Ƶ" onclick="CloseVideo()" />
			<b style="display:none">|</b>
			<div style="display:none">
			<input style="display:none" id="EnableDate" type="checkbox" value="" onclick="EnableDate(this)" />����
            <input style="display:none" id="AddText" type="checkbox" value="" onclick="AddText(this)" />����
            <input style="display:none" id="Deskew" type="checkbox" value="" onclick="Deskew(this)" />��ƫ
            <input style="display:none" id="SetState" type="checkbox" value="" onclick="SetState(this)" />�ֶ���ѡ
			<input style="display:none" id="OpenVerifyFacRect" type="checkbox" value="" onclick="OpenVerifyFacRect(this)" />�����ü�	
            <!-- <br /> -->
            </div>
			<input style="display:none" class="submit_01" type="button" value="��ת"	onclick="Left()" />
            <input style="display:none" class="submit_01" type="button" value="��ת"	onclick="Right()" />
            <input style="display:none" class="submit_01" type="button" value="����"	onclick="ShowProperty()" />
			<b style="display:none">|</b>
            <input style="display:none" class="submit_01" type="button" value="��ͷ¼��"	onclick="StartMainRecord()" />
            <input style="display:none" class="submit_01" type="button" value="ֹͣ"	onclick="StopMainRecord()" />
            <input style="display:none" class="submit_01" type="button" value="��ͷ¼��"	onclick="StartAssistRecord()" />
            <input style="display:none" class="submit_01" type="button" value="ֹͣ"	onclick="StopAssistRecord()" />		
			<b style="display:none">|</b>
			<input style="display:none" class="submit_01" type="button" value="����ͼ�����ϴ�"	onclick="UploadThumbToServer()" />
			<b style="display:none">|</b>
            <input style="display:none" class="submit_01" type="button" value="����/��ά��ʶ��"	onclick="Barcode()" />
            <input style="display:none" class="submit_01" type="button" value="MD5" onclick="GetImgMD5()" />
            <input style="display:none" class="submit_01" type="button" value="OCR" onclick="OCR()" />
           <!--  <br /> -->
            <input style="display:none" class="submit_01" type="button" value="��ʼ��"	onclick="InitBiokey()" />
            <input style="display:none" class="submit_01" type="button" value="�ɼ�ָ������"	onclick="GetFeature()" />
            <img style="display:none" src=""  id="BiokeyImg2" alt="ָ��ͼ��2" width=20 height=20/>
            <input style="display:none" class="submit_01" type="button" value="ֹͣ�ɼ�����"	onclick="StopGetFeature()" />
            <input style="display:none" class="submit_01" type="button" value="�ɼ�ָ��ģ��"	onclick="GetTemplate()" />
            <img style="display:none" src=""  id="BiokeyImg1" alt="ָ��ͼ��1" width=20 height=20/>
            <input style="display:none" class="submit_01" type="button" value="ֹͣ�ɼ�ģ��"	onclick="StopGetTemplate()" />
            <input style="display:none" class="submit_01" type="button" value="ָ�ƶԱ�" onclick="BiokeyVerify()" />
            <input style="display:none" class="submit_01" type="button" value="����ʼ��"	onclick="DInitBiokey()" />
			<b style="display:none">|</b>
			<input style="display:none" class="submit_01" type="button" value="����ʶ��" onclick="FaceDetect()" />
			<input style="display:none" class="submit_01" type="button" value="��֤�ȶ�" onclick="VerifyFaceDetect()" />
            <!-- <br /> -->
            <input  style="display:none" class="longbutton" type="button" value="��������֤�Ķ�" onclick="StartIDCard()" />
            <input  style="display:none" class="longbutton" type="button" value="ֹͣ�Ķ�" onclick="StopIDCard()" />
			</td>
	    </tr>
	     <tr style="text-align:center;">
	       <td class="input" >
	       	<span id="4" style="display:none;">���֤����:</span>
			<input  id="1" style="display:none;" class="button" type="button" value="����" onclick="ReadIDCard()" />
		   <span style="display:;font-size:13px;" >ɨ��ߴ�<select id="scansize" style="width: 90px" name="scansize" onchange="changescansize()">			
				 <option value ="org">ԭʼ</option>
				<option value ="mid">��</option> 
				<option value="small">С</option>
			</select></span>
		   <span style="font-size:13px;">OCRʶ��:</span>
		   <input id="19" style="display:;" class="button" type="button" value="�����ϴ�"	onclick="ScanToHttpServer()" />
		   <input  id="2" style="display:;" disabled="true" class="button" type="button" value="ʶ��" onclick="fileUpload()" />
		   <input  class="button" type="button" value="�ر�" onclick="window.close();" />
		   <br />
		   <br />
		    <input type="file" id="upfile" name="upfile" size="60" />
		    <input style="display:" class="button" type="button" value="�����ϴ�"	onclick="UploadToHttpServer()" />
		   <input style="display:none" type="text" id="copyfile" name="copyfile" />
		   </td>
		</tr>	
		<tr>
		   <td>
			
			<input style="display:none" class="button" type="button" value="����"	onclick="Scan()" />
			<img style="display:none" src=""  id="idcardimg" alt="����֤ͼ��" width=20 height=20/>
			<b style="display:none">|</b>
            <input style="display:none" class="submit_01" type="button" value="����IC���Ķ�" onclick="StartICCard()" />
            <input style="display:none" class="submit_01" type="button" value="ֹͣ�Ķ�" onclick="StopICCard()" />
			<b style="display:none">|</b>
            <input style="display:none" class="submit_01" type="button" value="�����������Ķ�" onclick="StartMagCard()" />
            <input  style="display:none" class="submit_01" type="button" value="ֹͣ�Ķ�" onclick="StopMagCard()" />
			<b style="display:none">|</b>
			<input style="display:none" class="submit_01" type="button" value="��������ͨ�Ķ�" onclick="StartShenZhenTongCard()" />
            <input style="display:none" class="submit_01" type="button" value="ֹͣ�Ķ�" onclick="StopShenZhenTongCard()" />
			<!-- <br /> -->
			
			
            <input style="display:none" type="text" id="message" size = "195"/>
            <input style="display:none" type="text" id="idcard" size = "195"/>
            <br />
            <input style="display:none;" TYPE="file" id="FILE1" name="FILE1" OnKeyDown="return false" SIZE="60"></input>
            <br />
            <input  type="hidden" id="iddata" />
            <span style="font-size:13px;">֤������:</span>
            <input style="display:;" type="text" id="8" size = "100"/><br />
            <span style="font-size:13px;">�����˻�:</span>
			<input style="display:" type="text" id="9" size = "100"/><br />
            <span style="font-size:13px;">���д���:</span>
            <input style="display:" type="text" id="10" size = "100"/><br />
			
			<input style="display:none" type="text" id="url" value="<%=url1%>" />
			<input style="display:none" type="text" id="cardurl" value="" />
			</td>
	    </tr>
	    <tr align="center">
	    	<td>
	    	    <input id=""  class="button" type="button" value="ȷ����Ϣ��д" onclick="back()" />
	    	</td>
	    </tr>
</table>
</form> 
    </body>
</html>

    
 
