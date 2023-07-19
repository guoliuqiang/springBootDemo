import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui';
import * as echarts from 'echarts'
import 'element-ui/lib/theme-chalk/index.css';
import '@/styles/index.scss' // global css
import '@/styles/public.scss'
import '@/styles/resetUI.scss'

import './permission' // permission control

Vue.config.productionTip = false

Vue.use(ElementUI,echarts);
Vue.prototype.$echarts = echarts

import router from './router'
import store from './store'

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
