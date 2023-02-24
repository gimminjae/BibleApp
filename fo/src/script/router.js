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

const routes = [
    {
        path: '/', component: AppHome,
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
        path: '/login', component: AppLogin,
        meta: {
            roles: ['MEMBER', 'ADMIN']
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
    }
    // {path: '/modify/:id', component: BoardModify},
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
