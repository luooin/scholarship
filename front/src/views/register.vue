<template>
	<div>
		<div class="container">
			<div class="login-form">
				<h1 class="h1">校内评奖评优系统注册</h1>
				<el-form ref="rgsForm" class="rgs-form" :model="rgsForm">
					<el-form-item label="教师姓名" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.jiaoshixingming" autocomplete="off" placeholder="教师姓名" />
					</el-form-item>
					<el-form-item label="密码" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.mima" autocomplete="off" placeholder="密码" type="password"
							#elsetype="text" />
					</el-form-item>
					<el-form-item label="确认密码" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item label="职称" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.zhicheng" autocomplete="off" placeholder="职称" />
					</el-form-item>
					<el-form-item label="电话" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.dianhua" autocomplete="off" placeholder="电话" />
					</el-form-item>
					<el-form-item label="邮箱" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.youxiang" autocomplete="off" placeholder="邮箱" />
					</el-form-item>
					<el-form-item label="班级" class="input" v-if="tableName == 'jiaoshi'">
						<el-input v-model="ruleForm.banji" autocomplete="off" placeholder="班级" />
					</el-form-item>
					<el-form-item label="学号" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.xuehao" autocomplete="off" placeholder="学号" />
					</el-form-item>
					<el-form-item label="姓名" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.xingming" autocomplete="off" placeholder="姓名" />
					</el-form-item>
					<el-form-item label="密码" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.mima" autocomplete="off" placeholder="密码" type="password"
							#elsetype="text" />
					</el-form-item>
					<el-form-item label="确认密码" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item label="邮箱" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.youxiang" autocomplete="off" placeholder="邮箱" />
					</el-form-item>
					<el-form-item label="手机" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.shouji" autocomplete="off" placeholder="手机" />
					</el-form-item>
					<el-form-item label="班级" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.banji" autocomplete="off" placeholder="班级" />
					</el-form-item>
					<el-form-item label="年级" class="input" v-if="tableName == 'xuesheng'">
						<el-input v-model="ruleForm.nianji" autocomplete="off" placeholder="年级" />
					</el-form-item>
					<div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
						<el-button class="btn" type="primary" @click="login()">注册</el-button>
						<el-button class="btn close" type="primary" @click="close()">取消</el-button>
					</div>
				</el-form>
			</div>
		</div>
	</div>
</template>
<script>


