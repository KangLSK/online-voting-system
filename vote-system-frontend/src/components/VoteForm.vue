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
  const res = await voteService.getVoteItems()
  console.log('取得的 items：', res.data)
  items.value = res
})


const submitVote = async () => {
  if (!voter.value || selectedItemIds.value.length === 0) {
    alert('請輸入名字並選擇至少一個項目')
    return
  }

  const payload = {
    voter: voter.value,
    itemIds: selectedItemIds.value
  }

  console.log("提交的 payload：", payload)

  try {
    await voteService.submitVote(payload)
    alert('投票成功！')
    selectedItemIds.value = []
    location.reload()
  } catch (err) {
    console.error("投票發生錯誤：", err)
    alert('投票失敗，請稍後再試')
  }
}
</script>
