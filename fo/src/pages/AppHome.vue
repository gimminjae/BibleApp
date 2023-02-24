<template>
  <div>
    <div class="d-flex justify-content-center mt-5">
      <div class="d-flex" style="width: 50%;">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" v-model="keyword"
               @keyup.enter="submit_form()">
        <button class="btn btn-outline-success" type="button" @click="submit_form()">Search</button>
      </div>
    </div>
    <div class="album py-5 bg-light">
      <div class="container">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

          <div class="col" v-for="book in bookList" :key="book">
            <AppCard :book="book"></AppCard>
          </div>

        </div>
      </div>
    </div>

  </div>
</template>
<script>
import axios from "axios";
import AppCard from "@/components/AppCard.vue";
import VueCookies from "vue-cookies";

export default {
  name: "AppHome",
  components: {AppCard},
  data() {
    return {
      keyword: "",
      bookList: []
    }
  },
  methods: {
    submit_form() {
      axios.get("/api/book?keyword=" + this.keyword).then(({data}) => {
        this.bookList = data;
      })
          .catch(error => {
            console.log(error);
          })
    }
  },
  mounted() {
    let config = {
      headers: {
        "Authorization": VueCookies.get("access_token")
      }
    }
    axios.get("/api/book", config).then(({data}) => {
      this.bookList = data;
    })
        .catch(error => {
          console.log(error);
        });
  }
}
</script>
<style scoped>

</style>
