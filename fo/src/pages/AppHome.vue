<template>
  <div class="container" style="margin-top: 20%;">
    <div>
      <div v-if="member !== null" class="d-flex justify-content-between">
        <div>
          <h1 v-if="this.member.gender === 'M'">{{ this.member.name }} 형제님</h1>
          <h1 v-else>{{ this.member.name }} 자매님</h1>
          <h2>{{ this.member.deptName }}부</h2>
        </div>
        <div class="">
          <button class="btn btn-secondary" @click="modifyMyInfo('info')">내 정보 변경</button>
          <button class="btn btn-secondary mx-2" @click="modifyMyInfo('pw')">비밀번호 변경</button>
        </div>
      </div>
      <div class="input-group mb-3">
        <button class="btn btn-outline-info" type="button" @click="createBibleChart" id="button-addon1">읽기표 만들기</button>
        <input type="text" class="form-control" placeholder="나만의 읽기표를 만들어 보세요!"
               aria-label="Example text with button addon" aria-describedby="button-addon1" v-model="bibleChartName">
      </div>
    </div>
    <div>
      <div v-for="bibleChart in bibleChartList" :key="bibleChart" class="mb-3">
        <router-link :to="{path: `/bibleChart/${bibleChart.bibleChartIdx}`}"
                     style="text-decoration: none; color: black;">
          <div class="card">
            <div class="card-header d-flex justify-content-between">
              <div>
                {{ bibleChart.chartName }}
              </div>
              <span class="badge bg-info">
                50%
              </span>
            </div>
            <div class="card-body">
              2020-10-10 ~ 2021-10-10 구약 1독 신약 2독!
            </div>
          </div>
        </router-link>
      </div>
    </div>
  </div>
  <div style="margin-bottom: 25%;"></div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";
import router from "@/script/router";

export default {
  name: "AppHome",
  components: {},
  data() {
    return {
      bibleChartList: [],
      bibleChartName: "",
      member: null
    }
  },
  methods: {
    modifyMyInfo(type) {
      if(type === 'info') {
        router.push({path:`/modify/memberInfo`})
      } else if(type === 'pw') {
        router.push({path:`/modify/memberPw`})
      }
    },
    getMember() {
      axios.get(`/api/member`, {headers: {"Authorization": VueCookies.get("access_token")}})
          .then(({data}) => {
            this.member = data;
          }).catch((error) => {
        console.log(error);
      })
    },
    createBibleChart() {
      if (this.bibleChartName.trim().length == 0) {
        alert('읽기표 이름을 입력하세요');
        document.getElementById('bibleChartName').focus();
        return;
      }
      axios.post(`/api/biblechart`, {chartName: this.bibleChartName}, {
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
    this.getMember();
  }
}
</script>
<style scoped>

</style>
