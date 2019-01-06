<template>
  <div class="checkout">
    <y-header>
      <div slot="nav"></div>
    </y-header>
    <div class="w" style="padding-top: 40px;">
      <!-- 收货地址 -->
      <y-shelf title="收货信息">
        <div slot="content">
          <ul class="address-item-list clearfix">
            <li
              v-for="(item,i) in addList"
              :key="i"
              class="address pr"
              :class="{checked:id === item.id}"
              @click="chooseAddress(item.id, item.shippingPeople, item.phone, item.addressDetail,item.province,item.city,item.area)"
            >
              <span v-if="id === item.id" class="pa">
                <svg viewBox="0 0 1473 1024" width="17.34375" height="12">
                  <path
                    d="M1388.020 57.589c-15.543-15.787-37.146-25.569-61.033-25.569s-45.491 9.782-61.023 25.558l-716.054 723.618-370.578-374.571c-15.551-15.769-37.151-25.537-61.033-25.537s-45.482 9.768-61.024 25.527c-15.661 15.865-25.327 37.661-25.327 61.715 0 24.053 9.667 45.849 25.327 61.715l431.659 436.343c15.523 15.814 37.124 25.615 61.014 25.615s45.491-9.802 61.001-25.602l777.069-785.403c15.624-15.868 25.271-37.66 25.271-61.705s-9.647-45.837-25.282-61.717M1388.020 57.589z"
                    fill="#6A8FE5"
                    p-id="1025"
                  ></path>
                </svg>
              </span>
              <p>收货人: {{item.shippingPeople}} {{item.isDefault ? '(默认地址)' : ''}}</p>
              <p class="street-name ellipsis">收货地址: {{item.addressDetail}}</p>
              <p>手机号码: {{item.phone}}</p>
              <div class="operation-section">
                <span
                  class="update-btn"
                  style="font-size:12px"
                  @click="update(item),getContent()"
                >修改</span>
                <span
                  class="delete-btn"
                  style="font-size:12px"
                  :data-id="item.id"
                  @click="del(item.id)"
                >删除</span>
              </div>
            </li>

            <li class="add-address-item" @click="update(),getContent()">
              <img src="../../../static/svg/jia.svg" alt>
              <p>使用新地址</p>
            </li>
          </ul>
        </div>
      </y-shelf>
      <!-- 购物清单 -->
      <y-shelf title="购物清单">
        <div slot="content">
          <div class="box-inner ui-cart">
            <div>
              <!--标题-->
              <div class="cart-table-title">
                <span class="name">商品信息</span>
                <span class="subtotal">小计</span>
                <span class="num">数量</span>
                <span class="price">单价</span>
              </div>
              <!--列表-->
              <div
                class="cart-table"
                v-for="(item,i) in cartList"
                :key="i"
                v-if="item.checked === '1'"
              >
                <div class="cart-group divide pr" :data-productid="item.productId">
                  <div class="cart-top-items">
                    <div class="cart-items clearfix">
                      <!--图片-->
                      <div class="items-thumb fl">
                        <img :alt="item.productName" :src="item.productImg">
                        <a
                          @click="goodsDetails(item.productId)"
                          :title="item.productName"
                          target="_blank"
                        ></a>
                      </div>
                      <!--信息-->
                      <div class="name hide-row fl">
                        <div class="name-table">
                          <a
                            @click="goodsDetails(item.productId)"
                            :title="item.productName"
                            target="_blank"
                            v-text="item.productName"
                          ></a>
                          <!-- <ul class="attribute">
                            <li>白色</li>
                          </ul>-->
                        </div>
                      </div>
                      <!--商品数量-->
                      <div>
                        <!--总价格-->
                        <div
                          class="subtotal"
                          style="font-size: 14px"
                        >¥ {{item.salePrice * item.productNum}}</div>
                        <!--数量-->
                        <div class="item-cols-num">
                          <span v-text="item.productNum"></span>
                        </div>
                        <!--价格-->
                        <div class="price">¥ {{item.salePrice}}</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 合计 -->
            <div class="cart-bottom-bg fix-bottom">
              <div class="fix-bottom-inner">
                <div class="shipping">
                  <div class="shipping-box" style="padding: 0 40px;">
                    <div class="shipping-total shipping-price">
                      <h4 class="highlight">
                        应付总额：
                        <em>￥{{checkPrice}}</em>
                      </h4>
                    </div>
                  </div>
                  <y-button
                    class="big-main-btn"
                    :classStyle="submit?'disabled-btn':'main-btn'"
                    style="margin: 0;width: 130px;height: 50px;line-height: 50px;font-size: 16px"
                    :text="submitOrder"
                    @btnClick="_submitOrder"
                  ></y-button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </y-shelf>

      <y-popup :open="popupOpen" @close="popupOpen=false;isEDIt=true" :title="popupTitle">
        <div slot="content" class="md" :data-id="msg.id">
          <div>配送区域:
            <el-select
              v-model="province"
              value-key="id"
              filterable
              placeholder="请选择"
              @visible-change="isEDIt = false"
              @change="getReadCity(province.id)"
            >
              <el-option v-for="item in provinces" :key="item.id" :label="item.text" :value="item"></el-option>
            </el-select>
            <el-select
              v-model="city"
              value-key="id"
              filterable
              placeholder="请选择"
              @visible-change="isEDIt = false"
              @change="getReadCounty(city.id)"
            >
              <el-option v-for="item in citys" :key="item.id" :label="item.text" :value="item"></el-option>
            </el-select>
            <el-select v-model="area" value-key="id" filterable placeholder="请选择">
              <el-option v-for="item in areas" :key="item.id" :label="item.text" :value="item"></el-option>
            </el-select>
            <div>收货人姓名:
              <el-input placeholder="请输入内容" v-model="msg.shippingPeople" clearable></el-input>
            </div>
            <div>详细地址:
              <el-input placeholder="请输入内容" v-model="msg.addressDetail" clearable></el-input>
            </div>
            <div>邮政编码:
              <el-input placeholder="请输入内容" v-model="msg.postalCode" clearable></el-input>
            </div>
            <div>手机:
              <el-input placeholder="请输入内容" v-model="msg.phone" clearable></el-input>
            </div>
          </div>
          <div>
            <el-checkbox class="auto-login" v-model="msg.isDefault">设为默认</el-checkbox>
          </div>
          <y-button
            text="保存"
            class="btn"
            :classStyle="btnHighlight?'main-btn':'disabled-btn'"
            @btnClick="save({userId:userId,id:msg.id,shippingPeople:msg.shippingPeople,phone:msg.phone,addressDetail:msg.addressDetail,isDefault:msg.isDefault,county:area.text,city:city.text,province:province.text,postalCode:msg.postalCode})"
          ></y-button>
        </div>
      </y-popup>
    </div>
    <y-footer></y-footer>
  </div>
