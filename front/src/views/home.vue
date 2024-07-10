<template>
  <div class="content">
    <div class="text main-text"
      :style='{ "padding": "0", "boxShadow": "0 0 0px rgba(0,0,0,.1)", "margin": "0 auto", "borderColor": "rgba(255, 255, 255, 0.3)", "backgroundColor": "rgba(247, 247, 247, 1)", "color": "#333", "borderRadius": "6px", "borderWidth": "0", "width": "auto", "lineHeight": "auto", "fontSize": "24px", "borderStyle": "solid" }'>
      欢迎使用 {{ this.$project.projectName }}</div>


    <div style="display: flex;">
      <div style="flex: 1; margin-top: 150px" v-if="this.$storage.get('sessionTable') === 'users'">
        <div id="bie" style="width: 100%;height: 500px;"></div>
      </div>
      <div style="flex: 1; margin-top: 150px" v-if="this.$storage.get('sessionTable') === 'jiaoshi'">
        <div id="bie" style="width: 100%;height: 500px;"></div>
      </div>
      <div style="flex: 1; margin-top: 150px"
        v-if="this.$storage.get('sessionTable') === 'users' || this.$storage.get('sessionTable') === 'jiaoshi'">
        <div id="bar" style="width: 100%;height: 500px;"></div>
      </div>
      <div style="flex: 1; margin-top: 150px; margin-right: 100px"
        v-if="this.$storage.get('sessionTable') === 'xuesheng'">
        <div id="line" style="width: 100%;height: 500px;"></div>
      </div>
      <div style="flex: 1; margin-top: 150px" v-if="this.$storage.get('sessionTable') === 'xuesheng'">
        <div id="line2" style="width: 100%;height: 500px;"></div>
      </div>
    </div>
  </div>
</template>
<script>
import * as echarts from "echarts";
import router from '@/router/router-static'
export default {
  data() {
    return {

    };
  },
  mounted() {
    this.init();
    this.initEcharts();
  },
  methods: {
    init() {
      if (this.$storage.get('Token')) {
        this.$http({
          url: `${this.$storage.get('sessionTable')}/session`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code != 0) {
            router.push({ name: 'login' })
          }
        });
      } else {
        router.push({ name: 'login' })
      }
    },
    initEcharts() {
      if (this.$storage.get('sessionTable') === 'users') {
        this.$http({
          url: `/jiangxuejinshenqing/echarts/bie`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.initBie(data.data)
          } else {
            this.$message.error(data.msg);
          }
        }),
          this.$http({
            url: `/jiangxiangmingcheng/echarts/bar`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              let map = data.data;
              this.initBar(map.xAxis, map.yAxis)
            } else {
              this.$message.error(data.msg);
            }
          })
      }
      if (this.$storage.get('sessionTable') === 'jiaoshi') {
        this.$http({
          url: `/jiangxuejinshenqing/echarts/jsBie`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.initBie(data.data)
          } else {
            this.$message.error(data.msg);
          }
        }),
          this.$http({
            url: `/jiangxiangmingcheng/echarts/bar`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              let map = data.data;
              this.initBar(map.xAxis, map.yAxis)
            } else {
              this.$message.error(data.msg);
            }
          })
      }
      if (this.$storage.get('sessionTable') === 'xuesheng') {
        this.$http({
          url: `/xueshengchengji/echarts/line`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let map = data.data;
            this.initLine(map.xAxis, map.yAxis)
          } else {
            this.$message.error(data.msg);
          }
        }),
          this.$http({
            url: `/jiangxuejinshenqing/echarts/line`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              let map = data.data;
              this.initLine2(map.xAxis, map.yAxis)
            } else {
              this.$message.error(data.msg);
            }
          })
      }
    },
    initBie(data) {
      let chartDom = document.getElementById('bie');
      let myChart = echarts.init(chartDom);
      let option;
      option = {
        title: {
          text: '评审结果统计',
          subtext: '',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '评审结果',
            type: 'pie',
            radius: '50%',
            data: data,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      option && myChart.setOption(option);
    },
    initLine(xAxis, yAxis) {
      let chartDom = document.getElementById('line');
      let myChart = echarts.init(chartDom);
      let option;

      option = {
        title: {
          text: '历年成绩', // 设置图表的标题
          subtextStyle: {
            fontWeight: 'normal',
            fontSize: 14
          },
          left: 'center' // 设置副标题的位置为居中
        },
        xAxis: {
          type: 'category',
          data: xAxis
        },
        yAxis: {
          type: 'value',
          name: '分数'
        },
        series: [
          {
            data: yAxis,
            type: 'line',
            smooth: true,
            label: { // 标签配置
              show: true, // 显示标签
              position: 'top' // 标签位置，可以是 'top', 'insideTop', 'inside', 'insideBottom', 'bottom'
            },
            lineStyle: {
              color: 'blue'
            }
          }
        ]
      };

      option && myChart.setOption(option);

    },
    initLine2(xAxis, yAxis) {
      let chartDom = document.getElementById('line2');
      let myChart = echarts.init(chartDom);
      let option;

      option = {
        title: {
          text: '奖学金发放历史记录', // 设置图表的标题
          subtextStyle: {
            fontWeight: 'normal',
            fontSize: 14
          },
          left: 'center' // 设置副标题的位置为居中
        },

        xAxis: {
          type: 'category',
          data: xAxis
        },
        yAxis: {
          type: 'value',
          name: '发放金额'
        },
        series: [
          {
            data: yAxis,
            type: 'line',
            smooth: true,
            label: { // 标签配置
              show: true, // 显示标签
              position: 'top' // 标签位置，可以是 'top', 'insideTop', 'inside', 'insideBottom', 'bottom'
            },
            lineStyle: {
              color: 'blue'
            }
          }
        ]
      };

      option && myChart.setOption(option);

    },
    initBar(xAxis, yAxis) {
      let chartDom = document.getElementById('bar');
      let myChart = echarts.init(chartDom);
      let option;

      option = {
        title: {
          text: '奖学金类型金额统计', // 设置图表的标题
          subtextStyle: {
            fontWeight: 'normal',
            fontSize: 14
          },
          left: 'center' // 设置副标题的位置为居中
        },
        xAxis: {
          type: 'category',
          data: xAxis,
          name: '奖项类型'
        },
        yAxis: {
          type: 'value',
          name: '总金额 / 元'
        },
        series: [
          {
            data: yAxis,
            type: 'bar',
            label: { // 标签配置
              show: true, // 显示标签
              position: 'top' // 标签位置，可以是 'top', 'insideTop', 'inside', 'insideBottom', 'bottom'
            },
            itemStyle: { // 设置柱状图的样式
              color: 'rgb(63, 81, 181)' // 设置柱状图的颜色
            }
          }
        ]
      };

      option && myChart.setOption(option);
    }
  }
}
</script>

<style lang="scss" scoped>
.content {
  display: flex;

  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 500px;
  text-align: center;
  background: transparent;

  .main-text {
    font-size: 38px;
    font-weight: bold;
    margin-top: 15%;
  }

  .text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }
}
</style>