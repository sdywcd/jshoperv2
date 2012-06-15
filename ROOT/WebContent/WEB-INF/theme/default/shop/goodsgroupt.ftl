<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>首页${(jshopbasicinfo.jshopname)}</title>
<meta name="Author" content="OSTOCY">
<meta name="Copyright" content="OSTOCY">
<meta http-equiv="expires" content="0">
<#if (jshopbasicinfo.metaKeywords)! != "">
<meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
	<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/teambuy.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/category.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/js/easyslider1.7/css/screen.css"/>
<script type="text/javascript"  src="${basepath}ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}ui/default/js/easyslider1.7/js/easySlider1.7.js"></script>
</head><body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div class="wrap">

	    <div style="background:url(${basepath}ui/default/images/g_topbanner.jpg) no-repeat top center; width: 100%;">
		<div class="g_content">
		
		    <div class="g_maindiv">
		       <div class="mainleft">
			    <div class="leftdiv1">
				<div class="top"></div>
				<div class="box">
					<#if (goodsgroupt??)&&(goodsgroupt?size>0) >	
					<form method="post" enctype="multipart/form-data" id="buyForm">
					
					<div class="name">
										
					<a target="_blank" href="/product/240603.html">鸿粉团 特价团购769 直接便宜70元 三星（SAMSUNG）S5360 3G手机 WCDMA/GSM Android OS v2.3系统（金属灰）   现货发售，当天发货。全网最低的行货正品手机，快快下手吧~ </a>
					</div>
					<div id="pp" class="div1_left">
					   
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div class="price1" id="scareBuyBtn">
					       

                                               <a onclick="goTeamBuy(-339725863, 92274137, 400215,302905,240603,0,50,0);return false;" href="javascript:;">
                                               <span>￥</span>
                                               <b id="customerPrice_240603">${goodsgroupt.priceladder}</b>
                                               </a>
					   </div>

					<div class="price2">
					   <div class="h1">
						<p>高鸿价</p>
						<p>节省</p>
					   </div>
					   <div class="h1">
						<cite>
						<span id="memberprice400215_240603" class="t2">		
						839.00
  
						</span>
						</cite>
						<cite>						
						<span id="memberprice2400215_240603" class="t2">839 -${goodsgroupt.priceladder}  </span>
						</cite>
					   </div>
					</div>
					<div class="sale">
					   
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div id="ss1" class="s1">
					       

					     <p><span id="sordercount" name="sordercount">${goodsgroupt.SOrderCount}</span>人已购买</p>
					     <p><cite>数量有限，下单要快哟</cite></p>
					   </div>

                                           
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div id="ss2" class="s2">
					      <div class="amo1">

					     <span id="ratio"><div style="width:0.0%" class="amo2"></div></span>
					     </div>
					   <p>共有<span id="salequantity" name="salequantity">${goodsgroupt.salequantity}</span>份，还剩<span id="peoplecountplux" name="peoplecountplux">${goodsgroupt.salequantity}-${goodsgroupt.SOrderCount}</span>份</p>
					</div>
					       


					<div id="mixcount" name="mixcount" class="s3">
					
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <img src="${basepath}ui/default/images/success1.gif">
					       
					</div>
					    <div class="s4">
						<span id="asdfgh">距活动结束还有：<br></span>
						<span id="timer"><input type="text" id="newtime" name="newtime" />
						<#setting date_format=" MM/dd/yyyy HH:mm:ss "/>
						<input type="text" id="begintime" name="begintime" value="${goodsgroupt.begintime?date?string}"  />
						<input type="text" id="endtime" name="endtime" value="${goodsgroupt.endtime?date?string}"  />
						<script type="text/javascript">
						function lxfendTime(){
		// $(".lcftime").each(function(){
			var temp=null;
			//var lxfday=$(this).attr("lxfday");
			var nowTime = new Date().getTime();			
			var begin=document.getElementById('begintime').value;
			var end =document.getElementById('endtime').value;
			var begintime=new Date(begin).getTime();
			var endtime=new Date(end).getTime();
			var grouptime=endtime-nowTime;
			var seconds= grouptime/1000;
			var minutes = Math.floor(seconds/60);
			var hours = Math.floor(minutes/60);
			var days = Math.floor(hours/24);
			var cday = days;
			var chour=hours % 24;
			var cminute=minutes % 60;
			var csecond=Math.floor(seconds%60);
			if(endtime<=nowTime){
				temp="已过期";
			}
			if(endtime>=nowTime){
				temp=cday+" 天 "+chour+" 时 "+cminute+"分 "+csecond+"秒";
			}
			if(begintime>nowTime){
		 	temp="团购即将开始";
			}
			document.getElementById('newtime').value=temp;
						
		// });
		setTimeout("lxfendTime()",1000);
	};	
	$(function(){
		lxfendTime();
	});
	</script>
						</span>			
					    </div>
					</div>
                                        <div class="sw">
						<a style="background:url(${basepath}ui/default/images/icon02.gif) no-repeat;" class="kaixin" href="javascript:window.open('http://www.kaixin001.com/repaste/share.php?rtitle='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;rurl='+encodeURIComponent(document.location.href)+'&amp;rcontent='+encodeURIComponent(document.getElementById('contenttt').value.substring(0,76)));void(0)">开心网</a>
						<a style="background:url(${basepath}ui/default/images/icon04.gif) no-repeat;" class="renren" href="javascript:window.open('http://share.renren.com/share/buttonshare.do?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;link='+encodeURIComponent(document.location.href),'favit','');void(0)">人人网</a>
						<a style="background:url(${basepath}ui/default/images/icon03.gif) no-repeat;" class="douban" href="javascript:window.open('http://www.douban.com/recommend/?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;url='+encodeURIComponent(location.href),'favit','');void(0)">豆瓣</a>
						<a style="background:url(${basepath}ui/default/images/icon05.gif) no-repeat;" class="sina" href="javascript:(function(){window.open('http://v.t.sina.com.cn/share/share.php?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;url='+encodeURIComponent(location.href)+'&amp;source=bookmark','_blank','width=450,height=400');})()">微博</a>
						<a class="im" title="分享到QQ微博" href="javascript:void(window.open('http://v.t.qq.com/share/share.php?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;rurl='+encodeURIComponent(document.location.href)));">qq微博</a>
						<a class="mail" title="邮件" href="mailto:?subject=高鸿团购&amp;body=哈喽，我看高鸿商城在团购这个东东：三星（SAMSUNG）S5360 3G手机 WCDMA/GSM Android OS v2.3系统（金属灰）……。我觉得挺不错的，价格还很便宜。建议你也来看看哦 ">邮件</a>
					</div>
				      </div>
				      <input type="hidden" value="高鸿团购三星（SAMSUNG）S5360 3G手机 WCDMA/GSM Android OS v2.3系统（金属灰），建议你也来看看http://www.tao3c.com/teamBuy/302905.html" name="contenttt" id="contenttt">
				  </form>


				<a style="text-decoration: none" target="_blank" href="/product/240603.html">
				<div class="div1_right">
				   <div class="pic">
					<div class="amount">
					    <p><span id="totalordercount" name="totalordercount"></span>${goodsgroupt.totalOrderCount}</p>人想购买
					</div>
					<img src="${goodsgroupt.pictureurl}" width="470px" height="470px">
				   </div>
				</div>
				</a>
			    </div>
			    <div class="bottom"></div>
			   </div>

			

     <div class="leftdiv2">
	
	        <div class="top"></div>
		<div class="box">
		<div class="title">本期活动规则</div>
		<div class="text">&nbsp;</div>
		</div>
		<div class="bottom"></div>
	
     </div>


     <div class="leftdiv2">
		<div class="top"></div>
		<div class="box">
		<div class="title">详细信息</div>
		<div class="text2"><p><span style="font-family: 宋体"><span style="widows: 2; text-transform: none; background-color: rgb(255,255,255); text-indent: 0px; font: 12px/18px 宋体, Arial, Lucida, Verdana, Helvetica, sans-serif; white-space: normal; orphans: 2; letter-spacing: normal; color: rgb(51,51,51); word-spacing: 0px; -webkit-text-decorations-in-effect: none; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px" class="Apple-style-span">