</template>
<script>
import { getCartList, addressList, addressUpdate, addressAdd, addressDel, productDet, submitOrder } from '/api/goods'
import YShelf from '/components/shelf'
import YButton from '/components/YButton'
import YPopup from '/components/popup'
import YHeader from '/common/header'
import YFooter from '/common/footer'
import { getStore } from '/utils/storage'
import { getReadAll, getReadCounty, getReadCity } from '/api/goods.js'
export default {
  data () {
    return {
      provinces: [],
      province: {},
      citys: [],
      city: {},
      areas: [],
      area: {},
      cartList: [],
      addList: [],
      id: '0',
      popupOpen: false,
      popupTitle: '管理收货地址',
      num: '', // 立刻购买
      productId: '',
      msg: {
        id: '',
        shippingPeople: '',
        phone: '',
        addressDetail: '',
        postalCode: '',
        isDefault: false
      },
      shippingPeople: '',
      postalCode: '',
      phone: '',
      addressDetail: '',
      userId: 0,
      orderTotal: 0,
      submit: false,
      submitOrder: '提交订单',
      isEDIt: true
    }
  },
  computed: {
    btnHighlight () {
      let msg = this.msg
      let city = this.city
      let province = this.province
      let area = this.area
      return msg.shippingPeople && msg.phone && msg.addressDetail && msg.postalCode && city && province && area
    },
    // 选中的总价格
    checkPrice () {
      let totalPrice = 0
      this.cartList && this.cartList.forEach(item => {
        if (item.checked === '1') {
          totalPrice += (item.productNum * item.salePrice)
        }
      })
      this.orderTotal = totalPrice
      return totalPrice
    }
  },
  // 监听
  watch: {
    'province': function (newValue, oldValue) {
      console.log(this.isEDIt)
      if (!this.isEDIt) {
        this.city = null
      }
    },
    'city': function (newValue, oldValue) {
      console.log(this.isEDIt)
      if (!this.isEDIt) {
        this.area = null
      }
    }
  },
  methods: {
    // 获取省信息
    getContent () {
      getReadAll().then(res => {
        if (res.code === 1) {
          this.provinces = res.content
        } else {
          return false
        }
      })
    },
    // 获取市
    getReadCity (params) {
      this.isEDIt = false
      getReadCity(params).then(res => {
        if (res.code === 1) {
          this.citys = res.content
        } else {
          return false
        }
      })
    },
    // 获取县、区列表
    getReadCounty (params) {
      this.isEDIt = false
      getReadCounty(params).then(res => {
        if (res.code === 1) {
          this.areas = res.content
        } else {
          return false
        }
      })
    },
    message (m) {
      this.$message.error({
        message: m
      })
    },
    messageSuccess (m) {
      this.$message({
        message: m,
        type: 'success'
      })
    },
    goodsDetails (id) {
      window.open(window.location.origin + '#/goodsDetails?productId=' + id)
    },
    _getCartList () {
      getCartList(getStore('account')).then(res => {
        this.cartList = res.content
      })
    },
    _addressList () {
      addressList(this.userId).then(res => {
        let data = res.content
        console.log(data)
        if (data.length) {
          this.addList = data
          data.forEach(array => {
            if (array.isDefault) {
              this.id = array.id || '1'
              this.shippingPeople = array.shippingPeople
              this.phone = array.phone
              this.addressDetail = array.addressDetail
              this.province = array.province
              this.city = array.city
              this.area = array.county
            }
          })
          // this.addList = data
          // this.id = data[0].id || '1'
          // this.shippingPeople = data[0].shippingPeople
          // this.phone = data[0].phone
          // this.addressDetail = data[0].addressDetail
          // this.province = data[0].province
          // this.city = data[0].city
          // this.area = data[0].county
        } else {
          this.addList = []
        }
      })
    },
    _addressUpdate (params) {
      addressUpdate(params).then(res => {
        this._addressList()
      })
    },
    _addressAdd (params) {
      addressAdd(params).then(res => {
        if (res.code === 1) {
          this.messageSuccess('操作成功')
          this._addressList()
        } else {
          this.message(res.message)
        }
      })
    },
    _addressDel (params) {
      addressDel(params).then(res => {
        this.messageSuccess('操作成功')
        this._addressList()
      })
    },
    // 提交订单后跳转付款页面
    _submitOrder () {
      this.submitOrder = '提交订单中...'
      this.submit = true
      var array = []
      if (this.id === '0') {
        this.message('请选择收货地址')
        this.submitOrder = '提交订单'
        this.submit = false
        return
      }
      if (this.cartList.length === 0) {
        this.message('非法操作')
        this.submitOrder = '提交订单'
        this.submit = false
        return
      }
      for (var i = 0; i < this.cartList.length; i++) {
        if (this.cartList[i].checked === '1') {
          array.push(this.cartList[i])
        }
      }
      let params = {
        userId: this.userId,
        phone: this.phone,
        shippingPeople: this.shippingPeople,
        addressDetail: this.addressDetail,
        goodsList: array,
        orderTotal: this.orderTotal,
        area: this.area,
        city: this.city,
        province: this.province
      }
      console.log('----------')
      console.log(params)
      submitOrder(params).then(res => {
        if (res.success === true) {
          this.payment(res.content)
        } else {
          this.message(res.message)
          this.submitOrder = '提交订单'
          this.submit = false
        }
      })
    },
    // 付款
    payment (orderId) {
      // 需要拿到地址id
      this.$router.push({
        path: '/order/payment',
        query: {
          'orderId': orderId
        }
      })
    },
    // 选择地址
    chooseAddress (id, shippingPeople, phone, addressDetail, province, city, area) {
      console.log(id, shippingPeople, phone, addressDetail, province, city, area)
      this.id = id
      this.shippingPeople = shippingPeople
      this.phone = phone
      this.addressDetail = addressDetail
      this.province = province
      this.city = city
      this.area = area
    },
    // 修改
    update (item) {
      if (item) {
        this.popupTitle = '管理收货地址'
        this.msg.shippingPeople = item.shippingPeople
        this.msg.phone = item.phone
        this.msg.addressDetail = item.addressDetail
        this.msg.isDefault = item.isDefault
        this.msg.id = item.id
        this.msg.postalCode = item.postalCode
        this.province = item.province
        this.city = item.city
        this.area = item.county
        this.popupOpen = true
      } else {
        this.popupTitle = '新增收货地址'
        this.msg.shippingPeople = ''
        this.msg.phone = ''
        this.msg.addressDetail = ''
        this.msg.isDefault = false
        this.msg.id = ''
        this.msg.postalCode = ''
        this.popupOpen = true
        this.province = {}
        this.city = {}
        this.area = {}
      }
    },
    // 保存
    save (p) {
      this.isEDIt = true
      this.popupOpen = false
      if (p.id) {
        this._addressUpdate(p)
      } else {
        delete p.id
        this._addressAdd(p)
      }
    },
    // 删除
    del (id) {
      this._addressDel(id)
    },
    _productDet (productId) {
      productDet({ params: { productId } }).then(res => {
        let item = res.content
        item.checked = '1'
        item.productImg = item.productImageBig
        item.productNum = this.num
        item.productPrice = item.salePrice
        this.cartList.push(item)
      })
    }
  },
  created () {
    this.userId = parseInt(getStore('userId'))
    let query = this.$route.query
    if (query.productId && query.num) {
      this.productId = query.productId
      this.num = query.num
      this._productDet(this.productId)
    } else {
      this._getCartList()
    }
    this._addressList()
  },
  components: {
    YShelf,
    YButton,
    YPopup,
    YHeader,
    YFooter
  }
}
</script>
<style lang="scss" rel="stylesheet/scss" scoped>
// 收货地址
.address-item-list {
  padding: 30px 13px 0;
  .address {
    padding: 19px 14px 0 19px;
    p {
      line-height: 26px;
    }
  }
  li.checked {
    border-color: #6a8fe5;
    position: relative;
    background: #fff;
    .pa {
      right: 15px;
      top: 18px;
    }
    &:hover {
      background: #fff;
    }
  }
  li {
    position: relative;
    overflow: hidden;
    float: left;
    width: 276px;
    height: 158px;
    margin: 0 0 30px 16px;
    border: 1px solid #e5e5e5;
    border-radius: 3px;
    background: #fafafa;
    line-height: 14px;
    text-align: left;
    word-wrap: break-word;
    word-break: normal;
    color: #626262;
    cursor: pointer;
    -moz-user-select: -moz-none;
    -webkit-user-select: none;
    -o-user-select: none;
    user-select: none;
    &:hover {
      background: #f2f2f2;
      .operation-section {
        visibility: visible;
        transform: translate(0, 0);
      }
    }
    &.add-address-item {
      text-align: center;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      p {
        margin-top: 5px;
      }
    }
    .operation-section {
      visibility: hidden;
      position: absolute;
      left: 0;
      bottom: 0;
      width: 100%;
      height: 28px;
      background: #e1e1e1;
      border-top: 1px solid #e1e1e1;
      transition: all 0.2s ease;
      transform: translate(0, 29px);
      border-top: 1px solid #e1e1e1;
      display: flex;
      align-items: center;
      justify-content: center;
      z-index: 11;
      span {
        background: #fff;
        display: flex;
        align-items: center;
        justify-content: center;
        flex: 1;
        height: 100%;
        &:hover {
          background: #f2f2f2;
        }
      }

      span + span {
        border-left: 1px solid #e1e1e1;
      }
    }
  }
}

