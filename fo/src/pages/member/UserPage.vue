<template>
  <div class="container">
    <div class="d-flex gap-3">
      <div>
        <h1>{{ this.member.memName }}</h1>
      </div>
    </div>
    <table class="table table-hover">
      <thead class="table">
      <tr class="text-center">
        <th style="width: 50%;">제목</th>
        <th>대여일시</th>
        <th>반납일시</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr class="text-center" v-for="borrowInfo in borrowInfoList" :key="borrowInfo">
        <td>
          <router-link :to="{path: `/book/${borrowInfo.bookIdx}`, }" style="text-decoration: none;">{{ borrowInfo.bookTitle }}</router-link>
        </td>
        <td>{{ borrowInfo.borrowedDateTime }}</td>
        <td><p v-if="borrowInfo.returnDateTime != null">{{ borrowInfo.returnDateTime }}</p></td>
        <td>
          <button v-if="borrowInfo.returnOrNot == false" @click="returnBook(borrowInfo.id)" class="btn btn-outline-secondary">반납</button>
          <button v-else class="btn-btn-outline" disabled>반납완료</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "UserPage",
  components: {},
  data() {
    return {
      member: {},
      borrowInfoList: []
    }
  },
  mounted() {
    this.getMember();
  },
  methods: {
    returnBook(borrowInfoId) {
      if(!confirm('도서를 반납하시겠습니까?')) {
        return;
      }
      console.log(borrowInfoId);

      axios.put(`/api/borrow/${borrowInfoId}`, {},  { headers: { "Authorization": VueCookies.get('access_token') }})
          .then(() => {
            alert('반납처리 되었습니다.');
            this.getMember();
          })
          .catch(error => {
            console.log(error);
          });
    },
    getMember() {
      axios.get(`/api/borrow/member/${this.$store.state.user.id}`, {headers: {"Authorization": VueCookies.get("access_token")}})
          .then(({data}) => {
            this.borrowInfoList = data;
          }).catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>
<style scoped>

</style>
