<template>
  <div class="container" style="margin-top: 20%;">
    <div class="mb-3">
      <h3>기존 비밀번호</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password1"
             aria-label=".form-control-lg example" v-model="this.modifyPw.oldPassword" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>새 비밀번호</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password2"
             aria-label=".form-control-lg example" v-model="this.modifyPw.password1" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>비밀번호 확인</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password3"
             aria-label=".form-control-lg example" v-model="this.modifyPw.password2" @keyup.enter="join">
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-info" @click="modifyMemPw">비밀번호 변경</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: 'ModifyMemPw',
  data() {
    return {
      modifyPw: {
        oldPassword: "",
        password1: "",
        password2: ""
      }
    }

  },
  methods: {
    modifyMemPw() {
      if (this.modifyPw.oldPassword.trim().length == 0) {
        alert('기존 비밀번호를 입력하세요');
        document.getElementById('password1').focus();
        return;
      }
      if (this.modifyPw.password1.trim().length == 0) {
        alert('비밀번호를 입력하세요');
        document.getElementById('password2').focus();
        return;
      }
      if (this.modifyPw.password1.trim().length == 0) {
        alert('비밀번호 확인을 입력하세요');
        document.getElementById('password3').focus();
        return;
      }
      if(this.modifyPw.password1.trim() !== this.modifyPw.password2.trim()) {
        alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
        return;
      }
      axios.put(`/api/member/modifyPw`, this.modifyPw, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(() => {
        alert('비밀번호가 변경되었습니다.');
        router.replace({path: `/home`});
      }).catch(error => {
        alert(error.data);
      })
    }
  }
}
</script>
<style scoped>

</style>