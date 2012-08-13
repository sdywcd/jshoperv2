/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/


/**
 * flexigrid list 
 */
$(function() {
	$('#showsetarea').hide();
	$("#setgoodscommentmanagement").flexigrid( {
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display:'商品名称',
			name:'goodsname',
			width:500,
			sortable:true,
			align:'center'
		},{ 
			display:'商品编号',
			name:'usersetnum',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'分类',
			name:'sname',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'会员价',
			name:'memberprice',
			width:120,
			sortable:true,
			align:'center'
		},{
			display:'上架',
			name:'salestate',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'新品',
			name:'isNew',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'特价',
			name:'bargainprice',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'热销',
			name:'hotsale',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'推荐',
			name:'recommended',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'库存',
			name:'quantity',
			width:100,
			sortable:true,
			align:'center'
		},{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		}],
		buttons : [ {
			name : '设置评论和分值',
			bclass : 'add',
			onpress : action
		},{
			separator : true
		} ],
		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		},{
			display:'商品名称',
			name:'goodsname'
		} ],
	
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '评论列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 20, 60,200, 1000 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '设置评论和分值') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$('#showsetarea').show();
						$('#hidgoodsid').attr("value",str);
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}
	}
});

//商品评论列表
$(function() {
	$("#goodscommentmanagement").flexigrid( {
		url : 'findAllGoodsComment.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '被评论的商品',
			name : 'goodsname',
			width : 500,
			sortable : true,
			align : 'center'
		},{
			display : '状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'
		},{
            display : '操作',
            name : 'operating',
            width : 200,
            sortable : true,
            align : 'center'
        }],
		buttons : [ {
			name : '设置商品分值和评论数据',
			bclass : 'add',
			onpress : action
		}, {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '评论内容',
			name : 'commentcontent'
		}, {
			display : '商品名称',
			name : 'goodsname'
		} ],
		sortname : "posttime",
		sortorder : "desc",
		usepager : true,
		title : '商品评论列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗！确定要删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelGoodsComment.action", {
							"commentid" : str
						}, function(data) {
							$('#goodscommentmanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '设置商品分值和评论数据') {
			window.location.href = "addgoodscommentandmark.jsp?session="+session+"#goods";
			return;
		}
	}
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */

$(function(){
	/**
	 * 设置商品星级分值
	 */
	$('#updatestarsum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var star=$('#star').val();
		$.post("updatestarsumBygoodsid.action",{"goodsid":goodsid,"star":star},function(data){
			if(data.sucflag){
				jAlert('设置商品星级分值成功','信息提示');
				
				return;
			}
		});
	});
	
	
	/**
	 * 设置商品打分人数
	 */
	$('#updatestarusersum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var staruser=$('#staruser').val();
		$.post("updatestarusersumBygoodsid.action",{"goodsid":goodsid,"staruser":staruser},function(data){
			if(data.sucflag){
				jAlert('设置商品打分人数成功','信息提示');
				
				return;
			}
		});
	});
	
	/**
	 * 设置商品总评论人数
	 */
	$('#updatecommentsum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var totalcomment=$('#totalcomment').val();
		$.post("updatecommentsumBygoodsid.action",{"goodsid":goodsid,"totalcomment":totalcomment},function(data){
			if(data.sucflag){
				jAlert('设置商品总评论人数成功','信息提示');
				
				return;
			}
		});
	});
	
	
	/**
	 *增加商品虚拟评论
	 */
	$('#addgoodscomment').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var replyorcommentusername=$('#replyorcommentusername').val();
		var commentcontent=$('#commentcontent').val();
		$.post("addvirtualGoodsComment.action",{"goodsid":goodsid,"replyorcommentusername":replyorcommentusername,"commentcontent":commentcontent},function(data){
			if(data.sucflag){
				jAlert('增加商品虚拟评论成功','信息提示');
				
				window.location.href="goodscommentmanagement.jsp?session="+session+"#goods";
			}
		});
	});
	
	
})
/*===========================================Gorgeous split-line==============================================*/

