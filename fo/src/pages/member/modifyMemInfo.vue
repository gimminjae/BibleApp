<template>
  <div class="container" style="width: 80%; margin-top: 20%;" v-if="member !== null">
    <div class="mb-3">
      <h3>이름</h3>
      <input class="form-control form-control-lg" type="text" placeholder="본인 실명을 사용하세요" id="MemberName"
             aria-label=".form-control-lg example" v-model="this.member.name" @keyup.enter="modify">
    </div>
    <div class="mb-3">
      <h3>부서</h3>
      <input class="form-control form-control-lg" type="text" placeholder="부서" id="dept"
             aria-label=".form-control-lg example" v-model="this.member.deptName" @keyup.enter="modify">
    </div>
    <div class="mb-3">
      <h3>성별</h3>
      <div class="d-flex gap-3">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                 v-model="this.member.gender" value="M">
          <label class="form-check-label" for="flexRadioDefault1">
            형제
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                 v-model="this.member.gender" value="W">
          <label class="form-check-label" for="flexRadioDefault2">
            자매
          </label>
        </div>
      </div>
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-info" @click="modify">회원 정보 수정</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: 'ModifyMemInfo',
  data() {
    return {
      member: null,
    }
  },
  mounted() {
    this.getMember();
  },
  methods: {
    getMember() {
      axios.get(`/api/member`, {headers: {"Authorization": VueCookies.get("access_token")}})
          .then(({data}) => {
            this.member = data;
          }).catch((error) => {
        console.log(error);
      })
    },
    modify() {
      if (this.member.name.trim().length == 0) {
        alert('이름을 입력하세요');
        document.getElementById('MemberName').focus();
        return;
      }
      if (this.member.deptName.trim().length == 0) {
        alert('부서를 입력하세요');
        document.getElementById('dept').focus();
        return;
      }
      if (this.member.gender.trim().length == 0) {
        alert('성별을 입력하세요');
        document.getElementById('gender').focus();
        return;
      }
      axios.put(`/api/member`, this.member, {headers: {"Authorization": VueCookies.get('access_token')}})
          .then(() => {
            alert('회원 정보가 변경되었습니다.');
            router.replace({path: '/home'});
          }).catch(error => {
        alert(error.data);
      })
    }
  }
}
</script>
<style scoped>

</style>