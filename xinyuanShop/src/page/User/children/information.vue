<template>
  <div>
    <y-shelf title="账户资料">
      <div slot="content">
        <div class="avatar-box">
          <div class="img-box">
            <img :src="userInfo.info.file" alt>
          </div>
          <div class="r-box">
            <h3 style="margin-left: 13px;">修改头像</h3>
            <y-button text="上传头像" classStyle="main-btn" style="margin: 0;" @btnClick="editAvatar()"></y-button>
          </div>
        </div>

        <div class="edit-avatar" v-if="editAvatarShow">
          <y-shelf title="设置头像">
            <span slot="right">
              <span class="close" @click="editAvatarShow=false">
                <svg
                  t="1501234940517"
                  class="icon"
                  style
                  viewBox="0 0 1024 1024"
                  version="1.1"
                  xmlns="http://www.w3.org/2000/svg"
                  p-id="3014"
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                  width="20"
                  height="20"
                >
                  <path
                    d="M941.576 184.248l-101.824-101.824L512 410.176 184.248 82.424 82.424 184.248 410.168 512l-327.744 327.752 101.824 101.824L512 613.824l327.752 327.752 101.824-101.824L613.832 512z"
                    fill="#cdcdcd"
                    p-id="3015"
                  ></path>
                </svg>
              </span>
            </span>
            <div slot="content" class="content">
              <div class="edit-l">
                <div
                  style="width: 100px;height: 100px;border: 1px solid #ccc;margin-bottom: 20px;overflow: hidden;"
                >
                  <div
                    class="show-preview"
                    :style="{'width': previews.w + 'px','height': previews.h + 'px','overflow': 'hidden','zoom':option.zoom}"
                  >
                    <div :style="previews.div">
                      <img :src="option.img" :style="previews.img">
                    </div>
                  </div>
                </div>
                <div style="padding: 10px 0 ">头像预览</div>
                <div class="btn">
                  <a href="javascript:;">重新选择</a>
                  <input type="file" value="上传头像" @change="upimg($event)">
                </div>
              </div>
              <div class="edit-r">
                <div>
                  <div class="big" id="cropper-target" v-if="option.img">
                    <vueCropper
                      :img="option.img"
                      @realTime="realTime"
                      ref="cropper"
                      :outputSize="example2.size"
                      :info="example2.info"
                      :canScale="example2.canScale"
                      :autoCrop="example2.autoCrop"
                      :autoCropWidth="example2.width"
                      :autoCropHeight="example2.height"
                      :fixed="example2.fixed"
                    ></vueCropper>
                  </div>
                </div>
              </div>
              <div class="bootom-btn pa">
                <y-button
                  style="width: 140px;height: 40px;line-height: 40px"
                  text="取消"
                  @btnClick="editAvatarShow=false"
                ></y-button>
                <y-button
                  style="width: 140px;height: 40px;line-height: 40px"
                  text="确定"
                  classStyle="main-btn"
                  @btnClick="cropper"
                ></y-button>
              </div>
            </div>
          </y-shelf>
        </div>
        <div>
          <el-form
            :model="ruleForm"
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
          >
            <el-form-item label="昵称" prop="nickName">
              <el-input v-model="ruleForm.nickName"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="account">
              <el-input v-model="ruleForm.account"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
              <el-radio-group v-model="ruleForm.sex">
                <el-radio :label="0">保密</el-radio>
                <el-radio :label="1">男</el-radio>
                <el-radio :label="2">女</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item
              prop="email"
              label="邮箱"
              :rules="[
      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
      { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
    ]"
            >
              <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>

            <el-form-item label="手机号" prop="phone">
              <el-input v-model.number="ruleForm.phone"/>
            </el-form-item>

            <el-form-item label="提示问题" prop="question">
              <el-select v-model="ruleForm.question">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="问题答案" prop="answer">
              <el-input type="textarea" v-model="ruleForm.answer"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
        <!-- <From></From> -->
      </div>
    </y-shelf>
  </div>