/**
获取商品详细的评论数据
*/
$(function(){
    var goodsid=$.query.get("goodsid");
    if(goodsid==""){
        return false;
    }
    $.post("getGoodscommentDetails.action",{"goodsid":goodsid},function(data){
        if(data.sucflag){
            var temp="";
            $(".title h5").text(data.beanlist[0].goodsname);
            $.each(data.beanlist,function(i,v){
                temp+="<h4>"+v.commentcontent+"</h4>";
                temp+="<ul class='square'>";
                temp+="<li>"+v.replyorcommentusername+"于"+v.posttime+"对"+v.goodsname+"进行评论</li>";
                temp+="<li>评分等级"+v.score+"</li>";
                if(v.state=="1"){
                    temp+="<li id='hideview"+v.commentid+"'><input onclick='hidcomment("+v.commentid+");' type='button' id='hidecomment"+v.commentid+"' name='hidecomment"+v.commentid+"' value='隐藏'/></li>";
                }else{
                    temp+="<li id='showview"+v.commentid+"'><input onclick='showcomment("+v.commentid+");' type='button' id='showcomment"+v.commentid+"' name='showcomment"+v.commentid+"' value='显示'/></li>";
                }
                temp+="<input type='hidden' id='hidecommentid'+"+v.commentid+" name='hidecommentid'+"+v.commentid+" value='"+v.commentid+"'/>";
                temp+="<li><input onclick='openDialog("+v.commentid+");' type='button' id='reply"+v.commentid+"' name='reply"+v.commentid+"' value='回复'/></li>";
                temp+="</ul>";
            });
            $("#detailcomments").html(temp);
        }
    });
});

//这里开始写隐藏和显示评论
function hidcomment(commentid){
    var state="0";
    $.post("updateGoodsCommentorReplyByState.action",{"state":state,"commentid":commentid+","},function(data){
        $("#hidecomment"+commentid).hide();
        $("#hideview"+commentid).html("<li id='showview"+commentid+"'><input onclick='showcomment("+commentid+");' type='button' id='showcomment"+commentid+"' name='showcomment"+commentid+"' value='显示'/></li>");
    });
}
function showcomment(commentid){
    var state="1";
    $.post("updateGoodsCommentorReplyByState.action",{"state":state,"commentid":commentid+","},function(data){
        $("#showcomment"+commentid).hide();
        $("#showview"+commentid).html("<li id='hideview"+commentid+"'><input onclick='hidcomment("+commentid+");' type='button' id='hidecomment"+commentid+"' name='hidecomment"+commentid+"' value='隐藏'/></li>");

    });
}
$(function() {
        // a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
        $( "#dialog:ui-dialog" ).dialog( "destroy" );
        
        var name = $( "#name" ),
            email = $( "#email" ),
            password = $( "#password" ),
            allFields = $( [] ).add( name ).add( email ).add( password ),
            tips = $( ".validateTips" );

        function updateTips( t ) {
            tips
                .text( t )
                .addClass( "ui-state-highlight" );
            setTimeout(function() {
                tips.removeClass( "ui-state-highlight", 1500 );
            }, 500 );
        }

        function checkLength( o, n, min, max ) {
            if ( o.val().length > max || o.val().length < min ) {
                o.addClass( "ui-state-error" );
                updateTips( "Length of " + n + " must be between " +
                    min + " and " + max + "." );
                return false;
            } else {
                return true;
            }
        }

        function checkRegexp( o, regexp, n ) {
            if ( !( regexp.test( o.val() ) ) ) {
                o.addClass( "ui-state-error" );
                updateTips( n );
                return false;
            } else {
                return true;
            }
        }
        
        $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 300,
            width: 350,
            modal: true,
            buttons: {
                "提交回复": function() {
                    var bValid = true;
                    allFields.removeClass( "ui-state-error" );

                    bValid = bValid && checkLength( name, "username", 3, 16 );
                    bValid = bValid && checkLength( email, "email", 6, 80 );
                    bValid = bValid && checkLength( password, "password", 5, 16 );

                    bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
                    // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
                    bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
                    bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

                    if ( bValid ) {
                        $( "#users tbody" ).append( "<tr>" +
                            "<td>" + name.val() + "</td>" + 
                            "<td>" + email.val() + "</td>" + 
                            "<td>" + password.val() + "</td>" +
                        "</tr>" ); 
                        $( this ).dialog( "close" );
                    }
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            },
            close: function() {
                allFields.val( "" ).removeClass( "ui-state-error" );
            }
        });

        
    });
    
function openDialog(commentid){
    $( "#reply"+commentid)
            .button()
            .click(function() {
                $( "#dialog-form" ).dialog( "open" );
            });
}