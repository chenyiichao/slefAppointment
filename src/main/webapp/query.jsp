<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <!-- 引入样式 -->
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <!-- 引入组件库 -->

  <title>查询空闲实验室</title>
</head>

<style>
  #banner {
    height: 780px;
    background: #f1f6f4 url(images/header-image.jpg) no-repeat center;
    position: relative;
    padding: 1px 0 0 0;
  }
</style>


<body>
  <!--查询表格-->

  <div id="vue_1">
    <section id="banner"><a name="home"></a>
      <h3>&nbsp;</h3>
      <el-row :gutter="20">
        <!--布局-->

        <el-col :span="13" :offset="5" id="try">
          <div>
            <el-select v-model="value" placeholder="请选择日期">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
            <el-select v-model="value2" placeholder="请选择节次">
              <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
            <el-button type="success" plain @click="search()">查询</el-button>
          </div>
          <br>
          <div class="grid-content bg-purple">
            <el-card class="box-card" style="width: 100%;">
              <div>
                <el-table :data="tableData" style="width: 100%" height="500">
                  <el-table-column label="日期" width="180">
                    <template slot-scope="scope">
                      <i class="el-icon-time"></i>
                      <span style="margin-left: 10px">{{ scope.row.date }}</span>
                    </template>
                  </el-table-column>
                  <el-table-column label="实验室" width="150">
                    <template slot-scope="scope">
                      <el-popover trigger="hover" placement="top">
                        <p>时间: {{ scope.row.classTime }}</p>
                        <p>实验室: {{ scope.row.name }}</p>
                        <p>可容纳: {{ scope.row.volume }}人</p>
                        <p>地址: {{ scope.row.lbAddress }}</p>
                        <div slot="reference" class="name-wrapper">
                          <el-tag size="medium">{{ scope.row.name }}</el-tag>
                        </div>
                      </el-popover>
                    </template>
                  </el-table-column>
                  <el-table-column label="实验室编号" width="150">
                    <template slot-scope="scope">
                      <span style="margin-left: 10px">{{ scope.row.lbId }}</span>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" width="200">
                    <template slot-scope="scope">
                      <el-button size="mini" type="success" @click="openbox(scope.$index, scope.row)"
                        style="width: 80px;">查看
                      </el-button>
                      <el-button size="mini" type="danger" @click="handlebook(scope.$index, scope.row)"
                        style="width: 80px;">预约
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>

              </div>
            </el-card>
          </div>
        </el-col>
      </el-row>
    </section>
  </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>

<script type="text/javascript">
  var vm = new Vue({
    el: '#vue_1',
    data: {
      tableData: [{
        date: "2020-02-18",
        time: "11、12、13节",
        name: '公共实验室101',
        number: '100001',
        volume: '5',
        describe: '适合做计算机实验，提供计算机',
        address: '数学与信息学院1楼101号'
      }, {
        date: "2020-02-18",
        time: "11、12、13节",
        name: '公共实验室102',
        number: '100002',
        volume: '5',
        describe: '适合做化学实验，提供化学仪器，实验原料需申请',
        address: '食品与药品学院2楼102号'
      }, {
        date: "2020-02-18",
        time: "11、12、13节",
        name: '公共实验室103',
        number: '100003',
        volume: '5',
        describe: '适合做演示和模拟，配备投影仪',
        address: '经济与管理学院1楼3号'
      }, {
        date: "2020-02-18",
        time: "11、12、13节",
        name: '公共实验室104',
        number: '100004',
        volume: '5',
        describe: '多功能工程实验室，具备大型加功仪器，适合做工程实验',
        address: '工程学院104号'
      }],
      site: '',
      url: "images/header-image.jpg",
      options: [{
        value: '2020-02-07',
        label: '2020-02-07'
      }, {
        value: '2020-02-08',
        label: '2020-02-08'
      }, {
        value: '2020-02-09',
        label: '2020-02-09'
      }, {
        value: '2020-02-10',
        label: '2020-02-10'
      }, {
        value: '2020-02-11',
        label: '2020-02-11'
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
      }],
      value2: '',
      value: ''
    },

    methods: {
      //预约
      handlebook(index, row) { //点击预约判断登陆状态，登陆就跳到申请表，未登陆就跳到登陆面
    	  window.location.href = "appointServlet?lbId="+row.lbId+"&date="+row.date+"&classTime="+row.classTime;
        console.log(index, row);
        console.log(row)
      },
      //查看详细信息
      openbox(index, row) {
        this.$alert(
          '<p>时间: '+row.classTime+
          '</p><p>实验室: '+row.name+
          '</p><p>可容纳: '+row.volume +
          '人</p><p>地址: '+row.lbAddress+
          '</p><p>介绍: '+row.description+'</p>',
          '详细情况', {
            dangerouslyUseHTMLString: true
          });
      },
      search() {
        // axios.get("http://localhost:3400/course").then((response) => {
        // console.log(response.data)
        // this.site=response.data
        // console.log(this.site)
        // })

        // axios操作方法 //下面的端口是模拟数据的接口
        axios.get('queryServlet?date='+this.value+"&classTime="+this.value2, {
            params: {}
          })
          .then((response) => {
            console.log(response.data);
            this.site = response.data;
            this.tableData = this.site
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    created() {
    	var date = new Date();
    	date.setDate(date.getDate() + 1); //获取AddDayCount天后的日期
    	var year = date.getFullYear();
        var month = date.getMonth() + 1; //获取当前月份的日期
        var day = date.getDate();
        var date1 = year + "-" + month + "-" + day;
    	//alert(date1);
    	 axios.get('queryServlet?date='+date1, {
             params: {}
           })
           .then((response) => {
             console.log(response.data)
             this.site = response.data;
             this.tableData = this.site
           })
           .catch((error) => {
             console.log(error);
           });
      let dateoptions = [{ //dateoptions为储存在data域中的时间格式
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
        dd.setDate(dd.getDate() + i + 1); //获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth() + 1; //获取当前月份的日期
        var d = dd.getDate();
        dateoptions[i].value = y + "-" + m + "-" + d
        dateoptions[i].label = y + "-" + m + "-" + d
      }
      this.options = dateoptions
    }
  })
</script>
</html>