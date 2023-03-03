<template>
  <div class="mx-auto my-auto" style="width: 80%;">
    <div class="mb-3 mt-3">
      <h3>아이디</h3>
      <input class="form-control form-control-lg" type="text" placeholder="ID" id="username"
             aria-label=".form-control-lg example" v-model="this.MemberDto.username" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>비밀번호</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password1"
             aria-label=".form-control-lg example" v-model="this.MemberDto.password1" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>비밀번호 확인</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password2"
             aria-label=".form-control-lg example" v-model="this.MemberDto.password2" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>이름</h3>
      <input class="form-control form-control-lg" type="text" placeholder="계정이름" id="MemberName"
             aria-label=".form-control-lg example" v-model="this.MemberDto.name" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>부서</h3>
      <input class="form-control form-control-lg" type="text" placeholder="부서" id="dept"
             aria-label=".form-control-lg example" v-model="this.MemberDto.deptName" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>성별</h3>
      <div class="d-flex gap-3">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" v-model="this.MemberDto.gender" value="M">
          <label class="form-check-label" for="flexRadioDefault1">
            형제
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"  v-model="this.MemberDto.gender" value="W">
          <label class="form-check-label" for="flexRadioDefault2">
            자매
          </label>
        </div>
      </div>
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-info" @click="join">계정생성</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import router from "@/script/router";

export default {
  name: "AppJoin",
  methods: {
    join() {
      if (this.MemberDto.username.trim().length == 0) {
        alert('아이디를 입력하세요');
        document.getElementById('username').focus();
        return;
      }
      if (this.MemberDto.password1.trim().length == 0) {
        alert('비밀번호를 입력하세요');
        document.getElementById('password1').focus();
        return;
      }
      if (this.MemberDto.password2.trim().length == 0) {
        alert('비밀번호를 입력하세요');
        document.getElementById('password2').focus();
        return;
      }
      if (this.MemberDto.name.trim().length == 0) {
        alert('이름을 입력하세요');
        document.getElementById('MemberName').focus();
        return;
      }
      if (this.MemberDto.deptName.trim().length == 0) {
        alert('부서를 입력하세요');
        document.getElementById('dept').focus();
        return;
      }
      if (this.MemberDto.gender.trim().length == 0) {
        alert('성별을 입력하세요');
        document.getElementById('gender').focus();
        return;
      }
      // let config = {
      //   headers: {
      //     "Authorization": VueCookies.get('access_token')
      //   }
      // }
      console.log(this.MemberDto);
      axios.post(`/api/member`, this.MemberDto)
          .then(() => {
            router.replace({path: '/'});
          }).catch((error) => {
            alert('계정 생성 실패 : ', error);
      });
    }
  },
  data() {
    return {
      MemberDto: {
        username: "",
        password1: "",
        password2: "",
        name: "",
        deptName: "",
        gender: "",
      }
    }
  },
}
</script>
