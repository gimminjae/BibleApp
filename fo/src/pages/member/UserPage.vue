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
        <th style="width: 70%;">제목</th>
        <th>대여일시</th>
        <th>반납일시</th>
      </tr>
      </thead>
      <tbody>
      <tr class="text-center" v-for="book in bookList" :key="book">
        <td><router-link :to="{path: `/book/${book.bookIdx}`, }">{{ book.bookTitle }}</router-link></td>
        <td>대여일시</td>
        <td>반납일시</td>
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
      bookList: []
    }
  },
  mounted() {
    this.getMember();
  },
  methods: {
    getMember() {
      axios.get(`/api/member/${VueCookies.get("nickname")}`)
          .then(({data}) => {
            this.member = data.member;
            this.bookList = data.bookList;
          }).catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>
<style scoped>

</style>
