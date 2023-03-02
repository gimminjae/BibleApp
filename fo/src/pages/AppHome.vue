<template>
  <div class="container" style="margin-top: 20%;">
    <div>
      <button class="btn btn-primary" @click="createBibleChart">읽기표 만들기</button>
      <input type="text" placeholder="읽기표 이름" id="bibleChartName" v-model="bibleChartName">
    </div>
    <div>
      <div v-for="bibleChart in bibleChartList" :key="bibleChart">
        <router-link :to="{path: `/bibleChart/${bibleChart.bibleChartIdx}`}">
          <h1>{{ bibleChart.chartName }}</h1>
        </router-link>
      </div>
    </div>
  </div>
  <div style="margin-bottom: 25%;"></div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "AppHome",
  components: {},
  data() {
    return {
      bibleChartList: [],
      bibleChartName: ""
    }
  },
  methods: {
    createBibleChart() {
      if(this.bibleChartName.trim().length == 0) {
        alert('읽기표 이름을 입력하세요');
        document.getElementById('bibleChartName').focus();
        return;
      }
      axios.post(`/api/biblechart`, { chartName: this.bibleChartName }, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      })
          .then(() => {
            this.getBible();
          })
          .catch(error => {
            console.log(error);
          });
    },
    getBible() {
      axios.get(`/api/biblechart/member`, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      })
          .then(({data}) => {
            this.bibleChartList = data;
          })
          .catch(error => {
            console.log(error);
          });
    }
  },
  mounted() {
    this.getBible();
  }
}
</script>
<style scoped>

</style>
