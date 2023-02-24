import {createRouter, createWebHistory} from "vue-router";
import AppLogin from "@/pages/member/AppLogin.vue";
import AppHome from "@/pages/AppHome";
import AppJoin from "@/pages/admin/AppJoin.vue";
import UserPage from "@/pages/member/UserPage.vue";
import BookDetail from "@/pages/book/BookDetail.vue";
import BookForm from "@/pages/admin/BookForm.vue";
import BookModify from "@/pages/admin/BookModify.vue";
import MembersPage from "@/pages/admin/MembersPage.vue";
import BooksPage from "@/pages/admin/BooksPage.vue";
import BookRequest from "@/pages/book/BookRequest.vue";
import store from "@/script/store";
import NaverBooks from "@/pages/admin/NaverBooks.vue";


const routes = [
    {
        path: '/home', component: AppHome,
        meta: {
            roles: ['MEMBER', 'ADMIN']
        }
    },
    {
        path: '/book/:id', component: BookDetail,
        meta: {
            roles: ['MEMBER', 'ADMIN']
        }
    },
    {
        path: '/', component: AppLogin,
        meta: {
            roles: ['UNKNOWN']
        }
    },
    {
        path: '/join', component: AppJoin,
        meta: {
            roles: ['ADMIN']
        }
    },
    {
        path: '/signup', component: BookForm,
        meta: {
            roles: ['ADMIN']
        }
    },
    {
        path: '/modify/:id', component: BookModify,
        meta: {
            roles: ['ADMIN']
        }
    },
    {
        path: '/:nickname', component: UserPage,
        meta: {
            roles: ['MEMBER', 'ADMIN']
        }
    },
    {
        path: '/members', component: MembersPage,
        meta: {
            roles: ['ADMIN']
        }
    },
    {
        path: '/books', component: BooksPage,
        meta: {
            roles: ['ADMIN']
        }
    },
    {
        path: '/requestBook', component: BookRequest,
        meta: {
            roles: ['MEMBER', 'ADMIN']
        }
    },
    {
        path: '/naverbooks', component: NaverBooks,
        meta: {
            roles: ['ADMIN']
        }
    }
    // {path: '/modify/:id', component: BoardModify},
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

//member권한의 회원이 관리자 페이지에 접근시, 로그인 상태인데도 로그인 페이지로 넘어감
router.beforeEach((to, from, next) => {
        let roleStatus = store.state.user.role; // 권한 상태
        // if(roleStatus === "UNKNOWN") {
        //     next({path:'login'});
        // }
        console.log(roleStatus);
        if (!to.meta.roles.includes(roleStatus)) {
            alert('해당 페이지에 접근 권한이 없습니다.')
            next(from)
        } else {
            next()
        }
    }
);
export default router;
