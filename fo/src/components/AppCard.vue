<template>
  <div class="card mt-3">
    <div class="card-header">
      {{ bible.bibleName }}
    </div>
    <div class="card-body">
      <blockquote class="blockquote mb-0 d-flex flex-wrap gap-2 justify-content-start">
        <div v-for="(bibleCount, index) in readList" :key="bibleCount">
          <button type="button" :class="readCount(bibleCount)"
                  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;" @click="bibleCountPlus(index, bibleCount)">
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
    bibleCountPlus(index, bibleCount) {
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