export default {
	data() {
		return {
			ruleForm: {
			},
			tableName: "",
			rules: {},
		};
	},
	mounted() {
		let table = this.$storage.get("loginTable");
		this.tableName = table;
	},
	created() {

	},
	methods: {
		// 获取uuid
		getUUID() {
			return new Date().getTime();
		},
		close() {
			this.$router.push({ path: "/login" });
		},
		// 注册
		login() {
			var url = this.tableName + "/register";
			if ((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName) {
				this.$message.error(`教师姓名不能为空`);
				return
			}
			if ((!this.ruleForm.mima) && `jiaoshi` == this.tableName) {
				this.$message.error(`密码不能为空`);
				return
			}
			if ((this.ruleForm.mima != this.ruleForm.mima2) && `jiaoshi` == this.tableName) {
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if ((!this.ruleForm.dianhua) && `jiaoshi` == this.tableName) {
				this.$message.error(`电话不能为空`);
				return
			}
			if (`jiaoshi` == this.tableName && this.ruleForm.dianhua && (!this.$validate.isMobile(this.ruleForm.dianhua))) {
				this.$message.error(`电话应输入手机格式`);
				return
			}
			if (`jiaoshi` == this.tableName && this.ruleForm.youxiang && (!this.$validate.isEmail(this.ruleForm.youxiang))) {
				this.$message.error(`邮箱应输入邮件格式`);
				return
			}
			if ((!this.ruleForm.banji) && `jiaoshi` == this.tableName) {
				this.$message.error(`班级不能为空`);
				return
			}
			if ((!this.ruleForm.xuehao) && `xuesheng` == this.tableName) {
				this.$message.error(`学号不能为空`);
				return
			}
			if ((!this.ruleForm.xingming) && `xuesheng` == this.tableName) {
				this.$message.error(`姓名不能为空`);
				return
			}
			if ((!this.ruleForm.mima) && `xuesheng` == this.tableName) {
				this.$message.error(`密码不能为空`);
				return
			}
			if ((this.ruleForm.mima != this.ruleForm.mima2) && `xuesheng` == this.tableName) {
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if (`xuesheng` == this.tableName && this.ruleForm.youxiang && (!this.$validate.isEmail(this.ruleForm.youxiang))) {
				this.$message.error(`邮箱应输入邮件格式`);
				return
			}
			if (`xuesheng` == this.tableName && this.ruleForm.shouji && (!this.$validate.isMobile(this.ruleForm.shouji))) {
				this.$message.error(`手机应输入手机格式`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
.el-radio__input.is-checked .el-radio__inner {
	border-color: #00c292;
	background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
	border-color: #00c292;
	background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
	border-color: #00c292;
	background: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
	color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
	color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
	color: #00c292;
}

.h1 {
	margin-top: 10px;
}

body {
	padding: 0;
	margin: 0;
}

.nk-navigation {
	margin-top: 15px;

	a {
		display: inline-block;
		color: #fff;
		background: rgba(255, 255, 255, .2);
		width: 100px;
		height: 50px;
		border-radius: 30px;
		text-align: center;
		display: flex;
		align-items: center;
		margin: 0 auto;
		justify-content: center;
		padding: 0 20px;
	}

	.icon {
		margin-left: 10px;
		width: 30px;
		height: 30px;
	}
}

.register-container {
	margin-top: 10px;

	a {
		display: inline-block;
		color: #fff;
		max-width: 500px;
		height: 50px;
		border-radius: 30px;
		text-align: center;
		display: flex;
		align-items: center;
		margin: 0 auto;
		justify-content: center;
		padding: 0 20px;

		div {
			margin-left: 10px;
		}
	}
}

.container {
	height: 100vh;
	background-position: center center;
	background-size: cover;
	background-repeat: no-repeat;
	background-color: rgba(255,126,18,0.1);
	color: black;

	.login-form {
		right: 50%;
		top: 50%;
		transform: translate3d(50%, -50%, 0);
		border-radius: 10px;
		background-color: rgba(220, 182, 110, 0.4);
		font-size: 14px;
		font-weight: 500;
		box-sizing: border-box;

		width: 360px;
		height: auto;
		padding: 15px;
		margin: 0 auto;
		border-radius: 10px;
		border-width: 0;
		border-style: solid;
		border-color: rgba(255, 0, 0, 0);
		background-color: rgba(220, 182, 110, 0.4);
		box-shadow: 0 0 6px rgba(255, 0, 0, .1);

		.h1 {
			width: 100%;
			height: auto;
			line-height: auto;
			color: black;
			font-size: 24px;
			padding: 0;
			margin: 0 auto;
			border-radius: 0;
			border-width: 0;
			border-style: solid;
			border-color: rgba(255, 0, 0, 0);
			background-color: rgba(255, 0, 0, 0);
			box-shadow: 0 0 6px rgba(255, 0, 0, 0);
			text-align: center;
		}

		.rgs-form {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;

			.el-form-item {
				width: 100%;
				display: flex;

				& /deep/ .el-form-item__content {
					flex: 1;
					display: flex;
				}
			}

			.input {
				width: 100%;
				height: auto;
				padding: 0;
				margin: 0 0 12px 0;
				border-radius: 0;
				border-width: 0;
				border-style: solid;
				border-color: rgba(255, 0, 0, 0);
				background-color: rgba(255, 0, 0, 0);
				box-shadow: 0 0 6px rgba(255, 0, 0, 0);

				& /deep/ .el-form-item__label {
					width: 84px;
					line-height: 44px;
					color: black;
					font-size: #606266;
					padding: 0 10px 0 0;
					margin: 0;
					border-radius: 0;
					border-width: 0;
					border-style: solid;
					border-color: rgba(255, 0, 0, 0);
					background-color: rgba(255, 0, 0, 0);
					box-shadow: 0 0 6px rgba(255, 0, 0, 0);
				}

				& /deep/ .el-input__inner {
					width: 100%;
					height: 38px;
					line-height: 38px;
					color: black;
					font-size: 14px;
					padding: 0 12px;
					margin: 0;
					border-radius: 4px;
					border-width: 1px;
					border-style: solid;
					border-color: rgba(236, 236, 255, 1);
					background-color: #fff;
					box-shadow: 0 0 6px rgba(255, 0, 0, 0);
					text-align: left;
				}
			}

			.send-code {
				& /deep/ .el-input__inner {
					width: 180px;
					height: 44px;
					line-height: 44px;
					color: #606266;
					font-size: 14px;
					padding: 0 12px;
					margin: 0;
					border-radius: 0;
					border-width: 1;
					border-style: solid;
					border-color: #606266;
					background-color: #fff;
					box-shadow: 0 0 6px rgba(255, 0, 0, 0);
					text-align: left;
				}

				.register-code {
					margin: 0;
					padding: 0;
					width: 86px;
					height: 44px;
					line-height: 44px;
					color: #fff;
					font-size: 14px;
					border-width: 0;
					border-style: solid;
					border-color: rgba(255, 0, 0, 0);
					border-radius: 0;
					background-color: rgb(64, 158, 255);
					box-shadow: 0 0 6px rgba(255, 0, 0, 0);
				}
			}

			.btn {
				margin: 0 10px;
				padding: 0;
				width: 88px;
				height: 44px;
				line-height: 44px;
				color: #fff;
				font-size: 14px;
				border-width: 0px;
				border-style: solid;
				border-color: #409EFF;
				border-radius: 4px;
				background-color: rgba(255, 106, 0, 1);
				box-shadow: 0 0 6px rgba(255, 0, 0, 0);
			}

			.close {
				margin: 0 10px;
				padding: 0;
				width: 88px;
				height: 44px;
				line-height: 44px;
				color: #409EFF;
				font-size: 14px;
				border-width: 1px;
				border-style: solid;
				border-color: #409EFF;
				border-radius: 4px;
				background-color: #FFF;
				box-shadow: 0 0 6px rgba(255, 0, 0, 0);
			}

		}
	}
}
</style>
