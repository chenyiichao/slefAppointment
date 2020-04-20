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
   <!--  <link rel="stylesheet" href="./css/index.css"> -->
    
    <!-- 引入组件库 -->
    <title>管理员审批</title>
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
    <div id="vue_2">
        <el-container>
            <el-header>
                <el-row :gutter="20">
                    <el-col :span="2">
                        <div></div>&nbsp;
                    </el-col>
                    <el-col :span="20">
                        <div>
                            <el-card class="box-card" style="width: 100%;">
                                <p>你好！${sessionScope.name}{{identity}}<span style="float: right;">
                                        <el-button type="success" plain @click="comhome()">主页</el-button>
                                        <el-button type="success" plain @click="gonext()">管理实验室</el-button>
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
                                <el-table :data="tableData1" height="300" border style="width: 100%" >
                                    <el-table-column fixed prop="date" label="日期" width="150"> 
                                    </el-table-column>
                                    <el-table-column prop="name" label="姓名" width="120">
                                    </el-table-column>
                                    <el-table-column prop="id" label="学号" width="120">
                                    </el-table-column>
                                    <el-table-column prop="clazz" label="班级" width="120">
                                    </el-table-column>
                                    <el-table-column prop="lbAddress" label="实验室" width="200">
                                    </el-table-column>
                                    <el-table-column prop="lbId" label="实验室编号" width="100">
                                    </el-table-column>
                                    <el-table-column prop="classTime" label="节次" width="80">
                                    </el-table-column>
                                    <el-table-column fixed="right" label="操作" width="140">
                                        <template slot-scope="scope">
                                            <el-button @click="handleClick(scope.row)" type="text" size="small">详细
                                            </el-button>
                                            <el-button @click="handleClick2(scope.row)" type="text" size="small">通过
                                            </el-button>
                                            <el-button @click="handleClick3(scope.row)" type="text" size="small">拒绝
                                            </el-button>
                                        </template>
                                    </el-table-column>
                                </el-table> 
                                <p>预约结果
	                                <span style="float: right;">
                                        <el-select v-model="label" placeholder="请选择">
                                            <el-option v-for="item in options" :key="item.value" :label="item.label"
                                                :value="item.label">
                                            </el-option>
                                        </el-select>
                                        <el-button type="success" plain @click="selectit()">确定</el-button>
                                    </span>
	                             </p>
                                <el-table :data="tableData2" height="300" border style="width: 100%">
                                    <el-table-column fixed prop="date" label="日期" width="150">
                                    </el-table-column>
                                    <el-table-column prop="name" label="姓名" width="120">
                                    </el-table-column>
                                    <el-table-column prop="id" label="学号" width="120">
                                    </el-table-column>
                                    <el-table-column prop="clazz" label="班级" width="120">
                                    </el-table-column>
                                    <el-table-column prop="lbAddress" label="实验室" width="220">
                                    </el-table-column>
                                    <el-table-column prop="lbId" label="实验室编号" width="100">
                                    </el-table-column>
                                    <el-table-column prop="classTime" label="节次" width="80">
                                    </el-table-column>
                                    <el-table-column prop="result" label="审核结果" width="120">
                                    </el-table-column>
                                    <el-table-column fixed="right" label="操作" width="100">
                                        <template slot-scope="scope">
                                            <el-button @click="handleClick(scope.row)" type="text" size="small">查看
                                            </el-button>
                                            <el-button @click="handleClick4(scope.row)" type="text" size="small">重审
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
                    <p>&nbsp;实验室类型：{{datashow.type}}</p>
                    <p>&nbsp;地址：{{datashow.lbAddress}}</p>
                    <p>&nbsp;姓名：{{datashow.name}}</p>
                    <p>&nbsp;学号：{{datashow.id}}</p>
                    <p>&nbsp;校园网：false</p>
                    <p>&nbsp;实验类型：{{datashow.testType}}</p>
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
        el: '#vue_2',
        data: {
            loading: true,
            identity: '管理员',
            //name: '陈逸超',
            drawer: false, //侧边栏
            dialogVisible: false, //弹框
            now: '',
            datashow: [],
            tableData1: [],
            tableData2: [],
            options: [{
                value: '0',
                label: '全部'
            },{
                value: '1',
                label: '多媒体公共实验室'
            }, {
                value: '2',
                label: '化学实验室'
            }, {
                value: '3',
                label: '工程实验室'
            }, {
                value: '4',
                label: '生物实验室'
            }, {
                value: '5',
                label: '计算机实验室'
            }],
            label: ""
        },
        methods: {
            handleClick(row) {
                console.log(row);
                this.datashow = row;
                this.drawer = true;
            },
            handleClick2(row) { //通过，将这条数据更新到已审核
                console.log(row);
				//window.location.href='checkingToCheckedServlet?lbId='+row.lbId+'&classTime='+row.classTime+'&date='+row.date
        		+"&result=通过"+"&description=通过";
				axios.post('checkingToCheckedServlet?lbId='
						+row.lbId+'&classTime='+row.classTime+'&date='
						+row.date+"&result=通过"+"&description=通过")
             	this.update() 
            },
            handleClick3(row) { //拒绝，通过将这条数据更新到已审核
                console.log(row);
                this.$prompt('请输入批复备注', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                }).then(({
                    value
                }) => {
                    this.$message({
                        type: 'success',
                        message: '你的批复是: ' + value
                    });
                    row.input = value;
                    console.log(row);  
                    axios.post('checkingToCheckedServlet?lbId='
                    		+row.lbId+'&classTime='+row.classTime+'&date='
                    		+row.date+"&result=未通过"+'&description='+value)
                 	this.update() 
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消输入'
                    });
                });
            },
            handleClick4(row) { //重审，将这条数据返回到未审核
                console.log(row);
                //'checkedTocheckingServlet?lbId='+row.lbId+'&classTime='+row.classTime+'&date='+row.date
                axios.post('checkedTocheckingServlet?lbId='
                		+row.lbId+'&classTime='+row.classTime+'&date='+row.date)
             	this.update() 
             	console.log("123")
            	/* .then((response) => {
                    this.tableData1 = response.data;
                })
                .catch((error) => {
                  console.log(error);
                }); */
                //window.location.href = 'checkedTocheckingServlet?lbId='+row.lbId+'&classTime='+row.classTime+'&date='+row.date;
                
            },
            gonext(){//跳转到实验室管理页
            	window.location.href="manageLaboratory.jsp";
            },
            exit() { //退出
				window.open("logoutServlet");
            	window.opener = null;
            	window.open('', '_self');
            	window.close();
            },
            comhome() { //回到主页
            	window.location.href="index.jsp";
            },
            selectit(){
            	console.log('asd')
            	axios.post('selectServlet?type='+this.label)
            	.then((response) => {
                    this.tableData2 = response.data;
                })
                .catch((error) => {
                  console.log(error);
                });
            },
            update(){
            	axios.post('checkServlet?option=1')
            	.then((response) => {
                    this.tableData1 = response.data;
                    console.log(response.data)
                    console.log("123456")
                })
                .catch((error) => {
                  console.log(error);
                });
                axios.post('checkServlet?option=2')
                .then((response) => {
                  this.tableData2 = response.data
                  console.log(response.data)
                  console.log("654321")
                })
                .catch((error) => {
                  console.log(error);
                });  
            }
        },
        created() {
        	console.log("asd")
        	this.update()
        }
    })
</script>
</html>