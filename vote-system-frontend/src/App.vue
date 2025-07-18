<script setup>
import VoteForm from './components/VoteForm.vue'
import VoteItemList from './components/VoteItemList.vue'
import VoteAdminPanel from './components/VoteAdminPanel.vue'
</script>

<template>
  <div class="container">
    <h1>線上投票系統</h1>

    <!-- 投票表單 -->
    <section>
      <VoteForm />
    </section>

    <!-- 投票項目列表與票數 -->
    <section>
      <VoteItemList />
    </section>

    <!-- 管理員面板 -->
    <section>
      <VoteAdminPanel />
    </section>
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
