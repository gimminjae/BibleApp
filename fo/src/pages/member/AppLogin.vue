<template>
  <div class="text-center" style="margin-top: 20%;">
    <div class="card text-bg-dark mx-3">
      <img class="card-img" src="@/assets/totalGuriYoung.png" alt="" style="max-width: 100%; height: auto;">
      <div class="card-img-overlay">
        <h1>하나님께서 함께 하시는</h1>
        <h1>구리교회 청년회</h1>
      </div>
    </div>
  </div>
  <div class="mx-auto my-auto" style="width: 80%;">
    <div class="mb-3 mt-3">
      <h3>ID</h3>
      <input class="form-control form-control-lg" type="text" placeholder="ID(username)" id="username"
             aria-label=".form-control-lg example" v-model="this.MemberDto.username" @keyup.enter="login">
    </div>
    <div class="mb-3">
      <h3>PW</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password"
             aria-label=".form-control-lg example" v-model="this.MemberDto.password" @keyup.enter="login">
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-primary" @click="login">로그인</button>
      <button style="width: 48%;" type="button" class="btn btn-secondary" @click="join">회원가입</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";
import router from "@/script/router";
import store from "@/script/store";

export default {
  name: "AppLogin",
  components: {},
  methods: {
    join() {
      router.push('/join');
    },
    login() {
      if (this.MemberDto.username.trim().length == 0) {
        alert('아이디를 입력하세요');
        document.getElementById('username').focus();
        return;
      }
      if (this.MemberDto.password.trim().length == 0) {
        alert('비밀번호를 입력하세요');
        document.getElementById('password').focus();
        return;
      }
      axios.post("/api/member/login", this.MemberDto)
          .then(({data}) => {
            //토큰
            const jwt = data.accessToken;
            const memName = data.memName;

            //토큰의 유효기간
            const expire = 60 * 60 * 24;

            //쿠키에 토큰을 저장한다.
            //보안 옵션을 줘도 https를 사용하지 않으면 보안 옵션은 작동하지 않는다.
            VueCookies.set('access_token', jwt, {
              expires: expire,
              secure: true,
              httpOnly: true,
              sameSite: 'strict'
            });
            VueCookies.set('memName', memName, {
              expires: expire,
              secure: true,
              httpOnly: true,
              sameSite: 'strict'
            });

            axios.get("/api/member/me", { headers: { "Authorization": VueCookies.get('access_token') }})
                .then(res => {
                  const user = res.data.member;

                  if(user == null) {
                    router.push({path: '/'});
                  }

                  if (user != null) {
                    store.commit('setUser', user);
                  }

                  //로그인 후 홈페이지로 이동
                  router.push({path: `/home`});
                })
                .catch(() => {
                      router.push({path: '/'});
                    }
                );
          })
          .catch((error) => {
            alert(error);
          });
    }
  },
  data() {
    return {
      MemberDto: {
        username: "",
        password: ""
      }
    }
  },
}
</script>
<style scoped>

</style>
