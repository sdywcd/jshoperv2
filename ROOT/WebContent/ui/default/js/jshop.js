/**
 * 全局变量
 */
var guigeflagword=false;
var guigeflagpc=false;

$(function() {
	// 获取url地址用来让用户登录时跳转
	var windowsurl = window.location;
	$('#hidurl').attr("value", windowsurl);
});
$(function(){
//	// 所在地插件
//	$("#ChinaArea").jChinaArea( {
//		aspnet : false,
//		s1 : "上海市",// 默认选中的省名
//		s2 : "上海市",// 默认选中的市名
//		s3 : "黄浦区"// 默认选中的县区名
//	});
});
var flag = false;
// 验证商品传递的参数
function validatethenpostinfotoaddgoods() {
	var username = $('#username').val();
	var password = $('#password').val();
	var rpassword = $('#rpassword').val();
	var email = $('#email').val();
	var rand = $('#rand').val();
	var random = $('#random').val();
	if (username == "") {
		alert("用户名必须填写");
		return false;
	}
	if (password == "") {
		alert("密码必须填写");
		return false;
	}
	if (password < 4 && password > 20) {
		alert("密码必须为6 - 20 之间");
		return false;
	}
	if (rpassword == "") {
		alert("请重复密码");
		return false;
	}
	if (rpassword != password) {
		alert("两次填写密码不一致");
		return false;
	}
	if (email == "") {
		alert("邮箱必须填写");
		return false;
	}
	if (rand == "") {
		alert("验证码必须填写");
		return false;
	}
	if (/^[0-9a-z][_.0-9a-z-]{0,31}@([0-9a-z][0-9a-z-]{0,30}[0-9a-z].){1,4}[a-z]{2,4}$/.test(email)) {
	} else {
		alert("邮箱格式不正确，请重新填写");
		return false;
	}
	flag = true;
}

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * 用户注册验证
 */
function clearMsg(val) {
	switch (val) {
	case 1:
		$("#usernameMsg").html("");
		break;
	case 2:
		$("#passwordMsg").html("");
		break;
	case 3:
		$("#EmailMsg").html("");
		break;
	case 4:
		$("#validateCodeMsg").html("");
		break;
	}
}
/**
 * 用户注册页部分js
 */
