import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue'
// 使用Ant Design of Vue 4.x版本开发时，报错无法解析antd样式文件。
// 查看依赖文件发现并不存在antd.css文件，查阅文档得知，这是1.7.8版本的使用方式，在最新的4.x版本中已经将antd.css文件修改名称为reset.css文件
import 'ant-design-vue/dist/reset.css'

//App报红，及TypeScript版本过低，然后刷新TypeScript重启服务
createApp(App).use(store).use(router).use(Antd).mount('#app')
