<script setup>

</script>

<template>
  <div>
    <h1>線上投票系統</h1>
    <nav>
      <router-link to="/vote">投票頁面</router-link> |
      <router-link to="/admin">管理頁面</router-link>
    </nav>
    <router-view />
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
}

section {
  margin-bottom: 40px;
}
</style>
