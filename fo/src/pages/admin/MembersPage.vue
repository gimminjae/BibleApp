<template>
  <div class="container">
    <h1>회원 정보</h1>
    <div class="d-flex justify-content-end mb-3">
      <router-link to="/join" class="btn btn-primary">계정 생성</router-link>
    </div>
    <table class="table table-hover text-center">
      <thead>
      <th>회원번호</th>
      <th>이름</th>
      <th>아이디</th>
      <th>생성일시</th>
      <th>대여한 도서</th>
      </thead>
      <tbody>
      <tr v-for="member in members" :key="member">
        <td>{{ member.memIdx }}</td>
        <td>{{ member.memName }}</td>
        <td>{{ member.userId }}</td>
        <td>{{ member.signUpDateTime }}</td>
        <td>{{ member.borrowedNum }} 권</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "MembersPage",
  data() {
    return {
      members: []
    }
  },
  mounted() {
    this.getMembers();
  },
  methods: {
    getMembers() {
      let config = {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      };
      axios.get(`/api/admin/member`, config)
          .then(res => {
            this.members = res.data;
          })
          .catch(error => {
            // alert(error.response.data);
            console.log(error);
          });
    }
  }
}
</script>
<style scoped>

</style>