.s-content {
  .md {
    > div {
      text-align: left;
      margin-bottom: 15px;
      > input {
        width: 100%;
        height: 50px;
        font-size: 18px;
        padding: 10px 20px;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-shadow: 0 3px 5px -4px rgba(0, 0, 0, 0.4) inset,
          -1px 0 3px -2px rgba(0, 0, 0, 0.1) inset;
        line-height: 46px;
      }
    }
  }

  .btn {
    margin: 0;
    width: 100%;
    height: 50px;
    font-size: 14px;
    line-height: 48px;
  }
}

.ui-cart {
  img {
    width: 80px;
    height: 80px;
  }

  .cart-table-title {
    position: relative;
    z-index: 1;
    line-height: 38px;
    height: 38px;
    padding: 0 0 0 30px;
    font-size: 12px;
    background: #eee;
    border-bottom: 1px solid #dbdbdb;
    border-bottom-color: rgba(0, 0, 0, 0.08);
    .name {
      float: left;
      text-align: left;
    }
    span {
      width: 137px;
      float: right;
      text-align: center;
      color: #838383;
    }
  }
  .cart-group.divide {
    .cart-items {
      border-top: 1px dashed #eee;
    }
  }
  .cart-items {
    position: relative;
    height: 140px;
    margin-left: 74px;
    .subtotal {
      font-weight: 700;
    }
    .item-cols-num,
    .price,
    .subtotal {
      overflow: hidden;
      float: right;
      width: 137px;
      text-align: center;
      color: #666;
      line-height: 140px;
    }
    /*数量*/
    .subtotal,
    .item-cols-num {
      padding-top: 50px;
      line-height: 40px;
    }
    .select {
      width: 112px;
      height: 40px;
      padding-top: 4px;
      margin: 0 auto;
      line-height: 40px;
      .down {
        background-position: 0 -60px;
      }
      .down.down-disabled:hover {
        background-position: 0 -300px;
        cursor: not-allowed;
      }
      .num {
        position: relative;
        overflow: hidden;
        display: inline-block;
        width: 36px;
        height: 18px;
        margin: 7px 0 0;
        border: none;
        border-radius: 3px;
        line-height: 18px;
        text-align: center;
        font-size: 14px;
        transition: all 0.2s ease-out;
      }
    }
  }
  .down.down-disabled {
    background-position: 0 -300px;
    cursor: not-allowed;
  }
}

