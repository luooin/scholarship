<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="学号" prop="xuehao">
          <el-input v-model="ruleForm.xuehao" 
              placeholder="学号" clearable  :readonly="ro.xuehao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="学号" prop="xuehao">
              <el-input v-model="ruleForm.xuehao" 
                placeholder="学号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming" 
              placeholder="学生姓名" clearable  :readonly="ro.xueshengxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="学生姓名" prop="xueshengxingming">
              <el-input v-model="ruleForm.xueshengxingming" 
                placeholder="学生姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="学院" prop="xueyuan">
          <el-input v-model="ruleForm.xueyuan" 
              placeholder="学院" clearable  :readonly="ro.xueyuan"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="学院" prop="xueyuan">
              <el-input v-model="ruleForm.xueyuan" 
                placeholder="学院" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="系别" prop="xibie">
          <el-input v-model="ruleForm.xibie" 
              placeholder="系别" clearable  :readonly="ro.xibie"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="系别" prop="xibie">
              <el-input v-model="ruleForm.xibie" 
                placeholder="系别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="年份" prop="nianfen">
          <el-input v-model="ruleForm.nianfen" 
              placeholder="年份" clearable  :readonly="ro.nianfen"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="年份" prop="nianfen">
              <el-input v-model="ruleForm.nianfen" 
                placeholder="年份" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="班级" prop="banji">
          <el-input v-model="ruleForm.banji" 
              placeholder="班级" clearable  :readonly="ro.banji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="班级" prop="banji">
              <el-input v-model="ruleForm.banji" 
                placeholder="班级" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="年级" prop="nianji">
          <el-select :disabled="ro.nianji" v-model="ruleForm.nianji" placeholder="请选择年级">
            <el-option
                v-for="(item,index) in nianjiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="年级" prop="nianji">
	      <el-input v-model="ruleForm.nianji"
                placeholder="年级" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="学期" prop="xueqi">
          <el-select :disabled="ro.xueqi" v-model="ruleForm.xueqi" placeholder="请选择学期">
            <el-option
                v-for="(item,index) in xueqiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="学期" prop="xueqi">
	      <el-input v-model="ruleForm.xueqi"
                placeholder="学期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="总成绩" prop="zongchengji">
          <el-input v-model="ruleForm.zongchengji" 
              placeholder="总成绩" clearable  :readonly="ro.zongchengji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="总成绩" prop="zongchengji">
              <el-input v-model="ruleForm.zongchengji" 
                placeholder="总成绩" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="学分绩点" prop="xuefenjidian">
          <el-input v-model="ruleForm.xuefenjidian" 
              placeholder="学分绩点" clearable  :readonly="ro.xuefenjidian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="学分绩点" prop="xuefenjidian">
              <el-input v-model="ruleForm.xuefenjidian" 
                placeholder="学分绩点" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="评优权重" prop="pingyouquanzhong">
          <el-input v-model="ruleForm.pingyouquanzhong" 
              placeholder="评优权重" clearable  :readonly="ro.pingyouquanzhong"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="评优权重" prop="pingyouquanzhong">
              <el-input v-model="ruleForm.pingyouquanzhong" 
                placeholder="评优权重" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="评优分值" prop="pingyoufenzhi">
            <el-input v-model="pingyoufenzhi"
                placeholder="评优分值" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.pingyoufenzhi" label="评优分值" prop="pingyoufenzhi">
              <el-input v-model="ruleForm.pingyoufenzhi" 
                placeholder="评优分值" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="登记时间" prop="dengjishijian">
          <el-input v-model="ruleForm.dengjishijian" 
              placeholder="登记时间" clearable  :readonly="ro.dengjishijian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="登记时间" prop="dengjishijian">
              <el-input v-model="ruleForm.dengjishijian" 
                placeholder="登记时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="学期评语" prop="xueqipingyu">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="学期评语"
                  v-model="ruleForm.xueqipingyu" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xueqipingyu" label="学期评语" prop="xueqipingyu">
                    <span>{{ruleForm.xueqipingyu}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(131, 138, 182, 1)","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(255, 106, 0, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"rgba(236, 236, 255, 1)","btnCancelBgColor":"rgba(255, 255, 255, 1)","selectLableColor":"rgba(131, 138, 182, 1)","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(236, 236, 255, 1)","btnCancelHeight":"44px","inputHeight":"38px","btnCancelFontColor":"rgba(0, 0, 0, 1)","dateBorderColor":"rgba(236, 236, 255, 1)","dateIconFontColor":"rgba(0, 0, 0, 1)","uploadBorderStyle":"dashed","dateBorderStyle":"solid","dateLableColor":"rgba(131, 138, 182, 1)","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"38px","inputFontColor":"rgba(119, 122, 178, 1)","uploadHeight":"148px","textareaLableColor":"rgba(131, 138, 182, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"rgba(255, 255, 255, 1)","inputLableFontSize":"14px","uploadLableColor":"rgba(131, 138, 182, 1)","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"38px","selectBorderColor":"rgba(236, 236, 255, 1)","inputBorderColor":"rgba(236, 236, 255, 1)","uploadBorderColor":"rgba(236, 236, 255, 1)","textareaFontColor":"rgba(119, 122, 178, 1)","selectBorderWidth":"1px","dateFontColor":"rgba(119, 122, 178, 1)","btnCancelBorderWidth":"0px","uploadBorderWidth":"2px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"rgba(119, 122, 178, 1)","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	xuehao : false,
	xueshengxingming : false,
	xueyuan : false,
	xibie : false,
	nianfen : false,
	banji : false,
	nianji : false,
	xueqi : false,
	zongchengji : false,
	xuefenjidian : false,
	xueqipingyu : false,
	pingyouquanzhong : false,
	pingyoufenzhi : false,
	dengjishijian : false,
      },
      ruleForm: {
        xuehao: '',
        xueshengxingming: '',
        xueyuan: '',
        xibie: '',
        nianfen: '',
        banji: '',
        nianji: '',
        xueqi: '',
        zongchengji: '',
        xuefenjidian: '',
        xueqipingyu: '',
        pingyouquanzhong: '',
        pingyoufenzhi: '',
        dengjishijian: '',
      },
          nianjiOptions: [],
          xueqiOptions: [],
      rules: {
          xuehao: [
          ],
          xueshengxingming: [
          ],
          xueyuan: [
          ],
          xibie: [
          ],
          nianfen: [
          ],
          banji: [
          ],
          nianji: [
          ],
          xueqi: [
          ],
          zongchengji: [
                { validator: validateNumber, trigger: 'blur' },
          ],
          xuefenjidian: [
                { validator: validateNumber, trigger: 'blur' },
          ],
          xueqipingyu: [
          ],
          pingyouquanzhong: [
                { validator: validateNumber, trigger: 'blur' },
          ],
          pingyoufenzhi: [
                { validator: validateNumber, trigger: 'blur' },
          ],
          dengjishijian: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {


    pingyoufenzhi:{
      get: function () {
        return 1*this.ruleForm.zongchengji*this.ruleForm.pingyouquanzhong
      }
    },

  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='xuehao'){
            this.ruleForm.xuehao = obj[o];
	    this.ro.xuehao = true;
            continue;
          }
          if(o=='xueshengxingming'){
            this.ruleForm.xueshengxingming = obj[o];
	    this.ro.xueshengxingming = true;
            continue;
          }
          if(o=='xueyuan'){
            this.ruleForm.xueyuan = obj[o];
	    this.ro.xueyuan = true;
            continue;
          }
          if(o=='xibie'){
            this.ruleForm.xibie = obj[o];
	    this.ro.xibie = true;
            continue;
          }
          if(o=='nianfen'){
            this.ruleForm.nianfen = obj[o];
	    this.ro.nianfen = true;
            continue;
          }
          if(o=='banji'){
            this.ruleForm.banji = obj[o];
	    this.ro.banji = true;
            continue;
          }
          if(o=='nianji'){
            this.ruleForm.nianji = obj[o];
	    this.ro.nianji = true;
            continue;
          }
          if(o=='xueqi'){
            this.ruleForm.xueqi = obj[o];
	    this.ro.xueqi = true;
            continue;
          }
          if(o=='zongchengji'){
            this.ruleForm.zongchengji = obj[o];
	    this.ro.zongchengji = true;
            continue;
          }
          if(o=='xuefenjidian'){
            this.ruleForm.xuefenjidian = obj[o];
	    this.ro.xuefenjidian = true;
            continue;
          }
          if(o=='xueqipingyu'){
            this.ruleForm.xueqipingyu = obj[o];
	    this.ro.xueqipingyu = true;
            continue;
          }
          if(o=='pingyouquanzhong'){
            this.ruleForm.pingyouquanzhong = obj[o];
	    this.ro.pingyouquanzhong = true;
            continue;
          }
          if(o=='pingyoufenzhi'){
            this.ruleForm.pingyoufenzhi = obj[o];
	    this.ro.pingyoufenzhi = true;
            continue;
          }
          if(o=='dengjishijian'){
            this.ruleForm.dengjishijian = obj[o];
	    this.ro.dengjishijian = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
            this.nianjiOptions = "大一,大二,大三,大四".split(',')
            this.xueqiOptions = "上学期,下学期".split(',')
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `xueshengchengji/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.pingyoufenzhi = this.pingyoufenzhi





























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "xueshengchengji/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `xueshengchengji/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.xueshengchengjiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `xueshengchengji/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.xueshengchengjiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.xueshengchengjiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
