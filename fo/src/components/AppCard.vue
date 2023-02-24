<template>

  <div class="card mb-3">
    <div class="row g-0">
      <div class="col-md-2">
        <img v-if="book.imgUrl == null" src="https://picsum.photos/250/300/?random" class="img-fluid rounded-start" alt="...">
        <img v-else :src="book.imgUrl" class="img-fluid rounded-start" alt="...">
      </div>
      <div class="col-md">
        <div class="card-body">
          <router-link :to="{path: `/book/${book.bookIdx}`,}" style="text-decoration: none;">
            <h1 class="card-title">{{ book.bookTitle }}</h1>
          </router-link>
          <p class="card-text">{{ book.bookOutline }}</p>
          <div class="d-flex justify-content-end align-items-center gap-3">
            <div class="btn-group gap-3">
            </div>
            <div class="btn-group gap-3 fs-5">
              <span class="badge rounded-pill text-bg-light mr-3">대여 횟수 :
                <span class="badge text-bg-secondary">{{ book.bookReadCount }}</span>
              </span>
              <span class="badge text-bg-light">{{ book.publishedDateTime }}</span>
              <span class="badge text-bg-light"><em class="bi bi-person-fill"></em>저자 : {{ book.author }}</span>
              <span class="badge text-bg-light" v-if="book.borrowOrNot">대여가능</span>
              <span class="badge text-bg-light" v-else>{{ book.memName }} 님이 대여중</span>
            </div>
            <button class="btn btn-primary" v-if="book.borrowOrNot" @click="borrowBook">대여하기</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import VueCookies from "vue-cookies";
import store from "@/script/store";
import router from "@/script/router";

export default {
  name: 'AppCard',
  props: {
    book: Object
  },
  data() {
    return {
      borrowInfoDto: {
        bookIdx: 0,
        memIdx: 0,
        memName: "",
        bookTitle: "",
      }
    }
  },
  methods: {
    makeBorrowInfo() {
      this.borrowInfoDto.bookIdx = this.book.bookIdx;
      this.borrowInfoDto.memIdx = store.state.user.id;
      this.borrowInfoDto.memName = store.state.user.memName;
      this.borrowInfoDto.bookTitle = this.book.bookTitle;
    },
    borrowBook() {
      if(!confirm('대여하시겠습니까?')) {
        return;
      }
      this.makeBorrowInfo();
      axios.post(`/api/borrow`, this.borrowInfoDto, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(res => {
        console.log(res);
        alert('도서를 대여했습니다.');
        router.push(`/:${store.state.user.memName}`);
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
