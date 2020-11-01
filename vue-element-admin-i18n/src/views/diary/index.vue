<template>
  <div class="icons-container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="日记头">
        <el-input v-model="form.diaryHead" />
      </el-form-item>
      <el-form-item label="日记内容">
        <el-input v-model="form.diaryContent" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
// import clipboard from '@/utils/clipboard'
// import svgIcons from './svg-icons'
// import elementIcons from './element-icons'
import { addDiary } from '@/api/diary/diary.js'
import store from '@/store/index.js'

export default {
  data() {
    return {
      form: {
        diaryHead: '',
        diaryContent: ''
      }
    }
  },
  methods: {
    onSubmit() {
      addDiary(this.form).then((response) => {
        store.getters.roles
        console.log(response)
        if (response.data.status === 'success') {
          this.$message.success('新增成功!')
          this.tCustomerReceiptDialog = false
          this.getCustomerReceipt()
        } else {
          this.$message.error('新增失败!')
        }
      })
      console.log('submit!')
    }
  }
}
</script>

<style lang="scss" scoped>
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
