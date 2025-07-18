<template>
  <div>
    <h2>管理投票項目</h2>
    <input v-model="newItemName" placeholder="新增項目名稱" />
    <button @click="addItem">新增</button>
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.name }}
        <button @click="deleteItem(item.id)">刪除</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import voteService from '../services/voteService'

const newItemName = ref('')
const items = ref([])

const fetchItems = async () => {
  items.value = await voteService.getVoteItems()
}

const addItem = async () => {
  if (!newItemName.value) return
  await voteService.addVoteItem(newItemName.value)
  newItemName.value = ''
  await fetchItems()
}

const deleteItem = async (id) => {
  await voteService.deleteVoteItem(id)
  await fetchItems()
}

onMounted(fetchItems)
</script>