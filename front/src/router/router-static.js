import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'

Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import sixiangpindechengji from '@/views/modules/sixiangpindechengji/list'
import xuesheng from '@/views/modules/xuesheng/list'
import xueshengchufa from '@/views/modules/xueshengchufa/list'
import jiangxuejinshenqing from '@/views/modules/jiangxuejinshenqing/list'
import jiangxiangmingcheng from '@/views/modules/jiangxiangmingcheng/list'
import jiaoshi from '@/views/modules/jiaoshi/list'
import xueshengchengji from '@/views/modules/xueshengchengji/list'
import menu from '@/views/modules/menu/list'
import users from '@/views/modules/users/list'
import pingjiangpingyoujieguo from '@/views/modules/pingjiangpingyoujieguo/list'
import notice from '@/views/modules/notice/list'

//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
        // 这里不设置值，是把main作为默认页面
        path: '/',
        name: '首页',
        component: Home,
        meta: {icon: '', title: 'center'}
    }, {
        path: '/updatePassword',
        name: '修改密码',
        component: UpdatePassword,
        meta: {icon: '', title: 'updatePassword'}
    }, {
        path: '/pay',
        name: '支付',
        component: pay,
        meta: {icon: '', title: 'pay'}
    }, {
        path: '/center',
        name: '个人信息',
        component: center,
        meta: {icon: '', title: 'center'}
    }
        , {
            path: '/sixiangpindechengji',
            name: '思想品德成绩',
            component: sixiangpindechengji
        }
        , {
            path: '/xuesheng',
            name: '学生',
            component: xuesheng
        }
        , {
            path: '/xueshengchufa',
            name: '学生处罚',
            component: xueshengchufa
        }
        , {
            path: '/jiangxuejinshenqing',
            name: '奖学金申请',
            component: jiangxuejinshenqing
        }
        , {
            path: '/jiangxiangmingcheng',
            name: '奖项名称',
            component: jiangxiangmingcheng
        }
        , {
            path: '/jiaoshi',
            name: '教师',
            component: jiaoshi
        }
        , {
            path: '/xueshengchengji',
            name: '学生成绩',
            component: xueshengchengji
        }
        , {
            path: '/menu',
            name: '菜单列表',
            component: menu
        }
        , {
            path: '/users',
            name: '管理员',
            component: users
        }
        , {
            path: '/pingjiangpingyoujieguo',
            name: '评奖评优结果',
            component: pingjiangpingyoujieguo
        }
        , {
            path: '/notice',
            name: '公告',
            component: notice
        }
    ]
},
    {
        path: '/login',
        name: 'login',
        component: Login,
        meta: {icon: '', title: 'login'}
    },
    {
        path: '/register',
        name: 'register',
        component: register,
        meta: {icon: '', title: 'register'}
    },
    {
        path: '/',
        name: '首页',
        redirect: '/index'
    }, /*默认跳转路由*/
    {
        path: '*',
        component: NotFound
    }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',
    /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;
