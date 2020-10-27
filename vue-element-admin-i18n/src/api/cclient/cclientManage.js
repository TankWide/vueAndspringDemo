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
      url: '/szacrm-manager-customer/CClientManage/CClientManageSelect',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientDetailsSelect(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientDetailsSelect',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientDetailsSelectNo(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientDetailsSelectNo',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientCerttype(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientCerttype',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientInsert(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientInsert',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientDelete(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientDelete',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function CClientUpdate(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/CClientUpdate',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}

export function checkTheTield(data) {
  if (store.getters.token === null || store.getters.token === undefined || store.getters.token === '') {
    logout().then(() => {
      removeToken()
      location.reload()
    })
  } else {
    return request({
      url: '/szacrm-manager-customer/CClientManage/checkTheTield',
      headers: {
        'Authorization': 'Bearer ' + store.getters.token
      },
      method: 'POST',
      data
    })
  }
}
