//**********************图片上传预览插件************************
//版本：1.0
//说明：图片上传预览插件
//上传的时候可以生成固定宽高范围内的等比例缩放图
//参数设置：
//width                     存放图片固定大小容器的宽
//height                    存放图片固定大小容器的高
//imgDiv                    页面DIV的JQuery的id
//imgType                   数组后缀名
//**********************图片上传预览插件*************************
(function($) {
    jQuery.fn.extend({
        uploadPreview: function(opts) {
            opts = jQuery.extend({
                width: 0,
                height: 0,
                imgDiv: "#imgDiv",
                imgType: ["gif", "jpeg", "jpg", "bmp", "png"],
                callback: function() { return false; }
            }, opts || {});
            var _self = this;
            var _this = $(this);
            var imgDiv = $(opts.imgDiv);
            imgDiv.width(opts.width);
            imgDiv.height(opts.height);
            autoScaling = function() {
                if ($.browser.version == "7.0" || $.browser.version == "8.0") imgDiv.get(0).filters.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
                var img_width = imgDiv.width();
                var img_height = imgDiv.height();
                if (img_width > 0 && img_height > 0) {
//                    var rate = (opts.width / img_width < opts.height / img_height) ? opts.width / img_width : opts.height / img_height;
//                    if (rate <= 1) {
//                        if ($.browser.version == "7.0" || $.browser.version == "8.0") imgDiv.get(0).filters.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "scale";
//                        imgDiv.width(img_width * rate);
//                        imgDiv.height(img_height * rate);
//                    } else {
//                        imgDiv.width(img_width);
//                        imgDiv.height(img_height);
//                    }
//                    var left = (opts.width - imgDiv.width()) * 0.5;
//                    var top = (opts.height - imgDiv.height()) * 0.5;
//                    imgDiv.css({ "margin-left": left, "margin-top": top });
                    imgDiv.show();
                }
            }
            _this.change(function() {
                if (this.value) {
                    if (!RegExp("\.(" + opts.imgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                        alert("图片类型必须是" + opts.imgType.join("，") + "中的一种");
                        this.value = "";
                        return false;
                    }
                    imgDiv.hide();
                    if ($.browser.msie) {
                        if ($.browser.version == "6.0") {
                            var img = $("<img />");
                            imgDiv.replaceWith(img);
                            imgDiv = img;
                            var image = new Image();
                            image.src = 'file:///' + this.value;
                            imgDiv.attr('src', image.src);
                            autoScaling();
                        }
                        else {
                            imgDiv.css({ filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)" });
                            imgDiv.get(0).filters.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
                            try {
                                imgDiv.get(0).filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = this.value;
                            } catch (e) {
                                alert("无效图片文件");
                                return;
                            }
                            setTimeout("autoScaling()", 100);
                        }
                    }
                    else {
                        var img = $("<img />");
                        imgDiv.replaceWith(img);
                        imgDiv = img;
                        imgDiv.attr('src', this.files.item(0).getAsDataURL());
                        imgDiv.css({ "vertical-align":"middle","width":opts.width,"height":opts.height});
                        setTimeout("autoScaling()", 100);
                    }
                }
            });
        }
    });
})(jQuery);
//function AddFileUpload(lbl) 
//{
//    var TfileUploadNum=parseInt(document.getElementById(lbl).innerHTML);
//    var idnum = TfileUploadNum + 1;
//    var str = "<div>";
//    str += "<input type='file' id='_fuWorkpic" +idnum+"' runat='server'/><input id='_btnAdd"+idnum+"' type='button' value='增加' onclick=\"AddFileUpload('_lblWorkpic');\"/>";
//    str += "</div>";
//    str += "<div style='width:300px;height:300px;border:1px solid red;float:left;'>";
//    str += "<div id='imgWorkDiv"+idnum+"'>";
//    str +="</div>";
//    str +="</div>";
//    str +="<div  style='width: 300px;height:300px;'>";
//    str +="<asp:Image ID='_imageWorkpic" +idnum +"' runat='server' Width='300' Height='300' Visible='false'/>";
//    str +="</div>";
//    $("#loadImage").append(str);
//    TfileUploadNum += 1;
//    document.getElementById('_lblWorkpic').innerHTML=TfileUploadNum;
//}