.cart-group.divide .cart-top-items:first-child .cart-items {
  border-top: none;
}

.items-choose {
  position: absolute;
  left: -74px;
  top: 0;
  width: 74px;
  height: 20px;
  padding: 60px 0 0 31px;
  font-size: 12px;
  color: #999;
}

.items-thumb {
  position: relative;
  margin-top: 30px;
  overflow: hidden;
  width: 80px;
  height: 80px;
}

.cart-items .items-thumb > a,
.ui-cart .cart-items .items-thumb > i {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  border: 1px solid #fff;
  border-radius: 3px;
  border: 0 solid rgba(255, 255, 255, 0.1);
  box-shadow: inset 0 0 0 1px rgba(0, 0, 0, 0.06);
}

.name {
  width: 380px;
  margin-left: 20px;
  color: #323232;
  display: table;
  a {
    color: #333;
    font-size: 16px;
  }
}

.name-table {
  display: table-cell;
  vertical-align: middle;
  height: 140px;
}

.fix-bottom {
  padding: 22px 29px 19px 30px;
  height: 90px;
  width: 100%;
  z-index: 1;
  background-position: center;
  background: #fdfdfd;
  background: -webkit-linear-gradient(#fdfdfd, #f9f9f9);
  background: linear-gradient(#fdfdfd, #f9f9f9);
  border-top: 1px solid #e9e9e9;
  box-shadow: 0 -3px 8px rgba(0, 0, 0, 0.04);
  .cart-bottom-bg {
    height: 80px;
    border-top: 1px solid #d9d9d9;
    border-radius: 0 0 8px 8px;
  }
  .fix-bottom-inner {
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
  }
  .shipping {
    display: flex;
    align-items: center;
  }
  em {
    display: inline-block;
    position: relative;
    top: 3px;
    margin-top: -4px;
    font-size: 24px;
    color: #d44d44;
    font-weight: 700;
  }
}

.attribute,
.name p {
  color: #999;
  font-size: 12px;
  padding-top: 4px;
  line-height: 17px;
}
</style>
