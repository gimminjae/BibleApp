<template>
  <div class="mx-auto my-auto" style="max-width: 50%; min-width: 40%;">
    <div class="mb-3 mt-3">
      <h3>ID</h3>
      <input class="form-control form-control-lg" type="text" placeholder="ID" id="id"
             aria-label=".form-control-lg example" v-model="this.MemberDto.userId" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>PW</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password"
             aria-label=".form-control-lg example" v-model="this.MemberDto.password" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>MemberName</h3>
      <input class="form-control form-control-lg" type="text" placeholder="계정이름" id="MemberName"
             aria-label=".form-control-lg example" v-model="this.MemberDto.memName" @keyup.enter="join">
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-info" @click="join">계정생성</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import router from "@/script/router";
import VueCookies from "vue-cookies";

export default {
  name: "AppJoin",
  methods: {
    join() {
      if (this.MemberDto.userId.trim().length == 0) {
        alert('아이디를 입력하세요');
        document.getElementById('username').focus();
        return;
      }
      if (this.MemberDto.password.trim().length == 0) {
        alert('비밀번호를 입력하세요');
        document.getElementById('password1').focus();
        return;
      }
      if (this.MemberDto.memName.trim().length == 0) {
        alert('닉네임을 입력하세요');
        document.getElementById('MemberName').focus();
        return;
      }
      let config = {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }
      console.log(this.MemberDto);
      axios.post(`/api/admin/member`, this.MemberDto, config)
          .then(() => {
            router.push({path: '/members'});
          }).catch((error) => {
            alert('계정 생성 실패 : ', error);
      });
    }
  },
  data() {
    return {
      MemberDto: {
        userId: "",
        password: "",
        memName: "",
      }
    }
  },
}
</script>
