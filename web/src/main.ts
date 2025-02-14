import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue'
// 使用Ant Design of Vue 4.x版本开发时，报错无法解析antd样式文件。
// 查看依赖文件发现并不存在antd.css文件，查阅文档得知，这是1.7.8版本的使用方式，在最新的4.x版本中已经将antd.css文件修改名称为reset.css文件
import 'ant-design-vue/dist/reset.css'
import * as Icons from '@ant-design/icons-vue'
import axios from 'axios'

//App报红，及TypeScript版本过低，然后刷新TypeScript重启服务
const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app')

//axios全局配置地址省略process.env.VUE_APP_SERVER
axios.defaults.baseURL = process.env.VUE_APP_SERVER;

/**
 * axios拦截器 使用日志查看信息
 */
axios.interceptors.request.use(function (config) {
    console.log('请求参数：', config);
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    console.log('返回结果：', response);
    return response;
}, error => {
    console.log('返回错误：', error);
    return Promise.reject(error);
});

// 使用全局图标，遇到不同图标不需要一个个import
const icons: any = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

//process.env读取环境参数的
console.log("环境", process.env.NODE_ENV);
console.log("服务端", process.env.VUE_APP_SERVER);
