<template>
  <div class="container" style="margin-top: 20%;">
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
  name: "AppHome",
  components: {AppCard},
  data() {
    return {
      bibleList: []
    }
  },
  methods: {
    getBible() {
      axios.get(`/api/bible/old`, {
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
  },
  mounted() {
    this.getBible();
  }
}
</script>
<style scoped>

</style>
