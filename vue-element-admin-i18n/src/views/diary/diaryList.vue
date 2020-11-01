<template>
  <div class="diaryList">
    <el-form :inline="true" :model="diaryForm" class="demo-form-inline">
      <el-form-item label="写作日期:">
        <el-date-picker
          v-model="diaryForm.time"
          type="daterange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        />
      </el-form-item>
      <el-form-item label="日记标题:">
        <el-input v-model="diaryForm.user" placeholder="日记名称" />
      </el-form-item>
      <el-form-item label="姓名:">
        <el-select v-model="diaryForm.userName" placeholder="姓名">
          <el-option
            v-for="item in diaryUser"
            :key="item.id"
            :label="item.username"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
      v-loading="tableloading"
      :data="tableData"
      border
      style="width: 100%"
    >
      <el-table-column
        prop="creatTime"
        label="写作日期"
        width="180"
      />
      <el-table-column
        prop="diaryHead"
        label="日记标题"
        width="180"
      />
      <el-table-column
        prop="userName"
        label="姓名"
      />
    </el-table>
  </div>
</template>

<script>

import { queryDiaryList } from '@/api/diary/diary.js'
import { userList } from '@/api/user.js'
import { isEmpty } from '@/utils/isEmpty.js'

export default {
  data() {
    return {
      tableloading: true,
      diaryUser: [],
      tableData: [],
      diaryForm: {
        diaryHead: null,
        userName: null,
        time: [],
        startCreatTime: null,
        endCreatTime: null,
        diaryContent: null
      }
    }
  },
  created() {
    this.queryDiaryList()
    this.userList()
  },
  methods: {
    queryDiaryList() {
      this.tableloading = true
      queryDiaryList(this.diaryForm).then((response) => {
        if (response.code === 200) {
          this.tableData = response.data
        }
      })
      this.tableloading = false
    },
    userList() {
      userList().then((response) => {
        if (response.code === 200) {
          this.diaryUser = response.data
        }
      })
    },
    onSubmit() {
      if (!isEmpty(this.diaryForm.time)) {
        this.diaryForm.startCreatTime = this.diaryForm.time[0]
        this.diaryForm.endCreatTime = this.diaryForm.time[1]
      }
      this.queryDiaryList()
    }
  }
}
</script>

<style lang="scss" scoped>
.diaryList{
  padding: 20px;
}
.icons-container {
  margin: 10px 20px 0;
  overflow: hidden;

  .grid {
    position: relative;
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
  }

  .icon-item {
    margin: 20px;
    height: 85px;
    text-align: center;
    width: 100px;
    float: left;
    font-size: 30px;
    color: #24292e;
    cursor: pointer;
  }

  span {
    display: block;
    font-size: 16px;
    margin-top: 10px;
  }

  .disabled {
    pointer-events: none;
  }
}
</style>
