<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%"
  >
    <el-table-column
      prop="createTime"
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
</template>

<script>
// import clipboard from '@/utils/clipboard'
// import svgIcons from './svg-icons'
// import elementIcons from './element-icons'
import { queryDiaryList } from '@/api/diary/diary.js'

export default {
  data() {
    return {
      tableData: [],
      form: {
        diaryHead: '11',
        diaryContent: '11'
      }
    }
  },
  created() {
    this.queryDiaryList()
  },
  methods: {
    queryDiaryList() {
      queryDiaryList(this.form).then((response) => {
        console.log(response)
        if (response.code === 200) {
          this.tableData = response.data
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
