<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- JSTL 核心标签库 -->
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

    <title>我的预约</title>
</head>

<style>
    body {
        background-color: #f1f6f4;
    }

    .item {
        margin-top: 0px;
        margin-right: 0px;
    }
</style>
</style>


<body>
    <div id="vue_5">
        <el-container>
            <el-header>
                <el-row :gutter="20">
                    <el-col :span="2">
                        <div></div>&nbsp;
                    </el-col>
                    <el-col :span="20">
                        <div>
                            <el-card class="box-card" style="width: 100%;">
                                <p>你好！${name}<span style="float: right;">
                                        <el-button type="success" plain @click="comhome()">主页</el-button>
                                        <el-button type="primary" plain @click="book()">继续预约</el-button>
                                        <el-button type="warning" plain @click="exit()">退出</el-button>
                                    </span>
                                </p>
                            </el-card>
                        </div>
                    </el-col>
                    <el-col :span="2">
                        <div>&nbsp;</div>
                    </el-col>
                </el-row>
            </el-header>
            <br><br>
            <el-main>
                <el-row :gutter="20">
                    <el-col :span="2">
                        <div>&nbsp;</div>
                    </el-col>
                    <el-col :span="20">
                        <div>

                            <el-card class="box-card" style="width: 100%;">

                                <p>待审核:&nbsp;{{tableData1.length}}</p>


                                <el-table :data="tableData1 " height="300" border style="width: 100%">
                                    <el-table-column fixed prop="date" label="日期" width="120">
                                    </el-table-column>
                                    <el-table-column prop="testName" label="实验名称" width="200">
                                    </el-table-column>
                                    <el-table-column prop="clazz" label="班级" width="100">
                                    </el-table-column>
                                    <el-table-column prop="lbId" label="实验室编号" width="100">
                                    </el-table-column>
                                    <el-table-column prop="lbAddress" label="地址" width="240">
                                    </el-table-column>
                                    <el-table-column prop="type" label="实验类型" width="120">
                                    </el-table-column>
                                    <el-table-column prop="classTime" label="节次" width="110">
                                    </el-table-column>
                                    <el-table-column fixed="right" label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button @click="handleClick(scope.row)" type="text" size="small">查看
                                            </el-button>
                                            <el-button @click="handleClick2(scope.row)" type="text" size="small">撤销
                                            </el-button>
                                        </template>
                                    </el-table-column>
                                </el-table>
                                <p>预约结果</p>
                                <el-table :data="tableData2" height="300" border style="width: 100%">
                                    <el-table-column fixed prop="date" label="日期" width="120">
                                    </el-table-column>
                                    <el-table-column prop="testName" label="实验名称" width="150">
                                    </el-table-column>
                                    <el-table-column prop="clazz" label="班级" width="100">
                                    </el-table-column>
                                    <el-table-column prop="lbId" label="实验室编号" width="100">
                                    </el-table-column>
                                    <el-table-column prop="lbAddress" label="地址" width="200">
                                    </el-table-column>
                                    <el-table-column prop="type" label="实验类型" width="120">
                                    </el-table-column>
                                    <el-table-column prop="classTime" label="节次" width="100">
                                    </el-table-column>
                                    <el-table-column prop="result" label="结果" width="100"> 
                                    </el-table-column>
                                    <el-table-column fixed="right" label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button @click="handleClick(scope.row)" type="text" size="small">查看
                                            </el-button>
                                            <el-button @click="handleClick3(scope.row)" type="text" size="small">撤销
                                            </el-button>
                                        </template>
                                    </el-table-column>
                                </el-table>
                            </el-card>

                        </div>
                    </el-col>
                    <el-col :span="2">
                        <div>&nbsp;</div>
                    </el-col>
                </el-row>
            </el-main>
            <!-- 侧边栏 -->
            <el-drawer title="详情" :visible.sync="drawer" :with-header="false">
                <div>
                    <h1 style="text-align: center;">详细信息</h1>
                    <p>&nbsp;日期：{{datashow.date}}</p>
                    <p>&nbsp;时间：{{datashow.classTime}}</p>
                    <p>&nbsp;实验室编号：{{datashow.lbId}}</p>
                    <p>&nbsp;地址：{{datashow.lbAddress}}</p>
                    <p>&nbsp;姓名：{{datashow.name}}</p>
                    <p>&nbsp;学号：{{datashow.id}}</p>
                    <p>&nbsp;校园网：false</p>
                    <p>&nbsp;实验类型：{{datashow.type}}</p>
                    <p>&nbsp;形式：{{datashow.equipment}}</p>
                    <p>&nbsp;状态：<span style="color: red;">{{datashow.result}}</span></p>
                    <p>&nbsp;批复：{{datashow.description}}</p>
                </div>
            </el-drawer>

        </el-container>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>

