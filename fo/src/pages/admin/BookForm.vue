<template>
  <div class="mx-auto my-auto mt-3" style="width: 50%;">
    <h1>도서 등록</h1>
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon1">제목</span>
      <input type="text" class="form-control" aria-label="Username"
             aria-describedby="basic-addon1" v-model="BookDto.bookTitle" id="bookTitle">
    </div>
    <div class="d-flex gap-2">
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">저자</span>
        <input type="text" class="form-control" aria-label="Username"
               aria-describedby="basic-addon1" v-model="BookDto.author" id="author">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">출판사</span>
        <input type="text" class="form-control" aria-label="Username"
               aria-describedby="basic-addon1" v-model="BookDto.publisher" id="publisher">
      </div>
    </div>
    <div class="d-flex gap-2">
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">출판일</span>
        <input type="text" class="datepicker form-control" aria-label="Username"
               aria-describedby="basic-addon1"  id="datepicker" value="">
      </div>
      <div class="input-group mb-3">
        <input class="form-control" type="file" id="formFile">
      </div>
    </div>
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label">도서 줄거리/내용</label>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" v-model="BookDto.bookOutline"></textarea>
    </div>
    <div class="d-flex justify-content-center my-3">
      <button class="btn btn-primary" style="width: 40%;" @click="submit">도서 등록</button>
    </div>
  </div>
</template>
<script>
import VueCookies from "vue-cookies";
import axios from "axios";
import router from "@/script/router";

export default {
  name: "bookForm",
  components: {},
  mounted() {
  },
  data() {
    return {
      BookDto: {
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
    // dataPicker() {
    //   $('#datepicker').datepicker({
    //     dateFormat: 'yy-mm-dd'
    //   });
    // },
    //글 작성
    submit() {

      if (this.BookDto.bookTitle.trim().length === 0) {
        alert('제목을 입력하세요');
        document.getElementById('title').focus();
        return;
      }
      //유효성 검사
      let config = {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }
      this.BookDto.publishedDate = document.getElementById('publishedDateTime').value;
      document.getElementById('publishedDateTime').value = "";
      axios.post("/api/admin/book", this.BookDto, config)
          .then(() => {
            router.push({path: `/books`});
          })
          .catch((error) => {
            alert('도서 등록 실패 : ' + error);
          });
    }
  }
}
</script>
<style>

</style>
