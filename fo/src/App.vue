<template>
  <div class="headerbar" v-if="$store.state.user.id">
    상단바
  </div>
  <RouterView></RouterView>
  <AppHeader></AppHeader>
</template>

<script>
import {useRoute} from "vue-router";
import {watch} from "vue";
import AppHeader from "@/pages/AppHeader.vue";
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
    check() {
      const jwt = VueCookies.get('access_token');

      let config = {
        headers: {
          "Authorization": jwt
        }
      }
      axios.get("/api/member/me", config)
          .then(res => {
            const user = res.data.member;

            // if(user === "unknown") {
            //   if(!confirm('계정이 있으십니까?')) {
            //     router.push('/join');
            //   }
            //   router.push('/');
            // }

            if (user != null) {
              store.commit('setUser', user);
            }
          })
          .catch(() => {
            router.push({path: '/'});
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

<style scoped>
.headerbar {
  z-index: 10;
  position: fixed;
  background-color: skyblue;
  left: 0;
  right: 0;
  top: 0;
  height: 4rem;
}
</style>
