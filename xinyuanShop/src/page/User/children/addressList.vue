<template>
  <div>
    <y-shelf title="收货地址">
      <span slot="right">
        <y-button text="添加收货地址" style="margin: 0" @btnClick="update()"></y-button>
      </span>
      <div slot="content">
        <!--标题-->
        <div class="table-title">
          <span class="name">姓名</span>
          <span class="address">详细地址</span>
          <span class="tel">电话</span>
        </div>
        <div v-if="addList.length">
          <div class="address-item" v-for="(item,i) in addList" :key="i">
            <div class="name">{{item.shippingPeople}}</div>
            <div class="address-msg">{{item.addressDetail}}</div>
            <div class="telephone">{{item.phone}}</div>
            <div class="defalut">
              <a
                @click="changeDef(item)"
                href="javascript:;"
                v-text="item.isDefault?'( 默认地址 )':'设为默认'"
                :class="{'defalut-address':item.isDefault}"
              ></a>
            </div>
            <div class="operation">
              <el-button type="primary" icon="edit" size="small" @click="update(item)"></el-button>
              <el-button
                type="danger"
                icon="delete"
                size="small"
                :data-id="item.id"
                @click="del(item.id,i)"
              ></el-button>
            </div>
          </div>
        </div>
        <div v-else>
          <div style="padding: 80px 0;text-align: center">
            <div style="font-size: 20px">你还未添加收货地址</div>
            <div style="margin: 20px ">
              <y-button text="添加地址" @btnClick="update()"></y-button>
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
            @change="getReadCity(province.id)"
          >
            <el-option v-for="item in provinces" :key="item.id" :label="item.text" :value="item"></el-option>
          </el-select>
          <el-select
            v-model="city"
            value-key="id"
            filterable
            placeholder="请选择"
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
</template>
<script>
import { addressList, addressUpdate, addressAdd, addressDel } from '/api/goods'
import YButton from '/components/YButton'
import YPopup from '/components/popup'
import YShelf from '/components/shelf'
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
      addList: [],
      popupOpen: false,
      popupTitle: '管理收货地址',
      msg: {
        id: '',
        shippingPeople: '',
        phone: '',
        addressDetail: '',
        postalCode: '',
        isDefault: false
      },
      userId: '',
      isEDIt: true
    }
  },
  computed: {
    btnHighlight () {
      let msg = this.msg
      return msg.shippingPeople && msg.phone && msg.addressDetail
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
    messageSuccess (m) {
      this.$message({
        message: m,
        type: 'success'
      })
    },
    message (m) {
      this.$message.error({
        message: m
      })
    },
    _addressList () {
      addressList(this.userId).then(res => {
        let data = res.content
        if (data.length) {
          this.addList = res.content
          this.id = res.content[0].id || '1'
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
    changeDef (item) {
      if (!item.isDefault) {
        item.isDefault = true
        this._addressUpdate(item)
      }
      return false
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
    del (id, i) {
      console.log(id)
      addressDel(id).then(res => {
        if (res.code === 1) {
          this.addList.splice(i, 1)
          this.messageSuccess('操作成功')
        } else {
          this.message('删除失败！')
        }
      })
    },
    // 修改
    update (item) {
      this.popupOpen = true
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
        console.log(item)
        console.log(this.province)
        console.log(this.city)
        console.log(this.area)
        this.getContent()
      } else {
        this.popupTitle = '新增收货地址'
        this.msg.shippingPeople = ''
        this.msg.phone = ''
        this.msg.addressDetail = ''
        this.msg.isDefault = false
        this.msg.id = ''
        this.msg.postalCode = ''
        this.province = {}
        this.city = {}
        this.area = {}
        this.getContent()
      }
    }
  },
  created () {
    this.userId = getStore('userId')
    this._addressList()
  },
  components: {
    YButton,
    YPopup,
    YShelf
  }
}
</script>
<style scoped lang="scss">
.table-title {
  position: relative;
  z-index: 1;
  line-height: 38px;
  height: 38px;
  padding: 0 0 0 38px;
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
    float: left;
    text-align: center;
    color: #838383;
  }
  .address {
    margin-left: 115px;
  }
  .tel {
    margin-left: 195px;
  }
}

.address-item {
  display: flex;
  align-items: center;
  height: 115px;
  text-align: center;
  .name {
    width: 106px;
  }
  .address-msg {
    flex: 1;
  }
  .telephone {
    width: 160px;
  }
  .defalut {
    width: 80px;
    > a {
      text-align: center;
      /*display: none;*/
    }
  }
  .operation {
    width: 135px;
    a {
      padding: 10px 5px;
    }
  }
  &:hover {
    .defalut > a {
      display: block;
    }
  }
}

.address-item + .address-item {
  border-top: 1px solid #cfcfcf;
}

.defalut-address {
  color: #626262;
  display: block;
  pointer-events: none;
  cursor: default;
}

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
</style>