</template>
<script>
import YButton from '/components/YButton'
import { upload, userInfo } from '/api/index'
import YShelf from '/components/shelf'
import vueCropper from 'vue-cropper'
import { mapState, mapMutations } from 'vuex'
import { getStore } from '/utils/storage'
export default {
  data () {
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('手机号不能为空'))
      } else {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
        console.log(reg.test(value))
        if (reg.test(value)) {
          callback()
        } else {
          return callback(new Error('请输入正确的手机号'))
        }
      }
    }
    return {
      imgSrc: '',
      editAvatarShow: false,
      cropContext: '',
      cropperImg: '',
      previews: {},
      option: {
        img: '',
        zoom: 0
      },
      fixedNumber: [1, 1],
      example2: {
        info: true,
        size: 1,
        canScale: false,
        autoCrop: true,
        // 只有自动截图开启 宽度高度才生效
        autoCropWidth: 300,
        autoCropHeight: 250,
        // 开启宽度和高度比例
        fixed: true
      },
      userId: '',
      token: '',
      ruleForm: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
        domains: [{
          value: ''
        }],
        email: '',
        phone: '',
        answer: '',
        nickName: '',
        account: '',
        sex: '',
        question: ''
      },
      rules: {
        nickName: [
          { required: true, message: '请输入昵称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        account: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        question: [
          { required: true, message: '请选择活动区域', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
        ],
        type: [
          { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
        ],
        answer: [
          { required: true, message: '请填写问题答案', trigger: 'blur' }
        ],
        phone: [
          { required: true, validator: checkPhone, trigger: 'blur' }
        ],
        sex: [
          { required: true }
        ]

      },
      options: [
        {
          value: '我最好朋友的生日?',
          label: '我最好朋友的生日?'
        },
        {
          value: '我儿时居住地的地址?',
          label: '我儿时居住地的地址?'
        },
        {
          value: '我的座右铭是?',
          label: '我的座右铭是?'
        },
        {
          value: '我最喜爱的电影?',
          label: '我最喜爱的电影?'
        },
        {
          value: '我最喜欢的食物?',
          label: '我最喜欢的食物?'
        },
        {
          value: '我最大的爱好?',
          label: '我最大的爱好?'
        },
        {
          value: '我最喜欢的小说?',
          label: '我最喜欢的小说?'
        },
        {
          value: '我最喜欢的运动队?',
          label: '我最喜欢的运动队?'
        }
      ]
    }
  },
  computed: {
    ...mapState(['userInfo'])
  },
  mounted: function () {
    this.userInfos()
  },
  methods: {
    userInfos () {
      userInfo(getStore('userId')).then(res => {
        if (res.code === 1) {
          console.log('获取用户资料成功。')
          this.ruleForm.account = res.content.account
          this.ruleForm.swer = res.content.answer
          this.ruleForm.email = res.content.email
          this.ruleForm.id = res.content.id
          this.ruleForm.nickName = res.content.nickName
          this.ruleForm.phone = res.content.phone
          this.ruleForm.question = res.content.question
          this.ruleForm.sex = res.content.sex
          this.ruleForm.answer = res.content.answer
        }
      })
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    ...mapMutations([
      'RECORD_USERINFO'
    ]),
    message (m) {
      this.$message(m)
    },
    messageSuccess (m) {
      this.$message({
        message: m,
        type: 'success'
      })
    },
    messageFail (m) {
      this.$message.error({
        message: m
      })
    },
    upimg (e) {
      var file = e.target.files[0]
      if (file.size > 1048576) {
        this.messageFail('图片大小不得超过1Mb')
        return false
      }
      if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(e.target.value)) {
        this.messageFail('图片类型仅支持.gif,jpeg,jpg,png,bmp')
        return false
      }
      var reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = (e) => {
        this.option.img = e.target.result
      }
    },
    cropper () {
      this.message('上传中...')
      if (this.option.img) {
        this.$refs.cropper.getCropData((data) => {
          this.imgSrc = data
          upload({ userId: this.userId, token: this.token, imgData: data }).then(res => {
            if (res.success === true) {
              let path = res.result
              let info = this.userInfo
              info.file = path
              this.RECORD_USERINFO({ info: info })
              this.editAvatarShow = false
              this.messageSuccess('上传成功')
            } else {
              this.messageFail(res.message)
            }
          })
        })
      } else {
        this.messageFail('别玩我啊 先选照骗')
      }
    },
    editAvatar () {
      this.editAvatarShow = true
    },
    realTime (data) {
      this.previews = data
      let w = 100 / data.w
      this.option.zoom = w
    }
  },
  created () {
    this.userId = getStore('userId')
    this.token = getStore('token')
  },
  components: {
    YButton,
    YShelf,
    vueCropper
    // From
  }
}
</script>
<style lang="scss" scoped>
@import "../../../assets/style/mixin";
@import url("//unpkg.com/element-ui@2.4.11/lib/theme-chalk/index.css");
.avatar-box {
  height: 124px;
  display: flex;
  margin: 0 30px 30px;
  border-bottom: #dadada solid 1px;
  line-height: 30px;
  display: flex;
  align-items: center;
  .img-box {
    @include wh(80px);
    border-radius: 5px;
    overflow: hidden;
  }
  img {
    display: block;
    @include wh(100%);
  }
  .r-box {
    margin-left: 20px;
    h3 {
      font-size: 18px;
      font-weight: 400;
      color: #333;
    }
  }
}

// 修改头像
.edit-avatar {
  z-index: 9999;
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  @include wh(100%);
  background-color: rgba(0, 0, 0, 0.5);
  @extend %block-center;
  .content {
    display: flex;
    padding: 45px 100px 0;
  }
  > div {
    box-sizing: content-box;
    @include wh(700px, 500px);
    margin: 0;
  }
  .btn {
    width: 80px;
    height: 30px;
    margin-left: 10px;
    position: relative;
    text-align: center;
    line-height: 30px;
    text-shadow: rgba(255, 255, 255, 0.496094) 0 1px 0;
    border: 1px solid #e6e6e6;
    border-radius: 10px;
    &:hover {
    }
    a {
      color: #666;
      display: block;
      @include wh(100%);
    }
  }
  input[type="file"] {
    position: absolute;
    right: 0;
    left: 0;
    top: 0;
    opacity: 0;
    width: 80px;
    height: 30px;
    cursor: pointer;
    box-sizing: border-box;
    border: 15px solid #000;
    overflow: hidden;
  }
  .edit-l {
    width: 100px;
    text-align: center;
  }
  .edit-r {
    margin-left: 20px;
    flex: 1;
    > div {
      border: 1px solid #ccc;
      width: 320px;
      height: 320px;
    }
  }
}

.image-container {
  width: 100px;
  height: 100px;
  border: 1px solid #ccc;
}

.close {
  position: absolute;
  right: 10px;
  top: 0;
  bottom: 0;
  padding: 0 10px;
  @extend %block-center;
  &:hover {
    svg {
      transition: all 1s;
      transform: rotate(360deg);
      transform-origin: 50% 50%;
    }
    path {
      fill: #8a8a8a;
    }
  }
}

.big {
  display: block;
  width: 320px;
  height: 320px;
}

.bootom-btn {
  padding: 0 15px;
  border-top: 1px solid #e6e6e6;
  bottom: 0;
  height: 60px;
  right: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>
