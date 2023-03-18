<template>
  <navbar class="container-fluid navbar-fixed-bottom" v-if="$store.state.user.id">
    <ul class="nav justify-content-center">
      <li class="nav-item">
        <router-link class="nav-link active" aria-current="page" to="/admin" href="#">관리자</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link active" aria-current="page" href="#" to="/home">성경</router-link>
      </li>
<!--      <li class="nav-item">-->
<!--        <router-link :to="{path:`/member/${$store.state.user.id}`}" class="nav-link active" aria-current="page" href="#">내 정보</router-link>-->
<!--      </li>-->
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" @click="logout" v-if="$store.state.user.id" href="#">로그아웃</a>
      </li>
    </ul>
  </navbar>
</template>
<script>
import store from "@/script/store";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: 'AppHeader',
  components: {
  },
  methods: {
    bibleList(version) {
      router.push('/home/' + version);
    },
    logout() {
      if(!confirm('로그아웃 하시겠습니까?')) {
        return;
      }
      store.commit('removeUser');
      VueCookies.remove('access_token');
      VueCookies.remove('memName');
      router.push({path: '/'});
    }
  }
}
</script>
<style>
/*var {*/
/*  position: fixed;*/
/*  bottom: 0;*/
/*  !* width: 100% *!*/
/*  left: 0;*/
/*  right: 0;*/
/*  display: flex;*/
/*  !* 생략 *!*/
/*}*/

navbar {
  position: fixed;
  background-color: skyblue;
  left: 0;
  right: 0;
  bottom: 0;
  height: 4rem;
}
</style>
