<template>
  <div class="container" style="margin-top: 20%;">
    <div class="d-flex justify-content-between">
      <div>
        목표 & 달성
      </div>
      <div class="d-flex gap-2">
        <button class="btn btn-warning" @click="setGoal">목표 설정</button>
        <button class="btn btn-light" @click="removeBibleChart">삭제</button>
      </div>
    </div>
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link" :class="{active: isOld}" @click="changeVersion('old')" aria-current="page" href="#">구약</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" :class="{active: !isOld}" @click="changeVersion('new')" aria-current="page" href="#">신약</a>
      </li>
    </ul>
    <div v-for="bible in bibleList" :key="bible">
      <AppCard :bible="bible" @AppCardChild="getBible" @refreshBible="getBible" class="mb-2"></AppCard>
    </div>
  </div>
  <div style="margin-bottom: 25%;"></div>
</template>
<script>
import axios from "axios";
import AppCard from "@/components/AppCard.vue";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: "AppBibleChartDetail",
  components: {AppCard},
  data() {
    return {
      bibleChart: null,
      bibleList: [],
      bibleChartIdx: null,
      version: "old",
      isOld: true,
      isGoal: true,
      bible: null
    }
  },
  methods: {
    removeBibleChart() {
      if(!confirm('삭제하시겠습니까?')) {
        return;
      }
      axios.delete(`/api/biblechart/${this.bibleChartIdx}`, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(() => {
        alert('삭제되었습니다.');
        router.replace('/home');
      }).catch(error => {
        alert(error.response.data);
      })
    },
    setGoal() {
      router.push({path:`/setGoal`})
    },
    changeVersion(version) {
      if(version === "old") {
        this.isOld = true;
      } else {
        this.isOld = false;
      }
      this.version = version;
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
