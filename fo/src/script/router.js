import {createRouter, createWebHistory} from "vue-router";
import AppLogin from "@/pages/member/AppLogin.vue";
import AppHome from "@/pages/AppHome";
import AppJoin from "@/pages/member/AppJoin.vue";
import store from "@/script/store";
import AppBibleChartDetail from "@/pages/AppBibleChartDetail.vue";
import UserPage from "@/pages/member/UserPage.vue";
import ModifyMemInfo from "@/pages/member/modifyMemInfo.vue";
import ModifyMemPw from "@/pages/member/modifyMemPw.vue";


const routes = [
    {
        path: '/home', component: AppHome,
        meta: {
            roles: ['MEMBER', 'ADMIN']
        }
    },
    {
        path: '/', component: AppLogin,
        meta: {
            roles: ['UNKNOWN', '']
        }
    },
    {
        path: '/join', component: AppJoin,
        meta: {
            roles: ['UNKNOWN', '']
        }
    },
    {
        path: '/bibleChart/:bibleChartIdx', component: AppBibleChartDetail,
        meta: {
            roles: ['MEMBER', 'ADMIN', 'SUBADMIN']
        }
    },
    {
        path: '/member/:memberIdx', component: UserPage,
        meta: {
            roles: ['MEMBER', 'ADMIN', 'SUBADMIN']
        }
    },
    {
        path: '/modify/memberInfo', component: ModifyMemInfo,
        meta: {
            roles: ['MEMBER', 'ADMIN', 'SUBADMIN']
        }
    },
    {
        path: '/modify/memberPw', component: ModifyMemPw,
        meta: {
            roles: ['MEMBER', 'ADMIN', 'SUBADMIN']
        }
    },


]
const router = createRouter({
    history: createWebHistory(),
    routes
})

//member권한의 회원이 관리자 페이지에 접근시, 로그인 상태인데도 로그인 페이지로 넘어감
router.beforeEach((to, from, next) => {
        let roleStatus = store.state.user.role; // 권한 상태
        if (roleStatus == null) {
            roleStatus = '';
        }
        if (!to.meta.roles.includes(roleStatus)) {
            console.log('권한 문제');
            next(from)
        } else {
            next()
        }
    }
);
export default router;
