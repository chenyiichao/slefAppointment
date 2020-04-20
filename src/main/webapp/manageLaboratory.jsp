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

    <title>实验室管理</title>
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
                                        <el-button type="success" plain @click="approval()">审批申请</el-button>
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

                                <p>实验室管理:&nbsp;{{tableData1.length}} <span style="float: right;">
                                        <el-button type="success" plain @click="add()">添加</el-button>
                                    </span></p>


                                <el-table :data="tableData1 " height="300" border style="width: 100%">
                                    <el-table-column fixed prop="lbId" label="实验室编号">
                                    </el-table-column>
                                    <el-table-column prop="name" label="实验室">
                                    </el-table-column>
                                    <el-table-column prop="lbAddress" label="地址">
                                    </el-table-column>
                                    <el-table-column prop="type" label="实验室类型">
                                    </el-table-column>
                                    <el-table-column prop="volume" label="容纳人数">
                                    </el-table-column>
                                    <el-table-column fixed="right" label="操作">
                                        <template slot-scope="scope">
                                            <el-button @click="handleClick1(scope.row)" type="text" size="small">禁用
                                            </el-button>
                                            <el-button @click="handleClick2(scope.row)" type="text" size="small">删除
                                            </el-button>
                                            <el-button @click="modify(scope.row)" type="text" size="small">编辑
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
            <!-- 添加 -->
            <el-drawer title="添加" :visible.sync="drawer" :with-header="false">
                <div>
                    <h1 style="text-align: center;">添加实验室</h1>
                    &nbsp;<p>请输入实验室名字</p>
                    &nbsp;<el-input placeholder="请输入实验室名字" v-model="adddata.name" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>请输入实验室编号</p>
                    &nbsp;<el-input placeholder="请输入实验室编号" v-model="adddata.lbId" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>请输入实验室地址</p>
                    &nbsp;<el-input placeholder="请输入实验室地址" v-model="adddata.lbAddress" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>请输入实验室类型</p>
                    &nbsp;<el-input placeholder="请输入实验室类型" v-model="adddata.type" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>实验室描述</p>
                    &nbsp;<el-input placeholder="请输入实验室描述" v-model="adddata.description" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>请输入可容纳人数</p>
                    &nbsp;<el-input placeholder="请输入可容纳人数" v-model="adddata.volume" style="width:80%" clearable>
                    </el-input>
                    <br>
                    <p style="text-align: center;">
                        <el-button @click="handleClick3()" type="success" plain>添加
                        </el-button>
                    </p>
                </div>
            </el-drawer>
            <!-- 禁用 -->
            <el-drawer title="禁用" :visible.sync="drawer2" :with-header="false">
                <div>
                    <p style="text-align: center;">请选择日期：</p>
                    <el-select v-model="date" placeholder="请选择实验日期" style="width: 80%;">
                        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                    <br>
                    <p style="text-align: center;">请选择时间：</p>
                    <el-select v-model="classTime" placeholder="请选择实验时间" style="width: 80%;">
                        <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                    <p style="text-align: center;">
                        <el-button type="warning" plain @click="ban()">确定禁用</el-button>
                    </p>

                </div>
            </el-drawer>
            <!--编辑-->
            <el-drawer title="编辑" :visible.sync="drawer3" :with-header="false">
                <div>
                    <h1 style="text-align: center;">编辑实验室</h1>
                    &nbsp;<p>实验室名字</p>
                    &nbsp;<el-input v-model="changedata.name" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>实验室编号</p>
                    &nbsp;<el-input v-model="changedata.lbId" style="width:80%" :disabled="true">
                    </el-input>
                    &nbsp;<p>实验室地址</p>
                    &nbsp;<el-input v-model="changedata.lbAddress" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>实验室类型</p>
                    &nbsp;<el-input v-model="changedata.type" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>实验室描述</p>
                    &nbsp;<el-input v-model="changedata.description" style="width:80%" clearable>
                    </el-input>
                    &nbsp;<p>可容纳人数</p>
                    &nbsp;<el-input v-model="changedata.volume" style="width:80%" clearable>
                    </el-input>
                    <br>
                    <p style="text-align: center;">
                        <el-button @click="handleClick4()" type="success" plain>确定
                        </el-button>
                    </p>
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
            name: '陈逸超',
            drawer: false, //侧边栏
            drawer2: false, //侧边栏，
            drawer3: false, //侧边栏，
            date: '',
            classTime: '',
            lbId: '',
            adddata: [{
                name: '',
                lbId: '',
                lbAddress: '',
                type: '',
                description: '',
                volume: ''
            }],
            changedata: [{
                name: '公共实验室201',
                lbId: '2020201',
                lbAddress: '数信院楼201实验室',
                type: '计算机实验室',
                description: '适合做计算机实验，提供计算机',
                volume: '10'
            }],
            tableData1: [{
                name: '公共实验室201',
                lbId: '2020201',
                lbAddress: '数信院楼201实验室',
                type: '生物实验室',
                description: '适合做生物实验，具备生物实验器械',
                volume: '10'
            }, {
                name: '公共实验室202',
                lbId: '2020202',
                lbAddress: '数信院楼202实验室',
                type: '化学实验室',
                description: '适合做化学实验，提供化学仪器，实验原料需申请',
                volume: '10'
            }, {
                name: '公共实验室203',
                lbId: '2020204',
                lbAddress: '数信院楼204实验室',
                type: '工程实验室',
                description: '多功能工程实验室，具备大型加功仪器，适合做工程实验',
                volume: '10'
            }, {
                name: '公共实验室204',
                lbId: '2020204',
                lbAddress: '数信院楼204实验室',
                type: '多媒体公共实验室',
                description: '适合做实验汇报',
                volume: '10'
            }, {
                name: '公共实验室205',
                lbId: '2020205',
                lbAddress: '数信院楼205实验室',
                type: '地理实验室',
                description: '适合做地理实验',
                volume: '10'
            }],
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
            handleClick1(row) { //禁止该实验室，通过axios更新数据库
                console.log(row);
                this.drawer2 = true;
                this.lbId = row.lbId;
                 
            },
            handleClick2(row) {//删除实验室，通过axios更新数据库
                console.log(row);
                axios.post('laboratoryServlet?lbId='+row.lbId+'&operation=delete');
                window.location.href="manageLaboratory.jsp";
            },
            handleClick3() { //添加//通过axios更新数据库
                let a = {
                    name: '公共实验室205',
                    lbId: '2020205',
                    lbAddress: '数信院楼205实验室',
                    type: '常规实验室',
                    description: '',
                    volume: '10'
                }
                a.name = this.adddata.name;
                a.lbId = this.adddata.lbId;
                a.type = this.adddata.type;
                a.volume = this.adddata.volume;
                a.description = this.adddata.description;
                a.lbAddress = this.adddata.lbAddress;
                this.tableData1.push(a);
                axios.post('laboratoryServlet?lbId='+a.lbId+'&operation=add&lbAddress='+a.lbAddress
                		+'&type='+a.type+'&description='+a.description+'&volume='+a.volume+'&name='+a.name);
                this.drawer = false;
            },
            handleClick4() { 
                //编辑//更新到数据库
                //与modify联动，这里要将修改保存到数据库
                console.log('aaa');
                console.log(this.changedata);
                //alert('aaaa');
                axios.post('laboratoryServlet?lbId='+this.changedata.lbId+'&operation=update&lbAddress='+this.changedata.lbAddress
                		+'&type='+this.changedata.type+'&description='+this.changedata.description+'&volume='+this.changedata.volume
                		+'&name='+this.changedata.name);
                this.drawer3 = false;
                
            },

            add() { //添加新实验室，打开侧边栏
                this.drawer = true;
                
            },
            modify(row) { //编辑实验室，打开侧边栏
            //可以对信息进行编辑
            //点击确定跳转到handleClick4（）这个时候要将信息发回到后台
                this.drawer3 = true;
                this.changedata=row;
                
            },
            exit() { //退出
            	window.open("index.jsp");
            	window.opener = null;
            	window.open('', '_self');
            	window.close();
            },
            ban() { //确定禁用
                //通过更新数据库占用该日期该节次
                this.drawer2 = false;
                console.log(this.date, this.classTime, this.lbId)
                axios.post('laboratoryServlet?lbId='+this.lbId+'&operation=ban&classTime='+this.classTime+'&date='+this.date);
                this.date = ''; //获取禁用日期
                this.classTime = ''; //获取禁用时间
                this.lbId = ''; //获取需要禁止的实验室 
            },
            comhome() { //回到主页
            	window.location.href="index.jsp";
                //alert('回主页');
            },
            approval() { //回申请表
            	window.location.href="admin.jsp";
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
                dateoptions[i].value = y + "-" + m + "-" + d
                dateoptions[i].label = y + "-" + m + "-" + d
            }
            this.options = dateoptions
            //创建时自动更新数据表，端口为模拟数据，请改正端口输出数据格式为请在控制台查看

                axios.get('queryLaboratoryServlet', {
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
               /* axios.get('http://localhost:3400/course2', {
                 params: {}
               })
               .then((response) => {
                 this.site = response.data;
                 this.tableData2 = this.site
               })
               .catch((error) => {
                 console.log(error);
               }); */
        },
    })
</script>


</html>