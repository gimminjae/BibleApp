<template>

  <div class="card shadow-sm">
    <svg class="bd-placeholder-img card-img-top" width="50%" height="225" xmlns="http://www.w3.org/2000/svg" role="img"
         aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>
      Placeholder</title>
      <rect width="100%" height="100%" fill="#55595c"/>
      <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
    </svg>

    <router-link :to="{
      path: `/book/${book.bookIdx}`,
    }">
      <div class="card-body">
        <div clsss="d-flex justify-content-between">
          <div class="mb-3">
            <h4 class="card-text">{{ book.bookTitle }}</h4>
          </div>
        </div>
        <div class="d-flex justify-content-between align-items-center">
          <div class="btn-group gap-3">
            <span class="badge rounded-pill text-bg-light mr-3">
              <span class="badge text-bg-secondary">{{ book.readCount }}</span>
            </span>
          </div>
          <div class="btn-group gap-3">
            <span class="badge text-bg-light">{{ book.publishedDateTime }}</span>
            <span class="badge text-bg-light"><em class="bi bi-person-fill"></em>저자 : {{ book.author }}</span>
            <span class="badge text-bg-light" v-if="book.borrowOrNot">대여가능</span>
            <span class="badge text-bg-light" v-else>대여중</span>
            <span class="badge text-bg-light" v-if="!book.borrowOrNot"><em class="bi bi-person-fill"></em>{{ book.memName }}</span>
          </div>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>

export default {
  name: 'AppCard',
  props: {
    book: Object
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
