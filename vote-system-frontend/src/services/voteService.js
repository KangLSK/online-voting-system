import axios from 'axios'

const API_BASE = 'http://localhost:8080/api/votes'

const voteService = {
    getVoteItems: () => axios.get(`${API_BASE}/items`),
    vote: (payload) => axios.post(`${API_BASE}/vote`, payload),
    addItem: (name) => axios.post(`${API_BASE}/items`, null, { params: { name } }),
    deleteItem: (id) => axios.delete(`${API_BASE}/items/${id}`)
}

export default voteService