$(function() {
	var msg = $.query.get('msg');
	if (msg != "") {
		$("#usernameMsg").html("");
		$("#passwordMsg").html("");
		$("#EmailMsg").html("");
		$("#passwordMsg").html("");
		$("#activeemailmsg").html("");
		$("#validateCodeMsg").html("");
		switch (msg) {
		case 1:
			$("#usernameMsg").html("<span style='color:red;'>6-20位字符，可由中文、英文、数字及“_”组成</span>");
			break;
		case 2:
			$("#passwordMsg").html("<span style='color:red;'>密码请设为6-16为字母或数字</span>");
			break;
		case 3:
			$("#EmailMsg").html("<span style='color:red;'>邮箱必须填写邮箱地址，如ostocy@sina.com</span>");
			break;
		case 4:
			$("#usernameMsg").html("<span style='color:red;'>用户已经存在</span>");
			break;
		case 5:
			$("#validateCodeMsg").html("<span style='color:red;'>验证码错误</span>");
			break;
		case 6:
			$("#activeemailmsg").html("<span style='color:red;'>激活邮件已经发送</span>");
			break;
		case 7:
			$("#EmailMsg").html("<span style='color:red;'>邮箱已经被使用<span>");
			break;
		}
	}
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

$(function() {
	// 获取url地址用来让用户登录时跳转
	function redirect() {
		var url = window.location.search;
		if (url == "") {
			var redirecturl = "../../../../index.html";
			self.location = redirecturl;
		} else {
			var redirecturl = url.substring(url.indexOf("?") + 13, url.length);
			self.location = redirecturl;
		}
	}

	// 用户登录ajax
	$('#submit').click(function() {
		var username = $('#username').val();
		var password = $('#password').val();
		$.post("login.action", {
			"username" : username,
			"password" : password
		}, function(data) {
			if (data.loginflag) {
				redirect();
			} else {
				return;
			}

		});
	});
	// 找回密码ajax
	// 检查用户问题

	$('#checkfindpassword').click(function() {
		var username = $('#username').val();
		var question = $('#question').val();
		var answer = $('#answer').val();
		$.post("checkUserByAnswer.action", {
			"username" : username,
			"question" : question,
			"answer" : answer
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "findpasswordok.html";
			} else {
				return;
			}

		});
	});
	// 设置密码保护
	$('#questionprotectsubmit').click(function() {
		var question = $('#paySafetyQuestion').val();
		if (question == "") {
			$('#showMsg1').css("visibility", "visible");
			$('#showMsg1').html("请选择问题");
			return false;
		}
		var answer = $('#payAnswer').val();
		if (answer == "") {
			$('#showMsg1').css("visibility", "visible");
			$('#showMsg1').html("问题回答不能为空");
			return false;
		}
		var oldanswer=$("#oldanswer").val();

		$.post("updateUserPasswordProtection.action", {
			"question" : question,
			"answer" : answer,
			"oldanswer":oldanswer
		}, function(data) {
			if (data.sucflag) {
				$('#showMsg1').css("visibility", "visible");
				$('#showMsg1').html("设置成功");
			} else {
				self.location = "login.html";
			}
		});
	});

	

	/**
	 * 用户中心个人资料部分
	 */

	// 点击提交更新个人资料
	$('#userbascinfosubmit').click(function(){
		var realname = $("#realname").val();
		var sex = $("input[name='sex']:checked").val();
		var birYear = $('#birYear').find("option:selected").text();
		var birMonth = $('#birMonth').find("option:selected").text();
		var birDay = $('#birDay').find("option:selected").text();
		var birthday = birYear + "-" + birMonth + "-" + birDay;
		var mobile = $("#mobile").val();
		var telno = $("#telno").val();
		var province = $("#province").find("option:selected").text();
		var city = $("#city").find("option:selected").text();
		var district = $("#district").find("option:selected").text();
		var address = province + city + district + $("#address").val();
		var postcode = $("#postcode").val();
		var qq = $("#qq").val();
		var msn = $("#msn").val();
		var othercontract = $("#othercontract").val();
		var hobby = $("#hobby").val();
		$.post("updateUserforMyInfo.action", {
			"realname" : realname,
			"sex" : sex,
			"birthday" : birthday,
			"mobile" : mobile,
			"telno":telno,
			"address":address,
			"postcode":postcode,
			"qq":qq,
			"msn":msn,
			"othercontract":othercontract,
			"hobby":hobby
		});

	});

	
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * 商品分类页面
 * 
 */
// 点击加入购物车
function addtocart(goodsid) {
	var needquantity = 1;
	var hidurl = $('#hidurl').val();
	$.post("addCart.action", {
		"goodsid" : goodsid,
		"needquantity" : needquantity,
		"hidurl" : hidurl
	}, function(data) {
		if (!data.slogin) {
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		} else if (data.sucflag) {
			// 跳转到购物车页面
			window.location.href = "findAllCartByUserId.action";
		} else {
			// 跳转到商品页面
			window.location.href = data.hidurl;
		}
	});

}
// 收藏夹
function addtofav(goodsid, title, readcount, memberprice) {
	var windowsurl = window.location;
	$('#hidurl').attr("value", windowsurl);
	var hidurl = $('#hidurl').val();

	$.post("addFavorite.action", {
		"title" : title,
		"goodsid" : goodsid,
		"readcount" : readcount,
		"memberprice" : memberprice,
		"hidurl" : hidurl
	}, function(data) {
		if(!data.slogin){
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		}else{
			if(data.sucflag){
				alert("收藏成功");
			}else{
				alert("收藏失败");
			}
		}
	});
}
/**
 * 商品详细部分点击加入购物车
 */
function addcart(){
	//检查是否规格商品
	var hidguigeflag=$("#hidguigeflag").val();
	if(hidguigeflag=="1"){
		//检测是否选择了规格
		if(checkguigebeforeAddcart()==false){
			alert("你选择的规格值产品缺货咯");
			return false;
		}
	}
	//点击加入购物车
	var productid=$("#hidproductid").val();
	var goodsid=$('#hidgoodsid').val();
	var needquantity=1;//默认只购买一个
	var hidurl=$('#hidurl').val();
	$.post("addCart.action",{"guigeflag":hidguigeflag,"productid":productid,"goodsid":goodsid,"needquantity":needquantity,"redirecturl":hidurl},function(data){
		if (!data.slogin) {
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		} else if (data.sucflag) {
			// 跳转到购物车页面
			window.location.href = "findAllCartByUserId.action";
		} else {
			// 跳转到商品页面
			window.location.href = data.hidurl;
		}
	});
}
//商品详细增加收藏夹
function addfav() {
	var hidurl=$('#hidurl').val();
	var title=$('#hidgoodsname').val();
	var goodsid=$('#hidgoodsid').val();
	var readcount=$('#hidreadcount').val();
	var memberprice=$('#hidmemberprice').val();
	$.post("addFavorite.action",{"title":title,"goodsid":goodsid,"readcount":readcount,"memberprice":memberprice,"hidurl":hidurl},function(data){
		if(!data.slogin){
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		}else{
			if(data.sucflag){
				$('#addfavok').html("收藏成功");
			}else{
				$('#addfavok').html("收藏失败");
			}
		}
	});
}




//遍历text计算重量和总金额
var amount=0;
var thisprice=0.0;
var thisweight=0.0;
var tempamount=0;
var tempprice=0.0;
var tempweight=0.0;
var totalmemberprice=0;
var totalweight=0;
var change;
function getall(){
	 amount=0;
	 thisprice=0.0;
	 thisweight=0.0;
	 tempamount=0;
	 tempprice=0.0;
	 tempweight=0.0;
	 totalmemberprice=0;
	 totalweight=0;
	 change;
	$("input:text").each(function(){
		if(!this.name.indexOf("amount")>0){
			if(this.value=="1"){
				tempamount=1;
			}else{
				tempamount=parseInt(this.value);
			}
			change=this.name.split(',');
			tempprice=change[1];
			tempweight=change[2];
			thisprice+=(tempprice*10)*(tempamount*10)/100;
			thisweight+=(tempweight*10)*(tempamount*10)/100;
		}
	});
	
}


//获取商品数量对应的input数据
function changereduceamount(goodsid,weight,favorable){
	getall();
	var amount=$('#amount'+goodsid).val();
	if(amount=="1"){
		amount=2;
	}
	var tempamount=parseInt(amount)-1;
	$('#amount'+goodsid).attr("value",tempamount);
	//计算金额和重量
	thisprice=thisprice-(favorable*10)*(1*10)/100;
	thisweight=thisweight-(weight*10)*(1*10)/100;
	$('#totalmemberprice').html(thisprice);
	$('#totalweight').html(thisweight);
}

function changeplusamount(goodsid,weight,favorable){
	getall();
	var amount=$('#amount'+goodsid).val();
	if(amount=="1"){
		amount=2;
	}
	var tempamount=parseInt(amount)+1;
	$('#amount'+goodsid).attr("value",tempamount);
	//计算金额和重量
	thisprice=thisprice+(favorable*10)*(1*10)/100;
	thisweight=thisweight+(weight*10)*(1*10)/100;
	$('#totalmemberprice').html(thisprice);
	$('#totalweight').html(thisweight);
}

//重新计算总价和重量
function resetgetall(){
	 var ramount=0;
	 var rthisprice=0.0;
	 var rthisweight=0.0;
	 var rtempamount=0;
	 var rtempprice=0.0;
	 var rtempweight=0.0;
	 var rtotalmemberprice=0;
	 var rtotalweight=0;
	 var rchange;
	$("input:text").each(function(){
		if(!this.name.indexOf("amount")>0){
			if(this.value=="1"){
				rtempamount=1;
			}else{
				rtempamount=parseInt(this.value);
			}
			rchange=this.name.split(',');
			rtempprice=rchange[1];
			rtempweight=rchange[2];
			rthisprice+=(rtempprice*10)*(rtempamount*10)/100;
			rthisweight+=(rtempweight*10)*(rtempamount*10)/100;
		}
	});
	$('#totalmemberprice').html(rthisprice);
	$('#totalweight').html(rthisweight);
	
}
function changeinfo(goodsid,weight,favorable){
	var amount=$('#amount'+goodsid).val();
	if(amount>100){
		alert("数量超时限定");
		$('#amount'+goodsid).attr("value",1);
		//计算金额和重量
		resetgetall();
		return;
	}else{
		//计算金额和重量
		resetgetall();
		return;
	}
	if(amount<1){
		alert("数量超时限定");
		$('#amount'+goodsid).attr("value",1);
		//计算金额和重量
		resetgetall();
		return;
	}else{
		//计算金额和重量
		resetgetall();
		return;
	
	}
	
}


/**
 * 增加商品评论
 */
function addgoodscomment(){
	var goodsid=$('#hidgoodsid').val();
	var goodsname=$('#hidgoodsname').val();
	var commentcontent=$('#commentcontent').val();
	var hidurl=window.location;
	if(goodsid!=""&&goodsname!=""&&commentcontent!=""){
		$.post("addGoodsComment.action",{"goodsid":goodsid,"goodsname":goodsname,"commentcontent":commentcontent},function(data){
			if(data.sucflag){
				window.location.href=hidurl;
			}else{
				window.location.href = "user/login.html?redirecturl=" + hidurl;
			}
		});
	}else{
		alert("请填写您的评论");
		return false;
	}
}



/**
 * 购物车中删除商品根据商品id
 */
function delCartBygoodsid(goodsid){
	var hidurl=$('#hidurl').val();
	$.post("DelCartByGoodsId.action",{"goodsid":goodsid,"redirecturl":hidurl},function(data){
		if (!data.slogin) {
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		} else if (data.sucflag) {
			// 跳转到购物车页面
			window.location.href = "findAllCartByUserId.action";
		} else {
			// 跳转到商品页面
			window.location.href = data.hidurl;
		}
	});
}
/*
 * 删除购物车商品根据购物车唯一id
 * */

function delCartByid(id){
    var hidurl=$('#hidurl').val();
    $.post("delCartByid.action",{"id":id,"redirecturl":hidurl},function(data){
        if (!data.slogin) {
            // 跳转到登录页面
            window.location.href = "user/login.html?redirecturl=" + hidurl;
        } else if (data.sucflag) {
            // 跳转到购物车页面
            window.location.href = "findAllCartByUserId.action";
        } else {
            // 跳转到商品页面
            window.location.href = data.hidurl;
        }
    });
}

/**
 * 购物车中结算
 */
function gotojs(){
	var hidurl=$('#hidurl').val();
	var hidgoodsid="";
	var needquantity=0;
	var sendstring="";
	$("input:text").each(function(){
		if(!this.id.indexOf("amount")>0){
			needquantity=this.value;
			hidgoodsid=this.id.substring(this.name.indexOf("amount")+6,this.id.length);
			sendstring+=""+hidgoodsid+","+needquantity+":";
			
		}
	});
	if(sendstring==""){
		alert("购物车中没有商品请继续购物");
		return false;
	}
	$.post("PlusCartNeedquantityByGoodsid.action",{"sendstring":sendstring},function(data){
		
		if(data.slogin){
			//跳转到登录页面
			window.location.href="user/login.html?redirecturl=" + hidurl;
		}
		if(data.sucflag){
			//跳转到购物车页面
			window.location.href="InitOrder.action?redirecturl=findAllCartByUserId.action";
		}
	});
	
}
/**
 * 增加新的收获地址
 * @return
 */
function addnewAddress(){
	var hidurl=$('#hidurl').val();
	var username=$('#username').val();
	//此处添加收货人信息
	var country=$("#country").find("option:selected").text();
	var province=$('#province').find("option:selected").text();
    var city=$('#city').find("option:selected").text();
    var district=$('#district').find("option:selected").text();
	var street=$('#street').val();
	var mobile=$('#mobile').val();
	var telno=$('#telno').val();
	var email=$('#email').val();
	var postcode=$('#postcode').val();
	if(username==""&&street==""&&mobile==""){
		alert("请填写收货信息");
		return;
	}
	$.post("addDeliveraddress.action",{"username":username,"country":country,"province":province,"city":city,"district":district,"street":street,"mobile":mobile,"telno":telno,"email":email,"postcode":postcode},function(data){
		
		if(data.slogin){
			//跳转到登录页面
			window.location.href="user/login.html?redirecturl=" + hidurl;
		}
		if(data.sucflag){
			window.location.href="GetUserDeliverAddress.action";
		}
	});
}

/**
 * 增加新的收获地址
 * @return
 */
function myAddressAdd(){
	var hidurl=$('#hidurl').val();
	var username=$('#username').val();
	//此处添加收货人信息
	var country=$("#country").find("option:selected").text();
	var province=$('#province').find("option:selected").text();
    var city=$('#city').find("option:selected").text();
    var district=$('#district').find("option:selected").text();
	var street=$('#street').val();
	var mobile=$('#mobile').val();
	var telno=$('#telno').val();
	var email=$('#email').val();
	var postcode=$('#postcode').val();
	if(username==""&&street==""&&mobile==""){
		alert("请填写收货信息");
		return;
	}
	$.post("addDeliveraddress.action",{"username":username,"country":country,"province":province,"city":city,"district":district,"street":street,"mobile":mobile,"telno":telno,"email":email,"postcode":postcode},function(data){
		
		if(data.slogin){
			//跳转到登录页面
			window.location.href="user/login.html?redirecturl=" + hidurl;
		}
		if(data.sucflag){
			window.location.href="GetUserDeliverAddressForUserCenter.action";
		}
	});
}
/**
 * 修改收货地址
 * @param addressid
 * @return
 */
function alteradderss(addressid){
	var addressid =  addressid;
	
	$.post("findDeliverAddressByaddresid.action",{"addressid":addressid},function(data){
		if(!data.slogin){
			window.location.href="/html/default/shop/user/login.html";
		}
		if(data.sucflag){
			
			$("#username").val(data.bean.username);
			$("#country").val(data.bean.country);
			$("#province").val(data.bean.province);
			$("#city").val(data.bean.city);
			$("#district").val(data.bean.district);
			$("#street").val(data.bean.street);
			$("#telno").val(data.bean.telno);
			$("#mobile").val(data.bean.mobile);
			$("#postcode").val(data.bean.postcode);
			$("#email").val(data.bean.email);
			$("#addsid").val(data.bean.addressid)
		}
		});
}

/**
 * 根据收获地址ID更新地址
 * @return
 */
function myAddressAlter(){
	var addressid = $("#addsid").val();
	var username=$('#username').val();
	//此处添加收货人信息
	var country=$("#country").find("option:selected").text();
	var province=$('#province').find("option:selected").text();
    var city=$('#city').find("option:selected").text();
    var district=$('#district').find("option:selected").text();
	var street=$('#street').val();
	var mobile=$('#mobile').val();
	var telno=$('#telno').val();
	var email=$('#email').val();
	var postcode=$('#postcode').val();
	if(username==""&&street==""&&mobile==""){
		alert("请填写收货信息");
		return;
	}
	$.post("updateDeliverAddress.action",{"addressid":addressid,"username":username,"country":country,"province":province,"city":city,"district":district,"street":street,"mobile":mobile,"telno":telno,"email":email,"postcode":postcode},function(data){
		if(!data.slogin){
			window.location.href="/html/default/shop/user/login.html";
		}
		if(data.sucflag){
			window.location.href="GetUserDeliverAddressForUserCenter.action";
		}
	});
}

/**
 * 删除收获地址
 * @param addressid
 * @return
 */
function deladdress(addid){
	var hidurl=$('#hidurl').val();
	var addressid=addid+",";
	$.post("delDeliverAddressByaddressid.action",{"addressid":addressid},function(data){
		if(data.slogin){
			//跳转到登录页面
			window.location.href="user/login.html?redirecturl=" + hidurl;
		}
		if(data.sucflag){
			window.location.href="GetUserDeliverAddress.action";
		}
	});
}

/**
 * 删除地址簿收货地址
 * @param addressid
 * @return
 */
function delmyaddress(addid){
	var hidurl=$('#hidurl').val();
	var addressid=addid+",";
	$.post("delDeliverAddressByaddressid.action",{"addressid":addressid},function(data){
		if(data.slogin){
			//跳转到登录页面
			window.location.href="user/login.html?redirecturl=" + hidurl;
		}
		if(data.sucflag){
			window.location.href="GetUserDeliverAddressForUserCenter.action";
		}
	});
}

function DelMyFavoriteByid(favoid){
	var favoriteid = favoid;
	$.post("DelMyFavoriteByid",{"favoriteid":favoriteid},function(data){
		if(!data.slogin){
			window.location.href="/html/default/shop/user/login.html";
		}
		if(data.sucflag){
			window.location.href="GetMyFavoriteByUserId.action";
		}
	});
}

/**
 * 搜索排序
 */
$(function() {
	var sign = $('#hidsign').val();
	$('#default').click(function() {
		window.location.href = "" + sign + "_1.html";
	});
	$('#sales').click(function() {
		window.location.href = "" + sign + "sales_1.html";
	});
	$('#memberprice').click(function() {
		window.location.href = "" + sign + "memberprice_1.html";
	});
	$('#totalcomment').click(function() {
		window.location.href = "" + sign + "totalcomment_1.html";
	});
	$("#bargainprice").click(function() {
		if ($("#bargainprice").attr("checked") == true) {
			window.location.href = "" + sign + "bargainprice_1.html";
		} else {
			return false;
		}
	});
	$("#hotsale").click(function() {
		if ($("#hotsale").attr("checked") == true) {
			window.location.href = "" + sign + "hotsale_1.html";
		} else {
			return false;
		}
	});
	$("#recommended").click(function() {
		if ($("#recommended").attr("checked") == true) {
			window.location.href = "" + sign + "recommended_1.html";
		} else {
			return false;
		}
	});
	$("#isNew").click(function() {
		if ($("#isNew").attr("checked") == true) {
			window.location.href = "" + sign + "isNew_1.html";
		} else {
			return false;
		}
	});
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */


// 控制商品详细页面的tab切换方法
function showdiv(index) {
	var array = new Array();
	array = [ '0', '1', '2', '3', '4', '5' ];
	for ( var i = 0; i < array.length; i++) {
		if (array[i] == index) {
			$("#gddiv" + index).show();
		} else {
			$("#gddiv" + i).hide();
		}
	}

}

$(function(){
	/**
	 * 
	 * 在商品详细页面选择规格值时修改边框样式
	 */
	
	$(".rm3_pic").click(function(){
	    guigeflagpc=true;
	    $(".rm3_pic").css("border","0px solid #FC5A0A ");
	    $(this).css("border","2px solid #FC5A0A ");
	    var guigevalue=this.title;
	    var goodsid=$("#hidgoodsid").val();
	    //当无货时让点击无效
	    var errormsg=$("#erroring").text();
	    if(errormsg.length>0){
	        return false;
	    }
	    var sg=$("#selectedguigea").text();
	    //改变相应的页面内容
	    if(sg!=""){
	        $("#selectedguigea").text("");
	        $("#selectedguigea").text(this.title);
	    }else{
	        $("#selectedguigea").text(this.title);
	    }
	    //发送请求获取货品内容修改页面值
	    //获取产品信息并填充数据
	    findProductBygoodsid(goodsid,guigevalue);
	    return true;
	});
	
	
	$(".text_current").click(function(){
	    guigeflagword=true;
	    $(".text_current").css("border","0px solid #FC5A0A ");
	    $(this).css("border","2px solid #FC5A0A ");
	    var guigevalue=this.title;
	    var goodsid=$("#hidgoodsid").val();
	    //当无货时让点击无效
	    var errormsg=$("#erroring").text();
	    if(errormsg.length>0){
	        return false;
	    }
	    //改变相应的页面内容
	    var sg=$("#selectedguigea").text();
	    if(sg!=""){
	        $("#selectedguigea").text("");
	        $("#selectedguigea").text(this.title);
	    }else{
	        $("#selectedguigea").text(this.title);
	    }
	    //发送请求获取货品内容修改页面值
	    //获取产品信息并填充数据
	    findProductBygoodsid(goodsid,guigevalue);
	    
	    return true;
	});
});

/**
 * 加入购物车前检查是否选择了规格
 * @returns {Boolean}
 */
function checkguigebeforeAddcart(){
	if(guigeflagpc==true&&guigeflagword==true){
		//当无货时让点击无效
		var errormsg=$("#erroring").text();
		if(errormsg.length>0){
			return false;
		}
		return true;
	}
	return false;
}

/**
 * 根据商品id获取货品值
 */
function findProductBygoodsid(goodsid,guigevalue){
	if(goodsid!=""&&guigevalue!=""){
		$.post("findProductTByGoodsid.action",{"goodsid":goodsid,"guigevalue":guigevalue},function(data){
			if(data.sucflag){
				if(data.bean!=null){
					if(data.bean.memberprice!=null){
						$('#erroring').html("");
						$("#changingmemberprice").html("￥<cite>"+data.bean.memberprice+"</cite>");
						$("#hidproductid").attr("value",data.bean.productid);
					}else{
						$("#erroring").html(guigevalue+"已经售完请选择其他规格产品或者联系客服");
					}
					
				}
			}
		});
	}
}

$(function(){
	//控制配送方式的显示和关闭
	$('#modifylogistics').click(function(){
	    $('#closelogistics').show();
	    $('#otherlogistics').show();
	});
	$('#closelogistics').click(function(){
	    $('#otherlogistics').hide();
	});
	//控制订单备注显示和修改
	$('#modifyorderbz').click(function(){
	    $('#firsttr1').hide();
	    $('#secondtr2').show();
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */



/**
 * 初始化支付宝所需的资料信息并增加订单
 */
function InitAlipayandAddOrder(){
	var paymentid=$('input[name="paymentid"]:checked').val(); 
	var logisticsid=$('input[name="logisticsid"]:checked').val(); 
	var freight=$('#goodsfreightprice').html();
	var deliveraddressid=$('input[name="checkaddress"]:checked').val(); 
	var customernotes=$('#customernotes').val();
	var logisticswebaddress=$('#hd'+logisticsid).val();
	var cartid=$('#cartid').val();//购物车id
	var total=$('#goodstotalprice').html();//表示商品总金额，不包含运费
	var totalpoints=$("#goodstotalpoints").html();//总积分
	var cartgoodsid=$("#cartgoodsid").val();//购物车中商品id
	var cartgoodsname=$("#cartgoodsname").val();//-购物车中商品名称集合cartgoodsname
	var cartneedquantity=$("#cartneedquantity").val();//购物车中所有商品数量总和
	if(logisticsid==null){
		alert("请选择配送方式");
		return;
	}
	if(deliveraddressid==null){
		alert("请选择 收获地址");
		return;
	}
	if(paymentid!=null){
		$.post("InitAlipayneedInfoGroup.action",{"cartneedquantity":cartneedquantity,"cartgoodsname":cartgoodsname,"cartgoodsid":cartgoodsid,"totalpoints":totalpoints,"total":total,"freight":freight,"cartid":cartid,"paymentid":paymentid,"logisticsid":logisticsid,"addressid":deliveraddressid,"logisticswebaddress":logisticswebaddress,"customernotes":customernotes,"orderTag":"1"},function(data){
			if(!data.slogin){
				window.location.href="user/login.html";
				return false;
			}
			if(!data.spayment){
				alert("支付方式获取失败");
				return;
			}
			if(!data.saddorder){
				alert("订单生成出错");
				window.location.href="user/login.html";
			}else{
				//增加发票到发票记录表
				var inv_Payee=$('#inv_payee').val();
				var orderid=data.serialidorderid;
				var inv_Type=$('#inv_type').val();
				var amount=$('#shouldtotalprice').text();
				if(inv_Payee==""){
					window.location.href="/alipay/alipayto.jsp";
				}else{
					$.post("addOrderInvoice.action",{"orderid":orderid,"invType":inv_Type,"invPayee":inv_Payee,"amount":amount,"invContent":"0"},function(data){
						if(data.saddflag){
							window.location.href="/alipay/alipayto.jsp";
						}else{
							alert("发票提交有误请联系客服处理开发票事宜");
							window.location.href="/alipay/alipayto.jsp";
						}
					});
				}
			}
			
		});
	}else{
		alert("请选择支付方式");
	}
}

/**
 * 初始化支付宝所需的资料信息
 */
function InitAgAlipayandUpdateOrder(){
	var orderid=$('#hidorderid').val();
	var paymentid=$('input[name="paymentid"]:checked').val(); 
	var logisticsid=$('input[name="logisticsid"]:checked').val(); 
	var freight=$('#goodsfreightprice').html();
	var deliveraddressid=$('input[name="checkaddress"]:checked').val(); 
	var customernotes=$('#customernotes').val();
	var logisticswebaddress=$('#hd'+logisticsid).val();
	if(logisticsid==null){
		alert("请选择配送方式");
		return;
	}
	if(deliveraddressid==null){
		alert("请选择 收获地址");
		return;
	}
	if(paymentid!=null){
		$.post("InitAgAlipayandUpdateOrder.action",{"orderid":orderid,"paymentid":paymentid,"logisticsid":logisticsid,"logisticswebaddress":logisticswebaddress,"addressid":deliveraddressid,"customernotes":customernotes,"orderTag":"2"},function(data){
			if(!data.slogin){
				window.location.href="user/login.html";
				return false;
			}
			if(data.spayment){
				alert("支付方式获取失败");
				return;
			}
			
			if(data.supdateorder){
				alert("更新订单出错");
				window.location.href="user/login.html";
			}else{
				//增加发票到发票记录表
				var inv_Payee=$('#inv_payee').val();
				var orderid=data.orderid;
				var inv_Type=$('#inv_type').val();
				var amount=$('#shouldtotalprice').text();
				if(inv_Payee==""){
					
					window.location.href="/alipay/alipayto.jsp";
					
				}else{
					$.post("addOrderInvoice.action",{"orderid":orderid,"invType":inv_Type,"invPayee":inv_Payee,"amount":amount,"invContent":"0"},function(data){
						if(data.saddflag){
							window.location.href="/alipay/alipayto.jsp";
						}else{
							alert("发票提交有误请联系客服处理开发票事宜");
							window.location.href="/alipay/alipayto.jsp";
							
						}
					});
				}
			}
			
		});
	}else{
		alert("请选择支付方式");
	}
}


/**
 * 关联商品计算
 * @type String
 */
var pack_products = {'isSpecificationsOpen':{},'data':{},'length':0};
var total =0;
function submitPack(pid){
    if(pack_products.data[pid]){
        $('#pack_product_' + pid).attr("class","");
        $('#img_pack_product_' + pid).attr("src","../../../ui/default/images/shop_1.gif");
        delete pack_products.data[pid];
        pack_products['length'] = pack_products['length'] - 1;
        //pack_products.productsid[]
        total = parseInt(total)-parseInt($('#pp_price_' + pid).val());
    }else{
        $('#pack_product_' + pid).attr("class","cur");
        $('#img_pack_product_' + pid).attr("src","../../../ui/default/images/shop_2.gif");
        pack_products.data[pid] = pid;
        pack_products.isSpecificationsOpen[pid]="1";
        pack_products['length'] = pack_products['length'] + 1;
        total = parseInt(total)+parseInt($('#pp_price_' + pid).val());
    }
    if(total>0){
        //读取商品会员价
        var memberprice=$("#hidmemberprice").val();
        var m=parseInt(memberprice);
        var temp  = total+parseInt(memberprice);
        var ex = /^\d+$/;
        if (ex.test(temp)) {
            // 则为整数
            $("#packTotalPrice").html(temp+".00");
        }
        else{
            $("#packTotalPrice").html(temp);
        }
        $(".left_div").css("display","");
    }else{
        $(".left_div").css("display","none");
    }
}

function addbelinkedGoodsTocart(){
    if(pack_products.length <= 0){
        alert("您没有选择组合套餐商品！");
        return;
    }
    //var a=JSON.stringify(pack_products.isSpecificationsOpen);
    var goodsid="";
    var needquantity="1";
    var hidurl = $('#hidurl').val();
    $.each(pack_products.data,function(i,v){
        goodsid+=v;
    });
    $.post("addCart.action", {
        "goodsid" : goodsid,
        "needquantity" : needquantity,
        "hidurl" : hidurl
    }, function(data) {
        if (!data.slogin) {
            // 跳转到登录页面
            window.location.href = "user/login.html?redirecturl=" + hidurl;
        } else if (data.sucflag) {
            // 跳转到购物车页面
            window.location.href = "findAllCartByUserId.action";
        } else {
            // 跳转到商品页面
            window.location.href = data.hidurl;
        }
    });

  
}
/**
 * 团购商品页面
 * 
 */
// 点击加入团购购物车
function addtogroupcart(groupid) {
	var needquantity = 1;
	var hidurl = $('#hidurl').val();
	$.post("addGroupCart.action", {
		"groupid" : groupid,
		"needquantity" : needquantity,
		"hidurl" : hidurl
	}, function(data) {
		if (!data.slogin) {
			// 跳转到登录页面
			window.location.href = "user/login.html?redirecturl=" + hidurl;
		} else if (data.sucflag) {
			// 跳转到团购订单页面
			window.location.href = "InitGroupOrder.action";
		} else {
			// 跳转到商品页面
			window.location.href = data.hidurl;
		}
	});

}

/**
 * 初始化支付宝所需的资料信息并增加团购订单
 */
function InitAlipayandAddGroupOrder(){
	var paymentid=$('input[name="paymentid"]:checked').val(); 
	var logisticsid=$('input[name="logisticsid"]:checked').val(); 
	var freight=$('#goodsfreightprice').html();
	var deliveraddressid=$('input[name="checkaddress"]:checked').val(); 
	var customernotes=$('#customernotes').val();
	var logisticswebaddress=$('#hd'+logisticsid).val();
	var cartid=$('#cartid').val();//购物车id
	var total=$('#goodstotalprice').html();//表示商品总金额，不包含运费
	var totalpoints=$("#goodstotalpoints").html();//总积分
	var cartgoodsid=$("#cartgoodsid").val();//购物车中商品id
	var cartgoodsname=$("#cartgoodsname").val();//-购物车中商品名称集合cartgoodsname
	var cartneedquantity=$("#cartneedquantity").val();//购物车中所有商品数量总和
	if(logisticsid==null){
		alert("请选择配送方式");
		return;
	}
	if(deliveraddressid==null){
		alert("请选择 收获地址");
		return;
	}
	if(paymentid!=null){
		$.post("InitAlipayneedInfo.action",{"cartneedquantity":cartneedquantity,"cartgoodsname":cartgoodsname,"cartgoodsid":cartgoodsid,"totalpoints":totalpoints,"total":total,"freight":freight,"cartid":cartid,"paymentid":paymentid,"logisticsid":logisticsid,"addressid":deliveraddressid,"logisticswebaddress":logisticswebaddress,"customernotes":customernotes,"orderTag":"1"},function(data){
			if(!data.slogin){
				window.location.href="user/login.html";
				return false;
			}
			if(!data.spayment){
				alert("支付方式获取失败");
				return;
			}
			if(!data.saddorder){
				alert("订单生成出错");
				window.location.href="user/login.html";
			}else{
				//增加发票到发票记录表
				var inv_Payee=$('#inv_payee').val();
				var orderid=data.serialidorderid;
				var inv_Type=$('#inv_type').val();
				var amount=$('#shouldtotalprice').text();
				if(inv_Payee==""){
					window.location.href="/alipay/alipayto.jsp";
				}else{
					$.post("addOrderInvoice.action",{"orderid":orderid,"invType":inv_Type,"invPayee":inv_Payee,"amount":amount,"invContent":"0"},function(data){
						if(data.saddflag){
							window.location.href="/alipay/alipayto.jsp";
						}else{
							alert("发票提交有误请联系客服处理开发票事宜");
							window.location.href="/alipay/alipayto.jsp";
						}
					});
				}
			}
			
		});
	}else{
		alert("请选择支付方式");
	}
}