<script type="text/javascript">
    var vm = new Vue({
        el: '#vue_5',
        data: {
            loading: true,
            identity: '同学',
            name: '侯志乾',
            drawer: false, //侧边栏
            dialogVisible: false, //弹框
            now: '',
            datashow: [{
                date1: 'test',
                name: 'test',
                number: 'test',
                class: 'test',
                testname: 'test',
                region: 'test',
                address: 'test',
                date2: 'test',
                input: 'test',
                net: false,
                resource: 'test',
                desc: 'test'
            }],
            tableData1: [{
                date1: '2016-05-02',
                name: '黄成怡',
                number: '201612010309',
                class: '信科3班',
                testname:'观察草履虫',
                region: '10013',
                address: '数信院楼201实验室',
                date2: '7，8节',
                result: '未审核',
                input: '',
                net: true,
                resource: '课程实验',
                desc: '参照书本'
            }, {
                date1: '2016-05-02',
                name: '黄成怡',
                number: '201612010309',
                class: '信科3班',
                testname:'解剖草履虫',
                region: '10013',
                address: '数信院楼201实验室',
                date2: '7，8节',
                result: '未审核',
                input: '',
                net: false,
                resource: '课程实验',
                desc: '先这样再这样'
            }],
            tableData2: [{
                date1: '2016-05-02',
                name: '黄成怡',
                number: '201612010309',
                class: '信科3班',
                testname:'观察草履虫',
                region: '10013',
                address: '数信院楼201实验室',
                date2: '7，8节',
                result: '通过',
                input: '同意',
                net: false,
                resource: '课程实验',
                desc: '参照书本'
            }, {
                date1: '2016-05-02',
                name: '黄成怡',
                number: '201612010309',
                class: '信科3班',
                testname:'观察草履虫',
                region: '10013',
                address: '数信院楼201实验室',
                date2: '7，8节',
                result: '未通过',
                input: '你解剖一个试试',
                net: false,
                resource: '课程实验',
                desc: '参照书本'
            }]
        },
        methods: {
            handleClick(row) {
                console.log(row);
                this.datashow = row;
                this.drawer = true;
            },
            handleClick2(row) { //通过
                console.log(row);
                axios.post("cancelServlet?lbId="+row.lbId+"&classTime="+row.classTime+"&date="+row.date
						+"&option=1");
		          axios.get('studentAppointServlet', {
		            params: {}
		          })
		          .then((response) => {
		            this.site = response.data;
		            this.tableData1 = this.site
		          })
		          .catch((error) => {
		            console.log(error);
		          });
                alert('撤销成功');
            },
            handleClick3(row) { //撤销
                console.log(row);
                this.$confirm('此操作将撤销, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    //在这里通过axios请求撤销该请求
					axios.post("cancelServlet?lbId="+row.lbId+"&classTime="+row.classTime+"&date="+row.date
							+"&option=2");
			          axios.get('studentAppointServlet2', {
			            params: {}
			          })
			          .then((response) => {
			            this.site = response.data;
			            this.tableData2 = this.site
			          })
			          .catch((error) => {
			            console.log(error);
			          });
                    this.$message({
                        type: 'success',
                        message: '撤销成功!'
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消操作'
                    });
                });
            },
            book() { //马上预约
            	window.location.href="query.jsp";
            },
            exit() { //退出登陆
            	window.open("index.jsp");
            	window.opener = null;
            	window.open('', '_self');
            	window.close();
            },
            comhome() { //跳转回到主页
            	window.location.href="index.jsp";
            }
        },
        created() {//创建时自动更新数据表，端口为模拟数据，请改正端口输出数据格式为请在控制台查看
            axios.get('studentAppointServlet', {
            params: {}
          })
          .then((response) => {
            console.log(response.data)
            this.site = response.data;
            this.tableData1 = this.site
          })
          .catch((error) => {
            console.log(error);
          });
          axios.get('studentAppointServlet2', {
            params: {}
          })
          .then((response) => {
            this.site = response.data;
            this.tableData2 = this.site
          })
          .catch((error) => {
            console.log(error);
          });
        },
    })
</script>


</html>