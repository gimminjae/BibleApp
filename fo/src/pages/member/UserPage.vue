<template>
  <div class="container" style="margin-top: 20%;">
    {{$store.state.user}}
    <h1 v-if="this.member.gender === 'M'">{{ this.member.name }} 형제님</h1>
    <h1 v-else>{{ this.member.name }} 자매님</h1>
    <h2>{{ this.member.deptName }}부</h2>
    {{this.member}}
  </div>
</template>
<script>
import axios from "axios";
import VueCookies from "vue-cookies";

export default {
  name: "UserPage",
  components: {},
  data() {
    return {
      member: {},
    }
  },
  mounted() {
    this.getMember();
  },
  methods: {
    getMember() {
      axios.get(`/api/member`, {headers: {"Authorization": VueCookies.get("access_token")}})
          .then(({data}) => {
            this.member = data;
          }).catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>
<style scoped>

</style>
