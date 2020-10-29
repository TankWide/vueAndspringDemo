import request from '@/utils/request'
import store from '@/store'
import { logout } from '@/api/user'
import { removeToken } from '@/utils/auth'

export function CClientManageSelect(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/helloController/first',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function addDiary(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/helloController/addDiary',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}
