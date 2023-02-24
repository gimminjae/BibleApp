<template>
  <div class="container" style="width: 80%;">
    <div class="d-flex justify-content-between my-3">
      <h1>{{ book.bookTitle }}</h1>
      <div class="d-flex gap-3">
        <router-link :to="{path: `/modify/${this.bookIdx}`}" class="">수정</router-link>
      </div>
    </div>
    <div>
      <p>{{ book}}</p>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import router from "@/script/router";
import VueCookies from "vue-cookies";

export default {
  name: "bookDetail",
  data() {
    return {
      book: {},
      bookId: 0
    }
  },
  mounted() {
    this.bookId = this.$route.params.id;
    this.getBook();
  },
  methods: {
    getBook() {
      let config = {
        headers: {
          "Authorization": VueCookies.get("access_token")
        }
      }
      axios.get(`/api/book/${this.bookId}`, config)
          .then(({data}) => {
            this.book = data;
          }).catch((error) => {
        alert(error.response.data);
        router.push({path: `/`});
      })
    },
  }
}
</script>
<style scoped>

</style>
