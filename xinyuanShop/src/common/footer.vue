<template>
  <div class="footer">
    <div class="container">
      <div class="siteinfo">
        <ul class="c0">
          <h3 class="c1">订单服务</h3>
          <ul>
            <li class="c2">
              <a class="c3">购买指南</a>
            </li>
            <li class="c2">
              <a class="c3">支付方式</a>
            </li>
            <li class="c2">
              <a class="c3">送货政策</a>
            </li>
          </ul>
        </ul>
        <ul class="c0">
          <h3 class="c1">服务支持</h3>
          <ul>
            <li class="c2">
              <a class="c3" target="_blank">售后政策</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank">价格保护</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank">退款说明</a>
            </li>
          </ul>
        </ul>
        <ul class="c0">
          <h3 class="c1">配送方式</h3>
          <ul>
            <li class="c2">
              <a class="c3" target="_blank" href="http://blog.exrick.cn">上门自提</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank" href="http://blog.exrick.cn/intro/">配送服务查询</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank" href="https://www.bilibili.com/video/av15860053/">海外配送</a>
            </li>
          </ul>
        </ul>
        <ul class="c0">
          <h3 class="c1">支付方式</h3>
          <ul>
            <li class="c2">
              <a class="c3" target="_blank" href="http://xpay.exrick.cn">货到付款</a>
            </li>
            <li class="c2">
              <a
                class="c3"
                target="_blank"
                href="http://shouji.baidu.com/software/11783429.html"
              >在线支付</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank" href="https://github.com/Exrick">分期付款</a>
            </li>
          </ul>
        </ul>
        <ul class="c0">
          <h3 class="c1">友情链接</h3>
          <ul>
            <li class="c2">
              <a
                class="c3"
                target="_blank"
                href="https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/api/"
              >SpringBoot</a>
            </li>
            <li class="c2">
              <a
                class="c3"
                target="_blank"
                href="http://element-cn.eleme.io/#/zh-CN/guide/design"
              >Element</a>
            </li>
            <li class="c2">
              <a class="c3" target="_blank" href="https://cn.vuejs.org/">Vue</a>
            </li>
          </ul>
        </ul>
      </div>
      <div class="copyright">
        <h4
          class="content-c2"
        >Copyright ©2017, exrick.cn Co., Ltd. All Rights Reserved.本网站设计内容大部分属锤子科技</h4>
        <ul class="privacy">
          <li class="content-c1">
            <a class="content-c0" @click="open1">法律声明</a>
          </li>
          <li class="content-c1">
            <a class="content-c0" @click="open2">隐私条款</a>
          </li>
          <li class="content-c1">
            <a class="content-c0" target="_blank" href="https://github.com/Exrick">开发者中心</a>
          </li>
        </ul>
      </div>
      <div class="cop">
        <a class="content-c3" href="http://www.miibeian.gov.cn/" target="_blank">
          <span class="content-c3">蜀ICP备16030308号-1</span>
          <span class="content-c3">蜀ICP证16030308号</span>
        </a>
      </div>
    </div>
  </div>
</template>
<script>
import YButton from '/components/YButton'
export default {
  data () {
    return {
    }
  },
  methods: {
    open1 () {
      this.$notify.info({
        title: '法律声明',
        message: '此仅为个人练习开源模仿项目，仅供学习参考，承担不起任何法律问题'
      })
    },
    open2 () {
      this.$notify.info({
        title: '隐私条款',
        message: '本网站将不会严格遵守有关法律法规和本隐私政策所载明的内容收集、使用您的信息'
      })
    },
    open3 () {
      this.$notify({
        title: '离线帮助',
        message: '没人会帮助你，请自己靠自己',
        type: 'warning'
      })
    },
    open4 () {
      this.$notify.info({
        title: '支付方式',
        message: '支持支付宝、微信等方式捐赠'
      })
    },
    open5 () {
      this.$notify({
        title: '送货政策',
        message: '本网站所有商品购买后不会发货，将用作捐赠',
        type: 'warning'
      })
    }
  },
  components: {
    YButton
  }
}
</script>
<style lang="scss" rel="stylesheet/scss" scoped>
.footer {
  padding: 50px 0 20px;
  border-top: 1px solid #e6e6e6;
  background: #fafafa;
  margin-top: 60px;
  height: 350px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  width: 1220px;
}

.siteinfo {
  height: 100px;
  padding: 50px 0 130px;
  border-bottom: 1px solid #e6e6e6;
  position: relative;
}

.c0 {
  width: 149px;
  line-height: 1;
  float: left;
}

.c1 {
  color: #646464;
  font-size: 20px;
  padding: 0 0 14px;
}

.c2 {
  color: #c3c3c3;
  font-size: 15px;
  padding: 6px 0;
}

.c3 {
  color: #969696;
}

.c4 {
  position: absolute;
  right: 0;
  overflow: hidden;
  line-height: 34px;
}

.tel {
  font-size: 30px;
  line-height: 1;
  color: #646464;
  top: -2px;
  position: relative;
}

.c5 {
  color: #646464;
  right: -70px;
  position: relative;
}

.time {
  margin-top: 5px;
  right: -4px;
  position: relative;
  clear: both;
  width: 241px;
  font-size: 12px;
  line-height: 18px;
  color: #c3c3c3;
  text-align: right;
}

.online {
  clear: both;
  width: 241px;
  font-size: 12px;
  line-height: 18px;
  color: #c3c3c3;
  text-align: right;
}

.button {
  width: 130px;
  height: 34px;
  font-size: 14px;
  color: #5079d9;
  border: 1px solid #dcdcdc;
  margin-top: 8px;
}

.copyright {
  color: #434d55;
  font-size: 12px;
  padding: 40px 0 0;
  display: flex;
  align-items: left;
}

.privacy {
  float: left;
  margin: 0 0 0 12px;
}

.content-c0 {
  color: #5079d9;
  cursor: pointer;
  text-decoration: none;
  &:hover {
    color: #3a5fcd;
  }
}

.content-c1 {
  float: left;
  line-height: 12px;
  padding: 1px 10px 0;
  border-left: 1px solid #ccc;
}

.content-c2 {
  float: left;
  height: 15px;
  line-height: 15px;
  color: #757575;
}

.cop {
  clear: both;
  padding: 10px 0 0;
  height: 15px;
}

.content-c3 {
  margin-right: 20px;
  color: #bdbdbd;
  font-size: 12px;
  height: 12px;
  line-height: 1;
}
</style>
