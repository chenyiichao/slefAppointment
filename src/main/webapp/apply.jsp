<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 核心标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <!-- 引入样式 -->
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <!-- 引入组件库 -->
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  <script src="https://unpkg.com/element-ui/lib/index.js"></script>
  <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>

  <title>实验室申请表</title>
</head>

<style>
  body {
    height: 780px;
    background: #f1f6f4 url(../images/header-image.jpg) no-repeat center;
    position: relative;
    padding: 1px 0 0 0;
  }
</style>


<body>
  <!--查询表格-->

  <div id="vue_3">
    <br>
    <section id="banner">
      <el-row :gutter="20">
        <!--布局-->
        <el-col :span="12" :offset="6">
          <div>
            <el-card class="box-card">
              <h2 style="text-align: center;">申请表填写</h2>
              <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="实验室编号" prop="region">
                  <el-input v-model="ruleForm.region" style="width: 300px;" placeholder="${lbId}"></el-input>
                </el-form-item>
                <el-form-item label="实验名称" prop="region">
                  <el-input v-model="ruleForm.testname" style="width: 300px;" ></el-input>
                </el-form-item>
                <el-form-item label="实验日期" prop="date1">
                  <el-select v-model="ruleForm.date1" placeholder="${date}" >
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" >
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="实验时间" prop="date2">
                  <el-select v-model="ruleForm.date2" placeholder="${classTime}">
                    <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>

                <el-form-item label="校园网" prop="net">
                  <el-switch v-model="ruleForm.net"></el-switch>
                </el-form-item>
                <el-form-item label="实验类型" prop="resource">
                  <el-radio-group v-model="ruleForm.resource">
                    <el-radio label="课程实验"></el-radio>
                    <el-radio label="实践作业"></el-radio>
                    <el-radio label="个人科研"></el-radio>
                    <el-radio label="其他（请在活动形式中说明）"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="实验形式" prop="desc">
                  <el-input type="textarea" v-model="ruleForm.desc"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="submitForm('ruleForm')">立即预约</el-button>
                  <el-button @click="resetForm('ruleForm')">重置</el-button>
                 <!--  <el-button @click="comeback()">返回</el-button> -->
                </el-form-item>
              </el-form>

            </el-card>
          </div>
        </el-col>
      </el-row>
    </section>
  </div>
</body>


<script type="text/javascript">
  var vm = new Vue({
    el: '#vue_3',
    data: {
      ruleForm: {
        testname: '',//实验名称
        region: '',//实验室编号
        date1: '',//实验日期
        date2: '',//实验时间
        net: false,//校园网
        resource: '',//实验类型
        desc: ''//实验形式
        //将该表单提交给后台，根据数据库中的实验室表完善信息传给未审核表
      },
      rules: {
        name: [{
          required: true,
          message: '内容不可为空',
          trigger: 'change'
        }],
        region: [{
          required: true,
          message: '内容不可为空',
          trigger: 'change'
        }],
        date1: [{
          required: true,
          message: '请选择日期',
          trigger: 'change'
        }],
        date2: [{
          required: true,
          message: '请选择时间',
          trigger: 'change'
        }],
        resource: [{
          required: true,
          message: '请选择活动资源',
          trigger: 'change'
        }],
        desc: [{
          required: true,
          message: '请填写活动形式',
          trigger: 'blur'
        }]
      },
      options: [{
        value: '2020-02-01',
        label: '2020-02-01'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-03',
        label: '2020-02-03'
      }, {
        value: '2020-02-04',
        label: '2020-02-04'
      }, {
        value: '2020-02-05',
        label: '2020-02-05'
      }],
      options2: [{
        value: '1,2节',
        label: '1,2节'
      }, {
        value: '3,4节',
        label: '3,4节'
      }, {
        value: '5,6节',
        label: '5,6节'
      }, {
        value: '7,8节',
        label: '7,8节'
      }, {
        value: '9,10节',
        label: '9,10节'
      }, {
        value: '11,12,13节',
        label: '11,12,13节'
      }]
    },

    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
   			alert('预约成功，等待管理员审核');
            console.log(this.ruleForm);
            // axios提交 
                axios.get('applyServlet?lbId='+this.ruleForm.region+"&testName="+this.ruleForm.testname+"&date="+
            		   this.ruleForm.date1+"&classTime="+this.ruleForm.date2+"&type="+this.ruleForm.resource+
            		   "&equipment="+this.ruleForm.desc, {
                   params: {}
                 })
                 .then((response) => {
                  console.log(response.data);
                   this.site = response.data;
                   this.tableData = this.site;
                 })
                 .catch((error) => {
                   console.log(error);
                 }); 
                 window.location.href = 'index.jsp';
           //  }
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      comeback(){
        alert("编写返回逻辑！")
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
      let dateoptions = [{
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }, {
        value: '2020-02-02',
        label: '2020-02-02'
      }]

      for (i = 0; i < dateoptions.length; i++) {
        var dd = new Date();
        dd.setDate(dd.getDate() + i); //获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth() + 1; //获取当前月份的日期
        var d = dd.getDate();
        dateoptions[i].value = y + "-" + m + "-" + d;
        dateoptions[i].label = y + "-" + m + "-" + d;
      }
      this.options = dateoptions;
    }
  })
</script>


</html>