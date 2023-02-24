<template>
  <div>
    <div class="d-flex justify-content-center mt-5">
      <div class="d-flex" style="width: 50%;">
        <input class="form-control me-2" type="search" placeholder="검색어를 입력하세요." aria-label="Search" v-model="keyword"
               @keyup.enter="submit_form()">
        <button class="btn btn-outline-success" type="button" @click="submit_form()">Search</button>
      </div>
    </div>
    <div class="album py-5 bg-light">
      <div class="container">

<!--        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">-->

        <div>
          <div class="col" v-for="book in bookList" :key="book">
            <NaverBook :book="book"></NaverBook>
          </div>

        </div>
      </div>
    </div>

  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";
import NaverBook from "@/components/NaverBook.vue";

export default {
  name: "NaverBooks",
  components: {NaverBook},
  data() {
    return {
      keyword: "",
      bookList: []
    }
  },
  methods: {
    submit_form() {
      axios.get("/api/admin/naver/search/book?keyword=" + this.keyword, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(({data}) => {
        this.bookList = data.items;
      })
          .catch(error => {
            console.log(error);
          })
    }
  },
  mounted() {
  }
}
</script>
<style scoped>

</style>
