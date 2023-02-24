<template>

  <div class="card mb-3">
    <div class="row g-0">
      <div class="col-md-2">
        <img :src="book.image" class="img-fluid rounded-start" alt="...">
      </div>
      <div class="col-md">
        <div class="card-body">
          <h1 class="card-title">{{ book.title }}</h1>
          <p class="card-text">{{ book.description }}</p>
          <div class="d-flex justify-content-end align-items-center gap-3">
            <div class="btn-group gap-3">
            </div>
            <div class="btn-group gap-3 fs-5">
              <span class="badge text-bg-light">출판일 : {{ book.pubdate }}</span>
              <span class="badge text-bg-light"><em class="bi bi-person-fill"></em>저자 : {{ book.author }}</span>
              <span class="badge text-bg-light">출판사 : {{ book.publisher }}</span>
            </div>
            <button class="btn btn-primary" @click="signupBook">등록하기</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: 'AppCard',
  props: {
    book: Object,
  },
  data() {
    return {
      bookDto: {
        bookTitle: "",
        author: "",
        publisher: "",
        publishedDate: "",
        bookOutline: "",
        imgUrl: "",
      }
    }
  },
  methods: {
    bookFromNaver() {
      this.bookDto.bookTitle = this.book.title;
      this.bookDto.author = this.book.author;
      this.bookDto.publisher = this.book.publisher;
      this.bookDto.publishedDate = this.book.pubdate;
      this.bookDto.bookOutline = this.book.description;
      this.bookDto.imgUrl = this.book.image;
    },
    signupBook() {
      if (!confirm('이 책을 등록하시겠습니까?')) {
        return;
      }
      this.bookFromNaver();

      axios.post(`/api/admin/book`, this.bookDto, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(() => {
        alert('등록되었습니다.');
        router.push({path:'/naverbooks'});
      }).catch(error => {
        console.log(error);
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
