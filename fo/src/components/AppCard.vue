<template>
  <div class="card mt-3">
    <div class="card-header d-flex justify-content-between">
      {{ bible.bibleName }}
      <button class="btn btn-outline-secondary btn-sm" @click="save">저장</button>
    </div>
    <div class="card-body">
      <blockquote class="blockquote mb-0 d-flex flex-wrap gap-2 justify-content-start">
        <div v-for="(bibleCount, index) in readList" :key="bibleCount">
          <button type="button" :class="readCount(bibleCount)"
                  style="--bs-btn-padding-y: .10rem; --bs-btn-padding-x: .15rem; --bs-btn-font-size: .100rem;" @click="bibleCountPlusOrMinus(index, bibleCount)">
            {{ index + 1 }}
            <span v-if="bibleCount != 0" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
              {{ bibleCount }}
    <span class="visually-hidden">unread messages</span>
  </span>
          </button>
        </div>
      </blockquote>
    </div>
  </div>
</template>

<script>


import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: 'AppCard',
  props: {
    bible: Object
  },
  data() {
    return {
      readList: this.bible.readList
    }
  },
  methods: {
    save() {
      if(!confirm('변경사항을 저장하시겠습니까?')) {
        return;
      }
      axios.post(`/api/bible/save/${this.bible.bibleIdx}`, { "readList":this.readList.toString() }, {
        headers : {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(res => {
        console.log(res);
      }).catch(error => {
        console.log(error);
      })
      console.log('save bible');
      console.log(this.bible);
      console.log(this.readList.toString());
    },
    bibleCountPlusOrMinus(index, bibleCount) {
      this.readList[index]++;
      console.log(index, bibleCount);
    },
    readCount(count) {
      if(count == 0) {
        return "btn btn-outline-info position-relative";
      } else {
        return "btn btn-info position-relative";
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
