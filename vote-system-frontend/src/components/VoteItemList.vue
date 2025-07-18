<template>
  <div>
    <h2>投票項目</h2>
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.name }} - 票數：{{ item.voteCount }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import voteService from '../services/voteService'

const items = ref([])

onMounted(async () => {
  items.value = await voteService.getVoteItems()
})
</script>
