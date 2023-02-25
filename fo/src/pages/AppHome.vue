<template>
  <div class="container">
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
  methods: {},
  mounted() {
    let config = {
      headers: {
        "Authorization": VueCookies.get("access_token")
      }
    }
    axios.get(`/api/bible/old`, config).then(({data}) => {
      this.bibleList = data;
    })
        .catch(error => {
          console.log(error);
        });
  }
}
</script>
<style scoped>

</style>
