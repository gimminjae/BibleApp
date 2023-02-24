<template>
  <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-between py-3 mb-4 border-bottom">
    <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
      <img src="public/images/logo.png" alt="">
    </a>

    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0" v-if="$store.state.user.id != 0"> <!-- v-if="$store.state.user.id != 0" -->
      <li><router-link to="/home" href="#" class="nav-link px-2 link-dark">구약</router-link></li>
      <li><router-link to="/home" href="#" class="nav-link px-2 link-dark">신약</router-link></li>
<!--      <li><router-link to="/requestBook" href="#" class="nav-link px-2 link-dark">Request Book</router-link></li>-->
      <li v-if="$store.state.user.memName === 'ADMIN'">
        <div class="btn-group">
          <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            ADMIN
          </button>
          <ul class="dropdown-menu"> <!-- 관리자 메뉴 -->
            <li><router-link to="/members" href="#" class="dropdown-item">Members</router-link></li>
            <li><router-link to="/books" href="#" class="dropdown-item">Books</router-link></li>
            <li><router-link to="/naverbooks" href="#" class="dropdown-item">SearchBooks</router-link></li>
            <li><router-link to="/signup" href="#" class="dropdown-item">sign up book</router-link></li>
          </ul>
        </div>
      </li>
    </ul>

    <div class="col-md-3 text-end mr-3">
      <a @click="logout" class="btn btn-outline-primary me-2" href="#" v-if="$store.state.user.id != 0">Logout</a>
    </div>
  </header>
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

</style>
