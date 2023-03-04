<template>
  <div class="container" style="margin-top: 20%;">
    <div class="mb-3">
      <h3>기존 비밀번호</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password1"
             aria-label=".form-control-lg example" v-model="this.joinDto.oldPassword" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>새 비밀번호</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password2"
             aria-label=".form-control-lg example" v-model="this.joinDto.password1" @keyup.enter="join">
    </div>
    <div class="mb-3">
      <h3>비밀번호 확인</h3>
      <input class="form-control form-control-lg" type="password" placeholder="password" id="password3"
             aria-label=".form-control-lg example" v-model="this.joinDto.password2" @keyup.enter="join">
    </div>
  </div>
</template>
<script>
export default {
  name: 'ModifyMemPw',
  methods: {

  }
}
</script>
<style scoped>

</style>