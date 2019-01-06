import http from './public'
// import axios from 'axios'
// 登陆
export const userLogin = params => {
  return http.fetchPost(
    'http://39.108.191.78:8080/Ecommmerce/user/login',
    params
  )
}
// 退出登陆
export const loginOut = params => {
  return http.fetchGet('/member/loginOut', params)
}
// 用户信息
export const userInfo = params => {
  return http.fetchGet(
    'http://39.108.191.78:8080/Ecommmerce/user/read/user/' + params
  )
}
// 注册账号
export const register = params => {
  return http.fetchPost(
    'http://39.108.191.78:8080/Ecommmerce/user/register',
    params
  )
}
// 上传图片
export const upload = params => {
  return http.fetchPost('/member/imgaeUpload', params)
}
// 修改头像
export const updateheadimage = params => {
  return http.fetchPost('/member/updateheadimage', params)
}
// 修改用户信息
export const updateUserInfo = params => {
  return http.fetchPost(
    'http://39.108.191.78:8080/Ecommmerce/user/update/userInfo',
    params
  )
}
// 捐赠列表
export const thanksList = params => {
  return http.fetchGet('/member/thanks', params)
}
// 首页接口
export const productHome = params => {
  return http.fetchGet(
    'http://39.108.191.78:8080/Ecommmerce/plate/selectByPlate',
    params
  )
}
// 首页接口,获取标题列表
export const navList = params => {
  return http.fetchGet('/goods/navList', params)
}
// 推荐板块
export const recommend = params => {
  return http.fetchGet('/goods/recommend', params)
}
// 捐赠板块
export const thank = params => {
  return http.fetchGet('/goods/thank', params)
}
// 极验验证码
// export const geetest = params => {
//   return http.fetchGet('/member/geetestInit?t=' + new Date().getTime(), params)
// }
export const geetest = params => {
  return http.fetchGet('http://echarts.baidu.com/examples/data-gl/asset/data/population.json')
}
