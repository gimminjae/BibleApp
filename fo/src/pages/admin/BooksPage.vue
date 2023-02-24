<template>
  <div class="container">
    <h1>도서 정보</h1>
    <div class="d-flex justify-content-end mb-3">
      <router-link to="/signup" class="btn btn-primary">도서 등록</router-link>
    </div>
    <table class="table table-hover text-center">
      <thead>
      <th>도서번호</th>
      <th>도서명</th>
      <th>저자</th>
      <th>출판사</th>
      <th>출판일</th>
      <th>등록일시</th>
      <th>현재 대여자</th>
      <th>대여 횟수</th>
      </thead>
      <tbody>
      <tr v-for="book in bookList" :key="book">
        <td>{{ book.bookIdx }}</td>
        <td><router-link :to="{path: `/book/${book.bookIdx}`}">{{ book.bookTitle }}</router-link></td>
        <td>{{ book.author }}</td>
        <td>{{ book.publisher }}</td>
        <td>{{ book.publishedDate }}</td>
        <td>{{ book.insertDateTime }}</td>
        <td>{{ book.memName }}</td>
        <td>{{ book.bookReadCount }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "BooksPage",
  data() {
    return {
      bookList: []
    }
  },
  mounted() {
    this.getBooks();
  },
  methods: {
    getBooks() {
      axios.get(`/api/book`, { headers: { "Authorization": VueCookies.get("access_token") }})
          .then(res => {
            this.bookList = res.data;
          })
          .catch(error => {
            console.log(error);
          });
    }
  }
}
</script>
<style scoped>

</style>
