<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>登陆</title>
</head>

<style>
    body {
        height: 780px;
        background: #f1f6f4 url(images/header-image.jpg) no-repeat center;
        position: relative;
        padding: 1px 0 0 0;
    }

    .box-card {
        width: 500px;
        margin: auto;
    }

    .box-card h1 {
        text-align: left;
        color: #409eff;
    }
</style>


<body>
<% 
   response.setHeader("Pragma","no-cache"); 
   response.setHeader("Cache-Control","no-cache"); 
   response.setDateHeader("Expires", 0); 
   response.setHeader("Cache-Control", "no-store"); 
%>
    <!--查询表格-->
    <div id="vue_4">
        <br>
        <section id="banner">
            <el-row :gutter="20">
                <!--布局-->
                <el-col :span="8" :offset="8">
                    <div>
                        <el-card class="box-card">
                            <el-alert title="初始账号为学号，密码为身份证后6位" type="error">
                            </el-alert>
                            <h2 style="text-align: center;">实验室自主科研预约系统</h2>
                            <el-form :label-position=labelPosition label-width="80px" :model="formLabelAlign">
                                <el-form-item label="账号：">
                                    <el-input v-model="formLabelAlign.userid" placeholder="请输入内容" clearable ></el-input>
                                </el-form-item>
                                <el-form-item label="密码：">
                                    <el-input placeholder="请输入密码" v-model="formLabelAlign.password" show-password>
                                    </el-input>
                                </el-form-item>
                                <font color="red">
									<%
										if(request.getAttribute("message")!= null){
											out.print(request.getAttribute("message"));
										}
									%>
								</font>
                                <el-form-item label="登陆者：">
                                    <el-radio v-model="formLabelAlign.type" label="1" >学生</el-radio>
                                    <el-radio v-model="formLabelAlign.type" label="2" >管理员</el-radio>
                                </el-form-item>
                                <div style="text-align: center;">
                                    <el-button type="primary" @click="submitForm()"> 立即登陆</el-button>
                                    <el-button @click="resetForm()">重置</el-button>
                                </div>
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
        el: '#vue_4',
        data: {
            labelPosition: 'left',
            formLabelAlign: {
                userid: '',
                password: '',
                type: '1'
            }

        },
        methods: {
            submitForm() {
                console.log(this.formLabelAlign)
                //alert('submit!');
                //alert(this.formLabelAlign.userid);
                window.location.href="loginServlet?userId="+this.formLabelAlign.userid+
                		"&password="+this.formLabelAlign.password+
                		"&label="+this.formLabelAlign.type;
            },
            changedate() {

            },
            resetForm() {
                this.formLabelAlign = {
                    userid: '',
                    password: '',
                    type: '1'
                }
            }
        },
        created() {

        }
    })
</script>


</html>