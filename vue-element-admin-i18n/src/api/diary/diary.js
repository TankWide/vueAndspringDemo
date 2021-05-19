import request from '@/utils/request'
import store from '@/store'
import { logout } from '@/api/user'
import { removeToken } from '@/utils/auth'

export function queryDiaryList(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/diaryController/queryDiaryList',
      headers: {
        'token': store.getters.token
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
      url: '/szacrm-manager-customer/diaryController/addDiary',
      headers: {
        'token': store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function uploadContract(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/diaryController/uploadContract',
      headers: {
        'token': store.getters.token
      },
      method: 'POST',
      data
    })
  }
}
export function getUrl(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/diaryController/getUrl',
      headers: {
        'token': store.getters.token
      },
      method: 'POST',
      data
    })
  }
}
