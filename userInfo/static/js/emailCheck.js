
var  u =null ;
if ($.cookie("user")!=null){
    u = JSON.parse($.cookie("user"));
}
console.log(u);
var userInfo = new Vue({
    el:"#user-info",
    data:{
        user:u,
    },
    methods:{
        test:function () {
            console.log(this.user)
        }
    }
});
var updateEmail = new Vue({
    el:"#update",
    data:{
        user:u,
        oldEmail:u.email,
        code:"",
        url:""
    },
    mounted:function () {
        var urlName = this.$refs.goUrl.value;
        this.url = urlName;
        console.log(urlName)
    },
    methods:{
        checkEmailAndGetCode:function () {
            var time = 3;
            $("#bnt").attr("disabled","disabled");
            $("#bnt").css("background-color","rgb(178,158,158)");
            var that = this;
            $.ajax({
                type: "GET",
                url: "http://192.168.0.106:80/ssm/user/getCode",
                data:{email:that.oldEmail},
                success: function(response){
                    console.log(response);
                    if (response.code == 200){
                        var code = response.data.value;
                        var date = new Date();
                        date.setTime(date.getTime() + (60 * 1000));
                        $.cookie('code', code, { expires: date });
                    }else{
                        console.log("获取验证码出错")
                    }
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log("服务器失败")
                }
            });
            var time = 30;
            var interval= setInterval(()=>{
                if(time <=0 ){
                    $("#bnt").attr("disabled",false);
                    $("#bnt").css("background-color","dodgerblue");
                    $("#bnt").html("获取验证码");
                    time = 30;
                    clearInterval(interval);
                }else{
                    $("#bnt").attr("disabled",true);
                    $("#bnt").html("重新获取("+time+")");
                    time--;
                }
            },1000);
        },
        submit:function () {
            var userCode = this.code;
            var code = $.cookie("code");
            if(!code){
                alert("请先获取验证码");
                return ;
            }
            if(userCode.length==0 || userCode==""|| !userCode){
                alert("请输入验证码");
                return ;
            }
            if(userCode != code){
                alert("验证码错误，请重新输入");
                this.code = "";
            }else{
                var date = new Date();
                date.setTime(date.getTime() + (0 * 1000));
                $.cookie("code",null,{ expires: date });
                window.location.href=  this.url;
            }
        }
    }
});
