<template>
  <div class="card mt-3">
    <div class="card-header d-flex justify-content-between" @click="showBool = !showBool">
      {{ bible.bibleName }}
      <span class="badge text-bg-success" v-if="!showBool && bible.readPercent > 0"> {{ bible.readPercent }} %</span>
      <div class="d-flex gap-1" v-if="showBool">
        <button class="btn btn-outline-secondary btn-sm" @click="save">저장</button>
        <button class="btn btn-outline-secondary btn-sm" @click="back">되돌리기</button>
      </div>
    </div>
    <div class="card-body" v-if="showBool">
      <blockquote class="blockquote mb-0 d-flex flex-wrap gap-2 justify-content-start">
        <div v-for="(bibleCount, index) in readList" :key="bibleCount">
          <button type="button" :class="readCount(bibleCount)"
                  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .100rem;"
                  @click="bibleCountPlusOrMinus(index)">
            {{ index + 1 }}
            <span v-if="bibleCount !== 0"
                  class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
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
      showBool: false,
      readList: this.bible.readList
    }
  },
  methods: {
    back(e) {
      this.$emit('AppCardChild', e.target.value)
    },
    setBible(newBible) {
      this.$props.bible.readPercent = newBible.readPercent;
    },
    save() {
      if (!confirm('변경사항을 저장하시겠습니까?')) {
        return;
      }
      let config = {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      };
      axios.post(`/api/bible/save/${this.bible.bibleIdx}`, {"readList": this.readList.toString()}, config)
          .then(() => {
            axios.get(`/api/bible/single/${this.bible.bibleIdx}`, config)
                .then(({data}) => {
                  this.setBible(data);
                  this.readList = data.readList;
                  this.showBool = true;
                })
          }).catch(error => {
        console.log(error);
      })
    },
    bibleCountPlusOrMinus(index) {
      this.readList[index]++;
    },
    readCount(count) {
      if (count === 0) {
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
#staticBackdrop {
  position: fixed;
}
</style>
