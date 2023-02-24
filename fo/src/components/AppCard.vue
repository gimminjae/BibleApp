<template>
  <div class="card">
    <div class="card-header">
      {{ bible.bibleName }}
    </div>
    <div class="card-body">
      <blockquote class="blockquote mb-0">
        {{ bible.readString }}
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
    }
  },
  methods: {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
