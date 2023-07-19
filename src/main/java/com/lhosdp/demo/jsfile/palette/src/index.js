import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import RedirectIndex from '@/views/redirect/index'
import LoginIndex from '@/views/login/index'
import NewLogin from '@/views/login/login'

/* Layout */
import Layout from '@/layout'

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
    {
      path: '/redirect',
      component: Layout,
      hidden: true,
      children: [{
          path: '/redirect/:path*',
          component: RedirectIndex
        }]
    }, {
      path: '/',
      component: Layout,
      redirect: '/autoFlow/list'
    },{
      path: '/newlogin',
      component: NewLogin,
      hidden: false
    }, {
      path: '/deploy',
      component: Layout,
      hidden: true,
      children: [{
        path: 'list',
        component: () => import('@/views/deploy/list'),
      }, {
        path: 'create',
        component: () => import('@/views/deploy/create'),
      }, {
        path: 'detail/:deploymentId',
        name: 'DeploymentDetail',
        component: () => import('@/views/deploy/detail'),
      }]
    }, {
      path: '/autoFlow',
      component: Layout,
      name: '自动化流程',
      meta: {
        title: '自动化流程',
        icon: 'points'
      },
      children: [{
        name: '自动化流程列表',
        path: 'list',
        meta: { title: '自动化流程列表', noCache: true },
        component: () => import('@/views/autoFlow/list'),
      }, {
        path: 'create',
        name: '创建自动化流程',
        component: () => import('@/views/autoFlow/create'),
      }, {
        path: 'processList/:strategyId',
        name: '自动化流程明细',
        hidden: true,
        component: () => import('@/views/autoFlow/processList'),
      }, {
        path: 'detail/:strategyId/:processId',
        name: '自动化流程明细',
        hidden: true,
        component: () => import('@/views/autoFlow/detail'),
      }, {
        path: 'statistics/:strategyId/:processId',
        name: '自动化流程统计',
        hidden: true,
        component: () => import('@/views/autoFlow/statistics'),
      },{
        path: 'strategyStatistics/:name/:processId/:strategyId/:planId',
        name: '执行计划中策略自动化流程统计',
        hidden: true,
        component: () => import('@/views/autoFlow/startetyStatistics'),
      },{
        path: 'auditlist/:stateId',
        name: '自动化流程审核记录',
        hidden: true,
        component: () => import('@/views/autoFlow/autoAuditlist'),
      }]
    }, {
      path: '/plan',
      component: Layout,
      name: '执行计划',
      meta: {
        title: '执行计划',
        icon: 'points'
      },
      children: [{
        path: 'create',
        name: '新建执行计划',
        meta: { title: '新建执行计划', noCache: true },
        component: () => import('@/views/plan/detail'),
      }, {
        path: 'list',
        name: '执行计划列表',
        meta: { title: '执行计划列表', noCache: true },
        component: () => import('@/views/plan/list'),
      }, {
        path: 'detail/:planId/:view',
        name: '执行计划流程明细',
        hidden: true,
        component: () => import('@/views/plan/detail'),
      },{
        path: 'statistics/:planId',
        // name: '执行计划列表详情效果分析',
        // meta: { title: '执行计划列表', noCache: true },
        component: () => import('@/views/plan/statisticsDemo'),
      },
        {
          path: 'auditlist/:stateId',
          name: '执行计划审核记录',
          hidden: true,
          component: () => import('@/views/plan/planAuditlist'),
        }]
    }, {
      path: '/abtest',
      component: Layout,
      name: 'AB测试',
      meta: {
        title: 'AB测试',
        icon: 'points'
      },
      children: [{
        path: 'create',
        name: '创建AB测试',
        meta: { title: '创建AB测试', noCache: true },
        component: () => import('@/views/abtest/detail'),
      },
      {
        path: 'schemelist',
        name: 'AB测试方案列表',
        meta: { title: 'AB测试方案列表', noCache: true },
        component: () => import('@/views/abtest/schemelist'),
      },
      {
        path: 'testRecordlist',
        name: 'AB测试记录列表',
        meta: { title: 'AB测试记录列表', noCache: true },
        component: () => import('@/views/abtest/testRecordlist'),
      },
       {
        path: 'detail/:testId/:view',
        name: '创建AB测试',
         hidden: true,
        component: () => import('@/views/abtest/detail'),
      },

      {
        path: 'report/:testId',
        component: () => import('@/views/abtest/reportDemo'),
      },
      {
        path: 'viewAudit',
        component: () => import('@/views/abtest/viewAudit'),
      },
        {
          path: 'auditlist/:stateId',
          name: 'AB测试审核记录',
          hidden: true,
          component: () => import('@/views/abtest/abtestAuditlist'),
        }
    ]
    }
];

var otherRouter = [];
/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = []

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes.concat(otherRouter)
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
