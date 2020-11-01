import request from '@/utils/request'
import store from '@/store'
export function login(data) {
  return request({
    url: '/szacrm-manager-customer/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/szacrm-manager-customer/user/info',
    method: 'get',
    headers: {
      'token': store.getters.token
    },
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/szacrm-manager-customer/user/logout',
    method: 'post'
  })
}

export function userList(token) {
  return request({
    url: '/szacrm-manager-customer/user/userList',
    method: 'post',
    headers: {
      'token': store.getters.token
    },
    params: { token }
  })
}