</span></span></p><table width="750" cellspacing="0" cellpadding="0" border="0" align="center" style="empty-cells: show">
    <tbody>
       ${goodsgroupt.detail}
    </tbody>
</table>
</div>
		</div>
		<div class="bottom"></div>
     </div>
    </div>
	
   </#if>
    <div class="mainright">
        <div class="rightdiv2">
	   <a target="_blank" href="/teamBuy/HistoryTeamBuy.do?movementId=302905">
	   <img src="${basepath}ui/default/images/g_gz1.gif">
	   </a>
	   <a target="_blank" href="/Info/InfoDetail_zixun.do?id=116714&amp;rootCid=904&amp;mid=0">
	   <img src="${basepath}ui/default/images/g_gz2.gif">
	   </a>
	   <a target="_blank" href="/Info/InfoDetail_zixun.do?id=122800&amp;rootCid=904&amp;mid=0">
	   <img src="${basepath}ui/default/images/g_gz3.gif">
	   </a>
	</div>
	<div class="rightdiv3">
	   <p>鸿粉团员已经节省</p>
	  <cite>
          <span>
<font color="red">￥61412121.0</font>
</span>
	  </cite>
	</div>
	
		<div class="rightdiv7 mt7">
		<div class="rd7_top"><img src="${basepath}ui/default/images/groundbuy_top_bg1.gif"></div>
		<div class="rd7_box">
		<div class="rd7_right_icon"></div>
		<div class="rd7_pic"><a target="_blank" href="/teamBuy/302903.html"><img src="${basepath}ui/default/images/246631_1_pic120_5335.jpg"></a></div>
			<div class="rd7_name">诺希（NOHON）小米手机电池 1930mAh （适用于小米M1 MIUI）</div>
			<div class="rd7_price"><p><span>￥</span>49.0</p><cite><a target="_blank" href="/teamBuy/302903.html"><img src="${basepath}ui/default/images/rd7_price_btn.gif"></a></cite></div>
		</div>
		<div class="rd7_bottom"><img src="${basepath}ui/default/images/groundbuy_top_bg3.gif"></div>
		</div>
	
		<div class="rightdiv7 mt7">
		<div class="rd7_top"><img src="${basepath}ui/default/images/groundbuy_top_bg1.gif"></div>
		<div class="rd7_box">
		<div class="rd7_right_icon"></div>
		<div class="rd7_pic"><a target="_blank" href="/teamBuy/302725.html"><img src="${basepath}ui/default/images/254017_1_pic120_4451.jpg"></a></div>
			<div class="rd7_name">美的（midea ） DE12Q51 1.2L 美的全钢无网豆浆机 （紫色）</div>
			<div class="rd7_price"><p><span>￥</span>399.0</p><cite><a target="_blank" href="/teamBuy/302725.html"><img src="${basepath}ui/default/images/rd7_price_btn.gif"></a></cite></div>
		</div>
		<div class="rd7_bottom"><img src="${basepath}ui/default/images/groundbuy_top_bg3.gif"></div>
		</div>
	
		<div class="rightdiv7 mt7">
		<div class="rd7_top"><img src="${basepath}ui/default/images/groundbuy_top_bg1.gif"></div>
		<div class="rd7_box">
		<div class="rd7_right_icon"></div>
		<div class="rd7_pic"><a target="_blank" href="/teamBuy/302804.html"><img src="${basepath}ui/default/images/500464_1_pic120_5947.jpg"></a></div>
			<div class="rd7_name">冲击波（SHOCK WAVE）SU-206 USB笔记本音箱 粉色</div>
			<div class="rd7_price"><p><span>￥</span>29.0</p><cite><a target="_blank" href="/teamBuy/302804.html"><img src="${basepath}ui/default/images/rd7_price_btn.gif"></a></cite></div>
		</div>
		<div class="rd7_bottom"><img src="${basepath}ui/default/images/groundbuy_top_bg3.gif"></div>
		</div>
	
		<div class="rightdiv7 mt7">
		<div class="rd7_top"><img src="${basepath}ui/default/images/groundbuy_top_bg1.gif"></div>
		<div class="rd7_box">
		<div class="rd7_right_icon"></div>
		<div class="rd7_pic"><a target="_blank" href="/teamBuy/302802.html"><img src="${basepath}ui/default/images/500243_1_pic120_909.jpg"></a></div>
			<div class="rd7_name">芙洛蒂（Phrodi） Pod-606 入耳式耳机 黑色</div>
			<div class="rd7_price"><p><span>￥</span>19.0</p><cite><a target="_blank" href="/teamBuy/302802.html"><img src="${basepath}ui/default/images/rd7_price_btn.gif"></a></cite></div>
		</div>
		<div class="rd7_bottom"><img src="${basepath}ui/default/images/groundbuy_top_bg3.gif"></div>
		</div>
	

	<div style="width:198px;border:#c2c2c2 solid 1px;background:#FFFFFF;float:left;margin:9px 0 0 0;padding:0 0 7px 0;">
		<p style="margin:11px 0 0 20px;"><a target="_blank" href="http://t.sina.com.cn/tao3c"><img src="${basepath}ui/default/images/t_sina.jpg"></a></p>
		<p style="margin:5px 0 0 20px;"><a target="_blank" href="http://t.qq.com/tao3c_com"><img src="${basepath}ui/default/images/t_qq.jpg"></a></p>
		<p style="margin:7px 0 0 7px;"><img src="${basepath}ui/default/images/t_tao3c.jpg"></p>
	</div>
	<div class="rightdiv5">
		<p>订阅高鸿活动通知</p>
		<cite>不想错过高鸿商城的活动？<br>立刻订阅邮件通知，精彩不再错过！</cite>
		<div class="email">
		<span class="left"><input type="text" id="userEmail" name="userEmail"></span>
		<span class="right">
		<a onclick="getEmail(302905);" href="javascript:;">
		<img src="${basepath}ui/default/images/g_btn1.gif">
		</a>
		</span>
		</div>
	</div>

	<div class="rightdiv4">
		<img src="${basepath}ui/default/images/r_pic02.jpg">
	</div>
       </div>
      </div>
     </div>
    </div>
   </div>
   

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}ui/default/js/jshop.js"></script>
			
</body>
</html>