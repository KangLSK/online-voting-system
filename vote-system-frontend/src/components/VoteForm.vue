<template>
  <div>
    <h2>投票</h2>
    <input v-model="voter" placeholder="請輸入你的名字" />
    <div v-for="item in items" :key="item.id">
      <label>
        <input type="checkbox" :value="item.id" v-model="selectedItemIds" />
        {{ item.name }}
      </label>
    </div>
    <button @click="submitVote">提交投票</button>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import voteService from '../services/voteService'

const items = ref([])
const selectedItemIds = ref([])
const voter = ref('')

onMounted(async () => {
  items.value = await voteService.getVoteItems()
})

const submitVote = async () => {
  if (!voter.value || selectedItemIds.value.length === 0) {
    alert('請輸入名字並選擇至少一個項目')
    return
  }

  await voteService.submitVote({
    voter: voter.value,
    itemIds: selectedItemIds.value
  })

  alert('投票成功！')
  selectedItemIds.value = []
}
</script>