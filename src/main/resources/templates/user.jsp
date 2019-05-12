<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link
	href="${APP_PAT }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- 用户注册的模态框 -->
	<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">用户注册</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">userName</label>
							<div class="col-sm-10">
								<input type="text" name="userName" class="form-control"
									id="userName_add_input" placeholder="userName"> 
									<span class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">userGender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="userGender" id="gender1_add_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="userGender" id="gender2_add_input" value="F"> 女
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">userPassword</label>
							<div class="col-sm-10">
								<input type="password" name="userPassword" class="form-control"
									id="userPassword_add_input" placeholder="userPassword">
								<span class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control"
									id="email_add_input" placeholder="11@tanjianmo.com"> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">contactNumber</label>
							<div class="col-sm-10">
								<input type="number" name="contactNumber" class="form-control"
									id="contactNumber_add_input" placeholder="contactNumber">
								<span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="user_save_btn">确认注册</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 用户登录的模态框 -->
	<div class="modal fade" id="userLoginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">欢迎登录</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">userName</label>
							<div class="col-sm-10">
								<input type="text" name="userName" class="form-control"
									id="userName_login_input" placeholder="userName"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">userPassword</label>
							<div class="col-sm-10">
								<input type="password" name="userPassword" class="form-control"
									id="userPassword_login_input" placeholder="userPassword">
								<span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="user_login_btn">确认登录</button>
				</div>
			</div>
		</div>
	</div>
	
	<!--管理员登录的模态框 -->
	<div class="modal fade" id="adminLoginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">欢迎登录后台系统</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">adminName</label>
							<div class="col-sm-10">
								<input type="text" name="adminName" class="form-control"
									id="adminName_login_input" placeholder="adminName"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">adminPassword</label>
							<div class="col-sm-10">
								<input type="password" name="adminPassword" class="form-control"
									id="adminPassword_login_input" placeholder="adminPassword">
								<span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="admin_login_btn">确认登录</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>欢迎使用</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="user_login_modal_btn">用户登录</button>
				<button class="btn btn-primary" id="user_add_modal_btn">注册</button>
				<button class="btn btn-primary" id="admin_login_modal_btn">管理员登录</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//点击登录按钮弹出模态框。
		$("#admin_login_modal_btn").click(function() {
			$("#adminLoginModal").modal({
				backdrop : "static"
			});
		});
		
		//点击登录按钮弹出模态框。
		$("#user_login_modal_btn").click(function() {
			$("#userLoginModal").modal({
				backdrop : "static"
			});
		});

		//清空表单样式及内容
		function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		//点击注册按钮弹出模态框。
		$("#user_add_modal_btn").click(function() {
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			reset_form("#userAddModal form");
			//弹出模态框 
			$("#userAddModal").modal({
				backdrop : "static"
			});
		});

		//点击确定登录，登录管理员
		$("#admin_login_btn").click(function() {
			
			var adminName = $("#adminName_login_input").val();
			var adminPassword = $("#adminPassword_login_input").val();
			if(adminName==""){
				alert("用户名不能为空");
				return false;
			}
			if(adminPassword==""){
				alert("密码不能为空");
				return false;
			}
			//2、发送ajax请求保存用户
			$.ajax({
				url : "${APP_PATH}/admin/login1",
				type : "POST",
				data : {
					"adminName" : adminName,
					"adminPassword" : adminPassword
				},
				dataType : "json",
				async : true,
				success : function(data) {
					if (data != null) {
						alert("登录成功!")
						window.location.href = "admin/login.action";
					} else {
						alert("用户名或密码不正确！")
					}
				}
			});
		});
		
		//点击确定登录，登录用户
		$("#user_login_btn").click(function() {
			
			var userName = $("#userName_login_input").val();
			var userPassword = $("#userPassword_login_input").val();
			if(userName==""){
				alert("用户名不能为空");
				return false;
			}
			if(userPassword==""){
				alert("密码不能为空");
				return false;
			}
			//2、发送ajax请求保存用户
			$.ajax({
				url : "${APP_PATH}/user/login1",
				type : "POST",
				data : {
					"userName" : userName,
					"userPassword" : userPassword
				},
				dataType : "json",
				async : true,
				success : function(data) {
					if (data != null) {
						alert("登录成功!")
						window.location.href = "user/login.action";
					} else {
						alert("用户名或密码不正确！")
					}
				}
			});
		});

		//校验用户名是否可用
		$("#userName_add_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var userName = this.value;
			$.ajax({
				url:"${APP_PATH}/user/checkuser",
				data:"userName="+userName,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#userName_add_input","success","用户名可用");
						$("#user_save_btn").attr("ajax-va","success"); 
					}else{
						show_validate_msg("#userName_add_input","error",result.extend.va_msg);
						$("#user_save_btn").attr("ajax-va","error"); 
					}
				}
			});
		});
		
		//点击确定注册，注册用户
		$("#user_save_btn").click(function() {
			//1、模态框中填写的表单数据提交给服务器进行保存
			//1.1先对要提交给服务器的数据进行校验
			if (!validate_add_form()) {
				return false;
			}
			; 
			//1.2判断之前的ajax用户名校验是否成功。如果成功。
			if ($(this).attr("ajax-va") == "error") {
				return false;
			} 

			//2、发送ajax请求保存员工
			$.ajax({
				url : "${APP_PATH}/user/regist",
				type : "POST",
				data : $("#userAddModal form").serialize(),
				success : function(result) {
					alert(result.msg);
					
					 if(result.code == 100){
						//员工保存成功；
						//1、关闭模态框
						$("#userAddModal").modal('hide');
						//2、来到最后一页，显示刚才保存的数据
						//发送ajax请求显示最后一页数据即可
						//to_page(totalRecord);
					}else{
						//显示失败信息
						//console.log(result);
						//有哪个字段的错误信息就显示哪个字段的；
						if(undefined != result.extend.errorFields.email){
							//显示邮箱错误信息
							show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
						}
						if(undefined != result.extend.errorFields.empName){
							//显示员工名字的错误信息
							show_validate_msg("#userName_add_input", "error", result.extend.errorFields.userName);
						}
					} 
				}
			});
		});

		//校验登录表单
		function validate_login_form() {
			//1、拿到要校验的数据，使用正则表达式
			var userName = $("#userName_login_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if (!regName.test(userName)) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#userName_login_input", "error",
						"用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			} else {
				show_validate_msg("#userName_login_input", "success", "");
			}
			;

			//2、拿到要校验的数据，使用正则表达式
			var userPassword = $("#userPassword_login_input").val();
			var regName_1 = /(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[$@!%*#?&])[A-Za-z\d$@!%*#?&]{6,}$/;
			if (!regName_1.test(userPassword)) {
				show_validate_msg("#userPassword_login_input", "error",
						"密码格式不正确，最少6位，包括至少一位大写字母，一位小写字母，一个数字，一个特殊字符");
				return false;
			} else {
				show_validate_msg("#userPassword_login_input", "success", "");
			}
			;
		}

		//校验注册表单数据
		function validate_add_form() {
			//1、拿到要校验的数据，使用正则表达式
			var userName = $("#userName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if (!regName.test(userName)) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#userName_add_input", "error",
						"用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			} else {
				show_validate_msg("#userName_add_input", "success", "");
			}
			;

			//2、拿到要校验的数据，使用正则表达式
			var userPassword = $("#userPassword_add_input").val();
			var regName_1 = /(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[$@!%*#?&])[A-Za-z\d$@!%*#?&]{6,}$/;
			if (!regName_1.test(userPassword)) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#userPassword_add_input", "error",
						"密码格式不正确，最少6位，包括至少一位大写字母，一位小写字母，一个数字，一个特殊字符");
				return false;
			} else {
				show_validate_msg("#userPassword_add_input", "success", "");
			}
			;

			//3、校验邮箱信息
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (!regEmail.test(email)) {
				//应该清空这个元素之前的样式
				show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
				return false;
			} else {
				show_validate_msg("#email_add_input", "success", "");
			}

			//4、拿到要校验的数据，使用正则表达式
			var userPassword = $("#contactNumber_add_input").val();
			var regName_1 = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
			if (!regName_1.test(userPassword)) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#contactNumber_add_input", "error",
						"手机号码输入不合法");
				return false;
			} else {
				show_validate_msg("#contactNumber_add_input", "success", "");
			}
			;

			return true;
		}

		//显示校验结果的提示信息
		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
	</script>
</body>
</html>