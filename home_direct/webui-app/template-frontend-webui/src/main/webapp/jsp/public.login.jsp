<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8"%>

<script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>
<div class="col-md-6 col-md-offset-3  mobile-padding">

	<div class="container" style="margin-top: -30px;">
		<div class="card" style="padding: 20px 0px 20px 0px;">
			<h1 class="title">Đăng nhập tài khoản</h1>

			<div id="form-login" class="container">
				<form action="/xu-ly-dang-nhap" method="post">
					<div class="form-group">
						<label>Tên đăng nhập<span style="color: red">*</span></label> <input
							type="text" class="form-control" id="username" name="username">
					</div>

					<div class="form-group">
						<label>Mật khẩu <span style="color: red">*</span></label> <input
							type="password" class="form-control" id="password"
							name="password">
					</div>

					<p id="alert"></p>
					<div class="button-container" style="clear: both;">
						<button type="submit" class="btn btn-success">
							<span>Đăng nhập</span>
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
