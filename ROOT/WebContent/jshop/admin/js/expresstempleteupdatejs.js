var session ="true";
$(function(){
	
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed"); 
	$("#menu-settings").addClass("opened");
});
$(function(){
	var expresstempleteid=$.query.get('expresstempleteid');
	$.post("findExpresstempleteBytempleteid.action",{"expresstempleteid":expresstempleteid},function(data){
		$('#logisticsid').val(data.beanlist.logisticsid);
		KE.html("expressarea",data.beanlist.kindeditorCode);
		$('#hidexpresstempleteid').val(data.beanlist.expresstempleteid);
	});
});

/**
 * div信息
 */
var divsendname="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-姓名(公司)</div>";
var divsendcountry="<div id='sendcountry' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-国家</div>";
var divsendprovince="<div id='sendprovince' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-省份</div>";
var divsendcity="<div id='sendcity' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-城市</div>";
var divsenddistrict="<div id='senddistrict' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-区县（地区）</div>";
var divsendstreet="<div id='sendstreet' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-街道（地址）</div>";
var divsendtelno="<div id='sendtelno' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-联系电话</div>";
var divsendmobile="<div id='sendmobile' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-手机号码</div>";
var divsendcontactor="<div id='sendcontactor' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>寄件方-联络人</div>";

var divrecipientname="<div id='recipientname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-姓名（公司）</div>";
var divrecipientcountry="<div id='recipientcountry' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-国家</div>";
var divrecipientprovince="<div id='recipientprovince' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-省份</div>";
var divrecipientcity="<div id='recipientcity' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-城市</div>";
var divrecipientdistrict="<div id='recipientdistrict' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-区县（地区）</div>";
var divrecipientstreet="<div id='recipientstreet' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-详细街道（详细地址）</div>";
var divrecipienttelno="<div id='recipienttelno' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-联系电话</div>";
var divrecipientmobile="<div id='recipientmobile' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-手机号码</div>";
var divrecipientpostcode="<div id='recipientpostcode' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-邮编</div>";
var divrecipientcontactor="<div id='recipientcontactor' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>收件方-联络人</div>";


var divyear="<div id='year' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>当时日期-年</div>";
var divmonth="<div id='month' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>当时日期-月</div>";
var divday="<div id='day' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>当时日期-日</div>";
var divhour="<div id='hour' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>当时日期-时</div>";
var divminutes="<div id='minutes' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>当时日期-分</div>";
var divorderid="<div id='orderid' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>订单-订单号</div>";
var divnotes="<div id='notes' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>订单-备注</div>";
var divsendtime="<div id='sendtime' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>订单-送货时间</div>";
var divrighttag="<div id='righttag' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>√(勾)</div>";
var divquantity="<div id='quantity' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:100px;top:50px;'>订单-商品件数</div>";

/**
 * div信息的选取和隐藏
 */
