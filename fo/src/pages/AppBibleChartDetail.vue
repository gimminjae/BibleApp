<template>
  <div class="container" style="margin-top: 20%;">
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link" :class="{active: isOld}" @click="changeVersion" aria-current="page" href="#">구약</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" :class="{active: !isOld}" @click="changeVersion" aria-current="page" href="#">신약</a>
      </li>
    </ul>
    <div v-for="bible in bibleList" :key="bible">
      <AppCard :bible="bible" class="mb-2"></AppCard>
    </div>
  </div>
  <div style="margin-bottom: 25%;"></div>
</template>
<script>
import axios from "axios";
import AppCard from "@/components/AppCard.vue";
import VueCookies from "vue-cookies";

export default {
  name: "AppBibleChartDetail",
  components: {AppCard},
  data() {
    return {
      bibleList: [],
      bibleChartIdx: null,
      version: "old",
      isOld: true,
    }
  },
  methods: {
    changeVersion() {
      this.isOld = !this.isOld;
      if(this.version === "old") {
        this.version = "new";
      } else {
        this.version = "old";
      }
      this.getBible();
    },
    getBible() {
      this.bibleChartIdx = this.$route.params.bibleChartIdx;
      axios.get(`/api/biblechart/${this.bibleChartIdx}?version=${this.version}`, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      })
          .then(({data}) => {
            this.bibleList = data;
          })
          .catch(error => {
            console.log(error);
          });
    }
  }
  ,
  mounted() {
    this.getBible();
  }
}
</script>
<style scoped>

</style>
