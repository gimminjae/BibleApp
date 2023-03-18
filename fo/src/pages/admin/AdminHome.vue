<template>
  <div class="container" style="margin-top: 20%;">
    관리자 홈
    <div class="d-flex justify-content-between" style="white-space: nowrap;">
      <div class="d-flex gap-2">
        <button class="btn btn-outline-secondary">부서1</button>
        <button class="btn btn-outline-secondary">부서2</button>
        <button class="btn btn-outline-secondary">부서3</button>
        <button class="btn btn-outline-secondary">부서4</button>
        <button class="btn btn-outline-secondary" @click="getAllMember">모든 회원</button>
        <button class="btn btn-outline-warning" @click="deptForm">new</button>
      </div>
    </div>
    <div v-if="formBool" class="input-group mb-3">
      <button class="btn btn-outline-info" type="button" @click="createDept" id="button-addon1">생성</button>
      <input type="text" class="form-control" placeholder=""
             aria-label="Example text with button addon" aria-describedby="button-addon1" id="bibleChart" v-model="bibleChartName">
    </div>
    <div>
      <table class="table table-hover text-center">
        <thead>
        <th>이름</th>
        <th>아이디</th>
        <th>부서</th>
        <th>권한</th>
        <th>성별</th>
        <th>옵션</th>
        </thead>
        <tbody>
        <tr v-for="member in memberList" :key="member">
          <td>{{ member.name }}</td>
          <td>{{ member.username }}</td>
          <td>{{ member.deptName }}</td>
          <td>{{ member.role }}</td>
          <td>{{ member.gender }}</td>
          <td>
            <div class="btn-group">
              <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                      aria-expanded="false">
                option
              </button>
              <ul class="dropdown-menu"> <!-- 관리자 메뉴 -->
                <li>
                  <button class="dropdown-item">관리자 권한 부여</button>
                </li>
                <li>
                  <button class="dropdown-item">관리자 권한 제거</button>
                </li>
              </ul>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "AdminHome",
  data() {
    return {
      memberList: [],
      listType: "",
      formBool: false
    }
  },
  methods: {
    getAllMember() {
      this.listType = '모든 회원';
      axios.get(`/api/admin/members/all`, {headers: {"Authorization": VueCookies.get('access_token')}})
          .then(({data}) => {
            this.memberList = data;
          }).catch(error => {
        alert(error.response.data);
      });
    },
    deptForm() {
      this.formBool = !this.formBool;
    },
    createDept() {
      axios.post(`/api/admin/dept`, { headers: { "Authorization": VueCookies.get('access_token')}})
          .then(() => {
            this.getDept();
          }).catch(error => {
            alert(error.response.data);
      });
    },
  }
}
</script>
<style scoped>

</style>