$(function(){
	//寄件方-姓名（公司）
	$("#cbsendname").toggle(
		function () {
			$("#movediv").append(divsendname);
			movesendname();
		},
		function () {
			$("#sendname").remove();
		}
	); 
	//寄件方-国家
	$("#cbsendcountry").toggle(
		function () {
			$("#movediv").append(divsendcountry);
			movesendcountry();
		},
		function () {
			$("#sendcountry").remove();
		}
	);
	//寄件方-省份
	$("#cbsendprovince").toggle(
		function () {
			$("#movediv").append(divsendprovince);
			movesendprovince();
		},
		function () {
			$("#sendprovince").remove();
		}
	);
	//寄件方-城市
	$("#cbsendcity").toggle(
		function () {
			$("#movediv").append(divsendcity);
			movesendcity();
		},
		function () {
			$("#sendcity").remove();
		}
	);
	//寄件方-区县（地区）
	$("#cbsenddistrict").toggle(
		function () {
			$("#movediv").append(divsenddistrict);
			movesenddistrict();
		},
		function () {
			$("#senddistrict").remove();
		}
	);
	//寄件方-街道（地址）
	$("#cbsendstreet").toggle(
		function () {
			$("#movediv").append(divsendstreet);
			movesendstreet();
		},
		function () {
			$("#sendstreet").remove();
		}
	);
	//寄件方-联系电话
	$("#cbsendtelno").toggle(
		function () {
			$("#movediv").append(divsendtelno);
			movesendtelno();
		},
		function () {
			$("#sendtelno").remove();
		}
	);
	//寄件方-手机号码
	$("#cbsendmobile").toggle(
		function () {
			$("#movediv").append(divsendmobile);
			movesendmobile();
		},
		function () {
			$("#sendmobile").remove();
		}
	);
	//寄件方-联络人
	$("#cbsendcontactor").toggle(
		function () {
			$("#movediv").append(divsendcontactor);
			movesendcontactor();
		},
		function () {
			$("#sendcontactor").remove();
		}
	);
	
	//收件方-姓名（公司）
	$("#cbrecipientname").toggle(
		function () {
			$("#movediv").append(divrecipientname);
			moverecipientname();
		},
		function () {
			$("#recipientname").remove();
		}
	);
	//收件方-国家
	$("#cbrecipientcountry").toggle(
		function () {
			$("#movediv").append(divrecipientcountry);
			moverecipientcountry();
		},
		function () {
			$("#recipientcountry").remove();
		}
	);
	//收件方-省份
	$("#cbrecipientprovince").toggle(
		function () {
			$("#movediv").append(divrecipientprovince);
			moverecipientprovince();
		},
		function () {
			$("#recipientprovince").remove();
		}
	);
	//收件方-城市
	$("#cbrecipientcity").toggle(
		function () {
			$("#movediv").append(divrecipientcity);
			moverecipientcity();
		},
		function () {
			$("#recipientcity").remove();
		}
	);
	//收件方-区县（地区）
	$("#cbrecipientdistrict").toggle(
		function () {
			$("#movediv").append(divrecipientdistrict);
			moverecipientdistrict();
		},
		function () {
			$("#recipientdistrict").remove();
		}
	);
	//收件方-详细街道（详细地址）
	$("#cbrecipientstreet").toggle(
		function () {
			$("#movediv").append(divrecipientstreet);
			moverecipientstreet();
		},
		function () {
			$("#recipientstreet").remove();
		}
	);
	//收件方-联系电话
	$("#cbrecipienttelno").toggle(
		function () {
			$("#movediv").append(divrecipienttelno);
			moverecipienttelno();
		},
		function () {
			$("#recipienttelno").remove();
		}
	);
	//收件方-手机号码
	$("#cbrecipientmobile").toggle(
		function () {
			$("#movediv").append(divrecipientmobile);
			moverecipientmobile();
		},
		function () {
			$("#recipientmobile").remove();
		}
	);
	//收件方-邮编
	$("#cbrecipientpostcode").toggle(
		function () {
			$("#movediv").append(divrecipientpostcode);
			moverecipientpostcode();
		},
		function () {
			$("#recipientpostcode").remove();
		}
	);
	//收件方-邮编
	$("#cbrecipientcontactor").toggle(
		function () {
			$("#movediv").append(divrecipientcontactor);
			moverecipientcontactor();
		},
		function () {
			$("#recipientcontactor").remove();
		}
	);
	//当时日期-年
	$("#cbyear").toggle(
		function () {
			$("#movediv").append(divyear);
			moveyear();
		},
		function () {
			$("#year").remove();
		}
	);
	//当时日期-月
	$("#cbmonth").toggle(
		function () {
			$("#movediv").append(divmonth);
			movemonth();
		},
		function () {
			$("#month").remove();
		}
	);
	//当时日期-日
	$("#cbday").toggle(
		function () {
			$("#movediv").append(divday);
			moveday();
		},
		function () {
			$("#day").remove();
		}
	);
	//当时日期-时
	$("#cbhour").toggle(
		function () {
			$("#movediv").append(divhour);
			movehour();
		},
		function () {
			$("#hour").remove();
		}
	);
	//当时日期-分
	$("#cbminutes").toggle(
		function () {
			$("#movediv").append(divminutes);
			moveminutes();
		},
		function () {
			$("#minutes").remove();
		}
	);
	//订单-订单号
	$("#cborderid").toggle(
		function () {
			$("#movediv").append(divorderid);
			moveorderid();
		},
		function () {
			$("#orderid").remove();
		}
	);
	//订单-备注
	$("#cbnotes").toggle(
		function () {
			$("#movediv").append(divnotes);
			movenotes();
		},
		function () {
			$("#notes").remove();
		}
	);
	//订单-送货时间
	$("#cbsendtime").toggle(
		function () {
			$("#movediv").append(divsendtime);
			movesendtime();
		},
		function () {
			$("#sendtime").remove();
		}
	);
	//√(勾)
	$("#cbrighttag").toggle(
		function () {
			$("#movediv").append(divrighttag);
			moverighttag();
		},
		function () {
			$("#righttag").remove();
		}
	);


	
	//订单-商品件数
	$("#cbquantity").toggle(
		function () {
			$("#movediv").append(divquantity);
			movequantity();
		},
		function () {
			$("#quantity").remove();
		}
	);
	
});

