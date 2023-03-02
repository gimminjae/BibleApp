<template>
  <div>
    <div class="mb-3">
      <h3>읽기표 이름</h3>
      <input class="form-control form-control-lg" type="text" placeholder="" id="chartName"
             aria-label=".form-control-lg example" v-model="this.BibleChartDto.chartName" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>시작일</h3>
      <input class="form-control form-control-lg" type="text" placeholder="" id="startDateTime"
             aria-label=".form-control-lg example" v-model="this.BibleChartDto.startDateTime" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>종료일</h3>
      <input class="form-control form-control-lg" type="text" placeholder="" id="endDateTime"
             aria-label=".form-control-lg example" v-model="this.BibleChartDto.endDateTime" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>목표</h3>
      <div>
        <h5>구약</h5>
        <input class="form-control form-control-lg" type="text" placeholder="구약 몇독?" id="oldCount"
               aria-label=".form-control-lg example" v-model="this.BibleChartDto.oldCount" @keyup.enter="join">
      </div>
      <div>
        <h5>신약</h5>
        <input class="form-control form-control-lg" type="text" placeholder="신약 몇독?" id="newCount"
               aria-label=".form-control-lg example" v-model="this.BibleChartDto.newCount" @keyup.enter="join">
      </div>
    </div>
    <div class="d-flex justify-content-around mb-3">
      <button style="width: 48%;" type="button" class="btn btn-info" @click="createBibleChart">읽기표 만들기</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "CreateBibleChart",
  components: {},
  data() {
    return {
      BibleChartDto: {
        chartName: "",
        startDateTime: null,
        endDateTime: null,
        oldCount: null,
        newCount: null,
      }
    }
  },
  methods: {
    createBibleChart() {
      if (this.BibleChartDto.chartName.trim().length == 0) {
        alert('이름을 입력하세요');
        document.getElementById('chartName').focus();
        return;
      }
      if (this.BibleChartDto.startDateTime.trim().length == 0) {
        alert('시작일을 입력하세요');
        document.getElementById('startDateTime').focus();
        return;
      }
      if (this.BibleChartDto.endDateTime.trim().length == 0) {
        alert('종료일을 입력하세요');
        document.getElementById('endDateTime').focus();
        return;
      }
      axios.post(`/api/biblechart`, this.BibleChartDto, {
        headers: {
          "Authorization": VueCookies.get('access_token')
        }
      }).then(res => {
        console.log(res);
      }).catch(error => {
        console.log(error);
      })
    }
  }
}
</script>
<style scoped>

</style>