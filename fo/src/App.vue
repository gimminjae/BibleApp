<template>
  <AppHeader></AppHeader>
  <RouterView></RouterView>
</template>

<script>
import {useRoute} from "vue-router";
import {watch} from "vue";
import AppHeader from "@/pages/AppHeader";
import VueCookies from "vue-cookies";
import store from "@/script/store";
import router from "@/script/router";
import axios from "axios";

export default {
  name: 'App',
  components: {
    AppHeader
  },
  methods: {
    requireAuth(from, to, next) {
      const token = store.state.user.role;
      if (token) {
        return next();
      } // isLogin === true면 페이지 이동
      next('/login') // isLogin === false면 다시 로그인 화면으로 이동
    },
    check() {
      const jwt = VueCookies.get('access_token');

      let config = {
        headers: {
          "Authorization": jwt
        }
      }
      axios.get("/api/member/me", config)
          .then(res => {
            console.log(res.data.member);
            const user = res.data.member;

            if(user == null) {
              router.push({path: '/login'});
            }

            if (user != null) {
              store.commit('setUser', user);
            }
          })
          .catch(() => {
            router.push({path: '/login'});
              }
          );
    }
  },
  beforeCreate() {
    //쿠키의 jwt로 회원정보를 가져옴
    const route = useRoute();

    watch(route, () => {
      this.check();
    });
  }
}
</script>

<style>

</style>