/**
 * 寄件方-姓名（公司）
 * @return
 */
function movesendname(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendname").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendname").css("left"));
		_y=e.pageY-parseInt($("#sendname").css("top"));
		$("#sendname").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendname").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendname").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-国家
 * @return
 */
function movesendcountry(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendcountry").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendcountry").css("left"));
		_y=e.pageY-parseInt($("#sendcountry").css("top"));
		$("#sendcountry").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendcountry").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendcountry").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-省份
 * @return
 */
function movesendprovince(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendprovince").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendprovince").css("left"));
		_y=e.pageY-parseInt($("#sendprovince").css("top"));
		$("#sendprovince").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendprovince").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendprovince").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-城市
 * @return
 */
function movesendcity(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendcity").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendcity").css("left"));
		_y=e.pageY-parseInt($("#sendcity").css("top"));
		$("#sendcity").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendcity").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendcity").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-区县（地区）
 * @return
 */
function movesenddistrict(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#senddistrict").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#senddistrict").css("left"));
		_y=e.pageY-parseInt($("#senddistrict").css("top"));
		$("#senddistrict").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#senddistrict").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#senddistrict").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-街道（地址）
 * @return
 */
function movesendstreet(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendstreet").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendstreet").css("left"));
		_y=e.pageY-parseInt($("#sendstreet").css("top"));
		$("#sendstreet").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendstreet").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendstreet").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-联系电话
 * @return
 */
function movesendtelno(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendtelno").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendtelno").css("left"));
		_y=e.pageY-parseInt($("#sendtelno").css("top"));
		$("#sendtelno").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendtelno").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendtelno").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-手机号码
 * @return
 */
function movesendmobile(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendmobile").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendmobile").css("left"));
		_y=e.pageY-parseInt($("#sendmobile").css("top"));
		$("#sendmobile").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendmobile").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendmobile").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 寄件方-联络人
 * @return
 */
function movesendcontactor(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendcontactor").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendcontactor").css("left"));
		_y=e.pageY-parseInt($("#sendcontactor").css("top"));
		$("#sendcontactor").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendcontactor").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendcontactor").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-姓名（公司）
 * @return
 */
function moverecipientname(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientname").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientname").css("left"));
		_y=e.pageY-parseInt($("#recipientname").css("top"));
		$("#recipientname").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientname").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientname").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-国家
 * @return
 */
function moverecipientcountry(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientcountry").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientcountry").css("left"));
		_y=e.pageY-parseInt($("#recipientcountry").css("top"));
		$("#recipientcountry").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientcountry").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientcountry").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-省份
 * @return
 */
function moverecipientprovince(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientprovince").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientprovince").css("left"));
		_y=e.pageY-parseInt($("#recipientprovince").css("top"));
		$("#recipientprovince").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientprovince").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientprovince").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-城市
 * @return
 */
function moverecipientcity(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientcity").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientcity").css("left"));
		_y=e.pageY-parseInt($("#recipientcity").css("top"));
		$("#recipientcity").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientcity").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientcity").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-区县（地区）
 * @return
 */
function moverecipientdistrict(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientdistrict").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientdistrict").css("left"));
		_y=e.pageY-parseInt($("#recipientdistrict").css("top"));
		$("#recipientdistrict").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientdistrict").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientdistrict").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-详细街道（详细地址）
 * @return
 */
function moverecipientstreet(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientstreet").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientstreet").css("left"));
		_y=e.pageY-parseInt($("#recipientstreet").css("top"));
		$("#recipientstreet").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientstreet").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientstreet").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-联系电话
 * @return
 */
function moverecipienttelno(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipienttelno").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipienttelno").css("left"));
		_y=e.pageY-parseInt($("#recipienttelno").css("top"));
		$("#recipienttelno").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipienttelno").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipienttelno").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-手机号码
 * @return
 */
function moverecipientmobile(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientmobile").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientmobile").css("left"));
		_y=e.pageY-parseInt($("#recipientmobile").css("top"));
		$("#recipientmobile").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientmobile").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientmobile").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-邮编
 * @return
 */
function moverecipientpostcode(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientpostcode").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientpostcode").css("left"));
		_y=e.pageY-parseInt($("#recipientpostcode").css("top"));
		$("#recipientpostcode").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientpostcode").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientpostcode").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 收件方-联络人
 * @return
 */
