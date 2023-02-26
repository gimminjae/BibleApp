<template>

  <nav class="navbar navbar-dark bg-dark fixed-top" v-if="$store.state.user.id">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">{{ $store.state.user.memName }} 님 안녕하세요!</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Dark offcanvas</h5>
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
          <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item">
              <router-link class="nav-link active" aria-current="page" href="#" to="/home">성경</router-link>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">회원</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" @click="logout" v-if="$store.state.user.id" href="#">로그아웃</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
<!--  <footer class="navbar fixed-bottom bg-body-tertiary d-flex flex-wrap align-items-center justify-content-center justify-content-between py-3 border-bottom">-->
<!--    <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">-->
<!--      <img src="public/images/logo.png" alt="">-->
<!--    </a>-->

<!--    <ul class="nav col-12 col-md-auto mb-2 justify-content-around mb-md-0" v-if="$store.state.user.id"> &lt;!&ndash; v-if="$store.state.user.id != 0" &ndash;&gt;-->
<!--&lt;!&ndash;      <li v-if="$store.state.user.role === 'ADMIN'">&ndash;&gt;-->
<!--&lt;!&ndash;        <div class="btn-group">&ndash;&gt;-->
<!--&lt;!&ndash;          <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">&ndash;&gt;-->
<!--&lt;!&ndash;            ADMIN&ndash;&gt;-->
<!--&lt;!&ndash;          </button>&ndash;&gt;-->
<!--&lt;!&ndash;          <ul class="dropdown-menu"> &lt;!&ndash; 관리자 메뉴 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;            <li><router-link to="/members" href="#" class="dropdown-item">Members</router-link></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><router-link to="/books" href="#" class="dropdown-item">Books</router-link></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><router-link to="/naverbooks" href="#" class="dropdown-item">SearchBooks</router-link></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><router-link to="/signup" href="#" class="dropdown-item">sign up book</router-link></li>&ndash;&gt;-->
<!--&lt;!&ndash;          </ul>&ndash;&gt;-->
<!--&lt;!&ndash;        </div>&ndash;&gt;-->
<!--&lt;!&ndash;      </li>&ndash;&gt;-->
<!--      <li>-->
<!--        <div class="dropup-center dropup">-->
<!--          <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--            성경-->
<!--          </button>-->
<!--          <ul class="dropdown-menu">-->
<!--            <li><a class="dropdown-item" href="#" @click="bibleList('old')">구약</a></li>-->
<!--            <li><a class="dropdown-item" href="#" @click="bibleList('new')">신약</a></li>-->
<!--            <li><a class="dropdown-item" href="#">목표달성률? or 부서 현황?</a></li>-->
<!--          </ul>-->
<!--        </div>-->
<!--      </li>-->
<!--      <li>-->
<!--        <div class="dropup-center dropup">-->
<!--          <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--            회원-->
<!--          </button>-->
<!--          <ul class="dropdown-menu">-->
<!--            <li><a @click="logout" class="dropdown-item" href="#" v-if="$store.state.user.id">Logout</a></li>-->
<!--            <li><a class="dropdown-item" href="#">회원 정보</a></li>-->
<!--          </ul>-->
<!--        </div>-->
<!--      </li>-->
<!--    </ul>-->
<!--    <div class="col-md-3 text-end mr-3">-->
<!--    </div>-->
<!--  </footer>-->
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
/*header {*/
/*  position: fixed;*/
/*  top: 0;*/
/*  !* width: 100% *!*/
/*  left: 0;*/
/*  right: 0;*/
/*  display: flex;*/
/*  !* 생략 *!*/
/*}*/
</style>
