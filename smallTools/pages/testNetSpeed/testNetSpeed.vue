<template>
	<view class="charts-box">
		<qiun-data-charts type="gauge" :opts="opts" :chartData="chartData" background="none" />
		<view class="uni-h2 uni-common-mt animation-button">网络状态：{{networkType}}</view><br><br>
		<button class="animation-button" @tap="testNet">点击开始测速</button><br><br><br>
		<button class="netSpeed-button" v-if="netSpeed" style="color:#2fc25b ;">{{netSpeed}}</button>
	</view>
</template>

<script>
	import uCharts from '@/plugins/stan-ucharts/u-charts/u-charts.js';
	export default {
		data() {
			return {
				networkType: '',
				beforeTime: '',
				afterTime: '',
				netSpeed: '',
				fileSize: '22',
				chartData: {
					"categories": [{
						"value": 0.2,
						"color": "#1890ff"
					}, {
						"value": 0.8,
						"color": "#2fc25b"
					}, {
						"value": 1,
						"color": "#f04864"
					}],
					"series": [{
						"name": "完成率",
						"data": 0.8
					}]
				},
				opts: {
					title: {
						name: '0Mb/s',
						color: '#2fc25b',
						fontSize: 25,
						offsetY: 50
					},
					subtitle: {
						name: '实时网速',
						color: '#666666',
						fontSize: 15,
						offsetY: -50
					}
				}
			}
		},
		components: {
			uCharts
		},
		onLoad(e) {
			this.init()
		},
		onReady() {},
		methods: {
			init() {
				this.getNetworkType()
			},
			getNetworkType: function() {
				uni.getNetworkType({
					success: (res) => {
						console.log(res)
						this.networkType = res.subtype || res.networkType
					},
					fail: () => {
						uni.showModal({
							content: '获取失败！',
							showCancel: false
						})
					}
				})
			},
			testNet: function() {
				uni.showLoading({
					title: '测试中'
				})
				this.beforeTime = new Date().getTime()
				var self = this
				const downloadTask = uni.downloadFile({
					url: "http://121.41.224.54:8080/5.13.rar",
					success: (res) => {
						uni.hideLoading();
						uni.getFileInfo({
							filePath: res.tempFilePath,
							success: (resItem) => {
								this.afterTime = new Date().getTime()
								this.netSpeed = this.toDecimal2(resItem.size / 1024 / 1024 / ((
									this.afterTime -
									this.beforeTime) / 1000).toFixed(2))
								this.netSpeed = this.netSpeed > 1 ? this.netSpeed + 'Mb/s' :
									this.netSpeed * 1024 + 'Kb/s'
								this.opts.title.name = this.netSpeed
							}
						})
					},
					fail: (err) => {
						console.log('downloadFile fail, err is:', err)
					},
					complete: () => {}
				})
				// downloadTask.onProgressUpdate((res) => {
				// 	// console.log('下载进度' + res.progress);
				// 	// console.log('已经下载的数据长度' + res.totalBytesWritten);
				// 	// console.log('预期需要下载的数据总长度' + res.totalBytesExpectedToWrite);
				// 	if (res.totalBytesWritten == res.totalBytesExpectedToWrite) {
				// 		this.afterTime = new Date().getTime()
				// 		console.log(this.beforeTime)
				// 		console.log(this.afterTime)
				// 		this.netSpeed=res.totalBytesExpectedToWrite/1024/1024/((this.afterTime - this.beforeTime)/1000)
				// 		console.log((this.afterTime - this.beforeTime) / 1000 / res.totalBytesExpectedToWrite)
				// 	}

				// 	// 测试条件，取消下载任务。
				// 	// if (res.progress > 50) {
				// 	// 	downloadTask.abort();
				// 	// }
				// })

			},
			//2.强制保留2位小数，如：2，会在2后面补上00.即2.00
			toDecimal2: function(x) {
				var f = parseFloat(x);
				if (isNaN(f)) {
					return false;
				}
				var f = Math.round(x * 100) / 100;
				var s = f.toString();
				var rs = s.indexOf('.');
				if (rs < 0) {
					rs = s.length;
					s += '.';
				}
				while (s.length <= rs + 2) {
					s += '0';
				}
				return s;
			}
		}
	}
</script>

<style>
	.charts-box {
		width: 100%;
		height: 300px;
		text-align: center;
	}

	.animation-button {
		width: 94%;
	}

	.netSpeed-button {
		width: 40%;
	}
</style>