function moverecipientcontactor(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#recipientcontactor").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#recipientcontactor").css("left"));
		_y=e.pageY-parseInt($("#recipientcontactor").css("top"));
		$("#recipientcontactor").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#recipientcontactor").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#recipientcontactor").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 当时日期-年
 * @return
 */
function moveyear(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#year").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#year").css("left"));
		_y=e.pageY-parseInt($("#year").css("top"));
		$("#year").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#year").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#year").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 当时日期-月
 * @return
 */
function movemonth(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#month").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#month").css("left"));
		_y=e.pageY-parseInt($("#month").css("top"));
		$("#month").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#month").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#month").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 当时日期-日
 * @return
 */
function moveday(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#day").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#day").css("left"));
		_y=e.pageY-parseInt($("#day").css("top"));
		$("#day").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#day").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#day").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 当时日期-时
 * @return
 */
function movehour(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#hour").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#hour").css("left"));
		_y=e.pageY-parseInt($("#hour").css("top"));
		$("#hour").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#hour").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#hour").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 当时日期-分
 * @return
 */
function moveminutes(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#minutes").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#minutes").css("left"));
		_y=e.pageY-parseInt($("#minutes").css("top"));
		$("#minutes").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#minutes").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#minutes").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 订单-订单号
 * @return
 */
function moveorderid(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#orderid").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#orderid").css("left"));
		_y=e.pageY-parseInt($("#orderid").css("top"));
		$("#orderid").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#orderid").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#orderid").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 订单-备注
 * @return
 */
function movenotes(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#notes").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#notes").css("left"));
		_y=e.pageY-parseInt($("#notes").css("top"));
		$("#notes").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#notes").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#notes").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * 订单-送货时间
 * @return
 */
function movesendtime(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#sendtime").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#sendtime").css("left"));
		_y=e.pageY-parseInt($("#sendtime").css("top"));
		$("#sendtime").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#sendtime").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#sendtime").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 * √(勾)
 * @return
 */
function moverighttag(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#righttag").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#righttag").css("left"));
		_y=e.pageY-parseInt($("#righttag").css("top"));
		$("#righttag").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#righttag").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#righttag").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}
/**
 *订单-商品件数
 * @return
 */
function movequantity(){
	var _move=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置
	$(document).ready(function(){
		$("#quantity").click(function(){
			//alert("click");//点击（松开后触发）
		}).mousedown(function(e){
			_move=true;
		_x=e.pageX-parseInt($("#quantity").css("left"));
		_y=e.pageY-parseInt($("#quantity").css("top"));
		$("#quantity").fadeTo(20, 0.25);//点击后开始拖动并透明显示
	});
	$(document).mousemove(function(e){
		if(_move){
			var x=e.pageX-_x;//移动时根据鼠标位置计算控件左上角的绝对位置
			var y=e.pageY-_y;
			$("#quantity").css({top:y,left:x});//控件新位置
			//sendnamehtml="<div id='sendname' style='position:absolute;width:100px;height:50px;border:solid 2px;text-align:left;line-height:20px;font-size:14px;left:"+x+"px;top:"+y+"px'></div>";
		}
		}).mouseup(function(){
			_move=false;
			$("#quantity").fadeTo("fast", 1);//松开鼠标后停止移动并恢复成不透明
		});
	});
}


//处理模板配置
$(function() {
	$.post("CheckLogin.action",function(data){
		if(data.slogin){
			top.location.href="jshop/admin/adminlogin.jsp";
		}
	});
	
	//获取物流商
	$(function(){
		$.post("findAllLogisticsBusinessTjson.action",function(data){
			$("#logisticsid").append(data.logisticsjson);
			return;
		});
	});
	
	
	
	var ke="";
	var logisticsid="";
	var kindeditorCode="";
	$("#logisticsid").change(function(){
		logisticsid=$("#logisticsid").val();
	});
	/**
	 * 当被提交执行插入操作
	 */
	$("#submit").click(function(){
		ke=KE.html("expressarea");
		var movediv=$('#movediv').html();
		var expresstempleteid=$('#hidexpresstempleteid').val();
		logisticsid=$("#logisticsid").val();
		kindeditorCode=ke+movediv;
		alert(ke+movediv);
		$.post("UpdateExpresstemplete.action",{"logisticsid":logisticsid,"kindeditorCode":kindeditorCode,"expresstempleteid":expresstempleteid},function(data){
			window.location.href="expresstempleteset.jsp?session="+session+"#settings";
		});
	});
	

		
		

});
