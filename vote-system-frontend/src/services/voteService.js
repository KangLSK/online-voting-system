import axios from 'axios'

const API_BASE = 'http://localhost:8080/api/votes'

const voteService = {
    getVoteItems: async () => {
        const res = await axios.get(`${API_BASE}/items`);
        return res.data;
    },

    submitVote: (payload) => axios.post(`${API_BASE}/vote`, payload),
    addVoteItem: (name) => axios.post(`${API_BASE}/items`, null, { params: { name } }),
    deleteVoteItem: (id) => axios.delete(`${API_BASE}/items/${id}`)
}

export default voteService